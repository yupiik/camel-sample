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

import io.yupiik.camel.sample.fintech.platform.entrypoint.route.AccountsProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AccountsProcessorTest {

    @Test
    public void testWithExpectedHeader() {
        AccountsProcessor processor = new AccountsProcessor();

        DefaultCamelContext camelContext = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(camelContext);
        exchange.getIn().setHeader("X-Fintech-Bank", "TEST");
        processor.process(exchange);

        assertEquals("direct-vm:TEST", exchange.getIn().getHeader("X-Fintech-Route-Redirect"));
    }

    @Test
    public void testWithNoHeader() {
        AccountsProcessor processor = new AccountsProcessor();

        DefaultCamelContext camelContext = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(camelContext);
        processor.process(exchange);

        assertNull(exchange.getIn().getHeader("X-Fintech-Route-Redirect"));
    }

    @Test
    public void testEmptyHeader() {
        AccountsProcessor processor = new AccountsProcessor();

        DefaultCamelContext camelContext = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(camelContext);
        exchange.getIn().setHeader("X-Fintech-Bank", null);
        processor.process(exchange);

        assertNull(exchange.getIn().getHeader("X-Fintech-Route-Redirect"));
    }

}
