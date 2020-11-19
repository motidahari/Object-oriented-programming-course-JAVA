package ex1;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.io.IOException;
import java.util.Objects;

public class WGraph_Algo implements weighted_graph_algorithms {

    private weighted_graph graph;
    private LinkedList<node_info> queue;

    /**
     * constructor for Graph_Algo to create new empty graph
     * @return none return
     */
    public WGraph_Algo() {
        this.graph = new WGraph_DS();
    }

    /**
     * constructor for Graph_Algo to create object with initialization to the graph
     * @param g graph
     * @return none return
     */
    public WGraph_Algo(weighted_graph g) {
        if(g != null){
            this.graph = g;
        }else{
            this.graph = new WGraph_DS();
        }
    }

    /**
     * Init the graph on which this set of algorithms operates on.
     * that function is to change the value of the graph inside the object
     * @param g
     */
    @Override
    public void init(weighted_graph g) {
            this.graph = g;
    }

    /**
     * Return the underlying graph of which this class works.
     * @return the graph
     */
    @Override
    public weighted_graph getGraph() {
        return this.graph;
    }

    /**
     * Compute a deep copy of this weighted graph.
     * we run first to add the Vertex from the graph
     * after we run by the Vertex to add all the list of Neighbors to the nodes
     * @return newGraph graph (the new graph)
     */
    @Override
    public weighted_graph copy() {
        weighted_graph newGraph = new WGraph_DS();
            for (node_info node : graph.getV()) { //copy the nodes in the graph
                newGraph.addNode(node.getKey());
                node_info newNode = graph.getNode(node.getKey());
                newGraph.getNode(node.getKey()).setTag(node.getTag());
                newGraph.getNode(node.getKey()).setInfo(node.getInfo());
            }
            for (node_info node : graph.getV()) { //copy the neighbors from the old graph to the new
                for (node_info oldNi : graph.getV(node.getKey())) {
                    newGraph.connect(node.getKey(), oldNi.getKey(), graph.getEdge(node.getKey(), oldNi.getKey()));
                }
            }
        return newGraph;
    }


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
    @Override
    public boolean isConnected() {
        if(graph == null)return true;
        boolean result = true;
        if (graph.nodeSize() <= 1 || graph.getV().size() <= 1) return true;
        initializationTag(graph);
        node_info src = null;
        for (node_info node : graph.getV()){
            src = node;
            break;
        }
        queue = new LinkedList<node_info>();
        queue.add(src);
        src.setTag(-1);
        while (queue.size() != 0) {
            node_info del = queue.poll();
            for (node_info node : graph.getV(del.getKey())) {
                if (node.getTag() >= 0) {
                    queue.add(node);
                    node.setTag(-1);
                }
            }
        }
        for (node_info node : graph.getV()) {
            if(node.getTag() == 0 ){
                result = false;
                break;
            }
        }
        initializationTag(graph);
        return result;
    }

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
    @Override
    public double shortestPathDist(int src, int dest) {
        if((graph.getNode(src) == null || graph.getNode(dest) == null)){
            return -1;
        }
        if (src == dest && graph.getNode(src) != null) return 0;
        for (node_info n : graph.getV()){
            n.setTag(Integer.MAX_VALUE);
        }
        node_info src2, dest2;
        if ((src2 = graph.getNode(src)) != null && (dest2 = graph.getNode(dest)) != null) {
            for (node_info n : graph.getV()){
                n.setTag(Integer.MAX_VALUE);
            }
            queue = new LinkedList<node_info>();
            queue.add(src2);
            src2.setTag(0);
            while (queue.size() != 0) {
                node_info del = queue.poll();
                for (node_info node : graph.getV(del.getKey())) {
                    if (node.getTag() == Integer.MAX_VALUE ){
                        queue.add(node);
                    }
                    if (node.getTag() >= (del.getTag() + graph.getEdge(del.getKey(),node.getKey()))) {
                        node.setTag(del.getTag() + graph.getEdge(del.getKey(),node.getKey()));
                    }
                }
            }
        }else{
            return -1;
        }
        if(dest2.getTag() == Integer.MAX_VALUE){
            return -1;
        }
        return graph.getNode(dest).getTag();
    }

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


