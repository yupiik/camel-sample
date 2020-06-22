package io.yupiik.camel.example.gateway.processor.passthrough;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.osgi.service.component.annotations.Component;

@Component(
        name = "io.yupiik.camel.example.gateway.processor.passthrough",
        immediate = true,
        service = { Processor.class },
        property = "name=passthrough"
)
public class Passthrough implements Processor {

    @Override
    public void process(Exchange exchange) {

    }

}
