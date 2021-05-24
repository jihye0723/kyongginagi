package org.techtown.tmaptest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class ProInfo2_7 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;

    public ProInfo2_7(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        // DB 열기.
        DBHelper helper;
        SQLiteDatabase db;
        helper = new DBHelper(getContext(), "capdb.db", null, 1);
        db = helper.getWritableDatabase();
        helper.onCreate(db);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("글로벌어문학부");

        proInfo_content=view.findViewById(R.id.proInfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();

        String sql = "select name, phone, email from pro where major='글로벌어문학부';";
        Cursor c = db.rawQuery(sql, null);
        if(c != null) {
            while(c.moveToNext()) {
                String name = c.getString(c.getColumnIndex("name"));
                String phone = c.getString(c.getColumnIndex("phone"));
                String email = c.getString(c.getColumnIndex("email"));

                adapter.addItem(new ProInfoItem(name, phone, email));
            }
        }

        /*adapter.addItem(new ProInfoItem("김영목", "031-249-9147", "ymkim710@hanmail.net"));
        adapter.addItem(new ProInfoItem("정미경", "031-249-9150", "kassmede@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("강명희", "031-249-9148", "gunie88@hanmail.net"));
        adapter.addItem(new ProInfoItem("이소영", "031-249-9146", "balkon@hanmail.net"));
        adapter.addItem(new ProInfoItem("Herbermann Marcus Antonius", "031-249-1463", "herbermann@kyonggi.ac.kr"));

        adapter.addItem(new ProInfoItem("유말희", "031-249-9158", "mhyoo@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김선미", "031-249-9157", "ksm66@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("임재일", "031-249-9189", "limzeil1123@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Arnaud Hilaire", "031-249-9262", "hilairearnaud74@hotmail.com"));

        adapter.addItem(new ProInfoItem("박재환", "031-249-9117", "jhpark7@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("윤영수", "031-249-9119", "ysyoon@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("홍진희", "031-249-9121", "jhh@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("김정희", "031-249-9310", "rusia73@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("곽은심", "031-249-9182", "kwak5017@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("Mito Kuraishi", "031-249-9262", "reportkochiradesu-kura@kyonggi.ac.kr"));

        adapter.addItem(new ProInfoItem("유영기", "031-249-9129", "easternmedicine@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("유현아", "031-249-9127", "xianya1@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("민경욱", "031-249-9264", "mkw318@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("윤유정", "031-249-9194", "yunyujeong@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이희현", "031-249-1371", "badanoul@kyonggi.ac.kr"));

        adapter.addItem(new ProInfoItem("송현배", "031-249-9358", "hbsong@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("장혜진", "031-249-9297", "maya70@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("Kulyk Oleksandra", "031-249-9160", "jhantwins@gmail.com"));*/

        proInfo_content.setAdapter(adapter);

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ProInfo2 pro = new ProInfo2();
        transaction.replace(R.id.tmap, pro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo2_7.this).commit();
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
