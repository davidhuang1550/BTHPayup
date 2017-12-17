package bthpayup.payup;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davidhuang on 2017-12-08.
 */

public class SendPayment extends Fragment {

    private View mView;
    private Activity mActivity;
    private Spinner paymentMethod;
    private Button nextBtn;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.send_funds, container ,false);

        paymentMethod = (Spinner)mView.findViewById(R.id.sendFundMethod);

        List<String> list = new ArrayList<String>();
        list.add("Text Message");
        list.add("NFC");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(mActivity,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        paymentMethod.setAdapter(dataAdapter);
        nextBtn = (Button)mView.findViewById(R.id.chooseRecp);
        paymentMethod.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    nextBtn.setText("Choose Recipient");
                } else{
                    nextBtn.setText("Send");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final EditText amount = (EditText)mView.findViewById(R.id.amount);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("Amount", amount.getText().toString());
                if(paymentMethod.getSelectedItemPosition() == 0) {
                    ContactList contactList = new ContactList();
                    contactList.setArguments(bundle);

                    getFragmentManager().beginTransaction().add(R.id.content_main, contactList).addToBackStack("sendpayment").commit();
                } else {
                    getFragmentManager().beginTransaction().add(R.id.content_main, new NFCSEND()).addToBackStack("sendpayment").commit();
                }
            }
        });

        return mView;
    }
}
