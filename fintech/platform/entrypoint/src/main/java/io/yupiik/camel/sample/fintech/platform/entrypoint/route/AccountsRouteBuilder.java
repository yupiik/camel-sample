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
import org.osgi.service.component.annotations.Component;

@Component(
        name = "io.yupiik.camel.sample.fintech.platform.entrypoint.accounts.route",
        immediate = true,
        service = { RouteBuilder.class },
        property = "name=accounts"
)
public class AccountsRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        //TODO implement
        from("cxfrs:bean");
    }

}