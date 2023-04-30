package org.example.Entities.Factory;


import org.example.Entities.EntitiesInterface;
import org.example.Entities.Repair;

public class RepairFactory implements EntitiesFactory{
    private static RepairFactory repairFactory;

    public static synchronized RepairFactory getFactory(){
        if( repairFactory==null){
            repairFactory=new RepairFactory();
        }
        return repairFactory;
    }
    @Override
    public EntitiesInterface createEntity() {
        return new Repair();
    }


}
