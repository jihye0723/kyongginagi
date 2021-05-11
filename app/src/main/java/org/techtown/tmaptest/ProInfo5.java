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

public class ProInfo5 extends Fragment implements onBackPressedListener {

    //교수님 정보 버튼 (대학명 출력)
    private View view;
    private Button pro05_1,pro05_2,pro05_3,pro05_4,pro05_5,pro05_6;

    public ProInfo5(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro5,container,false);

        //각 소속 대학 버튼
        pro05_1 = view.findViewById(R.id.pro05_1);
        pro05_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5_1 pro01= new ProInfo5_1();
                transaction.replace(R.id.tmap,pro01);
                transaction.commit();
            }
        });
        pro05_2 = view.findViewById(R.id.pro05_2);
        pro05_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5_2 pro02= new ProInfo5_2();
                transaction.replace(R.id.tmap,pro02);
                transaction.commit();
            }
        });
        pro05_3 = view.findViewById(R.id.pro05_3);
        pro05_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5_3 pro03= new ProInfo5_3();
                transaction.replace(R.id.tmap,pro03);
                transaction.commit();
            }
        });
        pro05_4 = view.findViewById(R.id.pro05_4);
        pro05_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5_4 pro04= new ProInfo5_4();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro05_5 = view.findViewById(R.id.pro05_5);
        pro05_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5_5 pro04= new ProInfo5_5();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro05_6 = view.findViewById(R.id.pro05_6);
        pro05_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5_6 pro05= new ProInfo5_6();
                transaction.replace(R.id.tmap,pro05);
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
