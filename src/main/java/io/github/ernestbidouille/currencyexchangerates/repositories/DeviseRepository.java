package io.github.ernestbidouille.currencyexchangerates.repositories;


import io.github.ernestbidouille.currencyexchangerates.models.Devise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviseRepository extends JpaRepository<Devise, String> {

}
