package com.lynas.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Иван Алексеевич on 28.07.2016.
 */
public class CompZPAscTest {

    @Test
    public void testCompare() throws Exception {
        CompZPAsc compZPAsc = new CompZPAsc();
        Firma firm1 = new Firma(1432, "Процессор", 12,8600);
        Firma firm2 = new Firma(228, "Куллер", 23,8600);
        assertEquals("Must be 1",0,compZPAsc.compare(firm1, firm2));
    }
}