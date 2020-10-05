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
package io.yupiik.camel.sample.idempotent.file1;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.support.processor.idempotent.FileIdempotentRepository;

import java.io.File;

public class Route extends RouteBuilder {

    @Override
    public void configure() {
        from("file:/tmp/input")
                .idempotentConsumer(header("CamelFileName"), FileIdempotentRepository.fileIdempotentRepository(new File("/tmp/track.txt")))
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        System.out.println("This file is being processed the first time -- " + exchange.getIn().getHeader("CamelFileName"));
                    }
                }).to("file:/tmp/output");
    }

}
