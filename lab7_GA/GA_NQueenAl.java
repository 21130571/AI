package lab7_GA;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class GA_NQueenAl {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		// Enter your code here
		initPopulation();
		int k = 0;
		while (k++ < MAX_ITERATIONS) {
			while (k++ < MAX_ITERATIONS) {
				ArrayList newPopulation = new ArrayList<>();
				for (int i = 0; i < POP_SIZE; i++) {
					Node x = this.getParentByRandomSelection();
					Node y = this.getParentByRandomSelection();
					Node child = this.reproduce(x, y);
					if (rd.nextDouble() < MUTATION_RATE) {
						mutate(child);
					}
					if (child.getH() == 0) {
						return child;
					}
				}

			}
			population = new ArrayList<Node>();
		}
		Collections.sort(population);
		return population.get(0);
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		// Enter your code here

		node.setRow(rd.nextInt(node.N), node.getRow(rd.nextInt(node.N)));

	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
//Enter your code here
		int c = rd.nextInt(Node.N);
		Node re = new Node();
		re.generateBoard();
		for (int i = 0; i < c; i++) {
			re.setRow(i, x.getRow(i));
		}
		for (int i = c; i < Node.N; i++) {
			re.setRow(i, y.getRow(i));
		}
		return re;
	}

//Select K individuals from the population at random and
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection(int k) {
//Enter your code here

		return null;
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
//Enter your code here
		return null;
	}
}
