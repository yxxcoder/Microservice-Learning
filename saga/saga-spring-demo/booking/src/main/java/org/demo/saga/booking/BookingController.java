package org.demo.saga.booking;

import org.apache.servicecomb.saga.omega.context.annotations.SagaStart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author yuxuan
 * @create 2018-09-04 下午12:34
 **/
@RestController
public class BookingController {

    @Value("${car.service.address:http://localhost:8082}")
    private String carServiceUrl;

    @Value("${hotel.service.address:http://localhost:8081}")
    private String hotelServiceUrl;

    @Autowired
    private RestTemplate template;

    @SagaStart
    @PostMapping("/booking/{name}/{rooms}/{cars}")
    public String order(@PathVariable String name, @PathVariable Integer rooms, @PathVariable Integer cars) {
        template.postForEntity(
                carServiceUrl + "/order/{name}/{cars}",
                null, String.class, name, cars);

        postCarBooking();

        template.postForEntity(
                hotelServiceUrl + "/order/{name}/{rooms}",
                null, String.class, name, rooms);

        postBooking();

        return name + " booking " + rooms + " rooms and " + cars + " cars OK";
    }

    // This method is used by the byteman to inject exception here
    private void postCarBooking() {

    }

    // This method is used by the byteman to inject the faults such as the timeout or the crash
    private void postBooking() {

    }
}

