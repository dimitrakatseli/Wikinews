/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikinews;

import static wikinews.StringProcess.removeBraces;
import static wikinews.StringProcess.removeWikiBrackets;
import static wikinews.StringProcess.replaceWhitespace;

/**
 *
 * @author dimitra
 */
public class Article {
    
    private String bestTitle;
    private String content;

    public Article(String bestTitle, String content) {
        this.bestTitle = bestTitle;
        this.content = content;
    }

    public String getBestTitle() {
        return bestTitle;
    }

    public void setBestTitle(String bestTitle) {
        this.bestTitle = bestTitle;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    
    public void parseContent() {
        content = StringProcess.parseWikinewsContent(content);
    }

    @Override
    public String toString() {
        return "Article{" + "bestTitle=" + bestTitle + ", content=" + content + '}';
    }
    
    
}
