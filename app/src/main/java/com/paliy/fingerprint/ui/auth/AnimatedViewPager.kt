package com.paliy.fingerprint.ui.auth

import android.annotation.SuppressLint
import android.content.Context
import android.support.v4.view.ViewPager
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.animation.DecelerateInterpolator
import android.view.animation.Interpolator
import android.widget.Scroller

class AnimatedViewPager : ViewPager {
  private var duration = 0

  constructor(context: Context?) : super(context!!) {
    postInitViewPager()
  }

  constructor(context: Context?, attrs: AttributeSet?) : super(context!!, attrs) {
    postInitViewPager()
  }

  private var mScroller: ScrollerCustomDuration? = null
  private fun postInitViewPager() {
    try {
      val scroller = ViewPager::class.java.getDeclaredField("mScroller")
      scroller.isAccessible = true
      mScroller = ScrollerCustomDuration(context,
          DecelerateInterpolator())
      scroller[this] = mScroller
    } catch (e: Exception) {
    }
  }

  @SuppressLint("ClickableViewAccessibility")
  override fun onTouchEvent(ev: MotionEvent) = false

  fun setDuration(duration: Int) {
    this.duration = duration
  }

  inner class ScrollerCustomDuration internal constructor(context: Context?, interpolator: Interpolator?) : Scroller(context, interpolator) {

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int, duration: Int) {
      super.startScroll(startX, startY, dx, dy, this@AnimatedViewPager.duration)
    }

    override fun startScroll(startX: Int, startY: Int, dx: Int, dy: Int) {
      super.startScroll(startX, startY, dx, dy, duration)
    }
  }
}