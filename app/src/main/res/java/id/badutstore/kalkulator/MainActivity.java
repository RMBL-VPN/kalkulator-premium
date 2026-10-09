package id.badutstore.kalkulator;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setStatusBarColor(Color.rgb(16, 19, 28));
        getWindow().setNavigationBarColor(Color.rgb(16, 19, 28));
        getWindow().getDecorView().setSystemUiVisibility(0);

        try {
            WebView webView = new WebView(this);
            webView.setBackgroundColor(Color.rgb(16, 19, 28));

            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(false);
            settings.setAllowFileAccess(true);
            settings.setAllowContentAccess(false);

            webView.setWebViewClient(new WebViewClient());
            setContentView(webView);
            webView.loadUrl("file:///android_asset/index.html");
        } catch (Exception e) {
            // WebView tidak tersedia / corrupt → tampilkan pesan, jangan crash
            TextView tv = new TextView(this);
            tv.setText("WebView tidak tersedia.\n\n" +
                    "Buka Settings → Apps → Android System WebView (atau Chrome)\n" +
                    "lalu Enable + Update, kemudian buka aplikasi ini lagi.\n\n" +
                    "Error: " + e.getClass().getSimpleName());
            tv.setTextColor(Color.WHITE);
            tv.setBackgroundColor(Color.rgb(16, 19, 28));
            tv.setPadding(48, 48, 48, 48);
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(16);
            setContentView(tv);
        }
    }
}
