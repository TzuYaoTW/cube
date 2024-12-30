package com.cube.interview.application.in.currency.api;

public class DeleteCurrencyRequestCommand {

  private String currencyMappingId;

  public String getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(String currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }
}
