package org.o7planning.sbangularjs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShipController {

    @RequestMapping("/ships")
    public String welcome() {
        return "ships";
    }
}