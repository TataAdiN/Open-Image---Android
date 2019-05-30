package tataadin.openimage.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Controller_Main {
    private Context context;
    private ImageView imageView;
    private Intent data;

    public Controller_Main(Context context){
        this.context = context;
    }

    public void openDialog(){
        Activity activity = (Activity) context;
        Intent searchImage = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(searchImage, 1);
    }

    private void setImage(){
        Uri SelectedImage = data.getData();
        if(SelectedImage!=null){
            try{
                InputStream ImageStream = context.getContentResolver().openInputStream(SelectedImage);
                Bitmap ImageBitmap = BitmapFactory.decodeStream(ImageStream);
                imageView.setImageBitmap(ImageBitmap);
            }catch(FileNotFoundException notfound){
                Toast.makeText(context, notfound.toString(), Toast.LENGTH_LONG).show();
            }
        }
    }

    public void setImage(ImageView imageView, Intent data){
        this.imageView = imageView;
        this.data = data;
        setImage();
    }
}
