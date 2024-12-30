package com.cube.interview.adapter.out.coindesk.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CallCoinDeskTimeResponse {
  @JsonProperty(value = "updated")
  private String updated;
  @JsonProperty(value = "updatedISO")
  private String updatedISO;
  @JsonProperty(value = "updateduk")
  private String updateduk;

  public String getUpdated() {
    return updated;
  }

  public void setUpdated(String updated) {
    this.updated = updated;
  }

  public String getUpdatedISO() {
    return updatedISO;
  }

  public void setUpdatedISO(String updatedISO) {
    this.updatedISO = updatedISO;
  }

  public String getUpdateduk() {
    return updateduk;
  }

  public void setUpdateduk(String updateduk) {
    this.updateduk = updateduk;
  }

  @Override
  public String toString() {
    return "{" +
        "updated='" + updated + '\'' +
        ", updatedISO='" + updatedISO + '\'' +
        ", updateduk='" + updateduk + '\'' +
        '}';
  }
}
