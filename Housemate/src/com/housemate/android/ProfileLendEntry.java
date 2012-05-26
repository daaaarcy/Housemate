package com.housemate.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.bonsai.android.R;

/**
 * Created with IntelliJ IDEA.
 * User: darcy
 * Date: 22/05/2012
 * Time: 23:20
 * <p/>
 * Lend entry in profile view
 */
public class ProfileLendEntry implements IEntry
{
    private LayoutInflater inflater;
    private Owe owe;

    public ProfileLendEntry(Context context, Owe owe)
    {
        this.inflater = LayoutInflater.from(context);
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
            convertView = inflater.inflate(R.layout.profile_lend_entry, null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.prof_entry_name_l);
            holder.amount = (TextView) convertView.findViewById(R.id.prof_entry_amt_l);
            holder.title = (TextView) convertView.findViewById(R.id.prof_entry_title_l);
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
        return EntryType.LEND.ordinal();
    }

    static class ViewHolder
    {
        TextView name;
        TextView title;
        TextView amount;
    }
}
