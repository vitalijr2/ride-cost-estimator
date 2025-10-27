package io.gitlab.vitalijr2.ridecost.estimator.internal;

import java.math.BigDecimal;
import java.util.function.BiConsumer;

public class AbstractRideCostEstimator {

  protected static final BiConsumer<BigDecimal, String> isPositive = (value, name) -> {
    if (value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException(name + " must be greater than zero");
    }
  };

}
