src Readme.
**********************************_Introduction_**********************************
@author Moti Dahari
@ID: 308212570

To run the project, go to the tests folder. run the project from the file WGraph_AlgoTest or WGraph_DSTest.
In this project we will implement the interfaces.
There are three classes which we will use in order to implement the interfaces.
(We will elaborate each class by it's section)


**********************************_functions implements_**********************************”

*********_NodeInfo class function:_*********

The first class is called "NodeInfo Class".
This class represents the individual Vertex and all it's connector's by implementing the interface "node_info" in the code "NodeInfo".
In this class we will perform the following steps:


        /**
         * constructor for NodeInfo to create new empty hashMap for the Neighbors
         * @param
         * @return none return
         */
        public NodeInfo();
        
        
        /**
         * constructor for NodeInfo to create new empty hashMap for the Neighbors with specific key
         * @param key of the node
         * @return none return
         */
        public NodeInfo(int key);
        
        
        /**
         * Return the key (id) associated with this node.
         * Note: each node_data should have a unique key.
         * @return this.key
         */
   
        public int getKey();

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
   
        public double getTag();

        /**
         * Allow setting the "tag" value for temporal marking an node - common
         * practice for marking by algorithms.
         * update the value of the tag
         * @param t - the new value of the tag
         */
   
        public void setTag(double t);

        /**
         * get all data by node
         * @param node - the new value of the tag
         */
   
        public String toString();

*********_WGraph_DS classs function:_*********


The second class is called "WGraph_DS Class".
This class represents all Vertexes which are what make our graph.
This graph is called "Undirected Graph".
This class creates a graph from each individual vertex (node) by implement the interface "weighted_graph"
in the code "WGraph_DS" to create the graph itself.
The 3 Data Structures which I used is "HashMap" since it is very effective.
one HashMap is represent for the Vertexes in the graph
second HashMap is "HashMap in HashMap" is for Neighbors by some vertex.
Third HashMap is "HashMap in HashMap" for the edge between one vertex to is Neighbors.
In this class we will perform the following steps:


    /**
     * constructor for WGraph_DS to create new empty hashMap(Vertex) for the graph
     * @return none return
     */
    public WGraph_DS();


    /**
     * return the node_data by the node_id,
     * check if has Vertex in the graph by node key
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    public node_info getNode(int key);


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
     * return the weight if the edge (node1, node1). In case
     * there is no such edge - should return -1
     * Note: this method should run in O(1) time.
     *  we check if node1 && node2 are Neighbors
     * @param node1
     * @param node2
     * @return the edge between 2 node (double), -1 if there no edge
     */
    public double getEdge(int node1, int node2);


    /**
     * add a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     * Note2: if there is already a node with such a key -> no action should be performed.
     * check if Vertex in the graph by node key if the graph does not have such a vertex
     * so we add the Vertex to the graph and we update the size & modeCount
     * else Doing nothing
     * @param key node_data
     *
     */
    public void addNode(int key);


    /**
     * Connect an edge between node1 and node2, with an edge with weight >=0.
     * Note: this method should run in O(1) time.
     * Note2: if the edge node1-node2 already exists - the method simply updates the weight of the edge.
     * check if has two Vertex in the graph by node1 key && node2 key
     * if the two nodes are exist we check if to node1 has Neighbor node2 || to node2 has Neighbor node1
     * if one of the vertices does not have the other neighbor we connect them and update the edgeSize && modeCount
     * @param node1
     * @param node2
     */
    public void connect(int node1, int node2, double w);

    /**
     * This method return a pointer (shallow copy) for a
     * Collection representing all the nodes in the graph.
     * Note: this method should run in O(1) tim
     * return all Vertex in the graph
     * @return Collection<node_info>
     */
    public Collection<node_info> getV();

    /**
     * This method returns a Collection containing all the
     * nodes connected to node_id
     * Note: this method should run in O(1) time.
     * check if Vertex in the graph by node key if to the graph has such a vertex
     * so we return the Neighbors by the node key
     * else return null
     * @param node_id
     * @return Collection<node_data> or null if the node isn't exist
     */
    public Collection<node_info> getV(int node_id);


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
    public node_info removeNode(int key);


    /**
     * Delete the edge from the graph,
     * Note: this method should run in O(1) time.
     * check if has two Vertex in the graph by node1 key && node2 key with the func hasEdge
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
     * @return hmap.size int, else return 0
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
     * return the number of the actions in the graph
     * @return modeCount int
     */
    public int getMC();

    /**
     * get all data by the graph
     * @return data by graph
     */
    public String toString();

*********_Graph_Algo class function:_*********

The third class is called "Graph_Algo Class".
This class executes algorithmic operations on graphs which were created by "WGraph_DS" (ONLY undirected graphs).
We implement the interface "weighted_graph_algorithms" in the code "WGraph_Algo" to perform algorithmic operations on different graphs.
The Data Structures which I used is "LinkedList && List" since it is very effective for the algorithms which we use.
In this class we will use the parameters "Tag && Info" which we have in the interface "node_info" which is used in the code "NodeInfo".
In this class we will perform the following steps:


    /**
     * constructor for Graph_Algo to create new empty graph
     * @return none return
     */
    public WGraph_Algo();


    /**
     * constructor for Graph_Algo to create object with initialization to the graph
     * @param g graph
     * @return none return
     */
    public WGraph_Algo(weighted_graph g);


    /**
     * Init the graph on which this set of algorithms operates on.
     * that function is to change the value of the graph inside the object
     * @param g
     */
    public void init(weighted_graph g);


    /**
     * Return the underlying graph of which this class works.
     * @return the graph
     */
    public weighted_graph getGraph();


    /**
     * Compute a deep copy of this weighted graph.
     * we run first to add the Vertex from the graph
     * after we run by the Vertex to add all the list of Neighbors to the nodes
     * @return newGraph graph (the new graph)
     */
    public weighted_graph copy();


    /**
     * Returns true if and only if (iff) there is a valid path from EVREY node to each
     * other node. NOTE: assume ubdirectional graph.
     * is connected : in a given graph if the size of vertexes is equal to 0/1 that means
     * there is an edge between each and every vertex to another
     * (in case size=1 the vertex is connected to itself by definition).
     * otherwise the Dijkstra's algorithm starts with the first vertex in the graph we update the tag of the node in the run
     * after that we run by all the vertex and if we get that the tag is equals to 0 return false
     * else return true
     * @return true if there is a valid path from EVREY node to each' false if isn't
     */
    public boolean isConnected() ;


    /**
     * returns the length of the shortest path between src to dest
     * Note: if no such path --> returns -1
     * if the shortestPathDist function return -1 we return null
     * if src equal to dest and the vertex in the graph the length of the path is 0
     * else we check if the two nodes exist in the graph,
     * in case they exist in the graph we run by Dijkstra's and update the tag in the length of the path
     * from source node to the destination node
     * @param src  - start node
     * @param dest - end (target) node
     * @return double of the weights by the path from src to dest if there is no path from src to dest return -1
     */
    public double shortestPathDist(int src, int dest);


    /**
     * returns the the shortest path between src to dest - as an ordered List of nodes:
     * src--> n1-->n2-->...dest
     * see: https://en.wikipedia.org/wiki/Shortest_path_problem
     * Note if no such path --> returns null;
     * create a new list object
     * if the shortestPathDist function return -1 we return null
     * if the shortestPathDist function return 0 we return list we one node
     * we check if the two nodes exist in the graph,
     * in case they don't we explore the graph by Dijkstra's and update the tag in the length of the path
     * from source node to the destination node
     * after that we compare the tag of dest with the value of the neighbors + the weight value, if they are equals so
     * is the correct path and we add the node to the list
     * @param src  - start node
     * @param dest - end (target) node
     * @return empty list if error, else if the src && dest keys are equals we retuen list with one node,
     * else we return the list from path to dest
     */
    public List<node_info> shortestPath(int src, int dest);

    /**
     * Saves this weighted (undirected) graph to the given
     * file name
     * we create a new file we the object of the fraph
     * @param file - the file name (may include a relative path).
     * @return true - iff the file was successfully saved
     */
    public boolean save(String file);

    /**
     * This method load a graph to this graph algorithm.
     * if the file was successfully loaded - the underlying graph
     * of this class will be changed (to the loaded one), in case the
     * graph was not loaded the original graph should remain "as is".
     * we create a new graph from the object in txt file
     * if that success so we update the new graph to this class ' els we keep the old graph
     * @param file - file name
     * @return true - iff the graph was successfully loaded.
     */
    public boolean load(String file) ;

    
    /**
     * return String of the graph
     * @return str of the graph
     */
    private String getGraph(weighted_graph graph);
   
   
    /**
     * Initialize the tag & info values of the graph
     * @param graph
     */
    private void initializationTag(weighted_graph graph);
    
    
    
*********_WGraph_AlgoTest class function:_*********

The Fourth class is called "WGraph_AlgoTest Class".
This class is designed to check the class of WGraph_Algo
In this class we will perform the following steps:


    /**
     * create graph with 0 vertex and check every function in the class
     **/
    @Test
    void test1();
    
    /**
     * create graph with 1 vertex and check every function in the class
     **/
    @Test
    void test2() ;
    
    /**
     * create graph with 50 vertex and check every function in the class
     **/
    @Test
    void test3() ;
    
    /**
     * create graph with 10 vertex and check every function in the class
     **/
    @Test
    void test4() ;
    
    /**
     * create graph with 9 vertex and check every function in the class
     **/
    @Test
    void test5() ;
    
    /**
     * create graph with 10 vertex and check every function in the class
     **/
    @Test
    void test6() ;
    
    /**
     * create graph with 10 vertex and check every function in the class
     **/
    @Test
    void test7() ;
    
    /**
     * create graph with 50 vertex and check every function in the class
     **/
    @Test
    void test8 ();
    
    /**
     * create graph with 1000000 vertex and check every function in the class
     **/
    @Test
    void test9();
    


    /**
     * check for init
     **/
    void init(weighted_graph g1);
    

    /**
     * check for getGraph
     **/
    void getGraph(weighted_graph g);
    
    /**
     * check for copy
     **/
    void copy( weighted_graph g );
    
    /**
     * check for isConnected
     **/
    void isConnected(weighted_graph g, boolean flag);
    
    /**
     * check for shortestPathDist
     **/
    void shortestPathDist(weighted_graph g, int src, int dest, double ans);
    
    /**
     * check for shortestPath
     **/
    void shortestPath(weighted_graph g, List<node_info> list, int src, int dest);
    
    /**
     * check for save
     **/
    void save(weighted_graph g , String path, String nameFile);
    
    /**
     * check for saveWithTry
     **/
    void saveWithTry(weighted_graph g);
    
    /**
     * check for loadWithTry
     **/
    void loadWithTry(weighted_graph g);
    
    /**
     * check for load
     **/
    void load(weighted_graph g , String path, String nameFile) ;
    

*********_WGraph_DSTest class function:_*********

The Fifth class is called "WGraph_DSTest Class".
This class is designed to check the class of WGraph_DS
In this class we will perform the following steps:

    /**
     * create graph with 0 vertex and check every function in the class
     **/
    @Test
    void test1();
    
    /**
     * create graph with 1 vertex and check every function in the class
     **/
    @Test
    void test2() ;
    
    /**
     * create graph with 50 vertex and check every function in the class
     **/
    @Test
    void test3() throws IOException;
    
    /**
     * create graph with 10 vertex and check every function in the class
     **/
    @Test
    void test4() ;
    
    /**
     * create graph with 9 vertex and check every function in the class
     **/
    @Test
    void test5() ;
    
    /**
     * create graph with 10 vertex and check every function in the class
     **/
    @Test
    void test6();
    
    /**
     * create graph with 10 vertex and check every function in the class
     **/
    @Test
    void test7();
    
    /**
     * create graph with 50 vertex and check every function in the class
     **/
    @Test
    void test8 ();
    
    /**
     * create graph with 1000000 vertex and check every function in the class
     **/
    @Test
    void test9();
    
    /**
     * check for getNode
     **/
    void getNode(weighted_graph graph, int key);
    
    /**
     * check for hasEdge
     **/
    void hasEdge(boolean flag, weighted_graph graph, int node1, int node2);
    
    /**
     * check for getEdge
     **/
    void getEdge(weighted_graph graph, int node1, int node2, double weight);
    
    /**
     * check for addNode
     **/
    void addNode(weighted_graph graph, int node1);
    
    /**
     * check for connect
     **/
    void connect(weighted_graph graph, int node1, int node2, double weight);
    
    /**
     * check for getV
     **/
    void getV(weighted_graph graph, int numV);
    
    /**
     * check for removeNode
     **/
    void removeNode(weighted_graph graph, int node1);
    
    /**
     * check for removeEdge
     **/
    void removeEdge(weighted_graph graph, int node1, int node2);
    
    /**
     * check for nodeSize
     **/
    void nodeSize(weighted_graph graph, int nodeSize);
    
    /**
     * check for edgeSize
     **/
    void edgeSize(weighted_graph graph, int edgeSize);
    
    /**
     * check for getMC
     **/
    void getMC(weighted_graph graph, int MC);
    
    
*********_functionForTests class function:_*********

The sixth class is called "functionForTests Class".
This class Represents Functions for our tests
In this class we will perform the following steps:


    /**
     * get random int
     **/
    private static int nextRnd(int min, int max);
    
    /**
     * get random double
     **/
    private static double nextRnd(double min, double max);
    
    /**
     * get array of nodes by some graph
     **/
    private static int[] nodes(weighted_graph g);
    
    /**
     * create a new graph with num vertex, num edges and num seed
     **/
    public static weighted_graph graph_creator(int v_size, int e_size, int seed);
    
    /**
     * get graph and print it
     **/
    public static void printGraph(weighted_graph graph);

    /**
     * get graph and all the vertex in the graph
     **/
    public static void printVInGraph(weighted_graph graph);
    
    /**
     * get string of all the Neighbors
     **/
    public static String printNi2(Collection<node_info> node);
    
    /**
     * run by list and print the path
     **/
    public static void printListOfPath(List<node_info> list, int a, int b);
    
    /**
     * check equals by 2 graphs
     **/
    public static boolean checkEqualsByGraph(weighted_graph g1, weighted_graph g2);
    
    /**
     * create graph with num of vertex
     **/
    public static weighted_graph graph_creator2(int size);
    
    /**
     * check equels by 2 strings
     **/
    public static boolean checkVal(String result, String result3);
    
    /**
     * create graph and connect every node to the 15 first nodes
     **/
    public static weighted_graph createGraphAndConnect(int size);

}

