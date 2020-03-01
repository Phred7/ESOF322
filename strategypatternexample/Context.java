/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package strategypatternexample;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author k57h721
 */
public class Context {
    private CheckStrategy strategy;
    private String filename;
    
    public Context(String filename) {
        this.strategy = new All();
        this.filename = filename;
    }
    
    public void changeStrategy(CheckStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void filter () throws IOException {
        BufferedReader infile = new BufferedReader (new FileReader(filename));
        String buffer = null;
        while ((buffer = infile.readLine()) != null) {
            StringTokenizer words = new StringTokenizer(buffer);
            while (words.hasMoreTokens()) {
                String word = words.nextToken();
                if (strategy.check(word)) {
                    System.out.println(word);
                }
            }
        }
    }
}
