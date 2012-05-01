package com.housemate.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bonsai.android.R;

import java.util.ArrayList;

public class ProfileAdapter extends BaseAdapter
{
    ArrayList<ProfileEntry> entryList;
    Context context;
    LayoutInflater inflater;

    public ProfileAdapter(Context context, ArrayList<ProfileEntry> entryList)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.profileentrylayout, null);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) convertView.findViewById(R.id.profEntryName);
            viewHolder.amount = (TextView) convertView.findViewById(R.id.profEntryAmount);
            convertView.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.name.setText(entryList.get(position).getName());
        viewHolder.amount.setText(Double.toString(entryList.get(position).getAmount()));

        return convertView;
    }

    static class ViewHolder
    {
        TextView name;
        TextView amount;
    }
}
