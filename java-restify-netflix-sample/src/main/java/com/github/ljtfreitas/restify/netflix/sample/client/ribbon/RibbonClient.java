package com.github.ljtfreitas.restify.netflix.sample.client.ribbon;

import static java.util.Arrays.asList;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.github.ljtfreitas.restify.http.client.request.jdk.JdkHttpClientRequestFactory;
import com.github.ljtfreitas.restify.http.netflix.client.request.RibbonHttpClientRequestFactory;
import com.github.ljtfreitas.restify.http.netflix.client.request.RibbonLoadBalancedClient;
import com.github.ljtfreitas.restify.netflix.sample.api.SampleObject;
import com.github.ljtfreitas.restify.netflix.sample.client.SampleApi;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.client.config.IClientConfigKey;
import com.netflix.loadbalancer.BaseLoadBalancer;
import com.netflix.loadbalancer.Server;

public class RibbonClient {

	public static void main(String[] args) throws Exception {

		BaseLoadBalancer loadBalancer = new BaseLoadBalancer();
		loadBalancer.addServers(asList(new Server("localhost", 8090), new Server("localhost", 8091), new Server("localhost", 8092)));

		DefaultClientConfigImpl clientConfig = new DefaultClientConfigImpl();
		clientConfig.setProperty(IClientConfigKey.Keys.MaxAutoRetriesNextServer, 3);

		JdkHttpClientRequestFactory delegate = new JdkHttpClientRequestFactory();

		RibbonLoadBalancedClient ribbonLoadBalancedClient = new RibbonLoadBalancedClient(loadBalancer, clientConfig, delegate);
		RibbonHttpClientRequestFactory ribbonHttpClientRequestFactory = new RibbonHttpClientRequestFactory(ribbonLoadBalancedClient);

		SampleApi sampleApi = new RestifyProxyBuilder()
				.client(ribbonHttpClientRequestFactory)
					.target(SampleApi.class, "http://sample-api")
						.build();

		SampleObject sampleObject = sampleApi.get();
		System.out.println(sampleObject);
	}
}
