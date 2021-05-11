package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ProInfo2 extends Fragment implements onBackPressedListener {

    //교수님 정보 버튼 (대학명 출력)
    private View view;
    private Button pro01,pro02,pro03,pro04,pro05,pro06,pro07;

    public ProInfo2(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro2,container,false);

        //각 소속 대학 버튼
        pro01 = view.findViewById(R.id.pro02_1);
        pro01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_1 pro01= new ProInfo2_1();
                transaction.replace(R.id.tmap,pro01);
                transaction.commit();
            }
        });
        pro02 = view.findViewById(R.id.pro02_2);
        pro02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_2 pro02= new ProInfo2_2();
                transaction.replace(R.id.tmap,pro02);
                transaction.commit();
            }
        });
        pro03 = view.findViewById(R.id.pro02_3);
        pro03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_3 pro03= new ProInfo2_3();
                transaction.replace(R.id.tmap,pro03);
                transaction.commit();
            }
        });
        pro04 = view.findViewById(R.id.pro02_4);
        pro04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_4 pro04= new ProInfo2_4();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro05 = view.findViewById(R.id.pro02_5);
        pro05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_5 pro05= new ProInfo2_5();
                transaction.replace(R.id.tmap,pro05);
                transaction.commit();
            }
        });
        pro06 = view.findViewById(R.id.pro02_6);
        pro06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_6 pro06= new ProInfo2_6();
                transaction.replace(R.id.tmap,pro06);
                transaction.commit();
            }
        });
        pro07 = view.findViewById(R.id.pro02_7);
        pro07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2_7 pro07= new ProInfo2_7();
                transaction.replace(R.id.tmap,pro07);
                transaction.commit();
            }
        });


        return view;
    }
    @Override
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
