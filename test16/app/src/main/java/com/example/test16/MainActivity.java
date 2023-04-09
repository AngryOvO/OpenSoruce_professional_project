package com.example.test16;

import java.io.File;
import java.io.FileFilter;
import android.os.Environment;
import androidx.appcompat.app.*;
import androidx.core.app.ActivityCompat;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;
import android.Manifest;

public class MainActivity extends AppCompatActivity {

    Button btnPrev,btnNext;
    MyPictureView mypicture;
    int curNum=1;
    File[] imageFiles;
    String imageFname;
    TextView textView1;
    @Override
    protected void onStart() {
        super.onStart();
        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);
        setContentView(R.layout.activity_main);
        setTitle("간단 이미지뷰어");
        btnPrev=(Button)findViewById(R.id.btnPrev);
        btnNext=(Button)findViewById(R.id.btnNext);
        textView1=(TextView)findViewById(R.id.textview1);
        mypicture=(MyPictureView)findViewById(R.id.myPictureView1);
        imageFiles= new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/Pictures").listFiles();
        imageFname=imageFiles[0].toString();
        mypicture.imagePath=imageFname;
        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum<=1)
                {
                    curNum=imageFiles.length;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();
                    textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
                    //Toast.makeText(getApplicationContext(),"첫번쨰 그립입니다.",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    curNum--;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();
                    textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
                }
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(curNum>=imageFiles.length)
                {
                    curNum=1;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();
                    textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
                    //Toast.makeText(getApplicationContext(),"마지막 그림입니다.",Toast.LENGTH_SHORT).show();
                }
                else {curNum++;
                    imageFname=imageFiles[curNum-1].toString();
                    mypicture.imagePath=imageFname;
                    mypicture.invalidate();}
                textView1.setText(String.valueOf(curNum)+"/"+String.valueOf(imageFiles.length));
            }
        });
    }

}
