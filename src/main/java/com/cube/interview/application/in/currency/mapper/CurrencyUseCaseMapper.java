package com.cube.interview.application.in.currency.mapper;

import com.cube.interview.adapter.in.rest.currency.api.GetCoinDeskResponse;
import com.cube.interview.application.in.currency.api.CreateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyDetailResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskTimeResponseQuery;
import com.cube.interview.application.in.currency.api.UpdateCurrencyDetailResponseCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyRequestCommand;
import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskTimeOuterResponse;
import com.cube.interview.domain.currency.Currency;
import com.cube.interview.domain.currency.dto.CurrencyDto;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CurrencyUseCaseMapper {


  CurrencyDto toCurrencyDto(CreateCurrencyRequestCommand requestCommand);

  CurrencyDto toCurrencyDto(UpdateCurrencyRequestCommand requestCommand);

  List<GetCurrencyDetailResponseQuery> toGetCurrencyListResponseQuery(List<Currency> currency);

  @Mapping(source = "createTime", target = "createTime", qualifiedByName = "zonedDateTimeToString")
  @Mapping(source = "updateTime", target = "updateTime", qualifiedByName = "zonedDateTimeToString")
  UpdateCurrencyDetailResponseCommand toUpdateCurrencyDetailResponseCommand(Currency currency);

  GetCoinDeskResponseQuery toGetCoinDeskResponseQuery(CallCoinDeskOuterResponse outerResponse);

  TransformCoinDeskResponseQuery toTransformCoinDeskResponseQuery(
      CallCoinDeskOuterResponse outerResponse);

  @Mapping(source = "updated", target = "updated", qualifiedByName = "updatedFormat")
  @Mapping(source = "updatedISO", target = "updatedISO", qualifiedByName = "updatedISOFormat")
  @Mapping(source = "updateduk", target = "updateduk", qualifiedByName = "updatedukFormat")
  TransformCoinDeskTimeResponseQuery toTransformCoinDeskTimeResponseQuery(
      CallCoinDeskTimeOuterResponse outerResponse);

  @Named("zonedDateTimeToString")
  default String zonedDateTimeToString(ZonedDateTime date) {
    return date == null ? null : date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss"));
  }

  @Named("updatedISOFormat")
  default String updatedISOFormat(String dateStr) {
    DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
    DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    if (dateStr == null || dateStr.isEmpty()) {
      return null;
    }
    ZonedDateTime zonedDateTime = ZonedDateTime.parse(dateStr, INPUT_FORMAT);
    return zonedDateTime.format(OUTPUT_FORMAT);
  }

  @Named("updatedFormat")
  default String updatedFormat(String dateStr) {
    DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d, yyyy HH:mm:ss 'UTC'",
        Locale.ENGLISH);
    DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    if (dateStr == null || dateStr.isEmpty()) {
      return null;
    }
    LocalDateTime dateTime = LocalDateTime.parse(dateStr, INPUT_FORMAT);
    return dateTime.format(OUTPUT_FORMAT);
  }

  @Named("updatedukFormat")
  default String updatedukFormat(String dateStr) {
    DateTimeFormatter INPUT_FORMAT = DateTimeFormatter.ofPattern("MMM d, yyyy 'at' HH:mm z",
        Locale.ENGLISH);
    DateTimeFormatter OUTPUT_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    if (dateStr == null || dateStr.isEmpty()) {
      return null;
    }
    LocalDateTime dateTime = LocalDateTime.parse(dateStr, INPUT_FORMAT);
    return dateTime.format(OUTPUT_FORMAT);
  }
}
