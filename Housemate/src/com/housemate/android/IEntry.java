package com.housemate.android;

import android.view.View;

/**
 * Created with IntelliJ IDEA.
 * User: darcy
 * Date: 22/05/2012
 * Time: 23:17
 * <p/>
 * Interface of an entry in ListView
 */
public interface IEntry
{
    public View getView(View convertView);

    public int getViewType();
}
