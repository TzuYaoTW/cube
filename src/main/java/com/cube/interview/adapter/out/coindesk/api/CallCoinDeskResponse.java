package com.cube.interview.adapter.out.coindesk.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallCoinDeskResponse {

  @JsonProperty(value = "time")
  private CallCoinDeskTimeResponse time;
  @JsonProperty(value = "disclaimer")
  private String disclaimer;
  @JsonProperty(value = "chartName")
  private String chartName;
  @JsonProperty(value = "bpi")
  private CallCoinDeskBpiResponse bpi;

  public CallCoinDeskTimeResponse getTime() {
    return time;
  }

  public void setTime(CallCoinDeskTimeResponse time) {
    this.time = time;
  }

  public String getDisclaimer() {
    return disclaimer;
  }

  public void setDisclaimer(String disclaimer) {
    this.disclaimer = disclaimer;
  }

  public String getChartName() {
    return chartName;
  }

  public void setChartName(String chartName) {
    this.chartName = chartName;
  }

  public CallCoinDeskBpiResponse getBpi() {
    return bpi;
  }

  public void setBpi(CallCoinDeskBpiResponse bpi) {
    this.bpi = bpi;
  }

  @Override
  public String toString() {
    return "response {" +
        "time=" + time +
        ", disclaimer='" + disclaimer + '\'' +
        ", chartName='" + chartName + '\'' +
        ", bpi=" + bpi +
        '}';
  }
}
