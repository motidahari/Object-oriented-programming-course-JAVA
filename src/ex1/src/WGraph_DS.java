package ex1.src;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Objects;

public class WGraph_DS implements weighted_graph, Serializable{

    private int modeCount, edgeSize = 0;
    private HashMap<Integer, node_info> hmapNodes ;
    private HashMap<Integer, HashMap<Integer, Double>> hmapEdgesWeight;
    private HashMap<Integer, HashMap<Integer, node_info>> hmapNi;


    /**
     * constructor for WGraph_DS to create new empty hashMap(Vertex) for the graph
     * @return none return
     */
    public WGraph_DS() {
        hmapNi = new HashMap<Integer, HashMap<Integer, node_info>>();
        hmapNodes = new HashMap<Integer, node_info>();
        hmapEdgesWeight = new HashMap<Integer, HashMap<Integer, Double>>();
        this.modeCount = 0;
    }


    /**
     * return the NodeInfo by the node_id,
     * check if has Vertex in the graph by node key
     * @param key - the node_id
     * @return the NodeInfo by the node_id, null if none.
     */
    @Override
    public node_info getNode(int key) {
        if(hmapNodes.containsKey(key) && hmapNi.containsKey(key) && hmapEdgesWeight.containsKey(key) && key >= 0){
            return hmapNodes.get(key);
        }
        return null;
    }


    /**
     * return true iff (if and only if) there is an edge between node1 and node2
     * Note: this method should run in O(1) time.
     * check if has two Vertex in the graph by node1 key && node2 key
     * if the two nodes are exist we check if to node1 has Neighbor node2 && to node2 has Neighbor node1
     * @param node1
     * @param node2
     * @return true if are they Neighbors from both sides false if they don't have
     */
    @Override
    public boolean hasEdge(int node1, int node2) {
        return  hmapNodes.containsKey(node1) &&
                hmapEdgesWeight.containsKey(node1) &&
                hmapNi.containsKey(node1) &&
                hmapNodes.containsKey(node2) &&
                hmapEdgesWeight.containsKey(node2) &&
                hmapNi.containsKey(node2) &&
                node1 != node2 &&
                hmapNi.get(node1).containsKey(node2) &&
                hmapNi.get(node2).containsKey(node1) &&
                hmapEdgesWeight.get(node1).containsKey(node2) &&
                hmapEdgesWeight.get(node2).containsKey(node1);
    }

    /**
     * return the weight if the edge (node1, node1). In case
     * there is no such edge - should return -1
     * Note: this method should run in O(1) time.
     *  we check if node1 && node2 are Neighbors
     * @param node1
     * @param node2
     * @return the edge between 2 node (double), -1 if there no edge
     */
    @Override
    public double getEdge(int node1, int node2) {
        if(hasEdge(node1, node2)){
            return hmapEdgesWeight.get(node1).get(node2);
        }
        return -1;
    }

    /**
     * add a new node to the graph with the given NodeInfo.
     * Note: this method should run in O(1) time.
     * Note2: if there is already a node with such a key -> no action should be performed.
     * check if Vertex in the graph by node key if the graph does not have such a vertex
     * so we add the Vertex to the graph and we update the size & modeCount
     * else Doing nothing
     * @param key NodeInfo
     *
     */
    @Override
    public void addNode(int key) {
        if(!hmapNodes.containsKey(key) && !hmapNi.containsKey(key) && !hmapEdgesWeight.containsKey(key) && key >= 0){
            node_info newNode = new NodeInfo(key);
            int size = hmapNodes.size() + hmapNi.size() + hmapEdgesWeight.size();
            hmapNodes.put(key, newNode);
            hmapNi.put(key, new HashMap<Integer, node_info>());
            hmapEdgesWeight.put(key, new HashMap<Integer, Double>());
            if(size < hmapNodes.size() + hmapNi.size() + hmapEdgesWeight.size()){
                size++;
                modeCount++;
            }
        }
    }


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
    @Override
    public void connect(int node1, int node2, double w) {
        if(node1 == node2)  return;
        if(hmapNodes.get(node1) != null && hmapNodes.get(node2) != null ){
            if(hasEdge(node1, node2)){
                if(getEdge(node1, node2) != w){
                    hmapEdgesWeight.get(node1).put(node2,w);
                    hmapEdgesWeight.get(node2).put(node1,w);
                    modeCount++;
                }
            }else{
                int size =  hmapEdgesWeight.get(node1).size() + hmapEdgesWeight.get(node1).size() + hmapNi.get(node1).size() + hmapNi.get(node1).size();
                hmapEdgesWeight.get(node1).put(node2,w);
                hmapEdgesWeight.get(node2).put(node1,w);
                hmapNi.get(node1).put(node2,hmapNodes.get(node2));
                hmapNi.get(node2).put(node1,hmapNodes.get(node1));
                if(size < hmapEdgesWeight.get(node1).size() + hmapEdgesWeight.get(node1).size() + hmapNi.get(node1).size() + hmapNi.get(node1).size()){
                    modeCount++;
                    edgeSize++;
                }
            }

        }
    }

