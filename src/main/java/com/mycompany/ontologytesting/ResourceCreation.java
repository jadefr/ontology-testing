/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ontologytesting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.apache.jena.ontology.Individual;
import org.apache.jena.ontology.ObjectProperty;
import org.apache.jena.ontology.OntClass;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.ResourceFactory;

/**
 *
 * @author jadef
 */
public class ResourceCreation {

    private static final String PATH = "src/main/files/";
    private static final String BASE_URI1 = "http://ecoinformatics.org/oboe/oboe.1.2/oboe-core.owl#";
    private static final String BASE_URI2 = "http://www.semanticweb.org/jadef/ontologies/2018/4/wcm#";
    private static final String BASE_URI3 = "http://ecoinformatics.org/oboe/oboe.1.2/oboe-characteristics.owl#";
    private static final String BASE_URI4 = "http://ecoinformatics.org/oboe/oboe.1.2/oboe-standards.owl#";
    private static final String BASE_URI5 = "http://www.semanticweb.org/jadef/ontologies/2018/4/oboe_wcm#";

    /**
     *
     * @param ontModel
     * @throws IOException
     */
    public static void createIndividual(OntModel ontModel) throws IOException {

        //Individuo da classe Entity - forma resumida
        OntClass darkSkyClass = ontModel.getOntClass(BASE_URI1 + "Entity"); //seleciona a classe Entity
        System.out.println(darkSkyClass);
        Individual darkSkyIndividual = darkSkyClass.createIndividual(BASE_URI5 + "DarkSky"); // nome da instancia
        System.out.println(darkSkyIndividual);

        //Individuo da classe observation
        OntClass observationClass = ontModel.getOntClass(BASE_URI1 + "Observation");
        System.out.println(observationClass);
        Individual observationIndividual = observationClass.createIndividual(BASE_URI5 + "Observation");
        System.out.println(observationIndividual);
        
        //Recuperar object properties já existentes na ontologia
        ObjectProperty ofEntity = ontModel.getObjectProperty(BASE_URI1 + "ofEntity");

        //Setar observation como dominio e darkSky como range
        Resource objpropOfEntity = observationIndividual.addProperty(ofEntity, darkSkyIndividual);

        OutputStream out = new FileOutputStream(PATH + "\\oboe_wcm_output.rdf");
        ontModel.write(out, "RDF/XML-ABBREV");
        out.close();

    }
}
