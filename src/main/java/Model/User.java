/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Ricardo
 */
public class User {

    private int id;
    private String name;
    private int age;
    private String email;
    private String telephone;
    private String department;
    public static final String[] LABEL_USERS = {"ID", "Name", "Age", "Email", "Telephone", "Department",};

    public User() {
        this.id = 0;
        this.name = "";
        this.age = 0;
        this.email = "";
        this.telephone = "";
        this.department = "";
    }

    public User(int id, String name, int age, String email, String telephone, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.department = department;
    }

    public String setColumData(int colum) {
        switch (colum) {
            case 0:
                return String.valueOf(this.getId());
            case 1:
                return this.getName();
            case 2:
                return String.valueOf(this.getAge());
            case 3:
                return this.getEmail();
            case 4:
                return this.getTelephone();
            case 5:
                return this.getDepartment();
        }
        return "";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", telephone=" + telephone + ", department=" + department + '}';
    }

}
