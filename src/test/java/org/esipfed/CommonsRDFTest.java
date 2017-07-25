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

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

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

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  @Test
  @Ignore
  public final void test() {
    fail("Not yet implemented"); // TODO
  }

}
