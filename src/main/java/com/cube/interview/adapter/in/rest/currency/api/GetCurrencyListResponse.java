package com.cube.interview.adapter.in.rest.currency.api;

import java.util.List;

public class GetCurrencyListResponse {

  private List<GetCurrencyDetailResponse> list;

  public List<GetCurrencyDetailResponse> getList() {
    return list;
  }

  public void setList(
      List<GetCurrencyDetailResponse> list) {
    this.list = list;
  }
}
