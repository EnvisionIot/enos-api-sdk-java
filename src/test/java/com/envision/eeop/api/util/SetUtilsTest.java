package com.envision.eeop.api.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SetUtilsTest {
	
	private static final List<String> set1 = Arrays.asList("A", "B", "B", "C");
	private static final List<String> set2 = Arrays.asList("D", "B", "D", "B");
	private static final List<String> set1minus2 = Arrays.asList("A", "C");
	private static final List<String> set1add2 = Arrays.asList("A", "B", "C", "D");
	
	@Test
	public void test() {
		assertEquals(set1minus2, SetUtils.difference(set1, set2));
		assertEquals(set1add2, SetUtils.union(set1, set2));
	}
}
