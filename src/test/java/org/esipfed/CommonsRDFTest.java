/*
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain  a copy of the License at 
 *
 * http://www.apache.org/licenses/LICENSE-2.0 Unless 
 *
 * required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" 
 * BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either 
 * express or implied. See the License for the specific language 
 * governing permissions and limitations under the License. 
 */
package org.esipfed;

import static org.junit.Assert.assertEquals;

import org.apache.commons.rdf.api.RDF;
import org.apache.commons.rdf.api.Triple;
import org.apache.commons.rdf.jsonldjava.JsonLdGraph;
import org.apache.commons.rdf.jsonldjava.JsonLdIRI;
import org.apache.commons.rdf.jsonldjava.JsonLdLiteral;
import org.apache.commons.rdf.jsonldjava.JsonLdRDF;
import org.junit.Test;
import org.semarglproject.vocab.XSD;

/**
 * Some examples of how one would write a client using the Commons RDF API. 
 * This example is based off of the core 
 * <a href="https://github.com/apache/commons-rdf/tree/master/examples">CommonsRDF Examples</a> 
 * but adapted for an Earth Science audience.
 * The subject matter is aimed specifically at demonstrating how the
 * <a href="https://podaac.jpl.nasa.gov/dataset/AQUARIUS_L3_SSS_CAP_7DAY_V4">Aquarius CAP Level 3 Sea Surface Salinity Standard Mapped Image 7-Day Data V4.0</a> 
 * dataset hosted at <a href="https://www.jpl.nasa.gov/">NASA JPLs</a> 
 * <a href="https://podaac.jpl.nasa.gov">PO.DAAC</a> can be described and modeled in 
 * <a href="http://www.w3.org/TR/rdf11-concepts/">RDF 1.1</a>.
 * 
 * @author lewismc
 *
 */
public class CommonsRDFTest {

  @Test
  public final void testCommonsRDFDataGeneration() {
    //the implementations of RDF can usually be created using a normal Java constructor
    //for more information see 
    //https://commons.apache.org/proper/commons-rdf/userguide.html#Finding_an_RDF_implementation
    RDF rdf = new JsonLdRDF();
    JsonLdGraph graph = (JsonLdGraph) rdf.createGraph();

    //create a consistent Subject IRI for the Dataset we are processing
    JsonLdIRI datasetSubjectIRI = (JsonLdIRI) rdf.createIRI("https://podaac.jpl.nasa.gov/dataset/AQUARIUS_L3_SSS_CAP_7DAY_V4");

    //DOI
    JsonLdIRI doiPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/identifier");
    JsonLdLiteral doiObjectLiteral = (JsonLdLiteral) rdf.createLiteral("10.5067/AQR40-3T7CS", XSD.ID);
    //triple
    Triple tdoi = rdf.createTriple(datasetSubjectIRI, doiPredicateIRI, doiObjectLiteral);
    graph.add(tdoi);
    
    //Long Name
    JsonLdIRI lnPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/name");
    JsonLdLiteral lnObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "Aquarius CAP Level 3 Sea Surface Salinity Standard Mapped Image 7-Day Data V4.0", XSD.NAME);
    //triple
    Triple tln = rdf.createTriple(datasetSubjectIRI, lnPredicateIRI, lnObjectLiteral);
    graph.add(tln);
    
    //Short Name
    JsonLdIRI snPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/alternateName");
    JsonLdLiteral snObjectLiteral = (JsonLdLiteral) rdf.createLiteral("AQUARIUS_L3_SSS_CAP_7DAY_V4", XSD.NAME);
    //triple
    Triple tsn = rdf.createTriple(datasetSubjectIRI, snPredicateIRI, snObjectLiteral);
    graph.add(tsn);
    
