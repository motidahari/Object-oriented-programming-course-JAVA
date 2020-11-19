import ex1.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class functionForTests {
    private static Random _rnd = null;

    /**
     * get random int
     **/
    private static int nextRnd(int min, int max) {
        double v = nextRnd(0.0+min, (double)max);
        int ans = (int)v;
        return ans;
    }
    /**
     * get random double
     **/
    private static double nextRnd(double min, double max) {
        double d = _rnd.nextDouble();
        double dx = max-min;
        double ans = d*dx+min;
        return ans;
    }
    /**
     * get array of nodes by some graph
     **/
    private static int[] nodes(weighted_graph g) {
        int size = g.nodeSize();
        Collection<node_info> V = g.getV();
        node_info [] nodes = new node_info[size];
        V.toArray(nodes); // O(n) operation
        int[] ans = new int[size];
        for(int i=0;i<size;i++) {ans[i] = nodes[i].getKey();}
        Arrays.sort(ans);
        return ans;
    }
    /**
     * create a new graph with num vertex, num edges and num seed
     **/
    public static weighted_graph graph_creator(int v_size, int e_size, int seed) {
        weighted_graph g = new WGraph_DS();
        _rnd = new Random(seed);
        for(int i = 0 ; i < v_size ; i++) {
            g.addNode(i);
        }
        // Iterator<node_data> itr = V.iterator(); // Iterator is a more elegant and generic way, but KIS is more important
        int[] nodes = nodes(g);
        while(g.edgeSize() < e_size) {
            int a = nextRnd(0,v_size);
            int b = nextRnd(0,v_size);
            int i = nodes[a];
            int j = nodes[b];
            g.connect(i,j,(((double)((int)(Math.random()*100)))/10));
        }
        return g;
    }
    /**
     * get graph and print it
     **/
    public static void printGraph(weighted_graph graph) {
        if(graph == null){
            System.out.println("graph is null");
            return;
        }
        int a = 0;
        String str = "";
        for (node_info vertex : graph.getV()){
            str = "key "+vertex.getKey()+" Ni --> [";
            for (node_info vertexNi : graph.getV(vertex.getKey())){
                if(a == 0){
                    str += "\n{key = " + vertexNi.getKey() +
                            " , weight = " + graph.getEdge(vertexNi.getKey(), vertex.getKey())+
                            " , info = " + graph.getNode(vertexNi.getKey()).getInfo()+
                            " , tag = " + graph.getNode(vertexNi.getKey()).getTag()+"}";
                }else {
                    str += ",\n{key = " + vertexNi.getKey() +
                            " , weight = " + graph.getEdge(vertexNi.getKey(), vertex.getKey())+
                            " , info = " + graph.getNode(vertexNi.getKey()).getInfo()+
                            " , tag = " + graph.getNode(vertexNi.getKey()).getTag()+"}";
                }
                a++;
            }
            if(a == 0){
                str += "]";
            }else{
                str += "\n]\n";
            }

            a = 0;
            System.out.println(str);
        }
    }

    /**
     * get graph and all the vertex in the graph
     **/
    public static void printVInGraph(weighted_graph graph) {
        int a = 0;
        String str = "";
        for (node_info vertex : graph.getV()){
            str = "key "+vertex.getKey();
            if(a == 0){
                str += "";
            }else{
                str += "\n]\n";
            }

            a = 0;
            System.out.println(str);
        }
    }
    /**
     * get string of all the Neighbors
     **/
    public static String printNi2(Collection<node_info> node) {
        String str = "[";
        int a = 0;
        for (node_info n : node) {
            if (a == 0) {
                str += n.getKey();
            } else {
                str += " , " + n.getKey();
            }
            a++;
        }
        str += "]";
        return str;
    }
    /**
     * run by list and print the path
     **/
    public static void printListOfPath(List<node_info> list, int a, int b){
        if(list != null){
            System.out.println("the path from "+a+" -> "+b+" is : ");
            String path = "";
            if(list.size() != 0){
                for (node_info n : list){
                    if(list.indexOf(n) == list.size()-1){
                        path += n.getKey();
                    }else{
                        path += n.getKey() + " -> ";
                    }
                }
                System.out.println(path);
                path = "";
            }else{
                System.out.println("no path from "+a+" -> "+b );
            }
            System.out.println();
        }else{
            System.out.println("the path from "+a+" -> "+b+" is : ");
            System.out.println("the list is null");
            System.out.println();
        }
    }
    /**
     * check equals by 2 graphs
     **/
    public static boolean checkEqualsByGraph(weighted_graph g1, weighted_graph g2){
        boolean flag = true;
        if(g1.getV().size() != g2.getV().size()){
            flag = false;
        }
        for (node_info node : g1.getV()){
            int key = node.getKey();
            String info = node.getInfo();
            Double tag = node.getTag();
            if(g2.getNode(node.getKey()) == null || (g2.getNode(node.getKey()) != null && (!g2.getNode(node.getKey()).getInfo().equals(info) || g2.getNode(node.getKey()).getTag() != tag))){
                flag = false;
            }else{
                if(g1.getV(node.getKey()).size() == g2.getV(node.getKey()).size()) {
                    for (node_info Ni : g1.getV(node.getKey())){
                        flag = false;
                        for (node_info NiById : g2.getV(Ni.getKey())){
                            if(node.getKey() == NiById.getKey()){
                                flag = true;
                                break;
                            }
                        }
                        if(!flag){
                            return flag;
                        }
                    }
                }else{
                    flag = false;
                }
            }
        }
        return flag;
    }
    /**
     * create graph with num of vertex
     **/
    public static weighted_graph graph_creator2(int size) {
        weighted_graph g = new WGraph_DS();
        for (int i = 0; i < size; ++i)
            g.addNode(i);
        return g;
    }
    /**
     * check equels by 2 strings
     **/
    public static boolean checkVal(String result, String result3){
        return result.equals(result3);
    }
    /**
     * create graph and connect every node to the 15 first nodes
     **/
    public static weighted_graph createGraphAndConnect(int size) {
        weighted_graph g = graph_creator2(size);
            for (int i = 0; i < g.nodeSize(); i++) {
                for (int j = 0; j < 15; j++) {
                    g.connect(i, j, 1);
                }
            }
    return g;
    }
}