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
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

public class BankbngProcessor implements Processor {

    private static Logger logger = LoggerFactory.getLogger(BankbngProcessor.class);

    @Override
    public void process(Exchange exchange) {
        exchange.getMessage().setHeader("X-Fintech-Transform", "NextGenPSD2");
        Response response = exchange.getMessage().getBody(Response.class);//.replaceAll("</.*>", "!")
        // TODO make the transform more robust
        String transformBody = response.readEntity(String.class)
                .replaceAll("\\<\\?xml version=\"1.0\" encoding=\"UTF-8\"\\?\\>\\n", "")
                .replaceAll("\\<account\\>", "{")
                .replaceAll("\\<\\/account\\>\\n", "}")
                .replaceAll("\\<\\/.*\\>", "\",")
                .replaceAll("\\<", "\"")
                .replaceAll("\\>", "\": \"")
                .replaceAll("\\,\\n}", "\n}");
        exchange.getMessage().setBody(transformBody);
    }

}