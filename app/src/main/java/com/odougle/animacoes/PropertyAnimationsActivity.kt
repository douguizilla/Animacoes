package com.odougle.animacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.animacoes.databinding.ActivityPropertyAnimationsBinding

class PropertyAnimationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPropertyAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}