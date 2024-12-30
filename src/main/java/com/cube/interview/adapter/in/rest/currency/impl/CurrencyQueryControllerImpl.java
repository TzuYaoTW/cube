package com.cube.interview.adapter.in.rest.currency.impl;

import com.cube.interview.adapter.in.rest.currency.api.CurrencyQueryController;
import com.cube.interview.adapter.in.rest.currency.api.GetCoinDeskRequest;
import com.cube.interview.adapter.in.rest.currency.api.GetCoinDeskResponse;
import com.cube.interview.adapter.in.rest.currency.api.GetCurrencyListRequest;
import com.cube.interview.adapter.in.rest.currency.api.GetCurrencyListResponse;
import com.cube.interview.adapter.in.rest.currency.api.TransformCoinDeskRequest;
import com.cube.interview.adapter.in.rest.currency.api.TransformCoinDeskResponse;
import com.cube.interview.adapter.in.rest.currency.mapper.CurrencyControllerMapper;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskUseCase;
import com.cube.interview.application.in.currency.api.GetCurrencyListResponseQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListUseCase;
import com.cube.interview.application.in.currency.api.TransformCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskUseCase;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyQueryControllerImpl implements CurrencyQueryController {

  private static final Logger log = LoggerFactory.getLogger(CurrencyQueryControllerImpl.class);
  private static final CurrencyControllerMapper mapper = Mappers.getMapper(
      CurrencyControllerMapper.class);

  private final GetCurrencyListUseCase getCurrencyListUseCase;
  private final GetCoinDeskUseCase getCoinDeskUseCase;
  private final TransformCoinDeskUseCase transformCoinDeskUseCase;

  public CurrencyQueryControllerImpl(GetCurrencyListUseCase getCurrencyListUseCase,
      GetCoinDeskUseCase getCoinDeskUseCase, TransformCoinDeskUseCase transformCoinDeskUseCase) {
    this.getCurrencyListUseCase = getCurrencyListUseCase;
    this.getCoinDeskUseCase = getCoinDeskUseCase;
    this.transformCoinDeskUseCase = transformCoinDeskUseCase;
  }

  @Override
  @PostMapping("/get/list")
  public ResponseEntity<GetCurrencyListResponse> getList(GetCurrencyListRequest request) {
    log.info(">>>> [ 查詢所有幣別對應表資料 ] URL: /api/currency/get/list");

    GetCurrencyListResponseQuery execute = getCurrencyListUseCase.execute(
        mapper.toGetCurrencyListRequestQuery(request));
    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.toGetCurrencyListResponse(execute));
  }

  @Override
  @PostMapping("/get/coindesk")
  public ResponseEntity<GetCoinDeskResponse> getCoinDesk(GetCoinDeskRequest request) {
    log.info(">>>> [ call coindesk API ] URL: /api/currency/get/coindesk");
    GetCoinDeskResponseQuery execute = getCoinDeskUseCase.execute(
        mapper.toGetCoinDeskRequestQuery(request));
    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.toGetCoinDeskResponse(execute));
  }

  @Override
  @PostMapping("/get/coindesk/trans")
  public ResponseEntity<TransformCoinDeskResponse> getTransData(TransformCoinDeskRequest request) {
    log.info(">>>> [ call coindesk API and transform DATA ] URL: /api/currency/get/coindesk/trans");
    TransformCoinDeskResponseQuery execute = transformCoinDeskUseCase.execute(
        mapper.toTransformCoinDeskRequestQuery(request));
    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.toTransformCoinDeskResponse(execute));

  }
}
