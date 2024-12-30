package com.cube.interview.application.in.currency.api;

public interface GetCoinDeskUseCase {

  GetCoinDeskResponseQuery execute(GetCoinDeskRequestQuery requestQuery);
}
