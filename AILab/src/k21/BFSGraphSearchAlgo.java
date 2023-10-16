package k21;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BFSGraphSearchAlgo implements  ISearchAlgo {

	@Override
	
	public Node execute(Node root, String goal) {
		// TODO Auto-generated method stub
		Queue <Node> frontier = new  LinkedList<Node>();
		frontier.add(root);
		List<Node> explorer = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.poll();
			if (current.getLabel().equals(goal)) {
				return current;
				
			}
			explorer.add(current);
			List<Node> children = current.getChildrenNodes();
			for (Node child : children) {
				//neu la tree search thi ko co dong if va tao bang
				//copy cua child de phong truong hop có 2 node giống nhau
				if (!frontier.contains(child)&& !explorer.contains(child)) {
					frontier.add(child);
					child.setParent(current);
				}
			}
		}
		return null;
	}

//
	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		
			Queue <Node> frontier = new  LinkedList<Node>();
			frontier.add(root);
			boolean started = false;
			List<Node> explorer = new ArrayList<Node>();
			while(!frontier.isEmpty()) {
				Node current = frontier.poll();
				if (current.getLabel().equals(start)) {
					frontier.clear();
					explorer.clear();
					current.setParent(null);
					started=true;
				}
				
				if (current.getLabel().equals(goal) && started) {					
					return current;
				}
				explorer.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node child : children) {
					
					if (!frontier.contains(child)&& !explorer.contains(child)) {
						frontier.add(child);
						child.setParent(current);
					}
				}
			}
			
		
		return null;
	}

}
