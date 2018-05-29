package org.o7planning.sbangularjs.model;

public class ShipDB {
    private Long shipId;
    private String shipNo;
    private String shipName;
    private String position;

    public ShipDB() {

    }

    public ShipDB(ShipForm shipForm) {
        this.shipId = shipForm.getShipId();
        this.shipNo = shipForm.getShipNo();
        this.shipName = shipForm.getShipName();
        this.position = shipForm.getPosition();
    }

    public ShipDB(Long shipId, String shipNo, String shipName, String position) {
        this.shipId = shipId;
        this.shipNo = shipNo;
        this.shipName = shipName;
        this.position = position;
    }

    public Long getShipId() {
        return shipId;
    }

    public void setShipId(Long shipId) {
        this.shipId = shipId;
    }

    public String getShipNo() {
        return shipNo;
    }

    public void setShipNo(String shipNo) {
        this.shipNo = shipNo;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
