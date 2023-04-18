
This project is only intended Demo project.


Build the project :
Plese switch to the folder clientservice: gradle build


run the project using the following command:

java -jar /YOUR_PROJECT_LOCATION/File-Upload-Download/clientservice/build/libs/clientservice-0.0.1-SNAPSHOT.jar



Additinal details:The file can be uploaded by adding a key in the body of the post request, of the http://localhost:8080/upload/

The user will be able to upload a document to the local file system
jacoco coverage enabled

integration and calling for the third party api is enabled, a sample happy scenario.

Generic error API as defined for using it for error handling, further could be incorporated for enhancing.

For handling of the co-relationID and the request tracing across the application could be enabled.

Junit test case had been configured and a sample for reference.

Apart from it the size limit the file could be enforced from backend along with the front end.

The DB will contain the user, file details ,audit and transaction table at high level.

Exception could be further subdivided to business and technical generic applicable to rest API service

The downstream service a sample call had been done from the code itself for reference


Provisioning for timeout etc could be further done.


CI/CD etc could be leveraged along with any API gateway feature, further enhancement will have to be done.

Security feature will have to be incorporated as per the one in organization.
