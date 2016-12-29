package com.github.ljtfreitas.restify.netflix.sample.client.ribbon.zookeeper;

import java.util.Collections;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.discovery.details.InstanceSerializer;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import com.github.ljtfreitas.restify.http.RestifyProxyBuilder;
import com.github.ljtfreitas.restify.http.client.request.jdk.JdkHttpClientRequestFactory;
import com.github.ljtfreitas.restify.http.netflix.client.request.RibbonHttpClientRequestFactory;
import com.github.ljtfreitas.restify.http.netflix.client.request.RibbonLoadBalancedClient;
import com.github.ljtfreitas.restify.http.netflix.client.request.zookeeper.ZookeeperDiscoveryConfiguration;
import com.github.ljtfreitas.restify.http.netflix.client.request.zookeeper.ZookeeperInstance;
import com.github.ljtfreitas.restify.http.netflix.client.request.zookeeper.ZookeeperServers;
import com.github.ljtfreitas.restify.http.netflix.client.request.zookeeper.ZookeeperServiceDiscovery;
import com.github.ljtfreitas.restify.netflix.sample.api.SampleObject;
import com.github.ljtfreitas.restify.netflix.sample.client.SampleApi;
import com.netflix.client.config.DefaultClientConfigImpl;
import com.netflix.loadbalancer.ClientConfigEnabledRoundRobinRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.LoadBalancerBuilder;

public class RibbonZookeeperClient {

	public static void main(String[] args) throws Exception {
		DefaultClientConfigImpl ribbonLoadBalacerConfiguration = new DefaultClientConfigImpl();
		ribbonLoadBalacerConfiguration.setClientName("sample-api");

		ClientConfigEnabledRoundRobinRule rule = new ClientConfigEnabledRoundRobinRule();
		rule.initWithNiwsConfig(ribbonLoadBalacerConfiguration);

		ZookeeperDiscoveryConfiguration zookeeperDiscoveryConfiguration = new ZookeeperDiscoveryConfiguration();
		zookeeperDiscoveryConfiguration.root("/services").serviceName("sample-api");

		CuratorFramework curator = CuratorFrameworkFactory.builder()
				.connectString("localhost:2181")
				.retryPolicy(new RetryOneTime(1000))
					.build();
		curator.start();

		InstanceSerializer<ZookeeperInstance> serializer = new JsonInstanceSerializer<>(ZookeeperInstance.class);

		ZookeeperServiceDiscovery zookeeperServiceDiscovery = new ZookeeperServiceDiscovery(zookeeperDiscoveryConfiguration, curator, serializer);
		zookeeperServiceDiscovery.register(new ZookeeperInstance("sample-api", "localhost", 8090, Collections.emptyMap()));
		zookeeperServiceDiscovery.register(new ZookeeperInstance("sample-api", "localhost", 8091, Collections.emptyMap()));
		zookeeperServiceDiscovery.register(new ZookeeperInstance("sample-api", "localhost", 8092, Collections.emptyMap()));

		ZookeeperServers zookeeperServers = new ZookeeperServers("sample-api", zookeeperServiceDiscovery);

		ILoadBalancer loadBalancer = LoadBalancerBuilder.newBuilder()
				.withRule(rule)
				.withClientConfig(ribbonLoadBalacerConfiguration)
				.withDynamicServerList(zookeeperServers)
					.buildDynamicServerListLoadBalancer();

		JdkHttpClientRequestFactory delegate = new JdkHttpClientRequestFactory();

		RibbonLoadBalancedClient ribbonLoadBalancedClient = new RibbonLoadBalancedClient(loadBalancer, ribbonLoadBalacerConfiguration, delegate);
		RibbonHttpClientRequestFactory ribbonHttpClientRequestFactory = new RibbonHttpClientRequestFactory(ribbonLoadBalancedClient);

		SampleApi sampleApi = new RestifyProxyBuilder()
				.client(ribbonHttpClientRequestFactory)
					.target(SampleApi.class, "http://sample-api")
						.build();

		SampleObject sampleObject = sampleApi.get();
		System.out.println(sampleObject);

		Thread.sleep(2000);

		sampleObject = sampleApi.get();
		System.out.println(sampleObject);

		Thread.sleep(2000);

		sampleObject = sampleApi.get();
		System.out.println(sampleObject);

		curator.close();
	}
}
