package zhou160._1;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {

        List<List<Integer>> list = new ArrayList<>();

        for (int x = 0; x < z; x++) {
            for (int y = 0; y < z; y++) {

                if (customfunction.f(x, y) == z) {
                    List<Integer> li = new ArrayList<>();
                    li.add(x);
                    li.add(y);
                    list.add(li);
                }
            }
        }

        return list;
    }
}