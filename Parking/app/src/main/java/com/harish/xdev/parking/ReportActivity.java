package com.harish.xdev.parking;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.harish.xdev.parking.Adapter.TicketAdapter;
import com.harish.xdev.parking.DB.DBAddTicket;
import com.harish.xdev.parking.Model.AddTicket;

import java.util.ArrayList;

public class ReportActivity extends AppCompatActivity {
    TicketAdapter ticketAdapter;
    ListView lstTicket;
    ArrayList<AddTicket>TicketList;
    public static void startIntent(Context context) {
            context.startActivity(new Intent(context,ReportActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        lstTicket = (ListView)findViewById(R.id.lstTicket);
        DBAddTicket ad= new DBAddTicket(this);

        TicketList = (ArrayList<AddTicket>) ad.getAllTickets();
        ticketAdapter = new TicketAdapter(this,TicketList);
        lstTicket.setAdapter(ticketAdapter);
        lstTicket.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                AddTicket e = TicketList.get(i);
            }
        });
    }
}


