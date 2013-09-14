package com.izeye.playground.support.csv.service;

import java.util.Arrays;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@ActiveProfiles("dev")
public class CsvParserTest {

	@Resource
	private CsvParser csvParser;

	@Test
	public void parse() {
		String csv = "2002,1,2002.12.07,0,0,1,\"143,934,100\",28,\"5,140,500\",\"2,537\",\"113,400\",\"40,155\",\"10,000\",10,23,29,33,37,40,16";
		String[] parsedCsv = csvParser.parse(csv);
		System.out.println(Arrays.asList(parsedCsv));

		csv = ",2,2002.12.14,1,\"2,002,006,800\",2,\"94,866,800\",103,\"1,842,000\",\"3,763\",\"100,800\",\"55,480\",\"10,000\",9,13,21,25,32,42,2";
		parsedCsv = csvParser.parse(csv);
		System.out.println(Arrays.asList(parsedCsv));
	}

}
