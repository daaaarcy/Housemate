package com.housemate.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfileActivity extends ListActivity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);


        //TODO: Gets an arraylist of entry from remote database
        try
        {
            URL serverURL = new URL("http://127.0.0.1:8000");
            URLConnection connection = serverURL.openConnection();

            // 10s connection time allowance
            connection.setConnectTimeout(10000);

            InputStream inputStream = serverURL.openStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext())
            {
                Log.d("test", scanner.nextLine());
            }
            //URLConnection connection = serverURL.openConnection();
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        catch (IOException e)
        {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }


        ArrayList<ProfileEntry> entries = new ArrayList<ProfileEntry>();
        entries.add(new ProfileEntry("Mike", 9.6));
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
