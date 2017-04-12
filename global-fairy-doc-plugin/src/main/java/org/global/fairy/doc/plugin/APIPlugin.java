package org.global.fairy.doc.plugin;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

@Mojo(name = "api")
public class APIPlugin extends AbstractMojo{
	//Logger logger = LogManager.getLogManager().getLogger(this.getClass().getSimpleName());

	/**
	 * 
	@parameter name="${basePackagePath}"
	*/
	public String basePackagePath ;;
	public void execute() throws MojoExecutionException, MojoFailureException {
		//logger.info("=======================plugin");
		
		System.out.println("=================plugin");
		System.out.println("=================basePackagePath:"+basePackagePath);
	}

}
