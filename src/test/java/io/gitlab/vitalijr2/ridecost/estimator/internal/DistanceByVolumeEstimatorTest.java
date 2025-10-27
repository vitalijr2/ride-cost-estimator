package io.gitlab.vitalijr2.ridecost.estimator.internal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
class DistanceByVolumeEstimatorTest {

  @DisplayName("Happy path")
  @Test
  void estimateCostOfRide() {
    // given
    var estimator = new DistanceByVolumeEstimator();

    // when
    var actualCost = estimator.estimateCostOfRide(15.873, 64.99, 475);

    // then
    assertEquals(1944.8276997, actualCost);
  }

}
