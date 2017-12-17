package bthpayup.payup;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by davidhuang on 2017-12-07.
 */

public class pay_up_first_page extends Fragment implements FragmentManager.OnBackStackChangedListener, View.OnClickListener{

    private Activity mActivity;
    private View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
        getFragmentManager().addOnBackStackChangedListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.pay_up_first_page, container, false);

        Button sendBtn = (Button)mView.findViewById(R.id.sendbtn);
        Button recieveBtn = (Button)mView.findViewById(R.id.recievebtn);
        sendBtn.setOnClickListener(this);
        recieveBtn.setOnClickListener(this);


        return mView;
    }

    @Override
    public void onBackStackChanged() {
        Toolbar toolbar = (Toolbar) mActivity.findViewById(R.id.toolbar);
        if (((SendFunds) mActivity).getFragmentManager().getBackStackEntryCount() > 0 ){
            ((SendFunds)mActivity).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getFragmentManager().popBackStack();
                }
            });

        } else {
            ((SendFunds)mActivity).getSupportActionBar().setDisplayHomeAsUpEnabled(false);
           mActivity.finish();
        }
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.sendbtn:
                    getFragmentManager().beginTransaction().add(R.id.content_main, new SendPayment()).addToBackStack("firstpage").commit();
                break;
            case R.id.recievebtn:
                getFragmentManager().beginTransaction().add(R.id.content_main, new RecieveFunds()).addToBackStack("firstpage").commit();

                break;
            default:
                System.out.println("something went wrong send and recieve were not clicked.");
                break;
        }
    }
}
