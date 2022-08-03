public class Currency_exchange_dijsktraApplication_blackrock{ 

	static ArrayList<String[]> v = new ArrayList<String[]>();
	public static void addNode(int from , int to , double value , double[][] graph) {
		graph[from][to] = value;
	}
	
    static int count = 0 ;
    static HashMap<String,Integer> hm = new HashMap<String,Integer>();
	public static void main(String[] args) 
	{  
	String x = "USD,GBP,0.7;USD,JPY,109;GBP,JPY,155;CAD,CNY,5.27;CAD,KRW,921";
	String[] nodes = x.split(";");
	System.out.println(Arrays.toString(nodes));
	for(String i : nodes) {
		String[] vals = i.split(","); // split string into 3 parts 1st is from node 2nd is to node 3rd is value 
		System.out.println(Arrays.toString(vals));
		v.add(vals);
		for(int j = 0 ; j <=1 ; j ++) {//helps us map all the nodes in the second for loop from string to integer value or index value 
			if(!(hm.containsKey(vals[j]))) {
			hm.put(vals[j],count);
			count++;
		}
			
		}
		
	}
	System.out.println(hm);
	System.out.println(count);
	//make grid using count 
	double[][] graph = new double[count][count];
	for( String[] i : v) {
		System.out.println(hm.get(i[0]));
		int from = (hm.get(i[0]));
		int to = (hm.get(i[1]));
		double value = (Double.parseDouble(i[2]));
		addNode(from , to ,(1/value) ,  graph);
		
	}
	System.out.println(Arrays.deepToString(graph));//thus we have our final adjacency graph with all from to connections now we use Dijsktra to continue
	for(int i =0 ; i <graph.length ; i ++) {
		System.out.println(Arrays.toString(graph[i]));
	}
	int source = 3 ; //assume for now 
	int dest = 1;
	double answer = Solve(graph, source , dest);
	System.out.println(answer);
	} 
	public static double Solve(double[][] graph , int source , int dest) {
		int vert = graph.length;
		boolean[] fin = new boolean[vert];
		double[] dist = new double[vert];
		Arrays.fill(dist,-1);
		dist[source]= 1;//starting point conversion 
		for(int count = 0 ; count < vert-1 ; count ++) {
			//now get min from dist graph
			int u =-1 ;
			for(int i = 0 ; i < vert ; i ++) {
				if(!fin[i] && (u==-1|| ((1/dist[i])<(1/dist[u]))&&(dist[i]>=0))) {//make sure i is not negative as negative means not visited yet
					if(dist[i]<0) {
						continue;
					}else {
						u =i ; //gets min from graph
					}
					
					
				}
				
			}
			System.out.println(u);
			if(u!=-1){
				fin[u]=true;
				for(int v = 0 ; v < vert ; v ++) {
					if(!fin[v] && graph[u][v]!=0) {
						if(dist[v]<0){
							dist[v] = dist[u]*graph[u][v];
						}else if (dist[v]>(dist[u]*graph[u][v])){
							dist[v] = dist[u]*graph[u][v];
							
						}
					}
				}
				
			}
		
			
		}
		return 1/dist[dest];
	}
	
	  public static double[][] graphmaker(String x){
		    ArrayList<String[]> v = new ArrayList<String[]>();
		    int count = 0 ;
		     HashMap<String,Integer> hm = new HashMap<String,Integer>();
		    String[] nodes = x.split(";");
			for(String i : nodes) {
				String[] vals = i.split(","); // split string into 3 parts 1st is from node 2nd is to node 3rd is value 
				v.add(vals);
				for(int j = 0 ; j <=1 ; j ++) {//helps us map all the nodes in the second for loop from string to integer value or index value 
					if(!(hm.containsKey(vals[j]))) {
					hm.put(vals[j],count);
					count++;
				}
					
				}
				
			}
		  
			//make grid using count 
			double[][] graph = new double[count][count];
			for( String[] i : v) {
				System.out.println(hm.get(i[0]));
				int from = (hm.get(i[0]));
				int to = (hm.get(i[1]));
				double value = (Double.parseDouble(i[2]));
				addNode(from , to ,(1/value) ,  graph);
				
			}
		  return graph;
		}


} 