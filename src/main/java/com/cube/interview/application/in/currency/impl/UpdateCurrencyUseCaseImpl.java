package com.cube.interview.application.in.currency.impl;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.CreateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyUseCase;
import com.cube.interview.application.in.currency.api.UpdateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyUseCase;
import com.cube.interview.application.in.currency.mapper.CurrencyUseCaseMapper;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import com.cube.interview.domain.currency.dto.CurrencyDto;
import java.util.Optional;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateCurrencyUseCaseImpl implements UpdateCurrencyUseCase {

  private static final Logger log = LoggerFactory.getLogger(UpdateCurrencyUseCaseImpl.class);
  private static final CurrencyUseCaseMapper mapper = Mappers.getMapper(
      CurrencyUseCaseMapper.class);
  private final CurrencyRepository currencyRepository;
  private final CurrencyService currencyService;

  public UpdateCurrencyUseCaseImpl(CurrencyRepository currencyRepository,
      CurrencyService currencyService) {
    this.currencyRepository = currencyRepository;
    this.currencyService = currencyService;
  }

  @Override
  @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, timeoutString = "", rollbackFor = Exception.class)
  public UpdateCurrencyResponseCommand execute(UpdateCurrencyRequestCommand requestCommand) {
    log.info(">>>> request: {}", requestCommand);

    UpdateCurrencyResponseCommand responseCommand = new UpdateCurrencyResponseCommand();
    Optional<Currency> beforeCurrency = currencyRepository.findById(
        requestCommand.getCurrencyMappingId());
    if (beforeCurrency.isPresent()) {
      if (currencyService.validateUniqueCodeAndName(requestCommand.getCurrencyMappingId(),
          requestCommand.getCode(),
          requestCommand.getName())) {
        responseCommand.setMessage("更新失敗: 幣別代號或名稱重複");
        return responseCommand;
      }
      Currency currency = beforeCurrency.get();
      CurrencyDto dto = mapper.toCurrencyDto(requestCommand);
      currency.update(dto);
      responseCommand.setMessage("更新成功");
      responseCommand.setData(mapper.toUpdateCurrencyDetailResponseCommand(currency));
      currencyRepository.save(currency);
    } else {
      responseCommand.setMessage("更新失敗: 幣別不存在");
      return responseCommand;
    }

    return responseCommand;
  }
}
