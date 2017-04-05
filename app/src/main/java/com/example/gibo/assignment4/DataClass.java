package com.example.gibo.assignment4;

import android.view.View;
import android.widget.TextView;


public class DataClass {

    String table, member;
    int s_num,p_num,price;
    boolean time;

    public DataClass(String table, boolean time, int s_num, int p_num, String member, int price ) {

        this.table = table;
        this.time = time;
        this.s_num = s_num;
        this.p_num = p_num;
        this.member = member;
        this.price = price;
    }

    public String GetTable(){
        return this.table;
    }
    public void SetTable(String table){
        this.table = table;
    }

    public boolean GetTime(){
        return this.time;
    }
    public void SetTime(boolean time){
        this.time = time;
    }

    public int GetSpa(){
        return this.s_num;
    }
    public void SetSpa(int s_num){
        this.s_num = s_num;
    }

    public int GetPizza(){
        return this.p_num;
    }
    public void SetPizza(int p_num){
        this.p_num = p_num;
    }

    public String GetMember(){
        return this.member;
    }
    public void SetMember(String member){
        this.member = member;
    }

    public int GetPrice(){
        return this.price;
    }
    public void SetPrice(int price){
        this.price = price;
    }

}
