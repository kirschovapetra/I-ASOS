# I-ASOS

Architektúra softvérových systémov (2. ročník ING, zimný semester)

## Web Services

<br>

### Web aplikácia - server

    File -> New Project -> Java with Maven -> Web Application

#### Pridať nový WS

    *klik na projekt* New -> Other -> Web Services -> Web service

#### Async

    @Oneway - iba pre void ktore nehadzu vynimky

<br>

### Web aplikácia - klient

    File -> New Project -> Java with Maven -> Java Application

#### Pridať WS klienta

    *klik na projekt* New -> Other -> Web Services -> Web Service Client

#### Async
    Web Service References -> Edit Web Servide Attribute -> MyWebService (alebo 
    Global Customization) -> Enable Asynchronous Client

* Async Polling - TODO 
* Async callback - TODO


### Linky

* GlassFish admin console: http://localhost:4848/common/index.jsf
* Index: http://localhost:8080/NazovProjektu/
* Tester: http://localhost:8080/NazovProjektu/NazovServisu?Tester
* WSDL: http://localhost:8080/NazovProjektu/NazovServisu?WSDL