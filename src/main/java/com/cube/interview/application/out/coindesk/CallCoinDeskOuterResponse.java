package com.cube.interview.application.out.coindesk;

public class CallCoinDeskOuterResponse {
  private CallCoinDeskTimeOuterResponse time;
  private String disclaimer;
  private String chartName;
  private CallCoinDeskBpiOuterResponse bpi;

  public CallCoinDeskTimeOuterResponse getTime() {
    return time;
  }

  public void setTime(CallCoinDeskTimeOuterResponse time) {
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

  public CallCoinDeskBpiOuterResponse getBpi() {
    return bpi;
  }

  public void setBpi(CallCoinDeskBpiOuterResponse bpi) {
    this.bpi = bpi;
  }
}
