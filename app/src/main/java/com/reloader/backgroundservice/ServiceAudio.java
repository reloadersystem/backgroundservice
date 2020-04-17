package com.reloader.backgroundservice;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ServiceAudio extends Service {

    private Context thisContext=this;

    private MediaPlayer mediaPlayer;

    @Override
    public void onCreate() {


    }

    public int onStartCommand(Intent intent, int flag, int idProcess) {

        // lo hace  en el hilo principal
        // alternativa usar handler
        mediaPlayer = MediaPlayer.create(thisContext, R.raw.musica);
        mediaPlayer.start();

        return START_STICKY;
    }


    @Override
    public void onDestroy(){
        mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
