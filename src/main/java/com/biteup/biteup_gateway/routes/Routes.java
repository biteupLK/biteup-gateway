package com.biteup.biteup_gateway.routes;

import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class Routes {

  @Bean
  public RouterFunction<ServerResponse> productServiceRoute() {
    return GatewayRouterFunctions.route("product_service")
        .route(
            RequestPredicates.path("/api/product").or(
                RequestPredicates.path("/api/product/**")),
            HandlerFunctions.http("http://localhost:8080"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> OrderServiceRoute() {
    return GatewayRouterFunctions.route("order_service")
        .route(
            RequestPredicates.path("/api/cart").or(
                RequestPredicates.path("/api/cart/**")),
            HandlerFunctions.http("http://localhost:8081"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> RestaurantServiceRoute() {
    return GatewayRouterFunctions.route("restaurant_service")
        .route(
            RequestPredicates.path("/api/restaurant").or(
                RequestPredicates.path("/api/restaurant/**")),
            HandlerFunctions.http("http://localhost:8082"))
        .build();
  }

  @Bean
  public RouterFunction<ServerResponse> UserServiceRoute() {
    return GatewayRouterFunctions.route("user_service")
        .route(
            RequestPredicates.path("/api/user/*"),
            HandlerFunctions.http("http://localhost:8083"))
        .build();
  }



  @Bean
  public RouterFunction<ServerResponse> paymentServiceRoute() {
    return GatewayRouterFunctions.route("biteup_payment")
        .route(
            RequestPredicates.path("/api/payment").or(
                RequestPredicates.path("/api/payment/**")),
            HandlerFunctions.http("http://localhost:8084"))
        .build();
  }

    @Bean
  public RouterFunction<ServerResponse> DeliveryServiceRoute() {
    return GatewayRouterFunctions.route("delivery_service")
        .route(
            RequestPredicates.path("/api/delivery/**"),
            HandlerFunctions.http("http://localhost:8085"))
        .build();
  }
}
