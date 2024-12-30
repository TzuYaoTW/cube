package com.cube.interview.application.in.currency.impl;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.UpdateCurrencyRequestCommand;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import com.cube.interview.domain.currency.dto.CurrencyDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class UpdateCurrencyUseCaseImplTest {

  @Mock
  private CurrencyRepository currencyRepository;

  @Mock
  private  CurrencyService currencyService;

  private UpdateCurrencyUseCaseImpl updateCurrencyUseCase;

  @BeforeEach
  void setup() {
    openMocks(this);
    updateCurrencyUseCase = new UpdateCurrencyUseCaseImpl(currencyRepository, currencyService);
  }

  @Test
  void execute() {
    UpdateCurrencyRequestCommand requestCommand = new UpdateCurrencyRequestCommand();
    requestCommand.setCurrencyMappingId(1l);
    requestCommand.setCode("TWD");
    requestCommand.setName("台幣");

    CurrencyDto dto = new CurrencyDto();
    dto.setCurrencyId(requestCommand.getCurrencyMappingId());
    dto.setCode(requestCommand.getCode());
    dto.setName(requestCommand.getName());

    Currency currency = new Currency();
    currency.update(dto);

    updateCurrencyUseCase.execute(requestCommand);
    verify(currencyRepository, times(1)).findById(anyLong());

  }
}