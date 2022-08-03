package Model;

import java.util.ArrayList;

public class MySet<T extends Comparable<T>> {
	public ArrayList<T> arr = new ArrayList<>();

	public MySet() {
		// TODO Auto-generated constructor stub
	}

	public void add(T instance) throws IllegalArgumentException {
		if (arr.size() == 0) {
			arr.add(instance);
		} else {
			boolean existsInArray = false;
			for (T t : arr) {
				if (t.compareTo(instance) == 0) {
					existsInArray = true;
					if (existsInArray) {
						throw new IllegalArgumentException("This Citizen is already in the array!");
//						System.out.println("This Citizen is already in the array!");
//						return;
					}
				}

			}
			arr.add(instance);
		}
	}

}
