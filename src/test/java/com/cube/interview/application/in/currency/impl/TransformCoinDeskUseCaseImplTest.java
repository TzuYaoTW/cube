package com.cube.interview.application.in.currency.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import com.cube.interview.application.in.currency.CurrencyService;
import com.cube.interview.application.in.currency.api.TransformCoinDeskBpiDetailResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskBpiResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskTimeResponseQuery;
import com.cube.interview.application.out.coindesk.CallCoinDeskBpiDetailOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskBpiOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskTimeOuterResponse;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import com.cube.interview.domain.currency.dto.CurrencyDto;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.test.util.ReflectionTestUtils;

class TransformCoinDeskUseCaseImplTest {

  private TransformCoinDeskUseCaseImpl transformCoinDeskUseCase;

  @Mock
  private CurrencyService currencyService;

  @Mock
  private CurrencyRepository currencyRepository;

  @BeforeEach
  void setup() {
    openMocks(this);
    transformCoinDeskUseCase = new TransformCoinDeskUseCaseImpl(currencyService, currencyRepository);
  }

  @Test
  void getTransformData_WillCallCoinDesk_AndTransformData_AndReturnInfo() {

    // Arrange
    TransformCoinDeskRequestQuery requestQuery = new TransformCoinDeskRequestQuery();
    TransformCoinDeskResponseQuery responseQuery = getTransformCoinDeskResponseQuery();
    List<Currency> currencies = getCurrencies();
    CallCoinDeskOuterResponse outerResponse = getCallCoinDeskOuterResponse();

    when(currencyService.callOutboundCoinDesk()).thenReturn(outerResponse);
    when(currencyRepository.findAll()).thenReturn(currencies);

    // Act
    TransformCoinDeskResponseQuery result = transformCoinDeskUseCase.execute(requestQuery);

    // Assert
    verify(currencyRepository, times(1)).findAll();
    assertEquals(responseQuery.getBpi().getUsd().getName(), result.getBpi().getUsd().getName());
    assertEquals(responseQuery.getBpi().getGbp().getName(), result.getBpi().getGbp().getName());
    assertEquals(responseQuery.getBpi().getEur().getName(), result.getBpi().getEur().getName());
  }

  private static TransformCoinDeskResponseQuery getTransformCoinDeskResponseQuery () {
    TransformCoinDeskResponseQuery responseQuery = new TransformCoinDeskResponseQuery();
    TransformCoinDeskTimeResponseQuery time = new TransformCoinDeskTimeResponseQuery();
    time.setUpdated("2024/12/29 02:52:22");
    time.setUpdatedISO("2024/12/29 02:52:22");
    time.setUpdateduk("2024/12/29 02:52:00");
    TransformCoinDeskBpiResponseQuery bpi = new TransformCoinDeskBpiResponseQuery();
    TransformCoinDeskBpiDetailResponseQuery usd = new TransformCoinDeskBpiDetailResponseQuery();
    usd.setCode("USD");
    usd.setName("美元");
    usd.setRate("93,491.939");
    usd.setRateFloat(93491.9394);
    bpi.setUsd(usd);
    TransformCoinDeskBpiDetailResponseQuery gbp = new TransformCoinDeskBpiDetailResponseQuery();
    gbp.setCode("GBP");
    gbp.setName("英鎊");
    gbp.setRate("74,557.952");
    gbp.setRateFloat(74557.9518);
    bpi.setGbp(gbp);
    TransformCoinDeskBpiDetailResponseQuery eur = new TransformCoinDeskBpiDetailResponseQuery();
    eur.setCode("EUR");
    eur.setName("歐元");
    eur.setRate("89,693.455");
    eur.setRateFloat(89693.4554);
    bpi.setEur(eur);
    responseQuery.setBpi(bpi);
    responseQuery.setTime(time);

    return responseQuery;
  }

  private static List<Currency> getCurrencies() {
    List<Currency> currencies = new ArrayList<>();

    CurrencyDto dto = new CurrencyDto();
    dto.setCode("USD");
    dto.setName("美元");
    ZonedDateTime now = ZonedDateTime.now();
    Currency currency = new Currency(dto);
    ReflectionTestUtils.setField(currency, "currencyMappingId", 1L);
    ReflectionTestUtils.setField(currency, "createTime", now);
    ReflectionTestUtils.setField(currency, "updateTime", now);
    currencies.add(currency);

    CurrencyDto dto1 = new CurrencyDto();
    dto1.setCode("GBP");
    dto1.setName("英鎊");
    Currency currency1 = new Currency(dto1);
    ReflectionTestUtils.setField(currency1, "currencyMappingId", 2L);
    ReflectionTestUtils.setField(currency1, "createTime", now);
    ReflectionTestUtils.setField(currency1, "updateTime", now);
    currencies.add(currency1);

    CurrencyDto dto2 = new CurrencyDto();
    dto2.setCode("EUR");
    dto2.setName("歐元");
    Currency currency2 = new Currency(dto2);
    ReflectionTestUtils.setField(currency2, "currencyMappingId", 3L);
    ReflectionTestUtils.setField(currency2, "createTime", now);
    ReflectionTestUtils.setField(currency2, "updateTime", now);
    currencies.add(currency2);

    return currencies;
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
}