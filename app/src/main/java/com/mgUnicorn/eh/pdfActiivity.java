package com.mgUnicorn.eh;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.mgUnicorn.eh.databinding.ActivityPdfActiivityBinding;

import java.io.File;

public class pdfActiivity extends AppCompatActivity {

    String filePath = "";
    ActivityPdfActiivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfActiivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        PDFView pdfView = findViewById(R.id.pdfView);
        filePath = getIntent().getStringExtra("PdfPath");

        File file = new File(filePath);
        Uri path = Uri.fromFile(file);
        pdfView.fromUri(path).load();

        binding.whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                try {
                    Uri contentUri = FileProvider.getUriForFile(pdfActiivity.this,
                            BuildConfig.APPLICATION_ID + ".fileprovider",
                            file);
                    Intent share = new Intent(Intent.ACTION_SEND);
                    share.setType("application/pdf");
                    share.putExtra(Intent.EXTRA_STREAM, contentUri);
                    share.setPackage("com.whatsapp");
                    share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    startActivity(Intent.createChooser(share, "Share PDF via"));

                } catch (Exception eh) {
                    Toast.makeText(pdfActiivity.this, eh.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }


}