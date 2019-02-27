package com.yaoyong.demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("t");
		hashSet.add("m");
		hashSet.add("d");

		Iterator iterate = hashSet.iterator();
		for (int i = 0, j = hashSet.size(); i < j; i++) {
			sb.append(iterate.next());
			if (i < j - 1) {
				sb.append(",");
			}
		}

		System.out.println(hashSet.toString() + "-------------------------------");

	}
}
