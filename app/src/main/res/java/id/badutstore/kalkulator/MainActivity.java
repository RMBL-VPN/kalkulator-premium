package id.badutstore.kalkulator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            // Status / navigation bar — dibungkus try agar tidak crash di ROM aneh
            try {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(Color.rgb(16, 19, 28));
                getWindow().setNavigationBarColor(Color.rgb(16, 19, 28));
                if (Build.VERSION.SDK_INT < 30) {
                    getWindow().getDecorView().setSystemUiVisibility(0);
                }
            } catch (Throwable ignored) {
            }

            WebView webView = new WebView(this);
            webView.setBackgroundColor(Color.rgb(16, 19, 28));
            webView.setLayerType(View.LAYER_TYPE_HARDWARE, null);

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
                settings.setSafeBrowsingEnabled(false);
            }

            webView.setWebViewClient(new WebViewClient());
            setContentView(webView);
            webView.loadUrl("file:///android_asset/index.html");

        } catch (Throwable e) {
            // WebView / system error → jangan biarkan force-close
            TextView tv = new TextView(this);
            tv.setText(
                    "Gagal memuat kalkulator.\n\n" +
                    "1. Buka Settings → Apps\n" +
                    "2. Cari \"Android System WebView\" atau \"Chrome\"\n" +
                    "3. Enable + Update dari Play Store\n" +
                    "4. Buka aplikasi ini lagi\n\n" +
                    "Detail: " + e.getClass().getSimpleName() +
                    (e.getMessage() != null ? "\n" + e.getMessage() : "")
            );
            tv.setTextColor(Color.WHITE);
            tv.setBackgroundColor(Color.rgb(16, 19, 28));
            tv.setPadding(48, 48, 48, 48);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(15f);
            setContentView(tv);
        }
    }
}
