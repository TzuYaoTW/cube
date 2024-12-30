package com.cube.interview.application.in.currency.api;

public class GetCurrencyDetailResponseQuery {

  private Long currencyMappingId;
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

  public Long getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(Long currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }
}
