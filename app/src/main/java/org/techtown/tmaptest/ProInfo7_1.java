package org.techtown.tmaptest;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ProInfo7_1 extends Fragment implements onBackPressedListener {

    private View view;
    ListView proInfo_content;
    TextView proTitle;
    DBHelper helper;
    SQLiteDatabase db;

    public ProInfo7_1(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);

        proTitle = view.findViewById(R.id.major);
        proTitle.setText("건축학과");
        proInfo_content=view.findViewById(R.id.proInfo_content);
        helper = new DBHelper(getActivity(), "capdb.db", null, 1);
        db = helper.getReadableDatabase();
        helper.onOpen(db);

        String sql= "select phone,name,email as _id from pro where major='건축학과';";
        Cursor c=db.rawQuery(sql,null);
        String[] strs=new String[]{"name","phone","_id"};
        int[] ints=new int[] {R.id.proName, R.id.proCall, R.id.proMail};

        SimpleCursorAdapter adapterC=null;
        adapterC = new SimpleCursorAdapter(proInfo_content.getContext(), R.layout.proinfo_item_list, c, strs, ints, 0);
        proInfo_content.setAdapter(adapterC);

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        ProInfo7 pro = new ProInfo7();
        transaction.replace(R.id.tmap, pro);
        transaction.commit();
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
