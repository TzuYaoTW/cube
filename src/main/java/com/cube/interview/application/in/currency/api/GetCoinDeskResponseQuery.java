package com.cube.interview.application.in.currency.api;

public class GetCoinDeskResponseQuery {
  private GetCoinDeskTimeResponseQuery time;
  private String disclaimer;
  private String chartName;
  private GetCoinDeskBpiResponseQuery bpi;


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

  public GetCoinDeskBpiResponseQuery getBpi() {
    return bpi;
  }

  public void setBpi(GetCoinDeskBpiResponseQuery bpi) {
    this.bpi = bpi;
  }

  public GetCoinDeskTimeResponseQuery getTime() {
    return time;
  }

  public void setTime(GetCoinDeskTimeResponseQuery time) {
    this.time = time;
  }
}
