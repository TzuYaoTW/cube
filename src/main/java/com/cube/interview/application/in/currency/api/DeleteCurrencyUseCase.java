package com.cube.interview.application.in.currency.api;

public interface DeleteCurrencyUseCase {

  DeleteCurrencyResponseCommand execute(DeleteCurrencyRequestCommand requestCommand);
}
