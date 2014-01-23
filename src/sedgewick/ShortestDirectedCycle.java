package sedgewick;

/*************************************************************************
 *  Compilation:  javac ShortestDirectedCycle.java
 *  Execution:    java DirectedCycle < input.txt
 *  Dependencies: Digraph.java BreadthFirstDirectedPaths.java Stack.java StdOut.java In.java
 *  Data files:   http://algs4.cs.princeton.edu/42directed/tinyDG.txt
 *                http://algs4.cs.princeton.edu/42directed/tinyDAG.txt
 *
 *  Finds a shortest directed cycle in a digraph.
 *  Runs in O(V * (E + V)) time.
 *
 *  % java ShortestDirectedCycle tinyDG.txt 
 *  Shortest directed cycle: 2 3 2 
 *
 *  %  java ShortestDirectedCycle tinyDAG.txt 
 *  No cycle
 *
 *************************************************************************/

public class ShortestDirectedCycle {
    private Stack<Integer> cycle;    // directed cycle (or null if no such cycle)
    private int length;

    public ShortestDirectedCycle(Digraph G) {
        Digraph R = G.reverse();
        length = G.V() + 1;
        for (int v = 0; v < G.V(); v++) {
            BreadthFirstDirectedPaths bfs = new BreadthFirstDirectedPaths(R, v);
            for (int w : G.adj(v)) {
                if (bfs.hasPathTo(w) && (bfs.distTo(w) + 1) < length) {
                    length = bfs.distTo(w) + 1;
                    cycle = new Stack<Integer>();
                    for (int x : bfs.pathTo(w))
                        cycle.push(x);
                    cycle.push(v);
                }
            }
        }
    }


    public boolean hasCycle()        { return cycle != null;   }
    public Iterable<Integer> cycle() { return cycle;           }
    public int length()              { return length;          }

    public static void main(String[] args) {
        Digraph G;
        if (args.length == 1) {
            In in = new In(args[0]);
            G = new Digraph(in);
        }
        else {
            int V = Integer.parseInt("10");
            int E = Integer.parseInt("15");
            G = DigraphGenerator.simple(V, E);
        }

        ShortestDirectedCycle finder = new ShortestDirectedCycle(G);
        if (finder.hasCycle()) {
            System.out.print("Shortest directed cycle: ");
            for (int v : finder.cycle()) {
            	System.out.print(v + " ");
            }
            System.out.println();
        }

        else {
        	System.out.println("No cycle");
        }
    }

}
