package com.cube.interview.application.in.currency.api;

public class TransformCoinDeskBpiResponseQuery {

  private TransformCoinDeskBpiDetailResponseQuery usd;

  private TransformCoinDeskBpiDetailResponseQuery gbp;

  private TransformCoinDeskBpiDetailResponseQuery eur;

  public TransformCoinDeskBpiDetailResponseQuery getUsd() {
    return usd;
  }

  public void setUsd(
      TransformCoinDeskBpiDetailResponseQuery usd) {
    this.usd = usd;
  }

  public TransformCoinDeskBpiDetailResponseQuery getGbp() {
    return gbp;
  }

  public void setGbp(
      TransformCoinDeskBpiDetailResponseQuery gbp) {
    this.gbp = gbp;
  }

  public TransformCoinDeskBpiDetailResponseQuery getEur() {
    return eur;
  }

  public void setEur(
      TransformCoinDeskBpiDetailResponseQuery eur) {
    this.eur = eur;
  }
}
