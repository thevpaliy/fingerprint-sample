package com.paliy.fingerprint.ui.fingerprint

sealed class AuthError

class Failed(val message: String) : AuthError()
class Locked: AuthError()