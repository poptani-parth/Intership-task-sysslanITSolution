//Web scraping using JSoup.

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Task_17 {
    public static void main(String[] args) {
        try {
            // Connect to website
            String url = "https://example.com";
            Document doc = Jsoup.connect(url).get();

            // Print page title
            System.out.println("Page Title: " + doc.title());

            // Extract all links
            Elements links = doc.select("a[href]");

            System.out.println("\n--- Links ---");
            for (Element link : links) {
                String text = link.text();
                String href = link.attr("href");

                System.out.println(text + " -> " + href);
            }

        } catch (Exception e) {
            System.out.println("Error fetching data.");
        }
    }
}