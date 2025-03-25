package edu.temple.threadapp

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    val countdownTextView: TextView by lazy { findViewById(R.id.countdownTextView) }

    val countdownHandler = Handler(Looper.getMainLooper()){
        countdownTextView.text = it.what.toString()

        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread{
            repeat(100) {
                val countdown = (100 - it)
                Log.d("Countdown: ", countdown.toString())
                countdownHandler.sendEmptyMessage(countdown)
                Thread.sleep(1000)
            }
        }.start()



    }
}