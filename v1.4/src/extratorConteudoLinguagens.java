import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class extratorConteudoLinguagens implements extratorConteudo {
    

    public List<Conteudo> extraiConteudos(String json){

        var Parser = new JsonParser();
        List<Map<String, String>> listadeAtributos = Parser.parse(json);

        List<Conteudo> conteudos = new ArrayList<>();

        //popular a lista de conteúdos
        for(Map<String, String> atributos : listadeAtributos) {
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image");
            var conteudo = new Conteudo(titulo, urlImagem);

            conteudos.add(conteudo);


        }
        return conteudos;
}

}
