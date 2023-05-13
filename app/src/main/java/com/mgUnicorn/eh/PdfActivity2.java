package com.mgUnicorn.eh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.File;

public class PdfActivity2 extends AppCompatActivity {

    String filePath="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdf2);

        PDFView pdfView=findViewById(R.id.pdfView);
        final SharedPreferences mSharedPreference= PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        String filePath=(mSharedPreference.getString("pdfKey", "Default_Value"));

        File file=new File(filePath);
        Uri path=Uri.fromFile(file);
        pdfView.fromUri(path).load();
    }
}