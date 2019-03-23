package com.example.lenovo.chenk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void check(View view)  {
        final EditText ediText = (EditText) findViewById(R.id.et);
        final TextView textview = (TextView) findViewById(R.id.tv);

        textview.setText(" 'm -> am");
        textview.setTextSize(35);

        final TextView tv=new TextView(this);
        final ImageButton b1 = new ImageButton(this);
        final ImageButton b2 = new ImageButton(this);

        LinearLayout linear=(LinearLayout) findViewById(R.id.linearlay_2);
        Button btn = new Button(this);
        btn.setText("Correct");
        btn.setTextSize(25);
        btn.setBackgroundResource(R.drawable.button_selector);
        linear.addView(btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final LinearLayout linear=(LinearLayout) findViewById(R.id.linearlay_1);

                tv.setText("am");
                tv.setTextSize(30);
                tv.setBackgroundResource(R.drawable.bg_rectangle_corner);
                linear.addView(tv);

                b1.setBackgroundResource(R.drawable.yes);
                linear.addView(b1);
                b1.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ediText.setText("I am XXX");
                        linear.removeAllViews();
                    }
                });

                b2.setBackgroundResource(R.drawable.no);
                linear. addView ( b2 );
                b2.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        linear.removeAllViews();
                    }
                });
            }
        });

    }

}
