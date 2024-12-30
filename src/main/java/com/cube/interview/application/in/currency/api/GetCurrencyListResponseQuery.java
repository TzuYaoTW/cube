package com.cube.interview.application.in.currency.api;

import java.util.List;

public class GetCurrencyListResponseQuery {

  private List<GetCurrencyDetailResponseQuery> list;

  public List<GetCurrencyDetailResponseQuery> getList() {
    return list;
  }

  public void setList(
      List<GetCurrencyDetailResponseQuery> list) {
    this.list = list;
  }
}
