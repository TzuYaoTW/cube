package com.cube.interview.adapter.in.rest.currency.impl;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.cube.interview.adapter.in.rest.currency.api.CreateCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.DeleteCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.UpdateCurrencyRequest;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyUseCase;
import com.cube.interview.application.in.currency.api.DeleteCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyUseCase;
import com.cube.interview.application.in.currency.api.UpdateCurrencyDetailResponseCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@AutoConfigureMockMvc
class CurrencyControllerImplTest {

  @Autowired
  private ObjectMapper objectMapper;

  @Mock
  private CreateCurrencyUseCase createCurrencyUseCase;
  @Mock
  private DeleteCurrencyUseCase deleteCurrencyUseCase;
  @Mock
  private UpdateCurrencyUseCase updateCurrencyUseCase;


  private MockMvc mockMvc;

  @BeforeEach
  void setup() {
    CurrencyControllerImpl currencyController = new CurrencyControllerImpl(createCurrencyUseCase,
        deleteCurrencyUseCase, updateCurrencyUseCase);
    mockMvc = MockMvcBuilders.standaloneSetup(currencyController).build();
  }

  @Test
  void create_WillCreateCurrency_AndWillReturn_200_AndMessage() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    CreateCurrencyRequest request = new CreateCurrencyRequest();
    request.setCode("TWD");
    request.setName("台幣");
    String requestString = objectMapper.writeValueAsString(request);

    CreateCurrencyResponseCommand responseCommand = new CreateCurrencyResponseCommand();
    responseCommand.setMessage("新增成功");

    // Act
    // Assert
    when(createCurrencyUseCase.execute(any())).thenReturn(responseCommand);
    mockMvc.perform(
            post("/api/currency/create").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("新增成功"));
  }

  @Test
  void create_RequestIsNull_AndWillReturn_400() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    CreateCurrencyRequest request = new CreateCurrencyRequest();
    request.setCode("");
    request.setName("");
    String requestString = objectMapper.writeValueAsString(request);

    CreateCurrencyResponseCommand responseCommand = new CreateCurrencyResponseCommand();

    // Act
    // Assert
    when(createCurrencyUseCase.execute(any())).thenReturn(responseCommand);
    mockMvc.perform(
            post("/api/currency/create").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
        .andExpect(status().isBadRequest());
  }

  @Test
  void delete_WillDeleteCurrency_AndWillReturn_200_AndMessage() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    DeleteCurrencyRequest request = new DeleteCurrencyRequest();
    request.setCurrencyMappingId("1");
    String requestString = objectMapper.writeValueAsString(request);

    DeleteCurrencyResponseCommand responseCommand = new DeleteCurrencyResponseCommand();
    responseCommand.setMessage("刪除成功");

    // Act
    // Assert
    when(deleteCurrencyUseCase.execute(any())).thenReturn(responseCommand);
    mockMvc.perform(
            post("/api/currency/delete").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("刪除成功"));
  }

  @Test
  void update_WillUpdateCurrency_AndWillReturn_200_AndInfo() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    UpdateCurrencyRequest request = new UpdateCurrencyRequest();
    request.setCurrencyMappingId("3");
    request.setCode("TWD");
    request.setName("台幣");

    String requestString = objectMapper.writeValueAsString(request);

    UpdateCurrencyResponseCommand responseCommand = new UpdateCurrencyResponseCommand();
    responseCommand.setMessage("更新成功");
    UpdateCurrencyDetailResponseCommand data = new UpdateCurrencyDetailResponseCommand();
    data.setCurrencyMappingId(3L);
    data.setCode("TWD");
    data.setName("台幣");
    data.setUpdateTime("2024/12/30 18:59:53");
    data.setCreateTime("2024/12/29 14:45:30");
    responseCommand.setData(data);

    // Act
    // Assert
    when(updateCurrencyUseCase.execute(any())).thenReturn(responseCommand);
    mockMvc.perform(
            post("/api/currency/update").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.message").value("更新成功"))
        .andExpect(jsonPath("$.data.currencyMappingId").value(3L))
        .andExpect(jsonPath("$.data.createTime").value("2024/12/29 14:45:30"));
  }

  @Test
  void update_RequestIsNull_AndWillReturn_400() throws Exception {

    // Arrange
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(HttpHeaders.CONTENT_TYPE, "application/json");

    UpdateCurrencyRequest request = new UpdateCurrencyRequest();
    request.setCurrencyMappingId("");
    request.setCode("");
    request.setName("");

    String requestString = objectMapper.writeValueAsString(request);

    UpdateCurrencyResponseCommand responseCommand = new UpdateCurrencyResponseCommand();

    // Act
    // Assert
    when(updateCurrencyUseCase.execute(any())).thenReturn(responseCommand);
    mockMvc.perform(
            post("/api/currency/update").headers(httpHeaders).contentType(MediaType.APPLICATION_JSON)
                .content(requestString))
        .andExpect(status().isBadRequest());
  }
}