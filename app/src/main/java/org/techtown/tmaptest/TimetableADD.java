package org.techtown.tmaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;


public class TimetableADD extends FragmentActivity {

    EditText lecName_ed, proName_ed, detail_lecRoom_ed;
    String lecName, proName, detail_lecRoom;
    Spinner startLec_sp, finishLec_sp, lecRoom_sp, lecDay_sp;
    String startTime, finishTime, lecLoc, lecDay;
    TextView cancelBtn, addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀바 없애기.
        setContentView(R.layout.activity_timetalble_add);


        lecName_ed = (EditText)findViewById(R.id.lecName);
        proName_ed = (EditText)findViewById(R.id.proName);
        detail_lecRoom_ed = (EditText)findViewById(R.id.detail_lecRoom);

        // 스피너.
        startLec_sp = (Spinner)findViewById(R.id.StartLec_sp);
        finishLec_sp = (Spinner)findViewById(R.id.FinishLec_sp);
        lecRoom_sp = (Spinner)findViewById(R.id.LecRoom_sp);
        lecDay_sp = (Spinner)findViewById(R.id.LecDay_sp);
        // 스피너 아이템 클릭 이벤트.
        startLec_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                startTime = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        finishLec_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                finishTime = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lecDay_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lecDay = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        lecRoom_sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                lecLoc = String.valueOf(parent.getItemAtPosition(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // 취소, 추가 버튼 구현.
        cancelBtn = (TextView)findViewById(R.id.timeAdd_cancel);
        addBtn = (TextView)findViewById(R.id.timeAdd_ok);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //추가버튼 , 프래그먼트에 값 넘겨주기
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lecName = lecName_ed.getText().toString();
                proName  = proName_ed.getText().toString();
                detail_lecRoom = detail_lecRoom_ed.getText().toString();
                Intent intent= new Intent();
                Bundle bundle=new Bundle(7);
                bundle.putString("lecName",lecName);
                bundle.putString("proName", proName);
                bundle.putString("lecDay", lecDay);
                bundle.putString("startLec", startTime);
                bundle.putString("finishLec", finishTime);
                bundle.putString("detail_lecRoom", detail_lecRoom);
                bundle.putString("lecLoc", lecLoc);
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();

            }

        });


    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        int request=requestCode & 0xffff;;


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

}