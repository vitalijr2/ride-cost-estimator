package io.gitlab.vitalijr2.ridecost.estimator.internal;

import io.gitlab.vitalijr2.ridecost.estimator.RideCostEstimator;
import java.math.BigDecimal;
import java.math.MathContext;
import org.jetbrains.annotations.NotNull;

/**
 * Calculates the cost based on distance for 1 unit of fuel.
 */
public class DistanceByVolumeEstimator implements RideCostEstimator {

  @Override
  public @NotNull BigDecimal estimateCostOfRide(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance) {
    return distance.divide(mileage, MathContext.DECIMAL32).multiply(price);
  }

}
