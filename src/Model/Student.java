package Model;

public class Student {
    private String mobPhone, homePhone, name, surname, patronymic, street, home;

    public Student(String name, String surname, String patronymic, String street, String home, String mobPhone, String  homePhone){
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.street = street;
        this.home = home;
        this.mobPhone = mobPhone;
        this.homePhone = homePhone;
    }

    public Student(){

    }


    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getStreet() {
        return street;
    }

    public String getHome() {
        return home;
    }

    public String getMobPhone() {
        return mobPhone;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHome(String home) {
        this.home = home;
    }

    public void setMobPhone(String mobPhone) {
        this.mobPhone = mobPhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
}
