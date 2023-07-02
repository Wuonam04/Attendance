package org.example;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Attendance")
public class Mark {

    public Mark() {
    }

    public Mark(String NEMIS_N0,int Class_ID,String WEEK_1) {
        this.WEEK_1 = WEEK_1;
        this.NEMIS_N0 = NEMIS_N0;
        this.Class_ID = Class_ID;
    };

    @Id //system knows that is the id
    private String NEMIS_N0;

    public String getNEMIS_N0() {
        return NEMIS_N0;
    }

    public void setNEMIS_N0(String NEMIS_N0) {
        this.NEMIS_N0 = NEMIS_N0;
    }
    
    private int Class_ID;

    public int getClass_ID() {
        return Class_ID;
    }

    public void setClass_ID(int class_ID) {
        Class_ID = class_ID;
    }

    private String WEEK_1;


    public String getWEEK_1() {
        return WEEK_1;
    }

    public void setWEEK_1(String WEEK_1) {
        this.WEEK_1 = WEEK_1;
    }
}
