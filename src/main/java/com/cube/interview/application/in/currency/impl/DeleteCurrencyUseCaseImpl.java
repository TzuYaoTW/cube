package com.cube.interview.application.in.currency.impl;

import com.cube.interview.application.in.currency.api.CreateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyUseCase;
import com.cube.interview.application.in.currency.api.DeleteCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyUseCase;
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
public class DeleteCurrencyUseCaseImpl implements DeleteCurrencyUseCase {
  private static final Logger log = LoggerFactory.getLogger(DeleteCurrencyUseCaseImpl.class);
  private static final CurrencyUseCaseMapper mapper = Mappers.getMapper(
      CurrencyUseCaseMapper.class);
  private final CurrencyRepository currencyRepository;

  public DeleteCurrencyUseCaseImpl(CurrencyRepository currencyRepository) {
    this.currencyRepository = currencyRepository;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeoutString = "", rollbackFor = Exception.class)
  public DeleteCurrencyResponseCommand execute(DeleteCurrencyRequestCommand requestCommand) {
    log.info(">>>> request: {}", requestCommand);
    DeleteCurrencyResponseCommand responseCommand = new DeleteCurrencyResponseCommand();

    currencyRepository.deleteById(Long.parseLong(requestCommand.getCurrencyMappingId()));

    responseCommand.setMessage("刪除成功");
    return responseCommand;
  }
}
