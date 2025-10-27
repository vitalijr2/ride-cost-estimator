package io.gitlab.vitalijr2.ridecost.estimator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.isA;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("fast")
class RideCostEstimatorFastTest {

  @DisplayName("Estimate cost of a ride")
  @Test
  void estimateCostOfRideInPrimitives() {
    // given
    var estimator = spy(RideCostEstimator.class);

    when(estimator.estimateCostOfRide(isA(BigDecimal.class), isA(BigDecimal.class), isA(BigDecimal.class))).thenReturn(
        BigDecimal.TEN);

    // when
    var result = estimator.estimateCostOfRide(123.45d, 56.789d, 123);

    // then
    assertEquals(10d, result);
    verify(estimator).estimateCostOfRide(eq(BigDecimal.valueOf(123.45)), eq(BigDecimal.valueOf(56.789)),
        eq(BigDecimal.valueOf(123)));
  }

}