    /**
     * This method return a pointer (shallow copy) for a
     * Collection representing all the nodes in the graph.
     * Note: this method should run in O(1) tim
     * return all Vertex in the graph
     * @return Collection<node_info>
     */
    @Override
    public Collection<node_info> getV() {
        return hmapNodes.values();
    }

    /**
     * This method returns a Collection containing all the
     * nodes connected to node_id
     * Note: this method should run in O(1) time.
     * check if Vertex in the graph by node key if to the graph has such a vertex
     * so we return the Neighbors by the node key
     * else return null
     * @param node_id
     * @return Collection<NodeInfo> or null if the node isn't exist
     */
    @Override
    public Collection<node_info> getV(int node_id) {
        if(hmapNi.containsKey(node_id) && node_id >= 0){
            return hmapNi.get(node_id).values();
        }
        return null;
    }


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
    @Override
    public node_info removeNode(int key) {
        if(hmapNodes.containsKey(key) && hmapNi.containsKey(key) && hmapEdgesWeight.containsKey(key) && key >= 0){
            int size = hmapNodes.size();
            node_info del;
            if( (del = hmapNodes.get(key)) != null){
                for(node_info node : hmapNi.get(key).values()){
                    if(hasEdge(node.getKey(), key)){
                        //removeEdge(node.getKey() , del.getKey());
                        hmapNi.get(node.getKey()).remove(key);
                        modeCount++;
                    }
                }
            }
            int removeEdge = hmapNi.get(key).values().size();
            del = hmapNodes.remove(key);
            hmapNi.remove(key);
            hmapEdgesWeight.remove(key);

            if(size > hmapNodes.size()){
                modeCount++;
                edgeSize -= removeEdge;
                return del;
            }
        }
        return null;
    }


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
    @Override
    public void removeEdge(int node1, int node2) {
        if(hasEdge(node1, node2)){
            int size = hmapEdgesWeight.get(node1).size() + hmapEdgesWeight.get(node2).size() + hmapNi.get(node2).size() + hmapNi.get(node1).size();
            hmapEdgesWeight.get(node1).remove(node2);
            hmapEdgesWeight.get(node2).remove(node1);
            hmapNi.get(node1).remove(node2);
            hmapNi.get(node2).remove(node1);
            if(size > hmapEdgesWeight.get(node1).size() + hmapEdgesWeight.get(node2).size() + hmapNi.get(node2).size() + hmapNi.get(node1).size()){
                modeCount++;
                edgeSize--;
            }
        }
    }

    /**
     * return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     * return the number of the Vertex in the graph
     * @return hmap.size int, else return 0
     */
    @Override
    public int nodeSize() {
        if (hmapNodes != null){
            return this.hmapNodes.size();
        }
        return 0;
    }

    /**
     * return the number of edges (undirectional graph).
     * Note: this method should run in O(1) time.
     * return the number of the edge in the graph
     * @return edgeSize int
     */
    @Override
    public int edgeSize() {
        return this.edgeSize;
    }

