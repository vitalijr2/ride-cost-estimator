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
import java.lang.System.Logger.Level;
import java.math.BigDecimal;
import java.util.function.BiConsumer;
import org.jetbrains.annotations.NotNull;

abstract class AbstractRideCostEstimator implements RideCostEstimator {

  private static final BiConsumer<BigDecimal, String> IS_POSITIVE = (value, name) -> {
    if (value.compareTo(BigDecimal.ZERO) <= 0) {
      throw new IllegalArgumentException(name + " must be greater than zero");
    }
  };

  protected final System.Logger logger = System.getLogger(getClass().getName());

  abstract protected @NotNull BigDecimal costByMileageAndPrice(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance);

  @Override
  public @NotNull BigDecimal estimateCostOfRide(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance) throws IllegalArgumentException {
    IS_POSITIVE.accept(mileage, "Mileage");
    IS_POSITIVE.accept(price, "Price");
    IS_POSITIVE.accept(distance, "Distance");

    var cost = costByMileageAndPrice(mileage, price, distance);

    logger.log(Level.TRACE, "Mileage {0}, Price {1}, Distance {2}, Cost {3}", mileage, price, distance, cost);

    return cost;
  }

}
