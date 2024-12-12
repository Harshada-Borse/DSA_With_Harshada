import java.util.*;
/*
 * Graph : combination of nodes and edges
 * 4 ways to represent it :
 * i) Adjacency List (list of list): adjacent nodes(vertices are store in the list of respective node)
 * ii) Adjecency matrix : it the edge exits between i - j -> 1 else 0 i.e. if edge exit then matrix[i][j] = 1 else 0(no edge exits)
 * iii) Edge list : list of edges in sorted form by their weight
 * iv) 2D matrix(Implicit graph) : given 2d matrix visualize it as graph
 * 
 * Efficient way to implement the graph is "Adjacency list" with minimum linear time complexity
 */

/* 
 * Implemention using adjacency list :
 * Here, we used the "array of list" -> created the array of vertices and each vertex is associate with the arraylist of edge
 ** Size of array = no. of vertices and the type of array is arraylist i.e. " List<Edge> edgeList[]"
 * each edge in the list consists of source, destination and weight
 *** We need to initialize the arraylist at every index with the empty arraylist since by defayult it contains the null 
 if we not initialize it to empty arraylist then it will gives the null pointer exception
 */

/*
 * Graph Travelsel :
 * 1. Breath-First Search(BFS) - using queue T.C. -> O(V + E)
 * 2. Depth-First Search(DFS) - using recursion T.C. -> O(V + E)
 */

public class GraphBasics {
    static class Edge {
        int source;
        int destination;
        int weight;

        Edge(int src, int des, int wt) {
            this.source = src;
            this.destination = des;
            this.weight = wt;
        }
    }

    static class Graph {
        int vertices;
        List<Edge> edgesList[];
        Scanner sc = new Scanner(System.in);

        Graph(int v) {
            this.vertices = v;
            edgesList = new ArrayList[v];

            for (int i = 0; i < v; i++) {
                edgesList[i] = new ArrayList<>();
            }
        }

        public void addEdge(int src, int des, int wt) {
            // For an undirected graph, both directions are added src to des and des to src
            edgesList[src].add(new Edge(src, des, wt));
            edgesList[des].add(new Edge(des, src, wt));
        }

        public List<Integer> findAdjacent(int src) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int i = 0; i < edgesList[src].size(); i++) {
                Edge e = edgesList[src].get(i);
                ans.add(e.destination); // adding adjacent vertices to the list
                System.out.println(e.source + " - " + e.destination); // get edge(pair of source and destination)
            }
            return ans;
        }

        public void BFS(int start) {
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[vertices];

            // add start to the queue
            q.add(start);

            while (!q.isEmpty()) {
                int curr = q.remove();
                if (visited[curr] == false) {
                    // 1. print current
                    System.out.print(curr + " ");

                    // 2. mark it as visited
                    visited[curr] = true;

                    // 3. add it's adjecent vertices to the queue
                    for (int i = 0; i < edgesList[curr].size(); i++) {
                        Edge e = edgesList[curr].get(i);
                        q.add(e.destination);
                    }
                }
            }
        }

        public void DFS(int curr, boolean[] visit) {
            System.out.print(curr + " ");

            visit[curr] = true;

            for (int i = 0; i < edgesList[curr].size(); i++) {
                Edge e = edgesList[curr].get(i);
                if (visit[e.destination] == false)
                    DFS(e.destination, visit);
            }
        }

        public void allPossiblePaths(int curr, int target, List<Integer> path, boolean[] visit) {
            // base case
            if (curr == target) {
                // print path
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i) + " -> ");
                }
                System.out.println();
                return;
            }

            visit[curr] = true;
            for (int i = 0; i < edgesList[curr].size(); i++) {
                Edge e = edgesList[curr].get(i);

                if (visit[e.destination] == false) {
                    path.add(e.destination);
                    // visit[e.destination] = true;

                    allPossiblePaths(e.destination, target, path, visit);

                    path.remove(path.size() - 1); // for backtrack
                    visit[e.destination] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of vertices: ");
        int v = sc.nextInt();

        Graph G1 = new Graph(v);

        System.out.print("Enter the number of edges: ");
        int e = sc.nextInt();

        System.out.println("Enter the details for each edge (Source, Destination, and Weight): ");

        for (int i = 0; i < e; i++) {
            // System.out.println("Edge " + (i + 1) + " --> ");
            // System.out.print("Source: ");
            int src = sc.nextInt();
            // System.out.print("Destination: ");
            int des = sc.nextInt();
            // System.out.print("Weight: ");
            int wt = sc.nextInt();
            G1.addEdge(src, des, wt);
            // System.out.println("----------------------");
        }

        System.out.print("Enter the vertex whose adjacent vertices you want to find : ");
        int ver = sc.nextInt();
        List<Integer> ans = new ArrayList<>();
        ans = G1.findAdjacent(ver);
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }

        // Graph travelsal
        // 1. BFS
        System.out.println("\t*** Graph Traversal ***\t");
        System.out.println("\t1. BFS\t");
        System.out.println("Enter the start vertex : ");
        int start = sc.nextInt();
        G1.BFS(start);

        boolean[] visit = new boolean[v];
        System.out.println();
        System.out.println("\t2. DFS\t");
        System.out.println("Enter the start vertex : ");
        int start2 = sc.nextInt();
        G1.DFS(start2, visit);

        System.out.println("\t*** Finding all paths from src to traget ***\t");
        System.out.print("Enter the source vertex : ");
        int src = sc.nextInt();

        System.out.print("Enter the target vertex : ");
        int target = sc.nextInt();

        List<Integer> path = new ArrayList<>();
        boolean[] visit2 = new boolean[v];
        path.add(src);
        G1.allPossiblePaths(src, target, path, visit2);
    }
}