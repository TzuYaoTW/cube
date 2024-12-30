package com.cube.interview.application.in.currency.impl;

import com.cube.interview.application.in.currency.api.CreateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyUseCase;
import com.cube.interview.application.in.currency.mapper.CurrencyUseCaseMapper;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import com.cube.interview.domain.currency.dto.CurrencyDto;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCurrencyUseCaseImpl implements CreateCurrencyUseCase {
  private static final Logger log = LoggerFactory.getLogger(CreateCurrencyUseCaseImpl.class);
  private static final CurrencyUseCaseMapper mapper = Mappers.getMapper(
      CurrencyUseCaseMapper.class);
  private final CurrencyRepository currencyRepository;

  public CreateCurrencyUseCaseImpl(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeoutString = "", rollbackFor = Exception.class)
  public CreateCurrencyResponseCommand execute(CreateCurrencyRequestCommand requestCommand) {

    log.info(">>>> request: {}", requestCommand);

    CreateCurrencyResponseCommand responseCommand = new CreateCurrencyResponseCommand();
    if (currencyRepository.findByCode(requestCommand.getCode()).isPresent()) {
      responseCommand.setMessage("新增失敗: code 幣別代號已存在");
      return responseCommand;
    }
    if (currencyRepository.findByName(requestCommand.getName()).isPresent()) {
      responseCommand.setMessage("新增失敗: name 幣別名稱已存在");
      return responseCommand;
    }

    CurrencyDto dto = mapper.toCurrencyDto(requestCommand);
    currencyRepository.save(new Currency(dto));

    responseCommand.setMessage("新增成功");
    return responseCommand;
  }
}
