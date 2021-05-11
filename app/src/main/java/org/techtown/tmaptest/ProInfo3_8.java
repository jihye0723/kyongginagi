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

public class ProInfo3_8 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo3_8(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);


        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("이종경", "031-249-9960","kklee119@naver.com"));
        adapter.addItem(new ProInfoItem("김동선", "031-249-9971","kds@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("곽한병", "031-249-9973","hpkwak@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("박성준", "031-249-9972", "hitman22@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이홍구", "031-249-9974","leeh@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("박경실", "031-249-9975","ksp9975@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("황규영", "031-249-9957","ghwang@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("오세숙", "031-249-9980", "penn_sso@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("설수영", "031-249-9970","sysul@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("백우열", "031-249-9953","wyb71@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("임종건", "031-249-1317","jonglim1229@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이광용", "031-249-9953","guifarro@kgu.ac.kr"));
        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("스포츠과학");



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
        fragmentManager.beginTransaction().remove(ProInfo3_8.this).commit();
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
