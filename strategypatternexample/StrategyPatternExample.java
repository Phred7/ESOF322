/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternexample;

import java.io.IOException;

/**
 *
 * @author k57h721
 */
public class StrategyPatternExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Context context = new Context(args[0]);
        
            
        //System.out.println("\n* Default (All):");
        //context.filter();
            
        System.out.println("\n* StartsWithT:");
        context.changeStrategy(new StartsWithT());
        context.filter();
            
        System.out.println("\n* LongerThan5:");
        context.changeStrategy(new LongerThan5());
        context.filter();
            
        System.out.println("\n* Palindrome:");
        context.changeStrategy(new Palindrome());
        context.filter();
                    
    }
    
}
