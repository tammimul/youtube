package com.example.youtube

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerView

class MainActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "ljCCaNi-Hfs&list=RDljCCaNi-Hfs&start_radio=1"
    val YOUTUBE_API_Key = "WL3Jm7_88Tk"


    private lateinit var youTubePlayer: YouTubePlayerView
    private lateinit var btnplay: Button

    lateinit var youtubePlayerInInit: YouTubePlayer.OnInitializedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        youTubePlayer = findViewById(R.id.youtubePlayer)

        btnplay = findViewById(R.id.btnplay)

        youtubePlayerInInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                p0: YouTubePlayer.Provider?,
                p1: YouTubePlayer?,
                p2: Boolean
            ) {
                p1?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(
                p0: YouTubePlayer.Provider?,
                p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
        btnplay.setOnClickListener {
            youTubePlayer.initialize(YOUTUBE_API_Key,youtubePlayerInInit)
        }
        }
    }
