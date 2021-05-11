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

public class ProInfo7_4 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo7_4(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);


        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("이시진", "031-249-9731", "sjlee@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("정상진", "031-249-9734", "sjjung@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("홍성창", "031-249-9733", "schong@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("유호식", "031-249-9735", "hsyoo@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이승희", "031-249-9736", "swrhee@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이병희", "031-249-9737","bal@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("장순웅", "031-249-9739", "swchang@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김지태", "031-249-9756", "jtkim221@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김성수", "031-249-9741","sskim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("응웬띤득", "---", "nguyensyduc@gmail.com"));
        adapter.addItem(new ProInfoItem("이상문", "031-249-1309","leesangm@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김성철", "---", "kmac40@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("라빈드란", "031-249-9755", "ravindran@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("정우진", "---","cine23@kyonggi.ac.kr"));

        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("환경에너지공학");


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
        fragmentManager.beginTransaction().remove(ProInfo7_4.this).commit();
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
