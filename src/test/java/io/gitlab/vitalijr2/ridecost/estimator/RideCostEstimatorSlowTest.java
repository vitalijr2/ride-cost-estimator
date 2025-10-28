package io.gitlab.vitalijr2.ridecost.estimator;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import io.gitlab.vitalijr2.ridecost.estimator.internal.DistanceByVolumeEstimator;
import io.gitlab.vitalijr2.ridecost.estimator.internal.VolumeByDistanceEstimator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@Tag("slow")
class RideCostEstimatorSlowTest {

  @DisplayName("Distance by volume estimator")
  @ParameterizedTest(name = "{3}")
  @CsvSource({"0,64.99,475,Mileage", "15.873,-1,475,Price", "15.873,64.99,-99,Distance"})
  void distanceByVolumeEstimator(double mileage, double price, long distance, String expectedName) {
    // when
    var estimator = assertDoesNotThrow(RideCostEstimator::distanceByVolumeEstimator, "Instance of RideCostEstimator");

    // then
    assertInstanceOf(DistanceByVolumeEstimator.class, estimator, "Distance by volume estimator");
  }

  @DisplayName("Volume by distance estimator")
  @ParameterizedTest(name = "{3}")
  @CsvSource({"0,64.99,475,Mileage", "15.873,-1,475,Price", "15.873,64.99,-99,Distance"})
  void volumeByDistanceEstimator(double mileage, double price, long distance, String expectedName) {
    // when
    var estimator = assertDoesNotThrow(RideCostEstimator::volumeByDistanceEstimator, "Instance of RideCostEstimator");

    // then
    assertInstanceOf(VolumeByDistanceEstimator.class, estimator, "Volume by distance estimator");
  }

}
