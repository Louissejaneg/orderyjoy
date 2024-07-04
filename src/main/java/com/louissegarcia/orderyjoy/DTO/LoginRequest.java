package com.louissegarcia.orderyjoy.DTO;

public class LoginRequest {
    private String usernameOrEmail;
    private String password;

    LoginRequest(){}

    //setters
    public void setUsernameOrEmail(String usernameOrEmail) {
        this.usernameOrEmail = usernameOrEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //getters 
    public String getUsernameOrEmail() {
        return usernameOrEmail;
    }

    public String getPassword() {
        return password;
    }

    

    

}
