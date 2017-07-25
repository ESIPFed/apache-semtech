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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.any23.Any23;
import org.apache.any23.extractor.ExtractionException;
import org.apache.any23.source.DocumentSource;
import org.apache.any23.source.FileDocumentSource;
import org.apache.any23.writer.CountingTripleHandler;
import org.apache.any23.writer.JSONWriter;
import org.apache.any23.writer.TripleHandler;
import org.apache.any23.writer.TripleHandlerException;
import org.junit.Test;


/**
 * Some examples of how one would utilize the Any23 API for parsing and extracting explicit, 
 * embeddd structured markup from dataset landing pages... again using the Aquarius dataset 
 * landing page used in {@link org.esipfed.CommonsRDFTest} as an example.
 *
 * @author lewismc
 *
 */
public class Any23Test {

  @Test
  public final void testAny23DataExtraction() throws IOException, ExtractionException, URISyntaxException {
    //define the Apache Any23 facade instance. The constructor allows to enforce the usage of specific extractors.
    Any23 runner = new Any23();
    //define the FileDocumentSource for local data collection, set a default URI
    DocumentSource source = new FileDocumentSource(
            new File(getClass().getClassLoader().getResource("AQUARIUS_L3_SSS_CAP_7DAY_V4.xhtml").toURI()), 
            "https://podaac.jpl.nasa.gov/dataset/AQUARIUS_L3_SSS_CAP_7DAY_V4");
    //define a buffered output stream used to store data produced by the TripleHandler defined at following line
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    TripleHandler handler = new JSONWriter(baos);
    //define an additional TripleHandler implementation for simply counting exracted triples
    CountingTripleHandler cHandler = new CountingTripleHandler(true);

    //execute metadata extraction using JSONWriter.
    //the produced metadata will be written within the passed TripleHandler instance.
    try {
      runner.extract(source, handler);
    } finally {
      //the TripleHandler needs to be explicitly closed
      try {
        handler.close();
      } catch (TripleHandlerException e) {
        e.printStackTrace();
      }
    }
    //print triples extraction to std out
    System.out.print(baos.toString("UTF-8") + "\n");

    //execute extraction using CountingTripleHandler for triple count verification
    try {
      runner.extract(source, cHandler);
    } finally {
      //the TripleHandler needs to be explicitly closed
      try {
        cHandler.close();
      } catch (TripleHandlerException e) {
        e.printStackTrace();
      }
    }
    //execute simple triple count verification
    assertEquals(16, cHandler.getCount());
  }

  // We could also implement tests for
  // * Data Conversion
  // * Validation and Fixing
  // * Custom XPath extractions
  // * Microformat extractions (e.g. nesting of Microdata, HCard, VCard, etc.)
  // * Microdata extraction
  // * CSV extractions from drone data...
  //
  // for more information visit http://any23.apache.org/developers.html
}
