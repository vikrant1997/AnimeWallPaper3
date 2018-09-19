package com.test.vikrant.anime;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import org.sufficientlysecure.donations.DonationsFragment;

public class DonateActivity extends Fragment {

    /**
     * Google
     */
    private static final String GOOGLE_PUBKEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAg8bTVFK5zIg4FGYkHKKQ/j/iGZQlXU0qkAv2BA6epOX1ihbMz78iD4SmViJlECHN8bKMHxouRNd9pkmQKxwEBHg5/xDC/PHmSCXFx/gcY/xa4etA1CSfXjcsS9i94n+j0gGYUg69rNkp+p/09nO9sgfRTAQppTxtgKaXwpfKe1A8oqmDUfOnPzsEAG6ogQL6Svo6ynYLVKIvRPPhXkq+fp6sJ5YVT5Hr356yCXlM++G56Pk8Z+tPzNjjvGSSs/MsYtgFaqhPCsnKhb55xHkc8GJ9haq8k3PSqwMSeJHnGiDq5lzdmsjdmGkWdQq2jIhKlhMZMm5VQWn0T59+xjjIIwIDAQAB";
    private static final String[] GOOGLE_CATALOG = new String[]{"ntpsync.donation.1",
            "ntpsync.donation.2", "ntpsync.donation.3", "ntpsync.donation.5", "ntpsync.donation.8",
            "ntpsync.donation.13"};
    private static DonateActivity INSTANCE =null;

    /**
     * PayPal
     */
    private static final String PAYPAL_USER = "singh121officialvikrant@gmail.com";
<<<<<<< HEAD
    //private static final String PAYPAL_CURRENCY_CODE = "USD";
=======
    private static final String PAYPAL_CURRENCY_CODE = "USD";
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337

    /**
     * Bitcoin
     */
    private static final String BITCOIN_ADDRESS = "12Y6zbBYoRxf8kBrjau3WedjtzvcACvPMk";

    /**
     * Called when the activity is first created.
     */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_donation, container, false);

        FragmentTransaction ft = getChildFragmentManager().beginTransaction();
        DonationsFragment donationsFragment;
        if (BuildConfig.DONATIONS_GOOGLE) {
            donationsFragment = DonationsFragment.newInstance(BuildConfig.DEBUG, true, GOOGLE_PUBKEY, GOOGLE_CATALOG
                   ,null, false, null, null,
                    null, false, null, null, false, null);
        } else {
            donationsFragment = DonationsFragment.newInstance(BuildConfig.DEBUG, false, null, null, null, true, PAYPAL_USER,
<<<<<<< HEAD
                    "", "paypal", false, null, null, true, BITCOIN_ADDRESS);
=======
                    PAYPAL_CURRENCY_CODE, "paypal", false, null, null, true, BITCOIN_ADDRESS);
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
        }

        ft.replace(R.id.container_donate, donationsFragment, "donationsFragment");
        ft.commit();
        return view;
    }

    public static Fragment getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new DonateActivity();
        return INSTANCE;
    }

    /**
     * Needed for Google Play In-app Billing. It uses startIntentSenderForResult(). The result is not propagated to
     * the Fragment like in startActivityForResult(). Thus we need to propagate manually to our Fragment.
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        FragmentManager fragmentManager = getChildFragmentManager();
        Fragment fragment = fragmentManager.findFragmentByTag("donationsFragment");
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

}
