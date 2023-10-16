package k21;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class DFSTreeSearchAlgo implements ISearchAlgo{

	@Override
	public Node execute(Node root, String goal) {
		Stack <Node> frontier1 = new  Stack<Node>();
		frontier1.add(root);
		//reverse stack  (not sure because find in stackoverflow)
		Stack <Node> frontier = new  Stack<Node>();
		while (!frontier1.isEmpty()) {
			Node x = frontier1.pop();
			frontier.add(x);
		}//
		List<Node> explorer = new ArrayList<Node>();
		while(!frontier.isEmpty()) {
			Node current = frontier.pop();
			if (current.getLabel().equals(goal)) {
				return current;
				
			}
			explorer.add(current);
			List<Node> children = current.getChildrenNodes();
			List<Node> childrencopy = new ArrayList<>(children);//ko hiểu rõ copy để làm gì
			for (Node child : children) {
				//neu la tree search thi ko co dong if va tao bang
				//copy cua child de phong truong hop có 2 node giống nhau, và thêm 1 điều là muốn tính chi phí thì thêm sau child.getend và thay Node thành Edge
				//di hỏi thây
				
				
				
					frontier.add(child);
					
					child.setParent(current);
					
					
				
			}
		}
		return null;
	
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		return null;
		// TODO Auto-generated method stub
	
}}
