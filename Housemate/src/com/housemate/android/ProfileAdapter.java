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
    ArrayList<Owe> owes;
    Context context;
    LayoutInflater inflater;

    public ProfileAdapter(Context context, ArrayList<Owe> owes)
    {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.owes = owes;
    }

    public int getCount()
    {
        return owes.size();
    }

    public Object getItem(int position)
    {
        return owes.get(position);
    }

    public long getItemId(int position)
    {
        return position;
    }

    /*
    Returns the total number of row types, in the case of Housemate
    we have two types, lend and borrow.
     */
    @Override
    public int getViewTypeCount()
    {
        return EntryType.values().length;
    }

    /*
    Borrow type is indexed 0, lend type is indexed 1.
     */
    @Override
    public int getItemViewType(int position)
    {
        return owes.get(position).getAmILender() ? EntryType.LEND.ordinal() : EntryType.BORROW.ordinal();
    }

    public View getView(int position, View convertView, ViewGroup parent)
    {
        ViewHolder viewHolder;
        if (convertView == null)
        {
            if (getItemViewType(position) == 0)
            {
                convertView = inflater.inflate(R.layout.profile_borrow_entry, null);
                viewHolder = new ViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.prof_entry_name_b);
                viewHolder.title = (TextView) convertView.findViewById(R.id.prof_entry_title_b);
                viewHolder.amount = (TextView) convertView.findViewById(R.id.prof_entry_amt_b);
                convertView.setTag(viewHolder);
            }
            else
            {
                convertView = inflater.inflate(R.layout.profile_lend_entry, null);
                viewHolder = new ViewHolder();
                viewHolder.name = (TextView) convertView.findViewById(R.id.prof_entry_name_l);
                viewHolder.title = (TextView) convertView.findViewById(R.id.prof_entry_title_l);
                viewHolder.amount = (TextView) convertView.findViewById(R.id.prof_entry_amt_l);
                convertView.setTag(viewHolder);
            }
        }
        else
        {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Owe entry = owes.get(position);
        viewHolder.name.setText(entry.getName());
        viewHolder.title.setText(entry.getTitle());
        viewHolder.amount.setText(Double.toString(entry.getAmount()));

        return convertView;
    }

    static class ViewHolder
    {
        TextView name;
        TextView title;
        TextView amount;
    }
}
