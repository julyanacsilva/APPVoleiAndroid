package br.com.sextouvolei.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.graphics.Color;
import android.webkit.CookieManager;
import java.io.InputStream;
import java.io.IOException;

public class MainActivity extends Activity {
    private WebView web;
    private final String origin = "https://appassets.androidplatform.net";
    private View customView;
    private WebChromeClient.CustomViewCallback customCallback;

    @Override public void onCreate(Bundle state) {
        super.onCreate(state);
        getWindow().setStatusBarColor(Color.rgb(12,19,33));
        getWindow().setNavigationBarColor(Color.rgb(12,19,33));
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        web = new WebView(this);
        web.setBackgroundColor(Color.rgb(12,19,33));
        web.getSettings().setJavaScriptEnabled(true);
        web.getSettings().setDomStorageEnabled(true);
        web.getSettings().setAllowFileAccess(false);
        web.getSettings().setAllowContentAccess(false);
        web.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        web.setWebChromeClient(new WebChromeClient() {
            @Override public void onShowCustomView(View view, CustomViewCallback callback) {
                if(customView != null) { callback.onCustomViewHidden(); return; }
                customView=view;customCallback=callback;
                setContentView(view);
            }
            @Override public void onHideCustomView() {
                if(customView!=null) {customView=null;setContentView(web);if(customCallback!=null)customCallback.onCustomViewHidden();customCallback=null;}
            }
        });
        web.setWebViewClient(new WebViewClient() {
            @Override public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                android.net.Uri uri=request.getUrl();
                if(!"appassets.androidplatform.net".equals(uri.getHost())) return null;
                String path=uri.getPath();
                if(path==null || path.equals("/"))path="/index.html";
                if(path.contains(".."))return new WebResourceResponse("text/plain","UTF-8",404,"Blocked",new java.util.HashMap<String,String>(),new java.io.ByteArrayInputStream(new byte[0]));
                String assetPath=path.substring(1);
                String mime=assetPath.endsWith(".html")?"text/html":assetPath.endsWith(".png")?"image/png":assetPath.endsWith(".webmanifest")?"application/manifest+json":"text/plain";
                try {
                    InputStream stream=getAssets().open(assetPath);
                    return new WebResourceResponse(mime,"UTF-8",stream);
                } catch(IOException err) {
                    return new WebResourceResponse("text/plain","UTF-8",404,"Not Found",new java.util.HashMap<String,String>(),new java.io.ByteArrayInputStream(new byte[0]));
                }
            }
        });
        setContentView(web);
        web.loadUrl(origin+"/index.html");
    }
    @Override public void onBackPressed() {
        if(customView!=null) { web.getWebChromeClient().onHideCustomView(); return; }
        if(web.canGoBack())web.goBack();else super.onBackPressed();
    }
    @Override protected void onDestroy(){ if(web!=null)web.destroy();super.onDestroy(); }
}
