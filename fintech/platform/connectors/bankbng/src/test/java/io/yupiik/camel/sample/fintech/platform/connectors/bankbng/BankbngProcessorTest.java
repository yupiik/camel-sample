/*
 * Copyright (C) 2020 - Yupiik SAS - https://www.yupiik.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.yupiik.camel.sample.fintech.platform.connectors.bankbng;

import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BankbngProcessorTest extends CamelTestSupport {

    @Override
    @BeforeEach
    public void setUp() throws Exception {
        //replaceRouteFromWith("routeId", "direct:start");
        super.setUp();
    }

    @Test
    public void testProcessor() throws InterruptedException {
//        try {
            template.sendBody("direct:bankbng", "Hello World");
//            fail("Should have thrown exception");
//        } catch (CamelExecutionException e) {
//            assertEquals("Forced", e.getCause().getMessage());
//        }

        assertMockEndpointsSatisfied();
    }


    @Override
    protected RoutesBuilder createRouteBuilder() throws Exception {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // try to redeliver up till 3 times
                errorHandler(defaultErrorHandler().maximumRedeliveries(3).redeliveryDelay(0));
                from("direct:bankbng").log("${body}");
            }
        };
    }
}