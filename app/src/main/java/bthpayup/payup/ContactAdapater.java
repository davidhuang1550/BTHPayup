package bthpayup.payup;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by davidhuang on 2017-12-08.
 */

public class ContactAdapater extends BaseAdapter {

    private Activity mActivity;
    private String[] names;
    private String[] phones;
    private String amount;

    public ContactAdapater(Activity activity, String[] names, String[] phones, String amount){
        mActivity = activity;
        this.names = names;
        this.phones = phones;
        this.amount = amount;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return names[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mActivity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View row = inflater.inflate(R.layout.contact_item, null);

        TextView name = (TextView)row.findViewById(R.id.name);
        final TextView number = (TextView)row.findViewById(R.id.number);

        name.setText(this.names[position]);
        number.setText(this.phones[position]);


        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmRecipient recipient =  new ConfirmRecipient();
                Bundle bundle = new Bundle();
                bundle.putString("Name", names[position]);
                bundle.putString("Number", phones[position]);
                bundle.putString("Amount", amount);
                recipient.setArguments(bundle);

                mActivity.getFragmentManager().beginTransaction().add(R.id.content_main, recipient).addToBackStack("contactlist").commit();
            }
        });

        return row;
    }
}
