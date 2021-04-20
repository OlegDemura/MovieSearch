package ru.olegd.moviesearch

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import ru.olegd.moviesearch.model.Film

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        intent.getParcelableExtra<Film>("DATA")?.let {
            findViewById<TextView>(R.id.title).text = it.title
            findViewById<TextView>(R.id.description).text = it.description
            findViewById<ImageView>(R.id.imageView).setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    it.image
                )
            )
        }

    }
}