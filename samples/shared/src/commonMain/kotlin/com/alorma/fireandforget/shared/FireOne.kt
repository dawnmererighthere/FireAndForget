package com.alorma.fireandforget.shared

import com.alorma.fireandforget.FireAndForget
import com.alorma.fireandforget.FireAndForgetRunner

class FireOne(
  fireAndForgetRunner: FireAndForgetRunner,
) : FireAndForget(
  fireAndForgetRunner = fireAndForgetRunner,
  name = "fire_one",
)