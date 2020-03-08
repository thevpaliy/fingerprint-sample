package com.paliy.fingerprint.ui.auth

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.paliy.fingerprint.ui.FlipTransformer
import com.paliy.fingerprint.ui.auth.login.LoginFragment
import com.paliy.fingerprint.ui.auth.register.RegisterFragment

class AuthAdapter(manager: FragmentManager?, private val pager: AnimatedViewPager) : FragmentStatePagerAdapter(manager), AuthFragment.Callback {
  private var signUp: AuthFragment? = null
  private var login: AuthFragment? = null
  private val transformer: FlipTransformer by lazy { FlipTransformer(160) }

  override fun getItem(position: Int): AuthFragment? {
    if (position == 0) {
      if (login == null) {
        login = LoginFragment()
      }
      login?.callback = this
      return login
    } else if (signUp == null) {
      signUp = RegisterFragment()
    }
    signUp?.callback = this
    return signUp
  }

  override fun remove(fragment: AuthFragment?) {
    if (login === fragment) {
      transformer.setMovingForward(true)
      pager.setCurrentItem(1, true)
      signUp?.fireAnimation()
    } else {
      transformer.setMovingForward(false)
      pager.setCurrentItem(0, true)
      login?.fireAnimation()
    }
  }

  override fun getCount(): Int {
    return 2
  }

  init {
    pager.setDuration(200)
    pager.setPageTransformer(true, transformer)
  }
}