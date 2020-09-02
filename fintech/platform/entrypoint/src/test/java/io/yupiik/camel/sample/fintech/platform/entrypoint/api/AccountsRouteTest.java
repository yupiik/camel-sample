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
package io.yupiik.camel.sample.fintech.platform.entrypoint.api;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import io.yupiik.camel.sample.fintech.platform.entrypoint.route.AccountsRoute;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.directvm.DirectVmConsumerNotAvailableException;
import org.apache.camel.support.SimpleRegistry;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AccountsRouteTest extends CamelTestSupport {

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountsRouteTest.class);

    private void requestEntryPoint(String bank, boolean includeHeader) throws Exception {
        HttpURLConnection client = (HttpURLConnection) new URL("http://localhost:8282/fintech/accounts/accounts").openConnection();
        client.setDoInput(true);
        client.setDoOutput(true);
        client.setRequestMethod("GET");
        if (includeHeader) {
            client.setRequestProperty("X-Fintech-Bank", bank);
        }
        StringBuilder buffer = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
        }
        LOGGER.info("Received: {}", buffer.toString());
    }

    @Test
    public void testWithKnownBank() throws Exception {
        requestEntryPoint("foo", true);

        getMockEndpoint("mock:foo").expectedMessageCount(1);

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testWithUnknownBank() {
        try {
            requestEntryPoint("bar", true);

            getMockEndpoint("mock:foo").expectedMessageCount(0);

            assertMockEndpointsSatisfied(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            // expected
            LOGGER.info("Got expected exception");
            e.printStackTrace();
            return;
        }
        Assertions.fail("Exception expected");
    }

    @Test
    public void testWithoutBank() throws Exception {
        requestEntryPoint(null, false);

        getMockEndpoint("mock:foo").expectedMessageCount(0);

        assertMockEndpointsSatisfied(2, TimeUnit.SECONDS);
    }

    @Override
    protected RoutesBuilder[] createRouteBuilders() throws Exception {
        context.getRegistry().bind("provider.jackson", new JacksonJsonProvider());
        RoutesBuilder[] builder = new RoutesBuilder[2];
        builder[0] = new AccountsRoute();
        builder[1] = new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("direct-vm:foo").id("foo-bank").log("Calling FOO bank").to("mock:foo");
            }
        };
        return builder;
    }

}
