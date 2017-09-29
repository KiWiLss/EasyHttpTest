package com.winding.easyhttptest.ui;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.SeekBar;

import com.winding.easyhttptest.R;
import com.winding.easyhttptest.service.StartService;
import com.winding.easyhttptest.utils.SoundUtils;

/**
 * Created by 刘少帅 on 2017/9/28
 */

public class SoundActivity extends AppCompatActivity {

    private SeekBar sb;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound);
        initView();
        sbListener();

    }

    private void sbListener() {


        AudioManager mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        //实例化
        final AudioManager mgr = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
//                // 调高音量
//                mgr.adjustStreamVolume(AudioManager.STREAM_MUSIC,AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);

//                     mgr.adjustStreamVolume(AudioManager.STREAM_MUSIC,
//                        AudioManager.ADJUST_LOWER,
//                        AudioManager.FLAG_SHOW_UI);//调低声音

                //设置音量的高低
                mgr.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void initView() {
        sb = (SeekBar) findViewById(R.id.sb_sound_control);
    }

    public void openSound(View view) {

        startService(new Intent(SoundActivity.this,StartService.class));

    }

    public void closeSound(View view) {
        stopService(new Intent(SoundActivity.this,StartService.class));
    }

    public void getAllSound(View view) {

       SoundUtils.getPhone(this);
       SoundUtils.getSystem(this);
       SoundUtils.getMedia(this);
       SoundUtils.getLingSeng(this);
       SoundUtils.getHint(this);

    }
}
