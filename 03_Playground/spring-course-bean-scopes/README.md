# Spring Course - Bean scopes
![Java CI with Maven](https://github.com/Interes-Group/spring-course-bean-scopes/workflows/Java%20CI%20with%20Maven/badge.svg?event=push)
![License MIT](https://img.shields.io/badge/License-MIT-green)
![Java 1.8](https://img.shields.io/badge/Java-1.8-blue)

Cieľom je oboznámiť sa s rôznymi bean scopes. Dokumentácia je dostupná na [spring docs](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-factory-scopes) .

## Obsah projektu
 - AbstractBean – Abstraktná trieda , ktorá obsahuje atribút name typu String. V konstriktore nastavuje tento atribút na hodnotu “<nazov triedy>:<aktualny timestamp>”.
 - triedy, dediace od AbstractBean reprezentujúce rôzne použitie scope:
    - SingletonBean
    - PrototypeBean
    - RequestBean
    - SessionBean

## Testovanie
Súčasťou projektu je RESTful endpoint pre otestovanie vytvorenia definovných komponentov na základe scope-u.
Endpoint je možné zavolať:
`curl localhost:8080`

Endpoint, ktorý pri zavolaní:
 1. načíta z aktuálneho aplikačného kontextu (ApplicationContext) všetky beany,
 2. vytvorí reťazec obsahujúci hodnoty atribútu name jednotlivých bean vhodne oddelených (napr. “\n”),
 3. počká 500ms,
 4. znovu načíta všetky beany,
 5. do vytvoreného reťazca znova pridá hodnoty atribútu name jednotlivých bean
 6. vráti vytvorený reťazec
 
### Očakávané správanie
**SingletonBean** by mal vždy vrátiť rovnaký názov pri každom volaní – vytvára sa vždy len jedna inštancia. 

**PrototypeBean** by mal pri každom volaní vrátiť rôzne hodnoty, aj v rámci volania – pri každom načítaní z aplikačného kontextu sa vytvorí nová inštancia.

**RequestBean** by mal pri každom volaní vrátiť rôzne hodnoty, v rámci volania by mali byť rovnaké – vytvára sa nová inštancia pre každé zavolanie endpointu. 

**SessionBean** by mal vždy vrátiť rovnaký názov pri každom volaní – vytvára sa nová inštancia pre každú používateľskú reláciu, keďže v projekte existuje iba jedna používateľská relácia.

## Build
Maven test - `mvn test`

Maven build - `mvn clean compile package`