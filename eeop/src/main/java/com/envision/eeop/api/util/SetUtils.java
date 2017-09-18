package com.envision.eeop.api.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Set Utility
 */
public class SetUtils {

	  /**
	   * Ensures that an object reference passed as a parameter to the calling method is not null.
	   *
	   * @param reference an object reference
	   * @param errorMessage the exception message to use if the check fails
	   * @return the non-null reference that was validated
	   * @throws NullPointerException if {@code reference} is null
	   */
	  protected static <T> T checkNotNull(T reference, String errorMessage) {
	      if (reference == null) {
	    	  throw new NullPointerException(errorMessage);
	      }
	      return reference;
	  }
  
	  /**
	   * Returns a list of the difference of two sets. The
	   * returned set contains all elements that are contained by {@code set1} and
	   * not contained by {@code set2}. {@code set2} may also contain elements not
	   * present in {@code set1}; these are simply ignored. The iteration order of
	   * the returned set matches that of {@code set1}.
	   */
	  public static <E> List<E> difference(final Collection<? extends E> set1, final Collection<? extends E> set2) {
		    checkNotNull(set1, "set1");
		    checkNotNull(set2, "set2");
		    
		    Set<E> _set1 = new HashSet<E>(set1);
		    Set<E> _set2 = new HashSet<E>(set2);

		    List<E> result = new ArrayList<E>();
		    for (E e: _set1) {
		         if (!_set2.contains(e)) {
		              result.add(e);
		         }
		    }
		    return result;
	  }
	  
	  /**
	   * Returns a list of the union of two sets. The returned
	   * set contains all elements that are contained in either backing set.
	   * Iterating over the returned set iterates first over all the elements of
	   * {@code set1}, then over each element of {@code set2}, in order, that is not
	   * contained in {@code set1}.
	   *
	   * <p><b>Note:</b> The returned view performs better when {@code set1} is the
	   * smaller of the two sets. If you have reason to believe one of your sets
	   * will generally be smaller than the other, pass it first.
	   */
	  public static <E> List<E> union(final Collection<? extends E> set1, final Collection<? extends E> set2) {
		    checkNotNull(set1, "set1");
		    checkNotNull(set2, "set2");

		    List<E> set2minus1 = difference(set2, set1);
		    List<E> result = new ArrayList<E>(new HashSet<E>(set1));
		    result.addAll(set2minus1);
		    return result;
	  }
}
