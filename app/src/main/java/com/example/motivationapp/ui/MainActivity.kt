package com.example.motivationapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivationapp.infrastructure.MotivationConstants
import com.example.motivationapp.R
import com.example.motivationapp.data.Mock
import com.example.motivationapp.infrastructure.SecurityPreferences
import com.example.motivationapp.databinding.ActivityMainBinding
import java.util.Locale
import kotlin.random.Random

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var category: Int = MotivationConstants.FILTER.INCLUSIVE_ALL
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        setListeners()
        verifyUserName()
        handleFilter(R.id.image_inclusive_all)
    }

    override fun onClick(v: View) {
        if (v.id == R.id.button_new_phrase) {
            newPhrase()
        } else if (v.id in listOf(R.id.image_inclusive_all, R.id.image_emoji, R.id.image_sunny)) {
            handleFilter(v.id)
        } else if (v.id == R.id.image_edit_user_name) {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        handleUserName()
    }

    private fun verifyUserName() {
        if (SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME) == "") {
            startActivity(Intent(this, UserActivity::class.java))
        }
    }

    private fun setListeners() {
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageInclusiveAll.setOnClickListener(this)
        binding.imageEmoji.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
        binding.imageEditUserName.setOnClickListener(this)
    }

    private fun handleFilter(id: Int) {
        binding.imageInclusiveAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))

        when (id) {
            R.id.image_inclusive_all -> {
                binding.imageInclusiveAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = MotivationConstants.FILTER.INCLUSIVE_ALL
            }
            R.id.image_emoji -> {
                binding.imageEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = MotivationConstants.FILTER.EMOJI
            }
            R.id.image_sunny -> {
                binding.imageSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                category = MotivationConstants.FILTER.SUNNY
            }
        }
    }

    private fun handleUserName() {
        val name = SecurityPreferences(this).getString(MotivationConstants.KEY.USER_NAME)
        val hello = getString(R.string.hello, name)
        binding.textUserName.text = hello
    }

    private fun newPhrase() {
        binding.textPhrase.text = Mock().getPhrase(category, Locale.getDefault().language)
    }
}