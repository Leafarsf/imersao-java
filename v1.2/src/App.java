import java.io.InputStream;
import java.net.URI;
import java.net.URL;
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


        ///extrair (parsear) só os dados q precisa (titulo, poster, classificação)
        var Parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = Parser.parse(body);

        // exibir e manipular os dados
        System.out.println("\u001b[31m Top 10 Filmes do top 250 geral do IMDB: \u001b[0m");

        for (int i = 0; i < 10; i++) {

            Map<String,String> filme = listaDeFilmes.get(i);
            
            String urlImagem = filme.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
            String nomeFilme = filme.get("title");
            
            InputStream inputStream = new URL(urlImagem).openStream();

            String nomeArquivo = nomeFilme + ".png";

            var gerar = new geradorDeFigurinhas();
            gerar.cria(inputStream, nomeArquivo);
            System.out.println("imprimindo..." + filme.get("title"));
        
        }    
        }

       
        }
        
        
        
