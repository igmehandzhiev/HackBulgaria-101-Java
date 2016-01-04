package p07_statisticsMethods;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyStatistics implements Statistics {

	private List<Integer> myList;
	Integer sum;

	public MyStatistics() {
		myList = new ArrayList<Integer>();
		sum = 0;
	}
	
	public MyStatistics(List<Integer> list) {
		myList = new ArrayList<Integer>(list);
		for(Integer number: myList) {
			sum += number;
		}
	}
	
	public void add(int number) {
		myList.add(number);
		sum += number;
	}

	public double getMean() {
		return sum / myList.size();
	}

	public int getMedian() {
		Collections.sort(myList);
		int middleIndex = (myList.size() + 1) / 2;
		return myList.get(middleIndex);
	}

	public Integer getMode() {

		Map<Integer, Integer> numbersCount = new HashMap<>();
		List<Integer> maxElems = new ArrayList<>();
		int max = 0;

		for (Integer elem : myList) {
			if (numbersCount.containsKey(elem))
				numbersCount.put(elem, numbersCount.get(elem) + 1);
			else
				numbersCount.put(elem, 1);

			if (numbersCount.get(elem) > max) {
				max = numbersCount.get(elem);
				maxElems.clear();
				maxElems.add(elem);
			} else if (numbersCount.get(elem) == max) {
				maxElems.add(elem);
			}
		}

		if (maxElems.size() > 1) {
			return null;
		} else {
			return maxElems.get(0);
		}
	}

	public int getRange() {
		int min = myList.get(0);
		int max = myList.get(0);
		
		
		for (Integer elem : myList) {
			if (elem > max) {
				max = elem;
			}

			if (elem < min) {
				min = elem;
			}
		}
		return max - min;
	}

	public void displayInfo() {
		System.out.println("Mean: " + getMean() + '\n' + "Mode: " + getMode() + '\n' + "Median: " + getMedian() + '\n'
				+ "Range: " + getRange());
	}
}