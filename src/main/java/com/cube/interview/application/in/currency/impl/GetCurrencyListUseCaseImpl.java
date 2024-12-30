package com.cube.interview.application.in.currency.impl;

import com.cube.interview.application.in.currency.api.GetCurrencyListRequestQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListResponseQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListUseCase;
import com.cube.interview.application.in.currency.mapper.CurrencyUseCaseMapper;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetCurrencyListUseCaseImpl implements GetCurrencyListUseCase {

  private static final Logger log = LoggerFactory.getLogger(GetCurrencyListUseCaseImpl.class);
  private static final CurrencyUseCaseMapper mapper = Mappers.getMapper(
      CurrencyUseCaseMapper.class);
  private final CurrencyRepository currencyRepository;

  public GetCurrencyListUseCaseImpl(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  @Override
  public GetCurrencyListResponseQuery execute(GetCurrencyListRequestQuery requestQuery) {
    GetCurrencyListResponseQuery responseQuery = new GetCurrencyListResponseQuery();

    List<Currency> currencies = currencyRepository.findAll();
    responseQuery.setList(mapper.toGetCurrencyListResponseQuery(
        currencies));

    return responseQuery;
  }
}
