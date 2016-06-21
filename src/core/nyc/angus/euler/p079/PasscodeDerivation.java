package nyc.angus.euler.p079;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Solution for Project Euler #79.
 */
public class PasscodeDerivation {

	/**
	 * Connect the characters in a graph, then perform a topological sort to get the correct ordering.
	 * <p>
	 * This won't return a complete passcode if it isn't possible to infer a single ordering.
	 */
	public String obtainPassword(final String[] words) {
		final Map<Character, Node> map = new HashMap<>();

		for (final String word : words) {
			Node prev = null;

			for (final char c : word.toCharArray()) {

				if (!map.containsKey(c)) {
					final Node n = new Node(c);
					map.put(c, n);
				}

				if (prev != null) {
					prev.children.add(map.get(c));
				}

				prev = map.get(c);
			}
		}

		final Node[] nodesArr = map.values().toArray(new Node[0]);
		Arrays.sort(nodesArr);

		return search(nodesArr);
	}

	private String search(final Node[] nodes) {
		final List<Node> results = new LinkedList<>();

		final boolean[] visited = new boolean[nodes.length];

		for (int i = 0; i < nodes.length; i++) {
			if (!visited[i]) {
				visit(i, nodes, visited, results);

			}
		}

		final StringBuilder sb = new StringBuilder();
		for (final Node n : results) {
			sb.append(n.c);
		}

		return sb.reverse().toString();
	}

	private void visit(final int i, final Node[] nodes, final boolean[] visited, final List<Node> results) {
		visited[i] = true;

		final List<Node> adjacent = nodes[i].children;

		for (final Node n : adjacent) {
			final int pos = Arrays.binarySearch(nodes, n);

			if (!visited[pos]) {
				visit(pos, nodes, visited, results);

			}
		}

		results.add(nodes[i]);

	}

	private class Node implements Comparable<Node> {
		char c;
		List<Node> children = new LinkedList<>();

		public Node(final char c) {
			this.c = c;
		}

		@Override
		public int hashCode() {
			return c;
		}

		@Override
		public int compareTo(final Node other) {
			return (other.c) - (this.c);
		}
	}
}
