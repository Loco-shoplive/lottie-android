package com.airbnb.lottie.annotation;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes that any overriding methods should invoke this method as well.
 * <p>
 * Example:
 * <pre><code>
 *  &#64;CallSuper
 *  public abstract void onFocusLost();
 * </code></pre>
 */
@Documented
@Retention(CLASS)
@Target({METHOD})
public @interface CallSuper {
}
