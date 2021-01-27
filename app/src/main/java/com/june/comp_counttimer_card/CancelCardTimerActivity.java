package com.june.comp_counttimer_card;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.june.R;

public class CancelCardTimerActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancel_card_timer);

        TextView mTTTTTT = findViewById(R.id.mTTTTTT);
        PsgCancelRemindCard mCard = findViewById(R.id.mCard);

        //初始不展示
        mCard.setVisibility(View.GONE);

        //测试代码
        mTTTTTT.setText(getString(R.string.i_known_psg_cancel, 52));

        mTTTTTT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("july", "onClick: ");

                PassengerCancelModel dd = new PassengerCancelModel();
                dd.setOid("gjlgsjgslgsdjl");
                dd.setTravelId("fsjsfljfslfjs");
                dd.setPhoneExpired(5);
                dd.setSubTitle("title测试");
                dd.setContent("展示信息内容");
                mCard.showPsgCancelCard(dd);

                mCard.setVisibility(View.VISIBLE);
            }
        });
    }
}
