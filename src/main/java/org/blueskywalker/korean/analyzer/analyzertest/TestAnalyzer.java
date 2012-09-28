package org.blueskywalker.korean.analyzer.analyzertest;

import java.io.IOException;
import java.io.Reader;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.util.Version;

/**
 * TestAnalyzer
 *
 */
public abstract class TestAnalyzer 
{
    Analyzer analyzer;
    TokenStream tokenStream;
    TokenStream token;
    
    final static Version version = Version.LUCENE_36;
    
    /**
     *
     */
    public TestAnalyzer(String field,Reader reader) {
        analyzer = null;
        tokenStream = null;
    }
        
    
    
    abstract public void analyze() throws IOException ;
        

    
    public static void main( String[] args )
    {
        System.out.println( TestAnalyzer.class.getName() );
    }
}
