package com.harish.xdev.parking;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.harish.xdev.parking.DB.DBAddTicket;
import com.harish.xdev.parking.DB.DBHelper;
import com.harish.xdev.parking.Model.AddTicket;

import java.text.SimpleDateFormat;
import java.util.List;

import butterknife.ButterKnife;

public class AddTicketActivity extends AppCompatActivity {
    TextView etDate;
    TextView etCost;
    TextView vnumber;
    TextView vbrand;
    Spinner vcolor;
    RadioGroup time;
    Spinner lane;
    RadioButton half;
    RadioButton one;
    RadioButton two;
    RadioButton dayends;
    Spinner position;
    Spinner paymethod;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_ticket);
        vnumber = (TextView) findViewById(R.id.vnumber);
        vbrand = (TextView) findViewById(R.id.vbrand);
        etDate = (TextView)findViewById(R.id.etdate);
        etCost = (TextView)findViewById(R.id.etCost);
        vcolor = (Spinner) findViewById(R.id.vcolor);
        lane = (Spinner) findViewById(R.id.lane);
        position = (Spinner) findViewById(R.id.position);
        // time = (RadioGroup) findViewById(R.id.timer);
        half=(RadioButton)findViewById(R.id.half);
        one=(RadioButton)findViewById(R.id.one);
        two=(RadioButton)findViewById(R.id.two);
        dayends=(RadioButton)findViewById(R.id.dayends);
        paymethod = (Spinner) findViewById(R.id.paymethod);
        btnsave = (Button) findViewById(R.id.btn);
        time = (RadioGroup) findViewById(R.id.time);

        int idd = time.getCheckedRadioButtonId();
        final RadioButton radioButton = (RadioButton) time.findViewById(idd);

        getCurrentdateAndTime();
        time.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.half:
                        etCost.setText("$10");
                        break;
                    case R.id.one:
                        etCost.setText("$20");
                        break;
                    case R.id.two:
                        etCost.setText("$30");
                        break;
                    case R.id.dayends:
                        etCost.setText("$80");
                }
            }
        });

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddTicket ad = new AddTicket();
                ad.setVnumber(vnumber.getText().toString());
                ad.setVbrand(vbrand.getText().toString());
                ad.setTime(etCost.getText().toString());
                ad.setEtdate(etDate.getText().toString());
                ad.setVcolor(vcolor.getSelectedItem().toString());
                ad.setLane(lane.getSelectedItem().toString());
                ad.setPosition(position.getSelectedItem().toString());
                ad.setPaymethod(paymethod.getSelectedItem().toString());

                loadSpinnerData();
                DBAddTicket ad1 = new DBAddTicket(AddTicketActivity.this);
                ad1.insertTicket(ad);
                ad1.getAllTickets();
                // ad.get();
                Toast.makeText(AddTicketActivity.this,"Ticket Add Successfully",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AddTicketActivity.this, HomeActivity.class);
                startActivity(intent);

            }
        });

    }

    public void getCurrentdateAndTime() {
        long date = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM MM dd, yyyy h:mm a");
        String dateString = sdf.format(date);
        etDate.setText(dateString);
    }

    private void loadSpinnerData() {
        // database handler
        DBHelper db = new DBHelper(getApplicationContext());

        // Spinner Drop down elements
        List<String> lables = db.getAllLabels();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, lables);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    }

}