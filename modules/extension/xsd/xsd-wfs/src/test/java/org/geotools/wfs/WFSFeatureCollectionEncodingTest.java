/*
 *    GeoTools - The Open Source Java GIS Toolkit
 *    http://geotools.org
 *
 *    (C) 2002-2015, Open Source Geospatial Foundation (OSGeo)
 *
 *    This library is free software; you can redistribute it and/or
 *    modify it under the terms of the GNU Lesser General Public
 *    License as published by the Free Software Foundation;
 *    version 2.1 of the License.
 *
 *    This library is distributed in the hope that it will be useful,
 *    but WITHOUT ANY WARRANTY; without even the implied warranty of
 *    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 *    Lesser General Public License for more details.
 */
package org.geotools.wfs;

import junit.framework.TestCase;
import net.opengis.wfs.FeatureCollectionType;
import net.opengis.wfs.WfsFactory;
import org.geotools.feature.DefaultFeatureCollection;
import org.geotools.feature.simple.SimpleFeatureBuilder;
import org.geotools.feature.simple.SimpleFeatureTypeBuilder;
import org.geotools.gml2.GMLConfiguration;
import org.geotools.xsd.Encoder;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class WFSFeatureCollectionEncodingTest extends TestCase {

    FeatureCollectionType fc;

    @Override
    protected void setUp() throws Exception {
        fc = WfsFactory.eINSTANCE.createFeatureCollectionType();
        DefaultFeatureCollection features = new DefaultFeatureCollection();

        SimpleFeatureTypeBuilder tb = new SimpleFeatureTypeBuilder();
        tb.setName("feature");
        tb.setNamespaceURI("http://geotools.org");
        tb.add("geometry", Point.class);
        tb.add("integer", Integer.class);

        SimpleFeatureBuilder b = new SimpleFeatureBuilder(tb.buildFeatureType());
        b.add(new GeometryFactory().createPoint(new Coordinate(0, 0)));
        b.add(0);
        features.add(b.buildFeature("zero"));

        b.add(new GeometryFactory().createPoint(new Coordinate(1, 1)));
        b.add(1);
        features.add(b.buildFeature("one"));

        fc.getFeature().add(features);
    }

    public void testEncodeFeatureCollection10() throws Exception {
        Encoder e = new Encoder(new org.geotools.wfs.v1_0.WFSConfiguration_1_0());
        e.getNamespaces().declarePrefix("geotools", "http://geotools.org");
        e.setIndenting(true);

        Document d = e.encodeAsDOM(fc, WFS.FeatureCollection);
        // XMLTestSupport.print(d);

        assertEquals(2, d.getElementsByTagName("gml:Point").getLength());
        assertTrue(d.getElementsByTagName("gml:coord").getLength() > 2);
        assertEquals(0, d.getElementsByTagName("gml:pos").getLength());

        assertEquals(2, d.getElementsByTagName("geotools:feature").getLength());
        assertNotNull(
                ((Element) d.getElementsByTagName("geotools:feature").item(0)).getAttribute("fid"));
    }

    public void testEncodeFeatureCollectionCoordinatesFormatting10() throws Exception {
        org.geotools.wfs.v1_0.WFSConfiguration_1_0 configuration =
                new org.geotools.wfs.v1_0.WFSConfiguration_1_0();
        configuration.getProperties().add(GMLConfiguration.OPTIMIZED_ENCODING);
        ((GMLConfiguration) configuration.getDependency(GMLConfiguration.class))
                .setForceDecimalEncoding(true);
        ((GMLConfiguration) configuration.getDependency(GMLConfiguration.class)).setNumDecimals(4);
        ((GMLConfiguration) configuration.getDependency(GMLConfiguration.class))
                .setPadWithZeros(true);
        Encoder e = new Encoder(configuration);
        e.getNamespaces().declarePrefix("geotools", "http://geotools.org");
        e.setIndenting(true);

        Document d = e.encodeAsDOM(fc, WFS.FeatureCollection);
        // XMLTestSupport.print(d);

        assertEquals(2, d.getElementsByTagName("gml:Point").getLength());
        assertEquals(4, d.getElementsByTagName("gml:coordinates").getLength());
        String coords = d.getElementsByTagName("gml:coordinates").item(1).getTextContent();
        assertEquals("1.0000,1.0000", coords);

        assertEquals(2, d.getElementsByTagName("geotools:feature").getLength());
        assertNotNull(
                ((Element) d.getElementsByTagName("geotools:feature").item(0)).getAttribute("fid"));
    }

    public void testEncodeFeatureCollection11() throws Exception {
        Encoder e = new Encoder(new org.geotools.wfs.v1_1.WFSConfiguration());
        e.getNamespaces().declarePrefix("geotools", "http://geotools.org");
        e.setIndenting(true);

        Document d = e.encodeAsDOM(fc, WFS.FeatureCollection);
        // XMLTestSupport.print(d);
        assertEquals(2, d.getElementsByTagName("gml:Point").getLength());
        assertEquals(2, d.getElementsByTagName("gml:pos").getLength());
        assertEquals(0, d.getElementsByTagName("gml:coord").getLength());

        assertEquals(2, d.getElementsByTagName("geotools:feature").getLength());
        assertNotNull(
                ((Element) d.getElementsByTagName("geotools:feature").item(0))
                        .getAttribute("gml:id"));
    }

    public void testEncodeFeatureCollectionCoordinatesFormatting11() throws Exception {
        org.geotools.wfs.v1_1.WFSConfiguration configuration =
                new org.geotools.wfs.v1_1.WFSConfiguration();
        configuration.getProperties().add(GMLConfiguration.OPTIMIZED_ENCODING);
        ((org.geotools.gml3.GMLConfiguration)
                        configuration.getDependency(org.geotools.gml3.GMLConfiguration.class))
                .setForceDecimalEncoding(true);
        ((org.geotools.gml3.GMLConfiguration)
                        configuration.getDependency(org.geotools.gml3.GMLConfiguration.class))
                .setNumDecimals(4);
        ((org.geotools.gml3.GMLConfiguration)
                        configuration.getDependency(org.geotools.gml3.GMLConfiguration.class))
                .setPadWithZeros(true);
        Encoder e = new Encoder(configuration);
        e.getNamespaces().declarePrefix("geotools", "http://geotools.org");
        e.setIndenting(true);

        Document d = e.encodeAsDOM(fc, WFS.FeatureCollection);
        // XMLTestSupport.print(d);
        assertEquals(2, d.getElementsByTagName("gml:Point").getLength());
        assertEquals(2, d.getElementsByTagName("gml:pos").getLength());
        assertEquals(0, d.getElementsByTagName("gml:coord").getLength());
        assertEquals("1.0000 1.0000", d.getElementsByTagName("gml:pos").item(0).getTextContent());
        assertEquals(2, d.getElementsByTagName("geotools:feature").getLength());
        assertNotNull(
                ((Element) d.getElementsByTagName("geotools:feature").item(0))
                        .getAttribute("gml:id"));
    }

    public void testEncodeFeatureCollectionMultipleFeatureTypes() throws Exception {
        DefaultFeatureCollection features = new DefaultFeatureCollection();

        SimpleFeatureTypeBuilder tb = new SimpleFeatureTypeBuilder();
        tb.setName("feature2");
        tb.setNamespaceURI("http://geotools.org/geotools2");
        tb.add("geometry", Point.class);
        tb.add("integer", Integer.class);

        SimpleFeatureBuilder b = new SimpleFeatureBuilder(tb.buildFeatureType());
        b.add(new GeometryFactory().createPoint(new Coordinate(0, 0)));
        b.add(0);
        features.add(b.buildFeature("zero"));

        b.add(new GeometryFactory().createPoint(new Coordinate(1, 1)));
        b.add(1);
        features.add(b.buildFeature("one"));

        fc.getFeature().add(features);

        Encoder e = new Encoder(new org.geotools.wfs.v1_1.WFSConfiguration());
        e.getNamespaces().declarePrefix("geotools", "http://geotools.org");
        e.getNamespaces().declarePrefix("geotools2", "http://geotools.org/geotools2");
        e.setIndenting(true);

        Document d = e.encodeAsDOM(fc, WFS.FeatureCollection);
        assertEquals(2, d.getElementsByTagName("geotools:feature").getLength());
        assertEquals(2, d.getElementsByTagName("geotools2:feature2").getLength());
    }
}