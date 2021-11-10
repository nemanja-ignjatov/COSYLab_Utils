# COSYLab Build Configuration

This submodule exports versions for COSYLab libraries, which are defined in the pom.xml file.

For that purpose, following libraries versions are currently exported:

- Cloud Library - containing utilities for Cloud components
- Fog Library - containing utilities for Fog components
- Crypto Library - containing utilities for security features (certificates, encryption, PKI, etc.)
- Context library - containing utilities for managing context information

###Exporting versions

Versions are exported by executing following command:
> mvn clean install

Afterwards, exported versions can be used for building COSYLab libraries.