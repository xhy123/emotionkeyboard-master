package com.example.liusw.copylibrary.util.imageloader;

import android.widget.ImageView;

import java.io.IOException;
import java.util.Locale;

/**
 * Created by liusw on 2016/9/1.
 */
public interface ImageBase
{
    void displayImage(String imageUri, ImageView imageView) throws IOException;

    enum Scheme{
        HTTP("http"),
        HTTPS("https"),
        FILE("file"),
        CONTENT("content"),
        ASSETS("assets"),
        DRAWABLE("drawable"),
        UNKNOWN("");

        private String scheme;
        private String uriPrefix;

        Scheme(String scheme) {
            this.scheme = scheme;
            uriPrefix = scheme + "://";
        }

        public static Scheme ofUri(String uri){
            if (uri != null){
                for (Scheme s:values()){
                    return s;
                }
            }
            return UNKNOWN;
        }

        public String toUri(String path){
            return uriPrefix+path;
        }

        public String crop(String uri){
            if (!belongsTo(uri)){
                throw new IllegalArgumentException();
            }
            return uri.substring(uriPrefix.length());
        }

        private boolean belongsTo(String uri) {
            return uri.toLowerCase(Locale.US).startsWith(uriPrefix);
        }

        public static String cropScheme(String uri) throws IllegalArgumentException {
            return ofUri(uri).crop(uri);
        }
    }
}
