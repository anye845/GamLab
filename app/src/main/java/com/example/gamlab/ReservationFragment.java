package com.example.gamlab;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.gamlab.database.DAOSchedule;
import com.example.gamlab.database.schedule;
import com.google.android.material.timepicker.TimeFormat;

import org.w3c.dom.Text;

import java.nio.BufferUnderflowException;
import java.util.Calendar;

public class ReservationFragment extends Fragment {

    private Button btnDate, btnTime, btnReserve;
    private TextView tvDate, tvTime;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);

        btnDate = view.findViewById(R.id.btnDate);
        btnTime = view.findViewById(R.id.btnTime);
        btnReserve = view.findViewById(R.id.btnReserve);
        tvDate = view.findViewById(R.id.tvDate);
        tvTime = view.findViewById(R.id.tvTime);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnDate();
            }
        });
        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleBtnTime();
            }
        });

        DAOSchedule dao = new DAOSchedule();
        btnReserve.setOnClickListener(v ->
        {
            schedule s = new schedule(tvTime.getText().toString(), tvDate.getText().toString());
            dao.add(s).addOnSuccessListener(suc->
            {
                Toast.makeText(getActivity(), "Success!!", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(getActivity(), ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });
        });


        return view;
    }

    private void handleBtnDate(){

        Calendar calendar = Calendar.getInstance();

        int YEAR = calendar.get(calendar.YEAR);
        int MONTH = calendar.get(calendar.MONTH);
        int DATE = calendar.get(calendar.DATE);

        DatePickerDialog datePickDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int date) {
                String dateString = year + " " + month + " " + date;
                tvDate.setText(dateString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.YEAR, year);
                calendar1.set(Calendar.MONTH, month);
                calendar1.set(Calendar.DATE,date);

                CharSequence dateCharSequence = DateFormat.format("MM/dd/yyyy", calendar1);
                tvDate.setText(dateCharSequence);

            }
        },YEAR,MONTH,DATE);

        datePickDialog.show();
    }

    private void handleBtnTime(){
        Calendar calendar = Calendar.getInstance();

        int HOUR = calendar.get(Calendar.HOUR);
        int MINUTE = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(getActivity(), new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hour, int minute) {
                String timeString = "hour:" + hour + "minute:" + minute;
                tvTime.setText(timeString);

                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(Calendar.HOUR,hour);
                calendar1.set(Calendar.MINUTE,minute);

                CharSequence timeCharSequence = DateFormat.format("hh:mm", calendar1);
                tvTime.setText(timeCharSequence);
            }
        },HOUR,MINUTE, true);

        timePickerDialog.show();

    }

}
