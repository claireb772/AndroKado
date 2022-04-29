package com.example.androkado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.androkado.bo.Article;

public class InfoUrlActivity extends AppCompatActivity {

    private WebView view;
    private Article article;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
//         Intent intent = getIntent();
//        Article article = intent.getParcelableExtra("article");
//        TextView tv_urlArticle = findViewById(R.id.tv_infoUrl_urlArticle);
//        tv_urlArticle.setText(article.getUrl());

        Intent intent = getIntent();
        article = intent.getParcelableExtra("article");

        view = findViewById(R.id.wv_webview);
        view.getSettings().setJavaScriptEnabled(true);

        view.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        view.loadUrl(article.getUrl());
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && view.canGoBack()) {
            view.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}