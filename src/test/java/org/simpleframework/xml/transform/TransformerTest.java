package org.simpleframework.xml.transform;

import org.simpleframework.xml.transform.Transformer;

import junit.framework.TestCase;

import java.util.Optional;

public class TransformerTest extends TestCase {
   
   private static class BlankMatcher implements Matcher {

      public Transform match(Class type) throws Exception {
         return null;
      }
   }
   
   private Transformer transformer;
   
   public void setUp() {
      this.transformer = new Transformer(new BlankMatcher());
   }

   public void testInteger() throws Exception {     
      Object value = transformer.read("1", Integer.class);
      String text = transformer.write(value, Integer.class);

      assertEquals(value, 1);
      assertEquals(text, "1");
   }
   
   public void testString() throws Exception {     
      Object value = transformer.read("some text", String.class);      
      String text = transformer.write(value, String.class);
      
      assertEquals("some text", value);
      assertEquals("some text", text);
   }
   
   public void testCharacter() throws Exception {
      Object value = transformer.read("c", Character.class);      
      String text = transformer.write(value, Character.class);      
      
      assertEquals(value, 'c');
      assertEquals(text, "c");
   }
   
   public void testInvalidCharacter() throws Exception {
      boolean success = false;
      
      try {
         transformer.read("too long", Character.class);
      }catch(InvalidFormatException e) {
         e.printStackTrace();
         success = true;
      }
      assertTrue(success);
   }
   
   public void testFloat() throws Exception {
      Object value = transformer.read("1.12", Float.class);      
      String text = transformer.write(value, Float.class);
      
      assertEquals(value, 1.12f);
      assertEquals(text, "1.12");
   }
   
   public void testDouble() throws Exception {     
      Object value = transformer.read("12.33", Double.class);
      String text = transformer.write(value, Double.class);      
      
      assertEquals(value, 12.33);
      assertEquals(text, "12.33");
   }
   
   public void testBoolean() throws Exception {
      Object value = transformer.read("true", Boolean.class);
      String text = transformer.write(value, Boolean.class);
      
      assertEquals(value, Boolean.TRUE);
      assertEquals(text, "true");
   }
   
   public void testLong() throws Exception {
      Object value = transformer.read("1234567", Long.class);
      String text = transformer.write(value, Long.class);
      
      assertEquals(value, 1234567L);
      assertEquals(text, "1234567");
   }
   
   public void testShort() throws Exception {
      Object value = transformer.read("12", Short.class);
      String text = transformer.write(value, Short.class);
      
      assertEquals(value, (short) 12);
      assertEquals(text, "12");
   }
   
   public void testPrimitiveIntegerArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", int[].class);
      String text = transformer.write(value, int[].class);
      
      assertTrue(value instanceof int[]);

      int[] array = (int[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1);
      assertEquals(array[1], 2);
      assertEquals(array[2], 3);
      assertEquals(array[3], 4);
      assertEquals(array[4], 5);
      assertEquals(text, "1, 2, 3, 4, 5");      
   }
   
   public void testPrimitiveLongArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", long[].class);
      String text = transformer.write(value, long[].class);
      
      assertTrue(value instanceof long[]);

      long[] array = (long[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1);
      assertEquals(array[1], 2);
      assertEquals(array[2], 3);
      assertEquals(array[3], 4);
      assertEquals(array[4], 5);
      assertEquals(text, "1, 2, 3, 4, 5");      
   }     
   
   public void testPrimitiveShortArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", short[].class);
      String text = transformer.write(value, short[].class);
      
      assertTrue(value instanceof short[]);

      short[] array = (short[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1);
      assertEquals(array[1], 2);
      assertEquals(array[2], 3);
      assertEquals(array[3], 4);
      assertEquals(array[4], 5);
      assertEquals(text, "1, 2, 3, 4, 5");      
   }
   
   public void testPrimitiveByteArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", byte[].class);
      String text = transformer.write(value, byte[].class);
      
      assertTrue(value instanceof byte[]);

      byte[] array = (byte[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1);
      assertEquals(array[1], 2);
      assertEquals(array[2], 3);
      assertEquals(array[3], 4);
      assertEquals(array[4], 5);
      assertEquals(text, "1, 2, 3, 4, 5");      
   }
   
   public void testPrimitiveFloatArray() throws Exception {
      Object value = transformer.read("1.0, 2.0, 3.0, 4.0, 5.0", float[].class);
      String text = transformer.write(value, float[].class);
      
      assertTrue(value instanceof float[]);

      float[] array = (float[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1.0f);
      assertEquals(array[1], 2.0f);
      assertEquals(array[2], 3.0f);
      assertEquals(array[3], 4.0f);
      assertEquals(array[4], 5.0f);
      assertEquals(text, "1.0, 2.0, 3.0, 4.0, 5.0");      
   }
   
   public void testPrimitiveDoubleArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", double[].class);
      String text = transformer.write(value, double[].class);
      
      assertTrue(value instanceof double[]);

      double[] array = (double[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1.0d);
      assertEquals(array[1], 2.0d);
      assertEquals(array[2], 3.0d);
      assertEquals(array[3], 4.0d);
      assertEquals(array[4], 5.0d);
      assertEquals(text, "1.0, 2.0, 3.0, 4.0, 5.0");      
   }
   
   public void testPrimitiveCharacterArray() throws Exception {
      Object value = transformer.read("hello world", char[].class);
      String text = transformer.write(value, char[].class);
      
      assertTrue(value instanceof char[]);

      char[] array = (char[])value;

      assertEquals(array.length, 11);
      assertEquals(array[0], 'h');
      assertEquals(array[1], 'e');
      assertEquals(array[2], 'l');
      assertEquals(array[3], 'l');
      assertEquals(array[4], 'o');      
      assertEquals(array[5], ' ');
      assertEquals(array[6], 'w');
      assertEquals(array[7], 'o');
      assertEquals(array[8], 'r');
      assertEquals(array[9], 'l');
      assertEquals(array[10], 'd');   
      
      assertEquals(text, "hello world");      
   }  
   
   // Java Language types
   
   
   public void testIntegerArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", Integer[].class);
      String text = transformer.write(value, Integer[].class);
      
      assertTrue(value instanceof Integer[]);

      Integer[] array = (Integer[])value;

      assertEquals(5, array.length);
      assertEquals(array[0], Optional.of(1).get());
      assertEquals(array[1], Optional.of(2).get());
      assertEquals(array[2], Optional.of(3).get());
      assertEquals(array[3], Optional.of(4).get());
      assertEquals(array[4], Optional.of(5).get());
      assertEquals("1, 2, 3, 4, 5", text);
   }
   
