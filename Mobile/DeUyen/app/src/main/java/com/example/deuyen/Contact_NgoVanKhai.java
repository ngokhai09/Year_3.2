package com.example.deuyen;

import java.io.Serializable;

public class Contact_NgoVanKhai implements Serializable, Comparable<Contact_NgoVanKhai> {
    private String id;
    private String name;
    private float math;
    private float physic;
    private float chemistry;

    public Contact_NgoVanKhai() {
    }

    public Contact_NgoVanKhai(String id, String name, float math, float physic, float chemistry) {
        this.id = id;
        this.name = name;
        this.math = math;
        this.physic = physic;
        this.chemistry = chemistry;
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

    public float getMath() {
        return math;
    }

    public void setMath(float math) {
        this.math = math;
    }

    public float getPhysic() {
        return physic;
    }

    public void setPhysic(float physic) {
        this.physic = physic;
    }

    public float getChemistry() {
        return chemistry;
    }

    public void setChemistry(float chemistry) {
        this.chemistry = chemistry;
    }

    public float getArg(){
        float a = (math + physic + chemistry)/3;
        return Math.round(a * 1000f)/1000f;
    }

    public String getFirstName(){
        String str = "";
        for(int i = name.length() - 1; i > 0; i--){
            if(name.charAt(i) != ' '){
                str += name.charAt(i);
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
