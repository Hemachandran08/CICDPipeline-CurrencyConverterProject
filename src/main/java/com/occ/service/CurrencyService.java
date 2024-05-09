package com.occ.service;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.occ.model.Currency;
import com.occ.repository.CurrencyRepo;

@Service
public class CurrencyService {

	@Autowired
	private CurrencyRepo currencyRepository;
	
	
	public CurrencyService() {
		
	}

	public List<Currency> getAllCurrencies() {
		return (List<Currency>) currencyRepository.findAll();
	}

	public Currency getCurrencyByCode(String code) {
		
		return currencyRepository.findByCode(code);
	}

	public String addCurrency(Currency currency) {
		String msg;
		try {
			currencyRepository.save(currency);
			msg = "Pass";

		} catch (Exception e) {
			msg = "Fail";
			e.printStackTrace();
		}

		return msg;
	}

	public String updateCurrency(Currency currency) {
		String msg;
		try {
			currencyRepository.save(currency);
			msg = "Pass";

		} catch (Exception e) {
			msg = "Fail";
		}

		return msg;
	}

	public double calculateConversion(String fromCode, String toCode, double amount) {
		Currency fromCurrency = currencyRepository.findByCode(fromCode);
		Currency toCurrency = currencyRepository.findByCode(toCode);

		if (fromCurrency == null || toCurrency == null) {
			throw new IllegalArgumentException("Invalid currency codes provided.");
		}

		double exchangeRate = Calculate.divide(toCurrency.getExchangeRate(), fromCurrency.getExchangeRate());
		return Calculate.multiply(amount, exchangeRate);
	}

	public Currency retrieveExchangeValue(String from, String to) {
		// TODO Auto-generated method stub
		return null;
	}
}