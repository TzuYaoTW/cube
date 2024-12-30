package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransformCoinDeskResponse {
  @JsonProperty(value = "time")
  private TransformCoinDeskTimeResponse time;

  @JsonProperty(value = "bpi")
  private TransformCoinDeskBpiResponse bpi;

  public TransformCoinDeskTimeResponse getTime() {
    return time;
  }

  public void setTime(TransformCoinDeskTimeResponse time) {
    this.time = time;
  }

  public TransformCoinDeskBpiResponse getBpi() {
    return bpi;
  }

  public void setBpi(TransformCoinDeskBpiResponse bpi) {
    this.bpi = bpi;
  }
}
