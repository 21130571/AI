package k21;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class UCSGraph implements ISearchAlgo {

//	@Override
//	public Node execute(Node root, String goal) {
//		// TODO Auto-generated method stub
//		PriorityQueue<Node> frontier = new PriorityQueue((int) root.getPathCost());
//		frontier.add(root);
//		List<Node> explorer = new ArrayList<>();
//		
//		
//		while(!frontier.isEmpty()) {
//			Node current = frontier.poll();
//			if (current.getLabel().equals(goal)) {
//				return current;
//			}
//			else {
//				explorer.add(current);
//				List<Edge> children = current.getChildren();
//				for (Edge child : children) {
//					Node end = child.getEnd();
//					if (!frontier.contains(end)&& !explorer.contains(end)) {
//						//set path cost moi và parent moi
//						
//						
//						frontier.add(end);
//						explorer.add(end);
//						
//						}
//else {
//						double newPathcost = current.getPathCost() + child.getWeight();
//						if (end.getPathCost() > ) {
//							
//						}
//					}
//						
//			
//		}
//		}
//		}
//		return null;
//	
//	}
	@Override
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		PriorityQueue<Node> frontier = new PriorityQueue(new ComparePath());
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
					double newPathCost = current.getPathCost() + child.getWeight();
					if (!frontier.contains(end) && !explorer.contains(end)) {
						end.setParent(current);
						end.setPathCost(newPathCost);
						frontier.add(end);
						explorer.add(end);
						
						
					} else 
						
						if (end.getPathCost() > newPathCost) {
							end.setParent(current);
							end.setPathCost(newPathCost);

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

	

}
