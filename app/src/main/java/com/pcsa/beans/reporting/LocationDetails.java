package com.pcsa.beans.reporting;

/**
 * @author Buddhiprabha Erabadda
 *
 * Holds contact information for a particular location
 */
public class LocationDetails {
    private String locationName;
    private String pcmo_contact;
    private String ssm_contact;
    private String sarl_contact;

    public LocationDetails(String locationName, String pcmo_contact, String ssm_contact, String sarl_contact){
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

    public String getPcmo_contact() {
        return pcmo_contact;
    }

    public void setPcmo_contact(String pcmo_contact) {
        this.pcmo_contact = pcmo_contact;
    }

    public String getSsm_contact() {
        return ssm_contact;
    }

    public void setSsm_contact(String ssm_contact) {
        this.ssm_contact = ssm_contact;
    }

    public String getSarl_contact() {
        return sarl_contact;
    }

    public void setSarl_contact(String sarl_contact) {
        this.sarl_contact = sarl_contact;
    }
}
