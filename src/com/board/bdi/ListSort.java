package com.board.bdi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

interface TestInter {
	void test();
}

//class HumanComparator implements Comparator<Human> {
//
//	@Override
//	public int compare(Human o1, Human o2) {
//		int fAge = o1.getAge();
//		int lAge = o2.getAge();
//		if(fAge<lAge) {
//			return -1;
//		}
//		if(lAge<fAge) {
//			return 1;
//		}
//		return 0;
//	}
//	
//}

public class ListSort {
	public static void main(String[] args) {
		List<TestInter> tiList = new ArrayList<>();
		tiList.add(new TestInter() {
			public void test() {
				System.out.println("a");
			}
		});
		
	}
}
