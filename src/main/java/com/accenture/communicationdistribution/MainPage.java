/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author r.jankowski
 */
@ManagedBean
@RequestScoped
public class MainPage {
    @EJB
    private IBean bean;
    String message = "TEST ";
     final Random r = new Random(99);
    public String getMessage(){       
        message = bean.getEmployee(1).toString();
        return message;
    }
    public void move() {
        if (bean.addEmployee("test", "test2", "test3")){
            message = "PASS";
        } else {
            message = "FAIL";
        }
    }
}
