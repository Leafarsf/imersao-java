import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        // pegar os dados do IMDB, fazer a conexão com a API (http) e salvar os dados em string e pegar os top 250 filmes
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //pegar os dados do IMDB de filmes mais populares no momento, fazer a conexão com a API (http) e salvar os dados em string e pegar os dados
        String url2 = "https://imdb-api.com/en/API/MostPopularMovies/k_r7yaoikw";
        URI endereco2 = URI.create(url2);
        var client2 = HttpClient.newHttpClient();
        var request2 = HttpRequest.newBuilder(endereco2).GET().build();
        HttpResponse<String> response2 = client2.send(request2, BodyHandlers.ofString());
        String body2 = response2.body();

        String url3 = "https://imdb-api.com/en/API/MostPopularTVs/k_r7yaoikw";
        URI endereco3 = URI.create(url3);
        var client3 = HttpClient.newHttpClient();
        var request3 = HttpRequest.newBuilder(endereco3).GET().build();
        HttpResponse<String> response3 = client3.send(request3, BodyHandlers.ofString());
        String body3 = response3.body();

        ///extrair (parsear) só os dados q precisa (titulo, poster, classificação)
        var Parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = Parser.parse(body);

        var Parser2 = new JsonParser();
        List<Map<String, String>> listaDeFilmesPop = Parser2.parse(body2);

        var Parser3 = new JsonParser();
        List<Map<String, String>> listaDeSeriesPop = Parser3.parse(body3);

        // exibir e manipular os dados
        System.out.println("\u001b[31m Filmes do top 250 geral do IMDB: \u001b[0m");

        for (Map<String,String> filme : listaDeFilmes) {
            
            System.out.println("---------------------------------");
            System.out.println("Titulo: " + filme.get("title"));
            System.out.println("Poster: " + filme.get("image"));
            System.out.println("Classificação: " + filme.get("imDbRating"));
            System.out.println("---------------------------------");
            
        }
        
        System.out.println("\u001b[31mTop 10 filmes do IMDB atualmente: \u001b[0m ");

        for(int i = 0; i < 10; i++) {
            System.out.println("---------------------------------");
            System.out.println("Titulo: " + listaDeFilmesPop.get(i).get("title"));
            System.out.println("Poster: " + listaDeFilmesPop.get(i).get("image"));
            System.out.println("Classificação: " + listaDeFilmesPop.get(i).get("imDbRating"));
            System.out.println("---------------------------------");
        }
        

        System.out.println("\u001b[31mTop 10 series do IMDB atualmente: \u001b[0m");

        for(int i = 0; i <10; i++) {
            System.out.println("---------------------------------");
            System.out.println("Titulo: " + listaDeSeriesPop.get(i).get("title"));
            System.out.println("Poster: " + listaDeSeriesPop.get(i).get("image"));
            System.out.println("Classificação: " + listaDeSeriesPop.get(i).get("imDbRating"));
            System.out.println("---------------------------------");
        }
        }
        
        }
        
