package com.graphic;

import org.junit.Test;

/**
 * Created by RoyChan on 2018/5/25.
 */
public class Test1 {

    @Test
    public void t() {
        int n = 5;
        for (int j = 1; j <= n; j++) {
            int s = 1 << j, k = (1 << n) - s, x;
            for (int y = s - j; y >= 0; y--) {
                System.out.println();
                for (x = 0; x < y + k; x++) System.out.printf("  ");
                for (x = 0; x + y < s; x++) System.out.printf("%c ", '!' ^ y & x);
                for (x = 1; x + y < s; x++) System.out.printf("%c ", '!' ^ y & (s - y - x - 1));
            }
        }
    }

}