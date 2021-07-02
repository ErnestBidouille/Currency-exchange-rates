package io.github.ernestbidouille.currencyexchangerates.services;

import io.github.ernestbidouille.currencyexchangerates.models.Devise;
import io.github.ernestbidouille.currencyexchangerates.repositories.DeviseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviseService {
    @Autowired
    DeviseRepository deviseRepository;

    public List<Devise> getAllDevise() {
        List<Devise> devises = new ArrayList<Devise>();
        deviseRepository.findAll().forEach(devise -> devises.add(devise));
        return devises;
    }

    public Devise getDeviseById(String id) {
        return deviseRepository.findById(id).get();
    }

    public void saveOrUpdate(Devise devise) {
        deviseRepository.save(devise);
    }

    public void delete(String id) {
        deviseRepository.deleteById(id);
    }

    public void update(Devise devise, String deviseId) {
        deviseRepository.save(devise);
    }
}
