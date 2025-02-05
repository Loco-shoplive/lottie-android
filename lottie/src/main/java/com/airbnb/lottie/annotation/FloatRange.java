package com.airbnb.lottie.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.LOCAL_VARIABLE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes that the annotated element should be a float or double in the given range
 * <p>
 * Example:
 * <pre><code>
 *  &#64;FloatRange(from=0.0,to=1.0)
 *  public float getAlpha() {
 *      ...
 *  }
 * </code></pre>
 */
@Documented
@Retention(CLASS)
@Target({METHOD, PARAMETER, FIELD, LOCAL_VARIABLE, ANNOTATION_TYPE})
public @interface FloatRange {
  /**
   * Smallest value. Whether it is inclusive or not is determined
   * by {@link #fromInclusive}
   */
  double from() default Double.NEGATIVE_INFINITY;

  /**
   * Largest value. Whether it is inclusive or not is determined
   * by {@link #toInclusive}
   */
  double to() default Double.POSITIVE_INFINITY;

  /**
   * Whether the from value is included in the range
   */
  boolean fromInclusive() default true;

  /**
   * Whether the to value is included in the range
   */
  boolean toInclusive() default true;
}
