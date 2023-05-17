package com.example.djdj

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.zhpan.indicator.IndicatorView
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pageData = listOf(
            PageData(
                image = R.drawable.ic_launcher_foreground,
                title = "Title 1",
                text = "Text 1"
            ),
            PageData(
                image = R.drawable.ic_launcher_foreground,
                title = "Title 2",
                text = "Text 2"
            )
        )

        val adapter = ViewPagerAdapter(pageData)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter


        val indicatorView = findViewById<IndicatorView>(R.id.indicatorView)
        indicatorView.apply {
            setSliderColor(Color.BLUE, Color.BLACK)
            setSliderWidth(
                resources.getDimension(R.dimen.default_6dp),
                resources.getDimension(R.dimen.default_16dp)
            )
            setSliderHeight(resources.getDimension(R.dimen.default_6dp))
            setSlideMode(IndicatorSlideMode.SCALE)
            setIndicatorStyle(IndicatorStyle.ROUND_RECT)
            setPageSize(viewPager.adapter!!.itemCount)
            notifyDataChanged()
        }


        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                indicatorView.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                indicatorView.onPageSelected(position)

                when(position) {
                    1 -> {
                        findViewById<Button>(R.id.button).text = "Herlkejf"
                    }
                }
            }
        })
    }
}