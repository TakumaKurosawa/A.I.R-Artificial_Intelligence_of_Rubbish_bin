package jp.ac.aitech.k17097kk.ev3_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;

import java.io.BufferedWriter;

public class MainActivity extends AppCompatActivity {

    private BufferedWriter bw;
    public String pre = "";  //前ボタン押された場所
    public double dis = 0;   //距離
    public double ang = 0;    //角度
    public boolean goflg = false; //移動開始ボタンを押す前　false
    public String turn = ""; //障害物に対面した時 左右どっちの方向に避けるか
    private SendToEv3 connect;

    int changeAng = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        final Button save = findViewById(R.id.save);

//        final ImageButton b00 = findViewById(R.id.b00);
//        final TextView t00 = findViewById(R.id.b00);
        final Button b01 = findViewById(R.id.b01);
        final TextView t01 = findViewById(R.id.b01);
        final Button b02 = findViewById(R.id.b02);
        final TextView t02 = findViewById(R.id.b02);
        final Button b03 = findViewById(R.id.b03);
        final TextView t03 = findViewById(R.id.b03);
        final Button b04 = findViewById(R.id.b04);
        final TextView t04 = findViewById(R.id.b04);
//        final Button b05 = findViewById(R.id.b05);
//        final TextView t05 = findViewById(R.id.b05);
        final Button b10 = findViewById(R.id.b10);
        final TextView t10 = findViewById(R.id.b10);
        final Button b11 = findViewById(R.id.b11);
        final TextView t11 = findViewById(R.id.b11);
        final Button b12 = findViewById(R.id.b12);
        final TextView t12 = findViewById(R.id.b12);
        final Button b13 = findViewById(R.id.b13);
        final TextView t13 = findViewById(R.id.b13);
        final Button b14 = findViewById(R.id.b14);
        final TextView t14 = findViewById(R.id.b14);
//        final Button b15 = findViewById(R.id.b15);
//        final TextView t15 = findViewById(R.id.b15);
        final Button b20 = findViewById(R.id.b20);
        final TextView t20 = findViewById(R.id.b20);
        final Button b21 = findViewById(R.id.b21);
        final TextView t21 = findViewById(R.id.b21);
        final Button b22 = findViewById(R.id.b22);
        final TextView t22 = findViewById(R.id.b22);
        final Button b23 = findViewById(R.id.b23);
        final TextView t23 = findViewById(R.id.b23);
        final Button b24 = findViewById(R.id.b24);
        final TextView t24 = findViewById(R.id.b24);
//        final Button b25 = findViewById(R.id.b25);
//        final TextView t25 = findViewById(R.id.b25);
        final Button b30 = findViewById(R.id.b30);
        final TextView t30 = findViewById(R.id.b30);
        final Button b31 = findViewById(R.id.b31);
        final TextView t31 = findViewById(R.id.b31);
        final Button b32 = findViewById(R.id.b32);
        final TextView t32 = findViewById(R.id.b32);
        final Button b33 = findViewById(R.id.b33);
        final TextView t33 = findViewById(R.id.b33);
        final Button b34 = findViewById(R.id.b34);
        final TextView t34 = findViewById(R.id.b34);
//        final Button b35 = findViewById(R.id.b35);
//        final TextView t35 = findViewById(R.id.b35);
        final Button b40 = findViewById(R.id.b40);
        final TextView t40 = findViewById(R.id.b40);
        final Button b41 = findViewById(R.id.b41);
        final TextView t41 = findViewById(R.id.b41);
        final Button b42 = findViewById(R.id.b42);
        final TextView t42 = findViewById(R.id.b42);
        final Button b43 = findViewById(R.id.b43);
        final TextView t43 = findViewById(R.id.b43);
        final Button b44 = findViewById(R.id.b44);
        final TextView t44 = findViewById(R.id.b44);
//        final Button b45 = findViewById(R.id.b45);
//        final TextView t45 = findViewById(R.id.b45);
//        final Button b50 = findViewById(R.id.b50);
//        final TextView t50 = findViewById(R.id.b50);
//        final Button b51 = findViewById(R.id.b51);
//        final TextView t51 = findViewById(R.id.b51);
//        final Button b52 = findViewById(R.id.b52);
//        final TextView t52 = findViewById(R.id.b52);
//        final Button b53 = findViewById(R.id.b53);
//        final TextView t53 = findViewById(R.id.b53);
//        final Button b54 = findViewById(R.id.b54);
//        final TextView t54 = findViewById(R.id.b54);
//        final Button b55 = findViewById(R.id.b55);
//        final TextView t55 = findViewById(R.id.b55);
        final Button go = findViewById(R.id.go);

//        b00.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b00";
//                t00.setText("◉");
//                //
//                ang = 0;
//                dis = 0;
////                }
//            }
//        });
        b01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b01";
                t01.setText("☆");
                //角度,距離変更
                ang = 90+5;
                dis = 45;
                turn = "RIGHT";
//                }
            }
        });
        b02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b02";
                t02.setText("☆");
                //角度,距離変更
                ang = 90+5;
                dis = 88.5;
                turn = "RIGHT";
