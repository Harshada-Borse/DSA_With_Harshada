import java.util.*;
/*
 * Topological Sorting:
 * -> Dependency
 * -> Apply only on Directed Acyclic Graph(DAG) is a directed graph with no cycle
 * -> Topological sorting is used only for DAG's(not for non-DAG's)
 * -> It is a linear order of vertices such that every directed edge u -> v, the vertex u comes before v in the order
 * -> T.C. -> O(V + E)
 */

public class TopologicalSorting {
    static class Edge {
        int src;
        int destination;

        Edge(int src, int des) {
            this.src = src;
            this.destination = des;
        }
    }

    static class Graph {
        int vertices;
        List<Edge> graph[];
        Scanner sc = new Scanner(System.in);

        Graph(int v) {
            this.vertices = v;
            graph = new ArrayList[v];

            // initialize to empty arraylist
            for (int i = 0; i < v; i++) {
                graph[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int des) {
            graph[src].add(new Edge(src, des));
        }

        public void topoSort(int curr, boolean[] visited, Stack<Integer> stack) {
            visited[curr] = true;

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (!visited[e.destination])
                    topoSort(e.destination, visited, stack);
            }

            stack.push(curr); // add the src at the last
        }
    }

    public static void main(String[] args) {
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("\t*** Implementing the Topological Sorting using DFS *** \t");
        System.out.println("-----------------------------------------------------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        Graph G1 = new Graph(v);

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter the details for each edge (Source, Destination): ");

        for (int i = 0; i < e; i++) {
            // System.out.println("Edge " + (i + 1) + " --> ");
            // System.out.print("Source: ");
            int src = sc.nextInt();
            // System.out.print("Destination: ");
            int des = sc.nextInt();
            // System.out.print("Weight: ");
            G1.addEdge(src, des);
            // System.out.println("----------------------");
        }

        System.out.println("The topological sort for the given graph is : ");
        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if (!visited[i])
                G1.topoSort(i, visited, stack);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
