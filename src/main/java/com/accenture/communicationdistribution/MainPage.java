/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution;

import java.util.Random;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

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
        message = bean.getEmployee(3).toString();
        return message;
    }
    public void move() {
        if (bean.addEmployee("", "test2", "test3")){
            message = "PASS";
        } else {
            message = "FAIL";
        }
    }
}
