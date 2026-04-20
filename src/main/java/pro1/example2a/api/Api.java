package pro1.example2a.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Api {

    private static HttpClient client = HttpClient.newBuilder().build();
    private static String baseUrl = "https://stag-demo.uhk.cz/ws/services/rest2";

    public static String getActionsByRoom(String room, String term, int year)
    {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) { }
        return getFromUri(baseUrl+"/rozvrhy/getRozvrhByMistnost?semestr="+term+"&rok="+year+"&budova=J&mistnost="+room+"&outputFormat=json");
    }

    private static String getFromUri(String uri)
    {
        try {
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(uri)).build();
            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            return null;
        }
    }
}

