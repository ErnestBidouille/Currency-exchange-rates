package io.github.ernestbidouille.currencyexchangerates.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.ernestbidouille.currencyexchangerates.models.Devise;
import io.github.ernestbidouille.currencyexchangerates.services.DeviseService;

@RestController
public class DeviseController {

    @Autowired
    DeviseService deviseService;

    @GetMapping("/devises")
    private List<Devise> getAllDevise() {
        return deviseService.getAllDevise();
    }

    @GetMapping("/devises/{deviseId}")
    private Devise getDevise(@PathVariable("deviseId") String deviseId) {
        return deviseService.getDeviseById(deviseId);
    }

    @DeleteMapping("/devises/{deviseId}")
    private void deleteDevise(@PathVariable("deviseId") String deviseId) {
        deviseService.delete(deviseId);
    }

    @PostMapping("/devises")
    private String saveDevise(@RequestBody Devise devise) {
        deviseService.saveOrUpdate(devise);
        return devise.getName();
    }

    @PutMapping("/devises")
    private Devise updateDevise(@RequestBody Devise devise) {
        deviseService.saveOrUpdate(devise);
        return devise;
    }
}
