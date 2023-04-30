package org.example.Entities;


import org.hibernate.Session;

public interface EntitiesInterface {
    void select(Session session);
     void insert(Session session);
     void delete(Session session);
     void update(Session session);
}
