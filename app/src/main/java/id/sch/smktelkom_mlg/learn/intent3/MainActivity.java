package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.imageView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialPhoneNumber("085850151839");

            }
        });


        findViewById(R.id.imageView3sms).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialsms("Pesan Dari Dafa");

            }
        });


        findViewById(R.id.imageViewbrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openweb("https://classroom.google.com/u/1/c/MTkwMjg0ODQwNFpa");

            }
        });



    }

    private void openweb(String url) {

        Uri weppage = Uri.parse(url);

        Intent intent = new Intent(Intent.ACTION_VIEW, weppage);
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivity(intent);

    }

    private void dialsms(String message) {


        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivity(intent);


    }

    private void dialPhoneNumber(String phonenumber) {

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phonenumber));
        if (intent.resolveActivity(getPackageManager()) != null) ;
        startActivity(intent);

    }
}
