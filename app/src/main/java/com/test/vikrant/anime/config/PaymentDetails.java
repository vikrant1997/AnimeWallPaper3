package com.test.vikrant.anime.config;

<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.test.vikrant.anime.R;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class PaymentDetails extends AppCompatActivity {

    TextView txtId,txtAmount,txtStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_payment_details);


        Intent intent=getIntent();
        try{
            Log.i("reached in paypal ","yes");
            JSONObject jsonObject=new JSONObject(intent.getStringExtra("PaymentDetails"));
            showDetails(jsonObject.getJSONObject("response"),intent.getStringExtra("PaymentAmount"));
        }
        catch (JSONException e){
            e.printStackTrace();
        }
    }
    private void showDetails(JSONObject response,String paymentAmount)throws JSONException{
        txtId=(TextView)findViewById(R.id.textId);
        txtAmount=(TextView)findViewById(R.id.textAmount);
        txtStatus=(TextView)findViewById(R.id.textStatus);
           // Log.i("paypal log ",response.getString("id")+" "+response.getString("state")+" "+paymentAmount);
            txtId.setText("Payment Id-"+response.getString("id"));
            txtAmount.setText("Payment Amount "+"$"+paymentAmount);
            txtStatus.setText("Payment Status "+response.getString("state"));



<<<<<<< HEAD
=======
=======
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PaymentDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);
>>>>>>> e98aa7a509bf4e3795c36120bc8d906927bd9c8b
>>>>>>> 440d6108ba6582afc33f33de7d4fe2570549dd0e
    }
}
