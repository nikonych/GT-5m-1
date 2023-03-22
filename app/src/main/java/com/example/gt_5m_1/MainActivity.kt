package com.example.gt_5m_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.gt_5m_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CounterView {
    lateinit var binding: ActivityMainBinding
    val presenter = Injector.fillPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        with(binding){
            btnPlus.setOnClickListener {
                presenter.incrementCount()
            }
            btnMinus.setOnClickListener {
                presenter.decrementCount()
            }
        }
    }

    override fun updateText(count: String) {
        binding.tvResult.text = count
    }

    override fun showToast() {
        Toast.makeText(this, "Поздравляем",Toast.LENGTH_SHORT).show()
    }

    override fun changeColor() {
        binding.tvResult.setTextColor(Color.GREEN)
    }

    override fun setDefaultColor() {
        binding.tvResult.setTextColor(Color.BLACK)
    }
}