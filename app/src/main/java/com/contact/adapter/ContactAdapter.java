package com.contact.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.contact.R;
import com.contact.model.Contact;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by gsoultan on 5/20/17.
 */

public class ContactAdapter extends ArrayAdapter<Contact> {

    private List<Contact> contacts;
    private Context mContext;

    public ContactAdapter(@NonNull Context context, @NonNull List<Contact> contacts) {
        super(context, R.layout.contact_item);
        this.contacts = contacts;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.contact_item,parent,false);
            holder = new ViewHolder();
            holder.nameTxt = (TextView) convertView.findViewById(R.id.nameTxt);
            holder.emailTxt = (TextView) convertView.findViewById(R.id.emailTxt);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        Contact c = this.getItem(position);
        holder.nameTxt.setText(c.getName());
        holder.emailTxt.setText(c.getEmail());
        return convertView;
    }

    @Nullable
    @Override
    public Contact getItem(int position) {
        return contacts.get(position);
    }

    @Override
    public int getCount() {
        return contacts.size();
    }

    static class ViewHolder {
        TextView nameTxt;
        TextView emailTxt;
    }
}
