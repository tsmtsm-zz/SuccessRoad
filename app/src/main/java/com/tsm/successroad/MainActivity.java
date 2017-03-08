package com.tsm.successroad;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //活动的状态：1.运行状态，2.暂停状态，3.停止状态，4.销毁状态
    //活动的生存周期： onCreate()   ->  onStart()  ->  onResume()  -> onPause()  ->  onStop() -> onDestroy()  ->  onRestart()
    //
    private static final String TAG = "MainActivity";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.textview);
        Button bt = (Button) findViewById(R.id.button1);

        //在 <intent-filter>标签中在配置-个 <data> 标签，用于更精确地指定当前活动能够响应什么类型的数据
        //android:scheme:用于指定数据的协议部分，如http，geo表示地理位置，tel：表示拨打电话
        //android:host:用于指定数据的主机名部分，如www.baidu.con
        //android:port:用于指定数据的端口部分
        //android:path:用于指定主机名和端口之后的部分
        //android:mimeType:用于指定可以处理的数据类型，可以使用通配符
        //putExtra 传递数据

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = "hello senced activity";
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtra("extra_data",data);
                //startActivity(intent);
                startActivityForResult(intent,1); //返回数据给上一个活动

               // Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("tel:10086"));
               // startActivity(intent);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 1:
                if(resultCode == RESULT_OK){
                    String string = data.getStringExtra("data_return");
                    Log.d("MainActivity",string);
                    break;

                }
                default:
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
