package org.example;



import javax.persistence.*;

@Entity
@Table(name = "Stream2")
public class Stream2 {
    
    public Stream2() {
    }

    public Stream2(String nemis,String name) {
        this.name = name;
    };

    @Id //system knows that is the id
    private String nemis;

    public String getNemis(String qwerty) {
        return nemis;
    }

    public void setNemis(String nemis) {
        this.nemis = nemis;
    }

    private String name;

    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
