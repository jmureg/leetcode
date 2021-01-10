package arrays;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/*
https://leetcode.com/problems/reveal-cards-in-increasing-order/
 */
public class DeckRevealedIncreasing {
    public int[] deckRevealedIncreasing(int[] deck) {
        int N = deck.length;
        Deque<Integer> index = new LinkedList<>();
        for (int i = 0; i < N; ++i)
            index.add(i);

        int[] ans = new int[N];
        Arrays.sort(deck);
        for (int card: deck) {
            int n = index.pollFirst();
            ans[n] = card;
            if (!index.isEmpty())
                index.add(index.pollFirst());
        }

        return ans;
    }
    public static void main(String[] args) {
        DeckRevealedIncreasing dri = new DeckRevealedIncreasing();
        int[] deck = new int[]{17,13,11,2,3,5,7};
        System.out.println(Arrays.toString(dri.deckRevealedIncreasing(deck)));
    }
}
