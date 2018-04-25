import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class BoundedMapTest {

    private BoundedMap sut;

    public void BoundedMapTest(){};

    @Test (expected = IllegalArgumentException.class)
    public void minSize1(){
        //arrange
        sut = new BoundedMap(0);
        int want = 1;
        //act
        sut.clear();
        int have = sut.size();
        //assert
        Assert.assertEquals (want,have);
    }

    @Test (timeout = 1_000)
    public void testCapacity1(){
        //arrange
        sut = new BoundedMap(0);
        int want = 1;
        //act
        int have = sut.size();
        //assert
        Assert.assertEquals(want,have);
    }

    @Test (timeout = 1_000)
    public void deletedAllEntries(){
        //arrange
        sut = new BoundedMap(10);
        int want = 0;
        //act
        sut.put(1,"Sim");
        sut.put(2, "Sala");
        sut.put(3, "Bim");
        sut.clear();
        int have = sut.size();
        //assert
        Assert.assertEquals(want,have);
    }

    @Test (timeout = 1_000)
    public void put3OrderedElements(){
        //arrange
        sut = new BoundedMap(3);
        HashMap<Integer, String> want = new HashMap<>() ;
        want.put(1, "x");
        want.put(2, "y");
        want.put(3, "z");
        //act
        BoundedMap have = sut;
        sut.put(1, "x");
        sut.put(2, "y");
        sut.put(3, "z");
        //assert
        Assert.assertEquals(want.entrySet(),have.entrySet());
    }

    @Test (timeout = 1_000)
    public void put4ElementsIn3BoundedMap(){
        //arrange
        sut = new BoundedMap(3);
        HashMap<Integer, String> want = new HashMap<>();
        want.put(2, "y");
        want.put(3, "z");
        want.put(4, "a");
        //act
        BoundedMap have = sut;
        sut.put(1,"x");
        sut.put(2,"y");
        sut.put(3,"z");
        sut.put(4,"a");
        //assert
        Assert.assertEquals(want.entrySet(), have.entrySet());
    }

    @Test (timeout = 1_000)
    public void put4Elements2SameInBoundedMap(){
        //arrange
        sut = new BoundedMap(3);
        HashMap<Integer, String> want = new HashMap<>();
        want.put(1, "x");
        want.put(2, "a");
        want.put(3, "z");
        //act
        BoundedMap have = sut;
        sut.put(1,"x");
        sut.put(2,"y");
        sut.put(3,"z");
        sut.put(2,"a");
        //assert
        Assert.assertEquals(want.entrySet(),have.entrySet());
    }

    @Test (timeout = 1_000)
    public void put5Elements2SameInBoundedMap(){
        //arrange
        sut = new BoundedMap(3);
        HashMap<Integer, String> want = new HashMap<>();
        want.put(1, "a");
        want.put(3, "z");
        want.put(4, "b");
        //act
        BoundedMap have = sut;
        sut.put(1,"x");
        sut.put(2,"y");
        sut.put(3,"z");
        sut.put(1,"a");
        sut.put(4,"b");
        //assert
        Assert.assertEquals(want.entrySet(),have.entrySet());
    }

    @Test (timeout = 1_000)
    public void clearThenPut(){
        //arrange
        sut = new BoundedMap(3);
        HashMap<Integer, String> want = new HashMap<>();
        want.put(1,"a");
        //act
        BoundedMap have = sut;
        sut.put(1, "x");
        sut.put(2,"y");
        sut.put(3, "z");
        sut.clear();
        sut.put(1, "a");
        //assert
        Assert.assertEquals(want.entrySet(), have.entrySet());
    }
}
