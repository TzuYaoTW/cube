package com.cube.interview.application.in.currency.api;

public class CreateCurrencyRequestCommand {

  private String name;
  private String code;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  @Override
  public String toString() {
    return "CreateCurrencyRequestCommand{" +
        "name='" + name + '\'' +
        ", code='" + code + '\'' +
        '}';
  }
}
