package com.example.proyprimercorte;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.media.AudioManager;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageButton btnPanico;
    MediaPlayer mp;
    TextView lblPregunta;
    EditText txtRespuestaUsr;
    String pregunta = "Como se llama mi perro?";
    String RespuestaCorrecta = "Ringo";
    String RespuestaUsr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout layout = this.findViewById(R.id.layPrincipal);
        layout.setBackgroundColor(Color.GRAY);
        reproducirAlarma();
        detenerAlarma();
        configuracion();
    }
    public void reproducirAlarma() {
        mp = MediaPlayer.create(MainActivity.this, R.raw.alarm);
        AudioManager audioManager;
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setRingerMode(AudioManager.RINGER_MODE_NORMAL);
        mp.setLooping(true);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
        mp.start();
    }
    public void configuracion(){
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                |View.SYSTEM_UI_FLAG_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }
    public void detenerAlarma(){
       btnPanico = this.findViewById(R.id.imgbtnPanico);
       lblPregunta = findViewById(R.id.lblPregunta);
       lblPregunta.setText(pregunta);
       btnPanico.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               txtRespuestaUsr = findViewById(R.id.txtRespuestaUsr);
               System.out.println(txtRespuestaUsr.getText());
               if (RespuestaCorrecta.compareTo(txtRespuestaUsr.getText().toString())==0){
                   mp.stop();
                   System.out.println("jasjkdhajd");
               }else {
                   Toast.makeText(MainActivity.this, "Respuesta Incorrecta", Toast.LENGTH_SHORT);
               }
           }
       });
    }
}
