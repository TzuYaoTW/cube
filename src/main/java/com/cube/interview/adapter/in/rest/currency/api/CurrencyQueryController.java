package com.cube.interview.adapter.in.rest.currency.api;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/currency")
@Validated
public interface CurrencyQueryController {

  ResponseEntity<GetCurrencyListResponse> getList(GetCurrencyListRequest request);
  ResponseEntity<GetCoinDeskResponse> getCoinDesk(GetCoinDeskRequest request);
  ResponseEntity<TransformCoinDeskResponse> getTransData(TransformCoinDeskRequest request);
}
