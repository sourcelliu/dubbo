/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dubbo.metrics.registry.metrics.model.sample;

import org.apache.dubbo.metrics.model.MetricsCategory;
import org.apache.dubbo.metrics.model.sample.GaugeMetricSample;
import org.apache.dubbo.metrics.model.sample.MetricSample;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

class GaugeMetricSampleTest {

    private static String name;
    private static String description;
    private static Map<String, String> tags;
    private static MetricsCategory category;
    private static String baseUnit;
    private static Supplier<Number> supplier;

    @BeforeAll
    public static void setup() {
        name = "test";
        description = "test";
        tags = new HashMap<>();
        category = MetricsCategory.REQUESTS;
        baseUnit = "byte";
        supplier = () -> 1;
    }

    @Test
    void test() {
        GaugeMetricSample sample = new GaugeMetricSample(name, description, tags, category, baseUnit, supplier);
        Assertions.assertEquals(sample.getName(), name);
        Assertions.assertEquals(sample.getDescription(), description);
        Assertions.assertEquals(sample.getTags(), tags);
        Assertions.assertEquals(sample.getType(), MetricSample.Type.GAUGE);
        Assertions.assertEquals(sample.getCategory(), category);
        Assertions.assertEquals(sample.getBaseUnit(), baseUnit);
        Assertions.assertEquals(sample.getSupplier().get(), 1);
        sample.setSupplier(() -> 2);
        Assertions.assertEquals(sample.getSupplier().get(), 2);
    }
}
