package shapes.maps;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 26.05.2018.
 */

class VertexTest {

    @Test
    public void VertexTest_init(){

        Vertex v2;
        Vertex v1=new Vertex(1,2);
        assertEquals(1,v1.x," value is not equal to the value at initialization");
        assertEquals(2,v1.y," value is not equal to the value at initialization");
        assertNotNull(v2=new Vertex(2,2),"Objects return null");
    }

}