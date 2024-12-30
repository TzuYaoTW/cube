package com.cube.interview.application.in.currency.api;

public class GetCoinDeskBpiDetailResponseQuery {

  private String code;
  private String symbol;
  private String rate;
  private String description;
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
}
