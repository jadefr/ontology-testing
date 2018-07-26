/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ontologytesting;

import java.io.IOException;
import org.apache.jena.ontology.OntModel;

/**
 *
 * @author jadef
 */
public class App {

    public static void main(String[] args) throws IOException {
        
        OntModel ontModel = OntologyAccess.loadOntologyModel("oboewcm2.owl");
        ResourceCreation.createIndividual(ontModel);

    }
}
