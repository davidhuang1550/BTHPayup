package bthpayup.payup;

import android.app.Activity;
import android.app.Fragment;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by davidhuang on 2017-12-09.
 */

public class GeneratedLink extends Fragment implements View.OnClickListener {

    private Activity mActivity;
    private View mView;
    private Button continueke;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.generated_link , container ,false);

        Button button = (Button)mView.findViewById(R.id.copylink);
        continueke = (Button)mView.findViewById(R.id.continueke);

        button.setOnClickListener(this);
        continueke.setOnClickListener(this);

        return mView;
    }

    @Override
    public void onClick(View v) {

        switch(v.getId()){
            case R.id.copylink:
                ClipboardManager clipboard = (ClipboardManager) mActivity.getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("link", "https://payups/H9EHD8902SZ");
                clipboard.setPrimaryClip(clip);
                Snackbar.make(v, "Link has been copied to the clipboard", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                continueke.setVisibility(v.VISIBLE);

                break;
            case R.id.continueke:

                mActivity.finish();
                break;
            default:

                break;
        }
    }
}
