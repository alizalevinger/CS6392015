package com.aliza.asynctaskproject;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ImageDownloader extends AsyncTask<String, Integer, Bitmap> {
    private Context context;
    private ImageView iv;

    public ImageDownloader(ImageView imgview){
        iv=imgview;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected Bitmap doInBackground(String...params) {
        try {
            URL myUrl = new URL(params[0]);
            HttpURLConnection httpCon = (HttpURLConnection) myUrl.openConnection();

            if (httpCon.getResponseCode() != 200)
                throw new Exception("Failed to connect");


            InputStream is = httpCon.getInputStream();
            return BitmapFactory.decodeStream(is);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

            return null;

    }



    @Override
     protected void onProgressUpdate (Integer...params){

    }

    @Override
    protected void onPostExecute(Bitmap img){

        if (iv!=null && img!=null){
            iv.setImageBitmap(img);
        }
    }
}

