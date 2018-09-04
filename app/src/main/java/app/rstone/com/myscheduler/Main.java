package app.rstone.com.myscheduler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends AppCompatActivity {
    String date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Context ctx = Main.this;
        TextView today = findViewById(R.id.today);
        today.setText(new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(new Date()));
        CalendarView calender = findViewById(R.id.calender);
        TimePicker time = findViewById(R.id.time);
        TextView year = findViewById(R.id.year);
        TextView month = findViewById(R.id.month);
        TextView day = findViewById(R.id.day);
        TextView hour = findViewById(R.id.hour);
        TextView minute = findViewById(R.id.minute);
        calender.setVisibility(View.VISIBLE);
        time.setVisibility(View.INVISIBLE);
        findViewById(R.id.rdoCalendar).setOnClickListener(
                (View v)->{
                    calender.setVisibility(View.VISIBLE);
                    time.setVisibility(View.INVISIBLE);
                }
        );
        findViewById(R.id.rdoTime).setOnClickListener(
                (View v)->{
                    time.setVisibility(View.VISIBLE);
                    calender.setVisibility(View.INVISIBLE);

                }
        );
        findViewById(R.id.btnEnd).setOnClickListener(
                (View v)->{
                    hour.setText(String.valueOf(time.getHour()));
                    minute.setText(String.valueOf(time.getMinute()));
                    //hour.setText(time.getHour());
                   // minute.setText(time.getMinute());
                   // year.setText(calender.get);
                    //Toast.makeText(ctx, "현재날짜"+day.getText(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(ctx, "현재시간"+time.getHour(),Toast.LENGTH_LONG).show();
                    //Toast.makeText(calender, year.getText(), Toast.LENGTH_LONG).show();
                    //Toast.makeText(ctx,"Lambda", Toast.LENGTH_LONG).show();
                }
        );
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                TextView y = findViewById(R.id.year);
                TextView m = findViewById(R.id.month);
                TextView d = findViewById(R.id.day);
                y.setText(year+"");
                m.setText(month+"");
                d.setText(dayOfMonth+"");
                date = year+"/"+month+"/"+dayOfMonth;
                Toast.makeText(ctx, "연도"+year+month+dayOfMonth, Toast.LENGTH_LONG).show();
            }
        });
    }
}


