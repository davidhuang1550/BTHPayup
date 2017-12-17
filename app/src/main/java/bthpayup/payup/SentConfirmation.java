package bthpayup.payup;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import net.futuredrama.jomaceld.circularpblib.CircularProgressBarView;

/**
 * Created by davidhuang on 2017-12-09.
 */

public class SentConfirmation extends Fragment {

    private Activity mActivity;
    private View mView;
    private ProgressBar pBar;
    private TextView sendingTextView;
    private int progress =0;
    private String[] dots = {".", "..", "...", ".", ".."};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.send_confirmation, container, false);
        pBar = (ProgressBar) mView.findViewById(R.id.pbar);
        final Handler handler = new Handler() ;
        sendingTextView = (TextView)mView.findViewById(R.id.sendText);
        new Thread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                while (dots.length > progress) {

                    handler.post(new Runnable() {

                        @Override
                        public void run() {

                            sendingTextView.setText("Sending " +dots[progress]);
                        }
                    });
                    try {
                        // Sleep for 10 milliseconds.
                        // Just to display the progress slowly
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress++;
                }
                getFragmentManager().beginTransaction().replace(R.id.content_main,new SuccesfulScreen()).commit();

            }
        }).start();
        return mView;
    }
}
