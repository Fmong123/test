
import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Shape> shapes;

    public Layer() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }

    public void removeCircles() {
        this.shapes.removeIf(shape -> shape instanceof Circle);
    }

    /**
     *cmt.
     */
    public String getInfo() {
        StringBuilder info = new StringBuilder();
        info.append("Layer of crazy shapes:\n");
        for (Shape shape : shapes) {
            info.append(shape.toString());
            info.append("\n");
        }
        return info.toString();
    }

    /**
     *cmt.
     */
    public void removeDuplicates() {
        for (int i = 0; i < shapes.size(); i++) {
            for (int j = i + 1; j < shapes.size(); j++) {
                if (shapes.get(i).equals(shapes.get(j))) {
                    shapes.remove(j);
                    j--;
                }
            }
        }
    }
}
