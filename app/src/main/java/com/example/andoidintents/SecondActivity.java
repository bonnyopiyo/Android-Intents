package com.example.andoidintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {
    //Declaring the buttons
Button mBtndial,mBtncall,mBtnsms,mBtncamera,mBtnemail,mBtnshare,mBtnmpesa,mBtnhome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        //initialize the buttons
        //call the buttons from activity_second.xml using the above initialisations
        mBtndial = findViewById(R.id.brndial);
        mBtncall = findViewById(R.id.btncall);
        mBtnsms = findViewById(R.id.btnsms);
        mBtncamera = findViewById(R.id.brncamera);
        mBtnemail = findViewById(R.id.btnmail);
        mBtnshare = findViewById(R.id.btnshare);
        mBtnmpesa = findViewById(R.id.btnpesa);
        mBtnhome = findViewById(R.id.btnhome);

mBtndial.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String phone = "07";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
});
mBtncall.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + "+918511812660"));
        if (ContextCompat.checkSelfPermission(SecondActivity.this,
                Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(SecondActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
        }
        else
        {
            startActivity(intent);
        }
    }
});
mBtnsms.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Uri uri = Uri.parse("smsto:0791898286");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "Niaje msee.....");
        startActivity(intent);
    }
});
mBtncamera.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(takePictureIntent, 1);
    }
});
mBtnemail.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto","bonfaceosindi@gmail.com", null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Job Apllication");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hello sir");
        startActivity(Intent.createChooser(emailIntent, "Sending email..."));
    }
});
mBtnshare.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "Hey, download this app from www.bondaceosindi@gmail.com");
        startActivity(shareIntent);

    }
});
mBtnmpesa.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent simToolKitLaunchIntent = getApplicationContext().getPackageManager().getLaunchIntentForPackage("com.android.stk");
        if(simToolKitLaunchIntent != null) {
            startActivity(simToolKitLaunchIntent);
        }
    }
});
mBtnhome.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent gohome = new Intent(SecondActivity.this,MainActivity.class);
        startActivity(gohome);
    }
});
    }
}
