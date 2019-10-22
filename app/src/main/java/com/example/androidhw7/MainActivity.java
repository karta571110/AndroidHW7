package com.example.androidhw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String inputapage;
    int BtoAbtnClicktime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent BtoA = getIntent();

        Button AtoBbtn = (Button) findViewById(R.id.AtoB);
        final EditText Apageeditext = (EditText) findViewById(R.id.ApageeditText);
        TextView Bresult = (TextView) findViewById(R.id.Bresult);
        BtoAbtnClicktime = BtoA.getIntExtra("Clicktime", 0);
        if (BtoAbtnClicktime >= 1) {
            Bresult.setText(BtoA.getStringExtra("Aresult"));
        }


        AtoBbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (("".equals(Apageeditext.getText().toString()))) {
                    Toast error = Toast.makeText(MainActivity.this, "請輸入隨意字母", Toast.LENGTH_SHORT);
                    error.show();
                }
                if (!("".equals(Apageeditext.getText().toString()))) {
                    inputapage = Apageeditext.getEditableText().toString();

                    Intent AtoB = new Intent(MainActivity.this, Bpage.class);
                    AtoB.putExtra("Bresult", "我從Apage來的" + inputapage);
                    startActivity(AtoB);
                }

            }
        });
    }
}
