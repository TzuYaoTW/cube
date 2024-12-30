package com.cube.interview.adapter.out.coindesk.impl;

import com.cube.interview.adapter.out.coindesk.CoinDeskMapper;
import com.cube.interview.adapter.out.coindesk.api.CallCoinDeskResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.coindesk.CoinDeskService;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CoinDeskServiceImpl implements CoinDeskService {

  private static final Logger log = LoggerFactory.getLogger(CoinDeskServiceImpl.class);
  private static final CoinDeskMapper mapper = Mappers.getMapper(CoinDeskMapper.class);

  private final RestTemplate restTemplate;

  @Autowired
  public CoinDeskServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Override
  public CallCoinDeskOuterResponse callCoinDesk() {

    String url = "https://api.coindesk.com/v1/bpi/currentprice.json";
    log.info(">>> call coindesk, url:{}", url);
    CallCoinDeskResponse response = restTemplate.getForObject(url, CallCoinDeskResponse.class);
    log.info(">>> call outbound {}", response);
    return mapper.toCallCoinDeskOuterResponse(response);
  }
}
