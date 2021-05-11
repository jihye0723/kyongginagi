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

public class ProInfo6 extends Fragment implements onBackPressedListener {

    //교수님 정보 버튼 (대학명 출력)
    private View view;
    private Button pro06_1,pro06_2,pro06_3,pro06_4,pro06_5;

    public ProInfo6(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro6,container,false);

        //각 소속 대학 버튼
        pro06_1 = view.findViewById(R.id.pro06_1);
        pro06_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo6_1 pro01= new ProInfo6_1();
                transaction.replace(R.id.tmap,pro01);
                transaction.commit();
            }
        });
        pro06_2 = view.findViewById(R.id.pro06_2);
        pro06_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo6_2 pro02= new ProInfo6_2();
                transaction.replace(R.id.tmap,pro02);
                transaction.commit();
            }
        });
        pro06_3 = view.findViewById(R.id.pro06_3);
        pro06_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo6_3 pro03= new ProInfo6_3();
                transaction.replace(R.id.tmap,pro03);
                transaction.commit();
            }
        });
        pro06_4 = view.findViewById(R.id.pro06_4);
        pro06_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo6_4 pro04= new ProInfo6_4();
                transaction.replace(R.id.tmap,pro04);
                transaction.commit();
            }
        });
        pro06_5 = view.findViewById(R.id.pro06_5);
        pro06_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo6_5 pro05= new ProInfo6_5();
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
