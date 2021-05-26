package org.techtown.tmaptest;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AlertDialog;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentController;
import androidx.fragment.app.FragmentManager;


import java.util.Random;

import static android.app.Activity.RESULT_OK;

//각 좌표 수동 입력
public class FragmentTimetable extends Fragment implements onBackPressedListener {

    private ImageButton timetablebtn;
    //요일별 버튼
    //private TextView mon1, mon2, mon3, mon4, mon5, mon6, mon7, mon8, mon9;
    //private TextView tue1, tue2, tue3, tue4, tue5, tue6, tue7, tue8, tue9;
    //private TextView wed1, wed2, wed3, wed4, wed5, wed6, wed7, wed8, wed9;
    //private TextView thu1, thu2, thu3, thu4, thu5, thu6, thu7, thu8, thu9;
    //private TextView fri1, fri2, fri3, fri4, fri5, fri6, fri7, fri8, fri9;
    //private TextView time;
    //private View view;
    String day;
    int start,finish;
    View view;
    private int REQUEST_TEST=1;

    public FragmentTimetable(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_timetable, container, false);

        // DB 열기.
        DBHelper helper;
        SQLiteDatabase db;
        helper = new DBHelper(getContext(), "capdb.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        // 시간표 정보 DB 데이터 가져오기.
        String sql = "select * from myTime";
        Cursor c = db.rawQuery(sql, null);
        if(c != null) {
            while (c.moveToNext()) {
                String startTime = c.getString(c.getColumnIndex("startT"));
                String finishTime = c.getString(c.getColumnIndex("finishT"));
                String lecName = c.getString(c.getColumnIndex("lec_name"));
                String proName = c.getString(c.getColumnIndex("pro_name"));
                String detail_lecRoom = c.getString(c.getColumnIndex("lec_loc"));
                String lecDay = c.getString(c.getColumnIndex("lec_day"));


                switch(lecDay){
                    case ("월") : day="mon"; break;
                    case("화"): day="tue"; break;
                    case("수"): day="wed"; break;
                    case("목"): day="thu"; break;
                    case("금"): day="fri"; break; }

                switch(startTime){
                    case("1"): start=1; break;
                    case("2"): start=2; break;
                    case("3"): start=3; break;
                    case("4"): start=4; break;
                    case("5"): start=5; break;
                    case("6"): start=6; break;
                    case("7"): start=7; break;
                    case("8"): start=8; break;
                    case("9"): start=9; break; }

                // 강의 종료시간 finish
                switch(finishTime){
                    case("1"): finish=1; break;
                    case("2"): finish=2; break;
                    case("3"): finish=3; break;
                    case("4"): finish=4; break;
                    case("5"): finish=5; break;
                    case("6"): finish=6; break;
                    case("7"): finish=7; break;
                    case("8"): finish=8; break;
                    case("9"): finish=9; break; }

                Random random=new Random();
                int color=Color.rgb( random.nextInt(255),
                        random.nextInt(255),random.nextInt(255));


                int midtime = start + (finish - start)/ 2 ;
                //시작시간,종료시간,날짜 받아서 배경색넣기
                for(int i=start; i<=finish; i++) {
                    int resID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + i, null, null);
                    ((TextView) view.findViewById(resID)).setBackgroundColor(color);
                }
                if(finish-start<=1) {
                    int midID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + start, null, null);
                    TextView mid = (TextView) view.findViewById(midID);
                    mid.setTextSize(10);
                    mid.setText(lecName);

                    mid.setGravity(Gravity.CENTER);
                }
                else {
                    int upID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + (midtime-1), null, null);
                    TextView up = (TextView) view.findViewById(upID);
                    int midID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + midtime, null, null);
                    TextView down = (TextView) view.findViewById(midID);
                    up.setTextSize(10);
                    up.setText(lecName+"\n"+proName);
                    up.setGravity(Gravity.BOTTOM | Gravity.CENTER);
                    down.setTextSize(10);
                    down.setText(detail_lecRoom);
                    down.setPadding(0,0,0,0);
                    down.setGravity(Gravity.BOTTOM | Gravity.CENTER);

                }

            }
        }


        timetablebtn = (ImageButton) view.findViewById(R.id.timetablebtn);
        //시간표 버튼 누르면 창 뜨게
        timetablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimetableADD.class);
                startActivity(intent);
                //FragmentTimetable.super.startActivityForResult(intent, REQUEST_TEST);
            }

        });
        return view;
    }

    //add에서 입력한값 받아오기
   /*@Override
    @Nullable
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Bundle bundle = data.getExtras();
                String lecName = bundle.getString("lecName");
                String proName= bundle.getString("proName");
                String lecDay=bundle.getString("lecDay");
                String startTime=bundle.getString("startLec");
                String finishTime=bundle.getString("finishLec");
                String detail_lecRoom=bundle.getString("detail_lecRoom");
                String lecLoc=bundle.getString("lecLoc");
                //강의날짜 mon~fri넣기 day
                switch(lecDay){
                    case ("월") : day="mon"; break;
                    case("화"): day="tue"; break;
                    case("수"): day="wed"; break;
                    case("목"): day="thu"; break;
                    case("금"): day="fri"; break; }
                //강의 시작시간 start
                switch(startTime){
                    case("1"): start=1; break;
                    case("2"): start=2; break;
                    case("3"): start=3; break;
                    case("4"): start=4; break;
                    case("5"): start=5; break;
                    case("6"): start=6; break;
                    case("7"): start=7; break;
                    case("8"): start=8; break;
                    case("9"): start=9; break; }
                //강의 종료시간 finish
                switch(finishTime){
                    case("1"): finish=1; break;
                    case("2"): finish=2; break;
                    case("3"): finish=3; break;
                    case("4"): finish=4; break;
                    case("5"): finish=5; break;
                    case("6"): finish=6; break;
                    case("7"): finish=7; break;
                    case("8"): finish=8; break;
                    case("9"): finish=9; break; }

                    //배경색 랜덤,투명도 설정
                Random random=new Random();
                int color=Color.rgb( random.nextInt(255),
                        random.nextInt(255),random.nextInt(255));


                if (bundle != null) {
                    int midtime = start + (finish - start)/ 2 ;
                    //시작시간,종료시간,날짜 받아서 배경색넣기
                    for(int i=start; i<=finish; i++) {
                        int resID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + i, null, null);
                        ((TextView) view.findViewById(resID)).setBackgroundColor(color);}
                        //시간표 정보 출력


                            if (finish-start<=1) {
                                int midID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + start, null, null);
                                TextView mid = (TextView) view.findViewById(midID);
                                mid.setTextSize(10);
                                mid.setText(lecName);

                                mid.setGravity(Gravity.CENTER);

                            }
                            else {
                                int upID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + (midtime-1), null, null);
                                TextView up = (TextView) view.findViewById(upID);
                                int midID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + midtime, null, null);
                                TextView down = (TextView) view.findViewById(midID);
                                up.setTextSize(10);
                                up.setText(lecName+"\n"+proName);
                                up.setGravity(Gravity.BOTTOM | Gravity.CENTER);
                                down.setTextSize(10);
                                down.setText(detail_lecRoom);
                                down.setPadding(0,0,0,0);
                                down.setGravity(Gravity.BOTTOM | Gravity.CENTER);

                            }

                    }


            }

        }

    }*/




    @Override
    public void onBackPressed() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(FragmentTimetable.this).commit();
        fragmentManager.popBackStack();
    }
}