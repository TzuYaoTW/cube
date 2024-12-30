package com.cube.interview.application.out.coindesk;

public class CallCoinDeskBpiOuterResponse {
  private CallCoinDeskBpiDetailOuterResponse usd;
  private CallCoinDeskBpiDetailOuterResponse gbp;
  private CallCoinDeskBpiDetailOuterResponse eur;

  public CallCoinDeskBpiDetailOuterResponse getUsd() {
    return usd;
  }

  public void setUsd(CallCoinDeskBpiDetailOuterResponse usd) {
    this.usd = usd;
  }

  public CallCoinDeskBpiDetailOuterResponse getGbp() {
    return gbp;
  }

  public void setGbp(CallCoinDeskBpiDetailOuterResponse gbp) {
    this.gbp = gbp;
  }

  public CallCoinDeskBpiDetailOuterResponse getEur() {
    return eur;
  }

  public void setEur(CallCoinDeskBpiDetailOuterResponse eur) {
    this.eur = eur;
  }
}
