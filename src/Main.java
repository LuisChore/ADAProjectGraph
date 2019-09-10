
/***
 * VÁZQUEZ CHOREÑO LUIS ERNESTO
 * Centro de Investigación en Computación
 * 2019
 *
 */

public class Main {

    public static void main(String args[]){


        Graph<Integer> g1 = Graph.graphGeneratorErdosRenyi(30,20,false,false);
        g1.writeGephiFile("Erdos30");

        Graph<Integer> g2 = Graph.graphGeneratorErdosRenyi(100,50,false,false);
        g2.writeGephiFile("Erdos100");

        Graph<Integer> g3 = Graph.graphGeneratorErdosRenyi(500,100,false,false);
        g3.writeGephiFile("Erdos500");


        Graph<Integer> g4 = Graph.graphGeneratorGilbert(30,0.7,false,false);
        g4.writeGephiFile("Gilbert30");


        Graph<Integer> g5 = Graph.graphGeneratorGilbert(100,0.5,false,false);
        g5.writeGephiFile("Gilbert100");

        Graph<Integer> g6 = Graph.graphGeneratorGilbert(500,0.3,false,false);
        g6.writeGephiFile("Gilbert500");

        Graph<Integer> g7 = Graph.graphGeneratorBarabasiAlbert(30,10,false,false);
        g7.writeGephiFile("Albert30");

        Graph<Integer> g8 = Graph.graphGeneratorBarabasiAlbert(100,20,false,false);
        g8.writeGephiFile("Albert100");

        Graph<Integer> g9 = Graph.graphGeneratorBarabasiAlbert(500,100,false,false);
        g9.writeGephiFile("Albert500");

        Graph<Coordinate> g10 = Graph.graphGeneratorGeographic(30,0.4,false,false);
        g10.writeGephiFile("Geographic30");


        Graph<Coordinate> g11 = Graph.graphGeneratorGeographic(100,0.3,false,false);
        g11.writeGephiFile("Geographic100");

        Graph<Coordinate> g12 = Graph.graphGeneratorGeographic(500,0.2,false,false);
        g12.writeGephiFile("Geographic500");
    }
}
