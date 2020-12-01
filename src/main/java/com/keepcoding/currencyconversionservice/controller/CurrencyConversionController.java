package com.keepcoding.currencyconversionservice.controller;

import com.keepcoding.currencyconversionservice.CurrencyExchangeServiceProxy;
import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {

    @Autowired
    CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable String from, @PathVariable String to, @PathVariable BigDecimal quantity) {

        CurrencyConversionBean result = currencyExchangeServiceProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionBean(result.getId(), result.getFrom(), result.getTo(),
                result.getConversionMultiple(), quantity, quantity.multiply(result.getConversionMultiple()), result.getPort());


    }
}
