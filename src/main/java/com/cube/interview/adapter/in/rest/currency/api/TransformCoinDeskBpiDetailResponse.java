package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransformCoinDeskBpiDetailResponse {
  private String code;
  private String name;
  private String rate;
  @JsonProperty(value = "rate_float")
  private double rateFloat;

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

  public String getRate() {
    return rate;
  }

  public void setRate(String rate) {
    this.rate = rate;
  }

  public double getRateFloat() {
    return rateFloat;
  }

  public void setRateFloat(double rateFloat) {
    this.rateFloat = rateFloat;
  }
}
