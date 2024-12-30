package com.cube.interview.adapter.in.rest.currency.api;

public class GetCoinDeskResponse {
  private GetCoinDeskTimeResponse time;
  private String disclaimer;
  private String chartName;
  private GetCoinDeskBpiResponse bpi;

  public GetCoinDeskTimeResponse getTime() {
    return time;
  }

  public void setTime(GetCoinDeskTimeResponse time) {
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

  public GetCoinDeskBpiResponse getBpi() {
    return bpi;
  }

  public void setBpi(GetCoinDeskBpiResponse bpi) {
    this.bpi = bpi;
  }
}
