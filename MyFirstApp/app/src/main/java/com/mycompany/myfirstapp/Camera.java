package com.mycompany.myfirstapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 888ch_000 on 2/7/2015.
 */
public class Camera extends ActionBarActivity
{
    private Uri fileUri;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        fileUri = getOutputMediaFileUri(1);
        i.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);

        startActivityForResult(i, 100);
    }

    @Override
    protected  void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK)
            Toast.makeText(this, "Image saved to:\n" + data.getData(), Toast.LENGTH_LONG).show();
        else if(resultCode == RESULT_CANCELED)
        {
            //User Cancels image request
        } else
        {
            //Image Capture Failed
        }
    }

    private static Uri getOutputMediaFileUri(int type)
    {
        return Uri.fromFile(getOutputMediaFile(type));
    }

    private static File getOutputMediaFile(int type)
    {
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Camera");
        if(! mediaStorageDir.exists()){
            if(!mediaStorageDir.mkdirs()){
                Log.d("Camera", "failed to create directory");
                return null;
            }
        }

        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if(type == 1){
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "IMG" + timeStamp + ".jpg");
        } else if(type == 2) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator + "VID" + timeStamp + ".mp4");
        } else {
            return null;
        }

        return mediaFile;
    }
}
