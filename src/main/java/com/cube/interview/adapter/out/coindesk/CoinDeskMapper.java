package com.cube.interview.adapter.out.coindesk;

import com.cube.interview.adapter.out.coindesk.api.CallCoinDeskResponse;
import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CoinDeskMapper {
  CallCoinDeskOuterResponse toCallCoinDeskOuterResponse(CallCoinDeskResponse response);
}
