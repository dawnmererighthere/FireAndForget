package com.alorma.fireandforget

abstract class FireAndForget(
  val fireAndForgetRunner: FireAndForgetRunner,
  val name: String,
) {
  fun isEnabled() = fireAndForgetRunner.isEnabled(this)
  fun reset() = fireAndForgetRunner.reset(this)
}