package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ProInfo3 extends Fragment implements onBackPressedListener {
    private View view;
    private Button button1, button2, button3,button4,button5,button6,button7,button8;

    public ProInfo3() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro3, container, false);

        //과 클릭
        button1 = view.findViewById(R.id.pro03_01);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_1 pro03_01 = new ProInfo3_1();
                transaction.replace(R.id.tmap, pro03_01);
                transaction.commit();
            }
        });
        button2 = view.findViewById(R.id.pro03_02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_2 pro03_02 = new ProInfo3_2();
                transaction.replace(R.id.tmap, pro03_02);
                transaction.commit();
            }
        });
        button3 = view.findViewById(R.id.pro03_03);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_3 pro03_03 = new ProInfo3_3();
                transaction.replace(R.id.tmap, pro03_03);
                transaction.commit();
            }
        });
        button4 = view.findViewById(R.id.pro03_04);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_4 pro03_04 = new ProInfo3_4();
                transaction.replace(R.id.tmap, pro03_04);
                transaction.commit();
            }
        });
        button5 = view.findViewById(R.id.pro03_05);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_5 pro03_05 = new ProInfo3_5();
                transaction.replace(R.id.tmap, pro03_05);
                transaction.commit();
            }
        });
        button6 = view.findViewById(R.id.pro03_06);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_6 pro03_06 = new ProInfo3_6();
                transaction.replace(R.id.tmap, pro03_06);
                transaction.commit();
            }
        });
        button7 = view.findViewById(R.id.pro03_07);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_7 pro03_07 = new ProInfo3_7();
                transaction.replace(R.id.tmap, pro03_07);
                transaction.commit();
            }
        });
        button8 = view.findViewById(R.id.pro03_08);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3_8 pro03_08 = new ProInfo3_8();
                transaction.replace(R.id.tmap, pro03_08);
                transaction.commit();
            }
        });

    return view;
    }


    public void onBackPressed() {
        goToBack();
    }

    //이전 프래그먼트로 돌아가기.
    private void goToBack(){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        FragmentProfessor pro= new FragmentProfessor();
        transaction.replace(R.id.tmap,pro);
        transaction.commit();
    }
}





