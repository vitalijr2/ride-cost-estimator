package io.gitlab.vitalijr2.ridecost.estimator.internal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@Tag("fast")
class AbstractRideCostEstimatorTest {

  private AbstractRideCostEstimator estimator;

  @BeforeEach
  void setUp() {
    estimator = new AbstractRideCostEstimator() {
      @Override
      protected @NotNull BigDecimal costByMileageAndPrice(@NotNull BigDecimal mileage, @NotNull BigDecimal price,
          @NotNull BigDecimal distance) {
        throw new UnsupportedOperationException();
      }
    };
  }

  @DisplayName("All parameters must be positive")
  @ParameterizedTest(name = "{3}")
  @CsvSource({"0,64.99,475,Mileage", "15.873,-1,475,Price", "15.873,64.99,-99,Distance"})
  void allParametersMustBePositive(double mileage, double price, long distance, String expectedName) {
    // when
    var exception = assertThrows(IllegalArgumentException.class,
        () -> estimator.estimateCostOfRide(mileage, price, distance));

    // then
    assertThat(exception.getMessage(), startsWith(expectedName));
  }

}