package com.izarebin.webview;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText edturl;
    Button btngo;
    WebView web;
    TextView txtcopyright;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edturl = (EditText) findViewById(R.id.edturl);
        btngo = (Button) findViewById(R.id.btngo);
        web = (WebView) findViewById(R.id.web);
        txtcopyright = (TextView) findViewById(R.id.txtcopyright);

        Typeface font = Typeface.createFromAsset(getAssets(), "fonts/koodak.ttf");

        btngo.setTypeface(font);
        txtcopyright.setTypeface(font);

        web.setWebViewClient(new MyWebView());

        btngo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edturl.getText().toString();
                web.getSettings().setLoadsImagesAutomatically(true);
                web.getSettings().setJavaScriptEnabled(true);
                web.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                web.loadUrl("http://" + url);
            }
        });
    }

    private class MyWebView extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
