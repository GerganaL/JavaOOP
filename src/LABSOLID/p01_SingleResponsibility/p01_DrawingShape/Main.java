package LABSOLID.p01_SingleResponsibility.p01_DrawingShape;

public class Main {
    public static void main(String[] args) {
        ShapeRepository shapeRepository = new ShapeRepository();

        DrawingManagerImpl drawingManager = new DrawingManagerImpl(shapeRepository, new RendererImpl());

        shapeRepository.addShape(new Rectangle(12,13));
        shapeRepository.addShape(new Circle());

        drawingManager.drawAll();
    }
}
