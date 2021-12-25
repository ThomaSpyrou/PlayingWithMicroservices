package com.microservice.currencyexchangeconversion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrConversionController {

    @Autowired
    CurrencyExchangeProxy currencyExchangeProxy;

//    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{qty}")
//    public CurrencyConversionValue calculateCurrencyConversionValue(@PathVariable String from,
//                                                                    @PathVariable String to,
//                                                                    @PathVariable int qty){
//
//        HashMap<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("from", from);
//        uriVariables.put("to", to);
//
//        ResponseEntity<CurrencyConversionValue> responseEntity = new RestTemplate().getForEntity(
//                "http://localhost:8000/currency-exchange/from/{from}/to/{to}",
//                CurrencyConversionValue.class, //since the responses-classes are similar they are auto mapped
//                uriVariables);
//
//        CurrencyConversionValue currencyConversion = responseEntity.getBody();
//
//        return new CurrencyConversionValue(currencyConversion.getId(), from, to, qty,
//                currencyConversion.getConversationMultiple(),
//                currencyConversion.getEnvironment());
//    }

    //using feign
    @GetMapping(path = "/currency-conversion/from/{from}/to/{to}/quantity/{qty}")
    public CurrencyConversionValue calculateCurrencyConversionValue(@PathVariable String from,
                                                                    @PathVariable String to,
                                                                    @PathVariable int qty){

        CurrencyConversionValue currencyConversionValue = currencyExchangeProxy.retrieveExchangeValue(from, to);

        return new CurrencyConversionValue(
                currencyConversionValue.getId(),
                from, to, qty,
                currencyConversionValue.getConversationMultiple(),
                currencyConversionValue.getEnvironment()
                );
    }

}
