package com.board.bdi;

import java.util.ArrayList;
import java.util.List;

class TestClass extends AbsClass {
	
	public void test() {
		
	}
}

public abstract class AbsClass {
	public static void main(String[] args) {
		AbsClass ac = new TestClass();
		List<AbsClass> acList = new ArrayList<>();
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
		acList.add(new TestClass());
	}
}

