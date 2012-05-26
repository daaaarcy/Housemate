package com.housemate.android;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bonsai.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: darcy
 * Date: 26/05/2012
 * Time: 17:51
 * <p/>
 * Borrow entry in profile view
 */
public class ProfileBorrowEntry implements IEntry
{
    private LayoutInflater inflater;
    private Owe owe;

    public ProfileBorrowEntry(LayoutInflater inflater, Owe owe)
    {
        this.inflater = inflater;
        this.owe = owe;
    }

    @Override
    public View getView(View convertView)
    {
        ViewHolder holder;
        if (convertView != null)
        {
            holder = (ViewHolder) convertView.getTag();
        }
        else
        {
            convertView = inflater.inflate(R.layout.profile_borrow_entry, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.prof_entry_name_b);
            holder.amount = (TextView) convertView.findViewById(R.id.prof_entry_amt_b);
            holder.title = (TextView) convertView.findViewById(R.id.prof_entry_title_b);
            convertView.setTag(holder);
        }
        holder.name.setText(owe.getName());
        holder.amount.setText(Double.toString(owe.getAmount()));
        holder.title.setText(owe.getTitle());

        return convertView;
    }

    @Override
    public int getViewType()
    {
        return EntryType.BORROW.ordinal();
    }

    static class ViewHolder
    {
        TextView name;
        TextView title;
        TextView amount;
    }
}
