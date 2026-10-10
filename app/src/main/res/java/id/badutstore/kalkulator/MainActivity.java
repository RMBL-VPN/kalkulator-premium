package id.badutstore.kalkulator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Hindari crash tema di beberapa ROM
        try {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        } catch (Throwable ignored) {
        }

        super.onCreate(savedInstanceState);

        // Layout dasar dulu supaya activity tidak blank/crash total
        FrameLayout root = new FrameLayout(this);
        root.setBackgroundColor(Color.rgb(16, 19, 28));
        setContentView(root);

        try {
            try {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(Color.rgb(16, 19, 28));
                getWindow().setNavigationBarColor(Color.rgb(16, 19, 28));
            } catch (Throwable ignored) {
            }

            WebView webView = new WebView(this);
            webView.setBackgroundColor(Color.rgb(16, 19, 28));
            webView.setLayoutParams(new FrameLayout.LayoutParams(
                    FrameLayout.LayoutParams.MATCH_PARENT,
                    FrameLayout.LayoutParams.MATCH_PARENT));

            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(false);
            settings.setAllowFileAccess(true);
            settings.setAllowContentAccess(false);
            settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
            settings.setSupportZoom(false);
            settings.setBuiltInZoomControls(false);
            settings.setDisplayZoomControls(false);
            if (Build.VERSION.SDK_INT >= 26) {
                try {
                    settings.setSafeBrowsingEnabled(false);
                } catch (Throwable ignored) {
                }
            }

            webView.setWebViewClient(new WebViewClient());
            root.addView(webView);
            webView.loadUrl("file:///android_asset/index.html");

        } catch (Throwable e) {
            TextView tv = new TextView(this);
            tv.setText(
                    "Gagal memuat kalkulator.\n\n" +
                    "Update/Enable Android System WebView atau Chrome,\n" +
                    "lalu buka aplikasi ini lagi.\n\n" +
                    e.getClass().getSimpleName() +
                    (e.getMessage() != null ? "\n" + e.getMessage() : "")
            );
            tv.setTextColor(Color.WHITE);
            tv.setPadding(48, 48, 48, 48);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(15f);
            root.addView(tv);
        }
    }
}
