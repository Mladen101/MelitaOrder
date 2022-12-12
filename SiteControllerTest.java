/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proj.controller;

import javax.servlet.http.HttpServletRequest;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.ui.ModelMap;

/**
 *
 * @author HP
 */
public class SiteControllerTest {
    
    public SiteControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of confirmOrder method, of class SiteController.
     */
    @org.junit.Test
    public void testConfirmOrder() {
        System.out.println("confirmOrder");
        String userdata = "";
        HttpServletRequest request = null;
        ModelMap model = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.confirmOrder(userdata, request, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class SiteController.
     */
    @org.junit.Test
    public void testRemove() {
        System.out.println("remove");
        int id = 0;
        HttpServletRequest request = null;
        ModelMap model = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.remove(id, request, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cart method, of class SiteController.
     */
    @org.junit.Test
    public void testCart() {
        System.out.println("cart");
        HttpServletRequest request = null;
        ModelMap model = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.cart(request, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToBasket method, of class SiteController.
     */
    @org.junit.Test
    public void testAddToBasket() {
        System.out.println("addToBasket");
        ModelMap model = null;
        HttpServletRequest request = null;
        Integer id = null;
        Integer quantity = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.addToBasket(model, request, id, quantity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toBasket method, of class SiteController.
     */
    @org.junit.Test
    public void testToBasket() {
        System.out.println("toBasket");
        int id = 0;
        ModelMap model = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.toBasket(id, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of index method, of class SiteController.
     */
    @org.junit.Test
    public void testIndex() {
        System.out.println("index");
        ModelMap model = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.index(model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of byCategory method, of class SiteController.
     */
    @org.junit.Test
    public void testByCategory() {
        System.out.println("byCategory");
        int id = 0;
        ModelMap model = null;
        SiteController instance = new SiteController();
        String expResult = "";
        String result = instance.byCategory(id, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
