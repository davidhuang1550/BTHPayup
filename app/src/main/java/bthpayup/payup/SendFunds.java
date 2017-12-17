package bthpayup.payup;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class SendFunds extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_funds);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
       // getFragmentManager().beginTransaction().add(R.id.content_main, new NFCSEND()).commit();
        getFragmentManager().beginTransaction().add(R.id.content_main, new pay_up_first_page()).addToBackStack("sendfunds").commit();
    }



    @Override
    public void onBackStackChanged() {

        if (getFragmentManager().getBackStackEntryCount() > 0 ){

            getFragmentManager().popBackStack();

        } else {
            super.onBackPressed();
        }
    }

}
