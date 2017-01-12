package com.github.ljtfreitas.restify.cdi.sample;

import org.apache.deltaspike.cdise.api.CdiContainer;
import org.apache.deltaspike.cdise.api.CdiContainerLoader;
import org.apache.deltaspike.core.api.provider.BeanProvider;

public class DeltaSpikeSample {

	public static void main(String[] args) {
		CdiContainer cdiContainer = CdiContainerLoader.getCdiContainer();

		try {
			cdiContainer.boot();
			cdiContainer.getContextControl().startContexts();

			GithubApi githubApi = BeanProvider.getContextualReference(GithubApi.class);

			System.out.println(githubApi.findRepository("ljtfreitas", "java-restify"));

		} finally {
			cdiContainer.shutdown();
		}
	}
}
