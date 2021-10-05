package com.odougle.animacoes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.*
import androidx.interpolator.view.animation.FastOutLinearInInterpolator
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator
import com.odougle.animacoes.databinding.ActivityPropertyAnimationsBinding

class PropertyAnimationsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityPropertyAnimationsBinding

    private var listInterpolators = arrayOf(
        AccelerateDecelerateInterpolator(),
        AnticipateOvershootInterpolator(2.0f, 1.5f),
        BounceInterpolator(),
        CycleInterpolator(2f),
        DecelerateInterpolator(1.0f),
        FastOutLinearInInterpolator(),
        LinearOutSlowInInterpolator(),
        LinearInterpolator(),
        OvershootInterpolator(2.0f)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPropertyAnimationsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.imgBazinga.setOnClickListener {
            executeAnimator()
        }
    }

    private fun executeAnimator() {
       val animationIndex = binding.spnAnimators.selectedItemPosition
        val interpolator = listInterpolators[binding.spnInterpolators.selectedItemPosition]
        executeViewPropertyAnimation(animationIndex, interpolator)
    }

    private fun executeViewPropertyAnimation(animationIndex: Int, interpolator: Interpolator) {
        when(animationIndex){
            0 -> binding.imgBazinga.animate()
                .alpha(0f)
                .setDuration(ANIMATION_DURATION)
                .setInterpolator(interpolator)
                .withEndAction{
                    binding.imgBazinga.animate()
                        .alpha(1f)
                        .setDuration(ANIMATION_DURATION)
                        .start()
                }
            1 -> binding.imgBazinga.animate()
                .rotation(360f)
                .setDuration(ANIMATION_DURATION)
                .withEndAction{
                    binding.imgBazinga.animate()
                        .rotation(0f)
                        .setDuration(ANIMATION_DURATION)
                        .start()
                }
            2 -> binding.imgBazinga.animate()
                .scaleX(2f)
                .scaleY(2f)
                .setDuration(ANIMATION_DURATION)
                .withEndAction{
                    binding.imgBazinga.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(ANIMATION_DURATION)
                        .start()
                }
            3 -> binding.imgBazinga.animate()
                .translationX(500f)
                .setDuration(ANIMATION_DURATION)
                .withEndAction {
                    binding.imgBazinga.animate()
                        .translationX(0f)
                        .setDuration(ANIMATION_DURATION)
                        .start()
                }

            4 -> binding.imgBazinga.animate()
                .alpha(0f)
                .rotation(360f)
                .scaleX(2f)
                .scaleY(2f)
                .translationX(500f)
                .setDuration(ANIMATION_DURATION)
                .withEndAction {
                    binding.imgBazinga.animate()
                        .alpha(1f)
                        .rotation(0f)
                        .scaleX(1f)
                        .scaleY(1f)
                        .translationX(0f)
                        .setDuration(ANIMATION_DURATION)
                        .start()
                }

        }
    }

    companion object{
        private const val ANIMATION_DURATION = 1000L
    }
}