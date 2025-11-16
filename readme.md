# Ride Cost Estimator

Mileage-Based Ride Cost Estimator Library.

In addition to the [GitLab page][gl-project], this project can also be found on [GitHub][gh-project].

[![Java Version][java-version]][jdk-download]
[![License][license-badge]][license-link]
![Maven Central Last Update][maven-central-last-update]
[![Maven Central][maven-central]][maven-central-link]
[![Javadoc][javadoc]][javadoc-link]  
[![GitLab master pipeline][gitlab-master-pipeline]][gitlab-master-pipeline-link]
[![Codacy Badge][codacy-badge]][codacy-badge-link]
[![Codacy Coverage][codacy-coverage]][codacy-coverage-link]
![GitLab last commit][gitlab-last-commit]
[![Today's hits][today-hits]][today-hits-link]

## How to use

This tiny library is for calculating the approximate cost of a trip.

There are [two ways to determine the cost][fuel-economy]: one is based on the amount of fuel consumed per 100 kilometers
or miles, the second uses the distance that can be traveled per unit volume (liter or gallon) of fuel. So if you are
going to calculate the cost given the number of liters or gallons that your car consumes per 100 kilometers or miles,
the corresponding instance of the estimator can be obtained through the `RideCostEstimator.volumeByDistanceEstimator()`.
And if you know how much distance you can travel on one liter or gallon, then the instance of the estimator can
be obtained through `RideCostEstimator.distanceByVolumeEstimator()`.

The next step is the same for both cost calculation methods. Let's assume that the mileage is **123.45**, either liters
per kilometer or miles per gallon, the price is **56.78**, and the trip distance is **123** kilometers or miles:

```java
var cost = estimator.estimateCostOfRide(123.45d, 56.789d, 123);
```

All three parameters must be positive, otherwise the method will throw an `IllegalArgumentException`.

## Contributing

Please read [Contributing](contributing.md).

## History

See [Changelog](changelog.md)

## License

```text
Copyright (C) 2024 Vitalij Berdinskih

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

See full text [here](LICENSE "the LICENSE file").

[gl-project]: https://gitlab.com/ride-cost/ride-cost-estimator

[gh-project]: https://github.com/vitalijr2/ride-cost-estimator

[java-version]: https://img.shields.io/static/v1?label=Java&message=17&color=blue&logoColor=E23D28

[jdk-download]: https://www.oracle.com/java/technologies/downloads/#java17

[license-badge]: https://img.shields.io/badge/license-Apache%202.0-blue.svg?style=flat

[license-link]: https://www.apache.org/licenses/LICENSE-2.0.html

[maven-central-last-update]: https://img.shields.io/maven-central/last-update/io.gitlab.vitalijr2.ridecost/ride-cost-estimator

[maven-central]: https://img.shields.io/maven-central/v/io.gitlab.vitalijr2.ridecost/ride-cost-estimator

[maven-central-link]: https://central.sonatype.com/artifact/io.gitlab.vitalijr2.ridecost/ride-cost-estimator?smo=true

[javadoc]: https://javadoc.io/badge2/io.gitlab.vitalijr2.ridecost/ride-cost-estimator/javadoc.svg

[javadoc-link]: https://javadoc.io/doc/io.gitlab.vitalijr2.ridecost/ride-cost-estimator

[gitlab-master-pipeline]: https://gitlab.com/ride-cost/ride-cost-estimator/badges/master/pipeline.svg

[gitlab-master-pipeline-link]: https://gitlab.com/ride-cost/ride-cost-estimator/-/commits/master

[codacy-badge]: https://app.codacy.com/project/badge/Grade/fe0ead7ccfea4ffdb1f2c2b18decfa9e

[codacy-badge-link]: https://app.codacy.com/gl/ride-cost/ride-cost-estimator/dashboard?utm_source=gl&utm_medium=referral&utm_content=&utm_campaign=Badge_grade

[codacy-coverage]: https://app.codacy.com/project/badge/Coverage/fe0ead7ccfea4ffdb1f2c2b18decfa9e

[codacy-coverage-link]: https://app.codacy.com/gl/ride-cost/ride-cost-estimator/dashboard?utm_source=gl&utm_medium=referral&utm_content=&utm_campaign=Badge_coverage

[gitlab-last-commit]: https://img.shields.io/gitlab/last-commit/vitalijr2/ride-cost-estimator

[today-hits]: https://hits.sh/github.com/vitalijr2/ride-cost-estimator.svg?view=today-total&label=today's%20hits

[today-hits-link]: https://hits.sh/github.com/vitalijr2/ride-cost-estimators/

[fuel-economy]: https://en.wikipedia.org/wiki/Fuel_economy_in_automobiles "Fuel economy in automobiles"
