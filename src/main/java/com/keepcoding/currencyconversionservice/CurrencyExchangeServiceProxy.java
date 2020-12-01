package com.keepcoding.currencyconversionservice;

import com.keepcoding.currencyconversionservice.model.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange-service") // La url no hace falta, se encarga Ribbon
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange/from/{from}/to/{to}") // EUR USD...
    CurrencyConversionBean retrieveExchangeValue(@PathVariable String from, @PathVariable String to);
}
