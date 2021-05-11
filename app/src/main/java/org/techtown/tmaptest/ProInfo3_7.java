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

public class ProInfo3_7 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo3_7(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);


        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("신혜경", "031-249-9961","shinmoon2@nate.com"));
        adapter.addItem(new ProInfoItem("이광춘", "031-249-9090","lgc58@naver.com"));
        adapter.addItem(new ProInfoItem("박영택", "031-249-9962","wabhak@hanmail.net"));
        adapter.addItem(new ProInfoItem("정연경", "031-249-9902","ykcheung@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김기창", "031-249-9911","gichangk@hanmail.net"));
        adapter.addItem(new ProInfoItem("김윤", "031-249-9965","yunil620@hanmail.net"));
        adapter.addItem(new ProInfoItem("장지훈", "031-249-9936","korea3003@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("배정하", "031-249-9937","paijh6424@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("성인근", "---","inn72@hanmail.net"));
        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("FINE ARTS");



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
        fragmentManager.beginTransaction().remove(ProInfo3_7.this).commit();
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
