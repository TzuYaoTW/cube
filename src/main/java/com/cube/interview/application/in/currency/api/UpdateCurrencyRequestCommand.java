package com.cube.interview.application.in.currency.api;

public class UpdateCurrencyRequestCommand {

  private Long currencyMappingId;
  private String name;
  private String code;

  public Long getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(Long currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "UpdateCurrencyRequestCommand{" +
        "currencyMappingId='" + currencyMappingId + '\'' +
        ", name='" + name + '\'' +
        ", code='" + code + '\'' +
        '}';
  }
}
