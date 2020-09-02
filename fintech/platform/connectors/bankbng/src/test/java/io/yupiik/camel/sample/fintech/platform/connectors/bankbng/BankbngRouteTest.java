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

import org.apache.camel.ExchangePattern;
import org.apache.camel.RoutesBuilder;
import org.apache.camel.test.junit5.CamelTestSupport;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

public class BankbngRouteTest extends CamelTestSupport {

    @Test
    public void test() throws Exception {
        getMockEndpoint("mock:cxfrs:http://localhost:8080/fintech/mock/bankbng/accounts").expectedMessageCount(1);
        getMockEndpoint("mock:cxfrs:http://localhost:8080/fintech/mock/bankbng/accounts").expectedHeaderReceived("Accept", "application/xml");
        getMockEndpoint("mock:cxfrs:http://localhost:8080/fintech/mock/bankbng/accounts").expectedHeaderReceived("CamelHttpMethod", "GET");

        Response response = new ResponseMock("foo");

        template.sendBody("direct-vm:bankbng", ExchangePattern.InOut, response);

        assertMockEndpointsSatisfied();
    }

    @Override
    public String isMockEndpointsAndSkip() {
        return "cxfrs:(.*)";
    }

    @Override
    protected RoutesBuilder createRouteBuilder() {
        return new BankbngRoute();
    }

}
