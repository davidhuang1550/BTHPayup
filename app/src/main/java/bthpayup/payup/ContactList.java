package bthpayup.payup;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by davidhuang on 2017-12-08.
 */

public class ContactList extends Fragment {

    private Activity mActivity;
    private View mView;
    private String[] names = {"Noah",
            "Liam",
            "Mason",
            "Jacob",
            "William",
            "Ethan",
            "James",
            "Alexander",
            "Michael",
            "Benjamin",
            "Elijah",
            "Daniel",
            "Aiden",
            "Logan",
            "Matthew",
            "Lucas",
            "Jackson",
            "David",
            "Oliver",
            "Jayden"};
    private String[] numbers = {
            "(251) 546-9442",
            "(125) 546-4478",
            "(949) 569-4371",
            "(630) 446-8851",
            "(226) 906-2721",
            "(671) 925-1352",
            "(524) 336-1415",
            "(742) 227-3902",
            "(535) 440-5890",
            "(173) 425-4752",
            "(249) 488-6520",
            "(901) 892-1097",
            "(619) 124-1500",
            "(627) 902-1814",
            "(201) 112-5334",
            "(710) 436-5410",
            "(299) 906-1737",
            "(864) 296-8384"};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity = getActivity();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        mActivity.setTitle("Choose Recipient");
        mView = inflater.inflate(R.layout.contact_list, container ,false);
        Bundle bundle = getArguments();

        ListView listView = (ListView)mView.findViewById(R.id.listview);

        ContactAdapater contactAdapater = new ContactAdapater(mActivity, names, numbers, bundle.getString("Amount"));

        listView.setAdapter(contactAdapater);

        return mView;
    }

}
