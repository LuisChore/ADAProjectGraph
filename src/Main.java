
/***
 * VÁZQUEZ CHOREÑO LUIS ERNESTO
 * Centro de Investigación en Computación
 * 2019
 *
 */

public class Main {

    public static void main(String args[]){

// Project 1


/*
        Graph g1 = Graph.graphGeneratorErdosRenyi(30,100,false,false);
        g1.writeGephiFile("Erdos30");

        Graph g2 = Graph.graphGeneratorErdosRenyi(100,500,false,false);
        g2.writeGephiFile("Erdos100");

        Graph g3 = Graph.graphGeneratorErdosRenyi(500,750,false,false);
        g3.writeGephiFile("Erdos500");




        Graph g4 = Graph.graphGeneratorGilbert(30,0.5,false,false);
        g4.writeGephiFile("Gilbert30");

        Graph g5 = Graph.graphGeneratorGilbert(100,0.4,false,false);
        g5.writeGephiFile("Gilbert100");

        Graph g6 = Graph.graphGeneratorGilbert(500,0.04,false,false);
        g6.writeGephiFile("Gilbert500");



        Graph g7 = Graph.graphGeneratorBarabasiAlbert(30,5,false,false);
        g7.writeGephiFile("Albert30");

        Graph g8 = Graph.graphGeneratorBarabasiAlbert(100,5,false,false);
        g8.writeGephiFile("Albert100");

        Graph g9 = Graph.graphGeneratorBarabasiAlbert(500,5,false,false);
        g9.writeGephiFile("Albert500");



        Graph g10 = Graph.graphGeneratorGeographic(30,0.4,false,false);
        g10.writeGephiFile("Geographic30");

        Graph g11 = Graph.graphGeneratorGeographic(100,0.2,false,false);
        g11.writeGephiFile("Geographic100");

        Graph g12 = Graph.graphGeneratorGeographic(500,0.1,false,false);
        g12.writeGephiFile("Geographic500");
*/

///// PROJECT 2 /////////

        /*
        Graph g1 = Graph.graphGeneratorErdosRenyi(30,100,false,false);
        g1.writeGephiFile("Erdos30");
        Graph temp = g1.BFSTree(0);
        temp.writeGephiFile("Erdos30BFStree");
        temp = g1.DFSTree(0);
        temp.writeGephiFile("Erdos30DFStree");
        temp = g1.DFSRTree(0);
        temp.writeGephiFile("Erdos30DFSRtree");



        Graph g2 = Graph.graphGeneratorErdosRenyi(100,350,false,false);
        g2.writeGephiFile("Erdos100");
        temp = g2.BFSTree(0);
        temp.writeGephiFile("Erdos100BFStree");
        temp = g2.DFSTree(0);
        temp.writeGephiFile("Erdos100DFStree");
        temp = g2.DFSRTree(0);
        temp.writeGephiFile("Erdos100DFSRtree");



        Graph g3 = Graph.graphGeneratorErdosRenyi(500,750,false,false);
        g3.writeGephiFile("Erdos500");
        temp = g3.BFSTree(0);
        temp.writeGephiFile("Erdos500BFStree");
        temp = g3.DFSTree(0);
        temp.writeGephiFile("Erdos500DFStree");
        temp = g3.DFSRTree(0);
        temp.writeGephiFile("Erdos500DFSRtree");




        Graph g4 = Graph.graphGeneratorGilbert(30,0.7,false,false);
        g4.writeGephiFile("Gilbert30");
        temp = g4.BFSTree(0);
        temp.writeGephiFile("Gilbert30BFStree");
        temp = g4.DFSTree(0);
        temp.writeGephiFile("Gilbert30DFStree");
        temp = g4.DFSRTree(0);
        temp.writeGephiFile("Gilbert30DFSRtree");


        Graph g5 = Graph.graphGeneratorGilbert(100,0.6,false,false);
         g5.writeGephiFile("Gilbert100");
         temp = g5.BFSTree(0);
         temp.writeGephiFile("Gilbert100BFStree");
         temp = g5.DFSTree(0);
         temp.writeGephiFile("Gilbert100DFStree");
         temp = g5.DFSRTree(0);
         temp.writeGephiFile("Gilbert100DFSRtree");

        Graph g6 = Graph.graphGeneratorGilbert(500,0.06,false,false);
        g6.writeGephiFile("Gilbert500");
         temp = g6.BFSTree(0);
         temp.writeGephiFile("Gilbert500BFStree");
         temp = g6.DFSTree(0);
         temp.writeGephiFile("Gilbert500DFStree");
         temp = g6.DFSRTree(0);
         temp.writeGephiFile("Gilbert500DFSRtree");


         Graph g7 = Graph.graphGeneratorBarabasiAlbert(30,15,false,false);
         g7.writeGephiFile("Albert30");
         temp = g7.BFSTree(0);
         temp.writeGephiFile("Albert30BFStree");
         temp = g7.DFSTree(0);
         temp.writeGephiFile("Albert30DFStree");
         temp = g7.DFSRTree(0);
         temp.writeGephiFile("Albert30DFSRtree");


         Graph g8 = Graph.graphGeneratorBarabasiAlbert(100,15,false,false);
         g8.writeGephiFile("Albert100");
         temp = g8.BFSTree(0);
         temp.writeGephiFile("Albert100BFStree");
         temp = g8.DFSTree(0);
         temp.writeGephiFile("Albert100DFStree");
         temp = g8.DFSRTree(0);
         temp.writeGephiFile("Albert100DFSRtree");

        Graph g9 = Graph.graphGeneratorBarabasiAlbert(500,15,false,false);
        g9.writeGephiFile("Albert500");
         temp = g9.BFSTree(0);
         temp.writeGephiFile("Albert500BFStree");
         temp = g9.DFSTree(0);
         temp.writeGephiFile("Albert500DFStree");
         temp = g9.DFSRTree(0);
         temp.writeGephiFile("Albert500DFSRtree");

        Graph g10 = Graph.graphGeneratorGeographic(30,0.4,false,false);
         g10.writeGephiFile("Geographic30");
         temp = g10.BFSTree(0);
         temp.writeGephiFile("Geographic30BFStree");
         temp = g10.DFSTree(0);
         temp.writeGephiFile("Geographic30DFStree");
         temp = g10.DFSRTree(0);
         temp.writeGephiFile("Geographic30DFSRtree");

        Graph g11 = Graph.graphGeneratorGeographic(100,0.3,false,false);
         g11.writeGephiFile("Geographic100");
         temp = g11.BFSTree(0);
         temp.writeGephiFile("Geographic100BFStree");
         temp = g11.DFSTree(0);
         temp.writeGephiFile("Geographic100DFStree");
         temp = g11.DFSRTree(0);
         temp.writeGephiFile("Geographic100DFSRtree");

        Graph g12 = Graph.graphGeneratorGeographic(500,0.2,false,false);
        g12.writeGephiFile("Geographic500");
         temp = g12.BFSTree(0);
         temp.writeGephiFile("Geographic500BFStree");
         temp = g12.DFSTree(0);
         temp.writeGephiFile("Geographic500DFStree");
         temp = g12.DFSRTree(0);
         temp.writeGephiFile("Geographic500DFSRtree");

*/
 //// PROJECT 3

        /*
        Graph g1 = Graph.graphGeneratorErdosRenyi(30,30,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos30Input");
        Graph g2 = g1.Dijkstra(g1.Nodes.get(0));
        g2.writeGephiFile("Erdos30Output");

        g1 = Graph.graphGeneratorErdosRenyi(100,100,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos100Input");
        g2 = g1.Dijkstra(g1.Nodes.get(0));
        g2.writeGephiFile("Erdos100Output");

        g1 = Graph.graphGeneratorErdosRenyi(500,500,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos500Input");
        g2 = g1.Dijkstra(g1.Nodes.get(0));
        g2.writeGephiFile("Erdos500Output");




        g1 = Graph.graphGeneratorGilbert(30,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert30Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Gilbert30Output");

        g1 = Graph.graphGeneratorGilbert(100,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert100Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Gilbert100Output");

        g1 = Graph.graphGeneratorGilbert(500,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert500Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Gilbert500Output");



        g1 = Graph.graphGeneratorBarabasiAlbert(30,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("BarabasiAlbert30Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("BarabasiAlbert30Output");

        g1 = Graph.graphGeneratorBarabasiAlbert(100,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("BarabasiAlbert100Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("BarabasiAlbert100Output");

        g1 = Graph.graphGeneratorBarabasiAlbert(500,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("BarabasiAlbert500Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("BarabasiAlbert500Output");




        g1 = Graph.graphGeneratorGeographic(30,0.2,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic30Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Geographic30Output");

        g1 = Graph.graphGeneratorGeographic(100,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic100Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Geographic100Output");

        g1 = Graph.graphGeneratorGeographic(500,0.2,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic500Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Geographic500Output");

*/
//// PROJECT 4

        Graph g1 = Graph.graphGeneratorErdosRenyi(30,100,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos30Input");
        Graph g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Erdos30KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Erdos30KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Erdos30Prim");




        g1 = Graph.graphGeneratorErdosRenyi(100,300,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos100Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Erdos100KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Erdos100KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Erdos100Prim");





        g1 = Graph.graphGeneratorErdosRenyi(500,750,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos500Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Erdos500KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Erdos500KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Erdos500Prim");



        g1 = Graph.graphGeneratorGilbert(30,0.5,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert30Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Gilbert30KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Gilbert30KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Gilbert30Prim");


        g1 = Graph.graphGeneratorGilbert(100,0.2,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert100Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Gilbert100KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Gilbert100KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Gilbert100Prim");


        g1 = Graph.graphGeneratorGilbert(500,0.02,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert500Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Gilbert500KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Gilbert500KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Gilbert500Prim");




        g1 = Graph.graphGeneratorBarabasiAlbert(30,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Albert30Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Albert30KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Albert30KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Albert30Prim");


        g1 = Graph.graphGeneratorBarabasiAlbert(100,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Albert100Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Albert100KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Albert100KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Albert100Prim");


        g1 = Graph.graphGeneratorBarabasiAlbert(500,5,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Albert500Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Albert500KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Albert500KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Albert500Prim");



        g1 = Graph.graphGeneratorGeographic(30,0.5,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic30Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Geographic30KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Geographic30KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Geographic30Prim");


        g1 = Graph.graphGeneratorGeographic(100,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic100Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Geographic100KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Geographic100KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Geographic100Prim");


        g1 = Graph.graphGeneratorGeographic(500,0.2,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic500Input");
        g2 = g1.Kruskal_D();
        g2.writeGephiFileW("Geographic500KruskalD");
        g2 = g1.Kruskal_I();
        g2.writeGephiFileW("Geographic500KruskalI");
        g2 = g1.Prim();
        g2.writeGephiFileW("Geographic500Prim");
/*
        g1 = Graph.graphGeneratorErdosRenyi(100,100,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos100Input");
        g2 = g1.Dijkstra(g1.Nodes.get(0));
        g2.writeGephiFile("Erdos100Output");

        g1 = Graph.graphGeneratorErdosRenyi(500,500,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Erdos500Input");
        g2 = g1.Dijkstra(g1.Nodes.get(0));
        g2.writeGephiFile("Erdos500Output");




        g1 = Graph.graphGeneratorGilbert(30,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert30Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Gilbert30Output");

        g1 = Graph.graphGeneratorGilbert(100,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert100Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Gilbert100Output");

        g1 = Graph.graphGeneratorGilbert(500,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Gilbert500Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Gilbert500Output");



        g1 = Graph.graphGeneratorBarabasiAlbert(30,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("BarabasiAlbert30Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("BarabasiAlbert30Output");

        g1 = Graph.graphGeneratorBarabasiAlbert(100,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("BarabasiAlbert100Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("BarabasiAlbert100Output");

        g1 = Graph.graphGeneratorBarabasiAlbert(500,15,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("BarabasiAlbert500Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("BarabasiAlbert500Output");




        g1 = Graph.graphGeneratorGeographic(30,0.2,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic30Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Geographic30Output");

        g1 = Graph.graphGeneratorGeographic(100,0.3,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic100Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Geographic100Output");

        g1 = Graph.graphGeneratorGeographic(500,0.2,false,false);
        g1.randomEdgeValues(1,100);
        g1.writeGephiFileW("Geographic500Input");
        g2 = g1.Dijkstra((g1.Nodes.get(0)));
        g2.writeGephiFile("Geographic500Output");
        */
    }
}
