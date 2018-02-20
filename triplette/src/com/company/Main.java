package com.company;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {
    static class Triplette {
        int a, b, c;

        Triplette(int a, int b, int c) {
            int[] array = new int[] {a,b,c};
            Arrays.sort(array);

            this.a = array[0];
            this.b = array[1];
            this.c = array[2];
        }

        @Override
        public boolean equals(Object arg0) {
            Triplette t = (Triplette)arg0;

            if(this.a == t.a && this.b == t.b && this.c == t.c)
            {
                return true;
            }
            return false;
        }


        @Override
        public int hashCode() {
            return Objects.hash(a, b, c);
        }
    }

    public static void main(String[] args) {
        for (Triplette triplette: findTripletteCubic(new int[] {5, -3, 0, 4, -2, 1, -1, 2, 3})) {
            System.out.print("[ " + triplette.a + " " + triplette.b + " " + triplette.c + " ] ");
        }
        System.out.println();

        for (Triplette triplette: findTriplette(new int[] {5, -3, 0, 4, -2, 1, -1, 2, 3})) {
            System.out.print("[ " + triplette.a + " " + triplette.b + " " + triplette.c + " ] ");
        }
        System.out.println();
    }


    public static Set<Triplette> findTripletteCubic(int[] array) {
        Set<Triplette> triplette = new HashSet<Triplette>();

        for (int i=0; i<array.length; i++) {
            for (int j=0; j<array.length; j++) {
                for (int l=0; l<array.length; l++) {
                    if (i!=j && i!=l && j!=l && array[i]+array[j]+array[l] == 0) {
                        triplette.add(new Triplette(array[i], array[j], array[l]));
                    }
                }
            }
        }

        return triplette;
    }


    private static class Incrementor {
        int i;
        int j;
        int l;
        int o;
        int c;

        Incrementor(int length) {
            c = length;
            i = 0;
            j = 1;
            l = 2;
            o = 0;
        }

        boolean canIncrement() {
            return (i < c && j < c && l < c);
        }

        void next() {
            if (j < c-2) {
                j += 1;
                l = j+1;
            }
            else {
                i = o + 1;
                j = i + 1;
                l = i + 2;
                o = i;
            }
        }
    }


    public static Set<Triplette> findTriplette(int[] array) {
        Set<Triplette> triplette = new HashSet<Triplette>();
        Arrays.sort(array);
        Incrementor i = new Incrementor(array.length);

        while (i.canIncrement()) {
            int t = array[i.i] + array[i.j] + array[i.l];
            if (t == 0) {
                triplette.add(new Triplette(array[i.i], array[i.j], array[i.l]));
                i.next();
            }
            else if (t < 0) {
                if (i.l < i.c - 1) {
                    i.l += 1;
                }
                else {
                    i.next();
                }
            }
            else {
                i.next();
            }
        }


        return triplette;
    }
}
