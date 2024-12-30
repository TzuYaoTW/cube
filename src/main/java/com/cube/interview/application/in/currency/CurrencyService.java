package com.cube.interview.application.in.currency;

import com.cube.interview.application.out.coindesk.CallCoinDeskOuterResponse;
import com.cube.interview.application.out.repository.currency.api.CurrencyRepository;
import com.cube.interview.domain.currency.Currency;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

  private final CurrencyRepository currencyRepository;
  private final ExternalService externalService;

  public CurrencyService(CurrencyRepository currencyRepository, ExternalService externalService) {
    this.currencyRepository = currencyRepository;
    this.externalService = externalService;
  }

  public boolean validateUniqueCodeAndName(Long id, String code, String name) {
    Optional<Currency> byName = currencyRepository.findByName(name);
    Optional<Currency> byCode = currencyRepository.findByCode(code);

    if (byName.isPresent()) {
      if (byName.get().getCurrencyMappingId() != id) {
        return true;
      }
    }
    if (byCode.isPresent()) {
      if (byCode.get().getCurrencyMappingId() != id) {
        return true;
      }
    }
    return false;
  }

  public CallCoinDeskOuterResponse callOutboundCoinDesk() {
    return externalService.callCoinDeskApi();
  }
}
