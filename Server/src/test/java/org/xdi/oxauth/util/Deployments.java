package org.xdi.oxauth.util;

import java.io.File;

import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ZipImporter;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.xdi.oxauth.gluu.ws.rs.GluuConfigurationWS;
import org.xdi.oxauth.service.ResteasyInitializer;
import org.xdi.oxauth.servlet.OpenIdConfiguration;
import org.xdi.oxauth.token.ws.rs.TokenRestWebService;

/**
 * Creates a deployment from a build Web Archive using ShrinkWrap ZipImporter
 * 
 * @author Yuriy Movchan
 */
public class Deployments {
	private static final String ARCHIVE_NAME = "oxauth.war";
	private static final String BUILD_DIRECTORY = "target";

//	public static WebArchive createDeployment() {
//        return ShrinkWrap.create(ZipImporter.class, ARCHIVE_NAME).importFrom(new File(BUILD_DIRECTORY + '/' + ARCHIVE_NAME))
//        .as(WebArchive.class);
//	}
//	public static JavaArchive createDeployment() {
//		return ShrinkWrap.create(JavaArchive.class, "test.jar").addClasses(
//				GluuConfigurationWS.class)
//	            .addClass(ResteasyInitializer.class)
//	            .addPackage(GluuConfigurationWS.class.getPackage())
//    		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//	}
	public static WebArchive createDeployment() {
		final WebArchive war = ShrinkWrap.create(WebArchive.class, "oxauth.war")
	         // adding the configuration class silences the logged exception when building the configuration on the server-side, but shouldn't be necessary
	         //.addClass(JettyEmbeddedConfiguration.class)
	            // Resteasy services
//	            .addClass(ResteasyInitializer.class)
//	            .addPackage(GluuConfigurationWS.class.getPackage())
	            // Servlets
//	            .addPackage(OpenIdConfiguration.class.getPackage())
//	            .addPackages(true, "org.xdi.oxauth")
	         .addAsWebInfResource("jetty-env.xml")
	         .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
	         .setWebXML("web.xml");
	      return war;
		}

}
