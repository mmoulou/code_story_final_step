package net.codestory2;

import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class Main
{
    private Multimap<String, Geek> likes = ArrayListMultimap.create();

    private Multimap<String, Geek> hates = ArrayListMultimap.create();

    private Map<String, Geek> geeksByEmail = Maps.newHashMap();

    public void parse(InputStream res) throws Exception
    {
        JsonParser jsonParser = null;

        jsonParser = new JsonFactory().createJsonParser(res);
        ObjectMapper mapper = new ObjectMapper();
        List<Geek> newGeeks = mapper.readValue(jsonParser, new TypeReference<List<Geek>>()
        {
        });
        for (Geek geek : newGeeks)
        {
            geeksByEmail.put(geek.getEmail(), geek);
            likes.put(geek.getLike1(), geek);
            likes.put(geek.getLike2(), geek);
            likes.put(geek.getLike3(), geek);
            hates.put(geek.getHate1(), geek);
            hates.put(geek.getHate2(), geek);
        }
    }

    public Geek getGeek(String name)
    {
        return geeksByEmail.get(name);
    }

    public Main() throws Exception
    {
        parse(Main.class.getResource("/codestory2013.json").openStream());
    }

    public static void main(String[] args) throws Exception
    {
        Main instance = new Main();
        instance.dump();
    }

    private void dump()
    {
        for (Geek geek : geeksByEmail.values())
        {
            System.out.println(geek);
        }
    }

    public Set<Geek> getGeeksThatLikeTheSameThings(Geek geek)
    {
        Set<Geek> geeks = Sets.newHashSet();
        geeks.addAll(getIfNotNull(likes, geek.getLike1()));
        geeks.addAll(getIfNotNull(likes, geek.getLike2()));
        geeks.addAll(getIfNotNull(likes, geek.getLike3()));
        return geeks;
    }

    public Set<Geek> getGeeksThatHateTheSameThings(Geek geek)
    {
        Set<Geek> geeks = Sets.newHashSet();
        geeks.addAll(getIfNotNull(hates, geek.getHate1()));
        geeks.addAll(getIfNotNull(hates, geek.getHate2()));
        return geeks;
    }

    private Collection<Geek> getIfNotNull(Multimap<String, Geek> maps, String like)
    {
        return (like != null) ? maps.get(like) : (List<Geek>) Collections.<Geek> emptyList();
    }
}
