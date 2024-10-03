package api.fligth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FligthApplication {

    public static void main(String[] args) {
        SpringApplication.run(FligthApplication.class, args);
    }

}
