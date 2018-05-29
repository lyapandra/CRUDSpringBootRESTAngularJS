package org.o7planning.sbangularjs.model;

import java.util.ArrayList;
import java.util.List;

public class ShipWar implements IShip {
    private Long shipWarId;
    private String shipWarNo;
    private String shipWarName;
    private List<String> shipWarPosition;
    private String shipWarImige;

    public Long getShipWarId() {
        return shipWarId;
    }

    public void setShipWarId(Long shipWarId) {
        this.shipWarId = shipWarId;
    }

    public String getShipWarNo() {
        return shipWarNo;
    }

    public void setShipWarNo(String shipWarNo) {
        this.shipWarNo = shipWarNo;
    }

    public String getShipWarName() {
        return shipWarName;
    }

    public void setShipWarName(String shipWarName) {
        this.shipWarName = shipWarName;
    }

    public List<String> getShipWarPosition() {
        return shipWarPosition;
    }

    public void setShipWarPosition(List<String> shipWarPosition) {
        this.shipWarPosition = shipWarPosition;
    }

    public String getShipWarImige() {
        return shipWarImige;
    }

    public void setShipWarImige(String shipWarImige) {
        this.shipWarImige = shipWarImige;
    }
}
