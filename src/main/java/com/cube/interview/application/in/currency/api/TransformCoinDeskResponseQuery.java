package com.cube.interview.application.in.currency.api;


public class TransformCoinDeskResponseQuery {
  private TransformCoinDeskTimeResponseQuery time;
  private TransformCoinDeskBpiResponseQuery bpi;

  public TransformCoinDeskTimeResponseQuery getTime() {
    return time;
  }

  public void setTime(
      TransformCoinDeskTimeResponseQuery time) {
    this.time = time;
  }

  public TransformCoinDeskBpiResponseQuery getBpi() {
    return bpi;
  }

  public void setBpi(TransformCoinDeskBpiResponseQuery bpi) {
    this.bpi = bpi;
  }
}
