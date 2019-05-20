package com.company.twoactivities3;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et_message;
    Button bt_send;
    TextView tv_msgretour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_message = findViewById(R.id.et_message);
        bt_send = findViewById(R.id.bt_send);
        tv_msgretour = findViewById(R.id.tv_msg_retour);


        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //traitement du click
                Intent i_Act2 = new Intent(getApplicationContext(), Main2Activity.class);
                i_Act2.putExtra("message", et_message.getText().toString());
                startActivityForResult(i_Act2, 101);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {//Main2activity
            if (resultCode == RESULT_OK){
                String msg_back = data.getExtras().getString("msg_back");
                tv_msgretour.setText(msg_back);
            }
            else if (resultCode == RESULT_CANCELED){}
        }

    }
}
