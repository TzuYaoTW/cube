package com.cube.interview.application.in.currency.api;

public interface UpdateCurrencyUseCase {

  UpdateCurrencyResponseCommand execute(UpdateCurrencyRequestCommand requestCommand);
}
