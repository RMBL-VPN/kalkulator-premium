package id.badutstore.kalkulator;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(16, 19, 28));
        getWindow().setNavigationBarColor(Color.rgb(16, 19, 28));

        WebView webView = new WebView(this);
        webView.setBackgroundColor(Color.rgb(16, 19, 28));

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);

        webView.setWebViewClient(new WebViewClient());

        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }
            }
