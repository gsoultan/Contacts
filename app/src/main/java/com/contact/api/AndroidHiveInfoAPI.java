package com.contact.api;

import com.contact.model.Contact;
import com.contact.model.Phone;
import com.contact.util.HttpHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gembit Soultan on 5/20/2017.
 */

public class AndroidHiveInfoAPI implements ContactAPI {

    private String url = "http://api.androidhive.info/contacts/";

    @Override
    public List<Contact> GetAllContact() {
        List<Contact> contacts = new ArrayList<Contact>();
        HttpHandler h = new HttpHandler();
        String result = h.makeServiceCall(url);

        if(result != null) {
            JSONObject jsonObj = null;
            try {
                jsonObj = new JSONObject(result);

                // Getting JSON Array node
                JSONArray contactsArray = jsonObj.getJSONArray("contacts");

                for(int i = 0; i < contactsArray.length(); i++) {
                    JSONObject obj = contactsArray.getJSONObject(i);

                    Contact c = new Contact();
                    c.setId(obj.getString("id"));
                    c.setName(obj.getString("name"));
                    c.setEmail(obj.getString("email"));
                    c.setAddress(obj.getString("address"));
                    c.setGender(obj.getString("gender"));

                    Phone p = new Phone();
                    JSONObject phone = obj.getJSONObject("phone");
                    p.setMobile(phone.getString("mobile"));
                    p.setHome(phone.getString("home"));
                    p.setOffice(phone.getString("office"));

                    c.setPhone(p);

                    contacts.add(c);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return contacts;
    }
}
