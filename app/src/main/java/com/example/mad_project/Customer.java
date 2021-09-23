package com.example.mad_project;

public class Customer {
    private String customerName;
    private String date;
    private String time;
    private String mobile;
    private String comments;

    public Customer(String customerName, String date, String time, String mobile, String comments) {
        this.customerName = customerName;
        this.date = date;
        this.time = time;
        this.mobile = mobile;
        this.comments = comments;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getMobile() {
        return mobile;
    }

    public String getComments() {
        return comments;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}

