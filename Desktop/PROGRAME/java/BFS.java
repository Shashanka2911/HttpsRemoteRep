import java.util.*;
import java.util.HashMap;

class Graph {
    private Map<Character, List<Character>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(char source, char destination) {
        adjacencyList.computeIfAbsent(source, k -> new ArrayList<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new ArrayList<>()).add(source);
    }

    public void bfs(char startNode) {
        Queue<Character> queue = new LinkedList<>();
        Set<Character> visited = new HashSet<>();

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            char currentNode = queue.poll();
            System.out.print(currentNode + " ");

            List<Character> neighbors = adjacencyList.get(currentNode);
            if (neighbors != null) {
                for (char neighbor : neighbors) {
                    if (!visited.contains(neighbor)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
        }
    }
}

public class BFS{
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

        System.out.println("BFS sequence starting from node A:");
        graph.bfs('A');
    }
}

