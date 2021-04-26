package lab10_3;

import java.io.*;

public interface FileUtil {
    public static void encode(String inputFileName, String outputFileName)
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

    public static void decode(String inputFileName, String outputFileName) throws IOException{
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
