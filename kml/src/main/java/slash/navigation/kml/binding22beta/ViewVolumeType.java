//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.10.12 at 02:39:09 PM CEST 
//


package slash.navigation.kml.binding22beta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ViewVolumeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ViewVolumeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://earth.google.com/kml/2.2}AbstractObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}leftFov" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}rightFov" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}bottomFov" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}topFov" minOccurs="0"/>
 *         &lt;element ref="{http://earth.google.com/kml/2.2}near" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ViewVolumeType", propOrder = {
    "leftFov",
    "rightFov",
    "bottomFov",
    "topFov",
    "near"
})
public class ViewVolumeType
    extends AbstractObjectType
{

    @XmlElement(defaultValue = "0.0")
    protected Double leftFov;
    @XmlElement(defaultValue = "0.0")
    protected Double rightFov;
    @XmlElement(defaultValue = "0.0")
    protected Double bottomFov;
    @XmlElement(defaultValue = "0.0")
    protected Double topFov;
    @XmlElement(defaultValue = "0.0")
    protected Double near;

    /**
     * Gets the value of the leftFov property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLeftFov() {
        return leftFov;
    }

    /**
     * Sets the value of the leftFov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLeftFov(Double value) {
        this.leftFov = value;
    }

    /**
     * Gets the value of the rightFov property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getRightFov() {
        return rightFov;
    }

    /**
     * Sets the value of the rightFov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setRightFov(Double value) {
        this.rightFov = value;
    }

    /**
     * Gets the value of the bottomFov property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getBottomFov() {
        return bottomFov;
    }

    /**
     * Sets the value of the bottomFov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setBottomFov(Double value) {
        this.bottomFov = value;
    }

    /**
     * Gets the value of the topFov property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getTopFov() {
        return topFov;
    }

    /**
     * Sets the value of the topFov property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setTopFov(Double value) {
        this.topFov = value;
    }

    /**
     * Gets the value of the near property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getNear() {
        return near;
    }

    /**
     * Sets the value of the near property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setNear(Double value) {
        this.near = value;
    }

}
