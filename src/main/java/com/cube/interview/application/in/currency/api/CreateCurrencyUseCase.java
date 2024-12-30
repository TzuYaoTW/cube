package com.cube.interview.application.in.currency.api;

public interface CreateCurrencyUseCase {

  CreateCurrencyResponseCommand execute(CreateCurrencyRequestCommand requestCommand);
}
