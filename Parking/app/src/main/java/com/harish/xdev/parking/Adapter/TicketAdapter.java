package com.harish.xdev.parking.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.harish.xdev.parking.Model.AddTicket;
import com.harish.xdev.parking.R;

import java.util.ArrayList;

public class TicketAdapter extends ArrayAdapter<AddTicket> {
    public TicketAdapter(Context context, ArrayList<AddTicket> TicketArrayList)
    {
        super(context, 0, TicketArrayList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the data item for this position
        AddTicket ad = getItem(position);
        ViewHolder viewHolder;

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.report_layout, parent, false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }


        else
        {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        // Populate the data into the template view using the data object
        viewHolder.vvnumber.setText(String.valueOf(ad.getVnumber()));
        viewHolder.vbrand.setText(String.valueOf(ad.getVbrand()));
      //  viewHolder.etdate.setText(String.valueOf(ad.getEtdate()));

        viewHolder.vcolor.setText(String.valueOf(ad.getVcolor()));
        viewHolder.position.setText(String.valueOf(ad.getPosition()));
        viewHolder.lane.setText(String.valueOf(ad.getLane()));
        viewHolder.time.setText(String.valueOf(ad.getTime()));

        viewHolder.paymethod.setText(String.valueOf(ad.getPaymethod()));


        return convertView;
    }

    private class ViewHolder
    {
        TextView vvnumber;
        TextView vbrand;
        TextView vcolor;
        TextView etdate;
        TextView position;
        TextView lane;
        TextView time;
        TextView paymethod;


        ViewHolder(View convertView)
        {
            vvnumber = (TextView) convertView.findViewById(R.id.vvnumber);
            vbrand = (TextView) convertView.findViewById(R.id.vbrand);
            etdate=(TextView) convertView.findViewById(R.id.etdate);
            vcolor = (TextView) convertView.findViewById(R.id.vcolor);
            paymethod = (TextView) convertView.findViewById(R.id.paymethod);
            position = (TextView) convertView.findViewById(R.id.position);
            lane = (TextView) convertView.findViewById(R.id.lane);
            time = (TextView) convertView.findViewById(R.id.time);
        }
    }
}
