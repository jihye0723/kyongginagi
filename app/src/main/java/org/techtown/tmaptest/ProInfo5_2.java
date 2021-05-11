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

public class ProInfo5_2 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo5_2(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("산업경영공학전공");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        adapter.addItem(new ProInfoItem("원중연", "031-249-9750", "jywon@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김현수", "031-249-9753", "hskim@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김용수", "031-249-9771", "kimys@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("오요셉", "031-249-9770", "yosep.oh@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("심현식", "031-249-1348", "hssim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("조면식", "031-249-9751", "mscho@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("장태우", "031-249-9754", "keenbee@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("성시일", "031-249-9749", "sisung@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이영수", "031-249-1338", "upline@kgu.ac.kr"));

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
        fragmentManager.beginTransaction().remove(ProInfo5_2.this).commit();
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
