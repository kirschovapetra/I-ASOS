# Spring Course - Dependency injection
![Java CI with Maven](https://github.com/Interes-Group/spring-course-dependency-injection/workflows/Java%20CI%20with%20Maven/badge.svg?event=push)
![License MIT](https://img.shields.io/badge/License-MIT-green)
![Java 1.8](https://img.shields.io/badge/Java-1.8-blue)

Cieľom je oboznámiť sa s možnosťou DI viacerých implementácií jednej beany.

## Obsah projektu
Projekt obsahuje rozhranie TranslationService, ktoré deklaruje metódu translate s jedným vstupom typu String a výstupom typu String.
Následne, tri rôzne beany implementujúce rozhranie TranslationService pre tri rôzne jazyky (napr. SlovakTranslationService, EnglishTranslationService, GermanTranslationService).
V main triede je závislosť na zoznam TraslationService bean.
Pri štarte aplikácie sa iteruje zoznamom bean a vypíše preklad slova “niečo” pre každý jazyk.