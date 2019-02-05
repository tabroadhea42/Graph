package graph

import util.ReadTextFile;
import pqsort.PQSort;
import java.util.ArrayList;
import java.util.Iterator;
import util.KeyedItem;

public class Graph
{
	
   public static void main (String[] args)
   {
	  String vertex_file = "vertex_file.txt";
	  Vertex[] verticies =  readVertexFile(vertex_file);

		boolean choice = false;
		
		
		Edge[] unsorted_array = readEdgeFile("edge_file.txt");
		/*for(int i = 0; i < unsorted_array.length; i++){
			if(unsorted_array[i] != null){
			System.out.println(unsorted_array[i]);
		}
			System.out.println("\n");
		}
		System.out.println("\n\n\n\n\n");
		KeyedItem[] unsorted_keyedItem = unsorted_array;
		KeyedItem[] sorted_array = PQSort.pqSort(unsorted_array, choice);
		for(int i = 0; i < unsorted_array.length; i++){
			if(sorted_array[i] != null){
			System.out.println(sorted_array[i]);
			}
		}*/
		
		KeyedItem[] unsorted_keyedItem = unsorted_array;
		KeyedItem[] sorted_array = PQSort.pqSort(unsorted_array, choice);
		
		String start_key = "Hirsova";
		String end_key = "Pitesti";
		
		Vertex start_key_v;
		Vertex end_key_v;
		
		for(int = 0; i < verticies.size(); i++)
		{
			if(start_key.equals(verticies[i].vertexName()))
			{
				start_key_v = verticies[i];
			}
		}
		
		for(int j = 0; j < verticies.size(); j++)
		{
			if(end_key.equals(verticies[j].vertexName()))
			{
				end_key_v = verticies[j];
			}
		}
		
		Edge[] prim = prim(verticies, sorted_array);
		Edge[] kruskal = kruskal(verticies.size(), sorted_array);
		Edge[] shortest = Dijkstra(verticies.size(); start_key_v, end_key_v, sorted_array);
		return;		
   }

   private static Vertex[] readVertexFile(String file_name)
   {
	  verticies = new ArrayList<Vertex>();
	   
      ReadTextFile file = new ReadTextFile(file_name);
      String str;
      while (!file.EOF())
      {
		 str = file.readLine();
         Vertex v = new Vertex(str);
		 verticies.add(v);
	  }	 
	  
	  int num_verts = verticies.size();
	  Vertex[] vertex_array = new Vertex[num_verts];
	  
	  int count = 0;
	  for (Vertex vs : verticies)
	  {
	  	vertex_array[count] = vs;
	  	count++;
	  }
	  
	  return vertex_array;
	}
	
	private static Edge[] readEdgeFile(String file_name)
	{
		ArrayList<Edge> edges = new ArrayList<Edge>();
		String start_vertex_key;
		String end_vertex_key;
		double edge_weight;
		ReadTextFile file = new ReadTextFile(file_name);
		String str = file.readLine();
		while(!file.EOF())
		{
			start_vertex_key = file.readLine();
			end_vertex_key = file.readLine();
			edge_weight =  Double.parseDouble(file.readLine());
			Edge e = new Edge(start_vertex_key, end_vertex_key, edge_weight);
			edges.add(e);
		}
		
		int num_edges = edges.size();
		Edge[] edge_array = new Edge[num_edges];
	  
		int count = 0;
		for (Edge es : edges)
		{
			edge_array[count] = es;
			count++;
		}
	  
		return edge_array;
	}
	
	private static Edge[] prim(Vertex[] verticies, KeyedItem[] sorted_array)
	{
		int num_edges = sorted_array.size();
		Edge[] prim = new Edge[verticies.size()];
		String[] visited = new String[verticies.size()];
		
		for(int i = 0; i < verticies.size(); i++)
		{
			Vertex v = verticies[i];
			String key = v.vertexName();
			for(int j = 0; j < num_edges; j++)
			{
				Edge e = sorted_array[j];
				String start_key = e.startKey();
				if(key.equals(start_key))
				{
					String end = e.endKey();
					bool have_been = false;
					for(int w = 0; w < visited.size(); w++)
					{
						if(end.equals(visisted[w]))
						{
							have_been = true;
						}
					}
					if(have_been == false)
					{
						prim.add(e);
					}
					else
					{
						have_been = false;
					}
				}
			}
		}
		
		return prim;
	}
	
	private static Edge[] kruskal(int num_verticies, KeyedItem[] sorted_array)
	{
		Edge[] kruskal = new Edge[num_verticies];
		kruskal[0] = sorted_array[0];
		
		bool visited = false;
		
		for(int i = 1; i < num_edges; i++)
		{
			Edge e = sorted_array[i];
			for(int j = 0; j < kruskal.size(); j++)
			{
				Edge k = kruskal[j];
				String start = k.startKey();
				String end = k.endKey();
				if(start.equals(e.startKey())
				{
					visited = true;
				}
				else if(start.equals(e.endKey())
				{
					visited = true;
				}
				else if(end.equals(e.startKey())
				{
					visited = true;
				}
				else if(end.equals(e.endKey())
				{
					visited = true;
				}
			}
			if(visited == false)
			{
				kruskal.add(e)
			}
			else
			{
				visited = false;
			}
		}
		
		return kruskal;
	}
	
	private static Edge[] Dijkstra(int num_verts, Vertex start_vertex_key, Vertex end_vertex_key, KeyedItem[] sorted_array)
	{	
		Vertex curr = start_vertex_key;
		Vertex[] visited = new Vertex[num_verts];
		visited[0] = curr;
		int pos = 1;
		String currName = curr.vertexName();
		String done = end_vertex_key.getName();
		
		while(!currName.equals(done))
		{
			for(int i = 0; i < sorted_array.size(); i++)
			{
				Edge[] unsorted = new Edge[num_verts];
				
				Vertex edgeStart = sorted_array[i].startKey();
				Vertex edgeEnd = sorted_array[i].endKey();
				String eStart = edgestart.vertexName();
				if(currName.equals(eStart))
				{
					edgeEnd.setPrevious(curr);
					double total = curr.getTotal() + sorted_array[i].edgeWeight();
					edgeEnd.setTotal(total);
					unsorted.add(edgeEnd);
				}
			}
			KeyedItem[] unsorted_keyedItem = unsorted_array;
			KeyedItem[] pq = PQSort.pqSort(unsorted_array, false);
			
			while(!pq.isEmpty())
			{
				bool done_that = false;
				
				Vertex sorted = pq.remove();
				for(int w = 0; w < visited.size(); w++)
				{
					String next = sorted.getName();
					String been_there = visited[i].getName();
					if(next.equals(been_there))
					{
						done_that = true;
						break;
					}
				}
				if(done_that = false)
				{
					curr.setNext(sorted);
					visited[pos].add(sorted);
					curr = sorted;
					currName = curr.vertexName();
					break;
				}
			}
		}
		
		return shortest;
	}
}