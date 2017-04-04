/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.accenture.communicationdistribution.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author r.jankowski
 */
@Entity
@Table(name = "rssmessages")
@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Rssmessages.findAll",
//            query = "SELECT r FROM Rssmessages r")
//    , @NamedQuery(name = "Rssmessages.findById",
//            query = "SELECT r FROM Rssmessages r WHERE r.id = :id")
//    , @NamedQuery(name = "Rssmessages.findByTitle",
//            query = "SELECT r FROM Rssmessages r WHERE r.title = :title")
//    , @NamedQuery(name = "Rssmessages.findByLink",
//            query = "SELECT r FROM Rssmessages r WHERE r.link = :link")
//    , @NamedQuery(name = "Rssmessages.findByDescription",
//            query = "SELECT r FROM Rssmessages r WHERE r.description = :description")
//    , @NamedQuery(name = "Rssmessages.findByPublicationDate",
//            query = "SELECT r FROM Rssmessages r WHERE r.publicationDate = :publicationDate")})
public class RssMessages implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 256)
    @Column(name = "TITLE")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 256)
    @Column(name = "LINK")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1,
            max = 256)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PUBLICATION_DATE")
    @Temporal(TemporalType.DATE)
    private Date publicationDate;

    public RssMessages() {
    }

    public RssMessages(Integer id) {
        this.id = id;
    }

    public RssMessages(Integer id, String title, String link, String description, Date publicationDate) {
        this.id = id;
        this.title = title;
        this.link = link;
        this.description = description;
        this.publicationDate = publicationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RssMessages)) {
            return false;
        }
        RssMessages other = (RssMessages) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RssMessages{" + "id=" + id + ", title=" + title + ", link=" + link + ", description=" + description + ", publicationDate=" + publicationDate + '}';
    }

  
    
}
