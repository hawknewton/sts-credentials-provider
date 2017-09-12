package com.hawknewton.maven_test;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.STSAssumeRoleSessionCredentialsProvider;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;

public class STSAssumeRoleFromProfileCredentialsProvider implements AWSCredentialsProvider {
	private AWSCredentialsProvider provider;
	
	public STSAssumeRoleFromProfileCredentialsProvider(String roleArn) {
		String sessionName =  "STSAssumeRoleFromProfileCredentialsProvider" + System.currentTimeMillis();
		AWSCredentialsProvider profileCredentials = new ProfileCredentialsProvider();
		AWSSecurityTokenServiceClientBuilder builder = AWSSecurityTokenServiceClientBuilder.standard().withCredentials(profileCredentials);
		AWSSecurityTokenService service = builder.build();
		provider = new STSAssumeRoleSessionCredentialsProvider.Builder(roleArn,  sessionName).withStsClient(service).build();
	}
	
	public AWSCredentials getCredentials() {
		return provider.getCredentials();
	}
	public void refresh() {
		provider.refresh();
	}
}
