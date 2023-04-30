package org.example.Entities;


import jakarta.persistence.*;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name="request")
public class Request implements EntitiesInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_request")
    private int id_request;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "second_name")

    private String second_name;
    @Column(name = "third_name")

    private String third_name;
    @Column(name = "telephone")

    private String telephone;
    @Column(name = "request_date")

    private Date request_date;

    public Request() {

    }

    @Override
    public String toString() {
        return "Request{" +
                "id_request=" + id_request +
                ", first_name='" + first_name + '\'' +
                ", second_name='" + second_name + '\'' +
                ", third_name='" + third_name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", request_date=" + request_date +
                '}';
    }

    public int getId_request() {
        return id_request;
    }

    public void setId_request(int id_request) {
        this.id_request = id_request;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getThird_name() {
        return third_name;
    }

    public void setThird_name(String third_name) {
        this.third_name = third_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRequest_date() {
        return request_date;
    }

    public void setRequest_date(Date request_date) {
        this.request_date = request_date;
    }

    public Request(String first_name, String second_name, String third_name, String telephone, Date request_date) {

        this.second_name = second_name;
        this.first_name = first_name;
        this.third_name = third_name;
        this.telephone = telephone;
        this.request_date = request_date;
    }


    @Override
    public void select(Session session) {
        List<Request> requests=session.createQuery("from Request ").getResultList();
        for (Request e: requests)
            System.out.println(e);
    }

    @Override
    public void insert(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("first name");
        String first=scanner.nextLine();

        System.out.println("second name");
        String second=scanner.nextLine();

        System.out.println("third name");
        String third=scanner.nextLine();

        System.out.println("telephone");
        String telephone=scanner.nextLine();

        System.out.println("date");
        String date=scanner.nextLine();

        Request request=new Request(first,second, third, telephone, Date.valueOf(date));
        session.save(request);
    }

    @Override
    public void delete(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        String sql="delete Request where id =" + id;
        session.createQuery(sql).executeUpdate();

    }

    @Override
    public void update(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose first_name second_name third_name telephone date");
        String st=scanner.nextLine();
        System.out.println("Enter id");
        int id=scanner.nextInt();
        if(st.equals("first_name")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String value = scanner1.nextLine();
            String sql="update Request set first_name= ' "+value+"' where id=" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("second_name")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String value = scanner1.nextLine();
            String sql="update Request set second_name= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("third_name")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String value = scanner1.nextLine();
            String sql="update Request set third_name= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("telephone")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String value = scanner1.nextLine();
            String sql="update Request set telephone= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("date")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            Date value = Date.valueOf(scanner1.nextLine());
            String sql="update Request set telephone= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else {
            System.out.println("error");
        }
    }
}