package br.univille.backend.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Combinations {
    
    public static List<List<Cards>> generateCombinations(Cards[] array, int k) {
        List<List<Cards>> result = new ArrayList<>();
        List<Cards> combination = new ArrayList<>();
        //Collections.sort(array, Comparator.comparing(Cards::getNumero));
        generateCombinations(array, k, 0, combination, result);
        return result;
    }
    
    private static void generateCombinations(Cards[] array, int k, int start, List<Cards> combination, List<List<Cards>> result) {
        if (k == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        
        for (int i = start; i <= array.length - k; i++) {
            
            if (array[i] == null) {
                continue;
            }
            
            combination.add(array[i]);
            generateCombinations(array, k - 1, i + 1, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
    

}