package com.example.lenovo.chenk;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
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

    int count = 0;

    public void check(View view) {
        count++;
        final EditText ediText = (EditText) findViewById(R.id.et);
        final TextView textview = (TextView) findViewById(R.id.tv);

        if(count == 1) {
            if (ediText.getText().toString().contains("'m")) {
                SpannableStringBuilder builder = new SpannableStringBuilder(ediText.getText().toString());
                ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
                builder.setSpan(redSpan, 1, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                ediText.setText(builder);

                textview.setText(" 'm -> am");
                textview.setTextSize(35);

                final ImageButton b1 = new ImageButton(this);
                final ImageButton b2 = new ImageButton(this);
                final LinearLayout linear1 = (LinearLayout) findViewById(R.id.linearlay_1);
                final LinearLayout linear2 = (LinearLayout) findViewById(R.id.linearlay_2);

                            b1.setBackgroundResource(R.drawable.yes);
                            linear2.addView(b1);
                            b1.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View v) {
                                    ediText.setText("I am XXX");
                                    linear1.removeAllViews();
                                    linear2.removeAllViews();
                                    textview.setText("");
                                    count = 0;
                                }
                            });

                            b2.setBackgroundResource(R.drawable.no);
                            linear1.addView(b2);
                            b2.setOnClickListener(new View.OnClickListener() {

                                @Override
                                public void onClick(View v) {
                                    linear1.removeAllViews();
                                    linear2.removeAllViews();
                                    textview.setText("");
                                    SpannableStringBuilder builder = new SpannableStringBuilder(ediText.getText().toString());
                                    ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.BLACK);
                                    builder.setSpan(redSpan, 1, 4, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                                    ediText.setText(builder);
                                }
                            });


            }
        }
            else if(ediText.getText().toString().contains("like study")) {
            SpannableStringBuilder builder = new SpannableStringBuilder(ediText.getText().toString());
            ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.RED);
            builder.setSpan(redSpan, 6, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            ediText.setText(builder);


                textview.setText(" study -> to study");
                textview.setTextSize(27);

                final ImageButton b1 = new ImageButton(this);
                final ImageButton b2 = new ImageButton(this);

                final LinearLayout linear2 = (LinearLayout) findViewById(R.id.linearlay_2);

                final LinearLayout linear1 = (LinearLayout) findViewById(R.id.linearlay_1);

                b1.setBackgroundResource(R.drawable.yes);
                linear2.addView(b1);
                b1.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        if (ediText.getText().toString().contains("."))
                            ediText.setText("I like to study English.");
                        else
                            ediText.setText("I like to study English");
                        linear1.removeAllViews();
                        linear2.removeAllViews();
                        textview.setText("");
                    }
                });

                b2.setBackgroundResource(R.drawable.no);
                linear1.addView(b2);
                b2.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        linear1.removeAllViews();
                        linear2.removeAllViews();
                        textview.setText("");
                        SpannableStringBuilder builder = new SpannableStringBuilder(ediText.getText().toString());
                        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.BLACK);
                        builder.setSpan(redSpan, 6, 12, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                        ediText.setText(builder);
                    }
                });
            }

    }

}
