package ex1.tests;

import ex1.src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

public class WGraph_DSTest {
    public static String path ="D:\\";
    public static String nameFile ="newFile";
    /**
     * create graph with 0 vertex and check every function in the the class
     **/
    @Test
    void test1() {//0 vertex
        weighted_graph g = new WGraph_DS();
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph_algorithms algo = new WGraph_Algo();

        hasEdge(false ,g,0,0);
        hasEdge(false ,g,0,1);
        hasEdge(false ,g,2,1);
        getV(g,0);
        getEdge(g,0,0,-1);
        getV(g,0);
        edgeSize(g,0);
        getMC(g,0);
    }
    /**
     * create graph with 1 vertex and check every function in the the class
     **/
    @Test
    void test2() throws IOException {//1 vertex
        weighted_graph g = functionForTests.graph_creator(1,0,1);
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph_algorithms algo = new WGraph_Algo();
        getNode(g,0);
        hasEdge(false ,g,0,0);
        hasEdge(false ,g,0,1);
        hasEdge(false ,g,2,1);
        getV(g,1);
        nodeSize(g,1);
        getEdge(g,0,0,-1);
        testAlgo.init(g);
        testAlgo.copy(g);
        testAlgo.isConnected(g,true);
        List<node_info> list = new LinkedList<node_info>();
        list.add(g.getNode(0));
        testAlgo.shortestPath(g,list,0,0);
        testAlgo.shortestPathDist(g,0,0,0);
        testAlgo.shortestPathDist(g,0,1,-1);
        testAlgo.shortestPathDist(g,0,2,-1);
        testAlgo.shortestPathDist(g,3,1,-1);
        testAlgo.save(g,path,nameFile);
        testAlgo.load(g,path,nameFile);
        removeEdge(g,0,0);
        removeNode(g,0);
        //connect(g , 0 , 0 , ((double)(((int)(((Math.random()*110)+1))*10)/10)));
        getV(g,0);
        edgeSize(g,0);
        getMC(g,2);
    }
    /**
     * create graph with 50 vertex and check every function in the the class
     **/
    @Test
    void test3() throws IOException {//50 vertex
        weighted_graph g = functionForTests.createGraphAndConnect(50);
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph_algorithms algo = new WGraph_Algo();
        nodeSize(g,50);
        getNode(g,0);
        hasEdge(false ,g,0,0);
        getEdge(g,0,0,-1);
        hasEdge(true ,g,0,1);
        getEdge(g,0,1,1);
        hasEdge(true ,g,2,1);
        getEdge(g,2,1,1);
        hasEdge(false ,g,20,21);
        getEdge(g,0,0,-1);
        hasEdge(true ,g,1,30);
        getEdge(g,1,30,1);
        hasEdge(false ,g,50,80);
        getEdge(g,0,0,-1);
        getV(g,50);
        testAlgo.init(g);
        testAlgo.copy(g);
        testAlgo.isConnected(g,true);
        List<node_info> list = new LinkedList<node_info>();
        list.add(g.getNode(20));
        list.add(g.getNode(0));
        list.add(g.getNode(49));
        testAlgo.shortestPath(g,list,20,50);
        testAlgo.shortestPathDist(g,0,0,0);
        testAlgo.shortestPathDist(g,0,1,1);
        testAlgo.shortestPathDist(g,0,2,1);
        testAlgo.shortestPathDist(g,3,1,1);
        testAlgo.save(g,path,nameFile);
        testAlgo.save(g,path,nameFile);
        removeEdge(g,0,0);
        for (int i = 0; i < 10; i++) {
            removeEdge(g,i,30);
        }
        testAlgo.isConnected(g,true);
        removeNode(g,0);
        //connect(g , 0 , 0 , ((double)(((int)(((Math.random()*110)+1))*10)/10)));
        getV(g,49);
        edgeSize(g,581);
        getMC(g,730);
    }
    /**
     * create graph with 10 vertex and check every function in the the class
     **/
    @Test
    void test4() throws IOException {//10 vertex
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);

        nodeSize(graph,10);

        connect(graph,0,1,4);
        connect(graph,0,2,4);
        connect(graph,1,2,2);
        connect(graph,2,3,1);
        connect(graph,1,4,1);
        connect(graph,4,5,2);
        connect(graph,3,5,4);
        connect(graph,4,6,1);
        connect(graph,6,7,3);
        connect(graph,7,8,3);
        connect(graph,7,9,2);
        connect(graph,8,9,4);

        testAlgo.init(graph);
        testAlgo.copy(graph);

