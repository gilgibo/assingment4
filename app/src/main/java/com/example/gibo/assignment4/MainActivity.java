package com.example.gibo.assignment4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    Button bt1,bt2,bt3;
    DataClass fapple = new DataClass("사과 테이블",false,0,0,"멤버쉽 없음",0);
    DataClass fgrape = new DataClass("포도 테이블",false,0,0,"멤버쉽 없음",0);
    DataClass fkiwi = new DataClass("키위 테이블",false,0,0,"멤버쉽 없음",0);
    DataClass forange = new DataClass("자몽 테이블",false,0,0,"멤버쉽 없음",0);

    SimpleDateFormat cNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InflateFragment();

        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);
        tv5 = (TextView)findViewById(R.id.tv5);
        tv6 = (TextView)findViewById(R.id.tv6);


        bt1 = (Button)findViewById(R.id.bt1);
        bt2 = (Button)findViewById(R.id.bt2);
        bt3 = (Button)findViewById(R.id.bt3);


    }

    public void InflateFragment(){

        Fragment1 fragment = new Fragment1();

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag1, fragment);

    }

    public void SettingA(){
        DataClass apple = new DataClass(fapple.GetTable(),fapple.GetTime(),fapple.GetSpa(),fapple.GetPizza(),fapple.GetMember(),fapple.GetPrice());

        tv1.setText(apple.GetTable());
        tv3.setText(Integer.toString(apple.GetSpa()));
        tv4.setText(Integer.toString(apple.GetPizza()));
        tv5.setText(apple.GetMember());
        tv6.setText(Integer.toString(apple.GetPrice()));

        if(apple.GetTime() == false) {
            Toast.makeText(getApplicationContext(), "비어있습니다.", Toast.LENGTH_SHORT).show();
            tv2.setText("");
        }
    }

    public void SettingB() {
        DataClass grape = new DataClass(fgrape.GetTable(), fgrape.GetTime(), fgrape.GetSpa(), fgrape.GetPizza(), fgrape.GetMember(), fgrape.GetPrice());

        tv1.setText(grape.GetTable());
        tv3.setText(Integer.toString(grape.GetSpa()));
        tv4.setText(Integer.toString(grape.GetPizza()));
        tv5.setText(grape.GetMember());
        tv6.setText(Integer.toString(grape.GetPrice()));

        if (grape.GetTime() == false) {
            Toast.makeText(getApplicationContext(), "비어있습니다.", Toast.LENGTH_SHORT).show();
            tv2.setText("");
        }
    }

    public void SettingC() {
        DataClass kiwi = new DataClass(fkiwi.GetTable(), fkiwi.GetTime(), fkiwi.GetSpa(), fkiwi.GetPizza(), fkiwi.GetMember(), fkiwi.GetPrice());

        tv1.setText(kiwi.GetTable());
        tv3.setText(Integer.toString(kiwi.GetSpa()));
        tv4.setText(Integer.toString(kiwi.GetPizza()));
        tv5.setText(kiwi.GetMember());
        tv6.setText(Integer.toString(kiwi.GetPrice()));

        if (kiwi.GetTime() == false) {
            Toast.makeText(getApplicationContext(), "비어있습니다.", Toast.LENGTH_SHORT).show();
            tv2.setText("");
        }
    }

    public void SettingD(){
        DataClass orange = new DataClass(forange.GetTable(),forange.GetTime(),forange.GetSpa(),forange.GetPizza(),forange.GetMember(),forange.GetPrice());

        tv1.setText(orange.GetTable());
        tv3.setText(Integer.toString(orange.GetSpa()));
        tv4.setText(Integer.toString(orange.GetPizza()));
        tv5.setText(orange.GetMember());
        tv6.setText(Integer.toString(orange.GetPrice()));

        if(orange.GetTime() == false) {
            Toast.makeText(getApplicationContext(), "비어있습니다.", Toast.LENGTH_SHORT).show();
            tv2.setText("");
        }
    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bt1:

                final View dlgview = View.inflate(this, R.layout.cusdia, null);
                AlertDialog.Builder dg = new AlertDialog.Builder(this);
                dg.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Date date = new Date(System.currentTimeMillis());
                        String formateDate = cNow.format(date);

                        Toast.makeText(getApplicationContext(),"정보가 입력 되었습니다.",Toast.LENGTH_SHORT).show();
                        EditText spa_num = (EditText)dlgview.findViewById(R.id.et1);
                        EditText pizza_num = (EditText)dlgview.findViewById(R.id.et2);
                        RadioGroup rg = (RadioGroup)dlgview.findViewById(R.id.rg);
                        RadioButton rb = (RadioButton)rg.findViewById(rg.getCheckedRadioButtonId());
                        Fragment1 mainFragment = (Fragment1) getFragmentManager().findFragmentById(R.id.frag1);

                        String spa = spa_num.getText().toString();
                        String pizza = pizza_num.getText().toString();
                        int price = Integer.parseInt(spa_num.getText().toString()) * 10000 +
                                Integer.parseInt(pizza_num.getText().toString()) * 12000;

                        tv2.setText(formateDate);
                        tv3.setText(spa);
                        tv4.setText(pizza);
                        tv5.setText(rb.getText().toString());
                        if(rg.getCheckedRadioButtonId() == R.id.rb1){
                            tv6.setText(price +"원");
                        } else if(rg.getCheckedRadioButtonId() == R.id.rb2){
                            price = (int)(price *0.9);
                            tv6.setText(price +"원");
                        }else if(rg.getCheckedRadioButtonId() == R.id.rb3){
                            price = (int)(price * 0.7);
                            tv6.setText(price +"원");
                        }
                        if(tv1.getText().toString().equals("사과 테이블")){
                            fapple.SetTime(true);
                            fapple.SetSpa(Integer.parseInt(spa));
                            fapple.SetPizza(Integer.parseInt(pizza));
                            fapple.SetMember(rb.getText().toString());
                            fapple.SetPrice(price);
                        }else if(tv1.getText().toString().equals("포도 테이블")){
                            fgrape.SetTime(true);
                            fgrape.SetSpa(Integer.parseInt(spa));
                            fgrape.SetPizza(Integer.parseInt(pizza));
                            fgrape.SetMember(rb.getText().toString());
                            fgrape.SetPrice(price);
                        }else if(tv1.getText().toString().equals("키위 테이블")){
                            fkiwi.SetTime(true);
                            fkiwi.SetSpa(Integer.parseInt(spa));
                            fkiwi.SetPizza(Integer.parseInt(pizza));
                            fkiwi.SetMember(rb.getText().toString());
                            fkiwi.SetPrice(price);
                        }else if(tv1.getText().toString().equals("자몽 테이블")){
                            forange.SetTime(true);
                            forange.SetSpa(Integer.parseInt(spa));
                            forange.SetPizza(Integer.parseInt(pizza));
                            forange.SetMember(rb.getText().toString());
                            forange.SetPrice(price);
                        }
                        if(tv1.getText().equals("사과 테이블") && fapple.GetTime() == true)
                            mainFragment.ChangeTable("사과",true);
                        else if(tv1.getText().equals("포도 테이블") && fgrape.GetTime() == true)
                            mainFragment.ChangeTable("포도", true);
                        else if(tv1.getText().equals("키위 테이블") && fkiwi.GetTime() == true)
                            mainFragment.ChangeTable("키위",true);
                        else if(tv1.getText().equals("자몽 테이블") && fapple.GetTime() == true)
                            mainFragment.ChangeTable("자몽",true);
                    }
                });
                dg.setNegativeButton("취소", null);
                dg.setTitle("새 주문");
                dg.setView(dlgview);
                dg.show();
                break;

            case R.id.bt2:
                final View dlgview2 = View.inflate(this, R.layout.cusdia, null);
                AlertDialog.Builder dg2 = new AlertDialog.Builder(this);
                dg2.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"정보가 변경 되었습니다.",Toast.LENGTH_SHORT).show();
                        EditText spa_num = (EditText)dlgview2.findViewById(R.id.et1);
                        EditText pizza_num = (EditText)dlgview2.findViewById(R.id.et2);
                        RadioGroup rg = (RadioGroup)dlgview2.findViewById(R.id.rg);
                        RadioButton rb = (RadioButton)rg.findViewById(rg.getCheckedRadioButtonId());

                        String spa = spa_num.getText().toString();
                        String pizza = pizza_num.getText().toString();
                        int price = Integer.parseInt(spa_num.getText().toString()) * 10000 +
                                Integer.parseInt(pizza_num.getText().toString()) * 12000;

                        tv3.setText(spa);
                        tv4.setText(pizza);
                        tv5.setText(rb.getText().toString());
                        if(rg.getCheckedRadioButtonId() == R.id.rb1){
                            tv6.setText(price +"원");
                        } else if(rg.getCheckedRadioButtonId() == R.id.rb2){
                            price = (int)(price *0.9);
                            tv6.setText(price +"원");
                        }else if(rg.getCheckedRadioButtonId() == R.id.rb3){
                            price = (int)(price * 0.7);
                            tv6.setText(price +"원");
                        }
                        if(tv1.getText().toString().equals("사과 테이블")){
                            fapple.SetSpa(Integer.parseInt(spa));
                            fapple.SetPizza(Integer.parseInt(pizza));
                            fapple.SetMember(rb.getText().toString());
                            fapple.SetPrice(price);
                        }else if(tv1.getText().toString().equals("포도 테이블")){
                            fgrape.SetSpa(Integer.parseInt(spa));
                            fgrape.SetPizza(Integer.parseInt(pizza));
                            fgrape.SetMember(rb.getText().toString());
                            fgrape.SetPrice(price);
                        }else if(tv1.getText().toString().equals("키위 테이블")){
                            fkiwi.SetSpa(Integer.parseInt(spa));
                            fkiwi.SetPizza(Integer.parseInt(pizza));
                            fkiwi.SetMember(rb.getText().toString());
                            fkiwi.SetPrice(price);
                        }else if(tv1.getText().toString().equals("자몽 테이블")){
                            forange.SetSpa(Integer.parseInt(spa));
                            forange.SetPizza(Integer.parseInt(pizza));
                            forange.SetMember(rb.getText().toString());
                            forange.SetPrice(price);
                        }
                    }
                });
                dg2.setNegativeButton("취소", null);
                dg2.setTitle("주문 수정");
                dg2.setView(dlgview2);
                dg2.show();
                break;


            case R.id.bt3 :

                tv2.setText("");
                tv3.setText("0");
                tv4.setText("0");
                tv5.setText("멤버쉽 없음");
                tv6.setText("0원");


                Fragment1 mainFragment = (Fragment1) getFragmentManager().findFragmentById(R.id.frag1);
                if(tv1.getText().equals("사과 테이블")) {
                    mainFragment.ChangeTable("사과", false);
                    fapple.SetTime(false);
                    fapple.SetSpa(0);
                    fapple.SetPizza(0);
                    fapple.SetMember("멤버쉽 없음");
                    fapple.SetPrice(0);
                }
                if(tv1.getText().equals("포도 테이블")) {
                    mainFragment.ChangeTable("포도", false);
                    fgrape.SetTime(false);
                    fgrape.SetSpa(0);
                    fgrape.SetPizza(0);
                    fgrape.SetMember("멤버쉽 없음");
                    fgrape.SetPrice(0);
                }
                if(tv1.getText().equals("키위 테이블")) {
                    mainFragment.ChangeTable("키위", false);
                    fkiwi.SetTime(false);
                    fkiwi.SetSpa(0);
                    fkiwi.SetPizza(0);
                    fkiwi.SetMember("멤버쉽 없음");
                    fkiwi.SetPrice(0);
                }
                if(tv1.getText().equals("자몽 테이블")) {
                    mainFragment.ChangeTable("자몽", false);
                    forange.SetTime(false);
                    forange.SetSpa(0);
                    forange.SetPizza(0);
                    forange.SetMember("멤버쉽 없음");
                    forange.SetPrice(0);
                }
                break;
        }

    }

    }
