package org.techtown.tmaptest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProInfoItemView extends LinearLayout {

    TextView proName, proCall, proMail;

    public ProInfoItemView(Context context) {
        super(context);
        init(context);
    }

    public ProInfoItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.proinfo_item_list,this, true);

        proName = (TextView) findViewById(R.id.proName);
        proCall = (TextView) findViewById(R.id.proCall);
        proMail = (TextView) findViewById(R.id.proMail);

    }

    public void setProName(String proNameN) {
        proName.setText(proNameN);
    }
    public void setProCall(String proCallN) { proCall.setText(proCallN); }
    public void setProMail(String proMailN) { proMail.setText(proMailN); }
}
