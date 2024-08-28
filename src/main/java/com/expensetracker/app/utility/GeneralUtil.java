package com.expensetracker.app.utility;

import java.text.NumberFormat;
import java.util.*;

import com.expensetracker.app.dto.CurrencyData;

public class GeneralUtil {
	public static String currencyFormatter(double amount, CurrencyData currency) {
		Locale locale;
		switch (currency.getCountryIso()) {
		case "IN":
			locale = new Locale("en", "IN");
			return NumberFormat.getCurrencyInstance(locale).format(amount);

		case "US":
			return NumberFormat.getCurrencyInstance(Locale.US).format(amount);
		default:
			return null;
		}
	}
}
