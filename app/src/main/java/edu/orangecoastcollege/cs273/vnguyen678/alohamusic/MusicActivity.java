package edu.orangecoastcollege.cs273.vnguyen678.alohamusic;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MusicActivity extends AppCompatActivity {

    private MediaPlayer ukueleMP;
    private MediaPlayer ipuMp;

    private Button ukuleleButon;
    private Button ipuButon;
    private Button hulaButon;
    private VideoView hulaVideoView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        ukuleleButon = (Button) findViewById(R.id.ukuleleButton);
        ipuButon = (Button) findViewById(R.id.ipuButton);
        hulaButon = (Button) findViewById(R.id.hulaButton);

        hulaVideoView = (VideoView) findViewById(R.id.hulaVideoView);
        hulaVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.hula));
        hulaVideoView.setMediaController(new MediaController(this));

        // Associate the media player object with the raw file
        ukueleMP = MediaPlayer.create(this, R.raw.ukulele);
        ipuMp = MediaPlayer.create(this, R.raw.ipu);
        // Assoicate the media player object with the hula video

    }

    public void playMedia(View view)
    {
        //how to Determine which button is clicked:
        switch (view.getId())
        {
            case R.id.ukuleleButton:
                if(ukueleMP.isPlaying())
                {
                    ukueleMP.pause();
                    ukuleleButon.setText(R.string.ukulele_button_play_text);
                    //show the othet two button
                    ipuButon.setVisibility(View.VISIBLE);
                    hulaButon.setVisibility(View.VISIBLE);
                }
                else
                {
                    ukueleMP.start();
                    ukuleleButon.setText(R.string.ukulele_button_pause_text);
                    ipuButon.setVisibility(View.INVISIBLE);
                    hulaButon.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.ipuButton:
                if(ipuMp.isPlaying())
                {
                    ipuMp.pause();
                    ipuButon.setText(R.string.ipu_button_play_text);
                    //show the othet two button
                    ukuleleButon.setVisibility(View.VISIBLE);
                    hulaButon.setVisibility(View.VISIBLE);
                }
                else
                {
                    ipuMp.start();
                    ipuButon.setText(R.string.ipu_button_pause_text);
                    ukuleleButon.setVisibility(View.INVISIBLE);
                    hulaButon.setVisibility(View.INVISIBLE);
                }

                break;
            case R.id.hulaButton:
                if(hulaVideoView.isPlaying())
                {
                    hulaVideoView.pause();
                    hulaButon.setText(R.string.hula_button_watch_text);
                    ukuleleButon.setVisibility(View.VISIBLE);
                    ipuButon.setVisibility(View.VISIBLE);
                }
                else
                {
                    hulaVideoView.start();
                    hulaButon.setText(R.string.hula_button_pause_text);
                    ukuleleButon.setVisibility(View.INVISIBLE);
                    ipuButon.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }

}
