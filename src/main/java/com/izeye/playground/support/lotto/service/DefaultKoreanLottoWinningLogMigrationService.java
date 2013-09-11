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
				int sequence = Integer.parseInt(csv[1]);
				String day = csv[2].replace(".", "-");
				String numbers = StringUtils.join(
						Arrays.copyOfRange(csv, 13, csv.length), ",");
				KoreanLottoWinningLog winningLog = new KoreanLottoWinningLog(
						sequence, day, numbers);
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
