/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wikinews;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

/**
 *
 * @author dimitra
 */
public class JsonUtils {
    
    private static final Type MAP_TYPE = new TypeToken<Map<String, Map>>(){}.getType();  

    
    public static Article getWikinewsContentFromJson(String jsonStr) {
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonStr).getAsJsonObject();
        JsonObject pages = json.get("query").getAsJsonObject()
                               .get("pages").getAsJsonObject();
        String articleId = pages.keySet().iterator().next();
        JsonObject articleIdJson = pages.get(articleId).getAsJsonObject();
        
        String title = articleIdJson.get("title").getAsString();
        
        String content = articleIdJson.get("revisions").getAsJsonArray()
                                    .get(0).getAsJsonObject()
                                    .get("*").getAsString();
        return new Article(title, content);
    }

    public static Map<String, String[]> getJsonMap(String jsonStr) {
        return new Gson().fromJson(jsonStr, MAP_TYPE);
    }

}
