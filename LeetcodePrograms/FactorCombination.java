//#LinkedIn WeWorkQuestion
// 254  Factor Combination
package LeetcodePrograms;
import java.util.*;
/**
 * Created by rkhurana on 2/24/19.
 */
public class FactorCombination {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> item, int n, int start){
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
            }
            return;
        }

        for (int i = start; i <= n; ++i) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n/i, i);
                item.remove(item.size()-1);
            }
        }
    }
    public static void main(String []args){
        FactorCombination fc = new FactorCombination();
        System.out.println(fc.getFactors(12));
    }
}
