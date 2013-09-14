package com.izeye.playground.support.lotto.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.izeye.playground.support.lotto.service.KoreanLottoWinningLogMigrationService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class KoreanLottoWinningLogMigrationServiceTest {

	@Resource
	private KoreanLottoWinningLogMigrationService winningLogMigrationService;

	@Test
	public void file2db() {
		winningLogMigrationService.file2db();
	}

}
