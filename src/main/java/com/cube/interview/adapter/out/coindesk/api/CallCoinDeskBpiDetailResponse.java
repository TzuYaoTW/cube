package com.cube.interview.adapter.out.coindesk.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallCoinDeskBpiDetailResponse {
  @JsonProperty(value = "code")
  private String code;
  @JsonProperty(value = "symbol")
  private String symbol;
  @JsonProperty(value = "rate")
  private String rate;
  @JsonProperty(value = "description")
  private String description;
  @JsonProperty(value = "rate_float")
  private double rateFloat;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getSymbol() {
    return symbol;
  }

  public void setSymbol(String symbol) {
    this.symbol = symbol;
  }

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getRateFloat() {
    return rateFloat;
  }

  public void setRateFloat(double rateFloat) {
    this.rateFloat = rateFloat;
  }

  @Override
  public String toString() {
    return "{" +
        "code='" + code + '\'' +
        ", symbol='" + symbol + '\'' +
        ", rate='" + rate + '\'' +
        ", description='" + description + '\'' +
        ", rateFloat=" + rateFloat +
        '}';
  }
}
