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

public class ProInfo5_4 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo5_4(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("경영학전공");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        adapter.addItem(new ProInfoItem("김성우", "031-249-9431", "swkim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("서재현", "031-249-9434", "jhseo@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이동희", "031-249-9426", "dhl@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("진창현", "031-249-9427", "chjin@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("최성우", "031-249-9429", "swchoi@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이희정", "031-249-9460", "hjlee2016@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이평수", "031-249-9457", "pyoungsoo@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이청림", "031-249-1369", "cllee76@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김주일", "031-249-1304", "kji_99@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("윤성준", "020-249-9406", "sjyoon@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("문규현", "031-249-9433", "ghmoon@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("유성민", "031-249-9423", "ryu@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김나민", "031-249-9464", "naminkim@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김한수", "031-249-9436", "kimhansoo@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("강상구", "031-249-9563", "kang409@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이정원", "031-249-8937", "jwlee419@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("박용진", "031-249-9425", "yjpark777@kgu.ac.kr"));

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
        fragmentManager.beginTransaction().remove(ProInfo5_4.this).commit();
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
