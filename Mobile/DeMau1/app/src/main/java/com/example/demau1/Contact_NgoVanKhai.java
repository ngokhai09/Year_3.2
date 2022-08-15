package com.example.demau1;

import java.io.Serializable;

public class Contact_NgoVanKhai implements Comparable<Contact_NgoVanKhai>, Serializable {
    private int Id;
    private String Name;
    private String Phone;

    public Contact_NgoVanKhai(int id, String name, String phone) {
        Id = id;
        Name = name;
        Phone = phone;
    }

    public Contact_NgoVanKhai() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFirstName(){
        String str = "";
        for(int i = Name.length() - 1; i >= 0; i--){
            if(Name.charAt(i) != ' '){
                str += Name.charAt(i);
            }
            else break;
        }
        return new StringBuffer(str).reverse().toString();
    }

    @Override
    public int compareTo(Contact_NgoVanKhai o) {
        return this.getFirstName().compareTo(o.getFirstName());
    }
}
