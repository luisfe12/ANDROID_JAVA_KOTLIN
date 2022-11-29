package com.example.reproductoraudio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    //cremos las variables para sounpoll
    Button play;
    SoundPool sp;
    int ubicacion_sonido;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //hacemos la conexion logica y grafica
        play = (Button)findViewById(R.id.button_play);

        //damso los valores al obejto sounpool
        /*
        Valore del SOundPoolmaximo de reproduciones simultaneas
        * Tipo de stream music
        * La calidad de reproduccion
        * */
        sp = new SoundPool(1, AudioManager.STREAM_MUSIC, 1);

        //carmanos la ubicacion del archivo de sonido
        ubicacion_sonido = sp.load(this, R.raw.sound_short, 1);
    }

    public void AudioSoundPool(View vista){
        //ahora reproduciomos el audio
        /*
        * primer parameytro ubicacion del archivo
        * los otros 2 es par amodular sonido tanto izquiereda y derecha
        * el tercero es prioridad
        * ponermo nuemro de repticiones -1 se reproduce por siemrpe, 0 se reproduce una vez 1 hay pasa en en su repetecion infinita
        * el ultimo parametro es la velocidad de reproduccion*/
        sp.play(ubicacion_sonido,1,1, 0, 0, 0);
    }


    //metodo reproducir mediplayer
    public void AudioMediaPlayer(View vista){
        //screamos la clase mediaplayer. sus paremtros son contexto y la ubicacion dela rchivo
        MediaPlayer mp = MediaPlayer.create(this, R.raw.sound_long);
        mp.start();
    }
}