/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution;


import com.accenture.communicationdistribution.model.RssMessages;
import javax.ejb.Local;

/**
 *
 * @author r.jankowski
 */
@Local
public interface IBean {
    public boolean addEmployee(String name, String lastName, String job); 
    public RssMessages getEmployee(int id);
    
}
