package ponti.edu.taller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.logging.Logger;

public class WebActivity extends AppCompatActivity {

    WebView page;
    String url= "https://es.wikipedia.org/wiki/Leonardo_de_Pisa";
    MainActivity k=new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        page= (WebView) findViewById(R.id.page);
        page.setWebViewClient(new WebViewClient());
        final WebSettings sett = page.getSettings();
        sett.setJavaScriptEnabled(true);
        page.loadUrl(url);
    }
}