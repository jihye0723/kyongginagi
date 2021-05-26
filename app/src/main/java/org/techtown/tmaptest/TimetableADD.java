package org.techtown.tmaptest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentManager;

import java.util.Random;


public class TimetableADD extends FragmentActivity {

    EditText lecName_ed, proName_ed, detail_lecRoom_ed;
    String lecName, proName, detail_lecRoom;
    Spinner startLec_sp, finishLec_sp, lecRoom_sp, lecDay_sp;
    String startTime, finishTime, lecLoc, lecDay;
    int color;
    TextView cancelBtn, addBtn;

    private View header;

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

                // DB 열기.
                DBHelper helper;
                SQLiteDatabase db;
                helper = new DBHelper(TimetableADD.this, "capdb.db", null, 1);
                db = helper.getWritableDatabase();
                helper.onCreate(db);
                ContentValues cv = new ContentValues();

                // 중복 확인 값.
                String sql = "select lec_name from myTime " +
                        "where lec_day='"+lecDay+"' and " +
                        "((startT between '"+Integer.parseInt(startTime)+"' and '"+Integer.parseInt(finishTime)+"') or " +
                        "(finishT between'"+Integer.parseInt(startTime)+"' and '"+Integer.parseInt(finishTime)+"') or"+
                        "((startT <= '"+Integer.parseInt(startTime)+"')and(finishT>='"+Integer.parseInt(finishTime)+"')));";
                Cursor c = db.rawQuery(sql, null);
                String redup = "";
                if(c != null) {
                    while (c.moveToNext())
                        redup = c.getString(c.getColumnIndex("lec_name"));
                }

                // ..교시 ~ ..교시 잘못 썼을때 Toast 메세지
                if(Integer.parseInt(startTime) > Integer.parseInt(finishTime))
                    Toast.makeText(getApplicationContext(), "강의시간을 올바르게 선택해주세요.", Toast.LENGTH_SHORT).show();
                else if(lecName.equals(""))
                    Toast.makeText(getApplicationContext(), "과목명을 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(proName.equals(""))
                    Toast.makeText(getApplicationContext(), "교수명을 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(detail_lecRoom.equals(""))
                    Toast.makeText(getApplicationContext(), "강의동을 입력해주세요.", Toast.LENGTH_SHORT).show();
                else if(redup.equals("") == false)
                    Toast.makeText(getApplicationContext(), "시간표가 겹칩니다.", Toast.LENGTH_SHORT).show();
                else {
                    // 추가할지 한번 더 물어보기.
                    AlertDialog.Builder builder = new AlertDialog.Builder(TimetableADD.this,R.style.MyAlertDialogStyle);
                    builder.setTitle("시간표 추가");
                    builder.setMessage("입력한 것을 추가하시겠습니까?");
                    builder.setPositiveButton("예", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Random random=new Random();
                            color= Color.rgb( random.nextInt(255), random.nextInt(255),random.nextInt(255));

                            // DB에 값 넣기.
                            cv.put("startT", Integer.parseInt(startTime));
                            cv.put("finishT", Integer.parseInt(finishTime));
                            cv.put("lec_name", lecName);
                            cv.put("pro_name", proName);
                            cv.put("lec_loc", detail_lecRoom);
                            cv.put("lec_day", lecDay);
                            cv.put("color", color);
                            long result = db.insert("myTime", null, cv);
                            if(result == -1) {
                                Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_SHORT).show(); }
                            else {
                                Toast.makeText(getApplicationContext(), "시간표를 추가하였습니다.", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), FragmentTimetable.class);
                                setResult(RESULT_OK,intent);
                                finish(); }
                        }});
                    builder.setNegativeButton("아니오", null);
                    builder.create().show();
                }

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