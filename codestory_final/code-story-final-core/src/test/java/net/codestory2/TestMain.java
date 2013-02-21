package net.codestory2;

import static org.junit.Assert.*;

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
        Main main = new Main();
        Geek bvo = main.getGeek("bvo123@123mail.org");

        assertEquals("Benoît", bvo.getPrenom());
    }
}
