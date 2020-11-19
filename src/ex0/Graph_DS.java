package ex0;
import java.util.Collection;
import java.util.HashMap;


public class Graph_DS implements graph {
    private int key, size, tag, modeCount, edgeSize = 0;
    private String info;
    private HashMap<Integer, node_data> hmap;

    /**
     * constructor for Graph_DS to create new empty hashMap(Vertex) for the graph
     * @return none return
     */
    public Graph_DS() {
        hmap = new HashMap<Integer, node_data>();
        this.key = this.modeCount = this.size = 0;
    }


    /**
     * return the node_data by the node_id,
     * check if has Vertex in the graph by node key
     * @param key - the node_id
     * @return the node_data by the node_id, null if none.
     */
    @Override
    public node_data getNode(int key) {
        if (hmap.containsKey(key)) {
            return hmap.get(key);
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
        if (hmap.containsKey(node1) && hmap.containsKey(node2)) {
            if ((getNode(node1)).hasNi(node2) && (getNode(node2)).hasNi(node1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * add a new node to the graph with the given node_data.
     * Note: this method should run in O(1) time.
     * check if Vertex in the graph by node key if to the graph does not have such a vertex
     * so we add the Vertex to the graph and we update the size & modeCount
     * else Doing nothing
     * @param n node_data
     *
     */
    @Override
    public void addNode(node_data n) {
        if (!hmap.containsKey(n.getKey())) {
            int size = hmap.size();
            hmap.put(n.getKey(), n);
            if (size < hmap.size()) {
                size++;
                modeCount++;
                key++;
            }
        }
    }

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
    @Override
    public void connect(int node1, int node2) {
        if ((hmap.containsKey(node1) && hmap.containsKey(node2)) && node1 != node2) {
            int size = getNode(node1).getNi().size() + getNode(node2).getNi().size();
            if (!getNode(node1).hasNi(node2) || !getNode(node2).hasNi(node1)) {
                (getNode(node1)).addNi(getNode(node2));
                (getNode(node2)).addNi(getNode(node1));
                if (size < hmap.get(node1).getNi().size() + hmap.get(node2).getNi().size()) {
                    edgeSize++;
                    modeCount++;
                }
            }
        }
    }

    /**
     * This method return a pointer (shallow copy) for the
     * collection representing all the nodes in the graph.
     * Note: this method should run in O(1) time.
     * return all Vertex in the graph
     * @return Collection<node_data>
     */
    @Override
    public Collection<node_data> getV() {
        return hmap.values();
    }

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
    @Override
    public Collection<node_data> getV(int node_id) {
        if (hmap.containsKey(node_id)) {
            return hmap.get(node_id).getNi();
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
    public node_data removeNode(int key) {
        if (hmap.containsKey(key)){
            int size = hmap.size();
            node_data removed = hmap.remove(key);
            for (node_data delNi : removed.getNi()) {
                delNi.removeNode(removed);
                edgeSize--;
            }
            if (size > hmap.size()) {
                modeCount++;
                this.size--;
                return removed;
            }
        }
        return null;
    }

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
    @Override
    public void removeEdge(int node1, int node2) {
        if (hmap.containsKey(node1) && hmap.containsKey(node2)) {
            int size = hmap.get(node1).getNi().size() + hmap.get(node2).getNi().size();
            hmap.get(node1).removeNode(hmap.get(node2));
            hmap.get(node2).removeNode(hmap.get(node1));
            if (size > hmap.get(node1).getNi().size() + hmap.get(node2).getNi().size()) {
                edgeSize--;
                modeCount++;
            }

        }
    }

    /**
     * return the number of vertices (nodes) in the graph.
     * Note: this method should run in O(1) time.
     * return the number of the Vertex in the graph
     * @return hmap.size int
     */
    @Override
    public int nodeSize() {
        return hmap.size();
    }

    /**
     * return the number of edges (undirectional graph).
     * Note: this method should run in O(1) time.
     * return the number of the edge in the graph
     * @return edgeSize int
     */
    @Override

    public int edgeSize() {
        return edgeSize;
    }

    /**
     * return the Mode Count - for testing changes in the graph.
     * Any change in the inner state of the graph should cause an increment in the ModeCount
     * return the number of the actions in the graph
     * @return modeCount int
     */
    @Override
    public int getMC() {
        return this.modeCount;
    }
}
