package com.board.bdi.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

class Human {
	private int age;
	private int height;

	public Human(int age, int height) {
		super();
		this.age = age;
		this.height = height;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Human [age=" + age + ", height=" + height + "]";
	}
}

class Compare<T> implements Comparator<T> {   // K V T E 

	@Override
	public int compare(T o1, T o2) {
		Human h1 = (Human)o1;
		Human h2 = (Human)o2;
		if(h1.getAge()<h2.getAge()) {
			return -1;
		}
		if(h1.getAge()>h2.getAge()) {
			return 1;
		}
		return 0;
	}
	
}
interface Com {
	public int compare(Object o1, Object o2);
}
public class Test {
//	public static void main(String[] args) {
//		int[] nums = new int[5];
//		nums[0] = 10;
//		nums[1] = 5;
//		nums[2] = 1;
//		nums[3] = 9;
//		nums[4] = 2;
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = i + 1; j < nums.length; j++) {
//				if (nums[i] > nums[j]) {
//					int tmp = nums[i];
//					nums[i] = nums[j];
//					nums[j] = tmp;
//				}
//			}
//		}
//		for (int i = 0; i < nums.length; i++) {
//			System.out.println(nums[i]);
//		}
//		
//		
//	}

	public static void main(String[] args) {
		List<Human> hList = new ArrayList<>();
		hList.add(new Human(27, 181));
		hList.add(new Human(27, 166));
		hList.add(new Human(25, 154));
		hList.add(new Human(29, 191));
		hList.add(new Human(19, 151));

		for (int i = 0; i < hList.size(); i++) { // ( == Collections.sort(hList, new Compare<Human>()); )
			for (int j = i + 1; j < hList.size(); j++) {
				if (hList.get(i).getHeight() > hList.get(j).getHeight()) {
					Human tmp = hList.get(i);
					hList.set(i, hList.get(j));
					hList.set(j, tmp);
				}
			}
		}
		for(int i=0; i<hList.size();i++) {
			System.out.println(hList.get(i));
		}

	}
}
