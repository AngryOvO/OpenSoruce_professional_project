package com.example.week6_9;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        //앞 화면에서 보낸 투표 결과 값을 받는다.
        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        //9개의 TextView, Rating Bar 객체배열
        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];
        Integer imageField[]={R.drawable.pic1,R.drawable.pic2,R.drawable.pic2,R.drawable.pic3,R.drawable.pic4,
                R.drawable.pic5,R.drawable.pic6,R.drawable.pic7,R.drawable.pic8,R.drawable.pic9};
        TextView tvTop=(TextView)findViewById(R.id.tvTop);
        ImageView ivTop=(ImageView)findViewById(R.id.ivTop);

        int max_index=0;
        for(int i=0;i<voteResult.length;++i){
            if (voteResult[max_index]<voteResult[i])
                max_index=i;
        }
        tvTop.setText(imageName[max_index]);
        ivTop.setImageResource(imageField[max_index]);

        //9개의 TextView, Rating Bar ID 배열
        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3,
                R.id.tv4, R.id.tv5, R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3,
                R.id.rbar4, R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };

        for (int i = 0; i<voteResult.length; i++){
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        //각 TextView 및 RatingBar 에 넘겨 받은값을 반영
        for (int i=0; i<voteResult.length; i++){
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float)voteResult[i]);
        }





        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });
    }
}