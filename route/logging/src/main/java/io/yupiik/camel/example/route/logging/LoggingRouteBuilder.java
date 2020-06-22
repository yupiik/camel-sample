package io.yupiik.camel.example.route.logging;

import org.apache.camel.builder.RouteBuilder;
import org.osgi.service.component.annotations.Component;

@Component(
        name = "io.yupiik.camel.example.gateway.route.logging",
        immediate = true,
        service = { RouteBuilder.class }
)
public class LoggingRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct-vm:logging").routeId("logging")
                .log("This is a test");
    }

}
