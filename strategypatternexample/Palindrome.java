/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternexample;

/**
 *
 * @author k57h721
 */
public class Palindrome implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if (s == null) {
            return false;
        }
        int length = s.length();
        if (length < 2) {
            return true;
        }
        int half = length/2;
        for (int i = 0; i < half; ++i) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
    
}
