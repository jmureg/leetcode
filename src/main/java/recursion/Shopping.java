package recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

public class Shopping {

    @Test
    public void test() {

        List<Integer> price = new ArrayList();
        price.add(2);
        price.add(5);

        List<List<Integer>> special = new ArrayList<List<Integer>>();
        List<Integer> one = new ArrayList();
        one.add(3);
        one.add(0);
        one.add(5);

        List<Integer> two = new ArrayList();
        two.add(1);
        two.add(2);
        two.add(10);

        special.add(one);
        special.add(two);

        List<Integer> needs = new ArrayList();
        needs.add(3);
        needs.add(2);

        assertEquals(14, shoppingOffers(price, special, needs));
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return shopping(price, special, needs);
    }

    public int shopping(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int j = 0, res = dot(needs, price);
        for (List<Integer> s : special) {
            ArrayList<Integer> clone = new ArrayList<Integer>(needs);
            for (j = 0; j < needs.size(); j++) {
                int diff = clone.get(j) - s.get(j);
                if (diff < 0)
                    break;
                clone.set(j, diff);
            }
            if (j == needs.size())
                res = Math.min(res, s.get(j) + shopping(price, special, clone));
        }
        return res;
    }

    public int dot(List<Integer> a, List<Integer> b) {
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            sum += a.get(i) * b.get(i);
        }
        return sum;
    }

}
