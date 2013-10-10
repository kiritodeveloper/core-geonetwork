package org.fao.geonet.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

/**
 * An entity representing the bi-directional mapping between the different iso language codes (de -> ger) and translations of the languages.
 * (German, Deutsch, etc...)
 * 
 * @author Jesse
 */
@Entity
@Access(AccessType.PROPERTY)
@Table(name = "isolanguages")
public class IsoLanguage extends Localized {
    private int id;
    private String code;
    private String shortCode;

    /**
     * Get the id for the lang code mapping. This is a generated value and as such new instances should not have this set as it will simply
     * be ignored and could result in reduced performance.
     * 
     * @return the id
     */
    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    /**
     * Set the id for the lang code mapping. This is a generated value and as such new instances should not have this set as it will simply
     * be ignored and could result in reduced performance.
     * 
     * @param id the id
     * @return this entity object
     */
    public IsoLanguage setId(int id) {
        this.id = id;
        return this;
    }

    /**
     * Get the 3 letter code of the mapping.
     * 
     * @return the 3 letter code of the mapping.
     */
    @Column(length = 3, nullable = false)
    public String getCode() {
        return code;
    }

    /**
     * Set the 3 letter language code for this mapping
     * 
     * @param code the 3 letter code.
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Get the 2 letter language code for this mapping
     * 
     * @return the 2 letter language code for this mapping
     */
    @Column(name = "shortcode", length = 2)
    public String getShortCode() {
        return shortCode;
    }

    /**
     * Set the 2 letter language code for this mapping
     * 
     * @param shortCode the 2 letter language code
     */
    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    /**
     * Get the map of langid -> label translations for groups
     */
    @ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
    @CollectionTable(joinColumns = @JoinColumn(name = "iddes"), name = "isolanguagesdes")
    @MapKeyColumn(name = "langid", length = 5)
    @Column(name = "label", nullable = false)
    public Map<String, String> getLabelTranslations() {
        return super.getLabelTranslations();
    }

    @Override
    public String toString() {
        return "IsoLanguage{" +
               "id=" + id +
               ", code='" + code + '\'' +
               ", shortCode='" + shortCode + '\'' +
               '}';
    }
}