    //Description
    JsonLdIRI dPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/description");
    JsonLdLiteral dObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "Version 4.0 Aquarius CAP Level 3 products are the third release of the "
                    + "AQUARIUS/SAC-D mapped salinity and wind speed data based on the Combined "
                    + "Active Passive (CAP) algorithm. Level 3 standard mapped image products "
                    + "contain gridded 1 degree spatial resolution salinity and wind speed data "
                    + "averaged over 7 day and monthly time scales. This particular data set is "
                    + "the 7-Day running mean sea surface salinity (SSS) V4.0 Aquarius CAP product. "
                    + "CAP is a P.I. produced data set developed and provided by the JPL Climate "
                    + "Oceans and Solid Earth group (S. Yueh). The CAP algorithm utilizes data from "
                    + "both the onboard radiometer and scatterometer to simultaneously retrieve "
                    + "salinity, wind speed and direction by minimizing the sum of squared "
                    + "differences between model and observations. The main improvement in CAP V4.0 "
                    + "is calibration of the rain roughness correction geophysical model function "
                    + "to HYCOM SSS adjusted by the Rain Impact Model (RIM) to account for the rain "
                    + "induced near surface stratification. Rain corrected salinity retrieval at "
                    + "L2 is based on collocation with ancillary rain rate from NOAA CMORPH at 0.25 "
                    + "degree and 30 minute resolution, replacing the SSMI/S and WindSAT data previously "
                    + "used previously for this in CAP V3.0. The Aquarius instrument is onboard the "
                    + "AQUARIUS/SAC-D satellite, a collaborative effort between NASA and the "
                    + "Argentinian Space Agency Comision Nacional de Actividades Espaciales (CONAE). "
                    + "The instrument consists of three radiometers in push broom alignment "
                    + "at incidence angles of 29, 38, and 46 degrees incidence angles relative to "
                    + "the shadow side of the orbit. Footprints for the beams are: 76 km (along-track) "
                    + "x 94 km (cross-track), 84 km x 120 km and 96km x 156 km, yielding a "
                    + "total cross-track swath of 370 km. The radiometers measure brightness temperature "
                    + "at 1.413 GHz in their respective horizontal and vertical polarizations "
                    + "(TH and TV). A scatterometer operating at 1.26 GHz measures ocean backscatter "
                    + "in each footprint that is used for surface roughness corrections in the "
                    + "estimation of salinity. The scatterometer has an approximate 390km swath.", XSD.STRING);
    //triple
    Triple td = rdf.createTriple(datasetSubjectIRI, dPredicateIRI, dObjectLiteral);
    graph.add(td);
    
    //Version
    JsonLdIRI vPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/version");
    JsonLdLiteral vObjectLiteral = (JsonLdLiteral) rdf.createLiteral("4.0", XSD.DOUBLE);
    //triple
    Triple tv = rdf.createTriple(datasetSubjectIRI, vPredicateIRI, vObjectLiteral);
    graph.add(tv);
    
    //Dataset Type
    JsonLdIRI dtPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/additionalType");
    JsonLdLiteral dtObjectLiteral = (JsonLdLiteral) rdf.createLiteral("OPEN", XSD.STRING);
    //triple
    Triple tdt = rdf.createTriple(datasetSubjectIRI, dtPredicateIRI, dtObjectLiteral);
    graph.add(tdt);
    
    //Measurement
    JsonLdIRI mPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/variableMeasured");
    JsonLdLiteral mObjectLiteral = (JsonLdLiteral) rdf.createLiteral("Oceans > Salinity/Density > Salinity", XSD.STRING);
    //triple
    Triple tm = rdf.createTriple(datasetSubjectIRI, mPredicateIRI, mObjectLiteral);
    graph.add(tm);
    
    //Processing Level
    JsonLdIRI plPredicateIRI = (JsonLdIRI) rdf.createIRI("https://raw.githubusercontent.com/mudrod/mudrod_ontologies/master/dif_v10.2.owl#Product_Level_Id");
    JsonLdLiteral plObjectLiteral = (JsonLdLiteral) rdf.createLiteral("3", XSD.INTEGER);
    //triple
    Triple tpl = rdf.createTriple(datasetSubjectIRI, plPredicateIRI, plObjectLiteral);
    graph.add(tpl);
    
    //Spatial Coverage
    //Should be noted that we could also opt to use http://www.w3.org/2003/01/geo/wgs84_pos# 
    //for describing sptail things...
    JsonLdIRI scPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/spatialCoverage");
    JsonLdLiteral scObjectLiteral = (JsonLdLiteral) rdf.createLiteral("90,-90,-180,180", XSD.STRING);
    //triple
    Triple tsc = rdf.createTriple(datasetSubjectIRI, scPredicateIRI, scObjectLiteral);
    graph.add(tsc);
    
    //Temporal Coverage
    JsonLdIRI tcPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/temporalCoverage");
    JsonLdLiteral tcObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "2011-08-25T00:00:00Z/2015-06-07T00:00:00Z", XSD.DURATION);
    //triple
    Triple ttc = rdf.createTriple(datasetSubjectIRI, tcPredicateIRI, tcObjectLiteral);
    graph.add(ttc);
    
    //Resolution
    JsonLdIRI rPredicateIRI = (JsonLdIRI) rdf.createIRI("Resolution");
    JsonLdLiteral rObjectLiteral = (JsonLdLiteral) rdf.createLiteral("ResolutionPlaceHolder");
    //triple
    Triple tr = rdf.createTriple(datasetSubjectIRI, rPredicateIRI, rObjectLiteral);
    graph.add(tr);
    
    //Projection
    JsonLdIRI pPredicateIRI = (JsonLdIRI) rdf.createIRI("Projection");
    JsonLdLiteral pObjectLiteral = (JsonLdLiteral) rdf.createLiteral("ProjectionPlaceHolder");
    //triple
    Triple tp = rdf.createTriple(datasetSubjectIRI, pPredicateIRI, pObjectLiteral);
    graph.add(tp);
    
    //Latency
    //how do we express hours using W3C owl-time?
    JsonLdIRI lPredicateIRI = (JsonLdIRI) rdf.createIRI("http://www.w3.org/2006/time#");
    JsonLdLiteral lObjectLiteral = (JsonLdLiteral) rdf.createLiteral("720", XSD.TIME);
    //triple
    Triple tl = rdf.createTriple(datasetSubjectIRI, lPredicateIRI, lObjectLiteral);
    graph.add(tl);
    
    //Platform
    JsonLdIRI platPredicateIRI = (JsonLdIRI) rdf.createIRI("http://www.w3.org/ns/sosa/Platform");
    JsonLdLiteral platObjectLiteral = (JsonLdLiteral) rdf.createLiteral("AQUARIUS_SAC-D", XSD.STRING);
    //triple
    Triple tplat = rdf.createTriple(datasetSubjectIRI, platPredicateIRI, platObjectLiteral);
    graph.add(tplat);
    
    //Sensor1
    JsonLdIRI s1PredicateIRI = (JsonLdIRI) rdf.createIRI("http://www.w3.org/ns/sosa/Sensor");
    JsonLdLiteral s1ObjectLiteral = (JsonLdLiteral) rdf.createLiteral("AQUARIUS_RADIOMETER", XSD.STRING);
    //triple
    Triple ts1 = rdf.createTriple(datasetSubjectIRI, s1PredicateIRI, s1ObjectLiteral);
    graph.add(ts1);
    
    //Sensor2
    JsonLdIRI s2PredicateIRI = (JsonLdIRI) rdf.createIRI("http://www.w3.org/ns/sosa/Sensor");
    JsonLdLiteral s2ObjectLiteral = (JsonLdLiteral) rdf.createLiteral("AQUARIUS_SCATTEROMETER", XSD.STRING);
    //triple
    Triple ts2 = rdf.createTriple(datasetSubjectIRI, s2PredicateIRI, s2ObjectLiteral);
    graph.add(ts2);
    
    //Project
    JsonLdIRI proPredicateIRI = (JsonLdIRI) rdf.createIRI("http://www.w3.org/ns/sosa/System");
    JsonLdLiteral proObjectLiteral = (JsonLdLiteral) rdf.createLiteral("AQUARIUS_SAC-D", XSD.STRING);
    //triple
    Triple tpro = rdf.createTriple(datasetSubjectIRI, proPredicateIRI, proObjectLiteral);
    graph.add(tpro);
    
    //Data Provider provider
    JsonLdIRI dpPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/provider");
    JsonLdLiteral dpObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "Jet Propulsion Laboratory, 4800 Oak Grove Drive, Pasadena, CA91109, USA", XSD.ENTITY);
    //triple
    Triple tdp = rdf.createTriple(datasetSubjectIRI, dpPredicateIRI, dpObjectLiteral);
    graph.add(tdp);
    
    //Data Provider creator
    JsonLdIRI dpcPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/creator");
    JsonLdLiteral dpcObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "Simon Yueh", XSD.NAME);
    //triple
    Triple tpc = rdf.createTriple(datasetSubjectIRI, dpcPredicateIRI, dpcObjectLiteral);
    graph.add(tpc);
    
    //Data Provider locationCreated
    JsonLdIRI dplcPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/locationCreated");
    JsonLdLiteral dplcObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "Jet Propulsion Laboratory, 4800 Oak Grove Drive, Pasadena, CA91109, USA", XSD.ENTITY);
    //triple
    Triple tdplc = rdf.createTriple(datasetSubjectIRI, dplcPredicateIRI, dplcObjectLiteral);
    graph.add(tdplc);
    
    //Data Provider date published
    JsonLdIRI dpdpPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/datePublished");
    JsonLdLiteral dpdpObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "2015-10-07T00:00:00Z", XSD.DATE_TIME);
    //triple
    Triple tdpdp = rdf.createTriple(datasetSubjectIRI, dpdpPredicateIRI, dpdpObjectLiteral);
    graph.add(tdpdp);
    
    //Keyword(s)
    JsonLdIRI kPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/keywords");
    JsonLdLiteral kObjectLiteral = (JsonLdLiteral) rdf.createLiteral(
            "Aquarius, CAP, salinity, polar, sun-synchronous, sss, psu, CONAE, argentina, JPL", XSD.STRING);
    //triple
    Triple tk = rdf.createTriple(datasetSubjectIRI, kPredicateIRI, kObjectLiteral);
    graph.add(tk);
    
    //Persistent ID
    JsonLdIRI pidPredicateIRI = (JsonLdIRI) rdf.createIRI("http://schema.org/identifier");
    JsonLdLiteral pidObjectLiteral = (JsonLdLiteral) rdf.createLiteral("PODAAC-AQR40-3T7CS", XSD.ID);
    //triple
    Triple tpid = rdf.createTriple(datasetSubjectIRI, pidPredicateIRI, pidObjectLiteral);
    graph.add(tpid);

    System.out.println("Graph size: " + graph.size());
    for (Triple t : graph.iterate()) {
      System.out.println("Triple: " + t.getSubject() + t.getPredicate() + t.getObject());
    }
    assertEquals(23, graph.size());
  }

}
