import java.util.*;

public class CycleDetection {
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

        public void addEdgeToDirected(int src, int des) {
            graph[src].add(new Edge(src, des));
        }

        public void addEdgeToUndirected(int src, int des) {
            graph[src].add(new Edge(src, des));
            graph[des].add(new Edge(des, src)); // add for undirected
        }

        public boolean checkForCycleDirected(int curr, boolean[] visit, boolean recStack[]) {
            if (recStack[curr]) // If the current vertex is already in recursion stack, it's a cycle.
                return true;
            if (visit[curr]) // If the current vertex is already visited, it's not a cycle. i.e. not present
                             // in recursion stack
                return false;

            visit[curr] = true;
            recStack[curr] = true;

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (checkForCycleDirected(e.destination, visit, recStack))
                    return true;
            }

            // After visited all the neighbors, remove from recursion stack.
            recStack[curr] = false;
            return false;
        }

        public boolean checkForCycleUndirected(boolean[] visit, int curr, int parent) {
            visit[curr] = true;

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                // condition 1 -> neighbour already visited but not parent i.e cycle
                if (visit[e.destination] && parent != e.destination)
                    return true;

                // condition 3 -> neighbour not visited yet -> visit it
                else if (!visit[e.destination]) {
                    if (checkForCycleUndirected(visit, e.destination, curr)) // cycle detected in the next graph of the
                                                                             // neighbor
                        return true;
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("----------------------------------------");
        System.out.println("\t*** Cycle Detection ***\t");
        System.out.println("----------------------------------------");

        boolean x = true;
        while (x) {
            System.out.println("\tOptions Available\t");
            System.out.println("1. For Directed Graph\n2. For Undirected Graph\n3. Exit");

            System.out.print("Enter your choice : ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of vertices: ");
                    int v = sc.nextInt();

                    Graph G1 = new Graph(v);

                    System.out.print("Enter the number of edges: ");
                    int e = sc.nextInt();

                    System.out.println("Enter the details for each edge (Source, Destination): ");

                    for (int i = 0; i < e; i++) {
                        int src = sc.nextInt();
                        int des = sc.nextInt();
                        G1.addEdgeToDirected(src, des);
                    }

                    boolean[] visited = new boolean[v];
                    boolean[] recStack = new boolean[v];
                    System.out.print("Enter the start vertex : ");
                    int start = sc.nextInt();
                    boolean ans = G1.checkForCycleDirected(start, visited, recStack);

                    if (ans)
                        System.out.println("Cycle detected in the given graph.");
                    else
                        System.out.println("No cycle in the given graph.");
                    break;

                case 2:
                    System.out.print("Enter the number of vertices: ");
                    int v1 = sc.nextInt();

                    Graph G2 = new Graph(v1);

                    System.out.print("Enter the number of edges: ");
                    int e1 = sc.nextInt();

                    System.out.println("Enter the details for each edge (Source, Destination): ");

                    for (int i = 0; i < e1; i++) {
                        int src = sc.nextInt();
                        int des = sc.nextInt();
                        G2.addEdgeToUndirected(src, des);
                    }

                    boolean[] visited1 = new boolean[v1];
                    System.out.print("Enter the start vertex : ");
                    int start1 = sc.nextInt();
                    boolean ans1 = G2.checkForCycleUndirected(visited1, start1, -1);

                    if (ans1)
                        System.out.println("Cycle detected in the given graph.");
                    else
                        System.out.println("No cycle in the given graph.");
                    break;

                case 3:
                    System.out.println("Thank You !!");
                    x = false;
                    break;
            }
        }
    }
}
