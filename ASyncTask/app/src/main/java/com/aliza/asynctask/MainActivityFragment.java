package com.aliza.asynctask;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;



/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ImageDownloader imageDownloader = new ImageDownloader();
        imageDownloader.execute("https://raw.githubusercontent.com/alizalevinger/CS6392015/master/skyline.png");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    private class ImageDownloader
            extends AsyncTask<String, Integer, Bitmap>{
        protected void onPreExecute(){
            //Setup is done here
        }
        @Override
        protected Bitmap doInBackground(String... params) {
            //TODO Auto-generated method stub
            try{
                URL url = new URL(params[0]);
                HttpURLConnection httpCon =
                        (HttpURLConnection)url.openConnection();
                if(httpCon.getResponseCode() != 200)
                    throw new Exception("Failed to connect");
                InputStream is = httpCon.getInputStream();
                return BitmapFactory.decodeStream(is);
            }catch(Exception e){

                Log.e("Image", "Failed to load image", e);
            }
            return null;
        }
        protected void onProgressUpdate(Integer... params){
            //Update a progress bar here, or ignore it, it's up to you
        }
        protected void onPostExecute(Bitmap img){
            ImageView iv = (ImageView)getView().findViewById(R.id.remote_image);
            if(iv!=null && img!=null){
                iv.setImageBitmap(img);
            }
        }
        protected void onCancelled(){
        }
    }

}

