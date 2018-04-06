# Embedded Config Server and Client with Encryption and Decryption fetching Properties from JDBC.

### Embedded Config Server :

@EnableConfigServer makes the application to act as Config Server

Add the property spring.cloud.config.server.bootstrap in bootstrap.yml to boolean value.

### RefreshScope

Modify the properties and make a POST call to /refresh with empty request. Eg : {}.

Now, without restarting the application, we can see the changes made in properties in client side.

### Encryption and Decryption

By default, config server allows encryption and decryption.

Two types of keys can be used : Symmetric and Asymmetric Key

#### Symmetric key : 
		
			set encrypt.key property to simple string of your choice. 

#### Asymmetric Key :

			Generate a server.jks using following command by replacing the values of your choice.

					keytool -genkeypair -alias mytestkey -keyalg RSA -dname "CN=Web Server,OU=Unit,O=Organization,L=City,S=State,C=US"   -keypass changeme -keystore server.jks -storepass letmein

			server.jks will be generated. Place the server.jks file in the same folder of bootstrap.yml

			Add the following props to bootstrap.yml 

					 key-store:
   						 location: server.jks
   						 password: letmein
    					 alias: mytestkey
  						 secret: changeme 


#### How to encrypt and decrypt ??

			To encrypt the string follow the steps : 

					Pass a String to be encrypted as a request to http://localhost:9014/encrypt. 
					Response will be encrypted data.
			
			To decrypt the string follow the steps : 
			
					Pass a encrypted String as a request to http://localhost:9014/decrypt. 
					Response will be decrypted data.


