package net.codestory2;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

public class Main
{
    private Multimap<String, Geek> likes = ArrayListMultimap.create();

    private Multimap<String, Geek> hates = ArrayListMultimap.create();

    private Map<String, Geek> geeksByEmail = Maps.newHashMap();

    public void parse(InputStream res)
    {
        try
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
        catch (JsonParseException e)
        {
            throw new RuntimeException(e);
        }
        catch (JsonMappingException e)
        {
            throw new RuntimeException(e);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public Geek getGeek(String name)
    {
        return geeksByEmail.get(name);
    }

    public Main()
    {
        try
        {
            parse(Main.class.getResource("/codestory2013.json").openStream());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
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

    public Set<Geek> getGeeksWhoLikeTheSameThings(Geek geek)
    {
        Set<Geek> geeks = Sets.newHashSet();
        geeks.addAll(getIfNotNull(likes, geek.getLike1()));
        geeks.addAll(getIfNotNull(likes, geek.getLike2()));
        geeks.addAll(getIfNotNull(likes, geek.getLike3()));
        geeks.remove(geek);
        return geeks;
    }

    public Set<Geek> getGeeksWhoHateTheSameThings(Geek geek)
    {
        Set<Geek> geeks = Sets.newHashSet();
        geeks.addAll(getIfNotNull(hates, geek.getHate1()));
        geeks.addAll(getIfNotNull(hates, geek.getHate2()));
        geeks.remove(geek);
        return geeks;
    }
    
    public class GradedGeek implements Comparable<GradedGeek> {
        Geek geek;
        int grade;
        
        public GradedGeek(Geek geek, int grade)
        {
            super();
            this.geek = geek;
            this.grade = grade;
        }

        public int compareTo(GradedGeek o)
        {
            return Integer.valueOf(grade).compareTo(o.grade);
        }

        @Override
        public String toString()
        {
            return "GradedGeek [geek=" + geek + ", grade=" + grade + "]";
        }
        
        
    }
    public List<GradedGeek> getGradedFriends(Geek geek)
    {
        Set<Geek> geeks = Sets.newHashSet();
        geeks.addAll(getGeeksWhoLikeTheSameThings(geek));
        geeks.addAll(getGeeksWhoHateTheSameThings(geek));
        
        ArrayList<GradedGeek> geekGrades = Lists.newArrayList();
        for (Geek g2 : geeks)
        {
            geekGrades.add(new GradedGeek(geek, calcGrade(geek, g2)));
        }
        Collections.sort(geekGrades);
        return geekGrades;
    }

   private int calcGrade(Geek geek, Geek g2)
    {
        int grade=0;
        
        if (geek.getLike1().equals(g2.getLike1())) grade+=10;
        if (geek.getLike1().equals(g2.getLike2()) || geek.getLike2().equals(g2.getLike1())) grade+=8;
        if (geek.getLike1().equals(g2.getLike3()) || geek.getLike3().equals(g2.getLike1())) grade+=5;
        if (geek.getLike2().equals(g2.getLike2()) ) grade+=5;
        if (geek.getLike2().equals(g2.getLike3()) || geek.getLike3().equals(g2.getLike2())) grade+=3;
        if (geek.getLike3().equals(g2.getLike3()) ) grade+=1;
        
        if (geek.getHate1().equals(g2.getHate1())) grade+=10;
        if (geek.getHate1().equals(g2.getHate2()) || geek.getHate2().equals(g2.getHate1())) grade+=8;
        if (geek.getHate2().equals(g2.getHate2())) grade+=5;
        return grade;
    }

 private Collection<Geek> getIfNotNull(Multimap<String, Geek> maps, String like)
    {
        return (like != null) ? maps.get(like) : (List<Geek>) Collections.<Geek> emptyList();
    }
}
