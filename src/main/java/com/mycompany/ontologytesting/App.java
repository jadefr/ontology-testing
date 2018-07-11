/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ontologytesting;

import java.io.IOException;

/**
 *
 * @author jadef
 */
public class App {

    public static void main(String[] args) throws IOException {
        OntologyAccess oa = new OntologyAccess();
        ResourceCreation ontologia = new ResourceCreation();
        
        ontologia.createIndividual(oa.loadOntologyModel("oboewcm2.owl"));
        

    }
}
