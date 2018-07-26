/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ontologytesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.ReasonerRegistry;

/**
 *
 * @author jadef
 */
public class OntologyAccess {

    private static OntModel ontModel;
    private static final String PATH = "src/main/files/";

    /**
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static OntModel loadOntologyModel(String fileName) throws IOException {

        ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
        Path pathObj = Paths.get(PATH, fileName);
        InputStream input = new FileInputStream(pathObj.toString());
        ontModel.read(input, "RDF/XML");
        //System.out.println(ontModel);
        Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
        reasoner = reasoner.bindSchema(ontModel);
        OntModelSpec ontModelSpec = OntModelSpec.OWL_DL_MEM_TRANS_INF;
        ontModelSpec.setReasoner(reasoner);
        return ontModel;
    }
}
