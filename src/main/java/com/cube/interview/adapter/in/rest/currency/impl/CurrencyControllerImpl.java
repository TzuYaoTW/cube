package com.cube.interview.adapter.in.rest.currency.impl;

import com.cube.interview.adapter.in.rest.currency.api.CreateCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.CreateCurrencyResponse;
import com.cube.interview.adapter.in.rest.currency.api.CurrencyController;
import com.cube.interview.adapter.in.rest.currency.api.DeleteCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.DeleteCurrencyResponse;
import com.cube.interview.adapter.in.rest.currency.api.UpdateCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.UpdateCurrencyResponse;
import com.cube.interview.adapter.in.rest.currency.mapper.CurrencyControllerMapper;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyUseCase;
import com.cube.interview.application.in.currency.api.DeleteCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyUseCase;
import com.cube.interview.application.in.currency.api.UpdateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyUseCase;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyControllerImpl implements CurrencyController {

  private static final Logger log = LoggerFactory.getLogger(CurrencyControllerImpl.class);
  private static final CurrencyControllerMapper mapper = Mappers.getMapper(
      CurrencyControllerMapper.class);

  private final CreateCurrencyUseCase createCurrencyUseCase;
  private final DeleteCurrencyUseCase deleteCurrencyUseCase;
  private final UpdateCurrencyUseCase updateCurrencyUseCase;

  public CurrencyControllerImpl(CreateCurrencyUseCase createCurrencyUseCase,
      DeleteCurrencyUseCase deleteCurrencyUseCase, UpdateCurrencyUseCase updateCurrencyUseCase) {
    this.createCurrencyUseCase = createCurrencyUseCase;
    this.deleteCurrencyUseCase = deleteCurrencyUseCase;
    this.updateCurrencyUseCase = updateCurrencyUseCase;
  }

  @Override
  @PostMapping("/create")
  public ResponseEntity<CreateCurrencyResponse> create(CreateCurrencyRequest request) {
    log.info(">>>> [ 新增幣別對應表資料 ] URL: /api/currency/create");
    CreateCurrencyResponseCommand execute = createCurrencyUseCase.execute(
        mapper.toCreateCurrencyRequestCommand(request));
    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.toCreateCurrencyResponse(execute));
  }

  @Override
  @PostMapping("/delete")
  public ResponseEntity<DeleteCurrencyResponse> delete(DeleteCurrencyRequest request) {
    log.info(">>>> [ 刪除幣別對應表資料 ] URL: /api/currency/delete");
    DeleteCurrencyResponseCommand execute = deleteCurrencyUseCase.execute(
        mapper.toDeleteCurrencyRequestCommand(request));
    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.toDeleteCurrencyResponse(execute));
  }

  @Override
  @PostMapping("/update")
  public ResponseEntity<UpdateCurrencyResponse> update(UpdateCurrencyRequest request) {
    log.info(">>>> [ 更新幣別對應表資料 ] URL: /api/currency/update");
    UpdateCurrencyResponseCommand execute = updateCurrencyUseCase.execute(
        mapper.toUpdateCurrencyRequestCommand(request));
    return ResponseEntity.status(HttpStatus.OK)
        .body(mapper.toUpdateCurrencyResponse(execute));
  }
}
