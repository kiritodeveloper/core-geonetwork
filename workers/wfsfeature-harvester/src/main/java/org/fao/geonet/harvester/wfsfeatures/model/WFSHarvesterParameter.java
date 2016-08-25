/*
 * Copyright (C) 2001-2016 Food and Agriculture Organization of the
 * United Nations (FAO-UN), United Nations World Food Programme (WFP)
 * and United Nations Environment Programme (UNEP)
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or (at
 * your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 *
 * Contact: Jeroen Ticheler - FAO - Viale delle Terme di Caracalla 2,
 * Rome - Italy. email: geonetwork@osgeo.org
 */

package org.fao.geonet.harvester.wfsfeatures.model;

import java.io.Serializable;
import java.util.Map;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by francois on 14/01/16.
 */
@XmlRootElement(name = "wfs")
public class WFSHarvesterParameter implements Serializable {
    private static final long serialVersionUID = 7526471155622776147L;
    private String metadataUuid;
    private String url;
    private String typeName;
    private String version = "1.0.0";
    private int timeOut = 60000;
    private int maxFeatures = -1;
    private String encoding = "UTF-8";
    private String crs = "EPSG:4326";
    private String titleExpression;
    /**
     * List of fields to tokenize during indexing.
     *
     * The key is the column name, the value is the separator.
     */
    private Map<String, String> tokenize;

    public WFSHarvesterParameter() {
    }

    public WFSHarvesterParameter(String url, String typeName, String metadataUuid) {
        this.url = url;
        this.typeName = typeName;
        this.metadataUuid = metadataUuid;
    }

    @XmlAttribute(required = true)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlAttribute
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @XmlAttribute
    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @XmlAttribute
    public int getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    @XmlAttribute
    public int getMaxFeatures() {
        return maxFeatures;
    }

    public void setMaxFeatures(int maxFeatures) {
        this.maxFeatures = maxFeatures;
    }

    @XmlAttribute
    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    @XmlAttribute
    public String getMetadataUuid() {
        return metadataUuid;
    }

    public void setMetadataUuid(String metadataUuid) {
        this.metadataUuid = metadataUuid;
    }

    @XmlElementWrapper(name = "tokenize")
    public Map<String, String> getTokenize() {
        return tokenize;
    }

    public void setTokenize(Map<String, String> tokenize) {
        this.tokenize = tokenize;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer(this.getClass().getSimpleName());
        sb.append("\nurl: ").append(url);
        sb.append("\ntypeName: ").append(typeName);
        sb.append("\nversion:").append(version);
        sb.append("\nmetadataUuid:").append(metadataUuid);
        sb.append("\ntimeOut:").append(timeOut);
        sb.append("\nmaxFeatures:").append(maxFeatures);
        sb.append("\ntitleExpression:").append(titleExpression);
        sb.append("\nencoding:").append(encoding);
        if (tokenize != null) {
            sb.append("\ntokenize: ");
            for (Map.Entry<String, String> e : tokenize.entrySet()) {
                sb.append(" * ")
                    .append(e.getKey())
                    .append(" separated by: ")
                    .append(e.getValue());
            }
        }
        return sb.toString();
    }

    public String getCrs() {
        return crs;
    }

    public void setCrs(String crs) {
        this.crs = crs;
    }

    @XmlAttribute
    public String getTitleExpression() {
        return titleExpression;
    }

    public void setTitleExpression(String titleExpression) {
        this.titleExpression = titleExpression;
    }
}