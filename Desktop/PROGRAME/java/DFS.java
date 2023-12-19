import java.util.*;
import java.util.HashMap;

class Graph {
    private Map<Character, List<Character>> adjacencyList;

    public Graph() {
        this.adjacencyList =new HashMap<>();
    }

    public void addEdge(char source, char destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void dfs(char startNode) {
        Set<Character> visited = new HashSet<>();
        dfsUtil(startNode, visited);
    }

    private void dfsUtil(char currentNode, Set<Character> visited) {
        visited.add(currentNode);
        System.out.print(currentNode + " ");

        List<Character> neighbors = adjacencyList.get(currentNode);
        if (neighbors != null) {
            for (char neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsUtil(neighbor, visited);
                }
            }
        }
    }
}

public class DFS {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Adding edges to the graph
        graph.addEdge('A', 'B');
        graph.addEdge('A', 'C');
        graph.addEdge('B', 'D');
        graph.addEdge('B', 'E');
        graph.addEdge('C', 'F');
        graph.addEdge('C', 'G');
        graph.addEdge('D', 'E');

        System.out.println("DFS sequence starting from node D:");
        graph.dfs('D');
    }
}
