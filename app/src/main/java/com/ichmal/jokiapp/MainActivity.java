package com.ichmal.jokiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button btnLogout ;
    Button info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogout = findViewById(R.id.out);
        info = findViewById(R.id.info);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                Toast.makeText(getApplicationContext(), "Logout Berhasil", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Info.class));
            }
        });
    }

    public void profileMenu(View v){
        Intent profile = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivity(profile);
    }
    public void historyMenu(View v){
        startActivity(new Intent(getApplicationContext(), RiwayatActivity.class));
    }
    public void jokiMlMenu(View v){
        Intent joki = new Intent(getApplicationContext(), JokiListActivity.class);
        startActivity(joki);
    }
    public void comingSoon(View v){
        Toast.makeText(getApplicationContext(), "Coming Soon.", Toast.LENGTH_LONG).show();
    }

    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Apakah Anda ingin keluar dari aplikasi?");
        builder.setCancelable(true);
        builder.setNegativeButton(getString(R.string.batal), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton(getString(R.string.keluar), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finishAffinity();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}