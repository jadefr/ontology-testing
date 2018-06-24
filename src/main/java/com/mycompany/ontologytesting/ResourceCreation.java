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

    String path = "C:\\Users\\jadef\\Documents\\NetBeansProjects";
    String baseURI1 = "http://ecoinformatics.org/oboe/oboe.1.2/oboe-core.owl#";
    String baseURI2 = "http://www.semanticweb.org/jadef/ontologies/2018/4/wcm#";
    String baseURI3 = "http://ecoinformatics.org/oboe/oboe.1.2/oboe-characteristics.owl#";
    String baseURI4 = "http://ecoinformatics.org/oboe/oboe.1.2/oboe-standards.owl#";

    public void createIndividual(OntModel ontModel) throws IOException {

        //Individuo da classe DarkSky (que equivale a uma entity) - forma resumida
        OntClass darkSkyClass = ontModel.getOntClass(baseURI2 + "DarkSky"); //seleciona a classe DarkSky
        Individual darkSkyIndividual = darkSkyClass.createIndividual(baseURI2 + "darkSky"); // nome da instancia

        //Individuo da classe observation
        OntClass observationClass = ontModel.getOntClass(baseURI1 + "Observation");
        Individual observationIndividual = observationClass.createIndividual(baseURI2 + "observation");

        //Recuperar object properties já existentes na ontologia
        ObjectProperty ofEntity = ontModel.getObjectProperty(baseURI1 + "ofEntity");

        //Setar observation como dominio e darkSky como range
        Resource objpropOfEntity = observationIndividual.addProperty(ofEntity, darkSkyIndividual);

        OutputStream out = new FileOutputStream(path + "\\oboe_wcm_output.rdf");
        ontModel.write(out, "RDF/XML-ABBREV");
        out.close();

    }
}
