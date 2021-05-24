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

public class ProInfo7 extends Fragment implements onBackPressedListener {

    //교수님 정보 버튼 (대학명 출력)
    private View view;
    private Button pro07_1,pro07_2,pro07_3,pro07_4,pro07_5,pro07_6,pro07_7,pro07_8,pro07_9,pro07_10;

    public ProInfo7(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro7,container,false);

        //각 소속 대학 버튼
        pro07_1 = view.findViewById(R.id.pro07_1);
        pro07_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_1 pro01= new ProInfo7_1();
                transaction.replace(R.id.tmap,pro01);
                transaction.commit();
            }
        });
        pro07_2 = view.findViewById(R.id.pro07_2);
        pro07_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_2 pro02= new ProInfo7_2();
                transaction.replace(R.id.tmap,pro02);
                transaction.commit();
            }
        });
        pro07_3 = view.findViewById(R.id.pro07_3);
        pro07_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_3 pro03= new ProInfo7_3();
                transaction.replace(R.id.tmap,pro03);
                transaction.commit();
            }
        });
        pro07_4 = view.findViewById(R.id.pro07_4);
        pro07_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_4 pro04= new ProInfo7_4();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro07_5 = view.findViewById(R.id.pro07_5);
        pro07_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_5 pro05= new ProInfo7_5();
                transaction.replace(R.id.tmap,pro05);
                transaction.commit();
            }
        });

        pro07_6 = view.findViewById(R.id.pro07_6);
        pro07_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_6 pro06= new ProInfo7_6();
                transaction.replace(R.id.tmap,pro06);
                transaction.commit();
            }
        });
        pro07_7 = view.findViewById(R.id.pro07_7);
        pro07_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_7 pro07= new ProInfo7_7();
                transaction.replace(R.id.tmap,pro07);
                transaction.commit();
            }
        });
        pro07_8 = view.findViewById(R.id.pro07_8);
        pro07_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_8 pro08= new ProInfo7_8();
                transaction.replace(R.id.tmap,pro08);
                transaction.commit();
            }
        });
        pro07_9 = view.findViewById(R.id.pro07_9);
        pro07_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_9 pro09= new ProInfo7_9();
                transaction.replace(R.id.tmap,pro09);
                transaction.commit();
            }
        });
        pro07_10 = view.findViewById(R.id.pro07_10);
        pro07_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_10 pro10= new ProInfo7_10();
                transaction.replace(R.id.tmap,pro10);
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
