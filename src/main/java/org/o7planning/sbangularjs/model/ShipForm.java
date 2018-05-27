package org.o7planning.sbangularjs.model;

public class ShipForm {
    private Long empId;
    private String empNo;
    private String empName;
    private String position;

    public Long getShipId() {
        return empId;
    }

    public void setShipId(Long empId) {
        this.empId = empId;
    }

    public String getShipNo() {
        return empNo;
    }

    public void setShipNo(String empNo) {
        this.empNo = empNo;
    }

    public String getShipName() {
        return empName;
    }

    public void setShipName(String empName) {
        this.empName = empName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
