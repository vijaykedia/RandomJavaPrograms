package com.codility;

import org.jetbrains.annotations.NotNull;

/**
 * Created by vijaykedia on 18/10/15.
 */
public class EquilibriumIndex {

    public static void main(final String[] args) {
        final int[] input = new int[] {1, 1, 1, 1, 2, 1};
        System.out.print(equilibriumIndex(input, 1));
    }

    private static int equilibriumIndex(@NotNull final int[] A, final int X) {
        final int[] index = new int[A.length];
        int j = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == X) {
                index[j++] = i;
            }
        }

        for (int i = 0; i < j; i++) {
            if ((i + 1) == (A.length - (index[i] + 1) - (j - (i + 1)))) {
                return i + 1;
            }
        }
        return -1;
    }
}
