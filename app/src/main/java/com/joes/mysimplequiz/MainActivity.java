package com.joes.mysimplequiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnNo;
    private Button btnYes;
    private TextView txtQue;
    private ImageView img;
    private int CurrentIndex=0;
private Question[] questionBank=new Question[]{
        new Question(R.string.my_question1,true),
        new Question(R.string.my_question2,false),
        new Question(R.string.my_question3,false),
        new Question(R.string.my_question4,false),
        new Question(R.string.my_question5,true)
};
    private Integer images[]={R.mipmap.p1,R.mipmap.p2,R.mipmap.p3,R.mipmap.p4,R.mipmap.p5};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNo=findViewById(R.id.btnNo);
        btnYes=findViewById(R.id.btnYes);
        txtQue=findViewById(R.id.txtQue);
        img=findViewById(R.id.img);
        img.setImageResource(images[CurrentIndex]);
        btnNo.setOnClickListener(this);
        btnYes.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNo:
                //Toast.makeText(MainActivity.this,"No Button",Toast.LENGTH_SHORT).show();
                checkAns(false);
                CurrentIndex++;
                updateQue();
                break;
            case R.id.btnYes:
               // Toast.makeText(MainActivity.this,"Yes Button",Toast.LENGTH_SHORT).show();
                checkAns(true);
                CurrentIndex++;
                updateQue();
                break;

        }
    }
    private  void updateQue() {
        if(CurrentIndex<questionBank.length) {
            txtQue.setText(questionBank[CurrentIndex].getAnsId());
            img.setImageResource(images[CurrentIndex]);
        }else {
            txtQue.setText("Total Correct Ans : "+correctCount);
            btnYes.setVisibility(View.GONE);
            btnNo.setVisibility(View.GONE);
            img.setVisibility(View.GONE);
        }
    }

    private  static  int correctCount=0;
    private  void checkAns(boolean uans){
        boolean isTrue=questionBank[CurrentIndex].isAns();
        if(uans==isTrue){
            correctCount++;
        }
    }

}
