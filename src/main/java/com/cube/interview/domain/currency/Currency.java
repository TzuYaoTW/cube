package com.cube.interview.domain.currency;

import com.cube.interview.domain.currency.dto.CurrencyDto;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Entity
@Table(name = "CURRENCY_MAPPING")
@DynamicUpdate
public class Currency implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "CURRENCY_MAPPING_ID")
  private Long currencyMappingId;

  @Column(name = "CODE")
  private String code;

  @Column(name = "NAME")
  private String name;

  @Column(name = "CREATE_TIME")
  private ZonedDateTime createTime;

  @Column(name = "UPDATE_TIME")
  private ZonedDateTime updateTime;

  public Currency(CurrencyDto dto) {
    this.code = dto.getCode();
    this.name = dto.getName();
    this.createTime = ZonedDateTime.now();
    this.updateTime = ZonedDateTime.now();
  }

  public void update(CurrencyDto dto) {
    this.code = dto.getCode();
    this.name = dto.getName();
    this.updateTime = ZonedDateTime.now();
  }

  public Currency() {
  }

  public Long getCurrencyMappingId() {
    return currencyMappingId;
  }

  public String getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public ZonedDateTime getCreateTime() {
    return createTime;
  }

  public ZonedDateTime getUpdateTime() {
    return updateTime;
  }

  @Override
  public String toString() {
    return "Currency{" +
        "currencyMappingId=" + currencyMappingId +
        ", code='" + code + '\'' +
        ", name='" + name + '\'' +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        '}';
  }
}