        removeNode(graph,0);
        testAlgo.isConnected(graph,true);
        testAlgo.save(graph,path,nameFile);
        testAlgo.load(graph,path,nameFile);
        getV(graph,9);
        edgeSize(graph,10);
        getMC(graph,25);
    }
    /**
     * create graph with 9 vertex and check every function in the the class
     **/
    @Test
    void test5() throws IOException {//9 vertex
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);
        nodeSize(graph,10);

        connect(graph,1,2,(((double)((int)(Math.random()*100)))/10));
        connect(graph,1,4,(((double)((int)(Math.random()*100)))/10));
        connect(graph,2,5,(((double)((int)(Math.random()*100)))/10));
        connect(graph,2,6,(((double)((int)(Math.random()*100)))/10));
        connect(graph,2,7,(((double)((int)(Math.random()*100)))/10));
        connect(graph,3,5,(((double)((int)(Math.random()*100)))/10));
        connect(graph,3,8,(((double)((int)(Math.random()*100)))/10));
        connect(graph,3,4,(((double)((int)(Math.random()*100)))/10));
        connect(graph,3,1,(((double)((int)(Math.random()*100)))/10));
        connect(graph,4,9,(((double)((int)(Math.random()*100)))/10));
        connect(graph,5,8,(((double)((int)(Math.random()*100)))/10));
        connect(graph,5,7,(((double)((int)(Math.random()*100)))/10));
        String[] s = {
                "[]",
                "[2 , 3 , 4]",
                "[1 , 5 , 6 , 7]",
                "[1 , 4 , 5 , 8]",
                "[1 , 3 , 9]",
                "[2 , 3 , 7 , 8]",
                "[2]",
                "[2 , 5]",
                "[3 , 5]",
                "[4]"
        };

        int index = 0;
        for (node_info n : graph.getV()){

            assertTrue(functionForTests.checkVal(s[index++], functionForTests.printNi2(graph.getV(n.getKey()))), "the Ni is not the true");
        }


        testAlgo.init(graph);
        testAlgo.copy(graph);
        removeNode(graph,6);
        testAlgo.isConnected(graph, false);
        removeNode(graph, 0);
        testAlgo.init(graph);
        testAlgo.isConnected(graph, true);
        testAlgo.save(graph,path,nameFile);
        testAlgo.load(graph,path,nameFile);
        getV(graph,8);
        edgeSize(graph,11);
        getMC(graph,25);

    }
    /**
     * create graph with 10 vertex and check every function in the the class
     **/
    @Test
    void test6() throws IOException {//10 vertex

        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);
        nodeSize(graph,10);

        connect(graph,0,1,4);
        connect(graph,0,2,4);
        connect(graph,1,2,2);
        connect(graph,1,4,1);
        connect(graph,3,2,1);
        connect(graph,3,5,4);
        connect(graph,5,4,2);
        connect(graph,4,6,1);
        connect(graph,6,7,3);
        connect(graph,7,8,3);
        connect(graph,7,9,2);
        connect(graph,8,9,4);

        testAlgo.init(graph);
        testAlgo.shortestPathDist(graph,0, 5,7.0);
        testAlgo.shortestPathDist(graph,0, 9,11.0);
        testAlgo.shortestPathDist(graph,1, 6,2.0);
        testAlgo.shortestPathDist(graph,1, 5,3.0);
        testAlgo.shortestPathDist(graph,2, 8,10.0);
        testAlgo.shortestPathDist(graph,2, 7,7.0);
        testAlgo.shortestPathDist(graph,4, 6,1.0);
        testAlgo.shortestPathDist(graph,10, 5,-1.0);
        testAlgo.shortestPathDist(graph,6, 9,5.0);
        testAlgo.shortestPathDist(graph,7, 9,2.0);
        testAlgo.shortestPathDist(graph,8, 9,4.0);

        testAlgo.isConnected(graph,true);
        testAlgo.save(graph,path,nameFile);
        testAlgo.load(graph,path,nameFile);
        getV(graph,10);
        edgeSize(graph,12);
        getMC(graph,22);

    }
    /**
     * create graph with 10 vertex and check every function in the the class
     **/
    @Test
    void test7() throws IOException {//10
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);
        nodeSize(graph,10);

        connect(graph,0,1,4);
        connect(graph,0,2,4);
        connect(graph,1,4,1);
        connect(graph,3,2,1);
        connect(graph,3,5,4);
        connect(graph,4,6,1);
        connect(graph,6,7,3);
        connect(graph,7,8,3);
        connect(graph,7,9,2);
        connect(graph,8,9,2);

        weighted_graph_algorithms gra = new WGraph_Algo();
        testAlgo.init(graph);
        testAlgo.copy(graph);
        testAlgo.isConnected(graph,true);
        testAlgo.save(graph,path,nameFile);
        testAlgo.load(graph,path,nameFile);
        getV(graph,10);
        edgeSize(graph,10);
        getMC(graph,20);
        addNode(graph,100);
        getMC(graph,21);
        testAlgo.isConnected(graph,false);
        removeNode(graph, 100);
        testAlgo.isConnected(graph,true);
        testAlgo.save(graph,path,nameFile);
        testAlgo.load(graph,path,nameFile);
    }
    /**
     * create graph with 50 vertex and check every function in the the class
     **/
    @Test
    void test8 () {//50 vertex
        weighted_graph g = new WGraph_DS();
        for (int i = 0; i < 50; ++i)
            g.addNode(i);
        for (int i = 0; i < g.nodeSize(); i++) {
            for (int j = 0; j < 15; j++) {
                g.connect(i, j, 1);
            }
        }
    }
    /**
     * create graph with 1000000 vertex and check every function in the the class
     **/
    @Test
    void test9()  {//1000000 vertex
        assertTimeoutPreemptively(Duration.ofMillis(10000), () -> {
            weighted_graph g = functionForTests.graph_creator2(1000000);
            for (int i = 0; i < g.nodeSize(); i++) {
                for (int j = 0; j < 10; j++) {
                    g.connect(i, j, 1);
                }
            }
        });
    }
    /**
     * check for getNode
     **/
    void getNode(weighted_graph graph, int key) {
        assertNotNull(graph.getNode(key), "the node is null");
    }
    /**
     * check for hasEdge
     **/
    void hasEdge(boolean flag, weighted_graph graph, int node1, int node2) {
        assertNotNull(graph, "the graph is null");
        assertTrue(flag == graph.hasEdge(node1,node2), "there is no edge between " + node1 + " && " + node2);
    }
    /**
     * check for getEdge
     **/
    void getEdge(weighted_graph graph, int node1, int node2, double weight) {
        assertEquals(weight, graph.getEdge(node1, node2), "the Edge " + weight +" != "+ graph.getEdge(node1, node2));
    }
    /**
     * check for addNode
     **/
    void addNode(weighted_graph graph, int node1) {
        int size = graph.nodeSize();
        graph.addNode(node1);
        graph.addNode(node1);
        assertFalse(size == graph.nodeSize() , "did not added the node");
        assertFalse((size + 2)  == graph.nodeSize() , "added the same node twice");
    }
    /**
     * check for connect
     **/
    void connect(weighted_graph graph, int node1, int node2, double weight) {
        int size = graph.edgeSize();
        graph.connect(node1, node2, weight);
        graph.connect(node2, node1, weight);
        assertTrue(size != graph.edgeSize() , "did not added the edge");
        assertFalse((size + 2)  == graph.edgeSize() , "added the same edge twice");
    }
    /**
     * check for getV
     **/
    void getV(weighted_graph graph, int numV) {
        if(graph != null && graph.getV() != null){
            assertEquals(graph.getV().size() , numV, "the size of the vertex is " +graph.getV().size() +" != "+ numV);
        }
    }
    /**
     * check for removeNode
     **/
    void removeNode(weighted_graph graph, int node1) {
        int eSize = graph.edgeSize();
        int vSize = graph.nodeSize();
        int vSizeNi = graph.getV(node1).size();
        graph.removeNode(node1);
        assertEquals((eSize - vSizeNi),graph.edgeSize() , "the size of the edges is " +(eSize - vSizeNi) +" != "+ graph.edgeSize());
        assertNotEquals(vSize, graph.nodeSize() , "the size of the vertex is " +vSize +" != "+ graph.nodeSize());
    }
    /**
     * check for removeEdge
     **/
    void removeEdge(weighted_graph graph, int node1, int node2) {
            int eSize = graph.edgeSize();
            int vSizeNi = graph.getV(node1).size();
            if(eSize < 0){
                graph.removeEdge(node1,node2);
                assertEquals((eSize - 1),graph.edgeSize() , "the size of the edges is " +(eSize - vSizeNi) +" != "+ graph.edgeSize());
            }
    }
    /**
     * check for nodeSize
     **/
    void nodeSize(weighted_graph graph, int nodeSize) {
        assertEquals(nodeSize,graph.nodeSize(), "the node size is " + nodeSize +" != "+ graph.nodeSize());
    }
    /**
     * check for edgeSize
     **/
    void edgeSize(weighted_graph graph, int edgeSize) {
        assertEquals(edgeSize,graph.edgeSize(), "the edge size is " + edgeSize +" != "+ graph.edgeSize());
    }
    /**
     * check for getMC
     **/
    void getMC(weighted_graph graph, int MC) {
        assertEquals(graph.getMC(),MC, "the edge size is " + graph.getMC() +" != "+ MC);
    }
}