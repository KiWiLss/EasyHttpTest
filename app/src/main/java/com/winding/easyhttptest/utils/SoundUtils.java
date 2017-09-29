package com.winding.easyhttptest.utils;

import android.content.Context;
import android.media.AudioManager;
import android.util.Log;

/**
 * Created by 刘少帅 on 2017/9/29
 */

public class SoundUtils {

    public static final String TAG ="MMM";

    public static AudioManager getSystemService(Context context){
        AudioManager mAudioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        return mAudioManager;
    }

    public static int getPhone(Context context){
        //通话音量
        AudioManager mAudioManager = getSystemService(context);
        //通话最大音量
        int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_VOICE_CALL );
        //当前通话音量
        int current = mAudioManager.getStreamVolume( AudioManager.STREAM_VOICE_CALL );
        Log.e(TAG, "getPhone: "+max+"|||"+current );
       return current;
    }
    public static int getSystem(Context context){
        AudioManager mAudioManager = getSystemService(context);
        //系统音量
        int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_SYSTEM );
        int current = mAudioManager.getStreamVolume( AudioManager.STREAM_SYSTEM );
        Log.e(TAG, "getPhone: "+max+"|||"+current );
        return current;
    }

    public static int getLingSeng(Context context){
        AudioManager mAudioManager = getSystemService(context);
        //铃声音量
        int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_RING );
        int current = mAudioManager.getStreamVolume( AudioManager.STREAM_RING );
        Log.e(TAG, "getPhone: "+max+"|||"+current );
        return current;
    }

    public static int getMedia(Context context){
        AudioManager mAudioManager = getSystemService(context);
        //音乐音量
        int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_MUSIC );
        int current = mAudioManager.getStreamVolume( AudioManager.STREAM_MUSIC );
        Log.e(TAG, "getPhone: "+max+"|||"+current );
        return current;
    }
    public static int getHint(Context context){
        AudioManager mAudioManager = getSystemService(context);
        //提示声音音量
        int max = mAudioManager.getStreamMaxVolume( AudioManager.STREAM_ALARM );
        int current = mAudioManager.getStreamVolume( AudioManager.STREAM_ALARM );
        Log.e(TAG, "getPhone: "+max+"|||"+current );
        return current;
    }

}
