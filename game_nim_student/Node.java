package game_nim_student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
		List<Node> re = new ArrayList<>();
		for (int i = 0; i < data.size(); i++) {
			int current = data.get(i);
			for (int j = 1; j < current/2; j++) {
				if(current-j != current/2) {
					Node m = new Node();
					m.add(j);
					m.add(current-j);
					for (int k = 0;  k< data.size(); k++) {
						if (k!=i) {
							m.add(data.get(k));
							
						}
						
					
				}
				
				}
					
			}
		}
		return re;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
//	for (Integer i : data) {
//		if(i % 2 != 0) return true;
//		
		Collections.sort(data, DESCOMPARATOR);
		if (this.data.get(0) > 2) {
			return true;
		} else {
			return false;
		}

	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
