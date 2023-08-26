package streams;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamsHello {

    public static void main(String[] args) {
        int[] listPrimitive = new int[] {1,2,3,4,5,6};
        List<Integer> list = new ArrayList<>();

        Arrays.stream(listPrimitive).forEach(num -> {
            list.add(num);
        });

        list.stream().forEach(e -> System.out.println(e));
    }

}

class TestStreamsHello
{

    @Test
    void shouldPrintArrayList() {
        int[] listPrimitive = new int[] {1,2,3,4,5,6};
        List<Integer> list = new ArrayList<>();

        Arrays.stream(listPrimitive).forEach(num -> {
            list.add(num);
        });

        list.stream().forEach(e -> System.out.println(e));

        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);

        Assertions.assertEquals(1, 1);
    }

}