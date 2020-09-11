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
package io.yupiik.camel.sample.fintech.platform.entrypoint.route;

import org.apache.camel.builder.RouteBuilder;

public class AccountsRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("cxfrs://http://0.0.0.0:8282/fintech?resourceClasses=io.yupiik.camel.sample.fintech.platform.entrypoint.api.AccountsEndpoint&providers=provider.jackson&features=#openapi&performInvocation=true")
                .id("account-main-route")
                .log("message received from main entrypoint")
                .process(new AccountsProcessor())
                .log("routing slip on X-Fintech-Route-Redirect header")
                .routingSlip().header("X-Fintech-Route-Redirect");
    }

}
