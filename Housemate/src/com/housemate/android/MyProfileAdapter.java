package com.housemate.android;

import java.util.ArrayList;
import java.util.zip.Inflater;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bonsai.android.R;

public class MyProfileAdapter extends BaseAdapter
{
    ArrayList<MyProfileEntry> entryList = new ArrayList<MyProfileEntry>();
    Context context;
    LayoutInflater inflater;

    public MyProfileAdapter(Context context, ArrayList<MyProfileEntry> entryList)
    {
        this.context = context;
        this.entryList = entryList;
    }

    public int getCount()
    {
        return entryList.size();
    }

    public Object getItem(int position)
    {
        return entryList.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.myprofilerowlayout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.myProfEntryName);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.myProfEntryAmount);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        
        viewHolder.name.setText(entryList.get(position).getName());
        viewHolder.amount.setText(Float.toString(entryList.get(position).getAmount()));
        
        return convertView;
    }

    static class ViewHolder
    {
        TextView name;
        TextView amount; 
    }
}
