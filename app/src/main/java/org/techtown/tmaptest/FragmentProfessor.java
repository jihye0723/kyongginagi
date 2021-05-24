package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class FragmentProfessor extends Fragment implements onBackPressedListener {

    //교수님 정보 버튼 (대학명 출력)
    private View view;
    private Button pro01,pro02,pro03,pro04,pro05,pro06,pro07;

    public FragmentProfessor(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_professor,container,false);

        //각 소속 대학 버튼
        pro01 = view.findViewById(R.id.pro01);
        pro01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo1 pro01= new ProInfo1();
                transaction.replace(R.id.tmap,pro01);
                transaction.commit();
            }
        });
        pro02 = view.findViewById(R.id.pro02);
        pro02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo2 pro02= new ProInfo2();
                transaction.replace(R.id.tmap,pro02);
                transaction.commit();
            }
        });
        pro03 = view.findViewById(R.id.pro03);
        pro03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo3 pro03= new ProInfo3();
                transaction.replace(R.id.tmap,pro03);
                transaction.commit();
            }
        });
        pro04 = view.findViewById(R.id.pro04);
        pro04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4 pro04= new ProInfo4();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro05 = view.findViewById(R.id.pro05);
        pro05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo5 pro05= new ProInfo5();
                transaction.replace(R.id.tmap,pro05);
                transaction.commit();
            }
        });
        pro06 = view.findViewById(R.id.pro06);
        pro06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo6 pro06= new ProInfo6();
                transaction.replace(R.id.tmap,pro06);
                transaction.commit();
            }
        });
        pro07 = view.findViewById(R.id.pro07);
        pro07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7 pro07= new ProInfo7();
                transaction.replace(R.id.tmap,pro07);
                transaction.commit();
            }
        });

        return view;
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(FragmentProfessor.this).commit();
        fragmentManager.popBackStack();
    }
}
