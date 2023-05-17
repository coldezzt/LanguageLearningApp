package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.viewpager2.widget.ViewPager2
import com.zhpan.indicator.IndicatorView
import com.zhpan.indicator.enums.IndicatorSlideMode
import com.zhpan.indicator.enums.IndicatorStyle

class IntroductionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

        var data = listOf(
            PageData(
                image = R.drawable.introduction_first_image,
                title = getString(R.string.introduction_first_title),
                subtitle = getString(R.string.introduction_first_subtitle)
            ),
            PageData(
                image = R.drawable.introduction_second_image,
                title = getString(R.string.introduction_second_title),
                subtitle = getString(R.string.introduction_second_subtitle)
            ),
            PageData(
                image = R.drawable.introduction_third_image,
                title = getString(R.string.introduction_third_title),
                subtitle = getString(R.string.introduction_third_subtitle)
            )
        )

        val adapter = ViewPagerAdapter(data)
        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        viewPager.adapter = adapter

        val indicatorView = findViewById<IndicatorView>(R.id.indicatorView)
        indicatorView.apply {
            setSliderColor(R.color.indicator_active_page, R.color.indicator_inactive_page)
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
                var btn = findViewById<Button>(R.id.button_next)
                if (position == 0 || position == 1) {
                    btn.setText(R.string.next)
                } else {
                    btn.setText(R.string.start)
                }
            }
        })

        var btn = findViewById<Button>(R.id.button_next)
        btn.setOnClickListener(View.OnClickListener {
            var pos = viewPager.currentItem
            if (pos == 0 || pos == 1) {
                viewPager.setCurrentItem(++pos)
            } else {
                setContentView(R.layout.activity_sign_up)
            }
        })
    }
}