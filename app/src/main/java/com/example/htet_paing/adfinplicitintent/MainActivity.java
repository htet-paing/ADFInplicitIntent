package com.example.htet_paing.adfinplicitintent;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.net.URI;

public class MainActivity extends AppCompatActivity {

    private EditText mwebsiteEdittext;
    private EditText mlocationEdittext;
    private EditText mShareTextEdittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mwebsiteEdittext=findViewById(R.id.website_edittext);
        mlocationEdittext=findViewById(R.id.location_edittext);
        mShareTextEdittext=findViewById(R.id.share_edittext);
    }

    public void OpenWebsite(View view) {
        String url=mwebsiteEdittext.getText().toString();
        Uri webpage=Uri.parse(url);
        Intent intent=new Intent(Intent.ACTION_VIEW,webpage);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }else {
            Log.d("ImplicitIntents","Cant handle this");
        }
    }

    public void OpenLocation(View view) {
        String loc=mlocationEdittext.getText().toString();
        Uri addressUri=Uri.parse("geo:0,0?q=" + loc);
        Intent intent=new Intent(Intent.ACTION_VIEW,addressUri);
        if (intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);

        }else {
            Log.d("ImplicitIntents","Cant handle this");

        }
    }

    public void ShareText(View view) {
        String txt=mShareTextEdittext.getText().toString();
        String mimeType="text/pain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser();

    }
}
