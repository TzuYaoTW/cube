package com.cube.interview.adapter.out.coindesk.api;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CallCoinDeskBpiResponse {
  @JsonProperty(value = "USD")
  private CallCoinDeskBpiDetailResponse usd;
  @JsonProperty(value = "GBP")
  private CallCoinDeskBpiDetailResponse gbp;
  @JsonProperty(value = "EUR")
  private CallCoinDeskBpiDetailResponse eur;

  public CallCoinDeskBpiDetailResponse getUsd() {
    return usd;
  }

  public void setUsd(CallCoinDeskBpiDetailResponse usd) {
    this.usd = usd;
  }

  public CallCoinDeskBpiDetailResponse getGbp() {
    return gbp;
  }

  public void setGbp(CallCoinDeskBpiDetailResponse gbp) {
    this.gbp = gbp;
  }

  public CallCoinDeskBpiDetailResponse getEur() {
    return eur;
  }

  public void setEur(CallCoinDeskBpiDetailResponse eur) {
    this.eur = eur;
  }

  @Override
  public String toString() {
    return "{" +
        "usd=" + usd +
        ", gbp=" + gbp +
        ", eur=" + eur +
        '}';
  }
}
