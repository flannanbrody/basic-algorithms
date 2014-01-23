package sedgewick;

import java.util.Random;

/*************************************************************************
 *  Compilation:  javac DirectedEulerianCycle.java
 *  Dependencies: Digraph.java Stack.java Queue.java StdOut.java
 *
 *  Find an Euler tour if one exists.
 *
 *  Runs in O(E + V) time.
 *  
 *  Hint: Prove that a digraph G has a directed Eulerian cycle if and only if G is connected and each vertex 
 *  has its indegree equal to its outdegree
 *
 *
 *************************************************************************/

public class DirectedEulerianCycle {
    private Stack<Integer> tour = new Stack<Integer>();
    private boolean isEulerian = true;
    private Stack<Integer> stack = new Stack<Integer>();
    private Queue<Integer>[] adj;

    public DirectedEulerianCycle(Digraph G) {

        // create local copy of adjacency lists
        adj = (Queue<Integer>[]) new Queue[G.V()];
        for (int v = 0; v < G.V(); v++) {
            adj[v] = new Queue<Integer>();
            for (int w : G.adj(v))
                adj[v].enqueue(w);
        }

        // find Eulerian tour
        stack.push(0);
        while (!stack.isEmpty()) {
            int s = stack.pop();
            tour.push(s);
            int v = s;
            while (!adj[v].isEmpty()) {
                stack.push(v);
                v = adj[v].dequeue();
            }
            if (v != s) isEulerian = false;
        }

        // check if all edges have been used
        for (int v = 0; v < G.V(); v++)
            if (!adj[v].isEmpty()) isEulerian = false;
    }

    // return Eulerian tour, or null if no such tour
    public Iterable<Integer> tour() {
        if (!isEulerian) return null;
        return tour;
    }

    // does the digraph have an Eulerian tour?
    public boolean isEulerian() {
        return isEulerian;
    }



    public static void main(String[] args) {
    	Random random = new Random();
        int V = Integer.parseInt("10");
        int E = Integer.parseInt("15");

        // random graph of V vertices and approximately E edges
        // with indegree[v] = outdegree[v] for all vertices
        Digraph G = new Digraph(V);
        int[] indegree  = new int[V];
        int[] outdegree = new int[V];
        int deficit = 0;
        for (int i = 0; i < E - deficit/2; i++) {
            int v = random.nextInt(V);
            int w = random.nextInt(V);
            if (v == w) { i--; continue; }
            G.addEdge(v, w);
            if (outdegree[v] >= indegree[v]) deficit++;
            else                             deficit--;
            outdegree[v]++;
            if (indegree[w] >= outdegree[w]) deficit++;
            else                             deficit--;
            indegree[w]++;
        }

                while (deficit > 0) {
            int v = random.nextInt(V);
            int w = random.nextInt(V);
            if (v == w) continue;
            if (outdegree[v] >= indegree[v]) continue;
            if (indegree[w]  >= outdegree[w]) continue;
            G.addEdge(v, w);
            if (outdegree[v] >= indegree[v]) deficit++;
            else                             deficit--;
            outdegree[v]++;
            if (indegree[w] >= outdegree[w]) deficit++;
            else                             deficit--;
            indegree[w]++;
        }

        System.out.println(G);
        DirectedEulerianCycle euler = new DirectedEulerianCycle(G);
        if (euler.isEulerian()) {
            for (int v : euler.tour()) {
            	System.out.println(v + " ");
            }
            System.out.println();
        }
        else {
        	System.out.println("Not eulerian");
        }
    }

}
