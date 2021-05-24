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

public class ProInfo4 extends Fragment implements onBackPressedListener {

    //교수님 정보 버튼 (대학명 출력)
    private View view;
    private Button pro04_1,pro04_2,pro04_3,pro04_4,pro04_5,pro04_6,pro04_7,pro04_8,pro04_9,pro04_10,pro04_11;

    public ProInfo4(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro4,container,false);

        //각 소속 대학 버튼
        pro04_1 = view.findViewById(R.id.pro04_1);
        pro04_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_1 pro01= new ProInfo4_1();
                transaction.replace(R.id.tmap,pro01);
                transaction.commit();
            }
        });
        pro04_2 = view.findViewById(R.id.pro04_2);
        pro04_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_2 pro02= new ProInfo4_2();
                transaction.replace(R.id.tmap,pro02);
                transaction.commit();
            }
        });
        pro04_3 = view.findViewById(R.id.pro04_3);
        pro04_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_3 pro03= new ProInfo4_3();
                transaction.replace(R.id.tmap,pro03);
                transaction.commit();
            }
        });
        pro04_4 = view.findViewById(R.id.pro04_4);
        pro04_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_4 pro04= new ProInfo4_4();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro04_5 = view.findViewById(R.id.pro04_5);
        pro04_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_5 pro05= new ProInfo4_5();
                transaction.replace(R.id.tmap,pro05);
                transaction.commit();
            }
        });
        pro04_6 = view.findViewById(R.id.pro04_6);
        pro04_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_6 pro06= new ProInfo4_6();
                transaction.replace(R.id.tmap,pro06);
                transaction.commit();
            }
        });
        pro04_7 = view.findViewById(R.id.pro04_7);
        pro04_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_7 pro07= new ProInfo4_7();
                transaction.replace(R.id.tmap,pro07);
                transaction.commit();
            }
        });
        pro04_8 = view.findViewById(R.id.pro04_8);
        pro04_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_8 pro08= new ProInfo4_8();
                transaction.replace(R.id.tmap,pro08);
                transaction.commit();
            }
        });
        pro04_9 = view.findViewById(R.id.pro04_9);
        pro04_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_9 pro09= new ProInfo4_9();
                transaction.replace(R.id.tmap,pro09);
                transaction.commit();
            }
        });
        pro04_10 = view.findViewById(R.id.pro04_10);
        pro04_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_10 pro10= new ProInfo4_10();
                transaction.replace(R.id.tmap,pro10);
                transaction.commit();
            }
        });
        pro04_11 = view.findViewById(R.id.pro04_11);
        pro04_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo4_11 pro11= new ProInfo4_11();
                transaction.replace(R.id.tmap,pro11);
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
