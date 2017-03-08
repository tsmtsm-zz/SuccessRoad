package com.tsm.successroad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.Format;
import java.util.Formattable;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Main2Activity";
    private EditText et;
    private ProgressBar pb;
    private  int progress;
    private int text =10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.secendactivity);
        final Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
      //  if (savedInstanceState != null)
      //      progress = savedInstanceState.getInt("progress");
      //  else
      //      progress = 0;
        TextView textView = (TextView)findViewById(R.id.textView);
        textView.setText(data);
       // text =100;
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(this);

        Button button2 = (Button)findViewById(R.id.button2);
        button2.setOnClickListener(this);

        Button button3 = (Button)findViewById(R.id.button3);
        button3.setOnClickListener(this);

        et = (EditText)findViewById(R.id.et);
        pb = (ProgressBar) findViewById(R.id.progressbar);
        pb.setProgress(progress);

        Log.d(TAG, "onCreate: ");



    }

    @Override
    protected void onPause() {
        super.onPause();
        progress = pb.getProgress();
        String s = String.format("%d",progress);
        Log.d(TAG, "onPause: "+s);
    }

    @Override
    protected void onResume() {
        super.onResume();
        pb.setProgress(progress);
        String s = String.format("%d",progress);
        Log.d(TAG, "onResume: "+s);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("progress",pb.getProgress());
        Log.d(TAG, "onSaveInstanceState: ");

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
            case R.id.button3:
                 progress = pb.getProgress();
                progress += 10;
                pb.setProgress(progress);
                text -= 40;
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
