package com.cube.interview.application.in.currency.api;

public class UpdateCurrencyDetailResponseCommand {

  private Long currencyMappingId;
  private String code;
  private String name;
  private String createTime;
  private String updateTime;

  public Long getCurrencyMappingId() {
    return currencyMappingId;
  }

  public void setCurrencyMappingId(Long currencyMappingId) {
    this.currencyMappingId = currencyMappingId;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCreateTime() {
    return createTime;
  }

  public void setCreateTime(String createTime) {
    this.createTime = createTime;
  }

  public String getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(String updateTime) {
    this.updateTime = updateTime;
  }
}
