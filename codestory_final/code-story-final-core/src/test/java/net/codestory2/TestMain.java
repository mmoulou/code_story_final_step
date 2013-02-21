package net.codestory2;

import static org.junit.Assert.assertEquals;

import java.util.Set;

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
        
        Set<Geek> geeks=instance.getGeeksThatLikeTheSameThings(bvo);
        System.out.println(geeks.size());
    }
    
    @Test
    public void testSameHatesAsMe() throws Exception
    {
        Geek bvo = instance.getGeek("bvo123@123mail.org");
        
        Set<Geek> geeks=instance.getGeeksThatHateTheSameThings(bvo);
        System.out.println(geeks.size());
    }
    
//    @Test
//    public void testOrderedFriends() throws Exception
//    {
//        Geek bvo = instance.getGeek("bvo123@123mail.org");
//        
//        Set<Geek> geeks=instance.getOrderedGeeks(bvo);
//        System.out.println(geeks.size());
//    }
}
