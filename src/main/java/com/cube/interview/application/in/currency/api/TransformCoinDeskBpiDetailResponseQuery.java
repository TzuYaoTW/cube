package com.cube.interview.application.in.currency.api;


public class TransformCoinDeskBpiDetailResponseQuery {
  private String code;
  private String name;
  private String rate;
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
