package com.asimio.dvdrental.model;
// Generated Jul 21, 2016 11:52:14 PM by Hibernate Tools 3.2.2.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Staff generated by hbm2java
 */
@Entity
@Table(name="staff"
    ,schema="public"
)
public class Staff  implements java.io.Serializable {


     private int staffId;
     private Address address;
     private String firstName;
     private String lastName;
     private String email;
     private short storeId;
     private boolean active;
     private String username;
     private String password;
     private Date lastUpdate;
     private byte[] picture;
     private Set<Payment> payments = new HashSet<Payment>(0);
     private Set<Rental> rentals = new HashSet<Rental>(0);
     private Set<Store> stores = new HashSet<Store>(0);

    public Staff() {
    }

	
    public Staff(int staffId, Address address, String firstName, String lastName, short storeId, boolean active, String username, Date lastUpdate) {
        this.staffId = staffId;
        this.address = address;
        this.firstName = firstName;
        this.lastName = lastName;
        this.storeId = storeId;
        this.active = active;
        this.username = username;
        this.lastUpdate = lastUpdate;
    }
    public Staff(int staffId, Address address, String firstName, String lastName, String email, short storeId, boolean active, String username, String password, Date lastUpdate, byte[] picture, Set<Payment> payments, Set<Rental> rentals, Set<Store> stores) {
       this.staffId = staffId;
       this.address = address;
       this.firstName = firstName;
       this.lastName = lastName;
       this.email = email;
       this.storeId = storeId;
       this.active = active;
       this.username = username;
       this.password = password;
       this.lastUpdate = lastUpdate;
       this.picture = picture;
       this.payments = payments;
       this.rentals = rentals;
       this.stores = stores;
    }
   
     @Id 
    
    @Column(name="staff_id", unique=true, nullable=false)
    public int getStaffId() {
        return this.staffId;
    }
    
    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="address_id", nullable=false)
    public Address getAddress() {
        return this.address;
    }
    
    public void setAddress(Address address) {
        this.address = address;
    }
    
    @Column(name="first_name", nullable=false, length=45)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    @Column(name="last_name", nullable=false, length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Column(name="email", length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Column(name="store_id", nullable=false)
    public short getStoreId() {
        return this.storeId;
    }
    
    public void setStoreId(short storeId) {
        this.storeId = storeId;
    }
    
    @Column(name="active", nullable=false)
    public boolean isActive() {
        return this.active;
    }
    
    public void setActive(boolean active) {
        this.active = active;
    }
    
    @Column(name="username", nullable=false, length=16)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    @Column(name="password", length=40)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_update", nullable=false, length=29)
    public Date getLastUpdate() {
        return this.lastUpdate;
    }
    
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    
    @Column(name="picture")
    public byte[] getPicture() {
        return this.picture;
    }
    
    public void setPicture(byte[] picture) {
        this.picture = picture;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="staff")
    public Set<Payment> getPayments() {
        return this.payments;
    }
    
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="staff")
    public Set<Rental> getRentals() {
        return this.rentals;
    }
    
    public void setRentals(Set<Rental> rentals) {
        this.rentals = rentals;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="staff")
    public Set<Store> getStores() {
        return this.stores;
    }
    
    public void setStores(Set<Store> stores) {
        this.stores = stores;
    }




}


