package net.codestory2;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

public class Main
{
    private Multimap<String, Geek> likes = ArrayListMultimap.create();
    
    private Multimap<String, Geek> hates = ArrayListMultimap.create();
    
    
    public void parse(InputStream res) throws Exception{
        JsonParser jsonParser = null;

        jsonParser = new JsonFactory().createJsonParser(res);
        ObjectMapper mapper = new ObjectMapper();
        List<Geek> geeks = mapper.readValue(jsonParser, new TypeReference<List<Geek>>()
        {
        });
        for (Geek geek : geeks)
        {
            likes.put(geek.getLike1(), geek);
            likes.put(geek.getLike2(), geek);
            likes.put(geek.getLike3(), geek);
            hates.put(geek.getHate1(), geek);
            hates.put(geek.getHate2(), geek);
        }
    }
    
    
    public Main() throws Exception
    {
        parse(Main.class.getResource("/codestory2013.json").openStream());
    }
    
    public static void main(String[] args) throws Exception
    {
        Main instance = new Main();
    }
}
