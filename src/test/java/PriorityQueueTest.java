import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


class PriorityQueueTest {
    private static Stream<Arguments> stringIntAndListProvider() {

//        TODO: return Stream;
        return Stream.of(
            Arguments.of(new int[]{4, 2, 6}, new int[]{2, 4, 6}),
            Arguments.of(new int[]{5, 4, 2, 3}, new int[]{2, 3, 4, 5}),
            Arguments.of(new int[]{-2, 100, 21, 57}, new int[]{-2, 21, 57, 100}),
            Arguments.of(new int[]{-5, -9, 12, 0, 2}, new int[]{-9, -5, 0, 2, 12}),
            Arguments.of(new int[]{-3, 1, 11, 0, 9, 3}, new int[]{-3, 0, 1, 3, 9, 11})
        );
    }

    @ParameterizedTest(name="#{index} - Test with Argument={0},{1}")
    @MethodSource("stringIntAndListProvider")
    public void PriorityQueue_RunTest(int[] random_array, int[] correct_array) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        int[]   result = new int[random_array.length];

//      random_array add to PriorityQueue
        for (int i = 0; i < random_array.length; i++) {
            pq.add(random_array[i]);
        }

//      get PriorityQueue result
        for (int i = 0; i < random_array.length; i++) {
            result[i] = pq.poll();
        }
    }


//    TODO: 3 unique Exceptions
    @Test
    public void whenExceptionThrown_thenNewlyAddedItemIsNull() {

        Exception exception = assertThrows(NullPointerException.class, ()->{
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
            pq.add(null);
        });

        String expectedMsg = "NullPointerException";
        String ActualMsg = exception.toString();
        assertTrue(ActualMsg.contains(expectedMsg));
    }

    @Test
    public void whenExceptionThrown_thenIllegalCapacity() {

        Exception exception = assertThrows(IllegalArgumentException.class, ()->{
            int initialCapacity = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(initialCapacity);
        });

        String expectedMsg = "IllegalArgumentException";
        String actualMsg = exception.toString();
        assertTrue(actualMsg.contains(expectedMsg));
    }

    @Test
    public void whenExceptionThrown_thenInitializedWithNullCollection() {
        Exception exception = assertThrows(NullPointerException.class, ()->{
            ArrayList<Integer> nullCollection = null;
            PriorityQueue<Integer> pq = new PriorityQueue<Integer>(nullCollection);
        });

        String expectedMsg = "NullPointerException";
        String actualMsg = exception.toString();
        assertTrue(actualMsg.contains(expectedMsg));
    }
}