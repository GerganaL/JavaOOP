package LABSOLID.p01_SingleResponsibility.p01_DrawingShape;

import LABSOLID.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import LABSOLID.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeRepository implements DrawingRepository {
  private   List<Shape> shapes = new ArrayList<>();


    @Override
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    @Override
    public void drawAll() {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }
}
