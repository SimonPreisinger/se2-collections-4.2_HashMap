/**
 * @author simon
 */
public class BoundedMapMain {
    // CHECKSTYLE:OFF MagicNumber
    public static void main(String... args){
        final BoundedMap boundedMap = new BoundedMap(20);
        boundedMap.put(2,"jo");
        boundedMap.put(2,"bert");
        boundedMap.put(4,"lo");
        boundedMap.put(23, "yo");
        boundedMap.put(23, "lo");
        boundedMap.entrySet();
        System.out.print(boundedMap.entrySet());
    }
    //CHECKSTYLE:ON
}
