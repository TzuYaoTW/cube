package com.cube.interview.application.in.currency.api;

public class UpdateCurrencyResponseCommand {

  private String message;
  private UpdateCurrencyDetailResponseCommand data;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public UpdateCurrencyDetailResponseCommand getData() {
    return data;
  }

  public void setData(
      UpdateCurrencyDetailResponseCommand data) {
    this.data = data;
  }
}
