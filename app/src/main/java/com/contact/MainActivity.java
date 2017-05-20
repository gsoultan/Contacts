package com.contact;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.contact.api.AndroidHiveInfoAPI;
import com.contact.api.ContactAPI;
import com.contact.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContactAPI api;
    private ListView lv;
    private List<Contact> contacts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.contactListView);
        new GetContacts().execute();
    }

    private class GetContacts extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            try {
                api = new AndroidHiveInfoAPI();
                contacts = api.GetAllContact();
            }catch (final Exception e) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Json parsing error: " + e.getMessage(),
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            ListAdapter adapter = new ArrayAdapter<Contact>(MainActivity.this, android.R.layout.simple_list_item_1, android.R.id.text1, contacts );
            lv.setAdapter(adapter);
        }
    }
}
