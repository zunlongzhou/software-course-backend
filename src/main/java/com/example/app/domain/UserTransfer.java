package com.example.app.domain;


public class UserTransfer {

    private String userName;

    private String userPhone;

    private String mail;

    private String deadline;

    private String password;


    public UserTransfer(){}

    public UserTransfer(String userName, String userPhone, String mail, String deadline, String password) {
        this.userName = userName;
        this.userPhone = userPhone;
        this.mail = mail;
        this.deadline = deadline;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserTransfer{" +
                "userName='" + userName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", mail='" + mail + '\'' +
                ", deadline='" + deadline + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