   public void testBooleanArray() throws Exception {
      Object value = transformer.read("true, false, false, false, true", Boolean[].class); 
      String text = transformer.write(value, Boolean[].class);
      
      assertTrue(value instanceof Boolean[]);

      Boolean[] array = (Boolean[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], Boolean.TRUE);
      assertEquals(array[1], Boolean.FALSE);
      assertEquals(array[2], Boolean.FALSE);
      assertEquals(array[3], Boolean.FALSE);
      assertEquals(array[4], Boolean.TRUE);
      assertEquals(text, "true, false, false, false, true");
   }
   
   public void testLongArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", Long[].class);
      String text = transformer.write(value, Long[].class);
      
      assertTrue(value instanceof Long[]);

      Long[] array = (Long[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], Optional.of(1L).get());
      assertEquals(array[1], Optional.of(2L).get());
      assertEquals(array[2], Optional.of(3L).get());
      assertEquals(array[3], Optional.of(4L).get());
      assertEquals(array[4], Optional.of(5L).get());
      assertEquals(text, "1, 2, 3, 4, 5");      
   }     
   
   public void testShortArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", Short[].class);
      String text = transformer.write(value, Short[].class);
      
      assertTrue(value instanceof Short[]);

      Short[] array = (Short[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], Short.valueOf((short)1));
      assertEquals(array[1], Short.valueOf((short)2));
      assertEquals(array[2], Short.valueOf((short)3));
      assertEquals(array[3], Short.valueOf((short)4));
      assertEquals(array[4], Short.valueOf((short)5));
      assertEquals(text, "1, 2, 3, 4, 5");      
   }
   
   public void testByteArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", Byte[].class);
      String text = transformer.write(value, Byte[].class);
      
      assertTrue(value instanceof Byte[]);

      Byte[] array = (Byte[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], Byte.valueOf((byte)1));
      assertEquals(array[1], Byte.valueOf((byte)2));
      assertEquals(array[2], Byte.valueOf((byte)3));
      assertEquals(array[3], Byte.valueOf((byte)4));
      assertEquals(array[4], Byte.valueOf((byte)5));
      assertEquals(text, "1, 2, 3, 4, 5");      
   }
   
   public void testFloatArray() throws Exception {
      Object value = transformer.read("1.0, 2.0, 3.0, 4.0, 5.0", Float[].class);
      String text = transformer.write(value, Float[].class);
      
      assertTrue(value instanceof Float[]);

      Float[] array = (Float[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1.0f);
      assertEquals(array[1], 2.0f);
      assertEquals(array[2], 3.0f);
      assertEquals(array[3], 4.0f);
      assertEquals(array[4], 5.0f);
      assertEquals(text, "1.0, 2.0, 3.0, 4.0, 5.0");      
   }
   
   public void testDoubleArray() throws Exception {
      Object value = transformer.read("1, 2, 3, 4, 5", Double[].class);
      String text = transformer.write(value, Double[].class);
      
      assertTrue(value instanceof Double[]);

      Double[] array = (Double[])value;

      assertEquals(array.length, 5);
      assertEquals(array[0], 1.0d);
      assertEquals(array[1], 2.0d);
      assertEquals(array[2], 3.0d);
      assertEquals(array[3], 4.0d);
      assertEquals(array[4], 5.0d);
      assertEquals(text, "1.0, 2.0, 3.0, 4.0, 5.0");      
   }
   
   public void testCharacterArray() throws Exception {
      Object value = transformer.read("hello world", Character[].class);
      String text = transformer.write(value, Character[].class);
      
      assertTrue(value instanceof Character[]);

      Character[] array = (Character[])value;

      assertEquals(array.length, 11);
      assertEquals(array[0], Optional.of('h').get());
      assertEquals(array[1], Optional.of('e').get());
      assertEquals(array[2], Optional.of('l').get());
      assertEquals(array[3], Optional.of('l').get());
      assertEquals(array[4], Optional.of('o').get());
      assertEquals(array[5], Optional.of(' ').get());
      assertEquals(array[6], Optional.of('w').get());
      assertEquals(array[7], Optional.of('o').get());
      assertEquals(array[8], Optional.of('r').get());
      assertEquals(array[9], Optional.of('l').get());
      assertEquals(array[10], Optional.of('d').get());
      
      assertEquals(text, "hello world");      
   }     
}
