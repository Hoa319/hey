package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    Button rutbai;
    ImageView labai1;
    ImageView labai2;
    ImageView labai3;
    TextView thongbao;

    int sonut=0;//de xet xem duoc may nut
    int darut=0;//chi cho rut 3 la
    boolean batay=true;//de xet truong hop 3 tay
    String chuoithongbao="";
    ArrayList<String> cacladarut=new ArrayList<String>();

    int manghinhbai[][]={
            {R.drawable.b2fv,
                    R.drawable.pa,R.drawable.p2,R.drawable.p3,R.drawable.p4,R.drawable.p5,
                    R.drawable.p6,R.drawable.p7,R.drawable.p8,R.drawable.p9,R.drawable.p10,
                    R.drawable.pj,R.drawable.pq,R.drawable.pk},
            {R.drawable.b2fv,
                    R.drawable.ka,R.drawable.k2,R.drawable.k3,R.drawable.k4,R.drawable.k5,
                    R.drawable.k6,R.drawable.k7,R.drawable.k8,R.drawable.k9,R.drawable.k10,
                    R.drawable.kj,R.drawable.kq,R.drawable.kk},
            {R.drawable.b2fv,
                    R.drawable.la,R.drawable.l2,R.drawable.l3,R.drawable.l4,R.drawable.l5,
                    R.drawable.l6,R.drawable.l7,R.drawable.l8,R.drawable.l9,R.drawable.l10,
                    R.drawable.lj,R.drawable.lq,R.drawable.lk},
            {R.drawable.b2fv,
                    R.drawable.sa,R.drawable.s2,R.drawable.s3,R.drawable.s4,R.drawable.s5,
                    R.drawable.s6, R.drawable.s9,R.drawable.s8,R.drawable.s9,R.drawable.s10,
                    R.drawable.sj,R.drawable.sq,R.drawable.sk}
    };
    String mangtenbai[][]={
            {"rong",
                    "ach chuon","hai chuon","ba chuon","bon chuon","nam chuon",
                    "sau chuon","bay chuon","tam chuon","chin chuon","muoi chuon",
                    "boi chuon","dam chuon","gia chuon"},
            {"rong",
                    "ach ro","hai ro","ba ro","bon ro","nam ro",
                    "sau ro","bay ro","tam ro","chin ro","muoi ro",
                    "boi ro","dam ro","gia ro"},
            {"rong",
                    "ach co","hai co","ba co","bon co","nam co",
                    "sau co","bay co","tam co","chin co","muoi co",
                    "boi co","dam co","gia co"},
            {"rong",
                    "ach bich","hai bich","ba bich","bon bich","nam bich",
                    "sau bich","bay bich","tam bich","chin bich","muoi bich",
                    "boi bich","dam bich","gia bich"}
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rutbai = (Button) findViewById(R.id.rutbai);
        labai1 = (ImageView) findViewById(R.id.ivlabai1);
        labai2 = (ImageView) findViewById(R.id.ivlabai2);
        labai3 = (ImageView) findViewById(R.id.ivlabai3);
        thongbao = (TextView) findViewById(R.id.txtthongbao);

        rutbai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                if (darut == 0) {
                    darut = 0;
                    sonut = 0;
                    batay = true;
                    chuoithongbao = "";
                    labai1.setImageResource(R.drawable.b2fv);
                    labai2.setImageResource(R.drawable.b2fv);
                    labai3.setImageResource(R.drawable.b2fv);
                    cacladarut.clear();
                }
                darut++;

                Random rd = new Random();
                int x, y;
                while (true) {
                    x = rd.nextInt(4);//0->3 (b-a+1)+a;
                    y = rd.nextInt(13) + 1;//1->13
                    if (cacladarut.contains(mangtenbai[x][y]) == false) {
                        cacladarut.add(mangtenbai[x][y]);
                        break;
                    }
                }
                if (y < 11)
                    batay = false;

                if (darut == 1) {
                    sonut += (y < 10) ? y : 0;
                    labai1.setImageResource(manghinhbai[x][y]);
                } else if (darut == 2) {
                    sonut += (y < 10) ? y : 0;
                    labai2.setImageResource(manghinhbai[x][y]);
                } else if (darut == 3) {
                    sonut += (y < 10) ? y : 0;
                    int kq = sonut % 10;
                    darut = 0;
                    labai3.setImageResource(manghinhbai[x][y]);
                    chuoithongbao += " so nut la " + kq;
                    //rutbai.setEnabled(false);
                }
                thongbao.setText("Cac la da rut" + cacladarut.toString()
                        + chuoithongbao + "ba tay" + batay);
            }
        });
    }
}


