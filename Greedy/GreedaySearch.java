package Greedy;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;



public class GreedaySearch implements IInformedSearchAlgo {

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
					}

				}
			}
		
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
PriorityQueue<Node> frontier = new PriorityQueue(new CompareH());
		
		frontier.add(root);
		boolean started = false;
		List<Node> explorer = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			
			if (current.getLabel().equals(start)) {
				frontier.clear();
				explorer.clear();
				current.setParent(null);
				started=true;
			}
			if (current.getLabel().equals(goal) && started) {
				return current;
			} else {
				explorer.add(current);
				List<Edge> children = current.getChildren();
				for (Edge child : children) {
					Node end = child.getEnd();
				double newPathH = current.getH() + child.getWeight();
					if (!frontier.contains(end) && !explorer.contains(end)) {
						end.setParent(current);
						end.setH(newPathH);
						frontier.add(end);
						explorer.add(end);
						
						
					}
			
		}
		
		
			
					}

				
			
		
		
	
	
	}
		return null;

}}
