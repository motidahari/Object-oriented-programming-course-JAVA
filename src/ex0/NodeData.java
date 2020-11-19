package ex0;
import java.util.Collection;
import java.util.*;
import java.util.HashMap;

public class NodeData implements node_data {
    private int key,size,tag;
    static int countIndex = 0;
    private String info;
    //private ArrayList<node_data>list;
    private HashMap<Integer, node_data> hmap;


    /**
     * constructor for NodeData to create new empty hashMap for the Neighbors
     * @param
     * @return none return
     */
    public NodeData(){
        hmap = new HashMap<Integer, node_data>();
        this.size = this.tag = 0 ;
        this.info = "";
        this.key = countIndex++;
    }
    /**
     * constructor for NodeData to create new empty hashMap for the Neighbors with specific key
     * @param key of the node
     * @return none return
     */
    public NodeData(int key){
        hmap = new HashMap<Integer, node_data>();
        this.size = this.tag = 0 ;
        this.info = "";
        this.countIndex = key;
        this.key = countIndex++;
    }


    /**
     * Return the key (id) associated with this node.
     * Note: each node_data should have a unique key.
     * @return this.key
     */
    @Override
    public int getKey() {
        return this.key;
    }

    /**
     * This method returns a collection with all the Neighbor nodes of this node_data
     * @return collection of all the Neighbors by the node
     */
    @Override
    public Collection<node_data> getNi() {
        return hmap.values();
    }

    /**
     * return true iff this<==>key are adjacent, as an edge between them.
     * check if has Neighbor to the node by node key
     * @param key
     * @return true is exist false if isn't
     */
    @Override
    public boolean hasNi(int key) {
        return hmap.containsKey(key);
    }

    /**
     * This method adds the node_data (t) to this node_data.
     * check if to the node in the class has Neighbor by the key of node_data t
     * if already has Neighbor to the node by node t.getKey we doing nothing
     * if not add the node to hashMap and we will increase the param size(Num Of Neighbor)
     * @param t node
     */
    @Override
    public void addNi(node_data t) {
        if(!hasNi(t.getKey())){
            int size = hmap.size();
            hmap.put(t.getKey(), t);
            if(size < hmap.size()){
                this.size++;
            }
        }
    }

    /**
     * Removes the edge this-key,
     * check if to the node in the class has Neighbor by the key of node_data node
     * if to the node has Neighbor node.getKey() we delete the node and update the size
     * if not we doing nothing
     * @param node node_data
     */
    @Override
    public void removeNode(node_data node) {
        if(hasNi(node.getKey())){
            int size = hmap.size();
            hmap.remove(node.getKey());
            if(size > hmap.size()){
                this.size--;
            }
        }
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
    public int getTag() {
        return this.tag;
    }

    /**
     * Allow setting the "tag" value for temporal marking an node - common
     * practice for marking by algorithms.
     * update the value of the tag
     * @param t - the new value of the tag
     */
    @Override
    public void setTag(int t) {
        this.tag = t;
    }

    /**
     * get all data by node
     * @param node - the new value of the tag
     */

    public String toString(node_data node) {
        return "NodeData{" +
                "key=" + key +
                ", size=" + size +
                ", tag=" + tag +
                ", info='" + info + '\'' +
                ", Neighbors=" + getAllNeighborsByNodeId(node) +
                '}';
    }
    /**
     * run by Neighbors of node and return String of all the Neighbors
     * help func to toString
     * @param node - the new value of the tag
     */
    public String getAllNeighborsByNodeId(node_data node){
        String str ="[";
        int a = 0;
        for(node_data n : node.getNi()){
            if(a == 0){
                str += n.getKey() ;
            }else{
                str += " , " + n.getKey();
            }
            a++;
        }
        str += "]";
        return str;
    }
}
