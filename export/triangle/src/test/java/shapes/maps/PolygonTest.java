package shapes.maps;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 26.05.2018.
 */
class PolygonTest {
    @Test
    public void PolygonTets_init(){
        Polygon p2;
        Vertex v1=new Vertex(1,1);
        Vertex v2=new Vertex(1,1);
        assertEquals(v1,new Polygon(v1,v2).vertices[0]," value is not equal to the value at initialization");
        assertEquals(v2,new Polygon(v1,v2).vertices[1]," value is not equal to the value at initialization");
        assertNotNull(p2=new Polygon(v1),"Objects return null");
    }
}