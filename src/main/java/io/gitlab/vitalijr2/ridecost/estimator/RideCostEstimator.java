package io.gitlab.vitalijr2.ridecost.estimator;

import io.gitlab.vitalijr2.ridecost.estimator.internal.DistanceByVolumeEstimator;
import io.gitlab.vitalijr2.ridecost.estimator.internal.VolumeByDistanceEstimator;
import java.math.BigDecimal;
import org.jetbrains.annotations.NotNull;

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
   */
  default double estimateCostOfRide(double mileage, double price, long distance) {
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
   */
  @NotNull BigDecimal estimateCostOfRide(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
      @NotNull BigDecimal distance);


}
