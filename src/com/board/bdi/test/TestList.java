package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collections;

public class TestList {
	public static void main(String[] args) {

		ArrayList<Integer> intList = new ArrayList<Integer>();
		intList.add(10);
		intList.add(5);
		intList.add(1);
		intList.add(9);
		intList.add(2);

		for (int i = 0; i < intList.size(); i++) { // (== Collections.sort(intList);)
			for (int j = i + 1; j < intList.size(); j++) {
				if (intList.get(i) > intList.get(j)) {
					int tmp = intList.get(i);
					intList.set(i, intList.get(j));
					intList.set(j, tmp);
				}
			}
		}
		
		System.out.println(intList);
	}
}
