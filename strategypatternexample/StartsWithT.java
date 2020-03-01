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
public class StartsWithT implements CheckStrategy {
    @Override
    public boolean check(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        return s.charAt(0) == 't';
    }
    
}
