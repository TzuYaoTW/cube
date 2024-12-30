package com.cube.interview.adapter.in.rest.currency.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cube.interview.application.in.currency.api.GetCoinDeskBpiDetailResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskBpiResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskTimeResponseQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskUseCase;
import com.cube.interview.application.in.currency.api.GetCurrencyDetailResponseQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListResponseQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListUseCase;
import com.cube.interview.application.in.currency.api.TransformCoinDeskBpiDetailResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskBpiResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskTimeResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskUseCase;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyQueryControllerImplTest {

  @Mock
  private GetCurrencyListUseCase getCurrencyListUseCase;
  @Mock
  private GetCoinDeskUseCase getCoinDeskUseCase;
  @Mock
  private TransformCoinDeskUseCase transformCoinDeskUseCase;

  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    CurrencyQueryControllerImpl currencyQueryController = new CurrencyQueryControllerImpl(
        getCurrencyListUseCase, getCoinDeskUseCase, transformCoinDeskUseCase);
    mockMvc = MockMvcBuilders.standaloneSetup(currencyQueryController).build();
  }

  @Test
  void getList_WillQueryCurrencyList_AndReturnInfo() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    GetCurrencyListResponseQuery responseQuery = new GetCurrencyListResponseQuery();
    List<GetCurrencyDetailResponseQuery> list = new ArrayList<>();
    GetCurrencyDetailResponseQuery detail = new GetCurrencyDetailResponseQuery();
    detail.setCurrencyMappingId(1L);
    detail.setCode("USD");
    detail.setName("美元");
    list.add(detail);
    responseQuery.setList(list);

    // Act
    // Assert
    when(getCurrencyListUseCase.execute(any())).thenReturn(responseQuery);
    mockMvc.perform(
            post("/api/currency/get/list").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.list[0].currencyMappingId").value(1))
        .andExpect(jsonPath("$.list[0].code").value("USD"))
        .andExpect(jsonPath("$.list[0].name").value("美元"));
  }

  @Test
  void getCoinDesk_WillCallCoinDesk_AndReturnInfo() throws Exception{

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

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

    // Act
    // Assert
    when(getCoinDeskUseCase.execute(any())).thenReturn(responseQuery);
    mockMvc.perform(
            post("/api/currency/get/coindesk").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.time.updated").value("Dec 29, 2024 17:46:32 UTC"))
        .andExpect(jsonPath("$.bpi.USD.code").value("USD"))
        .andExpect(jsonPath("$.bpi.EUR.symbol").value("&euro;"));
  }

  @Test
  void getCoinDesk_WillCallCoinDesk_AndReturnTransformData() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    TransformCoinDeskResponseQuery responseQuery = new TransformCoinDeskResponseQuery();
    TransformCoinDeskTimeResponseQuery time = new TransformCoinDeskTimeResponseQuery();
    time.setUpdated("2024/12/29 17:46:32");
    time.setUpdatedISO("2024/12/29 17:46:32");
    time.setUpdateduk("2024/12/29 17:46:00");
    responseQuery.setTime(time);

    TransformCoinDeskBpiResponseQuery bpi = new TransformCoinDeskBpiResponseQuery();
    TransformCoinDeskBpiDetailResponseQuery usd = new TransformCoinDeskBpiDetailResponseQuery();
    usd.setCode("USD");
    usd.setName("美元");
    usd.setRate("93,505.967");
    usd.setRateFloat(93505.9672);
    bpi.setUsd(usd);

    TransformCoinDeskBpiDetailResponseQuery gbp = new TransformCoinDeskBpiDetailResponseQuery();
    gbp.setCode("GBP");
    gbp.setName("英鎊");
    gbp.setRate("74,569.139");
    gbp.setRateFloat(74569.1387);
    bpi.setGbp(gbp);

    TransformCoinDeskBpiDetailResponseQuery eur = new TransformCoinDeskBpiDetailResponseQuery();
    eur.setCode("EUR");
    eur.setName("歐元");
    eur.setRate("89,706.913");
    eur.setRateFloat(89706.9132);
    bpi.setEur(eur);
    responseQuery.setBpi(bpi);

    // Act
    // Assert
    when(transformCoinDeskUseCase.execute(any())).thenReturn(responseQuery);
    mockMvc.perform(
            post("/api/currency/get/coindesk/trans").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.time.updated").value("2024/12/29 17:46:32"))
        .andExpect(jsonPath("$.bpi.USD.name").value("美元"))
        .andExpect(jsonPath("$.bpi.GBP.name").value("英鎊"));
  }
}