package com.cube.interview.adapter.out.repository.currency.api;

import com.cube.interview.domain.currency.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyJpaRepository extends JpaRepository<Currency, Long> {

  Optional<Currency> findByCode(String code);
  Optional<Currency> findByName(String name);
}
