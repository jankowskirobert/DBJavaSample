/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution;

import javax.ejb.Local;

/**
 *
 * @author r.jankowski
 */
@Local
public interface IBean {
    public String sayIt(String msg); 
    public String getMsg();
}
