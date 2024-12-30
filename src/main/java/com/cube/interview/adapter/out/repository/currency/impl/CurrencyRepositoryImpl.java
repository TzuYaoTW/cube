package com.cube.interview.adapter.out.repository.currency.impl;

import com.cube.interview.adapter.out.repository.currency.api.CurrencyJpaRepository;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import java.util.List;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CurrencyRepositoryImpl implements CurrencyRepository {

  private final CurrencyJpaRepository repo;

  public CurrencyRepositoryImpl(CurrencyJpaRepository repo) {
    this.repo = repo;
  }

  @Override
  public Optional<Currency> findById(Long id) {
    return repo.findById(id);
  }

  @Override
  public Optional<Currency> findByCode(String code) {
    return repo.findByCode(code);
  }

  @Override
  public Optional<Currency> findByName(String name) {
    return repo.findByName(name);
  }

  @Override
  public List<Currency> findAll() {
    return repo.findAll();
  }

  @Override
  public void deleteById(Long currencyMappingId) {
    repo.deleteById(currencyMappingId);
  }

  @Override
  public void save(Currency currency) {
    repo.save(currency);
  }
}
