package com.izeye.playground.support.csv.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import au.com.bytecode.opencsv.CSVParser;

@Service("csvParser")
public class DefaultCsvParser implements CsvParser {

	private ThreadLocal<CSVParser> csvParser = new ThreadLocal<CSVParser>() {
		protected CSVParser initialValue() {
			return new CSVParser();
		}
	};

	@Override
	public String[] parse(String csv) {
		try {
			return csvParser.get().parseLine(csv);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
