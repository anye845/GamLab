package com.example.gamlab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.Calendar;

import devs.mulham.horizontalcalendar.HorizontalCalendar;
import devs.mulham.horizontalcalendar.utils.HorizontalCalendarListener;


public class ReservationFragment extends Fragment {

    private RecyclerView rvTimeSlot;
    private FirebaseFirestore fb;
    private FirestoreRecyclerAdapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reservation, container, false);
        setContentView(R.layout.fragment_reservation);

        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, 0);

        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 3);

        HorizontalCalendar horizontalCalendar = new HorizontalCalendar.Builder(view, R.id.calendarView)
                .range(startDate, endDate)
                .datesNumberOnScreen(7)
                .build();
        horizontalCalendar.setCalendarListener(new HorizontalCalendarListener() {
            @Override
            public void onDateSelected(Calendar date, int position) {
                Log.e("TAG", "CURRENT DATE IS" + date);
            }
        });

        fb = FirebaseFirestore.getInstance();
        rvTimeSlot = view.findViewById(R.id.rvTimeSlot);


        Query query = fb.getInstance()
                .collection("Time")
                .orderBy("", Query.Direction.valueOf("desc"));
        FirestoreRecyclerOptions<TimeSlots> options = new FirestoreRecyclerOptions.Builder<TimeSlots>()
                .setQuery(query, TimeSlots.class)
                .build();

        adapter = new FirestoreRecyclerAdapter<TimeSlots, TimeSlotsViewHolder>(options) {
            @NonNull
            @Override
            public TimeSlotsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_slot, parent, false);
                return new TimeSlotsViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull TimeSlotsViewHolder holder, int position, @NonNull TimeSlots model) {
                holder.tvItem.setText(model.getTime());
            }
        };

        rvTimeSlot.setHasFixedSize(true);
        rvTimeSlot.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvTimeSlot.setAdapter(adapter);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    private void setContentView(int fragment_reservation) {
    }

    private class TimeSlotsViewHolder extends RecyclerView.ViewHolder{

        private TextView tvItem;

        public TimeSlotsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvItem = itemView.findViewById(R.id.tvItem);
        }
    }

    @Override
    public void onStop(){
        super.onStop();
        adapter.stopListening();;
    }


    @Override
    public void onStart(){
        super.onStart();
        adapter.startListening();;
    }


}