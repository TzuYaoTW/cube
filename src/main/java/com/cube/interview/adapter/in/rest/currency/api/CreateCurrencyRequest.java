package com.cube.interview.adapter.in.rest.currency.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.NotBlank;

public class CreateCurrencyRequest {

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

  public void setCode(
      @NotBlank(message = "幣別代號不可為空") String code) {
    this.code = code;
  }

  public void setName(
      @NotBlank(message = "幣別名稱不可為空") String name) {
    this.name = name;
  }
}
