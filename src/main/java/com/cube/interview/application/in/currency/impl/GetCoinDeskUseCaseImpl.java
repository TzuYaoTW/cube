package com.cube.interview.application.in.currency.impl;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.GetCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskUseCase;
import com.cube.interview.application.in.currency.mapper.CurrencyUseCaseMapper;

import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class GetCoinDeskUseCaseImpl implements GetCoinDeskUseCase {

  private static final Logger log = LoggerFactory.getLogger(GetCoinDeskUseCaseImpl.class);
  private static final CurrencyUseCaseMapper mapper = Mappers.getMapper(
      CurrencyUseCaseMapper.class);
  private final CurrencyService currencyService;

  public GetCoinDeskUseCaseImpl(CurrencyService currencyService) {
    this.currencyService = currencyService;
  }

  @Override
  public GetCoinDeskResponseQuery execute(GetCoinDeskRequestQuery requestQuery) {

    return mapper.toGetCoinDeskResponseQuery(
        currencyService.callOutboundCoinDesk());
  }
}

