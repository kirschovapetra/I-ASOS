# Zadanie 1 - Úvod do Spring Framework
Cieľom zadania je overiť základné znalosti používania Spring Frameworku.

Pomocou jazyka Java a frameworku Spring vytvorte systém podľa nasledovnej špecifikácie. 
Systém uchováva informácie o osobách (poistenec/poisťovateľ) a ich zmluvách. 
Pokiaľ nie je uvedené inak sú všetky dáta povinné. Pre jednotlivé dátové atribúty zvoľte vhodnú reprezentáciu (int, float, String, ...).

## Osoba
O každej osobe systém eviduje nasledovné dáta: 
 - unikátny identifikátor (ID), 
 - meno, 
 - priezvisko, 
 - rodné číslo, 
 - e-mail,
 - adresa trvalého pobytu, 
 - korešpondenčná adresa, 
 - zoznam zmlúv (zmluvy uzatvorené osobou)

Pokiaľ korešpondenčná adresa osoby nie je definovaná, použije sa jeho adresa trvalého pobytu. Adresa sa skladá z: 
 - PSČ, 
 - názvu obce, 
 - názvu ulice, 
 - orientačného čísla domu
 
Trieda osoby musí dediť od AbstractUser.

## Typy zmlúv
Systém eviduje dva typy zmlúv: životné poistenie a neživotné poistenie. Každá zmluva má priradené: 
 - unikátne číslo zmluvy (ID), 
 - dátum vzniku,
 - referenciu na poisťovateľa (osoba ktorá zmluvu uzavrela),
 - dátum začiatku a konca poistenia,
 - výšku poistného plnenia (suma, na ktorú sa poisťuje),
 - výšku mesačnej splátky. 

### Životné poistenie
Medzi zmluvy životného poistenia patria:

#### Cestovné poistenie
 - referenciu na poistenca
 - v rámci EU / mimo EU
 - účel cesty (číselníková hodnota, povolené sú: pracovne, rekreačne, šport, a pod.)

#### Úrazové poistenie
 - referenciu na poistenca
 - trvalé následky úrazu	(poistná suma v eurách)
 - Smrť v dôsledku úrazu (poistná suma v eurách)
 - Denné odškodné za hospitalizáciu (poistná suma v eurách)
 - Územná platnosť (číselníková hodnota, povolené hodnoty sú: “Slovensko”, “Svet”, “Svet + Slovensko”)

### Neživotné poistenie
Medzi zmluvy neživotného poistenia patria:

#### Poistenie domácnosti 
 - typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný dom - murovaný", "Rodinný dom - drevený")
 - adresa nehnuteľnosti
 - hodnota nehnuteľnosti v eurách 
 - hodnota zariadenia domácnosti v eurách 

#### Poistenie domu a bytu
 - typ nehnuteľnosti (číselníková hodnota, povolené hodnoty sú: "Byt", "Rodinný dom - murovaný", "Rodinný dom - drevený")
 - adresa nehnuteľnosti
 - hodnota nehnuteľnosti v eurách 
 - pripoistenie garáže (áno / nie)
 
Trieda zmluvy musí dediť od AbstractInsuranceContract.

## Funkcionalita API
Systém poskytuje nasledovnú funkcionalitu (API):

### Správa osôb
 - Pridanie novej osoby
 - Aktualizácia existujúcej osoby
 - Vylistovanie všetkých osôb v systéme
 - Nájdenie konkrétnej osoby (podla unikátneho identifikátora)

### Správa poistných zmlúv
 - Založenie poistnej zmluvy osobe
 - Aktualizácia existujúcej zmluvy
 - Vylistovanie všetkých poistných zmlúv
 - Vylistovanie poistných zmlúv pre daného poisťovateľa (podľa unikátneho identifikátora osoby) - vylistuje len zmluvy, kde je daná osoba poisťovateľom!

Nech API implementuje rozhranie (IUserService / IInsuranceContractService). Vytvorte konkrétnu implementáciu pre dané rozhrania. 

Pre demonštráciu funkcionality vytvorte v main metóde aspoň jedného používateľa a založte mu aspoň jednu ľubovoľnú zmluvu.

## Hodnotenie
Zadanie si naklonujte z repozitára zadania. Svoje vypracovanie nahrajte do vášho repozitára pre toto zadanie pomocou programu Git (git commit + git push). Vypracovanie môžete “pusho-vať” priebežne. 

Ešte pred programovaním napíšte svoje AIS ID, meno a priezvisko do pom.xml ako developer, aby sme vám vedeli zapísať body.

Hodnotiť sa bude iba master branch, na ktorej budú spustené aj hodnotiace testy pri každej aktualizácii kódu. Za každý úspešný test je udelené 0,5 bodu. Testy je prísne zakázané upravovať! Iba body získané z poslednej verzie vypracovania (t.j. z posledného commitu) sa berú do úvahy. 

Zadanie je hodnotené 5 bodmi:
 - 1b - dátový model, použité princípy OOP, návrh aplikácie
 - 0,5b - za každý úspešný test, celkovo 8 testov
