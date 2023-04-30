package org.example.Entities.Factory;


import org.example.Entities.Employee;
import org.example.Entities.EntitiesInterface;

public class EmployeeFactory implements EntitiesFactory{
    private static EmployeeFactory employeeFactory;

    public static synchronized EmployeeFactory getFactory(){
        if( employeeFactory==null){
            employeeFactory=new EmployeeFactory();
        }
        return employeeFactory;
    }

    @Override
    public EntitiesInterface createEntity() {
        return new Employee();
    }

}
