package com.openclassrooms.entrevoisins.model;

import java.util.Objects;

/**
 * Model object representing a Neighbour
 */
public class Neighbour {


    /** Identifier */
    private Integer id;

    /** Full name */
    private String name;

    /** Avatar */
    private String avatarUrl;

    /** Location */
    private String location;

    /** Facebook account */
    private String facebookAccount;

    /** Description */
    private String description;

    /** Phone Number*/
    private String phoneNumber;

    /**
     * Constructor
     * @param id
     * @param name
     * @param avatarUrl
     * @param facebookAccount
     * @param location
     * @param description
     */
    public Neighbour(Integer id, String name, String avatarUrl, String facebookAccount, String location, String description, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.location = location;
        this.facebookAccount = facebookAccount;
        this.description = description;
        this.phoneNumber= phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhoneNumber(){return phoneNumber;}

    public void setPhoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public  String getLocation() {return location;}

    public void setLocation(String location){this.location = location;}

    public String getFacebookAccount(){return facebookAccount;}

    public void setFacebookAccount(String facebookAccount){this.facebookAccount = facebookAccount;}

    public String getDescription(){return description;}

    public void setDescription(String description){this.description = description;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Neighbour neighbour = (Neighbour) o;
        return Objects.equals(id, neighbour.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
