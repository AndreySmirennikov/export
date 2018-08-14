package shapes.maps;

/**
 * Created by User on 26.05.2018.
 */
public class TriangleFactoryImpl implements TriangleFactory {
    Vertex v1;
    Vertex v2;
    Vertex v3;
    TriangleFactoryImpl(int x1,int y1,int x2,int y2,int x3,int y3){
        v1= new Vertex(x1,y1);
        v2= new Vertex(x2,y2);
        v3= new Vertex(x3,y3);
    }
    public Polygon getTriangle() {
        return new Polygon(v1,v2,v3);
    }
}
