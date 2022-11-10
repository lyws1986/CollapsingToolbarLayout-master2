package com.example.collapsingtoolbarlayout;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;



public class MainActivity extends AppCompatActivity {
    private CollapsingToolbarLayout coordinatorLayout;
    private ImageView iv_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinatorLayout = findViewById(R.id.ctl_toolbar);
        iv_img  = findViewById(R.id.iv_header);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) iv_img.getDrawable();

        Bitmap bitmap = bitmapDrawable.getBitmap();

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(@Nullable Palette palette) {
                int color = palette.getDominantColor(Color.BLUE);
                coordinatorLayout.setContentScrimColor(color);
            }
        });
    }
}
