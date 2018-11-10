/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikinews;

/**
 *
 * @author dimitra
 */
public class StringProcess {
    public static String removeBraces(String str) {
        return str.replaceAll("\\{\\{[^\\{\\}]*\\}\\}", "");
    }
    
    public static String removeWikiBrackets(String str) {
        str = str.replaceAll("\\[\\[[^\\[\\]]*\\|\\s*([^\\[\\]]*)\\]\\]", "$1");
        return str.replaceAll("\\[\\[([^\\[\\]]*)\\]\\]", "$1");
    }
    
    public static String replaceWhitespace(String str) {
        return str.replaceAll("\\s+", " ").trim();
    }
    
    public static String parseWikinewsContent(String str) {
        String parsed = str.split("== Sources ==")[0];
        parsed = replaceWhitespace(removeWikiBrackets(removeBraces(parsed)));
        parsed = parsed.replaceAll("\\\\n", "");
        
        return parsed;
    }
}
