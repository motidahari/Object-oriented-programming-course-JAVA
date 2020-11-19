package ex0;
import java.util.LinkedList;
import java.util.List;

public class Graph_Algo implements graph_algorithms {
    private graph graph;
    private LinkedList<node_data> queue;
    private List<node_data> list;

    /**
     * constructor for Graph_Algo to create new empty graph
     * @return none return
     */
    public Graph_Algo() {
        this.graph = new Graph_DS();
    }


    /**
     * constructor for Graph_Algo to create object with initialization to the graph
     * @param g graph
     * @return none return
     */
    public Graph_Algo(graph g) {
        if(g != null){
            this.graph = g;
        }else{
            this.graph = new Graph_DS();
        }
    }

    /**
     * Init this set of algorithms on the parameter - graph.
     * that function is to change the value of the graph inside the object
     * @param g
     */
    @Override
    public void init(graph g) {
        if(g != null){
            this.graph = g;
        }else{
            this.graph = new Graph_DS();
        }
    }

    /**
     * Compute a deep copy of this graph.
     * we run first to add the Vertex from the graph
     * after we run by the Vertex to add all the list of Neighbors to the nodes
     * @return newGraph graph (the new graph)
     */
    @Override
    public graph copy() {
        graph newGraph = new Graph_DS();
        for (node_data node : graph.getV()) { //copy the nodes in the graph
            node_data newNode = new NodeData(node.getKey());
            newNode.setInfo(node.getInfo());
            newNode.setTag(node.getTag());
            newGraph.addNode(newNode);
        }
        for (node_data node : graph.getV()) { //copy the neighbors from the old graph to the new
            for (node_data oldNi : node.getNi()) {
                newGraph.connect(node.getKey(), oldNi.getKey());
            }
        }
        return newGraph;
    }

    /**
     * Returns true if and only if there is a valid path from EVREY node to each
     * other node. NOTE: assume directional graph - a valid path (a-->b) does NOT imply a valid path (b-->a).
     * is connected : in a given graph if the size of vertexes is equal to 0/1 that means
     * there is an edge between each and every vertex to another
     * (in case size=1 the vertex is connected to itself by definition).
     * otherwise the BFS algorithm starts with the first vertex in the graph we update the tag of the node in the run
     * after that we run by all the vertex and if we get that the tag is equals to 0 return false
     * else return true
     * @return true if there is a valid path from EVREY node to each' false if isn't
     */
    @Override
    public boolean isConnected() {
        boolean result = true;
        if (graph.getV().size() <= 1) return true;
        node_data src = null;
        for (node_data node : graph.getV()){
            src = node;
            break;
        }
        queue = new LinkedList<node_data>();
        queue.add(src);
        src.setTag(-1);
        while (queue.size() != 0) {
            node_data del = queue.poll();
            for (node_data node : graph.getV(del.getKey())) {
                if (node.getTag() >= 0) {
                    queue.add(node);
                    node.setTag(-1);
                }
            }
        }
        for (node_data node : graph.getV()) {
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
     * if the two keys are equals the path is 0
     * if they're not equal we check if the two nodes exist in the graph,
     * in case they don't we explore the graph by BFS and update the tag by the length of the path from source node to the destination node
     * and after Initializing the tag & info values
     * @param src  - start node
     * @param dest - end (target) node
     * @return sortPath sort path in the graph by two vertex
     */
    @Override
    public int shortestPathDist(int src, int dest) {
        if (src == dest && graph.getNode(src) != null) return 0;
        node_data src2, dest2;
        int path = 0;
        int sortPath = -1;
        if ((src2 = graph.getNode(src)) != null && (dest2 = graph.getNode(dest)) != null) {
            int numV = graph.getV().size();
            queue = new LinkedList<node_data>();
            queue.add(src2);
            src2.setTag(src2.getTag());
            while (queue.size() != 0) {
                node_data del = queue.poll();
                path++;
                for (node_data node : graph.getV(del.getKey())) {
                    if (node.getTag() == 0) {
                        queue.add(node);
                        node.setTag(del.getTag() + 1);
                        if (node.getKey() == dest) {
                            sortPath = node.getTag();
                        }
                    }
                }
            }
        }
        initializationTag(graph);
        return sortPath;
    }

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
    @Override
    public List<node_data> shortestPath(int src, int dest) {
        int temp = 0;
        if ((temp = shortestPathDist(src, dest)) < 0) {
            return null;
        }else if(temp == 0){
            list = new LinkedList<node_data>();
            list.add(graph.getNode(src));
            return list;
        }else {
            list = new LinkedList<node_data>();
            node_data src2, dest2;
            int path = 0;
            int sortPath = -1;
            if ((src2 = graph.getNode(src)) != null && (dest2 = graph.getNode(dest)) != null) {
                int numV = graph.getV().size();
                queue = new LinkedList<node_data>();
                queue.add(src2);
                src2.setTag(src2.getTag());
                src2.setInfo("" + src2.getKey());
                while (queue.size() != 0) {
                    node_data del = queue.poll();
                    path++;
                    for (node_data node : graph.getV(del.getKey())) {
                        if (node.getTag() == 0) {
                            queue.add(node);
                            node.setTag(del.getTag() + 1);
                            node.setInfo(del.getInfo() + " -> " + node.getKey());
                            if (node.getKey() == dest) {
                                sortPath = node.getTag();
                            }
                        }
                    }
                }
            }
            String[] split = graph.getNode(dest).getInfo().split(" -> ");
            if (split.length > 0) {
                for (int i = 0; i < split.length; i++) {
                    int x = Integer.parseInt(split[i]);
                    list.add(graph.getNode(x));
                }
            }
            initializationTag(graph);
        }
        return list;
    }

    /**
     * Initialize the tag & info values of the graph
     * @param graph
     */
    public void initializationTag(graph graph){
        for (node_data node : graph.getV()) {
            node.setTag(0);
            node.setInfo("");
        }
    }
}