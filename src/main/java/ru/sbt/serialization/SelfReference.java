package ru.sbt.serialization;

import java.io.*;

public class SelfReference {
    public static void main( String... args ) throws IOException, ClassNotFoundException {
        GraphNode cyclicGraph = new GraphNode();
        cyclicGraph.nextNode = cyclicGraph;

        serialize( "cyclic.txt", cyclicGraph );
        GraphNode deserialize = ( GraphNode ) deserialize( "cyclic.txt" );

        System.out.println( deserialize == deserialize.nextNode );

    }

    private static Object deserialize( String fileName ) throws IOException, ClassNotFoundException {
        try ( FileInputStream fis = new FileInputStream( "test.txt" );
              ObjectInputStream in = new ObjectInputStream( fis ) ) {
            return in.readObject();
        }
    }

    private static void serialize( String fileName, GraphNode cyclicGraph ) throws IOException {
        try ( FileOutputStream fos = new FileOutputStream( fileName );
              ObjectOutputStream out = new ObjectOutputStream( fos ) ) {
            out.writeObject( cyclicGraph );
        }
    }
}