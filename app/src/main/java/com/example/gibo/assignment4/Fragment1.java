package com.example.gibo.assignment4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment{

    Button btn1,btn2,btn3,btn4;
    TextView tv2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View fragview = inflater.inflate(R.layout.fragment1, container, false);

        btn1 = (Button)fragview.findViewById(R.id.btn1);
        btn2 = (Button)fragview.findViewById(R.id.btn2);
        btn3 = (Button)fragview.findViewById(R.id.btn3);
        btn4 = (Button)fragview.findViewById(R.id.btn4);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).SettingA();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).SettingB();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).SettingC();
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).SettingD();
            }
        });

        return fragview;
    }
    public void ChangeTable(String cname, boolean time){
        if(cname.equals("사과")&& time == false)
            btn1.setText("사과 Table(비어있음)");
        if(cname.equals("사과")&& time == true)
            btn1.setText("사과 Table");
        if(cname.equals("포도")&& time == false)
            btn2.setText("포도 Table(비어있음)");
        if(cname.equals("포도")&& time == true)
            btn2.setText("포도 Table");
        if(cname.equals("키위")&& time == false)
            btn3.setText("키위 Table(비어있음)");
        if(cname.equals("키위")&& time == true)
            btn3.setText("키위 Table");
        if(cname.equals("자몽")&& time == false)
            btn4.setText("자몽 Table(비어있음)");
        if(cname.equals("자몽")&& time == true)
            btn4.setText("자몽 Table");

    }
}
