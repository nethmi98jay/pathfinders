package com.example.foodmart.Models;

public class DriverDetails {

    String id;
    String name;
    String contact;
    String nic;
    String address;
    String salary;

    public DriverDetails() {
    }

    public DriverDetails(String id, String name, String contact, String nic, String address, String salary) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.nic = nic;
        this.address = address;
        this.salary = salary;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
