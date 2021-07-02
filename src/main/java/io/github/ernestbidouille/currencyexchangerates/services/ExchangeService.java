package io.github.ernestbidouille.currencyexchangerates.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ernestbidouille.currencyexchangerates.models.Devise;
import io.github.ernestbidouille.currencyexchangerates.models.Exchange;
import io.github.ernestbidouille.currencyexchangerates.models.Rate;
import io.github.ernestbidouille.currencyexchangerates.repositories.ExchangeRepository;

@Service
public class ExchangeService {

    @Autowired
    ExchangeRepository exchangeRepository;

    public List<Exchange> getAllExchanges() {
        List<Exchange> exchanges = new ArrayList<Exchange>();
        exchangeRepository.findAll().forEach(exchange -> exchanges.add(exchange));
        return exchanges;
    }

    public Exchange getExchangeById(Long id) {
        return exchangeRepository.findById(id).get();
    }

    public List<Exchange> getExchangesByDevises(Devise sourceDevise, Devise destinationDevise) {
        return exchangeRepository.findByDevises(sourceDevise, destinationDevise);
    }

    public List<Exchange> getExchangesBySourceDevise(Devise sourceDevise) {
        return exchangeRepository.findBySourceDevise(sourceDevise);
    }

    public List<Exchange> getExchangesByDestinationDevise(Devise destinationDevise) {
        return exchangeRepository.findByDestinationDevise(destinationDevise);
    }

    public Exchange getExchangeByDevises(Devise sourceDevise, Devise destinationDevise) {
        return exchangeRepository.findOneByDevises(sourceDevise, destinationDevise);
    }

    public Rate getExchangeRateByDevises(Devise sourceDevise, Devise destinationDevise) {
        Rate rate = new Rate(exchangeRepository.findOneByDevises(sourceDevise, destinationDevise).getRate());
        return rate;
    }

    public void saveOrUpdate(Exchange exchange) {
        exchangeRepository.save(exchange);
    }

    public void delete(Long id) {
        exchangeRepository.deleteById(id);
    }

    public void update(Exchange exchange, Long deviseId) {
        exchangeRepository.save(exchange);
    }
}
