package com.airbnb.lottie;

import com.airbnb.lottie.annotation.NonNull;

/**
 * Class for initializing the library with custom config
 */
public class Lottie {

  private Lottie() {
  }

  /**
   * Initialize Lottie with global configuration.
   *
   * @see LottieConfig.Builder
   */
  public static void initialize(@NonNull final LottieConfig lottieConfig) {
    L.setFetcher(lottieConfig.networkFetcher);
    L.setCacheProvider(lottieConfig.cacheProvider);
    L.setTraceEnabled(lottieConfig.enableSystraceMarkers);
    L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
    L.setNetworkCacheEnabled(lottieConfig.enableNetworkCache);
    L.setDisablePathInterpolatorCache(lottieConfig.disablePathInterpolatorCache);
  }
}
