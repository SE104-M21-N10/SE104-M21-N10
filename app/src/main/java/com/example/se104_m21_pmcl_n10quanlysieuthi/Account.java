package com.example.se104_m21_pmcl_n10quanlysieuthi;

public class Account {
    public String login;
    public String pass;
    public String name;
    public Account(){
        login="null";
        pass="null";
        name="null";
    }
    public Account(String Login, String Pass, String Name){
        this.login=Login;
        this.pass=Pass;
        this.name=Name;
    }
}
