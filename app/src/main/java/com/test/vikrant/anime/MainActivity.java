package com.test.vikrant.anime;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import com.facebook.stetho.Stetho;
=======
//import com.facebook.stetho.Stetho;
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
import com.facebook.stetho.Stetho;
>>>>>>> PaypalAdded
=======
import com.facebook.stetho.Stetho;
>>>>>>> master


public class MainActivity extends AppCompatActivity {
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    AppCenter.start(getApplication(), "4eb56640-ee14-4e52-bc77-ae448422c6f6",
            Analytics.class, Crashes.class);
    AppCenter.start(getApplication(), "4eb56640-ee14-4e52-bc77-ae448422c6f6", Analytics.class, Crashes.class);

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> PaypalAdded
=======
>>>>>>> master
            Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);
        initializerBuilder.enableWebKitInspector( Stetho.defaultInspectorModulesProvider(this) );
        initializerBuilder.enableDumpapp( Stetho.defaultDumperPluginsProvider(getApplicationContext()) );
        Stetho.Initializer initializer = initializerBuilder.build();
        Stetho.initialize(initializer);

<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 54d2c575dcc6ea15ca80d5ea23fdb86520b80337
=======
>>>>>>> PaypalAdded
=======
>>>>>>> master
    setContentView(R.layout.activity_main);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run( ){
            Intent intent=new Intent(MainActivity.this,MainActivity2.class);
            startActivity(intent);
            finish();}
        },1000);

}
    }

