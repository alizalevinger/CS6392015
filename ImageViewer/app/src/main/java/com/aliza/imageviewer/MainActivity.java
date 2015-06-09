package com.aliza.imageviewer;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.Button;
import android.widget.ImageView;
import android.view.View;
import android.view.View.OnClickListener;




public class MainActivity extends FragmentActivity implements OnClickListener{



    int image_index = 0;
    private static final int MAX_IMAGE_COUNT = 5;


    private Integer[] ImageIds = {
            R.drawable.brooklynbridge,
            R.drawable.freedomtower,
            R.drawable.grandcentralclock,
            R.drawable.skyline,
            R.drawable.statue_of_liberty
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        android.app.FragmentManager fragmentManager=getFragmentManager();
        android.app.FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.commit();


        setContentView(R.layout.activity_main);

        Button prev_Button = (Button) findViewById(R.id.Prev);
        if (prev_Button != null)
            prev_Button.setOnClickListener(this);
        Button next_Button = (Button) findViewById(R.id.Next);
        if (next_Button != null)
            next_Button.setOnClickListener(this);

        showImage();

    }



    private void showImage() {

        ImageView imgView = (ImageView) findViewById(R.id.image_view);
        imgView.setImageResource(ImageIds[image_index]);

    }


    public void onClick(View v) {


        switch (v.getId()) {

            case (R.id.Prev):

                image_index--;

                if (image_index == -1) {
                    image_index = MAX_IMAGE_COUNT - 1;
                }


                showImage();



                break;

            case (R.id.Next):

                image_index++;

                if (image_index == MAX_IMAGE_COUNT) {
                    image_index = 0;
                }


                showImage();

                break;

        }

    }}













