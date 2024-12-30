package com.cube.interview.adapter.in.rest.currency.api;

public class GetCurrencyDetailResponse {

  private String currencyMappingId;
  private String code;
  private String name;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(String currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }
}
