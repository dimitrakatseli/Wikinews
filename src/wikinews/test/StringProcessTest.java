/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikinews.test;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import wikinews.StringProcess;
import wikinews.Utils;

/**
 *
 * @author dimitra
 */
public class StringProcessTest {
    
    public static void main(String[] args) throws IOException {
        //testRemoveBraces();
        //testReplaceWikiBrackets();
        //testReplaceWhitespace();
        testParseWikinewsText();
    }
    
    private static void testRemoveBraces() {
        String str = "{{Nikos }} Mr. {{Hello Dear Friend}} I am good";
        System.out.println(StringProcess.removeBraces(str));
    }
    
    private static void testReplaceWikiBrackets() {
        String str = "[[Nikos Wiki | Nikos ]] Mr. [[Hello |Dear Friend]] I am good";
        System.out.println(StringProcess.removeWikiBrackets(str));
    }
    
    private static void testReplaceWhitespace() {
        String str = "\n\n\n\tHello      \n\n How are\n\n you\n\n\n\t\t?";
        System.out.println("String before: \n" + str + "\n String after: ");
        System.out.println(StringProcess.replaceWhitespace(str));
    }
    
    private static void testParseWikinewsText() throws IOException {
        String str = Utils.readFile("apiarticle.json");
        String parsed_str = StringProcess.parseWikinewsContent(str);
        Utils.writeStringToFile("parsed_apiarticle.json", parsed_str);
    }
}
