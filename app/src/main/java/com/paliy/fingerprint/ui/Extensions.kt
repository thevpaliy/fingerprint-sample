package com.paliy.fingerprint.ui

import android.view.View
import android.view.ViewGroup

fun View.show(): View {
  visibility = View.VISIBLE
  return this
}


public val ViewGroup.views: List<View>
  get() = (0 until childCount).map { getChildAt(it) }

fun View.hide(isGone: Boolean = true): View {
  visibility = if (isGone) View.GONE else View.INVISIBLE
  return this
}