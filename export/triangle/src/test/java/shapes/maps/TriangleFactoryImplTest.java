package shapes.maps;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by User on 26.05.2018.
 */

class TriangleFactoryImplTest {

    public TriangleFactoryImpl triangleFactory;
    public Polygon p1;
    @BeforeEach
    void setUp() {
        p1=new Polygon(new Vertex(1,2),new Vertex(3,4),new Vertex(5,6));
        triangleFactory = new TriangleFactoryImpl(1,2,3,4,5,6);
    }

    @Test
    public void getTriangle() {
        assertTrue(triangleFactory instanceof TriangleFactory,"TriangleFactoryImplTest is not implements of TriangleFactory");
        assertNotSame(p1,triangleFactory.getTriangle(),"refer to the same object");
        assertEquals(p1.vertices[0].x,triangleFactory.getTriangle().vertices[0].x,"the coordinate x value is not equal to the value at initialization");
        assertEquals(p1.vertices[2].y,triangleFactory.getTriangle().vertices[2].y,"the coordinate y value is not equal to the value at initialization");
        assertEquals(p1.getClass(),triangleFactory.getTriangle().getClass(),"getTriangle return not Polygon");
    }

    @Test
    public void getTriangle_TrinagleTest() {
        assertEquals(3,triangleFactory.getTriangle().vertices.length,"the figure hasnt three vertices"); //test: the figure must has three vertices(Trinagle)
        assertFalse(triangleFactory.getTriangle().vertices[0].x==triangleFactory.getTriangle().vertices[1].x && triangleFactory.getTriangle().vertices[2].x==triangleFactory.getTriangle().vertices[1].x,"the x coordinates are equal");  //the x coordinates must are not equal
        assertFalse(triangleFactory.getTriangle().vertices[0].y==triangleFactory.getTriangle().vertices[1].y && triangleFactory.getTriangle().vertices[2].y==triangleFactory.getTriangle().vertices[1].y,"the x coordinates are  equal");  //the y coordinates musts are not equal
    }



}