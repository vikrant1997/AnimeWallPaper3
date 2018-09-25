package com.test.vikrant.anime;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Bundle;
=======
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
>>>>>>> PaypalAdded
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
<<<<<<< HEAD
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

=======
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.gson.JsonObject;
import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;
import com.test.vikrant.anime.Adapter.MyFragmentAdapter;
import com.test.vikrant.anime.Common.Common;
import com.test.vikrant.anime.config.Config;
import com.test.vikrant.anime.config.PaymentDetails;

import org.json.JSONException;
import org.sufficientlysecure.donations.DonationsFragment;

import java.math.BigDecimal;

import static android.app.Activity.RESULT_OK;

public class DonateActivity extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private View view;
    private static DonateActivity INSTANCE =null;
    public static final int PAYPAL_REQUEST_CODE=7171;
    private static PayPalConfiguration config=new PayPalConfiguration()
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    Button btnPayNow;
    EditText editAmount;
    String amount="";
>>>>>>> PaypalAdded
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        super.onCreate(savedInstanceState);
<<<<<<< HEAD

    }


=======
    }

>>>>>>> PaypalAdded
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

<<<<<<< HEAD
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

=======
        view = inflater.inflate(R.layout.activity_donation, container, false);

        Intent intent=new Intent(getActivity(),PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        getActivity().startService(intent);

        btnPayNow=view.findViewById(R.id.Paypal_button);
        editAmount=view.findViewById(R.id.Paypal_amount);

        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });

        return view;
    }
    public void processPayment(){
        amount=editAmount.getText().toString();
        PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),
                "USD","Donate For FasAnime",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent=new Intent(getActivity(), PaymentActivity.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }
>>>>>>> PaypalAdded
    public static Fragment getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new DonateActivity();
        return INSTANCE;
    }

<<<<<<< HEAD
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

=======
    @Override
    public void onDestroyView() {
        getActivity().stopService(new Intent(getActivity(),PayPalService.class));
        super.onDestroyView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("result code ",String.valueOf(resultCode));
        if(requestCode==PAYPAL_REQUEST_CODE){
            if(resultCode== Activity.RESULT_OK){
                PaymentConfirmation confirmation=data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if(confirmation!=null){
                    try{
                        String paymentDetails=confirmation.toJSONObject().toString(4);
                        Log.i("paymentExample amount ", paymentDetails +" \n "+amount);
                        Log.i("paymentdetails2 ",amount);
                        startActivity(new Intent(getActivity(), PaymentDetails.class)
                        .putExtra("PaymentDetails",paymentDetails)
                        .putExtra("PaymentAmount",amount));



                    }
                    catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }
            else if(resultCode==Activity.RESULT_CANCELED)
                Toast.makeText(getActivity(),"Canceled",Toast.LENGTH_SHORT).show();
        }else if (resultCode==PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(getActivity(),"Invalid",Toast.LENGTH_SHORT).show();
    }
>>>>>>> PaypalAdded
}
