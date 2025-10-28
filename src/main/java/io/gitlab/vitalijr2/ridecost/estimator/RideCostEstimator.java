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
package io.gitlab.vitalijr2.ridecost.estimator;

import io.gitlab.vitalijr2.ridecost.estimator.internal.DistanceByVolumeEstimator;
import io.gitlab.vitalijr2.ridecost.estimator.internal.VolumeByDistanceEstimator;
import java.math.BigDecimal;
import org.jetbrains.annotations.NotNull;

/**
 * Mileage-Based Ride Cost Estimator.
 * <p>
 * There are two ways to determine the cost: one is based on the amount of fuel consumed per 100 kilometers or miles,
 * the second uses the distance that can be traveled per unit volume (liter or gallon) of fuel. So if you are going to
 * calculate the cost given the number of liters or gallons that your car consumes per 100 kilometers or miles, the
 * corresponding instance of the estimator can be obtained through the
 * {@link #volumeByDistanceEstimator() volumeByDistanceEstimator()}. And if you know how much distance you can travel on
 * one liter or gallon, then the instance of the estimator can be obtained through
 * {@link #distanceByVolumeEstimator() distanceByVolumeEstimator()}.
 * <p>
 * The next step is the same for both cost calculation methods. Let's assume that the mileage is
 * <strong>123.45</strong>, either liters per kilometer or miles per gallon, the price is <strong>56.78</strong>, and
 * the trip distance is <strong>123</strong> kilometers or miles:
 * <pre><code class="language-java">
 * var cost = estimator.estimateCostOfRide(123.45d, 56.789d, 123);
 * </code></pre>
 * All three parameters must be positive, otherwise the method will throw an {@linkplain IllegalArgumentException}.
 *
 * @see <a href="https://en.wikipedia.org/wiki/Fuel_economy_in_automobiles">Fuel economy in automobiles</a>
 */
public interface RideCostEstimator {

  /**
   * Get an estimator that calculates the cost based on distance for 1 unit of fuel. Can be used for calculations based
   * on MPG and kilometers per liter.
   *
   * @return the distance-by-volume estimator
   */
  static @NotNull RideCostEstimator distanceByVolumeEstimator() {
    return new DistanceByVolumeEstimator();
  }

  /**
   * Get an estimator that calculates the cost based on fuel consumption per 100 units of distance. Can be used for
   * calculations based on liters per 100 kilometers or gallons per 100 miles.
   *
   * @return the volume-by-distance estimator
   */
  static @NotNull RideCostEstimator volumeByDistanceEstimator() {
    return new VolumeByDistanceEstimator();
  }

  /**
   * Estimate cost of a ride.
   *
   * @param mileage  fuel economy
   * @param price    fuel price
   * @param distance length of a ride
   * @return cost of a ride
   * @throws IllegalArgumentException if any parameter isn't positive.
   */
  default double estimateCostOfRide(double mileage, double price, long distance) throws IllegalArgumentException {
    return estimateCostOfRide(BigDecimal.valueOf(mileage), BigDecimal.valueOf(price),
        BigDecimal.valueOf(distance)).doubleValue();
  }

  /**
   * Estimate cost of a ride.
   *
   * @param mileage  fuel economy
   * @param price    fuel price
   * @param distance length of a ride
   * @return cost of a ride
   * @throws IllegalArgumentException if any parameter isn't positive.
   */
  @NotNull BigDecimal estimateCostOfRide(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance) throws IllegalArgumentException;


}
