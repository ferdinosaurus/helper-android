package com.e.kumpulanmateri.calender;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.e.kumpulanmateri.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity {

    private DatePickerDialog datePickerDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);



        findViewById(R.id.calendarBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar newCalendar = Calendar.getInstance();

                datePickerDialog = new DatePickerDialog(CalendarActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Calendar newDate = Calendar.getInstance();
                        newDate.set(year, monthOfYear, dayOfMonth);
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


                        Toast.makeText(CalendarActivity.this, check(sdf.format(newDate.getTime()))+"", Toast.LENGTH_SHORT).show();
                    }

                }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

    }

    boolean check(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date dateSelect = null;
        try {
            dateSelect = sdf.parse(strDate);
        } catch (ParseException e) {
            return false;
        }
        Calendar calendarSelect = Calendar.getInstance();
        calendarSelect.setTime(dateSelect);

        Date dateNow = new Date(System.currentTimeMillis());
        Calendar calendarThis = Calendar.getInstance();
        calendarThis.setTime(dateNow);

        int selectWeek = calendarSelect.get(Calendar.WEEK_OF_YEAR);
        int thisWeek = calendarThis.get(Calendar.WEEK_OF_YEAR);

        int selectDay = calendarSelect.get(Calendar.DAY_OF_YEAR);
        int thisDay = calendarThis.get(Calendar.DAY_OF_YEAR);

        if (selectWeek == thisWeek){
            if (dateNow.compareTo(dateSelect)>0){
                if (selectDay == thisDay){
                    return false;
                }else return true;
            }

        }
        return false;
    }
}