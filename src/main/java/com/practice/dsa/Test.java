package com.practice.dsa;

public class Test {

    public int a=10;

    public static void main(String[] args) {
        String text1="abcd";
        String text2="abdc";

        char[] X=text1.toCharArray();
        char[] Y=text2.toCharArray();
        int m = X.length;
        int n = Y.length;
        int L[][] = new int[m+1][n+1];
        for (int i=0; i<=m; i++){
            for (int j=0; j<=n; j++){
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = Math.max(L[i-1][j], L[i][j-1]);
            }
        }
        System.out.println(L[m][n]);



    }


    public boolean equals(Test obj) {
        return this.a==obj.a;
    }
}
