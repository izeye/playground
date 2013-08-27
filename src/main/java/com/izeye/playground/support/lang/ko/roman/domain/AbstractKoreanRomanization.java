package com.izeye.playground.support.lang.ko.roman.domain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import com.izeye.playground.common.util.StringUtils;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhoneme;
import com.izeye.playground.support.lang.ko.phoneme.domain.KoreanPhonemeType;
import com.izeye.playground.support.lang.ko.phoneme.service.KoreanPhonemeService;

public class AbstractKoreanRomanization implements KoreanRomanization {

	private static final String NULL = "-";
	private static final String EMPTY = "";

	private Map<KoreanPhoneme, String> koreanPhoneme2RomanMap;
	private Map<String, Set<KoreanPhoneme>> roman2PossibleKoreanPhonemeSetMap;

	private Set<String> romanVowelSet;

	private Map<KoreanPhoneme, Map<KoreanPhoneme, String>> transliteration2TranscriptionMap;
	private Map<String, Set<String>> transcription2PossibleTransliterationSetMap;

	@Resource
	private KoreanPhonemeService koreanPhonemeService;

	private final Logger log = LoggerFactory.getLogger(getClass());

	public AbstractKoreanRomanization(KoreanRomanizationScheme scheme) {
		loadRomanizationTransliterationRules(scheme);
		loadRomanizationTranscriptionRules(scheme);
	}

