package com.housemate.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ProfileActivity extends ListActivity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);

        //ListView lv = (ListView) findViewById(R.id.profile_list);
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2" };
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.profileentrylayout, R.id.profEntryName, values);

        ArrayList<ProfileEntry> entries = new ArrayList<ProfileEntry>();
        entries.add(new ProfileEntry("Mike", 5.6));
        entries.add(new ProfileEntry("Una", 12.4));

        ProfileAdapter profileAdapter = new ProfileAdapter(this, entries);
        this.setListAdapter(profileAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }
}
