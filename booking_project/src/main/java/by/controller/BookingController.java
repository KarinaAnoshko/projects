package by.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookingController {

    @RequestMapping("/reservation")
    String formReservation() {
        return "bookingForm";
    }
}
