# Spring Course - Circular dependency
![Java CI with Maven](https://github.com/Interes-Group/spring-course-circular-dependency/workflows/Java%20CI%20with%20Maven/badge.svg?event=push)
![License MIT](https://img.shields.io/badge/License-MIT-green)
![Java 1.8](https://img.shields.io/badge/Java-1.8-blue)

Cieľom je oboznámiť sa s problémom kruhovej závislosti. Dokumentácia je dostupná na [docs.spring.io](https://docs.spring.io/spring-framework/docs/current/spring-framework-reference/core.html#beans-dependency-resolution)

## Problém
Projekt demonštruje problém cyklickej závislosti.

Cyklická závislosť vzniká napríklad pri nasledujúcom kóde dvoch spring komponentov:
```
public class ServiceA {
    private final String secret = "A";
    private final ServiceB serviceB;
 
    public String getSecret() {
        return secret;
    }
   
    public String getCombinedSecrets() {
        return secret + serviceB.getSecret();
    }
}
public class ServiceB {
    private final String secret = "B";
    private final ServiceA serviceA;
 
    public String getSecret() {
        return secret;
    }
 
    public String getCombinedSecrets() {
        return secret + serviceA.getSecret();
    }
}
```

## Riešenie
 - Lazy loading závislosti
 - Setter-based dependency injection
 
## Build
Maven build: `mvn clean compile package` 
