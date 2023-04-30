package org.example.Entities;

import jakarta.persistence.*;
import org.hibernate.Session;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name="repair")
public class Repair implements EntitiesInterface {

    public int getId_repair() {
        return id_repair;
    }

    public void setId_repair(int id_repair) {
        this.id_repair = id_repair;
    }

    public int getId_change() {
        return id_change;
    }

    public void setId_change(int id_change) {
        this.id_change = id_change;
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public Date getRepair_date() {
        return repair_date;
    }

    public void setRepair_date(Date repair_date) {
        this.repair_date = repair_date;
    }

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_repair")
    private int id_repair;
    @JoinColumn(name="id_change")
    private int id_change;
    @JoinColumn(name = "id_request")
    private int id_request;
    @Column(name = "repair_date")
    private Date repair_date;

    @Override
    public String toString() {
        return "Repair{" +
                "id_repair=" + id_repair +
                ", id_change=" + id_change +
                ", id_request=" + id_request +
                ", repair_date=" + repair_date +
                '}';
    }

    public Repair(){

    }
    public Repair( int id_change, int id_request, Date repair_date){
        this.id_request=id_request;
        this.id_change=id_change;
        this.repair_date=repair_date;
    }

    @Override
    public void select(Session session) {
        List<Repair> repairs=session.createQuery("from Repair ").getResultList();
        for (Repair e: repairs)
            System.out.println(e);
    }

    @Override
    public void insert(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("id_change");
        int id_change=scanner.nextInt();

        System.out.println("id_request");
        int id_request=scanner.nextInt();

        System.out.println("repair_date");
        String repair_date=scanner.nextLine();

        Repair request=new Repair(id_change , id_request,  Date.valueOf(repair_date));
        session.save(request);
    }

    @Override
    public void delete(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        String sql="delete Repair where id =" + id;
        session.createQuery(sql).executeUpdate();
    }

    @Override
    public void update(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose id_change id_request repair_date ");
        String st=scanner.nextLine();
        System.out.println("Enter id");
        int id=scanner.nextInt();
        if(st.equals("id_change")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            int  value = scanner1.nextInt();
            String sql="update Repair set id_change= ' "+value+"' where id=" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();

        }else if(st.equals("id_request")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            int value = scanner1.nextInt();
            String sql="update Repair set id_request= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();

        }else if(st.equals("repair_date")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            Date value = Date.valueOf(scanner1.nextLine());
            String sql="update Repair set repair_date= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else {
            System.out.println("error");
        }
    }
}
