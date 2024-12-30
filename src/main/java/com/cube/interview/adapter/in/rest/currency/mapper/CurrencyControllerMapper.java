package com.cube.interview.adapter.in.rest.currency.mapper;

import com.cube.interview.adapter.in.rest.currency.api.CreateCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.CreateCurrencyResponse;
import com.cube.interview.adapter.in.rest.currency.api.DeleteCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.DeleteCurrencyResponse;
import com.cube.interview.adapter.in.rest.currency.api.GetCoinDeskRequest;
import com.cube.interview.adapter.in.rest.currency.api.GetCoinDeskResponse;
import com.cube.interview.adapter.in.rest.currency.api.GetCurrencyListRequest;
import com.cube.interview.adapter.in.rest.currency.api.GetCurrencyListResponse;
import com.cube.interview.adapter.in.rest.currency.api.TransformCoinDeskRequest;
import com.cube.interview.adapter.in.rest.currency.api.TransformCoinDeskResponse;
import com.cube.interview.adapter.in.rest.currency.api.UpdateCurrencyRequest;
import com.cube.interview.adapter.in.rest.currency.api.UpdateCurrencyResponse;
import com.cube.interview.application.in.currency.api.CreateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.CreateCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.DeleteCurrencyResponseCommand;
import com.cube.interview.application.in.currency.api.GetCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.GetCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListRequestQuery;
import com.cube.interview.application.in.currency.api.GetCurrencyListResponseQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskRequestQuery;
import com.cube.interview.application.in.currency.api.TransformCoinDeskResponseQuery;
import com.cube.interview.application.in.currency.api.UpdateCurrencyRequestCommand;
import com.cube.interview.application.in.currency.api.UpdateCurrencyResponseCommand;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CurrencyControllerMapper {

  CreateCurrencyRequestCommand toCreateCurrencyRequestCommand(CreateCurrencyRequest request);
  CreateCurrencyResponse toCreateCurrencyResponse(CreateCurrencyResponseCommand responseCommand);

  GetCurrencyListRequestQuery toGetCurrencyListRequestQuery(GetCurrencyListRequest request);
  GetCurrencyListResponse toGetCurrencyListResponse(GetCurrencyListResponseQuery responseQuery);

  DeleteCurrencyRequestCommand toDeleteCurrencyRequestCommand(DeleteCurrencyRequest request);
  DeleteCurrencyResponse toDeleteCurrencyResponse(DeleteCurrencyResponseCommand responseCommand);

  UpdateCurrencyRequestCommand toUpdateCurrencyRequestCommand(UpdateCurrencyRequest request);
  UpdateCurrencyResponse toUpdateCurrencyResponse(UpdateCurrencyResponseCommand responseCommand);

  GetCoinDeskRequestQuery toGetCoinDeskRequestQuery(GetCoinDeskRequest request);
  GetCoinDeskResponse toGetCoinDeskResponse(GetCoinDeskResponseQuery responseQuery);

  TransformCoinDeskRequestQuery toTransformCoinDeskRequestQuery(TransformCoinDeskRequest request);
  TransformCoinDeskResponse toTransformCoinDeskResponse(TransformCoinDeskResponseQuery responseQuery);
}
