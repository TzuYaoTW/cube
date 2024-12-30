package com.cube.interview.application.in.currency.api;

public class GetCoinDeskBpiResponseQuery {

  private GetCoinDeskBpiDetailResponseQuery usd;
  private GetCoinDeskBpiDetailResponseQuery gbp;
  private GetCoinDeskBpiDetailResponseQuery eur;

  public GetCoinDeskBpiDetailResponseQuery getUsd() {
    return usd;
  }

  public void setUsd(GetCoinDeskBpiDetailResponseQuery usd) {
    this.usd = usd;
  }

  public GetCoinDeskBpiDetailResponseQuery getGbp() {
    return gbp;
  }

  public void setGbp(GetCoinDeskBpiDetailResponseQuery gbp) {
    this.gbp = gbp;
  }

  public GetCoinDeskBpiDetailResponseQuery getEur() {
    return eur;
  }

  public void setEur(GetCoinDeskBpiDetailResponseQuery eur) {
    this.eur = eur;
  }
}
