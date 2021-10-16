package sk.stuba.fei.uim.asos.cvicenie1.dependencyinjection;

import org.springframework.stereotype.Component;

@Component
public class SlovakTranslationService implements TranslationService {

    @Override
    public String translate(String input) {
        return input + " po slovensky";
    }
}
