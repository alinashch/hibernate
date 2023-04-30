package org.example.Entities.Factory;


import org.example.Entities.Change;
import org.example.Entities.EntitiesInterface;

public class ChangeFactory implements  EntitiesFactory{
    private static ChangeFactory changeFactory;

    public static synchronized ChangeFactory getFactory(){
        if( changeFactory==null){
            changeFactory=new ChangeFactory();
        }
        return changeFactory;
    }
    @Override
    public EntitiesInterface createEntity() {
        return new Change();
    }
}
