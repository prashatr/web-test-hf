# web-test-hf

* To run Test cases parallelly using <parallel> configuration in maven-surefire-plugin <artifact>
To run them parallelly, execute mvn clean test

* To run a specific Test case, 
1. In pom.xml, for maven-surefire-plugin <artifact>, add <groups> to configuration & put name of testcase to be run
eg. if you want to run "TC1_SignInTest" test case, put <groups>com.hellofresh.challenge.Tests.TC1_SignInTest</groups> in configuration
2. then, in command line, execute mvn clean test
