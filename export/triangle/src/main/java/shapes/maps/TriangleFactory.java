package shapes.maps;

/**
 * Factory returning random triangles.
 */
public interface TriangleFactory {
  /**
   * @return a triangle
   */
  Polygon getTriangle();
}