	private File getRomanizationTransliterationRuleFile(
			KoreanRomanizationScheme scheme, RomanizationType type) {
		try {
			return ResourceUtils
					.getFile("classpath:data/language/korean/romanization/"
							+ scheme.name().toLowerCase() + "."
							+ type.name().toLowerCase() + ".rules");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	private void loadRomanizationTransliterationRules(
			KoreanRomanizationScheme scheme) {
		File schemeFile = getRomanizationTransliterationRuleFile(scheme,
				RomanizationType.TRANSLITERATION);

		koreanPhoneme2RomanMap = new HashMap<KoreanPhoneme, String>();
		roman2PossibleKoreanPhonemeSetMap = new HashMap<String, Set<KoreanPhoneme>>();

		romanVowelSet = new HashSet<String>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(schemeFile));
			String line;
			while ((line = br.readLine()) != null) {
				String[] splitLine = line.split(" ");
				char koreanPhonemeValue = splitLine[0].charAt(0);
				String romanValue = splitLine[1];
				KoreanPhonemeType koreanPhonemeType = KoreanPhonemeType
						.valueOf(splitLine[2]);

				if (koreanPhonemeType == KoreanPhonemeType.MEDIAL_JAMO) {
					romanVowelSet.add(romanValue);
				}

				KoreanPhoneme koreanPhoneme = new KoreanPhoneme(
						koreanPhonemeType, koreanPhonemeValue);
				if (romanValue.equals(NULL)) {
					if (koreanPhonemeType == KoreanPhonemeType.INITIAL_JAMO) {
						koreanPhoneme2RomanMap.put(koreanPhoneme, EMPTY);
					} else {
						// Ignore.
					}
				} else {
					koreanPhoneme2RomanMap.put(koreanPhoneme, romanValue);

					Set<KoreanPhoneme> possibleKoreanPhonemeSet = roman2PossibleKoreanPhonemeSetMap
							.get(romanValue);
					if (possibleKoreanPhonemeSet == null) {
						possibleKoreanPhonemeSet = new HashSet<KoreanPhoneme>();
						roman2PossibleKoreanPhonemeSetMap.put(romanValue,
								possibleKoreanPhonemeSet);
					}
					possibleKoreanPhonemeSet.add(koreanPhoneme);
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void loadRomanizationTranscriptionRules(
			KoreanRomanizationScheme scheme) {
		File schemeFile = getRomanizationTransliterationRuleFile(scheme,
				RomanizationType.TRANSCRIPTION);

		transliteration2TranscriptionMap = new HashMap<KoreanPhoneme, Map<KoreanPhoneme, String>>();
		transcription2PossibleTransliterationSetMap = new HashMap<String, Set<String>>();

		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(schemeFile));
			String line = br.readLine();
			if (line == null) {
				return;
			}
			String[] splitLine = line.split("\t");
			List<String> nextInitialPhonemes = Arrays.asList(splitLine);
			nextInitialPhonemes = nextInitialPhonemes.subList(2,
					nextInitialPhonemes.size());

			line = br.readLine();
			splitLine = line.split("\t");
			List<String> nextInitialRomans = Arrays.asList(splitLine);
			nextInitialRomans = nextInitialRomans.subList(2,
					nextInitialRomans.size());
			while ((line = br.readLine()) != null) {
				splitLine = line.split("\t");
				KoreanPhoneme previousEndingPhoneme = new KoreanPhoneme(
						KoreanPhonemeType.FINAL_JAMO, splitLine[0].charAt(0));
				String previousEndingRoman = splitLine[1];
				for (int i = 0; i < nextInitialPhonemes.size(); i++) {
					KoreanPhoneme nextInitialPhoneme = new KoreanPhoneme(
							KoreanPhonemeType.INITIAL_JAMO, nextInitialPhonemes
									.get(i).charAt(0));
					String nextInitialRoman = nextInitialRomans.get(i);
					if (nextInitialRoman.equals(NULL)) {
						nextInitialRoman = EMPTY;
					}

					String[] transcriptions = splitLine[i + 2].split(",");

					Map<KoreanPhoneme, String> nextInitialAndTranscriptionMap = transliteration2TranscriptionMap
							.get(previousEndingPhoneme);
					if (nextInitialAndTranscriptionMap == null) {
						nextInitialAndTranscriptionMap = new HashMap<KoreanPhoneme, String>();
						transliteration2TranscriptionMap.put(
								previousEndingPhoneme,
								nextInitialAndTranscriptionMap);
					}

					// NOTE:
					// Use the first transcription.
					nextInitialAndTranscriptionMap.put(nextInitialPhoneme,
							transcriptions[0]);

					for (String transcription : transcriptions) {
						Set<String> transliterationSet = transcription2PossibleTransliterationSetMap
								.get(transcription);
						if (transliterationSet == null) {
							transliterationSet = new HashSet<String>();
							transcription2PossibleTransliterationSetMap.put(
									transcription, transliterationSet);
						}
						transliterationSet.add(previousEndingRoman
								+ nextInitialRoman);
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String koreanPhoneme2Roman(KoreanPhoneme koreanPhoneme) {
		if (koreanPhoneme.getType() == KoreanPhonemeType.NO_JAMO) {
			return koreanPhoneme.getValue().toString();
		}
		return koreanPhoneme2RomanMap.get(koreanPhoneme);
	}

	@Override
	public Set<KoreanPhoneme> roman2PossibleKoreanPhonemeSet(String roman) {
		return roman2PossibleKoreanPhonemeSetMap.get(roman);
	}

	@Override
	public String korean2Roman(RomanizationType type, String korean) {
		StringBuilder sb = new StringBuilder();
		List<KoreanPhoneme> koreanPhonemes = koreanPhonemeService
				.decompose(korean);

		switch (type) {
		case TRANSLITERATION:
			for (KoreanPhoneme koreanPhoneme : koreanPhonemes) {
				sb.append(koreanPhoneme2Roman(koreanPhoneme));
			}
			break;

		case TRANSCRIPTION:
			int koreanPhonemeSize = koreanPhonemes.size();
			String transcription = null;
			for (int i = 0; i < koreanPhonemeSize; i++) {
				KoreanPhoneme previousEndingCandidate = koreanPhonemes.get(i);
				if (previousEndingCandidate.getType() == KoreanPhonemeType.FINAL_JAMO
						&& i + 1 < koreanPhonemeSize) {
					KoreanPhoneme nextInitialCandidate = koreanPhonemes
							.get(i + 1);
					if (nextInitialCandidate.getType() == KoreanPhonemeType.INITIAL_JAMO) {
						Map<KoreanPhoneme, String> previousEndingAndTranscriptionMap = transliteration2TranscriptionMap
								.get(previousEndingCandidate);
						if (previousEndingAndTranscriptionMap != null) {
							transcription = previousEndingAndTranscriptionMap
									.get(nextInitialCandidate);
							if (transcription != null) {
								i++;
							}
						}
					}
				}
				if (transcription != null) {
					sb.append(transcription);
					transcription = null;
				} else {
					sb.append(koreanPhoneme2Roman(previousEndingCandidate));
				}
			}
			break;

		default:
			throw new IllegalArgumentException("Unsupported romanization type.");
		}

		return sb.toString();
	}

	@Override
	public Set<String> roman2PossibleKoreanSet(RomanizationType type,
			String roman) {
		return roman2PossibleKoreanSet(type, roman, true);
	}

	@Override
	public Set<String> roman2PossibleKoreanSet(RomanizationType type,
			String roman, boolean filtered) {
		switch (type) {
		case TRANSLITERATION:
			List<List<KoreanPhoneme>> possibleKoreans = new ArrayList<List<KoreanPhoneme>>();
			possibleKoreans.add(new ArrayList<KoreanPhoneme>());

			int cursor = 0;
			int romanLength = roman.length();
			while (cursor < romanLength) {
				char firstRomanCandidate = roman.charAt(cursor);
				if (!Character.isLetter(firstRomanCandidate)) {
					for (List<KoreanPhoneme> possibleKorean : possibleKoreans) {
						possibleKorean
								.add(new KoreanPhoneme(
										KoreanPhonemeType.NO_JAMO,
										firstRomanCandidate));
					}
					cursor++;
					continue;
				}

				if (cursor + 2 < romanLength) {
					StringBuilder sbRomanPhonemeCandidate = new StringBuilder();
					sbRomanPhonemeCandidate.append(firstRomanCandidate);
					sbRomanPhonemeCandidate.append(roman.charAt(cursor + 1));
					sbRomanPhonemeCandidate.append(roman.charAt(cursor + 2));
					String romanPhonemeCandidate = sbRomanPhonemeCandidate
							.toString();
					Set<KoreanPhoneme> possibleKoreanPhonemeSet = roman2PossibleKoreanPhonemeSet(romanPhonemeCandidate);
					if (possibleKoreanPhonemeSet != null) {
						makePossibleKoreansFromPhonemeSet(possibleKoreans,
								possibleKoreanPhonemeSet);
						cursor += 3;
						continue;
					}
				}

				if (cursor + 1 < romanLength) {
					StringBuilder sbRomanPhonemeCandidate = new StringBuilder();
					sbRomanPhonemeCandidate.append(firstRomanCandidate);
					sbRomanPhonemeCandidate.append(roman.charAt(cursor + 1));
					String romanPhonemeCandidate = sbRomanPhonemeCandidate
							.toString();
					Set<KoreanPhoneme> possibleKoreanPhonemeSet = roman2PossibleKoreanPhonemeSet(romanPhonemeCandidate);
					if (possibleKoreanPhonemeSet != null) {
						makePossibleKoreansFromPhonemeSet(possibleKoreans,
								possibleKoreanPhonemeSet);
						cursor += 2;
						continue;
					}
				}

				String romanPhonemeCandidate = String
						.valueOf(firstRomanCandidate);
				Set<KoreanPhoneme> possibleKoreanPhonemeSet = roman2PossibleKoreanPhonemeSet(romanPhonemeCandidate);
				if (possibleKoreanPhonemeSet != null) {
					makePossibleKoreansFromPhonemeSet(possibleKoreans,
							possibleKoreanPhonemeSet);
					cursor++;
					continue;
				}

				throw new RomanizationFailureException("Unsupported roman at "
						+ cursor + ": " + roman);
			}

			Set<String> possibleKoreanSet = new HashSet<String>();
			for (List<KoreanPhoneme> possibleKorean : possibleKoreans) {
				if ((filtered && filter(possibleKorean)) || !filtered) {
					possibleKoreanSet.add(koreanPhonemeService
							.composePhonemesLoosely(possibleKorean));
				}
			}
			return possibleKoreanSet;

		case TRANSCRIPTION:
			Set<String> possibleRomanSet = new HashSet<String>();
			possibleRomanSet.add(roman);
			for (Map.Entry<String, Set<String>> transcription2PossibleTransliterationSet : transcription2PossibleTransliterationSetMap
					.entrySet()) {
				String transcription = transcription2PossibleTransliterationSet
						.getKey();
				Set<String> possibleTransliterationSet = transcription2PossibleTransliterationSet
						.getValue();
				Set<String> additionalPossibleRomanSet = new HashSet<String>();
				for (String possibleRoman : possibleRomanSet) {
					if (possibleRoman.contains(transcription)) {
						for (String possibleTransliteration : possibleTransliterationSet) {
							additionalPossibleRomanSet.add(StringUtils
									.replaceAll(possibleRoman, romanVowelSet,
											romanVowelSet, transcription,
											possibleTransliteration));
						}
					}
				}
				possibleRomanSet.addAll(additionalPossibleRomanSet);
			}

			possibleKoreanSet = new HashSet<String>();
			for (String possibleRoman : possibleRomanSet) {
				try {
					possibleKoreanSet.addAll(roman2PossibleKoreanSet(
							RomanizationType.TRANSLITERATION, possibleRoman,
							filtered));
				} catch (RomanizationFailureException e) {
					// Just ignore.
					log.debug("Failed to revert to Korean: " + e);
				}
			}
			return possibleKoreanSet;

		default:
			throw new IllegalArgumentException(
					"Unsupported romanization type: " + type);
		}
	}

	private void makePossibleKoreansFromPhonemeSet(
			List<List<KoreanPhoneme>> possibleKoreans,
			Set<KoreanPhoneme> possibleKoreanPhonemeSet) {
		List<List<KoreanPhoneme>> originalPossibleKoreans = new ArrayList<List<KoreanPhoneme>>();
		for (List<KoreanPhoneme> possibleKorean : possibleKoreans) {
			originalPossibleKoreans.add(new ArrayList<KoreanPhoneme>(
					possibleKorean));
		}

		Iterator<KoreanPhoneme> phonemeIt = possibleKoreanPhonemeSet.iterator();
		KoreanPhoneme phoneme = phonemeIt.next();
		for (List<KoreanPhoneme> possibleKorean : possibleKoreans) {
			possibleKorean.add(phoneme);
		}

		while (phonemeIt.hasNext()) {
			List<List<KoreanPhoneme>> copiedPossibleKoreans = new ArrayList<List<KoreanPhoneme>>();
			for (List<KoreanPhoneme> originalPossibleKorean : originalPossibleKoreans) {
				copiedPossibleKoreans.add(new ArrayList<KoreanPhoneme>(
						originalPossibleKorean));
			}
			phoneme = phonemeIt.next();
			for (List<KoreanPhoneme> copiedPossibleKorean : copiedPossibleKoreans) {
				copiedPossibleKorean.add(phoneme);
			}

			possibleKoreans.addAll(copiedPossibleKoreans);
		}
	}

	private boolean filter(List<KoreanPhoneme> koreanPhonemes) {
		KoreanPhoneme prevPhoneme = null;
		for (KoreanPhoneme koreanPhoneme : koreanPhonemes) {
			KoreanPhonemeType koreanPhonemeType = koreanPhoneme.getType();
			if (prevPhoneme == null) {
				if (koreanPhonemeType == KoreanPhonemeType.FINAL_JAMO) {
					return false;
				}
			} else {
				switch (prevPhoneme.getType()) {
				case INITIAL_JAMO:
					if (koreanPhonemeType != KoreanPhonemeType.MEDIAL_JAMO) {
						return false;
					}
					break;

				case MEDIAL_JAMO:
					break;

				case FINAL_JAMO:
				case NO_JAMO:
					if (koreanPhonemeType == KoreanPhonemeType.FINAL_JAMO) {
						return false;
					}
					break;

				default:
					break;
				}
			}
			prevPhoneme = koreanPhoneme;
		}
		return true;
	}

}
