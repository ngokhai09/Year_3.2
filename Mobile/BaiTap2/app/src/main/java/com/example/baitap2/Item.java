package com.example.baitap2;

import java.io.Serializable;

public class Item implements Serializable {
    private int Id;
    private String Name;
    private String Description;
    private String Image;
    private int Status;

    public Item(int i, String s, String toString){}
    public Item(int id, String name, String description, String image, int status) {
        Id = id;
        Name = name;
        Description = description;
        Image = image;
        Status = status;
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

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