    /**
     * return the number of the actions in the graph
     * @return modeCount int
     */
    @Override
    public int getMC() {
        return this.modeCount;
    }

    /**
     * get all data by the graph
     * @return data by graph
     */
    @Override
    public String toString() {
        String str = "";
        for (Integer x : hmapEdgesWeight.keySet()) {
            str += "" + x + " --> [";
            for (Integer i : hmapEdgesWeight.get(x).keySet()) {
//                NodeInfo n = new NodeInfo((NodeInfo) i);
                str += i.toString() + " (" + hmapEdgesWeight.get(x).get(i) + ") , ";//EdgeMap.get(x).keySet().toString() + " \n ";
            }
            str += "] \n";
        }
        return str + " ";
    }

    /**
     * function to check equals by Data Structure
     **/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WGraph_DS wGraph_ds = (WGraph_DS) o;
        return modeCount == wGraph_ds.modeCount &&
                edgeSize == wGraph_ds.edgeSize &&
                hmapNodes.equals(wGraph_ds.hmapNodes) &&
                hmapEdgesWeight.equals(wGraph_ds.hmapEdgesWeight) &&
                hmapNi.equals(wGraph_ds.hmapNi);
    }
    /**
     * function to check equals by Data Structure
     **/
    @Override
    public int hashCode() {
        return Objects.hash(modeCount, edgeSize, hmapNodes, hmapEdgesWeight, hmapNi);
    }

    private class NodeInfo implements node_info, Serializable{
        private int key;
        private double tag;
        private int countIndex = 0;
        private String info;

        /**
         * constructor for NodeInfo to create new empty hashMap for the Neighbors
         * @param
         * @return none return
         */
        public NodeInfo(){
            this.tag = 0 ;
            this.info = "";
            this.key = countIndex++;
        }
        /**
         * constructor for NodeInfo to create new empty hashMap for the Neighbors with specific key
         * @param key of the node
         * @return none return
         */
        public NodeInfo(int key){
            this.tag = 0;
            this.info = "";
            this.countIndex = key;
            this.key = countIndex++;
        }
        /**
         * Return the key (id) associated with this node.
         * Note: each NodeInfo should have a unique key.
         * @return this.key
         */
        @Override
        public int getKey() {
            return this.key;
        }

        /**
         * return the remark (meta data) associated with this node.
         * we use in the info to the path in the class GraphAlgo
         * @return info String
         */
        @Override
        public String getInfo() {
            return this.info;
        }

        /**
         * Allows changing the remark (meta data) associated with this node.
         *  change the value of the info
         * @param s String
         */
        @Override
        public void setInfo(String s) {
            this.info = s;
        }

        /**
         * Temporal data (aka color: e,g, white, gray, black)
         * which can be used be algorithms
         * we use on the tag param to count the path in the class GraphAlgo
         * @return tag int
         */
        @Override
        public double getTag() {
            return this.tag;
        }

        /**
         * Allow setting the "tag" value for temporal marking an node - common
         * practice for marking by algorithms.
         * update the value of the tag
         * @param t - the new value of the tag
         */
        @Override
        public void setTag(double t) {
            this.tag = t;
        }

        /**
         * get all data by node
         * @return str - data by node
         */
        @Override
        public String toString() {
            return "NodeInfo{" +
                    "key=" + key +
                    ", tag=" + tag +
                    ", info='" + info + '\'' +
                    '}';
        }
        /**
         * function to check equals by Data Structure
         **/
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            NodeInfo nodeInfo = (NodeInfo) o;
            return key == nodeInfo.key &&
                    Double.compare(nodeInfo.tag, tag) == 0 &&
                    countIndex == nodeInfo.countIndex &&
                    info.equals(nodeInfo.info);
        }
        /**
         * function to check equals by Data Structure
         **/
        @Override
        public int hashCode() {
            return Objects.hash(key, tag, countIndex, info);
        }
    }
}
