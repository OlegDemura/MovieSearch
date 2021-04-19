package ru.olegd.moviesearch

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import ru.olegd.moviesearch.data.Data
import ru.olegd.moviesearch.model.Film

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TITLE1 = "TITLE1"
        private const val TITLE2 = "TITLE2"
        private const val TITLE3 = "TITLE3"
    }

    private val data = Data()

    private val title1 by lazy { findViewById<TextView>(R.id.title1) }
    private val title2 by lazy { findViewById<TextView>(R.id.title2) }
    private val title3 by lazy { findViewById<TextView>(R.id.title3) }
    private val description1 by lazy { findViewById<TextView>(R.id.description1) }
    private val description2 by lazy { findViewById<TextView>(R.id.description2) }
    private val description3 by lazy { findViewById<TextView>(R.id.description3) }
    private val image1 by lazy { findViewById<ImageView>(R.id.image1) }
    private val image2 by lazy { findViewById<ImageView>(R.id.image2) }
    private val image3 by lazy { findViewById<ImageView>(R.id.image3) }
    private val button1 by lazy { findViewById<Button>(R.id.detailsButton1) }
    private val button2 by lazy { findViewById<Button>(R.id.detailsButton2) }
    private val button3 by lazy { findViewById<Button>(R.id.detailsButton3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title1.text = data.list[0].title
        title2.text = data.list[1].title
        title3.text = data.list[2].title

        savedInstanceState?.let {
            title1.setTextColor(it.getInt(TITLE1))
            title2.setTextColor(it.getInt(TITLE2))
            title3.setTextColor(it.getInt(TITLE3))
        }

        description1.text = data.list[0].description
        description2.text = data.list[1].description
        description3.text = data.list[2].description

        image1.setImageDrawable(ContextCompat.getDrawable(this, data.list[0].image))
        image2.setImageDrawable(ContextCompat.getDrawable(this, data.list[1].image))
        image3.setImageDrawable(ContextCompat.getDrawable(this, data.list[2].image))

        button1.setOnClickListener {
            title1.setTextColor(Color.GREEN)
            val film = Film(data.list[0].title, data.list[0].description, data.list[0].image)
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("DATA", film)
            startActivity(intent)
        }
        button2.setOnClickListener {
            title2.setTextColor(Color.GREEN)
            val film = Film(data.list[1].title, data.list[1].description, data.list[1].image)
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("DATA", film)
            startActivity(intent)
        }
        button3.setOnClickListener {
            title3.setTextColor(Color.GREEN)
            val film = Film(data.list[2].title, data.list[2].description, data.list[2].image)
            val intent = Intent(this, DetailsActivity::class.java)
            intent.putExtra("DATA", film)
            startActivity(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("TITLE1", title1.textColors.defaultColor)
        outState.putInt("TITLE2", title2.textColors.defaultColor)
        outState.putInt("TITLE3", title3.textColors.defaultColor)
    }

    fun sendToMessage(view: View) {
        startActivity(Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", "", null)))
    }

}