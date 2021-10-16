package sk.stuba.fei.uim.asos.assignment1;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.logging.Logger;

/*

Funkcionalita API
Systém poskytuje nasledovnú funkcionalitu (API):

Správa osôb
    Pridanie novej osoby
    Aktualizácia existujúcej osoby
    Vylistovanie všetkých osôb v systéme
    Nájdenie konkrétnej osoby (podla unikátneho identifikátora)
Správa poistných zmlúv
    Založenie poistnej zmluvy osobe
    Aktualizácia existujúcej zmluvy
    Vylistovanie všetkých poistných zmlúv
    Vylistovanie poistných zmlúv pre daného poisťovateľa (podľa unikátneho identifikátora osoby) - vylistuje len zmluvy, kde je daná osoba poisťovateľom!

Nech API implementuje rozhranie (IUserService / IInsuranceContractService). Vytvorte konkrétnu implementáciu pre dané rozhrania.

Pre demonštráciu funkcionality vytvorte v main metóde aspoň jedného používateľa a založte mu aspoň jednu ľubovoľnú zmluvu.

*/


public class AssignmentApplication {

    private static final Logger log = Logger.getLogger(AssignmentApplication.class.getSimpleName());

    public static void main(String[] args) {
        System.out.println("");
    }
}
