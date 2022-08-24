package lk.ijse.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }


    //we can use rest template for sending request among services
    //if we want to send asynchronous request we have to use web client in webflux
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
