package com.airbnb.lottie.annotation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PACKAGE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.CLASS;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * Denotes that the annotated element should only be accessed from within a
 * specific scope (as defined by {@link androidx.annotation.RestrictTo.Scope}).
 * <p>
 * Example of restricting usage within a library (based on gradle group ID):
 * <pre><code>
 *   &#64;RestrictTo(GROUP_ID)
 *   public void resetPaddingToInitialValues() { ...
 * </code></pre>
 * Example of restricting usage to tests:
 * <pre><code>
 *   &#64;RestrictScope(TESTS)
 *   public abstract int getUserId();
 * </code></pre>
 * Example of restricting usage to subclasses:
 * <pre><code>
 *   &#64;RestrictScope(SUBCLASSES)
 *   public void onDrawForeground(Canvas canvas) { ...
 * </code></pre>
 */
@Retention(CLASS)
@Target({ANNOTATION_TYPE, TYPE, METHOD, CONSTRUCTOR, FIELD, PACKAGE})
public @interface RestrictTo {

  /**
   * The scope to which usage should be restricted.
   */
  RestrictTo.Scope[] value();

  enum Scope {
    /**
     * Restrict usage to code within the same library (e.g. the same
     * gradle group ID and artifact ID).
     */
    LIBRARY,

    /**
     * Restrict usage to code within the same group of libraries.
     * This corresponds to the gradle group ID.
     */
    LIBRARY_GROUP,

    /**
     * Restrict usage to code within packages whose groups share
     * the same library group prefix up to the last ".", so for
     * example libraries foo.bar:lib1 and foo.baz:lib2 share
     * the prefix "foo." and so they can use each other's
     * apis that are restricted to this scope. Similarly for
     * com.foo.bar:lib1 and com.foo.baz:lib2 where they share
     * "com.foo.". Library com.bar.qux:lib3 however will not
     * be able to use the restricted api because it only
     * shares the prefix "com." and not all the way until the
     * last ".".
     */
    LIBRARY_GROUP_PREFIX,

    /**
     * Restrict usage to code within the same group ID (based on gradle
     * group ID). This is an alias for {@link #LIBRARY_GROUP_PREFIX}.
     *
     * @deprecated Use {@link #LIBRARY_GROUP_PREFIX} instead
     */
    @Deprecated
    GROUP_ID,

    /**
     * Restrict usage to tests.
     */
    TESTS,

    /**
     * Restrict usage to subclasses of the enclosing class.
     * <p>
     * <strong>Note:</strong> This scope should not be used to annotate
     * packages.
     */
    SUBCLASSES,
  }
}
