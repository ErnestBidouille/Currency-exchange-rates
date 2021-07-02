package io.github.ernestbidouille.currencyexchangerates.repositories;

import io.github.ernestbidouille.currencyexchangerates.models.Devise;
import io.github.ernestbidouille.currencyexchangerates.models.Exchange;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExchangeRepository extends JpaRepository<Exchange, Long> {

    @Query("SELECT e FROM Exchange e where e.sourceDevise = :sourceDevise and e.destinationDevise = :destinationDevise")
    List<Exchange> findByDevises(@Param("sourceDevise") Devise sourceDevise, @Param("destinationDevise") Devise destinationDevise);

    @Query("SELECT e FROM Exchange e where e.sourceDevise = :sourceDevise")
    List<Exchange> findBySourceDevise(@Param("sourceDevise") Devise sourceDevise);

    @Query("SELECT e FROM Exchange e where e.destinationDevise = :destinationDevise")
    List<Exchange> findByDestinationDevise(@Param("destinationDevise") Devise destinationDevise);

    @Query("SELECT e FROM Exchange e where e.sourceDevise= :sourceDevise and e.destinationDevise = :destinationDevise order by e.date DESC")
    Exchange findOneByDevises(@Param("sourceDevise") Devise sourceDevise, @Param("destinationDevise") Devise destinationDevise);
}
