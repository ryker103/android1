package com.example.admin.fitness;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class CameraActivity extends AppCompatActivity {

    ImageView image;
    Button btn1;
    String pictureFilePath ;
    File imgFile;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        image = findViewById(R.id.imageView);
        btn1 = findViewById(R.id.button2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra("android.int.extra.quickCapture", true);
                startActivityForResult(intent, 1);
            }
        });

    }

    protected void onActivityResult(int requestCode , int resultCode , @Nullable Intent data)
    {
        super.onActivityResult(requestCode,resultCode,data);
        Bitmap bp =(Bitmap) data.getExtras().get("data");
        image.setImageBitmap(bp);
    }

    private void sendTakePictureIntent()

    {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        cameraIntent.putExtra(MediaStore.EXTRA_FINISH_ON_COMPLETION,true);

        if(cameraIntent.resolveActivity(getPackageManager())!=null)
        {
            File pictureFile = null;
            try
            {
                pictureFile = getPictureFile();
            } catch (IOException ex){
                Toast.makeText(this,"Photo file cant be created , pls try again",Toast.LENGTH_SHORT).show();
                return;
            }

            if (pictureFile != null){
                Uri photoURI = FileProvider.getUriForFile(this,"com.example.CameraExample.provider",pictureFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,photoURI);
                startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);
            }
        }

    }

    private File getPictureFile() throws IOException
    {
        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        String pictureFile = "IMG_" + timeStamp;
        File filename = new File(pictureFile + ".jpg");
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(pictureFile,".jpg",storageDir);
        pictureFilePath = image.getAbsolutePath();
        return  image;
    }

//

    public static void addImageToGallary(final String filePath, final Context context)
    {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.DATE_TAKEN,System.currentTimeMillis());
        values.put(MediaStore.Images.Media.MIME_TYPE,"image/jpeg");
        values.put(MediaStore.MediaColumns.DATA,filePath);
        context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,values);
    }


}