
/***
 * VÁZQUEZ CHOREÑO LUIS ERNESTO
 * Centro de Investigación en Computación
 * 2019
 *
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

// Class for the problem number 3
class Coordinate{
    public double x,y;
}


public class Graph<T> {
    /**
     * Representation of graph with an adjacency list
     */
    private int numNodes;
    private int numEdges;
    private  boolean directed;
    private ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList< ArrayList<Integer>>();
    private ArrayList<T> Nodes = new ArrayList<T>();

    /***
     * CONSTRUCTOR
     * @param numNodes
     * @param numEdges
     * @param directed
     */
    Graph(int numNodes,int numEdges,boolean directed){
        this.numNodes = numNodes;
        this.numEdges = numEdges;
        this.directed = directed;
        for(int i=0;i<numNodes;i++)
            adjacencyList.add(new ArrayList<>());


    }


    // check if an edge (u,v) is in the graph
    private boolean checkEdge(int u,int v){
        for(int i=0;i<adjacencyList.get(u).size();i++){
            if( adjacencyList.get(u).get(i) == v){
                return true;
            }
        }
        return false;

    }

    /*
        Add a new edge considering if it's directed
     */
    private void addEdge(int u,int v){
        adjacencyList.get(u).add(v);
        if(!directed && u!=v)
            adjacencyList.get(v).add(u);
        numEdges++;
    }

    /*
        Only for testing
     */
    public void printGraph(){
        for(int i=0;i<numNodes;i++){
            System.out.println("Node: " + (i +1) );
            for(int j=0;j<adjacencyList.get(i).size();j++){
                System.out.print( ( 1+ adjacencyList.get(i).get(j) )+ ", ");
            }
            System.out.println();
        }
    }


    /*
        It generates a random number [0,range-1]
     */
    public static int getRandomNumber(int range){
        Random RandomObject = new Random();
        int randomNumber = RandomObject.nextInt(range);
        return randomNumber;
    }

    /*

        It generates a random number [0,1]
     */
    public static double getRandomNumber(){
        return Math.random();
    }

    /**
     *  Erdös y Rényi Model
     *
     * @param nodes
     * @param edges
     * @param directed
     * @param selfloop
     * @return
     */

    public static  Graph<Integer> graphGeneratorErdosRenyi(int nodes,int edges,boolean directed,boolean selfloop){
        Graph<Integer> G = new Graph(nodes,0,directed);
        int countEdges = 0;
        // you have to stop the algorithm until you have m edges in your graph
        while(countEdges < edges){
            int U = getRandomNumber(nodes); // random number
            int V = getRandomNumber(nodes);// random number
            if(G.checkEdge(U,V)){ // check if the edge already exist
                continue;
            }

            if( U == V && selfloop == false){ // check self loop
                continue;
            }
            // add new edge
            G.addEdge(U,V);
            countEdges++;

        }
        return G;
    }

    /***
     *  Modelo de Gilbert
     *
     * @param nodes
     * @param p
     * @param directed
     * @param selfloop
     * @return
     */
    public static Graph<Integer> graphGeneratorGilbert(int nodes, double p, boolean directed, boolean selfloop){
        // create an empty graph with n nodes
        Graph<Integer> G  = new Graph(nodes,0,directed);

        // check al pairs of nodes and check the probability that those nodes are connected
        for(int i=0;i<nodes;i++){
            int initialJ = (directed)? 0 : i;
            // here depends if it is a directed graph
            // if it is a directed graph you have to check with the last nodes, if not
            // you don't have to

            for(int j = initialJ;j<nodes;j++){

                // considering selfloop
                if( i == j && !selfloop){
                    continue;
                }

                // check if the edge already exist
                if(G.checkEdge(i,j)){
                    continue;
                }

                // test the probability
                double temp = getRandomNumber();
                if(p>=temp){
                    G.addEdge(i,j);
                }
            }
        }
        return G;

    }

    /***
     * Modelo Gn,r geográfico simple.
     * @param nodes
     * @param r
     * @param directed
     * @param selfloop
     * @return
     */
    public static Graph<Coordinate> graphGeneratorGeographic(int nodes,double r, boolean directed,boolean selfloop){
        Graph<Coordinate> G = new Graph<Coordinate>(nodes,0,directed);
        // create graph
        // n random pairs of numbers between 0 to 1 to generate a graph
        // inside an unitary area

        for(int i=0;i<nodes;i++){
            double x = getRandomNumber();
            double y = getRandomNumber();
            Coordinate c = new Coordinate();
            c.x = x;
            c.y = y;
            G.Nodes.add(c);
        }



        /*
            Check all the pairs of nodes to measure de distance
            if the distances is less or equal that r, the edge is included
         */
        for(int i=0;i<nodes;i++){
            int initialJ = (directed)? 0 : i;
            for(int j=initialJ;j<nodes;j++){
                if(i == j && !selfloop)
                    continue;

                if(G.checkEdge(i,j)){
                    continue;
                }

                double distance = getDistance(G.Nodes.get(i),G.Nodes.get(j));
                if(distance<=r)
                    G.addEdge(i,j);

            }
        }
        return G;

    }


    public static double getDistance(Coordinate a, Coordinate b){
        double f = a.x - b.x;
        double s = (a.y - b.y);
        f = f * f;
        s = s * s;
        return Math.sqrt(f + s);
    }


    /***
     *  Variante del modelo Gn,d Barabási-Albert
     * @param nodes
     * @param d
     * @param directed
     * @param selfloop
     * @return
     */
    public static Graph graphGeneratorBarabasiAlbert(int nodes,double d,boolean directed,boolean selfloop){

        Graph<Integer> G = new Graph<>(nodes,0,directed);

        // By definition the first d nodes  are
        // all connected all vs all
        int integerD = (int) d;
        for(int i=0;i<integerD;i++){
            for(int j=i + 1;j<d;j++){
                G.addEdge(i,j);
            }
        }

        /*
            Now check one by one the new nodes
            For each node check all the nodes that already were checked

                for every of those nodes the probability that those nodes are connected
                with the formula 1.00 - deg/d


         */

        for(int i=integerD;i<nodes;i++){
            for(int j=0;j<=i && G.adjacencyList.get(i).size()<integerD;j++){
                if(i == j && !selfloop)
                    continue;
                int degreeJ =  G.adjacencyList.get(j).size();
                if(degreeJ>=integerD)
                    continue;
                double probability = 1.00 - (double)degreeJ/d;
                double rng = getRandomNumber();
                if(rng<=probability){
                    G.addEdge(i,j);
                }
            }
        }
        return G;
    }


    public  void writeGephiFile(String name){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name + ".csv"), "UTF-8"))) {
            for(int i=0;i<this.numNodes;i++){
                 writer.write("" + (i+1) );

                for(int j=0;j<this.adjacencyList.get(i).size();j++){
                    writer.write(";" + (1 + adjacencyList.get(i).get(j)));
                }

                writer.write("\n") ;


            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