//                }
            }
        });
        b03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b03";
                t03.setText("☆");
                //角度,距離変更
                ang = 90+5;
                dis = 132;
                turn = "RIGHT";
//                }
            }
        });
        b04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b04";
                t04.setText("☆");
                //角度,距離変更
                ang = 90+5;
                dis = 174;
                turn = "RIGHT";
//                }
            }
        });
//        b05.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b05";
//                t05.setText("☆");
//                //角度,距離変更
//                ang = 90+5;
//                dis = 217;
//                turn = "RIGHT";
////                }
//            }
//        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b10";
                t10.setText("☆");
                //角度,距離変更
                ang = 0;
                dis = 45;//成功！
                turn = "LEFT";
//                }
            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b11";
                t11.setText("☆");
                //角度,距離変更
                ang = 45+4;
                dis = 64;//成功！元63
                turn = "RIGHT";
//                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b12";
                t12.setText("☆");
                //角度,距離変更
                ang = 64+6;
                dis = 100.62305898749;
                turn = "RIGHT";
//                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b13";
                t13.setText("☆");
                //角度,距離変更
                ang = 72+7;
                dis = 142.30249470758;
                turn = "RIGHT";
//                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b14";
                t14.setText("☆");
                //角度,距離変更
                ang = 76+6;
                dis = 185.2;
                turn = "RIGHT";
//                }
            }
        });
//        b15.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b15";
//                t15.setText("☆");
//                //角度,距離変更
//                ang = 79+6;
//                dis = 229;
//                turn = "RIGHT";
////                }
//            }
//        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b20";
                t20.setText("☆");
                //角度,距離変更
                ang = 0;
                dis = 88.5;//成功！元90
                turn = "LEFT";
//                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b21";
                t21.setText("☆");
                //角度,距離変更
                ang = 26+4;
                dis = 100.62305898749;
                turn = "LEFT";
//                }
            }
        });
        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b22";
                t22.setText("☆");
                //角度,距離変更
                ang = 45+4;
                dis = 126.5;//成功！元126
                turn = "RIGHT";
//                }
            }
        });
        b23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b23";
                t23.setText("☆");
                //角度,距離変更
                ang = 57+5;
                dis = 162.24980739588;
                turn = "RIGHT";
//                }
            }
        });
        b24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b24";
                t24.setText("☆");
                //角度,距離変更
                ang = 64+7;
                dis = 200;//201
                turn = "RIGHT";
//                }
            }
        });
//        b25.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b25";
//                t25.setText("☆");
//                //角度,距離変更
//                ang = 68+4;
//                dis = 242.33241632105;
//                turn = "RIGHT";
////                }
//            }
//        });
        b30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b30";
                t30.setText("☆");
                //角度,距離変更
                ang = 0;
                dis = 132;//成功！　元135
                turn = "LEFT";
//                }
            }
        });
        b31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b31";
                t31.setText("☆");
                //角度,距離変更
                ang = 18+3;
                dis = 142.30249470758; //142
                turn = "LEFT";
//                }
            }
        });
        b32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b32";
                t32.setText("☆");
                //角度,距離変更
                ang = 33+5;
                dis = 162.24980739588;
                turn = "LEFT";
