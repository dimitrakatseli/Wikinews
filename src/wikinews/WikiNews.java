package wikinews;

import com.google.gson.Gson;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import net.sf.classifier4J.summariser.SimpleSummariser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author dimitra
 */
public class WikiNews {

    public static void main(String[] args) throws IOException {

        String json;
        String url = "https://en.wikinews.org/w/api.php?format=json&action=query&generator=random&grnnamespace=0&prop=revisions%7Cimages&rvprop=content&grnlimit=1";
        Article article;
        ArrayList<Article> list = new ArrayList();
        SimpleSummariser summariser = new SimpleSummariser();
        Writer writer2 = Files.newBufferedWriter(Paths.get("classifier/classifier4jen.txt"));
        Writer writerNLP = Files.newBufferedWriter(Paths.get("NLPdata/articleen.txt"));
        Writer writerT= Files.newBufferedWriter(Paths.get("besttitle/titlesen.txt"));
        String hd4;

        int i = 0;
        do {
            json = Jsoup.connect(url).ignoreContentType(true).execute().body();
            article = parseWikinewsFromJson(json);

            //if exists continue and not save
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).getBestTitle().equals(article.getBestTitle())) {
                    continue;
                }

            }

            list.add(article);
            i++;
            hd4 = summariser.summarise(article.getContent(), 1);
            System.out.println("Headline:  " + article.getBestTitle());
            System.out.println("");
            System.out.println("Classifier4J Headline:  " + hd4);
            System.out.println("");
            System.out.println("Content  " + article.getContent());
            System.out.println("");
            writer2.write(hd4 + System.getProperty( "line.separator" ));
            writerNLP.write(article.getContent() +System.getProperty( "line.separator" ));
            writerT.write(article.getBestTitle() +System.getProperty( "line.separator" ));

        } while (50 > list.size());

        writer2.close();
        writerNLP.close();
        writerT.close();

        Gson g = new Gson();
        Writer writer = Files.newBufferedWriter(Paths.get("data/english.json"));
        writer.write(g.toJson(list, ArrayList.class));
        writer.close();

    }

    private static Article parseWikinewsFromJson(String json)
            throws IOException {
        Article article = JsonUtils.getWikinewsContentFromJson(json);
        article.parseContent();
        return article;
    }

}
