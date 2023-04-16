package com.example.week6_9;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("명화 선호도 투표");

        final int voteCount[] = new int[9];
        for(int i=0; i<9; i++) {
            voteCount[i] = 0;
            //9개의 이미지 버튼 객체배열
        }
        ImageView image[] = new ImageView[9];
        // 9개의 이미지버튼 ID 배열

        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4,
                R.id.iv5, R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };

        final String imgName[] = { "pic1", "2019038024_이동민", "pic3", "pic4", "pic5", "pic6", "pic7", "pic8", "pic9"};

        for (int i = 0; i<imageId.length; i++){
            final int index;
            index = i;
            image[index] = (ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    //투표수 증가
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),
                            imgName[index]+": 총"+ voteCount[index] +" 표",
                            Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button btnFinish = (Button) findViewById(R.id.btnResult);
        btnFinish.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("VoteCount", voteCount);
                intent.putExtra("ImageName", imgName);
                startActivity(intent);
            }
        });
    }
}