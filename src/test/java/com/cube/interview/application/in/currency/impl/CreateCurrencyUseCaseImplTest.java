package com.cube.interview.application.in.currency.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.CreateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import com.cube.interview.domain.currency.dto.CurrencyDto;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class CreateCurrencyUseCaseImplTest {
  @Mock
  private CurrencyRepository currencyRepository;

  @Mock
  private CurrencyService currencyService;

  private CreateCurrencyUseCaseImpl createCurrencyUseCase;

  @BeforeEach
  void setup() {
    openMocks(this);
    createCurrencyUseCase = new CreateCurrencyUseCaseImpl(currencyRepository);
  }

  @Test
  void createCurrency_WillCreate_AndReturnInfo() {

    // Arrange
    CreateCurrencyRequestCommand requestCommand = new CreateCurrencyRequestCommand();
    requestCommand.setCode("TWD");
    requestCommand.setName("台幣");

    CurrencyDto dto = new CurrencyDto();
    dto.setCode(requestCommand.getCode());
    dto.setName(requestCommand.getName());

    when(currencyRepository.findByCode("TWD")).thenReturn(Optional.empty());
    when(currencyRepository.findByName("台幣")).thenReturn(Optional.empty());

    // Act
    CreateCurrencyResponseCommand responseCommand = createCurrencyUseCase.execute(requestCommand);

    // Assert
    verify(currencyRepository, times(1)).findByCode(anyString());
    verify(currencyRepository, times(1)).findByName(anyString());
    verify(currencyRepository, times(1)).save(any());

    assertEquals(responseCommand.getMessage(), "新增成功");
  }

  @Test
  void createCurrency_CodeIsExist_WillReturnMessage() {

    // Arrange
    CreateCurrencyRequestCommand requestCommand = new CreateCurrencyRequestCommand();
    requestCommand.setCode("TWD");
    requestCommand.setName("台幣");

    CurrencyDto dto = new CurrencyDto();
    dto.setCode(requestCommand.getCode());
    dto.setName(requestCommand.getName());

    Currency currency = new Currency(dto);
    when(currencyRepository.findByCode("TWD")).thenReturn(Optional.of(currency));

    // Act
    CreateCurrencyResponseCommand responseCommand = createCurrencyUseCase.execute(requestCommand);

    // Assert
    verify(currencyRepository, times(1)).findByCode(anyString());
    verify(currencyRepository, times(0)).findByName(anyString());
    verify(currencyRepository, times(0)).save(any());
    assertEquals(responseCommand.getMessage(), "新增失敗: code 幣別代號已存在");
  }

  @Test
  void createCurrency_NameIsExist_WillReturnMessage() {

    // Arrange
    CreateCurrencyRequestCommand requestCommand = new CreateCurrencyRequestCommand();
    requestCommand.setCode("TWD");
    requestCommand.setName("台幣");

    CurrencyDto dto = new CurrencyDto();
    dto.setCode(requestCommand.getCode());
    dto.setName(requestCommand.getName());

    Currency currency = new Currency(dto);

    when(currencyRepository.findByCode("TWD")).thenReturn(Optional.empty());
    when(currencyRepository.findByName("台幣")).thenReturn(Optional.of(currency));

    // Act
    CreateCurrencyResponseCommand responseCommand = createCurrencyUseCase.execute(requestCommand);

    // Assert
    verify(currencyRepository, times(1)).findByCode(anyString());
    verify(currencyRepository, times(1)).findByName(anyString());
    verify(currencyRepository, times(0)).save(any());

    assertEquals(responseCommand.getMessage(), "新增失敗: name 幣別名稱已存在");
  }
}