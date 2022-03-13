package il.ac.hac.cs;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        try (FileWriter writer = new FileWriter("characters");
             FileOutputStream fileOutputStream = new FileOutputStream("bytes");
             DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("numbers"))) {

            // Writing characters to file:
            writer.write('a');
            writer.write('\n');
            writer.write('א');
            writer.write('\n');
            writer.write("Hello World!");

            // Writing bytes to file (use a hex editor like neo to view the file):
            fileOutputStream.write('a'); // will write the ASCII value of 'a'
            fileOutputStream.write(-1);
            fileOutputStream.write('א'); // will write the lower byte of the unicode value of 'א'
            fileOutputStream.write(-1);
            fileOutputStream.write(1);  // will write 1
            fileOutputStream.write(-1);
            fileOutputStream.write(256); // will write 0

            // Writing numbers to file:
            dataOutputStream.writeShort('a'); // will write the unicode value of 'a'
            dataOutputStream.write(-1);
            dataOutputStream.writeShort('א'); // will write the unicode value of 'א'
            dataOutputStream.write(-1);
            dataOutputStream.write(256); // will still write 0
            dataOutputStream.write(-1);
            dataOutputStream.writeInt(256); // will write 256
            dataOutputStream.write(-1);
            dataOutputStream.writeDouble(256); // will write 256 in double precision floating point standard


        } catch (IOException e) {
            System.err.println("Error opening file or reading from it: " + e.getMessage());
        }
    }
}
