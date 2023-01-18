package chapter01.p001_CountDuplicateCharacters;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

// 문자열에서 같은 문자의 개수 찾기.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        Main answer = new Main();

        System.out.println("answer : " + answer.countDuplicateCharacters(str));
        System.out.printf("Stream_answer : " + answer.countDuplicateCharactersForStream(str));
    }

    // Map으로 해결하는 방법
    private Map<Character, Integer> countDuplicateCharacters(String str) {
        Map<Character, Integer> result = new HashMap<>();

        str = str.replaceAll(" ", "");

        for(char c : str.toCharArray()) {
            result.compute(c, (k,v) -> (v == null) ? 1 : ++v);
        }

        return result;
    }

    private Map<Character, Long> countDuplicateCharactersForStream(String str) {

        System.out.println(str.chars());
        return str.replaceAll(" ", "") //문자열의 공백을 제거한다.
                .chars() // 공백을 제거한 문자열을 Stream 형식으로 변환한다. (IntStream을 반환함)
                .mapToObj(c -> (char) c) // IntStream을 문자스트림으로 변환한다.
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Collectors.groupingBy() 메서드로 문자를 분류하고, Collectors.counting() 카운트한다.
    }
}
