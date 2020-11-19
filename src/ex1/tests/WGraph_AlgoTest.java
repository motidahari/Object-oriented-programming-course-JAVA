package ex1.tests;

import ex1.src.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.io.File;
import java.io.IOException;

class WGraph_AlgoTest {
    private WGraph_DSTest wGraph_dsTest = new WGraph_DSTest();
    private static String path ="D:\\";
    private static String nameFile ="newFile";

    /**
     * create graph with 0 vertex and check every function in the the class
     **/
    @Test
    void test1() {//0 vertex
        weighted_graph g = new WGraph_DS();
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph_algorithms algo = new WGraph_Algo();
        wGraph_dsTest.hasEdge(false ,g,0,0);
        wGraph_dsTest.hasEdge(false ,g,0,1);
        wGraph_dsTest.hasEdge(false ,g,2,1);
        wGraph_dsTest.getV(g,0);
        wGraph_dsTest.getEdge(g,0,0,-1);
        wGraph_dsTest.getV(g,0);
        wGraph_dsTest.edgeSize(g,0);
        wGraph_dsTest.getMC(g,0);
    }

    /**
     * create graph with 1 vertex and check every function in the the class
     **/
    @Test
    void test2() throws IOException {//1 vertex
        weighted_graph g = functionForTests.graph_creator(1,0,1);
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph_algorithms algo = new WGraph_Algo();
        wGraph_dsTest.getNode(g,0);
        wGraph_dsTest.hasEdge(false ,g,0,0);
        wGraph_dsTest.hasEdge(false ,g,0,1);
        wGraph_dsTest.hasEdge(false ,g,2,1);
        wGraph_dsTest.getV(g,1);
        wGraph_dsTest.nodeSize(g,1);
        wGraph_dsTest.getEdge(g,0,0,-1);
        testAlgo.init(g);
        testAlgo.copy(g);
        getGraph(g);
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
        wGraph_dsTest.removeEdge(g,0,0);
        wGraph_dsTest.removeNode(g,0);
        //connect(g , 0 , 0 , ((double)(((int)(((Math.random()*110)+1))*10)/10)));
        wGraph_dsTest.getV(g,0);
        wGraph_dsTest.edgeSize(g,0);
        wGraph_dsTest.getMC(g,2);
    }

    /**
     * create graph with 50 vertex and check every function in the the class
     **/
    @Test
    void test3() throws IOException {//50 vertex
        weighted_graph g = functionForTests.createGraphAndConnect(50);
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph_algorithms algo = new WGraph_Algo();
        wGraph_dsTest.nodeSize(g,50);
        wGraph_dsTest.getNode(g,0);
        wGraph_dsTest.hasEdge(false ,g,0,0);
        wGraph_dsTest.getEdge(g,0,0,-1);
        wGraph_dsTest.hasEdge(true ,g,0,1);
        wGraph_dsTest.getEdge(g,0,1,1);
        wGraph_dsTest.hasEdge(true ,g,2,1);
        wGraph_dsTest.getEdge(g,2,1,1);
        wGraph_dsTest.hasEdge(false ,g,20,21);
        wGraph_dsTest.getEdge(g,0,0,-1);
        wGraph_dsTest.hasEdge(true ,g,1,30);
        wGraph_dsTest.getEdge(g,1,30,1);
        wGraph_dsTest.hasEdge(false ,g,50,80);
        wGraph_dsTest.getEdge(g,0,0,-1);
        wGraph_dsTest.getV(g,50);
        testAlgo.init(g);
        testAlgo.copy(g);
        getGraph(g);

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
        wGraph_dsTest.removeEdge(g,0,0);
        for (int i = 0; i < 10; i++) {
            wGraph_dsTest.removeEdge(g,i,30);
        }
        testAlgo.isConnected(g,true);
        wGraph_dsTest.removeNode(g,0);
        //connect(g , 0 , 0 , ((double)(((int)(((Math.random()*110)+1))*10)/10)));
        wGraph_dsTest.getV(g,49);
        wGraph_dsTest.edgeSize(g,581);
        wGraph_dsTest.edgeSize(g,581);
        wGraph_dsTest.getMC(g,730);
    }
    /**
     * create graph with 10 vertex and check every function in the the class
     **/
    @Test
    void test4() throws IOException {//10 vertex
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);

        wGraph_dsTest.nodeSize(graph,10);

