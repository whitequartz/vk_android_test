package com.sirius.test_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.*
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.nex3z.flowlayout.FlowLayout

class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor", "InflateParams")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataModel = DataModel()

        val imageApp = findViewById<ImageView>(R.id.imageApp)
        val iconApp = findViewById<ImageView>(R.id.iconApp)
        val nameApp = findViewById<TextView>(R.id.nameApp)
        val ratingAppUpper = findViewById<RatingBar>(R.id.ratingAppUpper)
        val gradeCount = findViewById<TextView>(R.id.gradeCount)
        val tagsList = findViewById<FlowLayout>(R.id.tagsList)
        val descApp = findViewById<TextView>(R.id.descApp)
        val digitRating = findViewById<TextView>(R.id.digitRating)
        val ratingApp = findViewById<RatingBar>(R.id.ratingApp)
        val reviewGradeCount = findViewById<TextView>(R.id.reviewGradeCount)
        val reviewsList = findViewById<LinearLayout>(R.id.reviewsList)
        val button = findViewById<Button>(R.id.button)

        dataModel.apply {
            Glide.with(this@MainActivity)
                .load(image).priority(Priority.HIGH).dontAnimate()
                .into(imageApp)
            Glide.with(this@MainActivity)
                .load(logo).priority(Priority.HIGH).dontAnimate()
                .into(iconApp)
            nameApp.text = name
            ratingAppUpper.rating = rating
            gradeCount.text = gradeCnt

            tagsList.removeAllViews()
            for (tag in tags) {
                LayoutInflater.from(this@MainActivity).inflate(R.layout.layout_tag, null).apply {
                    findViewById<TextView>(R.id.tag).text = tag
                    tagsList.addView(this)
                }
            }

            descApp.text = description
            digitRating.text = rating.toString()
            ratingApp.rating = rating
            reviewGradeCount.text = "$gradeCnt Reviews"

            reviewsList.removeAllViews()
            for (review in reviews) {
                LayoutInflater.from(this@MainActivity).inflate(R.layout.layout_review, null).apply {
                    findViewById<TextView>(R.id.userName).text = review.userName
                    findViewById<TextView>(R.id.date).text = review.date
                    findViewById<TextView>(R.id.message).text = review.message
                    Glide.with(this@MainActivity)
                        .load(review.userImage).priority(Priority.HIGH).dontAnimate()
                        .into(findViewById(R.id.userImage))
                    reviewsList.addView(this)
                }
            }

            button.text = action.name
        }

    }
}