    @Override
    public List<node_info> shortestPath(int src, int dest) {
        double dist = shortestPathDist(src,dest);
        queue = new LinkedList<node_info>();
        if(dist == 0){
            queue.addFirst(graph.getNode(src));
            return queue;
        }else if(dist == -1){
            return queue;
        }else{
            node_info temp = graph.getNode(dest);
            do {
                for (node_info ni : graph.getV(temp.getKey())){
                   if(ni.getTag() + graph.getEdge(ni.getKey(),temp.getKey()) == temp.getTag() ){
                       queue.addFirst(temp);
                       temp = ni;
                   }
                }
            }while (temp.getTag() != 0);
            queue.addFirst(temp);

        }
        return queue;
    }

    /**
     * Saves this weighted (undirected) graph to the given
     * file name
     * we create a new file we the object of the fraph
     * @param file - the file name (may include a relative path).
     * @return true - iff the file was successfully saved
     */
    @Override
    public boolean save(String file){
        try {
            FileOutputStream fileOut = new FileOutputStream(file + ".txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(graph);
            out.close();
            fileOut.close();
            //System.out.printf("Serialized data is saved in " + file);
            return true;
        }catch ( IOException e) {
            e.printStackTrace();
            return false;
        }
    }

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
    @Override
    public boolean load(String file) {
        try{
            InputStream fileInput = new FileInputStream("\\" +file + ".txt");
            InputStream buffer = new BufferedInputStream(fileInput);
            ObjectInput input = new ObjectInputStream (buffer);
            graph = (weighted_graph) input.readObject();
            fileInput.close();
            buffer.close();
            return true;
        }
        catch(IOException e ){
            return false;
        }catch(ClassNotFoundException e){
            return false;
        }
    }

    private String getGraph2(weighted_graph graph) {
        int a = 0;
        String str = "";
        for (node_info vertex : graph.getV()){
            str += vertex.getKey()+" ";
            for (node_info vertexNi : graph.getV(vertex.getKey())){
                if(a == 0){
                    str += "" + vertexNi.getKey() + "," + graph.getEdge(vertexNi.getKey(), vertex.getKey()) +" ";
                }else {
                    str += " " + vertexNi.getKey() + "," + graph.getEdge(vertexNi.getKey(), vertex.getKey()) +"";
                }
                a++;
            }
            str += "\n";
            a = 0;
        }
        return str;
    }
    /**
     * return String of the graph
     * @return str of the graph
     */
    private String getGraph(weighted_graph graph) {
        int a = 0;
        String str = "";
        for (node_info vertex : graph.getV()){
            str += vertex.getKey()+" Ni --> [";
            for (node_info vertexNi : graph.getV(vertex.getKey())){
                if(a == 0){
                    str += "{key = " + vertexNi.getKey() + " , weight = " + graph.getEdge(vertexNi.getKey(), vertex.getKey()) +"}";
                }else {
                    str += ",{key = " + vertexNi.getKey() + " , weight = " + graph.getEdge(vertexNi.getKey(), vertex.getKey()) +"}";
                }
                a++;
            }
            str += "]\n";
            a = 0;
        }
        return str;
    }
    /**
     * Initialize the tag & info values of the graph
     * @param graph
     */
    private void initializationTag(weighted_graph graph){
        for (node_info node : graph.getV()) {
            node.setTag(0);
            node.setInfo("");
        }
    }


    /**
     * function to check equals by graphs
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WGraph_Algo that = (WGraph_Algo) o;
        return graph.equals(that.graph) &&
                queue.equals(that.queue);
    }
    /**
     * function to check equals by data struc
     **/
    @Override
    public int hashCode() {
        return Objects.hash(graph, queue);
    }
}
