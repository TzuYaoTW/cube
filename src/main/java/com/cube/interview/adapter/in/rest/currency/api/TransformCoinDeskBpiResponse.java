package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransformCoinDeskBpiResponse {
  @JsonProperty(value = "USD")
  private TransformCoinDeskBpiDetailResponse usd;
  @JsonProperty(value = "GBP")
  private TransformCoinDeskBpiDetailResponse gbp;
  @JsonProperty(value = "EUR")
  private TransformCoinDeskBpiDetailResponse eur;

  public TransformCoinDeskBpiDetailResponse getUsd() {
    return usd;
  }

  public void setUsd(
      TransformCoinDeskBpiDetailResponse usd) {
    this.usd = usd;
  }

  public TransformCoinDeskBpiDetailResponse getGbp() {
    return gbp;
  }

  public void setGbp(
      TransformCoinDeskBpiDetailResponse gbp) {
    this.gbp = gbp;
  }

  public TransformCoinDeskBpiDetailResponse getEur() {
    return eur;
  }

  public void setEur(
      TransformCoinDeskBpiDetailResponse eur) {
    this.eur = eur;
  }
}
