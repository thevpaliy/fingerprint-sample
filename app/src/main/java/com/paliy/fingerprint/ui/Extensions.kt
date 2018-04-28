package com.paliy.fingerprint.ui

import android.view.View

fun View.show(): View {
  visibility = View.VISIBLE
  return this
}

fun View.hide(isGone: Boolean = true): View {
  visibility = if (isGone) View.GONE else View.INVISIBLE
  return this
}