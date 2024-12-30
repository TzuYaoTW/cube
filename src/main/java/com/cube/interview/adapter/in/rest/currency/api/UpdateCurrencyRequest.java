package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class UpdateCurrencyRequest {

  @JsonProperty(value = "currencyMappingId")
  @NotBlank(message = "幣別對應表流水號不可為空")
  private String currencyMappingId;

  @JsonProperty(value = "code")
  @NotBlank(message = "幣別代號不可為空")
  private String code;

  @JsonProperty(value = "name")
  @NotBlank(message = "幣別名稱不可為空")
  private String name;

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public String getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(String currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public void setName(String name) {
    this.name = name;
  }
}
