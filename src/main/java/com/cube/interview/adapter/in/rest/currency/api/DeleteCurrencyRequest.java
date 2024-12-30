package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class DeleteCurrencyRequest {

  @JsonProperty(value = "currencyMappingId")
  @NotBlank(message = "幣別流水號不可為空")
  private String currencyMappingId;

  public String getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(String currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }
}
