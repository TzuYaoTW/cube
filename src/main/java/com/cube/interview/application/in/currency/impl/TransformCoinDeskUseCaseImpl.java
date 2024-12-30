package com.cube.interview.application.in.currency.impl;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.GetCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskUseCase;
import com.cube.interview.application.in.currency.api.TransformCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskUseCase;
import com.cube.interview.application.in.currency.mapper.CurrencyUseCaseMapper;
import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import java.util.List;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TransformCoinDeskUseCaseImpl implements TransformCoinDeskUseCase {

  private static final Logger log = LoggerFactory.getLogger(TransformCoinDeskUseCaseImpl.class);
  private static final CurrencyUseCaseMapper mapper = Mappers.getMapper(
      CurrencyUseCaseMapper.class);
  private final CurrencyService currencyService;
  private final CurrencyRepository currencyRepository;

  public TransformCoinDeskUseCaseImpl(CurrencyService currencyService,
      CurrencyRepository currencyRepository) {
    this.currencyService = currencyService;
    this.currencyRepository = currencyRepository;
  }

  @Override
  public TransformCoinDeskResponseQuery execute(TransformCoinDeskRequestQuery requestQuery) {
    CallCoinDeskOuterResponse outerResponse = currencyService.callOutboundCoinDesk();
    TransformCoinDeskResponseQuery responseQuery = mapper.toTransformCoinDeskResponseQuery(
        outerResponse);

    List<Currency> currencies = currencyRepository.findAll();
    for (Currency currency : currencies) {
      if ("USD".equals(currency.getCode())) {
        responseQuery.getBpi().getUsd().setName(currency.getName());
      }
      if ("GBP".equals(currency.getCode())) {
        responseQuery.getBpi().getGbp().setName(currency.getName());
      }
      if ("EUR".equals(currency.getCode())) {
        responseQuery.getBpi().getEur().setName(currency.getName());
      }
    }

    return responseQuery;
  }
}

