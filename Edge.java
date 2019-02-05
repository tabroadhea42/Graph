package graph

import util.KeyedItem;

public class Edge extends KeyedItem
{
		private Vertex start_vertex_key;
		private Vertex end_vertex_key;
		private double edge_weight;
		  
		public Edge(string start_vertex_key, string end_vertex_key, double edge_weight) 
		{
			super(edge_weight);
			this.end_vertex_key = end_vertex_key;
			this.start_vertex_key = start_vertex_key;
		}
			
		public double edgeWeight()
		{
			return edge_weight;
		}
			
		public Vertex startKey()
		{
			return start_vertex_key;
		}
			
		public Vertex endKey()
		{
			return end_vertex_key;
		}
}
