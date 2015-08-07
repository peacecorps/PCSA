package com.pcsa.beans.reporting;

/**
 * @author Buddhiprabha Erabadda
 *
 * Holds contact information for a particular location
 */
public class LocationDetails {
    private String locationName;
    private int pcmo_contact;
    private int ssm_contact;
    private int sarl_contact;

    public LocationDetails(String locationName, int pcmo_contact, int ssm_contact, int sarl_contact){
        this.locationName = locationName;
        this.pcmo_contact = pcmo_contact;
        this.ssm_contact = ssm_contact;
        this.sarl_contact = sarl_contact;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public int getPcmo_contact() {
        return pcmo_contact;
    }

    public void setPcmo_contact(int pcmo_contact) {
        this.pcmo_contact = pcmo_contact;
    }

    public int getSsm_contact() {
        return ssm_contact;
    }

    public void setSsm_contact(int ssm_contact) {
        this.ssm_contact = ssm_contact;
    }

    public int getSarl_contact() {
        return sarl_contact;
    }

    public void setSarl_contact(int sarl_contact) {
        this.sarl_contact = sarl_contact;
    }
}
