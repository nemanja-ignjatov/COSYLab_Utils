# COSYLab Libraries

This module contains Java libraries required for building the provided COSYLab components. 
Projects for COSYLab components are:
- Cloud components - https://github.com/nemanja-ignjatov/COSYLab_Cloud
- Fog components - https://github.com/nemanja-ignjatov/COSYLab_Fog

Libraries are separated in four utilities modules:

1. cloud_utils - utilities for Cloud components

2. fog_utils - utilities for Fog components

3. crypto_utils - network security utilities

4. context_utils - context information management utilities

### Cloud Utilities

Cloud utilities contain Java classes required for HTTP communication with and between Cloud components.
Provided utilities are split in following packages:
- **payloads** - Communication messages payloads for Cloud components;
- **exceptions** - Class for modelling error handling;
- **utils** - Shared Cloud components constants.

### Fog Utilities

Fog utilities provide functionalities for AMQP and HTTP communication between Fog components, as well as shared utilities between them.
Provided functionalities are separated in packages as follows:
- **amqp_utils** - generic AMQP payloads, AMQP route constants, AMQP message and error handlers;
- **error_handling** - Classes for modeling exceptions in AMQP communication and components business logic;
- **http_utils** - HTTP error handling;
- **payloads** - Communication message payloads for Fog components;
- **faca** - Utilities for access rules application within FACA component;
- **globals** - Common constants and placeholders.

### Crypto Utilities

Crypto utilities containg supporting functionalities for the provided Identity and Trust management features within COSYLab.
These features are separated in the following packages:
- **identities** - Utilities for managing(creating, parsing) identities within COSYLab platform;
- **jws** - Utilities for features based on the JWS, i.e. session tokens;
- **pki** - Support for digital certificates, keystores, enerating public key pairs;
- **utils** - Support for AES and EC encryptions, as well as global security constants and utilitiy functions.

### Context Utilities

This module contains utilities for managing context information and its integration with FACA component.
Provided utilities are organized in packages as follows:
- **amqp** - Support for AMQP-based context information exchange;
- **attributes** - Classes for modelling attributes containing context information;
- **payloads** - Communication messages payloads for exchanging context information with FACA component.

###How to build libraries

Libraries can be build together or separately. Both build options are triggered using command:
> mvn clean install

To build all libraries, execute this command in this folder. Otherwise, execute the command in the folder of the specific utilities library.
Afterwards, compiled and installed libraries can be used for building COSYLab components.