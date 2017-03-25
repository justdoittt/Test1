package com.gy;

import java.util.List;

public class SwitchUtils {

	public static <T> void exchange(List<T> src, int i, int j) {
		T t1 = null;
		T t2 = null;
		t1 = src.get(i);
		t2 = src.get(j);
		src.set(i, t2);
		src.set(j, t1);

	}

}
