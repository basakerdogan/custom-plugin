package com.basak.summarize;

import org.apache.maven.plugin.AbstractMojo;


import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugin.logging.Log;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Developer;

@Mojo(name = "summarize", defaultPhase = LifecyclePhase.COMPILE ) 
public class DependencySummarize extends AbstractMojo {
	
	
	@Parameter(defaultValue = "${project}", required = true)
	private MavenProject project;
	
	@Parameter(defaultValue = "${project.build.directory}", required=true)
	private String outputFile;
	Log log;
	
	public void execute() throws MojoExecutionException, MojoFailureException {
		outputFile+="\\summarizeOutputFile.txt";
		List<Dependency> dependecies = project.getDependencies();
		List<Developer> devs = project.getDevelopers();
		String dependencyInfo= "";

	
		
		for (Dependency d : dependecies) {
			String artificantID = d.getArtifactId();
			String groupID = d.getGroupId();
			String getVersion = d.getVersion();
			dependencyInfo+= "artificantID" +artificantID + "groupID" + groupID +"version" +getVersion ;
			log.info("deneme");
			try {
				WriteOutputFile.writeOutput(outputFile, dependencyInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		for(Developer developer: devs){
			String dev = developer.getName();
			int devNumber = developer.getRoles().size();
			dependencyInfo+= "developerName" + dev + "size" + devNumber;
			try {
				WriteOutputFile.writeOutput(outputFile, dependencyInfo);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	
		
		
		
		
	}

}
