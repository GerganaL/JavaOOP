package LABSOLID.p01_SingleResponsibility.p01_DrawingShape;

import LABSOLID.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import LABSOLID.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;

public class RendererImpl implements Renderer {
    @Override
    public void render(Shape shape) {
        shape.draw();
    }
}
