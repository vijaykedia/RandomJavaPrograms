package com.hackerearth;

import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by vijaykedia on 01/11/15.
 * <p>
 * Problem Statement
 * Navi is a famous shopkeeper in his locality. He gives discounts to his regular customers.
 * Some new rules have been made due to which he is in trouble.
 * According to the new rules, any shopkeeper can sale his items to only one customer in a day.
 * But every customer has some issues like the total money they have or the total weight they can handle at a time or number of items they are interested in.
 * Navi’s friend has decided to help Navi and he promised him that he will purchase items from his shop daily and try to maximize his sale in terms of total price with satisfying the count of items and weight of the items.
 * He will give his requirements as Wmax (maximum weight he can carry) and C (maximum count of the items he can carry).
 * Now Navi is interested in knowing the total price of the items he can sell.
 * <p>
 * Input
 * First line of input will contain D (total number of days).
 * Then for each day first line will contain N (Number of items).
 * Next each N lines will contains two integers P (price of ith item on that day) and W(weight of ith item on that day) separated by a space.
 * Last line for the input of the particular day will contain Wmax and C separated by a space.
 * <p>
 * Output
 * For each day output “For Day #day_number:” then in next line print the maximum total price.
 * If his friend is not able to purchase any of the item then print -1.
 * <p>
 * Constraints
 * 1 < = D < = 10
 * 1 < = N < = 16
 * 1 < = C < = 20
 * 1 < = Pi , Wi , Wmax < = 109
 * <p>
 * Sample Input(Plaintext Link)
 * 1
 * 3
 * 10 20
 * 20 30
 * 30 40
 * 50 2
 * <p>
 * Sample Output(Plaintext Link)
 * For Day #1:
 * 30
 * <p>
 * Explanation
 * He will buy first and second item.
 */
public class NaviAndHisFriend {

    public static void main(@NotNull final String[] args) throws IOException {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        final int numberOfDays = Integer.parseInt(line);
        for (int i = 0; i < numberOfDays; i++) {

            // Read inputs for each day
            line = br.readLine();
            final int numberOfItems = Integer.parseInt(line);
            final int[] priceOfItems = new int[numberOfItems];
            final int[] weightOfItems = new int[numberOfItems];

            for (int j = 0; j < numberOfItems; j++) {
                line = br.readLine();
                final String[] temp = line.split(" ");
                priceOfItems[i] = Integer.parseInt(temp[0]);
                weightOfItems[i] = Integer.parseInt(temp[1]);
            }

            line = br.readLine();
            final String[] temp = line.split(" ");
            final int maxWeight = Integer.parseInt(temp[0]);
            final int maxCount = Integer.parseInt(temp[1]);

            // Calculate output
            final long[][] lookup = new long[priceOfItems.length][maxWeight];

            long currentPrice = knapsack(lookup, numberOfItems - 1, maxWeight - 1, weightOfItems, priceOfItems);

            for (long[] aLookup : lookup) {
                System.out.println(Arrays.toString(aLookup));
            }
            // Print output
            System.out.println("For Day #" + i + ":");
            System.out.print(currentPrice);
        }
    }

    private static long knapsack(final long[][] lookup, final int index, final int size, final int weights[], final int values[]) {


        System.out.println("---------------");
        for (long[] aLookup : lookup) {
            System.out.println(Arrays.toString(aLookup));
        }
        System.out.println("---------------");

        long take = 0;

        if (lookup[index][size] != 0) {
            return lookup[index][size];
        }

        if (index == 0) {
            if (weights[0] <= size) {
                lookup[index][size] = values[0];
                return values[0];
            } else {
                lookup[index][size] = 0;
                return 0;
            }
        }

        if (weights[index] <= size) {
            take = values[index] + knapsack(lookup, index - 1, size - (int) weights[index], weights, values);
        }

        long dontTake = knapsack(lookup, index - 1, size, weights, values);

        lookup[index][size] = take > dontTake ? take : dontTake;

        return lookup[index][size];
    }
}
