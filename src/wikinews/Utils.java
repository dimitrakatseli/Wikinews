/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikinews;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 *
 * @author dimitra
 */
public class Utils {

    public static String readFile(String path) throws IOException {
        return readFile(path, Charset.defaultCharset());
    }

    public static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    public static void writeStringToFile(String path, String text) throws FileNotFoundException {
        try (PrintStream out = new PrintStream(new FileOutputStream(path))) {
            out.print(text);
        }
    }
}
