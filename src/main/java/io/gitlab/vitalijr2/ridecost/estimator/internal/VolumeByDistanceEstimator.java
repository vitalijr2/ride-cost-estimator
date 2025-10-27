/*-
 * ---------------LICENSE_START-----------------
 * Ride Cost Estimator
 * ---------------------------------------------
 * Copyright (C) 2025 Vitalij Berdinskih
 * ---------------------------------------------
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ---------------LICENSE_END-------------------
 */
package io.gitlab.vitalijr2.ridecost.estimator.internal;

import io.gitlab.vitalijr2.ridecost.estimator.RideCostEstimator;
import java.math.BigDecimal;
import java.math.MathContext;
import org.jetbrains.annotations.NotNull;

/**
 * Calculates the cost based on fuel consumption per 100 units of distance.
 */
public class VolumeByDistanceEstimator extends AbstractRideCostEstimator implements RideCostEstimator {

  private static final BigDecimal ONE_HUNDRED = new BigDecimal(100);

  @Override
  public @NotNull BigDecimal estimateCostOfRide(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance) throws IllegalArgumentException {
    isPositive.accept(mileage, "Mileage");
    isPositive.accept(price, "Price");
    isPositive.accept(distance, "Distance");

    return distance.divide(ONE_HUNDRED, MathContext.DECIMAL32).multiply(mileage).multiply(price);
  }

}
