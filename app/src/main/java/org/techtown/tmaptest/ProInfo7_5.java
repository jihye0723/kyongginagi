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

public class ProInfo7_5 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo7_5(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("김성우", "031-249-9787","wookim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("정지훈", "031-249-9786","jhjung@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김상범", "031-249-9790","ksb@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김현준", "031-249-9789","hjkim68@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김준석", "031-249-9768", "jskim84@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("차상호", "031-249-9783","sanghocha@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김준모", "031-249-9045","junmokim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("진준형", "031-249-1316","jjh1023@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("양인환", "031-249-1323","ihyang@kgu.ac.kr"));




        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("화학공학");



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
        fragmentManager.beginTransaction().remove(ProInfo7_5.this).commit();
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
