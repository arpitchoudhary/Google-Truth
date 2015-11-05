package com.example.arpit.googletruth;


import com.google.common.collect.Range;
import com.google.common.truth.Truth;

import junit.framework.Assert;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DataUtilityTest {

    DataUtility dataUtility;
    List<String> expectedNames;

    @Before
    public void setUp() {
        dataUtility = new DataUtility();
        expectedNames = new ArrayList<>();
        expectedNames.add("Arpit");
        expectedNames.add("Kshitiz");
        expectedNames.add("Sunil");
        expectedNames.add("Atul");
        expectedNames.add("Sharad");
    }

    @After
    public void tearDown() {
        dataUtility = null;
    }


    //JUnit Test Case
    @Test
    public void getSquareRoot_validInput_returnNumberWithinRange() {
        double minValue = 5.0;
        double maxValue = 10.0;
        double result = dataUtility.getSquareRoot(81);
        Assert.assertTrue("Result should be in range 5-10", result > minValue && result < maxValue);
    }

    //Truth Test Case
    @Test
    public void getSquareRoot_ValidInput_returnNumberWithinRange() {
        double result = dataUtility.getSquareRoot(81);
        Truth.assertThat(result).isIn(Range.open(5.0, 10.0));
    }

    //JUnit Test Case
    @Test
    public void getListOfNames_returnNoDuplicateNames() {
        List<String> names = dataUtility.getListOfNames();
        Set<String> uniqueValue = new HashSet<>();
        for (String result : names) {
            uniqueValue.add(result);
        }
        Assert.assertTrue("No Duplicate Names", uniqueValue.size() == names.size());
    }

    //Truth Test Case
    @Test
    public void getListOfNames_returnNoDuplicateNames1() {
        List<String> names = dataUtility.getListOfNames();
        Truth.assertThat(names).containsNoDuplicates();
    }

    //JUnit Test Case
    @Test
    public void getListOfNames_wasCalled_returnListInOrder() {
        List<String> names = dataUtility.getListOfNames();
        int flag = 0;
        for (int i = 0; i < names.size(); i++) {
            if (!(names.get(i).equals(expectedNames.get(i)))) {
                flag = 1;
                break;
            }
        }
        Assert.assertTrue("Result is Exactly In Order", flag == 0);
    }

    //Truth Test Case
    @Test
    public void getListOfNames_WasCalled_returnListInOrder() {
        List<String> names = dataUtility.getListOfNames();
        Truth.assertThat(names).named("names").containsExactlyElementsIn(expectedNames).inOrder();
    }

    //Truth Test Case
    @Test
    public void getReverseName_validInputString_reverseString() {
        String result = dataUtility.getReverseName("xyz XYZ");
        Truth.assertThat(result).endsWith("zyx");
    }

    //JUnit Test Case
    @Test
    public void getListOfNames_wasCalled_returnNothing(){
        List<String> names = dataUtility.getListOfNames();
        Assert.assertNull("No names Returned", names);
    }

    //Truth Test Case
    @Test
    public void getListOfNames_valInput_returnNothing(){
        List<String> names = dataUtility.getListOfNames();
        Truth.assertThat(names).named("Names").isEmpty();
    }
}
