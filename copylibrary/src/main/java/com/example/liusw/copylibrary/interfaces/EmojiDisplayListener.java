package com.example.liusw.copylibrary.interfaces;

import android.content.Context;
import android.text.Spannable;

/**
 * Created by liusw on 2016/9/1.
 */
public interface EmojiDisplayListener
{
    void onEmojiDisplay(Context context, Spannable spannable,String emojiHex, int fontSize, int start, int end);
}
