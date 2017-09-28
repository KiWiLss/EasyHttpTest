package com.winding.easyhttptest.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.chad.library.adapter.base.listener.SimpleClickListener;

/**
 * Created by 刘少帅 on 2017/9/28
 */

public class StartService extends Service {


    public static final String TAG = "MMM";
    private AudioManager mAm;
    private static boolean vIsActive=false;
    private MyOnAudioFocusChangeListener mListener;
    public class MyOnAudioFocusChangeListener implements AudioManager.OnAudioFocusChangeListener {
        @Override
        public void onAudioFocusChange(int focusChange) {
            // TODO Auto-generated method stub
        }
    }
    public int onStartCommand(Intent intent, int flags, int startId) {
        // TODO Auto-generated method stub
        Log.d(SimpleClickListener.TAG, "onStartCommand");
        Toast.makeText(getApplicationContext(), "服务已启动", Toast.LENGTH_SHORT).show();

        mAm = (AudioManager) getApplicationContext().getSystemService(
                Context.AUDIO_SERVICE);
        vIsActive=mAm.isMusicActive();
        mListener = new MyOnAudioFocusChangeListener();
        Log.e(TAG, "onStartCommand: "+vIsActive );
        if(vIsActive)
        {
            int result = mAm.requestAudioFocus(mListener,
                    AudioManager.STREAM_MUSIC,
                    AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
            {
                Log.d(TAG, "requestAudioFocus successfully.");
            }
            else
            {
                Log.d(TAG, "requestAudioFocus failed.");
            }
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
        if(vIsActive)
        {
            mAm.abandonAudioFocus(mListener);
        }
        Log.d(TAG, "onDestroy");
    }

    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
