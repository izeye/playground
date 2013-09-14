package com.izeye.playground.support.lotto.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import com.izeye.playground.common.util.StringUtils;
import com.izeye.playground.support.csv.service.CsvParser;
import com.izeye.playground.support.lotto.dao.KoreanLottoDao;
import com.izeye.playground.support.lotto.domain.KoreanLottoWinningLog;

@Service("koreanLottoWinning")
public class DefaultKoreanLottoWinningLogMigrationService implements
		KoreanLottoWinningLogMigrationService {

	@Resource
	private CsvParser csvParser;

	@Resource
	private KoreanLottoDao koreanLottoDao;

	private static final int INDEX_SEQUENCE = 1;
	private static final int INDEX_DRAWING_DAY = 2;
	private static final int INDEX_PRIZE_1 = 4;
	private static final int INDEX_PRIZE_2 = 6;
	private static final int INDEX_PRIZE_3 = 8;
	private static final int INDEX_PRIZE_4 = 10;
	private static final int INDEX_PRIZE_5 = 12;

	@Override
	public void file2db() {
		BufferedReader br = null;
		try {
			File file = ResourceUtils
					.getFile("classpath:data/lotto/korean_lotto_winning_logs.csv");
			br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String[] csv = csvParser.parse(line);
				int sequence = Integer.parseInt(csv[INDEX_SEQUENCE]);
				String day = csv[INDEX_DRAWING_DAY].replace(".", "-");
				String numbers = StringUtils.join(
						Arrays.copyOfRange(csv, 13, csv.length), ",");
				long prize1 = Long.parseLong(csv[INDEX_PRIZE_1]
						.replace(",", ""));
				long prize2 = Long.parseLong(csv[INDEX_PRIZE_2]
						.replace(",", ""));
				long prize3 = Long.parseLong(csv[INDEX_PRIZE_3]
						.replace(",", ""));
				long prize4 = Long.parseLong(csv[INDEX_PRIZE_4]
						.replace(",", ""));
				long prize5 = Long.parseLong(csv[INDEX_PRIZE_5]
						.replace(",", ""));
				KoreanLottoWinningLog winningLog = new KoreanLottoWinningLog(
						sequence, day, numbers, prize1, prize2, prize3, prize4,
						prize5);
				koreanLottoDao.insert(winningLog);
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

}
