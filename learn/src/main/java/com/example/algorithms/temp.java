package com.example.algorithms;

public class temp {
    public static void Alouette(String[] lapart, int n) {
        System.out.println("Chantez \"Alouette, gentille alouette, alouette, je te plumerai.\"");
        for (int i = 0; i < n; i++) {
            System.out.println("Je te plumerai " + lapart[i] + ".");
            for (int j = i; j >= 0; j--) {
                System.out.print("Et " + lapart[j] + " ! ");
            }
            System.out.println("\nAlouette! Alouette! Aaaaaa. . . ");
        }
        System.out.println("Alouette, gentille alouette, alouette, je te plumerai.");
    }

    public static void main(String[] args) {
        String[] lapart = {"la t¨ºte", "le bec", "les yeux", "le cou", "les ailes", "les pattes", "la queue", "le dos"};
        int n = lapart.length;
        Alouette(lapart, n);
    }
}