package book.fujava.filewriters;

import java.io.FileWriter;
import java.io.IOException;

public class FileWriterEAM {
    private final FileWriter writer;

    private FileWriterEAM(final String fileName) throws IOException {
        writer = new FileWriter(fileName);
    }

    private void close() throws IOException{
        System.out.println("autoclose called");
        writer.close();
    }
    public void writeStuff(final String message) throws IOException {
        writer.write(message);
    }

    public static void use(final String fileName,
                           final UseInstance<FileWriterEAM, IOException> block) throws IOException{
        final FileWriterEAM writerEAM = new FileWriterEAM(fileName);
        try {
            block.accept(writerEAM);
        } finally {
            writerEAM.close();
        }
    }

    public static void main(String[] args) {
        try {
            FileWriterEAM.use("eam.txt", writerEAM -> {
                writerEAM.writeStuff("how ");
                writerEAM.writeStuff("sweet ");
                writerEAM.writeStuff("it is");
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
