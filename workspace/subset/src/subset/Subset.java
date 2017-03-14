package subset;

import java.util.ArrayList;

public class Subset {

	static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> set, int index) {
		ArrayList<ArrayList<Integer>> allsubsets;
		
		if ( set.size() == index ) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // empty subsets
		} else {
			allsubsets = subsets(set, index+1);
			ArrayList<ArrayList<Integer>> tempArray = new ArrayList<ArrayList<Integer>>();
			for ( ArrayList<Integer> subset : allsubsets ) {
				ArrayList<Integer> newArray = new ArrayList<Integer>();
				newArray.addAll(subset);
				newArray.add(set.get(index));
				tempArray.add(newArray);
			}
			allsubsets.addAll(tempArray);
		}
		return allsubsets;
		
	}
	
	public static void main (String args[]) {
		ArrayList<Integer> myArr = new ArrayList();
		myArr.add(4);
		myArr.add(8);
		myArr.add(7);
		myArr.add(18);
		ArrayList<ArrayList<Integer>> test = subsets(myArr, 0);
		for ( ArrayList<Integer> sub : test ) {
			System.out.println(sub);
		}
		
	}
}
