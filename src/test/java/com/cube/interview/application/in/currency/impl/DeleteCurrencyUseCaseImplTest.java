package com.cube.interview.application.in.currency.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cube.interview.application.in.currency.api.DeleteCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyResponseCommand;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class DeleteCurrencyUseCaseImplTest {

  @Mock
  private CurrencyRepository currencyRepository;

  private DeleteCurrencyUseCaseImpl deleteCurrencyUseCase;

  @BeforeEach
  void setup() {
    openMocks(this);
    deleteCurrencyUseCase = new DeleteCurrencyUseCaseImpl(currencyRepository);
  }

  @Test
  void delete_WillDeleteCurrency() {

    // Arrange
    DeleteCurrencyRequestCommand requestCommand = new DeleteCurrencyRequestCommand();
    requestCommand.setCurrencyMappingId("1");

    // Act
    DeleteCurrencyResponseCommand responseCommand = deleteCurrencyUseCase.execute(requestCommand);

    // Assert
    verify(currencyRepository, times(1)).deleteById(any());
    assertEquals(responseCommand.getMessage(), "刪除成功");
  }
}