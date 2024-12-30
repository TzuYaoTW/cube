package com.cube.interview.adapter.in.rest.currency.api;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/currency")
@Validated
public interface CurrencyController {

  ResponseEntity<CreateCurrencyResponse> create(@Valid @RequestBody CreateCurrencyRequest request);
  ResponseEntity<DeleteCurrencyResponse> delete(@Valid @RequestBody DeleteCurrencyRequest request);
  ResponseEntity<UpdateCurrencyResponse> update(@Valid @RequestBody UpdateCurrencyRequest request);
}
