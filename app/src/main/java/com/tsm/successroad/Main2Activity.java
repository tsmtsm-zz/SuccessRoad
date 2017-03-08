package com.tsm.successroad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Main2Activity";
    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.secendactivity);
        final Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(data);

        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        et = (EditText)findViewById(R.id.et);



    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.button:
                Intent intent1 = new Intent();
                intent1.putExtra("data_return","mememememem");
                setResult(RESULT_OK,intent1);
                finish();
                Log.d(TAG, "onClick: fi");
                break;
            case R.id.button2:
                String string = et.getText().toString();
                Toast.makeText(this, string,Toast.LENGTH_LONG).show();
                break;
            default:
                break;

        }
    }

    @Override
    public void onBackPressed() {
        Intent intent1 = new Intent();
        intent1.putExtra("data_return","mememememem");
        setResult(RESULT_OK,intent1);
        finish();
    }
}
