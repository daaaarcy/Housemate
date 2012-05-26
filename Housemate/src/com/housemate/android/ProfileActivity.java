package com.housemate.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class ProfileActivity extends ListActivity
{
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        readProfileEntries();
    }

    /**
     * Reads the entry data from server and displays it
     */
    private void readProfileEntries()
    {
        String url = getServerAddress() + "profile/" + getUserEmail();
        String content = executeGetRequest(url);
        try
        {
            JSONArray jsonArray = new JSONArray(content);
//            Log.i(ProfileActivity.class.toString(), "No. of owes: " + jsonArray.length());

            ArrayList<IEntry> entries = new ArrayList<IEntry>(jsonArray.length());

            // Iterates the JSON array received from server
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject entryObject = jsonArray.getJSONObject(i);

                final boolean amILender = entryObject.getBoolean("am_i_lender");
                final String name = entryObject.getString("name");
                final String title = entryObject.getString("title");
                final double amount = entryObject.getDouble("amount");
                try
                {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.UK);
                    Date datetime = dateFormat.parse(entryObject.getString("datetime"));
                    Log.i(ProfileActivity.class.toString(), amILender + "," + name + "," + title + "," + amount + "," + datetime);
                }
                catch (ParseException e)
                {
                    e.printStackTrace();
                }

                final Owe owe = new Owe(name, title, amount, amILender);

                // Converts owe to corresponding profile entry and add it to the list
                IEntry entry;
                if (amILender)
                    entry = new ProfileLendEntry(this, owe);
                else
                    entry = new ProfileBorrowEntry(this, owe);
                entries.add(i, entry);
            }
            ProfileAdapter profileAdapter = new ProfileAdapter(entries);
            this.setListAdapter(profileAdapter);
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
    }

    /*
        Fires a GET request and returns the response body
     */
    private String executeGetRequest(String url)
    {
        StringBuilder builder = new StringBuilder();
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        try
        {
            HttpResponse response = client.execute(httpGet);
            StatusLine statusLine = response.getStatusLine();
            int statusCode = statusLine.getStatusCode();
            if (statusCode == 200)
            {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                while ((line = reader.readLine()) != null)
                {
                    builder.append(line);
                }
                reader.close();
                entity.consumeContent();
            }
            else
            {
                Log.e(ProfileActivity.class.toString(), "Failed to download file");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return builder.toString();
    }

    static String getUserEmail()
    {
        return "darcy@hm.com";
    }

    static String getServerAddress()
    {
        // 127.0.0.1 refers to device's localhost, below is the PC's host loopback
        return "http://10.0.2.2:8000/";
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        String item = (String) getListAdapter().getItem(position);
        Toast.makeText(this, item + " selected", Toast.LENGTH_LONG).show();
    }
}
