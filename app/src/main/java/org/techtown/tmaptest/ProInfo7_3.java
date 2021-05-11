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

public class ProInfo7_3 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo7_3(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);


        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("김응수", "031-249-9764","eskim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김유택", "031-249-9765","ytkim@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김영진", "031-249-9766","yjkim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("강승구", "031-249-9767","sgkang@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("박용준", "031-249-9769","yjpark2006@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김지완", "031-249-1308", "jiwank@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("유상우", "031-249-9761","sryu@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("민성욱", "031-249-9732","swmhin@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("안계석", "031-249-9763","gsmaroan@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김강덕", "031-249-9715", "solidwaste@kgu.ac.kr"));

        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("신소재공학");




        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        FragmentProfessor Fpro = new FragmentProfessor();
        transaction.replace(R.id.tmap, Fpro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo7_3.this).commit();
        fragmentManager.popBackStack();
    }
    //리스트뷰 어댑터 구현
    class ProInfoAdapter extends BaseAdapter {
        ArrayList<ProInfoItem> items = new ArrayList<ProInfoItem>();

        public int getCount(){
            return items.size();
        }
        public void addItem(ProInfoItem item){
            items.add(item);
        }
        public Object getItem(int position){
            return items.get(position);
        }
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ProInfoItemView proInfoItemView=null;
            if(convertView == null){
                proInfoItemView=new ProInfoItemView(getActivity().getApplicationContext() );
            } else {
                proInfoItemView=(ProInfoItemView) convertView;
            }
            ProInfoItem item= items.get(position);
            proInfoItemView.setProName(item.getProName());
            proInfoItemView.setProCall(item.getProCall());
            proInfoItemView.setProMail(item.getProMail());
            return proInfoItemView;
        }
    }
}
