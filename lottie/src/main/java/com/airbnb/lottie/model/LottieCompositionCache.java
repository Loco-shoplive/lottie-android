package com.airbnb.lottie.model;

import com.airbnb.lottie.annotation.Nullable;
import com.airbnb.lottie.annotation.RestrictTo;

import com.airbnb.lottie.LottieComposition;

import java.util.LinkedHashMap;

@RestrictTo(RestrictTo.Scope.LIBRARY)
public class LottieCompositionCache {

  private static final LottieCompositionCache INSTANCE = new LottieCompositionCache();

  public static LottieCompositionCache getInstance() {
    return INSTANCE;
  }

  private LinkedHashMap<String, LottieComposition> cache = new LinkedHashMap<>(20);

  LottieCompositionCache() {
  }

  @Nullable
  public LottieComposition get(@Nullable String cacheKey) {
    if (cacheKey == null) {
      return null;
    }
    return cache.get(cacheKey);
  }

  public void put(@Nullable String cacheKey, LottieComposition composition) {
    if (cacheKey == null) {
      return;
    }
    cache.put(cacheKey, composition);
  }

  public void clear() {
    cache.clear();
  }

  /**
   * Set the maximum number of compositions to keep cached in memory.
   * This must be {@literal >} 0.
   */
  public void resize(int size) {
    cache = new LinkedHashMap<>(size);
  }
}
