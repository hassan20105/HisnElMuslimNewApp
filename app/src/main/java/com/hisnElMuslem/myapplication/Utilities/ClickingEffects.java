package com.hisnElMuslem.myapplication.Utilities;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;

import com.hisnElMuslem.myapplication.R;

public class ClickingEffects {
    public static void vibrate(Context context)
    {
        Vibrator vibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(200);
    }

    public static void sound (Context context)
    {
        MediaPlayer mp = MediaPlayer. create (context, R.raw.buttonsound_click);
        mp.start();
    }

}
