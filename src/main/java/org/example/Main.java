package org.example;

import org.example.Entities.*;
import org.example.Entities.Factory.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();
        configuration.addAnnotatedClass(Repair.class);
        configuration.addAnnotatedClass(Request.class);
        configuration.addAnnotatedClass(Change.class);
        configuration.addAnnotatedClass(Employee.class);

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession()) {
                session.beginTransaction();

                System.out.println("Enter employee change request repair");
                Scanner scanner = new Scanner(System.in);
                String s = scanner.nextLine();

                System.out.println("Enter select insert delete update");
                String n = scanner.nextLine();


                if (s.equals("employee")) {
                    EntitiesFactory entitiesFactory = new EmployeeFactory();
                    EnterSmth(session, n, entitiesFactory);
                } else if (s.equals("change")) {
                    EntitiesFactory entitiesFactory = new ChangeFactory();
                    EnterSmth(session, n, entitiesFactory);
                } else if (s.equals("request")) {
                    EntitiesFactory entitiesFactory = new RequestFactory();
                    EnterSmth(session, n, entitiesFactory);
                } else if (s.equals("repair")) {
                    EntitiesFactory entitiesFactory = new RepairFactory();
                    EnterSmth(session, n, entitiesFactory);
                }
                session.getTransaction().commit();
                session.close();
                System.out.println("OK");

        }

    }

    private static void EnterSmth(Session session, String n, EntitiesFactory entitiesFactory) {
        if(n.equals("select")){
            entitiesFactory.createEntity().select(session);
        }else if(n.equals("insert")){
            entitiesFactory.createEntity().insert(session);
        }else if(n.equals("delete")){
            entitiesFactory.createEntity().delete(session);
        }else if(n.equals("update")){
            entitiesFactory.createEntity().update(session);
        }
    }
}