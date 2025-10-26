package io.gitlab.vitalijr2.ridecost.estimator.internal;

import io.gitlab.vitalijr2.ridecost.estimator.RideCostEstimator;
import java.math.BigDecimal;
import java.math.MathContext;
import org.jetbrains.annotations.NotNull;

/**
 * Calculates the cost based on fuel consumption per 100 units of distance.
 */
public class VolumeByDistanceEstimator implements RideCostEstimator {

  private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

  @Override
  public @NotNull BigDecimal estimateCostOfRide(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance) {
    return distance.divide(ONE_HUNDRED, MathContext.DECIMAL32).multiply(mileage).multiply(price);
  }

}
