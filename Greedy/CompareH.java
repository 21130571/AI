package Greedy;

import java.util.Comparator;



public class CompareH implements Comparator<Node> {

	

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
int comparepath = Double.compare(o1.getH(), o2.getH());
		
		return comparepath;
		
	}
		
	}


