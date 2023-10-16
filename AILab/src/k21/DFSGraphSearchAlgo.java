package k21;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSGraphSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		//dfs
		
			Stack <Node> frontier1 = new  Stack<Node>();
			frontier1.add(root);
			//reverse stack
			Stack <Node> frontier = new  Stack<Node>();
			while (!frontier1.isEmpty()) {
				Node x = frontier1.pop();
				frontier.add(x);
			}
			List<Node> explorer = new ArrayList<Node>();
			while(!frontier.isEmpty()) {
				Node current = frontier.pop();
				if (current.getLabel().equals(goal)) {
					return current;
					
				}
				explorer.add(current);
				List<Node> children = current.getChildrenNodes();
				for (Node child : children) {
					//neu la tree search thi ko co dong if va tao bang
					//copy cua child de phong truong hop có 2 node giống nhau, và thêm 1 điều là muốn tính chi phí thì thêm sau child.getend và thay Node thành Edge
					if (!frontier.contains(child)&& !explorer.contains(child)) {
						frontier.add(child);
						child.setParent(current);
						
					}
				}
			}
			return null;
		
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack <Node> frontier1 = new  Stack<Node>();
		frontier1.add(root);
		//reverse stack  (not sure because find in stackoverflow)
		Stack <Node> frontier = new  Stack<Node>();
		while (!frontier1.isEmpty()) {
			Node x = frontier1.pop();
			frontier.add(x);
		}//
		
		frontier.add(root);
		boolean started = false;
		List<Node> explorer = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
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
