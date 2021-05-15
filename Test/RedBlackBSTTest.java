import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.Test;


/*
@author Andrea Lam
@Author Esteban Aldana
 */

public class RedBlackBSTTest {

    @Test
    public void testContains() {
        String temporalesp = "Hola";
        String temporaleng = "Hello";
        RedBlackBST test = new RedBlackBST();
        test.put(temporaleng, temporalesp);
        boolean bandera = true;
        boolean resultado = test.contains(temporaleng);
        Assert.assertEquals(bandera, resultado);

    }

    @Test
    public void testPut()
    {
        String temporalesp = "Hola";
        String temporaleng = "Hello";
        RedBlackBST test = new RedBlackBST();
        test.put(temporaleng, temporalesp);

    }


}