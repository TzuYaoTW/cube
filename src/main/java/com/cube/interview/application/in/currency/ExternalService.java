package com.cube.interview.application.in.currency;

import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.coindesk.CoinDeskService;
import org.springframework.stereotype.Service;

@Service
public class ExternalService {

  private final CoinDeskService coinDeskService;

  public ExternalService(CoinDeskService coinDeskService) {
    this.coinDeskService = coinDeskService;
  }

  public CallCoinDeskOuterResponse callCoinDeskApi() {
    return coinDeskService.callCoinDesk();
  }
}
