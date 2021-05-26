package org.techtown.tmaptest;

import android.app.Activity;
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
import androidx.fragment.app.FragmentTransaction;


import com.skt.Tmap.TMapPoint;

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
    View view;
    private int REQUEST_TEST=1106;

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
                int startTime = c.getInt(c.getColumnIndex("startT"));
                int finishTime = c.getInt(c.getColumnIndex("finishT"));
                String lecName = c.getString(c.getColumnIndex("lec_name"));
                String proName = c.getString(c.getColumnIndex("pro_name"));
                String detail_lecRoom = c.getString(c.getColumnIndex("lec_loc"));
                String lecDay = c.getString(c.getColumnIndex("lec_day"));
                int color = c.getInt(c.getColumnIndex("color"));


                switch(lecDay){
                    case ("월") : day="mon"; break;
                    case("화"): day="tue"; break;
                    case("수"): day="wed"; break;
                    case("목"): day="thu"; break;
                    case("금"): day="fri"; break; }


                int midtime = startTime + (finishTime - startTime)/ 2 ;
                //시작시간,종료시간,날짜 받아서 배경색넣기
                for(int i=startTime; i<=finishTime; i++) {
                    int resID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + i, null, null);
                    ((TextView) view.findViewById(resID)).setBackgroundColor(color);
                }
                if(finishTime-startTime<=1) {
                    int midID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + startTime, null, null);
                    int secID= getResources().getIdentifier("org.techtown.tmaptest:id/" + day + (startTime+1), null, null);
                    TextView mid = (TextView) view.findViewById(midID);
                    TextView sec = (TextView) view.findViewById(secID);
                    if(finishTime-startTime==1){
                        mid.setTextSize(10);
                        mid.setText(lecName+"\n"+proName);
                        sec.setText(detail_lecRoom);
                        sec.setTextSize(10);
                        sec.setGravity(Gravity.CENTER);
                    }
                    else if (finishTime-startTime==0){
                        mid.setTextSize(7);
                        mid.setText(lecName+"\n"+proName+"\n"+detail_lecRoom);
                        mid.setGravity(Gravity.CENTER);}
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

                for(int i=startTime; i<=finishTime; i++) {
                    int deleteID = getResources().getIdentifier("org.techtown.tmaptest:id/" + day + i, null, null);
                    TextView delete = (TextView) view.findViewById(deleteID);
                    delete.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyAlertDialogStyle);
                            builder
                                    .setMessage("해당 시간표를 삭제하시겠습니까 ?")
                                    .setCancelable(false)
                                    .setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            String sql1="DELETE FROM myTime WHERE lec_day='"+lecDay+"' and startT='"+startTime+"' and finishT='"+finishTime+"'";

                                            db.execSQL(sql1);
                                            refresh();

                                        }
                                    })
                                    .setNeutralButton("취소", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialogInterface, int i) {
                                            dialogInterface.cancel();
                                        }
                                    });
                            AlertDialog alertDialog = builder.create();
                            alertDialog.show();
                        }
                    });
                }

            }
        }


        timetablebtn = (ImageButton) view.findViewById(R.id.timetablebtn);
        //시간표 버튼 누르면 창 뜨게
        timetablebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TimetableADD.class);
                getActivity().startActivityForResult(intent, REQUEST_TEST);
                //FragmentTimetable.super.startActivityForResult(intent, REQUEST_TEST);
            }

        });
        return view;
    }



    @Override
    public void onBackPressed() {
        goToMain();
    }

    public void refresh(){
        FragmentTransaction transaction=getFragmentManager().beginTransaction();
        transaction.detach(this).attach(this).commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(FragmentTimetable.this).commit();
        fragmentManager.popBackStack();
    }
}