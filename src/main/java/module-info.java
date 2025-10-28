/**
 * Mileage-Based Ride Cost Estimator Library.
 * <p>
 * This tiny library is for calculating the approximate cost of a trip.
 * <p>
 * There are [two ways to determine the cost][fuel-economy]: one is based on the amount of fuel consumed per 100
 * kilometers or miles, the second uses the distance that can be traveled per unit volume (liter or gallon) of fuel. So
 * if you are going to calculate the cost given the number of liters or gallons that your car consumes per 100
 * kilometers or miles, the corresponding instance of the estimator can be obtained through the
 * {@link io.gitlab.vitalijr2.ridecost.estimator.RideCostEstimator#volumeByDistanceEstimator()
 * volumeByDistanceEstimator()}. And if you know how much distance you can travel on one liter or gallon, then the
 * instance of the estimator can be obtained through
 * {@link io.gitlab.vitalijr2.ridecost.estimator.RideCostEstimator#distanceByVolumeEstimator()
 * distanceByVolumeEstimator()}.
 * <p>
 * The next step is the same for both cost calculation methods. Let's assume that the mileage is
 * <strong>123.45</strong>, either liters per kilometer or miles per gallon, the price is <strong>56.78</strong>, and
 * the trip distance is <strong>123</strong> kilometers or miles:
 * <pre><code class="language-java">
 * var cost = estimator.estimateCostOfRide(123.45d, 56.789d, 123);
 * </code></pre>
 * All three parameters must be positive, otherwise the method will throw an {@linkplain IllegalArgumentException}.
 */
module ride.cost.estimator {
  requires org.jetbrains.annotations;
  exports io.gitlab.vitalijr2.ridecost.estimator;
}
