package com.numbers.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.numbers.service.NumberService;

@Service
public class NumberServiceImpl implements NumberService {

	@Override
	public String getFactAboutNumber(long number) {
		String url = "http://numbersapi.com";
		url = url + "/" + number;
		return new RestTemplate().getForObject(url, String.class);
	}

	@Override
	public String getMathFactAboutNumber(long number) {
		String url = "http://numbersapi.com";
		url = url + "/" + number + "/" + "math";
		return new RestTemplate().getForObject(url, String.class);
	}

	@Override
	public String getFactInDate(int month, int day) {
		String url = "http://numbersapi.com";
		url = url + "/" + month + "/" + day + "/" + "date";
		return new RestTemplate().getForObject(url, String.class);
	}


	

}
