package hello;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GreetingTest {
	
	
    @Test
    public void testGreetingSetsID() throws Exception {
    	Greeting greeting = new Greeting(1, "hello");
    	assertEquals("Expect id to be 1", 1, greeting.getId());
    }
    @Test
    public void testGreetingSetsGreeting() throws Exception {
    	Greeting greeting = new Greeting(1, "hello");
    	assertEquals("Expect greeting to be hello", "hello", greeting.getContent());
    }
}