//                }
            }
        });
        b33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b33";
                t33.setText("☆");
                //角度,距離変更
                ang = 45+4;
                dis = 187.5;//成功！元189
                turn = "RIGHT";
//                }
            }
        });
        b34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b34";
                t34.setText("☆");
                //角度,距離変更
                ang = 54+5;
                dis = 224.7;
                turn = "RIGHT";
//                }
            }
        });
//        b35.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b35";
//                t35.setText("☆");
//                //角度,距離変更
//                ang = 59+4;
//                dis = 262.39283526804;
//                turn = "RIGHT";
////                }
//            }
//        });
        b40.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b40";
                t40.setText("☆");
                //角度,距離変更
                ang = 0;
                dis = 174;//成功！元180
                turn = "LEFT";
//                }
            }
        });
        b41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b41";
                t41.setText("☆");
                //角度,距離変更
                ang = 14+3;
                dis = 185.5397531528;
                turn = "LEFT";
//                }
            }
        });
        b42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b42";
                t42.setText("☆");
                //角度,距離変更
                ang = 26+4;
                dis = 201.24611797498;//201
                turn = "LEFT";
//                }
            }
        });
        b43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b43";
                t43.setText("☆");
                //角度,距離変更
                ang = 36+4;
                dis = 225;
                turn = "LEFT";
//                }
            }
        });
        b44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (goflg == true) {
//                    check(pre);
//                } else {
                if (pre.equals("")) {
                } else {
                    check(pre);
                }
                pre = "b44";
                t44.setText("☆");
                //角度,距離変更
                ang = 45+4;
                dis = 249;//元252
                turn = "RIGHT";
//                }
            }
        });
//        b45.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b45";
//                t45.setText("☆");
//                //角度,距離変更
//                ang = 51+4;
//                dis = 288.14059068448;
//                turn = "RIGHT";
////                }
//            }
//        });
//        b50.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b50";
//                t50.setText("☆");
//                //角度,距離変更
//                ang = 0;
//                dis = 217;//成功！元225
//                turn = "LEFT";
////                }
//            }
//        });
//        b51.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if (goflg == true) {
////                    check(pre);
////                } else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b51";
//                t51.setText("☆");
//                //角度,距離変更
//                ang = 11+2;
//                dis = 227;
//                turn = "LEFT";
////                }
//            }
//        });
//        b52.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if(goflg==true){
////                    check(pre);
////                }else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b52";
//                t52.setText("☆");
//                //角度,距離変更
//                ang = 22+4;
//                dis = 242.33241632105;
//                turn = "LEFT";
////                }
//            }
//        });
//        b53.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
////                if(goflg==true){
////                    check(pre);
////                }else {
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b53";
//                t53.setText("☆");
//                //角度,距離変更
//                ang = 31+4;
//                dis = 262.39283526804;
//                turn = "LEFT";
////                }
//            }
//        });
//        b54.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                if (pre.equals("")) {
//                } else {
//                    check(pre);
//                }
//                pre = "b54";
//                t54.setText("☆");
//                //角度,距離変更
//                ang = 39+4;
//                dis = 288.14059068448;
//                turn = "LEFT";
//
//            }
//        });
//        b55.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (pre.equals("")) {
//
//                } else {
//                    check(pre);
//                }
//                pre = "b55";
//                t55.setText("☆");
//                //角度,距離変更
//                ang = 45+4;
//                dis = 318;
//                turn = "RIGHT";
//            }
//        });
        go.setOnClickListener(new View.OnClickListener() {//移動開始ボタンが押されたら角度と距離を送る
            @Override
            public void onClick(View view) {
                sendCommand();
                go.setText("移　動　開　始");
            }
        });

