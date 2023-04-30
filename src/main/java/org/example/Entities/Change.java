package org.example.Entities;


import jakarta.persistence.*;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name="change")
public class Change implements EntitiesInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_change")
    private int idChange;
    @Column(name="date_production")
    private Date dateProduction;
    @Column(name="name_detail")
    private String nameDetail;
    @Column(name="number_detail")
    private int numberDetail;
    public Change(){}


    public Change(java.sql.Date date_production , String name_detail, int number_detail){
        this.dateProduction=date_production;
        this.nameDetail=name_detail;
        this.numberDetail=number_detail;
    }

    public int getIdChange() {
        return idChange;
    }

    public void setIdChange(int idChange) {
        this.idChange = idChange;
    }

    public Date getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(Date dateProduction) {
        this.dateProduction = dateProduction;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public int getNumberDetail() {
        return numberDetail;
    }

    @Override
    public String toString() {
        return "Change{" +
                "idChange=" + idChange +
                ", dateProduction=" + dateProduction +
                ", nameDetail='" + nameDetail + '\'' +
                ", numberDetail=" + numberDetail +
                '}';
    }

    public void setNumberDetail(int numberDetail) {
        this.numberDetail = numberDetail;
    }

    @Override
    public void select(Session session) {
        List<Change> changes=session.createQuery("from Change ").getResultList();
        for (Change e: changes)
            System.out.println(e);
    }

    @Override
    public void insert(Session session) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("dateProduction");
        java.sql.Date dateProduction= java.sql.Date.valueOf(scanner.nextLine());

        System.out.println("nameDetail");
        String nameDetail=scanner.nextLine();

        System.out.println("numberDetail");
        int numberDetail=scanner.nextInt();

        Change request=new Change(dateProduction, nameDetail, numberDetail );
        session.save(request);
    }

    @Override
    public void delete(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        String sql="delete Change where id =" + id;
        session.createQuery(sql).executeUpdate();
    }

    @Override
    public void update(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose dateProduction, nameDetail, numberDetail  ");
        String st=scanner.nextLine();
        System.out.println("Enter id");
        int id=scanner.nextInt();

        if(st.equals("dateProduction")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            java.sql.Date value = java.sql.Date.valueOf(scanner1.nextLine());
            String sql="update Change set dateProduction= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("nameDetail")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String value = scanner1.nextLine();
            String sql="update Change set nameDetail= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("numberDetail")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            int value = scanner1.nextInt();
            String sql="update Change set numberDetail= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();

        }

    }
}
