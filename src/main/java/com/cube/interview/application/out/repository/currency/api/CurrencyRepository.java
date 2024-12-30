package com.cube.interview.application.out.repository.currency.api;

import com.cube.interview.domain.currency.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository {

  Optional<Currency> findById(Long id);

  Optional<Currency> findByCode(String code);

  Optional<Currency> findByName(String name);

  List<Currency> findAll();

  void deleteById(Long currencyMappingId);

  void save(Currency currency);
}
