import java.util.*;

class Edge implements Comparable<Edge> {
    int src, dest, weight;

    public Edge(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight - other.weight;
    }
}

class Graph {
    private int V;
    private List<Edge>[] graph;

    public Graph(int V) {
        this.V = V;
        graph = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    public void addEdge(int src, int dest, int weight) {
        graph[src].add(new Edge(src, dest, weight));
        graph[dest].add(new Edge(dest, src, weight)); // Undirected graph
    }

    public int minSpanningTreeWeight() {
        boolean[] inMST = new boolean[V];
        int[] parent = new int[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>(); // sort the edges according to weight
        key[0] = 0;
        pq.add(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            inMST[u] = true;

            for (int i = 0; i < graph[u].size(); i++) {
                Edge e = graph[u].get(i);
                int v = e.dest;
                int weight = e.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Edge(u, v, key[v]));
                    parent[v] = u;
                }
            }
        }

        for (int i = 1; i < V; ++i) {
            System.out.println(parent[i] + " - " + i + " : " + key[i]);
        }
        int totalWeight = 0;
        for (int i = 1; i < V; ++i) {
            totalWeight += key[i];
        }
        return totalWeight;
    }

    public List<Edge> getMinSpanningTree() {
        boolean[] inMST = new boolean[V];
        int[] parent = new int[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        key[0] = 0;
        pq.add(new Edge(0, 0, 0));

        while (!pq.isEmpty()) {
            int u = pq.poll().dest;
            inMST[u] = true;

            for (Edge e : graph[u]) {
                int v = e.dest;
                int weight = e.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Edge(u, v, key[v]));
                    parent[v] = u;
                }
            }
        }

        List<Edge> minSpanningTree = new ArrayList<>();
        for (int i = 1; i < V; ++i) {
            minSpanningTree.add(new Edge(parent[i], i, key[i]));
        }
        return minSpanningTree;
    }
}

public class PrimsAlgo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices: ");
        int V = scanner.nextInt();

        Graph graph = new Graph(V);

        System.out.print("Enter the number of edges: ");
        int E = scanner.nextInt();

        System.out.println("Enter the details of each edge (source, destination, weight):");
        for (int i = 0; i < E; i++) {
            int src = scanner.nextInt();
            int dest = scanner.nextInt();
            int weight = scanner.nextInt();
            graph.addEdge(src, dest, weight);
        }

        int totalWeight = graph.minSpanningTreeWeight();
        System.out.println("Total weight of the minimum spanning tree: " + totalWeight);

        // List<Edge> minSpanningTree = graph.getMinSpanningTree();
        // System.out.println("One specific minimum spanning tree:");
        // for (Edge edge : minSpanningTree) {
        // System.out.println(edge.src + " - " + edge.dest + " : " + edge.weight);
        // }

        scanner.close();
    }
}
