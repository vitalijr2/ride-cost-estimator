package io.gitlab.vitalijr2.ridecost.estimator;


import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import io.gitlab.vitalijr2.ridecost.estimator.internal.DistanceByVolumeEstimator;
import io.gitlab.vitalijr2.ridecost.estimator.internal.VolumeByDistanceEstimator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("slow")
class RideCostEstimatorSlowTest {

  @DisplayName("Distance by volume estimator")
  @Test
  void distanceByVolumeEstimator() {
    // when
    var estimator = RideCostEstimator.distanceByVolumeEstimator();

    // then
    assertAll("Distance by volume estimator", () -> assertNotNull(estimator),
        () -> assertInstanceOf(DistanceByVolumeEstimator.class, estimator));
  }

  @DisplayName("Volume by distance estimator")
  @Test
  void volumeByDistanceEstimator() {
    // when
    var estimator = RideCostEstimator.volumeByDistanceEstimator();

    // then
    assertAll("Volume by distance estimator", () -> assertNotNull(estimator),
        () -> assertInstanceOf(VolumeByDistanceEstimator.class, estimator));
  }

}