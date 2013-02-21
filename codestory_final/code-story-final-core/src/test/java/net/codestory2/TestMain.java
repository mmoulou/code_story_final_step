package net.codestory2;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import net.codestory2.Main.GradedGeek;

import org.junit.Before;
import org.junit.Test;

public class TestMain
{
    private Main instance;

    @Before
    public void before() throws Exception
    {
        instance = new Main();
    }

    @Test
    public void testGetGeek() throws Exception
    {
        Geek bvo = instance.getGeek("bvo123@123mail.org");

        assertEquals("Benoît", bvo.getPrenom());
    }
    
    @Test
    public void testSameLikesAsMe() throws Exception
    {
        Geek bvo = instance.getGeek("bvo123@123mail.org");
        
        Set<Geek> geeks=instance.getGeeksWhoLikeTheSameThings(bvo);
        assertEquals(17, geeks.size());
    }
    
    @Test
    public void testSameHatesAsMe() throws Exception
    {
        Geek bvo = instance.getGeek("bvo123@123mail.org");
        
        Set<Geek> geeks=instance.getGeeksWhoHateTheSameThings(bvo);
        assertEquals(1, geeks.size());
    }
    
    @Test
    public void testFindGradedFriends() throws Exception
    {
        Geek bvo = instance.getGeek("bvo123@123mail.org");
        
        List<GradedGeek> geeks=instance.getGradedFriends(bvo);
        System.out.println(geeks.toString());
    }
}
