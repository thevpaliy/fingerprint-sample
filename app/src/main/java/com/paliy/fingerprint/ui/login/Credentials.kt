package com.paliy.fingerprint.ui.login

data class Credentials(
    val email: String?,
    val password: String?
) {
  val isValid: Boolean
    get() = !(email.isNullOrEmpty() || password.isNullOrEmpty())
}
