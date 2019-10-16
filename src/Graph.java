
/***
 * VÁZQUEZ CHOREÑO LUIS ERNESTO
 * Centro de Investigación en Computación
 * 2019
 *
 */

import java.io.*;
import java.util.*;

public class Graph {
    /**
     * Representation of a graph with an adjacency list
     */
    private int numNodes;
    private int numEdges;
    private  boolean directed;
    private ArrayList<ArrayList<Pair>> adjacencyList = new ArrayList< ArrayList<Pair>>();
    public ArrayList<Node> Nodes = new ArrayList<>();
    private ArrayList<Coordinate> coordinates = new ArrayList<>();



    /***
     * CONSTRUCTOR
     */
    Graph(int numNodes,int numEdges,boolean directed){
        this.numNodes = numNodes;
        this.numEdges = numEdges;
        this.directed = directed;
        for(int i=0;i<numNodes;i++){
            adjacencyList.add(new ArrayList<>());
            Nodes.add( new Node(i));
        }

    }


    // check if an edge (u,v) is in the graph
    private boolean checkEdge(int u,int v){
        for(int i=0;i<adjacencyList.get(u).size();i++){
            if( (Integer)adjacencyList.get(u).get(i).first() == v){
                return true;
            }
        }
        return false;

    }


    private double getWeightEdge(int u,int v){
        double ans = 0;

        for(int i=0;i<adjacencyList.get(u).size();i++){
            if( (Integer)adjacencyList.get(u).get(i).first() == v){
                return (Double)adjacencyList.get(u).get(i).second();
            }
        }
        return ans;
    }

    /*
        Add a new edge considering if it's directed
     */
    private void addEdge(int u,int v,double weight){
        adjacencyList.get(u).add(new Pair(v,weight));
        if(!directed && u!=v)
            adjacencyList.get(v).add(new Pair(u,weight));
        numEdges++;
    }

    /*
        Only for testing
     */
    public void printGraph(){
        for(int i=0;i<numNodes;i++){
            System.out.println("Node: " + (i +1) );
            for(int j=0;j<adjacencyList.get(i).size();j++){
                System.out.print( ( 1+ (Integer)adjacencyList.get(i).get(j).first() )+ ", ");
            }
            System.out.println();
        }
    }

