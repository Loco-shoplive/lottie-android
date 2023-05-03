package com.airbnb.lottie;

import com.airbnb.lottie.annotation.Nullable;

/**
 * @see LottieCompositionFactory
 * @see LottieResult
 */
@Deprecated
public interface OnCompositionLoadedListener {
  /**
   * Composition will be null if there was an error loading it. Check logcat for more details.
   */
  void onCompositionLoaded(@Nullable LottieComposition composition);
}
