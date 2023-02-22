package book.fujava.filewriters;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterARM implements AutoCloseable {
    private final FileWriter writer;

    public FileWriterARM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public void close() throws IOException {
        writer.close();
        System.out.println("close called automatically");
    }

    public static void main(String[] args) throws IOException {

        try (final FileWriterARM writerExample = new FileWriterARM("peekaboo.txt")) {
            writerExample.writeStuff("peel-a-boo");
            System.out.println("done with resource");
        }
    }
}
