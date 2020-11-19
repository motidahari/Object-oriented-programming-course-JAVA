Ex0 Readme.
**********************************_Introduction_**********************************
@auther Moti Dahari
@ID: 308212570


In this project we will implement the interfaces.
There are three classes which we will use in order to implement the interfaces.
(We will elaborate each class by it's section)


**********************************_functions implements_**********************************”

*********_NodeData class function:_*********

The first class is called "NodeData Class".
This class represents the individual Vertex and all it's connector's by implementing the interface "node_data" in the code "NodeData".
The Data Structures which I used is "HashMap" since it is very effective.
In this class we will perform the following steps:

    /**
     * constructor for NodeData to create new empty hashMap for the Neighbors
     * @param
     * @return none return
     */
public NodeData();

    /**
     * constructor for NodeData to create new empty hashMap for the Neighbors with specific key
     * @param key of the node
     * @return none return
     */
public NodeData();

    /**
     * Return the key (id) associated with this node.
     * Note: each node_data should have a unique key.
     * @return this.key
     */
public int getKey();

    /**
     * This method returns a collection with all the Neighbor nodes of this node_data
     * @return collection of all the Neighbors by the node
     */
public Collection<node_data> getNi();

    /**
     * This method adds the node_data (t) to this node_data.
     * check if to the node in the class has Neighbor by the key of node_data t
     * if already has Neighbor to the node by node t.getKey we doing nothing
     * if not add the node to hashMap and we will increase the param size(Num Of Neighbor)
     * @param t node
     */
public void addNi(node_data t);

    /**
     * Removes the edge this-key,
     * check if to the node in the class has Neighbor by the key of node_data node
     * if to the node has Neighbor node.getKey() we delete the node and update the size
     * if not we doing nothing
     * @param node node_data
     */
public void removeNode(node_data node);

    /**
     * return the remark (meta data) associated with this node.
     * we use in the info to the path in the class GraphAlgo
     * @return info String
     */	
public String getInfo();

    /**
     * Allows changing the remark (meta data) associated with this node.
     *  change the value of the info
     * @param s String
     */	
public void setInfo(String s);

    /**
     * Temporal data (aka color: e,g, white, gray, black)
     * which can be used be algorithms
     * we use on the tag param to count the path in the class GraphAlgo
     * @return tag int
     */	
public int getTag();

    /**
     * Allow setting the "tag" value for temporal marking an node - common
     * practice for marking by algorithms.
     * update the value of the tag
     * @param t - the new value of the tag
     */	
public void setTag(int t);

    /**
     * get all data by node
     * @param node - the new value of the tag
     */
public String toString(node_data node);

    /**
     * run by Neighbors of node and return String of all the Neighbors
     * help func to toString
     * @param node - the new value of the tag
     */
public String getAllNeighborsByNodeId(node_data node);



*********_Graph_DS classs function:_*********


The second class is called "Graph_DS Class".
This class represents all Vertexes which are what make our graph.
This graph is called "Undirected Graph".
This class creates a graph from each individual vertex (node) by implement the interface "graph"
in the code "Graph_DS" to create the graph itself.
The Data Structures which I used is "HashMap" since it is very effective.
In this class we will perform the following steps:


    /**
     * constructor for Graph_DS to create new empty hashMap(Vertex) for the graph
     * @return none return
     */
 public Graph_DS()


    /**
     * constructor for Graph_Algo to create object with initialization to the graph
     * @param g graph
     * @return none return
     */
    public Graph_Algo(graph g);


    /**
     * return the node_data by the node_id,
     * check if has Vertex in the graph by node key
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
public node_data getNode(int key);

    /**
     * return true iff (if and only if) there is an edge between node1 and node2
     * Note: this method should run in O(1) time.
     * check if has two Vertex in the graph by node1 key && node2 key
     * if the two nodes are exist we check if to node1 has Neighbor node2 && to node2 has Neighbor node1
     * @param node1
     * @param node2
     * @return true if are they Neighbors from both sides false if they don't have
     */
public boolean hasEdge(int node1, int node2);

    /**
     * add a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     * check if Vertex in the graph by node key if to the graph does not have such a vertex
     * so we add the Vertex to the graph and we update the size & modeCount
     * else Doing nothing
     * @param n node_data
     *
public void addNode(node_data n);

    /**
     * Connect an edge between node1 and node2.
     * Note: this method should run in O(1) time.
     * Note2: if the edge node1-node2 already exists - the method simply does nothing.
     * check if has two Vertex in the graph by node1 key && node2 key
     * if the two nodes are exist we check if to node1 has Neighbor node2 || to node2 has Neighbor node1
     * if one of the vertices does not have the other neighbor we connect them and update the edgeSize && modeCount
     * @param node1
     * @param node2
     */
public void connect(int node1, int node2);

    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     * Note: this method should run in O(1) time.
     * return all Vertex in the graph
     * @return Collection<node_data>
     */
public Collection<node_data> getV();

    /**
     * This method return a collection of  the
     * collection representing all the nodes connected to node_id
     * Note: this method should run in O(1) time.
     * check if Vertex in the graph by node key if to the graph has such a vertex
     * so we return the Neighbors by the node key
     * else return null
     * @param node_id
     * @return Collection<node_data> or null if the node isn't exist
     */
public Collection<node_data> getV(int node_id);

    /**
     * Delete the node (with the given ID) from the graph -
     * and removes all edges which starts or ends at this node.
     * This method should run in O(n), |V|=n, as all the edges should be removed.
     * check if Vertex in the graph by node key if to the graph has such a vertex
     * so we delete the node from the graph and update the modeCount && edgeSize && size
     * after that we return the deleted node
     * else return null
     * @param key
     * @return the data of the removed node (null if none).
     */
public node_data removeNode(int key);

    /**
     * Delete the edge from the graph,
     * Note: this method should run in O(1) time.
     * check if has two Vertex in the graph by node1 key && node2 key
     * if the two nodes are exist we get the size of the Neighbors by every node
     * after we delete we compare the old size of the number of the Neighbors with the new size
     * if there isn't equality between the sizes we update the edgeSize && modeCount
     * @param node1
     * @param node2
     */
public void removeEdge(int node1, int node2);

    /**
     * return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     * return the number of the Vertex in the graph
     * @return hmap.size int
     */
public int nodeSize();

   /**
     * return the number of edges (undirectional graph).
     * Note: this method should run in O(1) time.
     * return the number of the edge in the graph
     * @return edgeSize int
     */
public int edgeSize();

    /**
     * return the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount
     * return the number of the actions in the graph
     * @return modeCount int
     */
public int getMC();



*********_Graph_Algo class function:_*********

The third class is called "Graph_Algo Class".
This class executes algorithmic operations on graphs which were created by "Graphs_DS" (ONLY undirected graphs).
We implement the interface "graph_algorithms" in the code "Graph_Algo" to perform algorithmic operations on different graphs.
The Data Structures which I used is "LinkedList && List" since it is very effective for the algorithms which we use.
In this class we will use the parameters "Tag && Info" which we have in the interface "node_data" which is used in the code "NodeData".
In this class we will perform the following steps:


    /**
     * constructor for Graph_Algo to create new empty graph
     * @return none return
     */
public Graph_Algo();

    /**
     * constructor for Graph_Algo to create object with initialization to the graph
     * @param g graph
     * @return none return
     */
public Graph_Algo(graph g)

    /**
     * Init this set of algorithms on the parameter - graph.
     * that function is to change the value of the graph inside the object
     * @param g
     */
public void init(graph g);

    /**
     * Compute a deep copy of this graph.
     * we run first to add the Vertex from the graph
     * after we run by the Vertex to add all the list of Neighbors to the nodes
     * @return newGraph graph (the new graph)
     */
public graph copy();

    /**
     * Returns true if and only if (iff) there is a valid path from EVREY node to each
     * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
     * is connected : in a given graph if the size of vertexes is equal to 0/1 that means there is an edge between each vertex to another
     * (in case size=1 the vertex is connected to itself by definition).
     * otherwise the BFS algorithm starts with the first vertex in the graph we update the tag of the node in the run
     * after that we run by all the vertex and if we get that the tag is equals to 0 return false
     * else return true
     * @return true if there is a valid path from EVREY node to each' false if isn't
     */
public boolean isConnected();

    /**
     * returns the length of the shortest path between src to dest
     * if the two keys are equals the path is 0
     * if they're not equal we check if the two nodes exist in the graph,
     * in case they don't we explore the graph by BFS and update the tag by the length of the path from source node to the destination node
     * and after Initializing the tag & info values
     * @param src  - start node
     * @param dest - end (target) node
     * @return sortPath sort path in the graph by two vertex
     */
public int shortestPathDist(int src, int dest);

    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * create a new list object
     * if the shortestPathDist function return -1 or 0 so we return empty list
     * if they're equal we check if the two nodes exist in the graph,
     * in case they don't we explore the graph by BFS and update the tag in the length of the path from source node to the destination node
     * and update the info in the path from source node to the destination node
     * after that we split the String and cast every String of the key to int and add the nodes to the list
     * in the end we Initialize the tag & info values of the graph
     * @param src  - start node
     * @param dest - end (target) node
     * @return empty list if the src && dest keys are equals or the that has just one node in the graph,
     * else return the shortest Path from source node to the destination node
     */
public List<node_data> shortestPath(int src, int dest);


    /**
     * Initialize the tag & info values of the graph
     * @param graph
     */
    public void initializationTag(graph graph);
