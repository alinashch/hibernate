package org.example.Entities;


import jakarta.persistence.*;
import org.hibernate.Session;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

@Entity
@Table(name="employee")
public class Employee implements EntitiesInterface {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_employee")
    private int id_employee;
    @Column(name="first_name_employee")

    private String first_name_employee;
    @Column(name="second_name_employee")

    private String second_name_employee;
    @Column(name="third_name_employee")

    private String third_name_employee;
    @Column(name="date_birth_employee")

    private Date date_birth_employee;
    @Column(name="address_employee")

    private String address_employee;
    @Column(name="telephone_employee")

    private String telephone_employee;
    @Column(name="post")

    private int post;
    @Column(name="salary")

    private int salary;
    @Column(name="experience")

    private int experience;
    @Column(name="operating_mode")

    private String operating_mode;
    @Column(name="allowance")

    private int allowance;

    @Override
    public String toString() {
        return "Employee{" +
                "id_employee=" + id_employee +
                ", first_name_employee='" + first_name_employee + '\'' +
                ", second_name_employee='" + second_name_employee + '\'' +
                ", third_name_employee='" + third_name_employee + '\'' +
                ", date_birth_employee=" + date_birth_employee +
                ", address_employee='" + address_employee + '\'' +
                ", telephone_employee='" + telephone_employee + '\'' +
                ", post=" + post +
                ", salary=" + salary +
                ", experience=" + experience +
                ", operating_mode='" + operating_mode + '\'' +
                ", allowance=" + allowance +
                '}';
    }

    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }

    public String getFirst_name_employee() {
        return first_name_employee;
    }

    public void setFirst_name_employee(String first_name_employee) {
        this.first_name_employee = first_name_employee;
    }

    public String getSecond_name_employee() {
        return second_name_employee;
    }

    public void setSecond_name_employee(String second_name_employee) {
        this.second_name_employee = second_name_employee;
    }

    public String getThird_name_employee() {
        return third_name_employee;
    }

    public void setThird_name_employee(String third_name_employee) {
        this.third_name_employee = third_name_employee;
    }

    public Date getDate_birth_employee() {
        return date_birth_employee;
    }

    public void setDate_birth_employee(Date date_birth_employee) {
        this.date_birth_employee = date_birth_employee;
    }

    public String getAddress_employee() {
        return address_employee;
    }

    public void setAddress_employee(String address_employee) {
        this.address_employee = address_employee;
    }

    public String getTelephone_employee() {
        return telephone_employee;
    }

    public void setTelephone_employee(String telephone_employee) {
        this.telephone_employee = telephone_employee;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getOperating_mode() {
        return operating_mode;
    }

    public void setOperating_mode(String operating_mode) {
        this.operating_mode = operating_mode;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }

    public Employee(){

    }
    public  Employee( String first_name_employee, String second_name_employee, String third_name_employee, Date date_birth_employee, String address_employee, String telephone_employee, int post, int salary, int experience, int allowance, String operating_mode){
        this.first_name_employee=first_name_employee;
        this.second_name_employee=second_name_employee;
        this.third_name_employee=third_name_employee;
        this.date_birth_employee=date_birth_employee;
        this.address_employee=address_employee;
        this.telephone_employee=telephone_employee;
        this.post=post;
        this.salary=salary;
        this.experience=experience;
        this.operating_mode=operating_mode;
        this.allowance=allowance;
    }


    @Override
    public void select(Session session) {
        List<Employee> employees=session.createQuery("from Employee ").getResultList();
        for (Employee e: employees)
            System.out.println(e);
    }

    @Override
    public void insert(Session session) {
        Scanner scanner=new Scanner(System.in);

        System.out.println("first_name_employee");
        String first_name_employee=scanner.nextLine();

        System.out.println("second_name_employee");
        String second_name_employee=scanner.nextLine();

        System.out.println("third_name_employee");
        String third_name_employee=scanner.nextLine();

        System.out.println("date_birth_employee");
        Date date_birth_employee= Date.valueOf(scanner.nextLine());

        System.out.println("address_employee");
        String address_employee=scanner.nextLine();

        System.out.println("telephone_employee");
        String telephone_employee=scanner.nextLine();

        System.out.println("post");
        int post=scanner.nextInt();

        System.out.println("salary");
        int salary=scanner.nextInt();

        System.out.println("experience");
        int experience=scanner.nextInt();

        System.out.println("allowance");
        int allowance=scanner.nextInt();

        Scanner scanner1=new Scanner(System.in);
        System.out.println("operating_mode");
        String operating_mode=scanner1.nextLine();

        Employee employee=new Employee(first_name_employee, second_name_employee,third_name_employee, date_birth_employee,address_employee,telephone_employee , post , salary, experience,allowance, operating_mode  );

        session.save(employee);
    }

    @Override
    public void delete(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        int id=scanner.nextInt();
        String sql="delete Employee where id =" + id;
        System.out.println(sql);
        session.createQuery(sql).executeUpdate();
    }

    @Override
    public void update(Session session) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Choose first_name_employee, second_name_employee,third_name_employee, date_birth_employee,address_employee,telephone_employee , post , salary, experience,allowance, operating_mode  ");
        String st=scanner.nextLine();
        System.out.println("Enter id");
        int id=scanner.nextInt();
        if(st.equals("first_name_employee")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String  value = scanner1.nextLine();
            String sql="update Employee set first_name_employee= ' "+value+"' where id=" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("second_name_employee")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String  value = scanner1.nextLine();
            String sql="update Employee set second_name_employee= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("third_name_employee")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String  value = scanner1.nextLine();
            String sql="update Employee set third_name_employee= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("date_birth_employee")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            Date  value = Date.valueOf(scanner1.nextLine());
            String sql="update Employee set date_birth_employee= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("address_employee")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String  value = scanner1.nextLine();
            String sql="update Employee set address_employee= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("telephone_employee")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String  value = scanner1.nextLine();
            String sql="update Employee set telephone_employee= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("post")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            int  value = scanner1.nextInt();
            String sql="update Employee set post= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("salary")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            int  value = scanner1.nextInt();
            String sql="update Employee set salary= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("experience")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            int  value = scanner1.nextInt();
            String sql="update Employee set experience= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }else if(st.equals("operating_mode")){
            System.out.println("Enter new value ");
            Scanner scanner1=new Scanner(System.in);
            String  value = scanner1.nextLine();
            String sql="update Employee set operating_mode= ' "+value+"' where id =" + id;
            System.out.println(sql);
            session.createQuery(sql).executeUpdate();
        }
    }
}
