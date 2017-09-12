# Overview
I wanted to be able to use a simple AWS credentials provider to assume into a role using the credentials in my default profile when using the AWS Athena JDBC driver.

My driver config includes the following jars:

```
AthenaJDBC41-1.1.0.jar
commons-logging-1.2.jar
httpcore-4.4.4.jar
jackson-core-2.6.6.jar
joda-time-2.8.1.jar
aws-java-sdk-1.11.184.jar
httpclient-4.5.2.jar
jackson-annotations-2.6.0.jar
jackson-databind-2.6.6.jar
sts-assume-role.jar
```

And my connection properties include:

```
aws_credentials_provider_arguments: arn:aws:iam::123123123131231:role/RoleXXYYYZZZ
aws_credentials_provider_class: com.hawknewton.maven_test.STSAssumeRoleFromProfileCredentialsProvider
```

Good luck!
