package com.cube.interview.application.in.currency.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cube.interview.application.in.currency.api.GetCurrencyListRequestQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListResponseQuery;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;

import com.cube.interview.domain.currency.dto.CurrencyDto;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

class GetCurrencyListUseCaseImplTest {

  @Mock
  private CurrencyRepository currencyRepository;

  private GetCurrencyListUseCaseImpl getCurrencyListUseCase;

  @BeforeEach
  void setup() {
    openMocks(this);
    getCurrencyListUseCase = new GetCurrencyListUseCaseImpl(currencyRepository);
  }

  @Test
  void getCurrencyList_WillReturnCurrencies() {

    // Arrange
    GetCurrencyListRequestQuery requestQuery = new GetCurrencyListRequestQuery();
    List<Currency> currencies = new ArrayList<>();
    CurrencyDto dto = new CurrencyDto();
    dto.setCode("USD");
    dto.setName("美金");
    ZonedDateTime now = ZonedDateTime.now();
    Currency currency = new Currency(dto);
    ReflectionTestUtils.setField(currency, "currencyMappingId", 1L);
    ReflectionTestUtils.setField(currency, "createTime", now);
    ReflectionTestUtils.setField(currency, "updateTime", now);
    currencies.add(currency);

    when(currencyRepository.findAll()).thenReturn(currencies);

    // Act
    GetCurrencyListResponseQuery result = getCurrencyListUseCase.execute(requestQuery);

    // Assert
    verify(currencyRepository, times(1)).findAll();
    assertEquals(1L, result.getList().get(0).getCurrencyMappingId());
    assertEquals("USD", result.getList().get(0).getCode());
    assertEquals("美金", result.getList().get(0).getName());
  }
}