package br.univille.backend.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    
    public List<List<Cards>> validCombinations(Cards[] cards){
        List<List<Cards>> combinations = generateCombinations(cards, 3);
        List<List<Cards>> combinacoesValidas = new ArrayList<>();

        for (List<Cards> combination : combinations) {
            //busca a quantidade de jokers na combinação
            long countJokers = combination.stream().filter(obj -> obj.getSequencia() == 20).count();
            //Coloca as cartas em sequencia
            Collections.sort(combination, Comparator.comparing(Cards::getSequencia));
            if (countJokers == 2){
                combinacoesValidas.add(combination);
                continue;
            }
            if (countJokers == 1){
                if (combination.get(0).getSequencia() == combination.get(1).getSequencia() || combination.get(0).getSequencia() == combination.get(2).getSequencia() || combination.get(1).getSequencia() == combination.get(2).getSequencia()){
                    combinacoesValidas.add(combination);
                } else if (combination.get(0).getNaipe().equals(combination.get(1).getNaipe()) && (combination.get(0).getSequencia() == (combination.get(1).getSequencia()-1) || combination.get(0).getSequencia() == (combination.get(1).getSequencia()-2))){
                    combinacoesValidas.add(combination);
                }
            } else {
                
                if (combination.get(0).getSequencia() == combination.get(1).getSequencia() && combination.get(0).getSequencia() == combination.get(2).getSequencia()){
                    combinacoesValidas.add(combination);
                    continue;
                }

                if (combination.get(0).getNaipe().equals(combination.get(1).getNaipe()) && combination.get(0).getNaipe().equals(combination.get(2).getNaipe())){
                    if (combination.get(0).getSequencia() == (combination.get(1).getSequencia()-1) && combination.get(0).getSequencia() == (combination.get(2).getSequencia()-2)){
                        combinacoesValidas.add(combination);
                        continue;
                    }
                }                
            }        
        }
        return combinacoesValidas;

    }
    public boolean clearCombinations (List<List<Cards>> combinatios, List<Integer> selectors){
        // Cria um conjunto de cartas para armazenar todas as cartas únicas
        Set<Cards> cartasUnicasSet = new HashSet<>();
        boolean todasUnicas = true;
        // Itera sobre as combinações
        for (int selector : selectors ) {
            List<Cards> combinacao = combinatios.get(selector-1);
            System.out.println(combinacao);
            // Verifica cada carta na combinação
            for (Cards carta : combinacao) {
                // Se a carta já estiver no conjunto de cartas únicas, esta combinação não será válida
                if (!cartasUnicasSet.add(carta)) {
                    todasUnicas = false;
                    break;
                }
            }
            
        }
        return todasUnicas;
    }
    
    public boolean isWinner(Cards[] cards){
        boolean isPlayerWinner = false;
        List<List<Cards>> combinations = validCombinations(cards);
        if (combinations.size() < 3){
            return isPlayerWinner;
        }
        List<List<Integer>> sorteios = gerarSorteios((combinations.size()));
        for (List<Integer> sorteio : sorteios){
            isPlayerWinner = clearCombinations(combinations, sorteio);
            if (isPlayerWinner){
                return isPlayerWinner;
            }
        }
        return isPlayerWinner;
    }

    public static List<List<Integer>> gerarSorteios(int maximo) {
        List<List<Integer>> sorteios = new ArrayList<>();

        for (int i = 1; i <= maximo; i++) {
            for (int j = i+1; j <= maximo; j++) {
                for (int k = j+1; k <= maximo; k++) {
                    List<Integer> sorteio = new ArrayList<>();
                    sorteio.add(i);
                    sorteio.add(j);
                    sorteio.add(k);
                    sorteios.add(sorteio);
                }
            }
        }

        return sorteios;
    }
}