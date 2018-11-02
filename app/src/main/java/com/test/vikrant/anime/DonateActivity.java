package com.test.vikrant.anime;

<<<<<<< HEAD
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
=======
<<<<<<< HEAD
import android.app.Activity;
import android.content.Intent;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
<<<<<<< HEAD
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
=======
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


<<<<<<< HEAD

=======
import com.google.gson.JsonObject;
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
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
<<<<<<< HEAD
    private SearchView searchView;
    private View view;
    private static DonateActivity INSTANCE = null;
    public static final int PAYPAL_REQUEST_CODE = 7171;
    private static PayPalConfiguration config = new PayPalConfiguration()
=======
    private View view;
    private static DonateActivity INSTANCE =null;
    public static final int PAYPAL_REQUEST_CODE=7171;
    private static PayPalConfiguration config=new PayPalConfiguration()
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
            .environment(PayPalConfiguration.ENVIRONMENT_SANDBOX)
            .clientId(Config.PAYPAL_CLIENT_ID);

    Button btnPayNow;
    EditText editAmount;
<<<<<<< HEAD
    String amount = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
        setHasOptionsMenu(false);
=======
    String amount="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setRetainInstance(true);
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
<<<<<<< HEAD
        setHasOptionsMenu(false);
        view = inflater.inflate(R.layout.activity_donation, container, false);

        Intent intent = new Intent(getActivity(), PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        getActivity().startService(intent);

        btnPayNow = view.findViewById(R.id.Paypal_button);
        editAmount = view.findViewById(R.id.Paypal_amount);
        whiteNotificationBar(view);
=======

        view = inflater.inflate(R.layout.activity_donation, container, false);

        Intent intent=new Intent(getActivity(),PayPalService.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        getActivity().startService(intent);

        btnPayNow=view.findViewById(R.id.Paypal_button);
        editAmount=view.findViewById(R.id.Paypal_amount);

>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processPayment();
            }
        });

        return view;
    }
<<<<<<< HEAD

    public void processPayment() {
        amount = editAmount.getText().toString();
        PayPalPayment payPalPayment = new PayPalPayment(new BigDecimal(String.valueOf(amount)),
                "USD", "Donate For FasAnime", PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent = new Intent(getActivity(), PaymentActivity.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payPalPayment);
        startActivityForResult(intent, PAYPAL_REQUEST_CODE);
    }

    public static Fragment getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new DonateActivity();
=======
    public void processPayment(){
        amount=editAmount.getText().toString();
        PayPalPayment payPalPayment=new PayPalPayment(new BigDecimal(String.valueOf(amount)),
                "USD","Donate For FasAnime",PayPalPayment.PAYMENT_INTENT_SALE);
        Intent intent=new Intent(getActivity(), PaymentActivity.class);

        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION,config);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT,payPalPayment);
        startActivityForResult(intent,PAYPAL_REQUEST_CODE);
    }
    public static Fragment getINSTANCE(){
        if(INSTANCE==null)
            INSTANCE=new DonateActivity();
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        return INSTANCE;
    }

    @Override
    public void onDestroyView() {
<<<<<<< HEAD
        getActivity().stopService(new Intent(getActivity(), PayPalService.class));
=======
        getActivity().stopService(new Intent(getActivity(),PayPalService.class));
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
        super.onDestroyView();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
<<<<<<< HEAD
        Log.i("result code ", String.valueOf(resultCode));
        if (requestCode == PAYPAL_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);
                if (confirmation != null) {
                    try {
                        String paymentDetails = confirmation.toJSONObject().toString(4);
                        Log.i("paymentExample amount ", paymentDetails + " \n " + amount);
                        Log.i("paymentdetails2 ", amount);
                        startActivity(new Intent(getActivity(), PaymentDetails.class)
                                .putExtra("PaymentDetails", paymentDetails)
                                .putExtra("PaymentAmount", amount));


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            } else if (resultCode == Activity.RESULT_CANCELED)
                Toast.makeText(getActivity(), "Canceled", Toast.LENGTH_SHORT).show();
        } else if (resultCode == PaymentActivity.RESULT_EXTRAS_INVALID)
            Toast.makeText(getActivity(), "Invalid", Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        MenuItem item=menu.findItem(R.id.action_search);
        item.setVisible(false);
    }
    private void whiteNotificationBar(View view) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            int flags = view.getSystemUiVisibility();
            flags |= View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
            view.setSystemUiVisibility(flags);
            getActivity().getWindow().setStatusBarColor(Color.WHITE);
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        menu.clear();
        menu.close();
        super.onCreateOptionsMenu(menu, inflater);
    }
}
=======
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
=======
public class DonateActivity {
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
}
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
