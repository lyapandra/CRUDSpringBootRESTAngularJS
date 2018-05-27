package org.o7planning.sbangularjs.dao;


import org.o7planning.sbangularjs.model.Ship;
import org.o7planning.sbangularjs.model.ShipForm;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ShipDAO {

    private static final Map<Long, Ship> empMap = new HashMap<Long, Ship>();

    static {
        initShips();
    }

    private static void initShips() {
        Ship emp1 = new Ship(1L, "E01", "Smith", "Clerk");
        Ship emp2 = new Ship(2L, "E02", "Allen", "Salesman");
        Ship emp3 = new Ship(3L, "E03", "Jones", "Manager");

        empMap.put(emp1.getShipId(), emp1);
        empMap.put(emp2.getShipId(), emp2);
        empMap.put(emp3.getShipId(), emp3);
    }

    public Long getMaxShipId() {
        Set<Long> keys = empMap.keySet();
        Long max = 0L;
        for (Long key : keys) {
            if (key > max) {
                max = key;
            }
        }
        return max;
    }

    public Ship getShip(Long empId) {
        return empMap.get(empId);
    }

    public Ship addShip(ShipForm empForm) {
        Long empId= this.getMaxShipId()+ 1;
        empForm.setShipId(empId);
        Ship newShip = new Ship(empForm);

        empMap.put(newShip.getShipId(), newShip);
        return newShip;
    }

    public Ship updateShip(ShipForm empForm) {
        Ship emp = this.getShip(empForm.getShipId());
        if(emp!= null)  {
            emp.setShipNo(empForm.getShipNo());
            emp.setShipName(empForm.getShipName());
            emp.setPosition(empForm.getPosition());
        }
        return emp;
    }

    public void deleteShip(Long empId) {
        empMap.remove(empId);
    }

    public List<Ship> getAllShips() {
        Collection<Ship> c = empMap.values();
        List<Ship> list = new ArrayList<Ship>();
        list.addAll(c);
        return list;
    }

}