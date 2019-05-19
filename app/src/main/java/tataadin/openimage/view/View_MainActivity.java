package tataadin.openimage.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import tataadin.openimage.R;
import tataadin.openimage.controller.Controller_Main;

public class View_MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button tombolOpen;
    private Controller_Main controllerMain;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        controllerMain = new Controller_Main(this);
        setContentView(R.layout.activity_main);
        tombolOpen = findViewById(R.id.tombol_open);
        imageView = findViewById(R.id.imageView);
        tombolOpen.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (tombolOpen == view){
            controllerMain.openDialog();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1) {
            if (resultCode == RESULT_OK) {
                controllerMain.setImage(imageView, data);
            }
        }
    }
}
