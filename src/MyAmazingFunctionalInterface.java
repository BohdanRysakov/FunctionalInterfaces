import java.util.List;
import java.util.Map;

//This Functional Interface creates Map of Graph, where Key is node and value(List) is his edges to another nodes
@FunctionalInterface
public interface MyAmazingFunctionalInterface {

    Map<String, List<String>> doGraph();
}
