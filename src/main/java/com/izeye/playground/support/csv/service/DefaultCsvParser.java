package com.izeye.playground.support.csv.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVParser;

@Service("csvParser")
public class DefaultCsvParser implements CsvParser {

	@Override
	public String[] parse(String csv) {
		CSVParser csvParser = new CSVParser();
		try {
			return csvParser.parseLine(csv);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
