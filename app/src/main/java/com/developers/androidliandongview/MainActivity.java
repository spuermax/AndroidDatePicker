package com.developers.androidliandongview;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.developers.androidliandongview.pickerview.WheelView;
import com.developers.androidliandongview.pickerview.picker.DatePicker;
import com.developers.androidliandongview.pickerview.picker.DateTimePicker;
import com.developers.androidliandongview.pickerview.utils.ConvertUtils;
import com.developers.androidliandongview.pickerview.utils.DateUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private WheelView wheelView;
    private LinearLayout linear_layout;
    private ArrayList<String> wordNumber = new ArrayList<>();

    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wheelView = findViewById(R.id.wheelView);
        linear_layout = findViewById(R.id.linear_layout);

        for (int i = 1; i < 40; i++) {
            wordNumber.add(i * 5 + "词");
        }

        wheelView.setItems(wordNumber, 2);

        wheelView.setTextColor(0xFFFF00FF);
        wheelView.setTextSize(18);
//        WheelView.DividerConfig config = new WheelView.DividerConfig();
//        config.setRatio(1.0f / 10.0f);//线比率
//        config.setColor(0xFFFF0000);//线颜色
//        config.setAlpha(100);//线透明度
//        config.setThick(ConvertUtils.toPx(this, 5));//线粗
        wheelView.setDividerConfig(null);
        wheelView.setOnItemSelectListener(new WheelView.OnItemSelectListener() {
            @Override
            public void onSelected(int index) {
                Log.i("AAAAAA", wordNumber.get(index));

                datePicker.setSelectedItem(2019,06,07);



            }
        });


        datePicker = new DatePicker(this, DateTimePicker.YEAR_MONTH_DAY);

        datePicker.setOffset(4);
        datePicker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                Log.i("AAAAAAA", "index= " + index + "== year = " + year);
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                Log.i("AAAAAAA", "index= " + index + "== month = " + month);

            }

            @Override
            public void onDayWheeled(int index, String day) {
                Log.i("AAAAAAA", "index= " + index + "== day = " + day);

            }
        });

        linear_layout.addView(datePicker.getContentView());


    }


}