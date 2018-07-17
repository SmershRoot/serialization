package ru.sbt.serialization;

import java.io.*;

public class Test {

    public static void main( String... args ) throws IOException, ClassNotFoundException {
        SerializablePoint somePoint = new SerializablePoint( 1.0, 1.0, "test" );

/*        try ( FileOutputStream fos = new FileOutputStream( "test.txt" );
              ObjectOutputStream out = new ObjectOutputStream( fos ) ) {
            out.writeObject( somePoint );
        }*/

        try ( FileInputStream fis = new FileInputStream( "test.txt" );
              ObjectInputStream in = new ObjectInputStream( fis ) ) {
            SerializablePoint deserealized = ( SerializablePoint ) in.readObject();

            System.out.println( "deserealized.getName():" + deserealized.getName() );

            System.out.println( somePoint.equals( deserealized ) );
            System.out.println( "fields:" );
            System.out.println( somePoint.getX() == deserealized.getX() );
            System.out.println( somePoint.getY() == deserealized.getY() );
            System.out.println( somePoint.getName() == deserealized.getName() );
            System.out.println( somePoint.getName().equals( deserealized.getName() ) );
        }

        /*try ( FileInputStream fis = new FileInputStream( "test.txt" ) ) {
            for ( int i = 0; i < fis.available(); i++)
                //System.out.print( Integer.toHexString( fis.read() ) );
                System.out.print( String.format("%02X", fis.read() & 0xFFFFF) );

        }*/
    }
}
