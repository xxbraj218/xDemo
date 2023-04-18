
This project is only intended Demo project.


Build the project :
Plese switch to the folder clientservice: gradle build


run the project using the following command:

java -jar /YOUR_PROJECT_LOCATION/File-Upload-Download/clientservice/build/libs/clientservice-0.0.1-SNAPSHOT.jar



Additinal details:The file can be uploaded by adding a key in the body of the post request, of the http://localhost:8080/upload/

1)The user will be able to upload a document to the local file system

2)jacoco coverage enabled

3)integration and calling for the third party api is enabled, a sample happy scenario.

4)Generic error API as defined for using it for error handling, further could be incorporated for enhancing.

5)For handling of the co-relationID and the request tracing across the application could be enabled.

6)Junit test case had been configured and a sample for reference.

7)Apart from it the size limit the file could be enforced from backend along with the front end.

8)The DB will contain the user, file details ,audit and transaction table at high level.

9)Exception could be further subdivided to business and technical generic applicable to rest API service

10)The downstream service a sample call had been done from the code itself for reference


11)Provisioning for timeout etc could be further done.


12)CI/CD etc could be leveraged along with any API gateway feature, further enhancement will have to be done.


13)Security feature will have to be incorporated as per the one in organization.
