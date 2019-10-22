package com.example.androidhw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bpage extends AppCompatActivity {
    String inputbpage;
    int Clicktime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent AtoB = getIntent();

        Button BtoAbtn = (Button) findViewById(R.id.AtoB);
        final EditText Bpageeditext = (EditText) findViewById(R.id.ApageeditText);
        TextView Aresult = (TextView) findViewById(R.id.Bresult);

        Aresult.setText(AtoB.getStringExtra("Bresult"));

        BtoAbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (("".equals(Bpageeditext.getText().toString()))) {
                    Toast error = Toast.makeText(Bpage.this, "請輸入隨意字母", Toast.LENGTH_SHORT);
                    error.show();
                }
                if (!("".equals(Bpageeditext.getText().toString()))) {
                    Clicktime++;
                    inputbpage = Bpageeditext.getEditableText().toString();
                    Intent BtoA = new Intent(Bpage.this, MainActivity.class);
                    BtoA.putExtra("Clicktime", Clicktime);
                    BtoA.putExtra("Aresult", "我是從Bpage傳來的" + inputbpage);
                    startActivity(BtoA);

                }
            }
        });
    }
}
