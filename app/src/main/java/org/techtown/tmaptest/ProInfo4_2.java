package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ProInfo4_2 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo4_2(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("사회복지전공");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        adapter.addItem(new ProInfoItem("박경숙", "031-249-9329", "kspark@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김형모", "031-249-9331", "hkim66@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("조원일", "031-249-9320", "tsukubacho@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("양소남", "031-249-9324", "snyang@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("박소연", "031-249-9334", "sypark@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김 욱", "031-249-9330", "wkim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("박능후", "031-249-9332", "npark@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("민소영", "031-249-9322", "graminso@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("주은선", "031-249-9333", "skyesjoo@kgu.ac.kr"));

        proInfo_content.setAdapter(adapter);

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ProInfo4 pro = new ProInfo4();
        transaction.replace(R.id.tmap, pro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo4_2.this).commit();
        fragmentManager.popBackStack();
    }

    //리스트뷰 어댑터 구현.
    class ProInfoAdapter extends BaseAdapter {
        ArrayList<ProInfoItem> items = new ArrayList<ProInfoItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(ProInfoItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ProInfoItemView proInfoItemView = null;
            if (convertView == null) {
                proInfoItemView = new ProInfoItemView(getActivity().getApplicationContext() );
            } else {
                proInfoItemView = (ProInfoItemView) convertView;
            }
            ProInfoItem item = items.get(position);
            proInfoItemView.setProName(item.getProName());
            proInfoItemView.setProCall(item.getProCall());
            proInfoItemView.setProMail(item.getProMail());
            return proInfoItemView;
        }
    }

}
