package com.company.twoactivities3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv_msg_recu;
    Button bt_send_back;
    EditText et_msg_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv_msg_recu = findViewById(R.id.tv_msg_recu);
        bt_send_back = findViewById(R.id.bt_send_back);
        et_msg_back = findViewById(R.id.et_msg_back);


        Intent i = getIntent();
        String msg =  i.getExtras().getString("message");

        tv_msg_recu.setText(msg);

        bt_send_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_back = new Intent();
                i_back.putExtra("msg_back", et_msg_back.getText().toString());
                setResult(RESULT_OK, i_back);
                finish();
            }
        });


    }
}
