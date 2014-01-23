package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DiagraphRouteBetweenTwoNodes {

	public static void main(String args[]){
		Graph_AdjacencyList graph = new Graph_AdjacencyList(20);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(4, 2);
		graph.addEdge(4, 5);
		graph.addEdge(5, 7);
		graph.addEdge(6, 3);
		graph.addEdge(7, 6);
 
		System.out.println(depthFirstSearch(graph, 2, 7));
		System.out.println(depthFirstSearch(graph, 3, 7));
		System.out.println(depthFirstSearch(graph, 7, 3));
	}
	/*
	 * we can use breadth first search or depth first search
	 */
	public static boolean breadthFirstSearch(Graph_AdjacencyList g, int start, int end){
		// +1 是因为在graph中我们没有用0 是从1开始计数
		boolean[] visited = new boolean[g.size() + 1];
		visited[start] = true;
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		while(!queue.isEmpty()){
			int v = queue.remove();
			for(int item: g.neighbours(v)){
				if(!visited[item]){
					if(item == end)
						return true;
					else{
						visited[item] = true;
						queue.add(item);
					}
				}
			}
		}
		return false;
	}
	
	public static boolean depthFirstSearch(Graph_AdjacencyList g, int start, int end){
		boolean visited[] = new boolean[g.size() + 1];
		return depthRecursive(g, start, end, visited);
	}
	
	public static boolean depthRecursive(Graph_AdjacencyList g, 
			int start, int end, boolean[] visited){
		visited[start] = true;
		for(int item: g.neighbours(start)){
			if(!visited[item]){
				if(item == end)
					return true;
				else
					return depthRecursive(g, item, end, visited);
			}
		}
		return false;
	}
	
	/*
	 * Diagraph
	 */
	private static class Graph_AdjacencyList {
		private ArrayList<ArrayList<Integer>> list;
		private int numOfVertices;
		
		public Graph_AdjacencyList(int n){
			numOfVertices = n;
			list = new ArrayList<ArrayList<Integer>>(n);
			for(int i = 0 ;i <= n;i++)
				list.add(new ArrayList<Integer>());
		}
		
		public int size(){
			return numOfVertices;
		}
		
		/*
		 * 只加v1这个list上
		 * 因为输入的时候v1-v2 v2-v1 都会出现 
		 * 如果都加 会出现重复
		 */
		public void addEdge(int v1, int v2){
			list.get(v1).add(v2);
		}
		
		public void removeEdge(int v1, int v2){
			//因为remove的参数是index 而不是要删除的值 我们先要找到要删除的index
			int i2 = list.get(v1).indexOf(v2);
			list.get(v1).remove(i2);
		}
		
		public ArrayList<ArrayList<Integer>> getLists(){
			return list;
		}
		
		public ArrayList<Integer> neighbours(int index){
			return list.get(index);
		}
		
		public void setLists(ArrayList<ArrayList<Integer>> newList){
			list = newList;
		}
		
		public void main1(String args[]){
			Graph_AdjacencyList graph = new Graph_AdjacencyList(20);
			graph.addEdge(12, 13);
			graph.addEdge(1, 12);
			graph.addEdge(2, 12);
			graph.addEdge(3, 12);
			graph.addEdge(4, 12);
			graph.addEdge(3, 9);
			graph.addEdge(20, 9);
			graph.addEdge(3, 9);
			
			System.out.println(graph.neighbours(20));
			System.out.println(graph.getLists());
			
		}
	}
}

