package com.example.lyhoo.nfc;

public class person_info {
    private static String Name;
    private static String Password;
    public person_info(String name,String password){
        Name = name;
        Password = password;
    }
    public person_info(){

    }
    public String getName(){
        return Name;
    }
    public String getPassword(){
        return Password;
    }
}
