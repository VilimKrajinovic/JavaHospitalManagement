/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.classes.patient;

/**
 *
 * @author amd
 */
public class ContactDetailsContact {

    /**
     * @return the idContactDetailsContact
     */
    public int getIdContactDetailsContact() {
        return idContactDetailsContact;
    }

    /**
     * @param idContactDetailsContact the idContactDetailsContact to set
     */
    public void setIdContactDetailsContact(int idContactDetailsContact) {
        this.idContactDetailsContact = idContactDetailsContact;
    }

    /**
     * @return the telephoneWork
     */
    public String getTelephoneWork() {
        return telephoneWork;
    }

    /**
     * @param telephoneWork the telephoneWork to set
     */
    public void setTelephoneWork(String telephoneWork) {
        this.telephoneWork = telephoneWork;
    }

    /**
     * @return the telephoneHome
     */
    public String getTelephoneHome() {
        return telephoneHome;
    }

    /**
     * @param telephoneHome the telephoneHome to set
     */
    public void setTelephoneHome(String telephoneHome) {
        this.telephoneHome = telephoneHome;
    }

    /**
     * @return the telephoneMobile
     */
    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    /**
     * @param telephoneMobile the telephoneMobile to set
     */
    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    /**
     * @return the pager
     */
    public String getPager() {
        return pager;
    }

    /**
     * @param pager the pager to set
     */
    public void setPager(String pager) {
        this.pager = pager;
    }

    /**
     * @return the fax
     */
    public String getFax() {
        return fax;
    }

    /**
     * @param fax the fax to set
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
    
    private int    idContactDetailsContact;
    private String telephoneWork;
    private String telephoneHome;
    private String telephoneMobile;
    private String pager;
    private String fax;
    private String email;
}
