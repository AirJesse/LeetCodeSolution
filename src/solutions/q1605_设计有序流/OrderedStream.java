package solutions.q1605_设计有序流;

import java.util.ArrayList;
import java.util.List;

public class OrderedStream {

    int ptr;
    String[] stream;

    public OrderedStream(int n) {
        stream = new String[n + 1];
        ptr = 1;
    }

    public List<String> insert(int idKey, String value) {
        List<String> result = new ArrayList<>();
        stream[idKey] = value;
        while (ptr < stream.length && stream[ptr] != null) {
            result.add(stream[ptr++]);
        }
        return result;
    }
}
