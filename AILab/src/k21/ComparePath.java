package k21;

import java.util.Comparator;

public class ComparePath implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		// TODO Auto-generated method stub
		int comparepath = Double.compare(o1.getPathCost(), o2.getPathCost());
		
		return comparepath;
	}

}
