package io.github.ernestbidouille.currencyexchangerates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.github.ernestbidouille.currencyexchangerates.models.Devise;
import io.github.ernestbidouille.currencyexchangerates.models.Exchange;
import io.github.ernestbidouille.currencyexchangerates.models.Rate;
import io.github.ernestbidouille.currencyexchangerates.services.ExchangeService;

@RestController
@RequestMapping("/exchanges")
public class ExchangeController {

    @Autowired
    ExchangeService exchangeService;

    @GetMapping()
    private List<Exchange> getAllExchanges(@RequestParam(required = false) Devise sourceDevise,
            @RequestParam(required = false) Devise destinationDevise) {
        if (sourceDevise != null && destinationDevise != null) {
            return exchangeService.getExchangesByDevises(sourceDevise, destinationDevise);
        } else if (sourceDevise != null) {
            return exchangeService.getExchangesBySourceDevise(sourceDevise);
        } else if (destinationDevise != null) {
            return exchangeService.getExchangesByDestinationDevise(destinationDevise);
        }
        return exchangeService.getAllExchanges();
    }

    @GetMapping("/lastExchange")
    private Exchange getLastExchange(@RequestParam Devise sourceDevise, @RequestParam Devise destinationDevise) {
        return exchangeService.getExchangeByDevises(sourceDevise, destinationDevise);
    }

    @GetMapping("/lastExchangeRate")
    private Rate getLastExchangeRate(@RequestParam Devise sourceDevise, @RequestParam Devise destinationDevise) {
        Rate rate = exchangeService.getExchangeRateByDevises(sourceDevise, destinationDevise);
        return rate;
    }

    @GetMapping("/{exchangeId}")
    private Exchange getExchange(@PathVariable("exchangeId") Long exchangeId) {
        return exchangeService.getExchangeById(exchangeId);
    }

    @DeleteMapping("/{exchangeId}")
    private void deleteExchange(@PathVariable("exchangeId") Long exchangeId) {
        exchangeService.delete(exchangeId);
    }

    @PostMapping()
    private Long saveDevise(@RequestBody Exchange exchange) {
        exchangeService.saveOrUpdate(exchange);
        return exchange.getId();
    }

    @PutMapping()
    private Exchange updateDevise(@RequestBody Exchange exchange) {
        exchangeService.saveOrUpdate(exchange);
        return exchange;
    }
}