        wGraph_dsTest.connect(graph,0,1,4);
        wGraph_dsTest.connect(graph,0,2,4);
        wGraph_dsTest.connect(graph,1,2,2);
        wGraph_dsTest.connect(graph,2,3,1);
        wGraph_dsTest.connect(graph,1,4,1);
        wGraph_dsTest.connect(graph,4,5,2);
        wGraph_dsTest.connect(graph,3,5,4);
        wGraph_dsTest.connect(graph,4,6,1);
        wGraph_dsTest.connect(graph,6,7,3);
        wGraph_dsTest.connect(graph,7,8,3);
        wGraph_dsTest.connect(graph,7,9,2);
        wGraph_dsTest.connect(graph,8,9,4);
        getGraph(graph);

        testAlgo.init(graph);
        testAlgo.copy(graph);

        wGraph_dsTest.removeNode(graph,0);
        testAlgo.isConnected(graph,true);
        saveWithTry(graph);
        loadWithTry(graph);
        wGraph_dsTest.getV(graph,9);
        wGraph_dsTest.edgeSize(graph,10);
        wGraph_dsTest.getMC(graph,25);
    }
    /**
     * create graph with 9 vertex and check every function in the the class
     **/
    @Test
    void test5() throws IOException {//9 vertex
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);
        wGraph_dsTest.nodeSize(graph,10);

        wGraph_dsTest.connect(graph,1,2,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,1,4,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,2,5,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,2,6,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,2,7,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,3,5,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,3,8,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,3,4,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,3,1,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,4,9,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,5,8,(((double)((int)(Math.random()*100)))/10));
        wGraph_dsTest.connect(graph,5,7,(((double)((int)(Math.random()*100)))/10));
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
        getGraph(graph);

        int index = 0;
        for (node_info n : graph.getV()){

            assertTrue(functionForTests.checkVal(s[index++], functionForTests.printNi2(graph.getV(n.getKey()))), "the Ni is not the true");
        }


        testAlgo.init(graph);
        testAlgo.copy(graph);
        wGraph_dsTest.removeNode(graph,6);
        testAlgo.isConnected(graph, false);
        wGraph_dsTest.removeNode(graph, 0);
        testAlgo.init(graph);
        testAlgo.isConnected(graph, true);
        saveWithTry(graph);
        loadWithTry(graph);
        wGraph_dsTest.getV(graph,8);
        wGraph_dsTest.edgeSize(graph,11);
        wGraph_dsTest.getMC(graph,25);

    }
    /**
     * create graph with 10 vertex and check every function in the the class
     **/
    @Test
    void test6() throws IOException {//10 vertex

        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);
        wGraph_dsTest.nodeSize(graph,10);

        wGraph_dsTest.connect(graph,0,1,4);
        wGraph_dsTest.connect(graph,0,2,4);
        wGraph_dsTest.connect(graph,1,2,2);
        wGraph_dsTest.connect(graph,1,4,1);
        wGraph_dsTest.connect(graph,3,2,1);
        wGraph_dsTest.connect(graph,3,5,4);
        wGraph_dsTest.connect(graph,5,4,2);
        wGraph_dsTest.connect(graph,4,6,1);
        wGraph_dsTest.connect(graph,6,7,3);
        wGraph_dsTest.connect(graph,7,8,3);
        wGraph_dsTest.connect(graph,7,9,2);
        wGraph_dsTest.connect(graph,8,9,4);
        getGraph(graph);

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
        saveWithTry(graph);
        loadWithTry(graph);
        saveWithTry(graph);
        loadWithTry(graph);
        wGraph_dsTest.getV(graph,10);
        wGraph_dsTest.edgeSize(graph,12);
        wGraph_dsTest.getMC(graph,22);

    }
    /**
     * create graph with 10 vertex and check every function in the the class
     **/
    @Test
    void test7() throws IOException {//10
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        weighted_graph graph = functionForTests.graph_creator2(10);
        wGraph_dsTest.nodeSize(graph,10);

        wGraph_dsTest.connect(graph,0,1,4);
        wGraph_dsTest.connect(graph,0,2,4);
        wGraph_dsTest.connect(graph,1,4,1);
        wGraph_dsTest.connect(graph,3,2,1);
        wGraph_dsTest.connect(graph,3,5,4);
        wGraph_dsTest.connect(graph,4,6,1);
        wGraph_dsTest.connect(graph,6,7,3);
        wGraph_dsTest.connect(graph,7,8,3);
        wGraph_dsTest.connect(graph,7,9,2);
        wGraph_dsTest.connect(graph,8,9,2);
        getGraph(graph);

        weighted_graph_algorithms gra = new WGraph_Algo();
        testAlgo.init(graph);
        testAlgo.copy(graph);
        testAlgo.isConnected(graph,true);
        saveWithTry(graph);
        loadWithTry(graph);
        wGraph_dsTest.getV(graph,10);
        wGraph_dsTest.edgeSize(graph,10);
        wGraph_dsTest.getMC(graph,20);
        wGraph_dsTest.addNode(graph,100);
        wGraph_dsTest.getMC(graph,21);
        testAlgo.isConnected(graph,false);
        wGraph_dsTest.removeNode(graph, 100);
        testAlgo.isConnected(graph,true);
        saveWithTry(graph);
        loadWithTry(graph);
    }
    /**
     * create graph with 50 vertex and check every function in the the class
     **/
    @Test
    void test8 () {//50 vertex
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();

        weighted_graph g = new WGraph_DS();
        for (int i = 0; i < 50; ++i)
            g.addNode(i);
        for (int i = 0; i < g.nodeSize(); i++) {
            for (int j = 0; j < 15; j++) {
                g.connect(i, j, 1);
            }
        }
        testAlgo.isConnected(g,true);

        getGraph(g);

    }
    /**
     * create graph with 1000000 vertex and check every function in the the class
     **/
   @Test
    void test9()  {//1000000 vertex
        assertTimeoutPreemptively(Duration.ofMillis(10000), () -> {
            weighted_graph g = functionForTests.graph_creator2(1000000);
            getGraph(g);
            for (int i = 0; i < g.nodeSize(); i++) {
                for (int j = 0; j < 10; j++) {
                    g.connect(i, j, 1);
                }
            }
        });
    }


    /**
     * check for init
     **/
    void init(weighted_graph g1) {
        if(g1 != null){
            weighted_graph_algorithms algo = new WGraph_Algo();
            algo.init(g1);
            assertNotNull(algo.copy(), "the graph is null");
        }
    }

    /**
     * check for getGraph
     **/
    void getGraph(weighted_graph g) {
        assertNotNull(g, "the graph is null");
    }
    /**
     * check for copy
     **/
    void copy( weighted_graph g ) {
        weighted_graph_algorithms algo = new WGraph_Algo();
        algo.init(g);
        assertTrue(functionForTests.checkEqualsByGraph(algo.copy(),g), "the copy is failed");
    }
    /**
     * check for isConnected
     **/
    void isConnected(weighted_graph g, boolean flag) {
        weighted_graph_algorithms algo = new WGraph_Algo();
        algo.init(g);
        assertEquals(algo.isConnected(), flag ,"is connected gives " + algo.isConnected() + " != " + flag);
    }
    /**
     * check for shortestPathDist
     **/
    void shortestPathDist(weighted_graph g, int src, int dest, double ans) {
        weighted_graph_algorithms algo = new WGraph_Algo();
        algo.init(g);
        assertEquals(algo.shortestPathDist(src, dest), ans ,"is shor test Path Dist gives " + algo.shortestPathDist(src, dest) + " != " + ans);
    }
    /**
     * check for shortestPath
     **/
    void shortestPath(weighted_graph g, List<node_info> list, int src, int dest) {
        weighted_graph_algorithms algo = new WGraph_Algo();
        algo.init(g);
        List<node_info> getList = (LinkedList<node_info>)algo.shortestPath(src, dest);
        //System.out.println(getList.size());
        if(getList != null){
            for (int i = 0; i < getList.size(); i++) {
                assertEquals(getList.get(i), list.get(i) , "your path from " + src + " to " + dest +" is not the current");
            }
        }
    }
    /**
     * check for save
     **/
    void save(weighted_graph g , String path, String nameFile) throws IOException {
        weighted_graph_algorithms algo = new WGraph_Algo();
        algo.init(g);
        boolean flag = algo.save(path+nameFile+".txt");
        assertTrue(flag, "failed to save the file");
        boolean exists = false;
        File temp;
        try
        {
            temp = File.createTempFile(nameFile, ".txt");
            exists = temp.exists();
            assertTrue(temp.exists(), "failed to create the file");
            if(exists){
                assertTrue(functionForTests.checkEqualsByGraph(g, algo.copy()), "g1 is not equal to g2");
            }

            //System.out.println("Temp file exists : " + exists);
        } catch (IOException e) {}
    }
    /**
     * check for saveWithTry
     **/
    void saveWithTry(weighted_graph g)  {
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        try {
            save(g,path,nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * check for loadWithTry
     **/
    void loadWithTry(weighted_graph g) {
        WGraph_AlgoTest testAlgo = new WGraph_AlgoTest();
        try {
            load(g,path,nameFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    /**
     * check for load
     **/
    void load(weighted_graph g , String path, String nameFile)  throws IOException{
        weighted_graph_algorithms algo = new WGraph_Algo();
        algo.init(g);
        boolean flag = algo.load(path+nameFile+".txt");
        assertTrue(flag, "failed to load the object from the txt file");
        assertTrue(functionForTests.checkEqualsByGraph(algo.copy(),g), "failed to load the graph from the file");
    }

}