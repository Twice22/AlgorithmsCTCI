package cent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Cent {
	
	private ArrayList<Map<Integer, Integer>> sol = new ArrayList<Map<Integer, Integer>>();
	
	void Cents() {}
	
	public ArrayList<Map<Integer, Integer>> getSol() {
		return sol;
	}
	
	public Map<Integer, Integer> cents(int nb) {
		if ( nb > 0 ) {
			Map<Integer, Integer> nMap = new LinkedHashMap();
			nMap.put(1, nb);
			nMap.put(5, 0);
			nMap.put(10, 0);
			nMap.put(25, 0);
			return centsRec(nMap);
		} else {
			return null;
		}
	}
	
	public Map<Integer, Integer> centsRec(Map<Integer, Integer> round) {
		
		Set<Entry<Integer, Integer>> setLhm = round.entrySet();
		Iterator<Entry<Integer, Integer>> it = setLhm.iterator();
		
		while( it.hasNext() ) {
			Entry<Integer, Integer> e = it.next();
			//System.out.println(e.getKey() + " : " + e.getValue());
			switch ( e.getKey() ) {
				case 1:
					if ( e.getValue() >= 5 ) {
						round.put(e.getKey(), e.getValue()-5);
						round.put(5, round.get(5)+1);
						System.out.println("round : " + round);
						sol.add(round);
						centsRec(round);
					}
				break;
				
				case 5:
					if ( e.getValue() >= 2 ) {
						round.put(e.getKey(), e.getValue()-2);
						round.put(10, round.get(10)+1);
						sol.add(round);
						centsRec(round);
					}
					if ( e.getValue() >= 5 ) {
						round.put(e.getKey(), e.getValue()-5);
						round.put(25, round.get(25)+1);
						sol.add(round);
						centsRec(round);
					}
				break;
				
				case 10:
					if ( e.getValue() >= 3 ) {
						round.put(e.getKey(), e.getValue()-3);
						round.put(5, round.get(5)+1);
						round.put(25, round.get(25)+1);
						sol.add(round);
						centsRec(round);
					}
				break;
				
				/*case 25:
					if ( e.getValue() >=1  ) {
						round.put(e.getKey(), e.getValue()-1);
						round.put(10, round.get(10)+2);
						round.put(5, round.get(5)+1);
						centsRec(round, allSol);
					}
				break;*/
					
			}
		}
		
		return round;
	}

	public static void main(String args[]) {
		int nb = 17;
		Cent lCt =  new Cent();
		lCt.cents(nb);
		ArrayList<Map<Integer, Integer>> mySol = lCt.getSol();
		int i = 0;
		for ( Map<Integer, Integer> arr : mySol ) {
			System.out.println((++i) + " : " + arr);
		}
	}
}
