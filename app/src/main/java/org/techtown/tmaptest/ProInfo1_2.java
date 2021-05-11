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

public class ProInfo1_2 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo1_2(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("교양학부");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        adapter.addItem(new ProInfoItem("이수정", "031-249-9198", "suejung@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("박연규", "031-249-9191", "ygypark@hanmail.net"));
        adapter.addItem(new ProInfoItem("최성애", "031-249-9978", "choisa@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("최성호", "031-249-9017", "finechoi@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김진태", "031-249-9976", "jtkim@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김범준", "031-249-9193","bjkim@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김영윤", "031-249-9197", "youngy@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("임성철", "031-249-9186", "sungchul-rhim@hanmail.net"));
        adapter.addItem(new ProInfoItem("최준호", "031-249-1302", "contramony@hanmail.net"));
        adapter.addItem(new ProInfoItem("조극훈", "031-249-1302", "chokh6611@naver.com"));
        adapter.addItem(new ProInfoItem("김화경", "031-249-1300", "kimhk@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김문희", "031-249-1300", "kimmuni21@hanmail.net"));
        adapter.addItem(new ProInfoItem("윤대선", "031-249-1303", "levinas@naver.com"));
        adapter.addItem(new ProInfoItem("조한선", "031-249-1462", "hcho@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이노미", "031-249-1501", "nomi@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이봉호", "031-249-1312", "jiriso@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("엄현섭", "031-249-1301", "sehbi@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("송명진", "031-249-1499", "bluesunmj@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김학권", "031-249-1494", "kim7409@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("권성훈", "031-249-9046", "poemksh@naver.com"));
        adapter.addItem(new ProInfoItem("하은아", "031-249-1473", "donut9@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이유경", "031-249-1472", "greentea0313@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("박찬정", "031-249-1370", "hien77@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("곽미선", "031-249-1372", "misun.kwak@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김차영", "--",  "kimcha0@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("정혜욱", "031-249-1467", "wukj@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("임진혁", "031-249-9951", "ijh@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("공혜원", "031-249-9182", "hwkong@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("추승엽", "031-249-9979", "schoo@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김현아", "031-249-1467", "hyuna486@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이국희", "031-249-1494", "leegh1983@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("황혜영", "031-249-9545", "hyhwang@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("한성용", "031-249-1305", "srhahn70@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("송창운", "031-249-1526", "scw9876@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("우현주", "031-249-1462", "hj.woo@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("조윤용", "031-249-1472", "yoonycho@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김종성", "031-249-9951", "jongsungkim@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("변효정", "--",  "hjbyun@hotmail.com"));
        adapter.addItem(new ProInfoItem("안상희", "--", "heehee0916@hanmail.net"));
        adapter.addItem(new ProInfoItem("Alan John Stark", "--"," alan.stark76@gmail.com"));
        adapter.addItem(new ProInfoItem("Amanda Marie DuVall", "--", "amanda.duvall@gmail.com"));
        adapter.addItem(new ProInfoItem("Taraivosa Lagilagi Daucakacaka", "--", "dtaraivosa@gmail.com"));
        adapter.addItem(new ProInfoItem("James Richard Kirkmeyer", "--", "sbreen.kyonggi@gmail.com"));
        adapter.addItem(new ProInfoItem("Christian Poon", "--", "Cpoonteach@gmail.com"));
        adapter.addItem(new ProInfoItem("John Enow-Mangeb Mbu-Arrey", "--", "ensarrey@yahoo.com"));
        adapter.addItem(new ProInfoItem("Chagoyen Ralph E", "031-249-1496", "Ralph.chagoyen@yahoo.com"));
        adapter.addItem(new ProInfoItem("Fontanilla Maria Veronica", "031-249-1497", "dr_nikkifontanilla@yahoo.com"));
        adapter.addItem(new ProInfoItem("Corley Jr John Pareja", "031-249-1494", "jpcorley2008@yahoo.com"));
        adapter.addItem(new ProInfoItem("Lee Ernest", "031-249-1466", "mrernestteacher@gmail.com"));
        adapter.addItem(new ProInfoItem("Colangelo Anne Marie", "031-249-1495", "missc@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Robert Gibson", "031-249-1492", "rgibson@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Kim Seung Mi", "031-249-1497", "20170112@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("Murphy Kathleen Frances", "031-249-9359", "20170110@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Cary Michael William", "--", "mikecary@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Becht Richard Edward", "--", "profrichieb@gmail.com"));
        adapter.addItem(new ProInfoItem("Doh Seo Young", "031-249-1478", "jendoh7@gmail.com"));
        adapter.addItem(new ProInfoItem("Faraci Jr Joseph Anthony", "031-249-1471", "maslow2020us@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Kajgo Vladan", "031-249-1493", "vladankajgo@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Greer Michele Renee", "031-249-1372", "michelegreer@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Rhee Sa Rah", "031-249-9295", "sarah@kyonggi.ac.kr"));

        proInfo_content.setAdapter(adapter);

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ProInfo1 pro = new ProInfo1();
        transaction.replace(R.id.tmap, pro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo1_2.this).commit();
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
