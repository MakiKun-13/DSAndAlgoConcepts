package others;

import java.util.*;

public class VanityNumber {
    public static void main(String[] args) {
        List<String> codes = new ArrayList<>();
        codes.add("TWLO");
        codes.add("CODE");
        codes.add("4006");
        List<String> numbers = new ArrayList<>();
        numbers.add("+17474824380");
        numbers.add("+14157088956");
        numbers.add("+919810155555");
        numbers.add("+15109926333");
        numbers.add("+1415123456");
        System.out.println(vanity(codes, numbers));
    }
    public static List<String> vanity(List<String> codes, List<String> numbers) {
        Map<Character, Character> characterMap = getCharMap();
        // Creating the numerical string for the codes
        List<String> numericCodes = new ArrayList<>();
        for(String s : codes) {
            String regex = "\\d+";
            if(!s.matches(regex)) {
                String str = "";
                for (char i : s.toCharArray()) {
                    str = str + characterMap.get((i));
                }
                numericCodes.add(str);
            }
            else {
                numericCodes.add(s);
            }
        }
        List<String> result = new ArrayList<>();
        for(String number: numbers) {
            for(int i=0; i<numericCodes.size(); i++) {
                String code = numericCodes.get(i);
                if(number.contains(code)) {
                    String codedNumber = number.replace(code,"-"+codes.get(i)+"-");
                    if(codedNumber.endsWith("-")) {
                        codedNumber = codedNumber.substring(0, codedNumber.length()-1);
                    }
                    result.add(codedNumber);
                }
            }
        }
        Collections.sort(result);
        return result;
    }

    private static Map<Character, Character> getCharMap() {
        Map<Character, Character> map = new HashMap<>();
        map.put('A', '2');
        map.put('B', '2');
        map.put('C', '2');
        map.put('D', '3');
        map.put('E', '3');
        map.put('F', '3');
        map.put('G', '4');
        map.put('H', '4');
        map.put('I', '4');
        map.put('J', '5');
        map.put('K', '5');
        map.put('L', '5');
        map.put('M', '6');
        map.put('N', '6');
        map.put('O', '6');
        map.put('P', '7');
        map.put('Q', '7');
        map.put('R', '7');
        map.put('S', '7');
        map.put('T', '8');
        map.put('U', '8');
        map.put('V', '8');
        map.put('W', '9');
        map.put('X', '9');
        map.put('Y', '9');
        map.put('Z', '9');
        return map;
    }
}
