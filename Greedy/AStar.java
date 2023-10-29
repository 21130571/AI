package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStar implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
PriorityQueue<Node> frontier = new PriorityQueue(new CompareH());
		
		frontier.add(root);
		List<Node> explorer = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
			} else {
				explorer.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
				double newPathG = current.getG() + child.getWeight();
					if (!frontier.contains(end) && !explorer.contains(end)) {
						end.setParent(current);
						end.setG(newPathG);
						frontier.add(end);
						explorer.add(end);
						
						
					}
					else if (frontier.contains(end) && end.getG() > newPathG) {
						end.setG(newPathG);
						end.setParent(current);
					}
					}

				}
			}
		
		return null;
		
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean isAdmissibleH(Node root, String goal) {
		
		return false;
		
	}

}
