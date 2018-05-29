package org.o7planning.sbangularjs.dao;


import org.o7planning.sbangularjs.model.ShipDB;
import org.o7planning.sbangularjs.model.ShipForm;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class ShipDAO {

    private static final Map<Long, ShipDB> empMap = new HashMap<Long, ShipDB>();

    static {
        initShips();
    }

    private static void initShips() {
        ShipDB emp1 = new ShipDB(1L, "E01", "Smith", "Clerk");
        ShipDB emp2 = new ShipDB(2L, "E02", "Allen", "Salesman");
        ShipDB emp3 = new ShipDB(3L, "E03", "Jones", "Manager");

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

    public ShipDB getShip(Long empId) {
        return empMap.get(empId);
    }

    public ShipDB addShip(ShipForm empForm) {
        Long empId= this.getMaxShipId()+ 1;
        empForm.setShipId(empId);
        ShipDB newShip = new ShipDB(empForm);

        empMap.put(newShip.getShipId(), newShip);
        return newShip;
    }

    public ShipDB updateShip(ShipForm empForm) {
        ShipDB emp = this.getShip(empForm.getShipId());
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

    public List<ShipDB> getAllShips() {
        Collection<ShipDB> c = empMap.values();
        List<ShipDB> list = new ArrayList<ShipDB>();
        list.addAll(c);
        return list;
    }

}