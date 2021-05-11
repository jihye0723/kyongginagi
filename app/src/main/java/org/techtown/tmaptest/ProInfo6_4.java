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

public class ProInfo6_4 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo6_4(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("생명과학전공");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        adapter.addItem(new ProInfoItem("이옥민", "031-249-9643", "omlee@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("길성호", "031-249-9646", "shghil@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("공동수", "031-249-9649", "dskong@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이진성", "031-249-1306", "lejis@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("동 계", "031-249-1325", "dongke@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김진수", "031-249-9706", "herry1022@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("윤병수", "031-249-9645", "bsyoon@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김재수", "031-249-9648", "jkimtamu@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이영수", "031-249-9644", "ysyi@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("조경주", "031-249-1365", "kcho0611@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("곽현정", "--", "hjkwak@kgu.ac.kr"));

        proInfo_content.setAdapter(adapter);

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ProInfo6 pro = new ProInfo6();
        transaction.replace(R.id.tmap, pro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo6_4.this).commit();
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
