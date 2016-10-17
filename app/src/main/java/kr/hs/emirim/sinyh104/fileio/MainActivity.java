package kr.hs.emirim.sinyh104.fileio;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button butOut,butIn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        butOut=(Button)findViewById(R.id.but_out);
        butIn=(Button)findViewById(R.id.but_in);
        butOut.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                try {
                    FileOutputStream out=openFileOutput("1017shin.txt", Context.MODE_WORLD_WRITEABLE);//오늘은 10월 17일
                    String massage="미림정보과학고 학생들이 제일 예쁘다.";
                    try {
                        out.write(massage.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    out.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });//익명 클래스
        butIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileInputStream in=openFileInput("1017shin.txt");
                    byte[] readMassage=new byte[200];
                    try {
                        in.read(readMassage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Toast.makeText(getApplicationContext(),new String(readMassage),Toast.LENGTH_LONG).show();
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (FileNotFoundException e) {
                    Toast.makeText(getApplicationContext(),"파일이 존재하지 않습니다.",Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}
