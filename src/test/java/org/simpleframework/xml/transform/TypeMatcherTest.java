package org.simpleframework.xml.transform;

import junit.framework.TestCase;

import java.util.Optional;

public class TypeMatcherTest extends TestCase {
   
   private static class BlankMatcher implements Matcher {

      public Transform match(Class type) throws Exception {
         return null;
      }
   }
   
   private Matcher matcher;
   
   public void setUp() {
      this.matcher = new DefaultMatcher(new BlankMatcher());
   }

   public void testInteger() throws Exception {     
      Transform transform = matcher.match(Integer.class);
      Object value = transform.read("1");

      assertEquals(value, 1);
   }
   
   public void testString() throws Exception {     
      Transform transform = matcher.match(String.class);
      Object value = transform.read("some text");
      
      assertEquals("some text", value);
   }
   
   public void testCharacter() throws Exception {
      Transform transform = matcher.match(Character.class);
      Object value = transform.read("c");
      
      assertEquals(value, 'c');
   }
   
   public void testFloat() throws Exception {
      Transform transform = matcher.match(Float.class);
      Object value = transform.read("1.12");
      
      assertEquals(value, 1.12f);
   }
   
   public void testDouble() throws Exception {
      Transform transform = matcher.match(Double.class);
      Object value = transform.read("12.33");
      
      assertEquals(value, 12.33);
   }
   
   public void testBoolean() throws Exception {
      Transform transform = matcher.match(Boolean.class);
      Object value = transform.read("true");
      
      assertEquals(value, Boolean.TRUE);
   }
   
   public void testLong() throws Exception {
      Transform transform = matcher.match(Long.class);
      Object value = transform.read("1234567");
      
      assertEquals(value, 1234567L);
   }
   
   public void testShort() throws Exception {
      Transform transform = matcher.match(Short.class);
      Object value = transform.read("12");
      
      assertEquals(value, (short) 12);
   }
   
   public void testIntegerArray() throws Exception {      
      Transform transform = matcher.match(Integer[].class);
      Object value = transform.read("1, 2, 3, 4, 5");
      
      assertTrue(value instanceof Integer[]);
      
      Integer[] array = (Integer[])value;
      
      assertEquals(array.length, 5);
      assertEquals(array[0], Optional.of(1).get());
      assertEquals(array[1], Optional.of(2).get());
      assertEquals(array[2], Optional.of(3).get());
      assertEquals(array[3], Optional.of(4).get());
      assertEquals(array[4], Optional.of(5).get());
   }
   
   public void testPrimitiveIntegerArray() throws Exception {
      Matcher matcher = new DefaultMatcher(new BlankMatcher());
      Transform transform = matcher.match(int[].class);
      Object value = transform.read("1, 2, 3, 4, 5");
      
      assertTrue(value instanceof int[]);

      int[] array = (int[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1);
      assertEquals(array[1], 2);
      assertEquals(array[2], 3);
      assertEquals(array[3], 4);
      assertEquals(array[4], 5);      
   }
}
