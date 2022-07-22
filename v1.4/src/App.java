import java.io.InputStream;
import java.net.URL;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        String url = "https://alura-api.herokuapp.com/linguagens";
        ClienteHttp Http = new ClienteHttp();
        String json = Http.buscaDados(url);

        // caso queria da IMDB, só mudar para extratorconteudoimdb
        extratorConteudo extrator = new extratorConteudoLinguagens();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        // var geradora = new geradorDeFigurinhas();

        for (int i = 0; i < 5; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();

            String nomeArquivo = conteudo.getTitulo() + ".png";

            var gerar = new geradorDeFigurinhas();
            gerar.cria(inputStream, nomeArquivo);
            System.out.println("imprimindo..." + conteudo.getTitulo());
        
        }    
        }

       
        }
        
        
        
