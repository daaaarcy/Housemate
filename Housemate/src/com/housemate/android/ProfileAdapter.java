package com.housemate.android;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class ProfileAdapter extends BaseAdapter
{
    private ArrayList<IEntry> entries;

    public ProfileAdapter(ArrayList<IEntry> entries)
    {
        this.entries = entries;
    }

    public int getCount()
    {
        return entries.size();
    }

    public Object getItem(int position)
    {
        return entries.get(position);
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
        return entries.get(position).getViewType();
    }

    /*
    Called when view of the entry is being generated
     */
    public View getView(int position, View convertView, ViewGroup parent)
    {
        return entries.get(position).getView(convertView);
    }
}
