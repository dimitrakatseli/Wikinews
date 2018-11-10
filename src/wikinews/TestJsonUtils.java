/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikinews;

import java.io.IOException;

/**
 *
 * @author dimitra
 */
public class TestJsonUtils {
    public static void main(String[] args) throws IOException {
        testGetArticleContentFromJson();
    }
    
    private static void testGetArticleContentFromJson() throws IOException {
        String str = Utils.readFile("parsed_apiarticle.json");
        Article article = JsonUtils.getWikinewsContentFromJson(str);
        System.out.println(article);
    }
    
}