    /*
        Only for testing
     */
    public void printGraph(boolean b){
        for(int i=0;i<numNodes;i++){
            System.out.println("Node: " + (i +1) );
            for(int j=0;j<adjacencyList.get(i).size();j++){
                System.out.print(  "(" +  ( 1+ (Integer)adjacencyList.get(i).get(j).first() )+ ","  + adjacencyList.get(i).get(j).second()  + ")" );
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



    /*
        It generates a random number [rangeMin,rangeMax]
     */
    public static double getRandomNumber(double rangeMin, double rangeMax){
        Random r = new Random();
        double randomValue = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        return randomValue;
    }




    /**
     *  Erdös y Rényi Model
     */

    public static  Graph graphGeneratorErdosRenyi(int nodes,int edges,boolean directed,boolean selfloop){
        Graph G = new Graph(nodes,0,directed);
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
            G.addEdge(U,V,0.0);
            countEdges++;

        }
        return G;
    }

    /***
     *  Modelo de Gilbert
     */
    public static Graph graphGeneratorGilbert(int nodes, double p, boolean directed, boolean selfloop){
        // create an empty graph with n nodes
        Graph G  = new Graph(nodes,0,directed);

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
                    G.addEdge(i,j,0);
                }
            }
        }
        return G;

    }

    /***
     * Modelo Gn,r geográfico simple.
     */
    public static Graph graphGeneratorGeographic(int nodes,double r, boolean directed,boolean selfloop){
        Graph G = new Graph(nodes,0,directed);
        // create graph
        // n random pairs of numbers between 0 to 1 to generate a graph
        // inside an unitary area

        for(int i=0;i<nodes;i++){
            double x = getRandomNumber();
            double y = getRandomNumber();
            Coordinate c = new Coordinate();
            c.x = x;
            c.y = y;
            G.coordinates.add(c);
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

                double distance = getDistance(G.coordinates.get(i),G.coordinates.get(j));
                if(distance<=r)
                    G.addEdge(i,j,0);

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
     */
    public static Graph graphGeneratorBarabasiAlbert(int nodes,double d,boolean directed,boolean selfloop){

        Graph G = new Graph(nodes,0,directed);

        // By definition the first d nodes  are
        // all connected all vs all
        int integerD = (int) d;
        for(int i=0;i<integerD;i++){
            for(int j=i + 1;j<d;j++){
                G.addEdge(i,j,0);
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
                    G.addEdge(i,j,0);
                }
            }
        }
        return G;
    }



    public  void writeGephiFile(String name){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name + ".csv"), "UTF-8"))) {
            for(int i=0;i<this.adjacencyList.size();i++){
                writer.write("" + Nodes.get(i).getName() );

                for(int j=0;j<this.adjacencyList.get(i).size();j++){
                    int v = (int) adjacencyList.get(i).get(j).first();
                    writer.write(";" + Nodes.get(v).getName());
                }

                writer.write("\n") ;


            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }


    public  void writeGephiFileW(String name){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name + ".csv"), "UTF-8"))) {

            writer.write("source;target;weight\n");

            for(int i=0;i<this.adjacencyList.size();i++){
                for(int j=0;j<this.adjacencyList.get(i).size();j++){
                    int v = (int) adjacencyList.get(i).get(j).first();
                    double w = (double) adjacencyList.get(i).get(j).second();
                    String dstring = String.format("%.2f", w);
                    writer.write( i + ";" +  v + ";" + dstring + "\n");
                }
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }





    public  void writeGephiFileWF(String name){
        try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(name + ".csv"), "UTF-8"))) {

            for(int i=0;i<adjacencyList.size();i++){
                writer.write(";" + Nodes.get(i).getName());
            }

            writer.write("\n") ;


            for(int i=0;i<adjacencyList.size();i++){

                writer.write( Nodes.get(i).getName());
                for(int j=0;j<adjacencyList.size();j++){
                    String dstring = String.format("%.2f", getWeightEdge(i,j));
                    writer.write(";" + dstring);
                }
                writer.write("\n") ;
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }
    /******************************** PROJECT 2 ************************/
    /** RECURSIVE DFS ****/

    public Graph DFSTree(int id_node){
        Graph dfstree = new Graph(numNodes,0,false);
        ArrayList<Boolean> visited =new ArrayList<>(this.adjacencyList.size());
        for(int i=0;i<this.adjacencyList.size();i++){
            visited.add(false);
        }
        dfs(id_node,dfstree,visited);
        return dfstree;
    }


    public void dfs(int u, Graph new_graph,ArrayList<Boolean> vis){
        vis.set(u,true);
        for(int i=0;i<this.adjacencyList.get(u).size();i++){
            int v = (Integer) adjacencyList.get(u).get(i)._first;
            if(!vis.get(v)){
                new_graph.addEdge(u,v,0);
                dfs(v,new_graph,vis);
            }
        }
    }




    /** BFS ***/
    public Graph BFSTree(int id_node){

        Graph bfstree = new Graph(numNodes,0,false);
        ArrayList<Boolean> visited =new ArrayList<>(this.adjacencyList.size());
        for(int i=0;i<this.adjacencyList.size();i++){
            visited.add(false);
        }

        Queue<Integer> q = new LinkedList<>();
        q.add(id_node);
        visited.set(id_node,true);
        while(q.isEmpty() == false){
            int u = q.peek();
            q.poll();
            for(int i=0;i<this.adjacencyList.get(u).size();i++){
                int v = (Integer)adjacencyList.get(u).get(i)._first;
                if(!visited.get(v)){
                    bfstree.addEdge(u,v,0);
                    visited.set(v,true);
                    q.add(v);
                }
            }
        }
        return bfstree;
    }

    /**
     * ITERATIVE DFS
     */

    public Graph DFSRTree(int id_node){
        Graph dfstree = new Graph(numNodes,0,false);
        ArrayList<Boolean> visited =new ArrayList<>(this.adjacencyList.size());
        for(int i=0;i<this.adjacencyList.size();i++){
            visited.add(false);
        }
        Stack<Integer> S = new Stack<>();
        S.add(id_node);
        visited.set(id_node,true);

        while(S.isEmpty() == false){
            int u = S.peek();
            S.pop();
            for(int i = 0;i<this.adjacencyList.get(u).size();i++){
                int v = (Integer) adjacencyList.get(u).get(i)._first;
                if(!visited.get(v)){
                    S.add(v);
                    visited.set(v,true);
                    dfstree.addEdge(u,v,0);
                }
            }
        }

        return dfstree;
    }





    /**********PROJECT 3 ************/

    void randomEdgeValues(double min, double max) {

        HashMap<Pair, Double> map = new HashMap<>();

        for(int i=0;i<this.adjacencyList.size();i++){
            for(int j=0;j<this.adjacencyList.get(i).size();j++){
                int u = i;
                int v = (Integer) adjacencyList.get(i).get(j).first();
                if( u == v){
                    continue;
                }

                if(!directed && v < u){
                    double other_edge = this.getWeightEdge(v,u);
                    adjacencyList.get(i).get(j).setSecond((other_edge));
                    continue;
                }

                double W = getRandomNumber(min,max);
                adjacencyList.get(i).get(j).setSecond(W);

                Pair temp = new Pair(u,v);
            }
        }
    }


    Graph Dijkstra(Node node){
        final double inf = 1e9;
        int n = adjacencyList.size();
        Graph g = new Graph(n,0,false);
        ArrayList<Double>  dist=new ArrayList<>(this.adjacencyList.size());
        ArrayList<Integer>  parent=new ArrayList<>(this.adjacencyList.size());

        for(int i=0;i<this.adjacencyList.size();i++){
            dist.add(inf);
            parent.add(i);
        }

        int u = node.getId();
        g.Nodes.get(u).setName( "node_" + (u + 1) + " - 0.0 ");
        dist.set(u,0.0);

        PriorityQueue < Pair > pq = new PriorityQueue < Pair >();

        pq.offer(new Pair(u,0.0));
        while(pq.size()>0){
            Pair top = pq.poll();
            double d = (double) top.second();
            u = (int) top.first();

            if(dist.get(u)<d){
                continue;
            }
;
            for(int i = 0; i < adjacencyList.get(u).size();i++){
                int v = (int) adjacencyList.get(u).get(i).first();
                double w = (double) adjacencyList.get(u).get(i).second();
                if( dist.get(u) + w < dist.get(v)){
                    dist.set(v,dist.get(u) + w);
                    pq.offer(new Pair(v,dist.get(v)));
                    parent.set(v,u);
                }
            }

        }

        for(int i=0;i<n;i++){
            u = parent.get(i);
            String dstring = String.format("%.2f", dist.get(i));
            g.Nodes.get(i).setName( "node_" + (i + 1) + "-" + dstring);
            int v = i;
            if(u != v){
                g.addEdge(u,v,0);
            }
        }


        return g;
    }



}
