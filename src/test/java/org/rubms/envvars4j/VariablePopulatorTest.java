package org.rubms.envvars4j;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by ruben on 5/06/16.
 */
public class VariablePopulatorTest {


    @Test
    public void populateFromVariablesCorrectlyFillsTheObjectFields() throws Exception {
        VariableProvider variableProvider = mock(VariableProvider.class);
        when(variableProvider.get("TEST_INTEGER_NUMBER")).thenReturn("23");
        when(variableProvider.get("TEST_FLOATINGPOINT_NUMBER")).thenReturn("23.65");
        when(variableProvider.get("TEST_BOOLEAN")).thenReturn("true");
        when(variableProvider.get("TEST_STRING")).thenReturn("Foo");

        TestObject testObject = new TestObject();

        VariablePopulator variablePopulator = new VariablePopulator(testObject, variableProvider);
        variablePopulator.populateFromVariables();
        assertEquals(true, testObject.getTestBooleanObject());
        assertEquals(true, testObject.getTestBoolean());
        assertEquals(23, testObject.getTestIntegerObject().intValue());
        assertEquals(23, testObject.getTestInteger());
        assertEquals(23, testObject.getTestShortObject().shortValue());
        assertEquals(23, testObject.getTestShort());
        assertEquals(23.65, testObject.getTestFloatObject(), 0.001);
        assertEquals(23.65, testObject.getTestFloat(), 0.001);
        assertEquals(23.65, testObject.getTestDoubleObject(), 0.001);
        assertEquals(23.65, testObject.getTestDouble(), 0.001);
        assertEquals("Foo", testObject.getTestString());
    }

    public class TestObject {
        @VariableOption(name="TEST_BOOLEAN")
        private Boolean testBooleanObject = false;

        @VariableOption(name="TEST_BOOLEAN")
        private boolean testBoolean = false;

        @VariableOption(name="TEST_INTEGER_NUMBER")
        private Integer testIntegerObject = 0;

        @VariableOption(name="TEST_INTEGER_NUMBER")
        private int testInteger = 0;

        @VariableOption(name="TEST_INTEGER_NUMBER")
        private Short testShortObject = 0;

        @VariableOption(name="TEST_INTEGER_NUMBER")
        private short testShort = 0;

        @VariableOption(name="TEST_FLOATINGPOINT_NUMBER")
        private Float testFloatObject = 0F;

        @VariableOption(name="TEST_FLOATINGPOINT_NUMBER")
        private float testFloat = 0F;

        @VariableOption(name="TEST_FLOATINGPOINT_NUMBER")
        private Double testDoubleObject = 0D;

        @VariableOption(name="TEST_FLOATINGPOINT_NUMBER")
        private double testDouble = 0D;

        @VariableOption(name="TEST_STRING")
        private String testString;

        public Boolean getTestBooleanObject() {
            return testBooleanObject;
        }

        public void setTestBooleanObject(Boolean testBooleanObject) {
            this.testBooleanObject = testBooleanObject;
        }

        public boolean getTestBoolean() {
            return testBoolean;
        }

        public void setTestBoolean(boolean testBoolean) {
            this.testBoolean = testBoolean;
        }

        public Integer getTestIntegerObject() {
            return testIntegerObject;
        }

        public void setTestIntegerObject(Integer testIntegerObject) {
            this.testIntegerObject = testIntegerObject;
        }

        public int getTestInteger() {
            return testInteger;
        }

        public void setTestInteger(int testInteger) {
            this.testInteger = testInteger;
        }

        public Short getTestShortObject() {
            return testShortObject;
        }

        public void setTestShortObject(Short testShortObject) {
            this.testShortObject = testShortObject;
        }

        public short getTestShort() {
            return testShort;
        }

        public void setTestShort(short testShort) {
            this.testShort = testShort;
        }

        public Float getTestFloatObject() {
            return testFloatObject;
        }

        public void setTestFloatObject(Float testFloatObject) {
            this.testFloatObject = testFloatObject;
        }

        public float getTestFloat() {
            return testFloat;
        }

        public void setTestFloat(float testFloat) {
            this.testFloat = testFloat;
        }

        public Double getTestDoubleObject() {
            return testDoubleObject;
        }

        public void setTestDoubleObject(Double testDoubleObject) {
            this.testDoubleObject = testDoubleObject;
        }

        public double getTestDouble() {
            return testDouble;
        }

        public void setTestDouble(double testDouble) {
            this.testDouble = testDouble;
        }

        public String getTestString() {
            return testString;
        }

        public void setTestString(String testString) {
            this.testString = testString;
        }
    }
}