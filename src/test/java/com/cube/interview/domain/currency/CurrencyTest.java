package com.cube.interview.domain.currency;

import static org.junit.jupiter.api.Assertions.*;

import com.cube.interview.domain.currency.dto.CurrencyDto;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

class CurrencyTest {

  private Currency currency;

  @BeforeEach
  void setup() {
    this.currency = new Currency();
  }

  @Test
  void create_WillCreateCurrency() {
    // Arrange
    CurrencyDto dto = new CurrencyDto();
    dto.setCode("USD");
    dto.setName("美元");
    ZonedDateTime now = ZonedDateTime.now();

    // Act
    currency = new Currency(dto);
    ReflectionTestUtils.setField(currency, "currencyMappingId", 1L);
    ReflectionTestUtils.setField(currency, "createTime", now);
    ReflectionTestUtils.setField(currency, "updateTime", now);

    // Assert
    assertEquals(dto.getCode(), currency.getCode());
    assertEquals(dto.getName(), currency.getName());
    assertEquals(now, currency.getCreateTime());
    assertEquals(now, currency.getUpdateTime());
    assertEquals(1L, currency.getCurrencyMappingId());
  }

  @Test
  void update_WillUpdateCurrency() {
    // Arrange
    CurrencyDto dto = new CurrencyDto();
    dto.setCode("USD");
    dto.setName("美元");
    ZonedDateTime now = ZonedDateTime.now();

    // Act
    currency.update(dto);
    ReflectionTestUtils.setField(currency, "currencyMappingId", 1L);
    ReflectionTestUtils.setField(currency, "createTime", now);
    ReflectionTestUtils.setField(currency, "updateTime", now);

    // Assert
    assertEquals(dto.getCode(), currency.getCode());
    assertEquals(dto.getName(), currency.getName());
    assertEquals(now, currency.getCreateTime());
    assertEquals(now, currency.getUpdateTime());
    assertEquals(1L, currency.getCurrencyMappingId());
  }
}