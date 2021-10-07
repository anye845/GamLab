package com.example.gamlab.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gamlab.R;

import java.util.ArrayList;


public class HomeScreenFragment extends Fragment {
    private TextView pc1;
    private TextView pc2;
    private TextView pc3;
    private TextView pc4;
    private TextView pc5;
    private TextView pc6;
    private TextView switch1;
    private TextView ps4;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;



    public HomeScreenFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home_screen, container, false);

        btn1 = view.findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn2 = view.findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn3 = view.findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn4 = view.findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn5 = view.findViewById(R.id.btn5);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn6 = view.findViewById(R.id.btn6);
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn7 = view.findViewById(R.id.btn7);
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });
        btn8 = view.findViewById(R.id.btn8);
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "working", Toast.LENGTH_SHORT).show();
                //goToReservationActivity();
            }
        });

        return view;
    }
//    private void goToReservationActivity() {
//        Intent i = new Intent(getContext(), ReservationActivity.class);
//        getContext().startActivity(i);
//    } //I need to make this for pc1-6, switch, and ps4


    }