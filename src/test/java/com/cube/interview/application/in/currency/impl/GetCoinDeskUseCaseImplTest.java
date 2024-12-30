package com.cube.interview.application.in.currency.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.GetCoinDeskBpiDetailResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskBpiResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskTimeResponseQuery;
import com.cube.interview.application.in.currency.mapper.CurrencyUseCaseMapper;
import com.cube.interview.application.out.coindesk.CallCoinDeskBpiDetailOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskBpiOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskTimeOuterResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class GetCoinDeskUseCaseImplTest {
  private GetCoinDeskUseCaseImpl getCoinDeskUseCase;

  @Mock
  private CurrencyService currencyService;
  @Mock
  private CurrencyUseCaseMapper mapper;

  @BeforeEach
  void setup() {
    openMocks(this);
    getCoinDeskUseCase = new GetCoinDeskUseCaseImpl(currencyService);
  }

  @Test
  void getCoinDesk_WillCallCoinDesk_AndReturnInfo() {
    // Arrange
    GetCoinDeskRequestQuery requestQuery = new GetCoinDeskRequestQuery();
    CallCoinDeskOuterResponse outerResponse = getCallCoinDeskOuterResponse();
    GetCoinDeskResponseQuery responseQuery = getCoinDeskBpiResponseQuery();

    when(currencyService.callOutboundCoinDesk()).thenReturn(outerResponse);
    when(mapper.toGetCoinDeskResponseQuery(outerResponse)).thenReturn(responseQuery);

    // Act
    getCoinDeskUseCase.execute(requestQuery);

    // Assert
    verify(currencyService, times(1)).callOutboundCoinDesk();
  }

  private static CallCoinDeskOuterResponse getCallCoinDeskOuterResponse() {

    CallCoinDeskOuterResponse outerResponse = new CallCoinDeskOuterResponse();
    CallCoinDeskTimeOuterResponse time = new CallCoinDeskTimeOuterResponse();
    time.setUpdated("Dec 29, 2024 17:46:32 UTC");
    time.setUpdatedISO("2024-12-29T17:46:32+00:00");
    time.setUpdateduk("Dec 29, 2024 at 17:46 GMT");
    outerResponse.setTime(time);
    outerResponse.setDisclaimer("This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org");
    outerResponse.setChartName("Bitcoin");

    CallCoinDeskBpiOuterResponse bpi = new CallCoinDeskBpiOuterResponse();
    CallCoinDeskBpiDetailOuterResponse usd = new CallCoinDeskBpiDetailOuterResponse();
    usd.setCode("USD");
    usd.setSymbol("&#36");
    usd.setRate("93,505.967");
    usd.setDescription("United States Dollar");
    usd.setRateFloat(93505.9672);
    bpi.setUsd(usd);

    CallCoinDeskBpiDetailOuterResponse gbp = new CallCoinDeskBpiDetailOuterResponse();
    gbp.setCode("GBP");
    gbp.setSymbol("&pound");
    gbp.setRate("74,569.139");
    gbp.setDescription("British Pound Sterling");
    gbp.setRateFloat(74569.1387);
    bpi.setGbp(gbp);

    CallCoinDeskBpiDetailOuterResponse eur = new CallCoinDeskBpiDetailOuterResponse();
    eur.setCode("EUR");
    eur.setSymbol("&euro;");
    eur.setRate("89,706.913");
    eur.setDescription("Euro");
    eur.setRateFloat(89706.9132);
    bpi.setEur(eur);
    outerResponse.setBpi(bpi);
    return outerResponse;
  }

  private static GetCoinDeskResponseQuery getCoinDeskBpiResponseQuery() {
    GetCoinDeskResponseQuery responseQuery = new GetCoinDeskResponseQuery();
    GetCoinDeskTimeResponseQuery time = new GetCoinDeskTimeResponseQuery();
    time.setUpdated("Dec 29, 2024 17:46:32 UTC");
    time.setUpdatedISO("2024-12-29T17:46:32+00:00");
    time.setUpdateduk("Dec 29, 2024 at 17:46 GMT");
    responseQuery.setTime(time);
    responseQuery.setDisclaimer("This data was produced from the CoinDesk Bitcoin Price Index (USD). Non-USD currency data converted using hourly conversion rate from openexchangerates.org");
    responseQuery.setChartName("Bitcoin");

    GetCoinDeskBpiResponseQuery bpi = new GetCoinDeskBpiResponseQuery();
    GetCoinDeskBpiDetailResponseQuery usd = new GetCoinDeskBpiDetailResponseQuery();
    usd.setCode("USD");
    usd.setSymbol("&#36");
    usd.setRate("93,505.967");
    usd.setDescription("United States Dollar");
    usd.setRateFloat(93505.9672);
    bpi.setUsd(usd);

    GetCoinDeskBpiDetailResponseQuery gbp = new GetCoinDeskBpiDetailResponseQuery();
    gbp.setCode("GBP");
    gbp.setSymbol("&pound");
    gbp.setRate("74,569.139");
    gbp.setDescription("British Pound Sterling");
    gbp.setRateFloat(74569.1387);
    bpi.setGbp(gbp);

    GetCoinDeskBpiDetailResponseQuery eur = new GetCoinDeskBpiDetailResponseQuery();
    eur.setCode("EUR");
    eur.setSymbol("&euro;");
    eur.setRate("89,706.913");
    eur.setDescription("Euro");
    eur.setRateFloat(89706.9132);
    bpi.setEur(eur);

    responseQuery.setBpi(bpi);

    return responseQuery;
  }
}