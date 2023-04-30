package org.example.Entities.Factory;


import org.example.Entities.EntitiesInterface;
import org.example.Entities.Request;

import java.sql.Date;

public class RequestFactory implements EntitiesFactory {
    private static RequestFactory requestFactory;

    public static synchronized RequestFactory getFactory(){
        if( requestFactory==null){
            requestFactory=new RequestFactory();
        }
        return requestFactory;
    }
    @Override
    public EntitiesInterface createEntity() {
        return new Request();
    }
}
