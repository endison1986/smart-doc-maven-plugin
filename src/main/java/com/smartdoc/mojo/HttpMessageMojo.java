package com.smartdoc.mojo;

import com.power.doc.builder.HttpMessageBuilder;
import com.power.doc.model.ApiConfig;
import com.smartdoc.constant.MojoConstants;
import com.thoughtworks.qdox.JavaProjectBuilder;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Execute;
import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.ResolutionScope;

/**
 * @author biding
 */
@Execute(phase = LifecyclePhase.COMPILE)
@Mojo(name = MojoConstants.HTTP_MESSAGE_MOJO, requiresDependencyResolution = ResolutionScope.COMPILE)
public class HttpMessageMojo extends BaseDocsGeneratorMojo {
    @Override
    public void executeMojo(ApiConfig apiConfig, JavaProjectBuilder javaProjectBuilder) throws MojoExecutionException, MojoFailureException {
        try {
            HttpMessageBuilder.buildApiDoc(apiConfig, javaProjectBuilder);
        } catch (Exception e) {
            getLog().error(e);
        }
    }
}
