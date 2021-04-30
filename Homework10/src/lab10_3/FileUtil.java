package lab10_3;

import java.io.*;

public interface FileUtil {
    // method which encodes the bytes of a file by incrementing each byte
    static void encode(String inputFileName, String outputFileName)
            throws IOException {
        InputStream in = new FileInputStream(inputFileName );
        OutputStream out = new FileOutputStream(outputFileName);
        int ch;
        while( (ch = in.read()) != -1 ){
            out.write((ch +1 ) % 256);
        }
        in.close();
        out.close();
    }

    // method for decoding the file
    static void decode(String inputFileName, String outputFileName) throws IOException{
        InputStream in = new FileInputStream(inputFileName );
        OutputStream out = new FileOutputStream(outputFileName);

        int ch;
        while((ch = in.read()) != -1){
            out.write((ch - 1) % 256);
        }

        in.close();
        out.close();
    }
}
