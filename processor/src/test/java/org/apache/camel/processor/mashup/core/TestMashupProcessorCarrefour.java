package org.apache.camel.processor.mashup.core;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

import java.io.Reader;

import junit.framework.Assert;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.processor.mashup.exception.CarrefourException;

import org.junit.Test;

/**
 * Unit test on the mashup processor.
 */
public class TestMashupProcessorCarrefour {
    

    @Test
    public void ALoginCarrefour() throws Exception {
    	
    	System.setProperty("karaf.data", "target");
    	 
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        Message in = exchange.getIn();
        in.setHeader("MASHUP_ID", "authenticationPFMashup");
        in.setHeader("MASHUP_STORE", "target/test-classes/model");
        in.setHeader("loginCBPASS", "50882655081100");
        in.setHeader("motPasse", "4655");
        in.setHeader("testJS", "true");
        
        
        MashupProcessor mashupProcessor = new MashupProcessor(); 
        mashupProcessor.process(exchange);

        Message out = exchange.getOut();
        System.out.println(out.getBody()); 
        System.out.println("** A identification + login   ***\n\n");
//
//        Thread.sleep(5 * 1000);
//        

    }
    
    @Test
    public void BDisponibleCarrefour() throws Exception {
    	
    	System.setProperty("karaf.data", "target");
    	 
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        Message in = exchange.getIn();
        in.setHeader("MASHUP_ID", "accountBalanceMashup");
        in.setHeader("MASHUP_STORE", "target/test-classes/model");
        in.setHeader("loginCBPASS", "50882655081100");
        
        
        
        MashupProcessor mashupProcessor = new MashupProcessor(); 
        mashupProcessor.process(exchange);

        Message out = exchange.getOut();
        System.out.println(out.getBody()); 
        System.out.println("** A Disponible    ***\n\n");
        
    }
    
    @Test
    public void CConsultCarrefour() throws Exception {
    	
    	System.setProperty("karaf.data", "target");
    	 
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        Message in = exchange.getIn();
        in.setHeader("MASHUP_ID", "creditHistorymashup");
        in.setHeader("MASHUP_STORE", "target/test-classes/model");
        in.setHeader("loginCBPASS", "50882655081100");
        
        
        
        MashupProcessor mashupProcessor = new MashupProcessor(); 
        mashupProcessor.process(exchange);

        Message out = exchange.getOut();
        System.out.println(out.getBody()); 
        System.out.println("** A Consulter    ***\n\n");
        
    }
    
    
    @Test
    public void DRedirectCarrefour() throws Exception {
    	
    	System.setProperty("karaf.data", "target");
    	
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        Message in = exchange.getIn();
        in.setHeader("MASHUP_ID", "redirect");
        in.setHeader("MASHUP_STORE", "target/test-classes/model");

        
        MashupProcessor mashupProcessor = new MashupProcessor();
        mashupProcessor.process(exchange);

        Message out = exchange.getOut();
        System.out.println(out.getBody()); 
        
    }
    
    
    @Test
    public void ECarrefourException() throws Exception {
    	
    	System.setProperty("karaf.data", "target");
    	
        Exchange exchange = new DefaultExchange(new DefaultCamelContext());
        Message in = exchange.getIn();
        in.setHeader("MASHUP_ID", "noAuthorized");
        in.setHeader("MASHUP_STORE", "target/test-classes/model");

        try{
        MashupProcessor mashupProcessor = new MashupProcessor();
        mashupProcessor.process(exchange);
        fail("Exception excepted");
        } catch(CarrefourException ce){
          
        assertEquals(ce.getIdextractor(), "foo");
        System.out.println("id extractor =>" + ce.getIdextractor() + " message " + ce.getMessage());
        }

         
        
    }
    
    

    
    
}
