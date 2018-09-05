package org.demo.saga.booking;

import org.apache.servicecomb.saga.omega.spring.EnableOmega;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yuxuan
 * @create 2018-09-04 下午12:33
 **/
@SpringBootApplication
@EnableOmega
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
