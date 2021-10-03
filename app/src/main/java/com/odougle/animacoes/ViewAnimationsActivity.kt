package com.odougle.animacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.odougle.animacoes.databinding.ActivityViewAnimationsBinding

class ViewAnimationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewAnimationsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}