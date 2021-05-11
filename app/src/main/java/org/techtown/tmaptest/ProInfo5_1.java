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

public class ProInfo5_1 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo5_1(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("AI컴퓨터공학부");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        adapter.addItem(new ProInfoItem("권기현", "031-249-9666", "khkwon@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김인철", "031-249-9669", "kic@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이은정", "031-249-9671", "ejlee@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("안진호", "031-249-9674", "jhahn@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김희열", "031-249-9607", "heeyoul.kim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("배상원", "031-249-9677", "swbae@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김도훈", "031-249-1364", "karmy01@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("윤익준", "031-249-9642", "ijyoon@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("전준철", "031-249-9668", "jcchun@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김광훈", "031-249-9679", "kwang@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("권준희", "031-249-9675", "kwonjh@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김남기", "031-249-9662", "ngkim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이병대", "031-249-9676", "blee@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("정경용", "031-249-1382", "kychung@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("임현기", "031-249-1318", "hlim20@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("윤원현", "031-249-1306", "einstein@kgu.ac.kr"));
        proInfo_content.setAdapter(adapter);

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ProInfo5 pro = new ProInfo5();
        transaction.replace(R.id.tmap, pro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo5_1.this).commit();
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
