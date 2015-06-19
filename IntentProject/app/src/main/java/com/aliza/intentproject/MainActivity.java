package com.aliza.intentproject;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


    public class MainActivity extends FragmentActivity{




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            android.app.FragmentManager fragmentManager=getFragmentManager();
            android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.commit();
            setContentView(R.layout.activity_main);
        }

        public boolean onCreateOptionsMenu (Menu menu){
            // Inflate the menu; this adds items to the action bar if it is present.

            getMenuInflater().inflate(R.menu.menu_main, menu);
            super.onCreateOptionsMenu(menu);
            return true;
        }
   // }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    Button sms;
    Button phone;
    Button web;
    Button map;
    Button share;
    Button newActivity;

    public void sendSMS(View view){
        sms=(Button)findViewById(R.id.sms_button);
        sms.setOnClickListener(new View.OnClickListener(){
            @Override
         public void onClick(View view){
                Intent intent = new Intent((Intent.ACTION_VIEW));

                intent.setData(Uri.parse("smsto: " + Uri.encode("6312581026")));
                intent.putExtra("sms_body", "hello");
                intent.putExtra("address", "6312581026");
                intent.setType("vnd.android-dir/mms-sms");
                startActivity(intent);
            }
        });
            }

    public void makeCall(View view){
        phone=(Button)findViewById(R.id.call_button);
        phone.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                String phoneNumber = "tel:2589693567";
                callIntent.setData(Uri.parse(phoneNumber));
                startActivity(callIntent);
            }
        });
    }

    public void goWeb(View view){
        web=(Button)findViewById(R.id.web_button);
        web.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent webIntent = new Intent(Intent.ACTION_VIEW);
                String webPage = "http://stackoverflow.com";
                webIntent.setData(Uri.parse(webPage));
                startActivity(webIntent);
            }
        });
    }

    public void openMap(View view){
        map=(Button)findViewById(R.id.map_button);
        map.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent mapIntent = new Intent(Intent.ACTION_VIEW);
                String location = "10002";
                mapIntent.setData(Uri.parse("geo:0,0?q="+ location ));
                startActivity(mapIntent);
            }
        });
    }

    public void share(View view){
        share=(Button)findViewById(R.id.share_button);
        share.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("plain/text");
                String chooserTitle = getString(R.string.chooser_title);
                Intent chooser = Intent.createChooser(shareIntent, chooserTitle);
                startActivity(chooser);
            }
        });
    }

    public void launchNewActivity(View view){
        newActivity=(Button)findViewById(R.id.new_activity_button);
        newActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent newActivityIntent = new Intent(MainActivity.this, NewActivity.class);
                startActivity(newActivityIntent);

            }
        });
    }






}
