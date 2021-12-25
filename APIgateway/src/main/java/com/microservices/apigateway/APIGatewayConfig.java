package com.microservices.apigateway;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class APIGatewayConfig {
    //with this class we create custom routes

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        Function<PredicateSpec, Buildable<Route>> routeFun
                = predicateSpec -> predicateSpec.path("/get")
                .filters(gatewayFilterSpec -> gatewayFilterSpec.addRequestHeader("MyHeader", "MyURI"))
                .uri("http://httpbin.org:80");

        return builder.routes()
                .route(routeFun)
                .route(predicateSpec -> predicateSpec.path("/currency-exchange/**")
                        .uri("lb:///currency-exchange")) //talk to eureka find the service and load balancing
                .route(predicateSpec -> predicateSpec.path("/currency-conversion/**")
                .uri("lb:///currency-conversion")) //talk to eureka find the service and load balancing
                .build();
    }

}