//        save.setOnClickListener(new View.OnClickListener() {//移動開始ボタンが押されたら角度と距離を送る
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this,SaveActivity.class);
//                //データを遷移先に転送
//                startActivity(intent);
//            }
//        });

    }

    public void check(String b) {//前に押されていたボタンがあったら印を消す
        if (b.equals("b00")) {
//            TextView t00 = findViewById(R.id.b00);
//            t00.setText("");
        } else if (b.equals("b01")) {
            TextView t01 = findViewById(R.id.b01);
            t01.setText("");
        } else if (b.equals("b02")) {
            TextView t02 = findViewById(R.id.b02);
            t02.setText("");
        } else if (b.equals("b03")) {
            TextView t03 = findViewById(R.id.b03);
            t03.setText("");
        } else if (b.equals("b04")) {
            TextView t04 = findViewById(R.id.b04);
            t04.setText("");
//        } else if (b.equals("b05")) {
//            TextView t05 = findViewById(R.id.b05);
//            t05.setText("");
        } else if (b.equals("b10")) {
            TextView t10 = findViewById(R.id.b10);
            t10.setText("");
        } else if (b.equals("b11")) {
            TextView t11 = findViewById(R.id.b11);
            t11.setText("");
        } else if (b.equals("b12")) {
            TextView t12 = findViewById(R.id.b12);
            t12.setText("");
        } else if (b.equals("b13")) {
            TextView t13 = findViewById(R.id.b13);
            t13.setText("");
        } else if (b.equals("b14")) {
            TextView t14 = findViewById(R.id.b14);
            t14.setText("");
//        } else if (b.equals("b15")) {
//            TextView t15 = findViewById(R.id.b15);
//            t15.setText("");
        } else if (b.equals("b20")) {
            TextView t20 = findViewById(R.id.b20);
            t20.setText("");
        } else if (b.equals("b21")) {
            TextView t21 = findViewById(R.id.b21);
            t21.setText("");
        } else if (b.equals("b22")) {
            TextView t22 = findViewById(R.id.b22);
            t22.setText("");
        } else if (b.equals("b23")) {
            TextView t23 = findViewById(R.id.b23);
            t23.setText("");
        } else if (b.equals("b24")) {
            TextView t24 = findViewById(R.id.b24);
            t24.setText("");
//        } else if (b.equals("b25")) {
//            TextView t25 = findViewById(R.id.b25);
//            t25.setText("");
        } else if (b.equals("b30")) {
            TextView t30 = findViewById(R.id.b30);
            t30.setText("");
        } else if (b.equals("b31")) {
            TextView t31 = findViewById(R.id.b31);
            t31.setText("");
        } else if (b.equals("b32")) {
            TextView t32 = findViewById(R.id.b32);
            t32.setText("");
        } else if (b.equals("b33")) {
            TextView t33 = findViewById(R.id.b33);
            t33.setText("");
        } else if (b.equals("b34")) {
            TextView t34 = findViewById(R.id.b34);
            t34.setText("");
//        } else if (b.equals("b35")) {
//            TextView t35 = findViewById(R.id.b35);
//            t35.setText("");
        } else if (b.equals("b40")) {
            TextView t40 = findViewById(R.id.b40);
            t40.setText("");
        } else if (b.equals("b41")) {
            TextView t41 = findViewById(R.id.b41);
            t41.setText("");
        } else if (b.equals("b42")) {
            TextView t42 = findViewById(R.id.b42);
            t42.setText("");
        } else if (b.equals("b43")) {
            TextView t43 = findViewById(R.id.b43);
            t43.setText("");
        } else if (b.equals("b44")) {
            TextView t44 = findViewById(R.id.b44);
            t44.setText("");
//        } else if (b.equals("b45")) {
//            TextView t45 = findViewById(R.id.b45);
//            t45.setText("");
//        } else if (b.equals("b50")) {
//            TextView t50 = findViewById(R.id.b50);
//            t50.setText("");
//        } else if (b.equals("b51")) {
//            TextView t51 = findViewById(R.id.b51);
//            t51.setText("");
//        } else if (b.equals("b52")) {
//            TextView t52 = findViewById(R.id.b52);
//            t52.setText("");
//        } else if (b.equals("b53")) {
//            TextView t53 = findViewById(R.id.b53);
//            t53.setText("");
//        } else if (b.equals("b54")) {
//            TextView t54 = findViewById(R.id.b54);
//            t54.setText("");
//        } else if (b.equals("b55")) {
//            TextView t55 = findViewById(R.id.b55);
//            t55.setText("");
        } else {

        }
    }

    // EV3に命令を送る
    private void sendCommand() {
        connect = new SendToEv3(this.turn, String.valueOf(this.dis), String.valueOf(this.ang));
        connect.start();
    }
}
