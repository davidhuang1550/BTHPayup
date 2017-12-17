package bthpayup.payup;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by davidhuang on 2017-12-09.
 */

public class ConfirmRecipient extends Fragment implements  View.OnClickListener{

    private Activity mActivity;
    private View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.confirm_recipient, container, false);

        Bundle bundle = getArguments();
        String name = bundle.getString("Name");
        String phone = bundle.getString("Number");
        String amount = bundle.getString("Amount");

        TextView nameView = (TextView)mView.findViewById(R.id.name);
        TextView phoneView = (TextView)mView.findViewById(R.id.number);
        TextView amountView = (TextView)mView.findViewById(R.id.amount);

        nameView.setText(name);
        phoneView.setText(phone);
        amountView.setText("$"+ amount);

        Button button = (Button)mView.findViewById(R.id.generateLink);
        Button send = (Button)mView.findViewById(R.id.send);

        button.setOnClickListener(this);
        send.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.generateLink:
                    getFragmentManager().beginTransaction().replace(R.id.content_main, new GeneratedLink()).commit();

                break;
            case R.id.send:
                    getFragmentManager().beginTransaction().replace(R.id.content_main, new SentConfirmation()).commit();
                break;
            default:

                break;
        }
    }
}
