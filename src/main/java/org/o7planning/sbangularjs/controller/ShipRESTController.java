package org.o7planning.sbangularjs.controller;

import org.o7planning.sbangularjs.dao.ShipDAO;
import org.o7planning.sbangularjs.model.Ship;
import org.o7planning.sbangularjs.model.ShipForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ShipRESTController {

    @Autowired
    private ShipDAO shipDAO;


    // URL:
    // http://localhost:8080/SomeContextPath/ships
    // http://localhost:8080/SomeContextPath/ships.xml
    // http://localhost:8080/SomeContextPath/ships.json
    @RequestMapping(value = "/ships", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Ship> getShips() {
        List<Ship> list = shipDAO.getAllShips();
        return list;
    }

    // URL:
    // http://localhost:8080/SomeContextPath/ship/{shipId}
    // http://localhost:8080/SomeContextPath/ship/{shipId}.xml
    // http://localhost:8080/SomeContextPath/ship/{shipId}.json
    @RequestMapping(value = "/ship/{shipId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Ship getShip(@PathVariable("shipId") Long shipId) {
        return shipDAO.getShip(shipId);
    }

    // URL:
    // http://localhost:8080/SomeContextPath/ship
    // http://localhost:8080/SomeContextPath/ship.xml
    // http://localhost:8080/SomeContextPath/ship.json

    @RequestMapping(value = "/ship", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Ship addShip(@RequestBody ShipForm shipForm) {

        System.out.println("(Service Side) Creating ship with shipNo: " + shipForm.getShipNo());

        return shipDAO.addShip(shipForm);
    }

    // URL:
    // http://localhost:8080/SomeContextPath/ship
    // http://localhost:8080/SomeContextPath/ship.xml
    // http://localhost:8080/SomeContextPath/ship.json
    @RequestMapping(value = "/ship", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Ship updateShip(@RequestBody ShipForm shipForm) {

        System.out.println("(Service Side) Editing ship with Id: " + shipForm.getShipId());

        return shipDAO.updateShip(shipForm);
    }

    // URL:
    // http://localhost:8080/SomeContextPath/ship/{shipId}
    @RequestMapping(value = "/ship/{shipId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteShip(@PathVariable("shipId") Long shipId) {

        System.out.println("(Service Side) Deleting ship with Id: " + shipId);

        shipDAO.deleteShip(shipId);
    }

}
