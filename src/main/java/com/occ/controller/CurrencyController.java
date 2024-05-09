package com.occ.controller;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.occ.service.CurrencyService;
import com.occ.model.Currency;

@RestController
@CrossOrigin("http://localhost:3000")

public class CurrencyController {

	@Autowired
	private CurrencyService currencyService;

	public CurrencyController(CurrencyService currencyService) {
		this.currencyService = currencyService;
	}

	@GetMapping("GetAll")
	public List<Currency> getAllCurrencies() {
		return currencyService.getAllCurrencies();
	}

	@GetMapping("/{code}")
	public Currency getCurrencyByCode(@PathVariable String code) {
		return currencyService.getCurrencyByCode(code);
	}

	@PostMapping("/Insert")
	public String addCurrency(@RequestBody Currency currency) {
		String msg;
		currencyService.addCurrency(currency);
		try {
			msg = "Pass";
		} catch (Exception e) {
			msg = "Fail";
		}
		return msg;
	}

	@PutMapping("/{id}")
	public void updateCurrency(@PathVariable Long id, @RequestBody Currency currency) {
		// Validate if the currency with the given ID exists
		// Update the currency details
		currencyService.updateCurrency(currency);
	}

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public double convertCurrency(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("quantity") double quantity) {

		return currencyService.calculateConversion(from, to, quantity);

		// Implement currency conversion logic using the CurrencyService
		// Example: CurrencyConversionBean response =
		// currencyService.convertCurrency(from, to, quantity);

		// Return the response
		// Example: return response;
	}
}
