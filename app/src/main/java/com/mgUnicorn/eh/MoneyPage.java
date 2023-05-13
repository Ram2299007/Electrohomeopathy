package com.mgUnicorn.eh;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.mgUnicorn.eh.databinding.ActivityMoneyPageBinding;
import com.mgUnicorn.eh.models.paymentModel;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MoneyPage extends AppCompatActivity {

    ActivityMoneyPageBinding binding;


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoneyPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.white));
        }
        Vibrator v = (Vibrator) getSystemService(getApplicationContext().VIBRATOR_SERVICE);


        binding.runn.setSelected(true);


        Toast.makeText(getApplicationContext(), "Please wait... \n we are  checking you are premium or not. ", Toast.LENGTH_SHORT).show();
      //  Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
        FirebaseDatabase.getInstance().getReference().child("payment").child(Objects.requireNonNull(FirebaseAuth.getInstance().getUid()))

                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        paymentModel model = snapshot.getValue(paymentModel.class);

                        try {
                            System.out.println(model.getPaymentMessage());

                            binding.imgClose.setVisibility(View.VISIBLE);
                            Toast.makeText(getApplicationContext(), "Please click below on close button to home page", Toast.LENGTH_SHORT).show();


                        } catch (Exception e) {

                            Toast.makeText(getApplicationContext(), "Please choose payment option.....", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


        binding.btnonefivezerozero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), GooglePayPayment.class));
            }
        });


        binding.imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get instance of Vibrator from current Context

// Vibrate for 400 milliseconds
                v.vibrate(80);
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                finish();
                Toast.makeText(getApplicationContext(), "Welcome...!", Toast.LENGTH_SHORT).show();

            }
        });


        binding.fivezerozero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Currently unavailable !!!", Toast.LENGTH_SHORT).show();
                //startActivity(new Intent(getApplicationContext(), GooglePayment2.class));
            }
        });
    }





}