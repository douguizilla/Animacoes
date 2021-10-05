package com.odougle.animacoes

import android.graphics.Interpolator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.odougle.animacoes.databinding.ActivityViewAnimationsBinding

class ViewAnimationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityViewAnimationsBinding
    private val animations: Array<Animation> by lazy{
        initAnimations()
    }

    private val interpolators: Array<android.view.animation.Interpolator> by lazy {
        initInterpolations()
    }

    private val animationListener = object: Animation.AnimationListener{
        override fun onAnimationStart(animation: Animation?) {

        }

        override fun onAnimationEnd(animation: Animation?) {
            binding.btnPlay.isEnabled = true
            animation?.setAnimationListener(null)
        }

        override fun onAnimationRepeat(animation: Animation?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnPlay.setOnClickListener { executeAnimation() }
    }

    private fun executeAnimation() {
        val interpolator = interpolators[binding.spnInterpolators.selectedItemPosition]
        val animation = animations[binding.spnAnimations.selectedItemPosition]
        animation.interpolator = interpolator
        animation.setAnimationListener(animationListener)
        binding.imgBazinga.startAnimation(animation)
        binding.btnPlay.isEnabled = false

    }

    private fun initInterpolations() : Array<android.view.animation.Interpolator> {
        return arrayOf(
            AccelerateDecelerateInterpolator(),
            BounceInterpolator(),
            FastOutLinearInInterpolator(),
            FastOutSlowInInterpolator(),
            LinearOutSlowInInterpolator(),
            LinearInterpolator(),
            OvershootInterpolator(2.0f)
        )
    }

    private fun initAnimations() : Array<Animation> {
        val animationDuration = 1000L
        val alphaAnim = AlphaAnimation(1f,0f)
        val rotateAnim = RotateAnimation(
            0f,360f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)

        val scaleAnim = ScaleAnimation(
            1f,3f,1f,3f,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f)

        val translateAnim = TranslateAnimation(
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 1f,
            Animation.RELATIVE_TO_SELF, 0f,
            Animation.RELATIVE_TO_SELF, 2f)

        val set = AnimationSet(true)
        set.addAnimation(alphaAnim)
        set.addAnimation(rotateAnim)
        set.addAnimation(scaleAnim)
        set.addAnimation(translateAnim)

        val animations = arrayOf(alphaAnim, rotateAnim, scaleAnim, translateAnim, set)

        for(i in 0..animations.size - 2){
            animations[i].duration = animationDuration
            animations[i].repeatMode = Animation.REVERSE
            animations[i].repeatCount = 1
        }
        return animations
    }
}