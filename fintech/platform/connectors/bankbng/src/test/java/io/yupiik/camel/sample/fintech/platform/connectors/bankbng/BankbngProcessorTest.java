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

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.DefaultExchange;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.*;

public class BankbngProcessorTest {

    @Test
    public void testSimpleBody() {
        BankbngProcessor processor = new BankbngProcessor();

        DefaultCamelContext camelContext = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(camelContext);
        Response response = new ResponseMock("foo");
        exchange.getMessage().setBody(response, Response.class);
        processor.process(exchange);

        Assertions.assertEquals("NextGenPSD2", exchange.getMessage().getHeader("X-Fintech-Transform"));
        Assertions.assertEquals("foo", exchange.getMessage().getBody());
    }

    @Test
    public void testTransformedBody() {
        BankbngProcessor processor = new BankbngProcessor();

        DefaultCamelContext camelContext = new DefaultCamelContext();
        Exchange exchange = new DefaultExchange(camelContext);
        Response response = new ResponseMock("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<account><foo>bar</foo></account>\n");
        exchange.getMessage().setBody(response, Response.class);
        processor.process(exchange);

        Assertions.assertEquals("NextGenPSD2", exchange.getMessage().getHeader("X-Fintech-Transform"));
        Assertions.assertEquals("{\"foo\": \"bar\",}", exchange.getMessage().getBody());
    }

}