package com.mgUnicorn.eh.EhRemedy.conceroso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import com.mgUnicorn.eh.R;
import com.mgUnicorn.eh.ZoomLinearLayout;

public class c10 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c10);

        final ZoomLinearLayout zoomLinearLayout = (ZoomLinearLayout) findViewById(R.id.zoom_linear_layoutc10);
        zoomLinearLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                zoomLinearLayout.init(c10.this);
                return false;
            }
        });
    }
}