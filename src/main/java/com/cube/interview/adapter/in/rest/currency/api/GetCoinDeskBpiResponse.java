package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GetCoinDeskBpiResponse {
  @JsonProperty(value = "USD")
  private GetCoinDeskBpiDetailResponse usd;
  @JsonProperty(value = "GBP")
  private GetCoinDeskBpiDetailResponse gbp;
  @JsonProperty(value = "EUR")
  private GetCoinDeskBpiDetailResponse eur;

  public GetCoinDeskBpiDetailResponse getUsd() {
    return usd;
  }

  public void setUsd(GetCoinDeskBpiDetailResponse usd) {
    this.usd = usd;
  }

  public GetCoinDeskBpiDetailResponse getGbp() {
    return gbp;
  }

  public void setGbp(GetCoinDeskBpiDetailResponse gbp) {
    this.gbp = gbp;
  }

  public GetCoinDeskBpiDetailResponse getEur() {
    return eur;
  }

  public void setEur(GetCoinDeskBpiDetailResponse eur) {
    this.eur = eur;
  }
}
