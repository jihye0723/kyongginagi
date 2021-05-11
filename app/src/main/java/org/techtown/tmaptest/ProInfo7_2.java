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

public class ProInfo7_2 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo7_2(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);


        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("이건배", "031-249-9799","kblee@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이적식", "031-249-9800","jslee@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("최윤호", "031-249-9801","yhchoi@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("성동수", "031-249-9802","dssung@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("정원채", "031-249-9803","wcjung@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("오민석", "031-249-9804","msoh@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("성영제", "031-249-9805","yjsung@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("박상준", "031-249-9798", "sj.park@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("최상원", "031-249-9762", "swchoi20@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("임두혁", "031-249-9811", "doohyeok.lim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김기용", "031-249-1507", "eye4eye@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("강명규", "031-249-1507","kangkyoo@kgu.ac.kr"));

        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("전자공학과");



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
        fragmentManager.beginTransaction().remove(ProInfo7_2.this).commit();
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
