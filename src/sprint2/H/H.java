package sprint2.H;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class H {
    static HashMap<Character, Character> simpleBrace = new HashMap<>();
    static {
        simpleBrace.put('(', '(');
        simpleBrace.put(')', '(');
        simpleBrace.put('{', '{');
        simpleBrace.put('}', '{');
        simpleBrace.put('[', '[');
        simpleBrace.put(']', '[');
    }
    public static void main(String[] args) throws IOException {
        try(BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in))){

            System.out.println(is_correct_bracket_seq(reader.readLine())?"True":"False");



        }
    }
    static boolean cheakBrace(char curChar, char patt) throws Exception {
        if (curChar != patt) throw new Exception();
        return true;
    }
    static boolean is_correct_bracket_seq(String line){
        LinkedList <Character> stakBrace = new LinkedList<Character>();
        char cur;
        for (char elStr:line.toCharArray()){
            try{switch (elStr){
                case '(' : {
                    stakBrace.push(simpleBrace.get(elStr));
                    break;
                }
                case ')': {
                    cheakBrace(stakBrace.pop(), simpleBrace.get(elStr));
                    break;
                }
                case '[' : {
                    stakBrace.push(simpleBrace.get(elStr));
                    break;
                }
                case ']': {
                    cheakBrace(stakBrace.pop(), simpleBrace.get(elStr));
                    break;
                }
                case '{' : {
                    stakBrace.push(simpleBrace.get(elStr));
                    break;
                }
                case '}': {
                    cheakBrace(stakBrace.pop(), simpleBrace.get(elStr));
                    break;
                }
            }}
            catch (NoSuchElementException e){
                return false;
            } catch (Exception e) {
                return false;
            }
            ;
        };
        return stakBrace.isEmpty();

    }

}
