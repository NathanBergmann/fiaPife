package br.univille.backend.entities;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    
    public static List<List<Cards>> generateCombinations(Cards[] array, int k) {
        List<List<Cards>> result = new ArrayList<>();
        List<Cards> combination = new ArrayList<>();
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
    
    public void validCombinations(Cards[] cards){
        List<List<Cards>> combinations = generateCombinations(cards, 3);
        List<List<Cards>> combinacoesValidas = new ArrayList<>();

        for (List<Cards> combination : combinations) {
            System.out.println(combination);
            //busca a quantidade de jokers na combinação
            long countJokers = combination.stream().filter(obj -> obj.getSequencia() == 20).count();
            if (countJokers == 2){
                combinacoesValidas.add(combination);
                continue;
            }
            if (countJokers == 1){
                if (combination.get(0).getSequencia() == combination.get(1).getSequencia() || combination.get(0).getSequencia() == combination.get(2).getSequencia() || combination.get(1).getSequencia() == combination.get(2).getSequencia()){
                    combinacoesValidas.add(combination);
                }
            } else {
                
            if (combination.get(0).getSequencia() == combination.get(1).getSequencia() && combination.get(0).getSequencia() == combination.get(2).getSequencia()){
                combinacoesValidas.add(combination);
            } else if (!combination.get(0).getNaipe().equals(combination.get(1).getNaipe()) || !combination.get(0).getNaipe().equals(combination.get(2).getNaipe())){
                continue;
            } else {
                
            }
        }
        return;
    }

}
}