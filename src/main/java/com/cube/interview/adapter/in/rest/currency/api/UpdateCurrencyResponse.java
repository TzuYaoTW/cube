package com.cube.interview.adapter.in.rest.currency.api;

public class UpdateCurrencyResponse {

  private String message;

  private UpdateCurrencyDetailResponse data;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public UpdateCurrencyDetailResponse getData() {
    return data;
  }

  public void setData(UpdateCurrencyDetailResponse data) {
    this.data = data;
  }
}
