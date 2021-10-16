package asos;

import org.aspectj.lang.ProceedingJoinPoint;

public class EncryptionAspect {

    public Object encryptAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("[encryptAround]: " + jp.getSignature());
        Object ret = jp.proceed();
        Object newRet = encrypt(ret.toString(), 4);
//        System.out.println("      Ret: " + ret);
//        System.out.println("      New ret: " + newRet);
        return newRet;
    }
    public Object decryptAround(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("[decryptAround]: " + jp.getSignature());
        
        Object arg = jp.getArgs()[0];
        Object[] newArgs = {decrypt(arg.toString(), 4)};
        
//        System.out.println("      Args: " + arg);
//        System.out.println("      New args: " + newArgs[0]);

        return jp.proceed(newArgs);
    }

    public Object encrypt(String plaintext, int shift){
        String ciphertext = "";
        char alphabet;
        for (int i = 0; i < plaintext.length(); i++) {
            alphabet = plaintext.charAt(i);

            if (alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char) (alphabet + shift);
                if (alphabet > 'z') {
                    alphabet = (char) (alphabet + 'a' - 'z' - 1);
                }
                ciphertext = ciphertext + alphabet;
            } 
            else if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet + shift);
                if (alphabet > 'Z') {
                    alphabet = (char) (alphabet + 'A' - 'Z' - 1);
                }
                ciphertext = ciphertext + alphabet;
            } else {
                ciphertext = ciphertext + alphabet;
            }
        }
        return ciphertext;
    }
    
    public Object decrypt(String ciphertext, int shift){
        String decryptMessage = "";
        for (int i = 0; i < ciphertext.length(); i++) {
            char alphabet = ciphertext.charAt(i);
            if (alphabet >= 'a' && alphabet <= 'z') {
                alphabet = (char) (alphabet - shift);
                if (alphabet < 'a') {
                    alphabet = (char) (alphabet - 'a' + 'z' + 1);
                }
                decryptMessage = decryptMessage + alphabet;
            } 
            else if (alphabet >= 'A' && alphabet <= 'Z') {
                alphabet = (char) (alphabet - shift);
                if (alphabet < 'A') {
                    alphabet = (char) (alphabet - 'A' + 'Z' + 1);
                }
                decryptMessage = decryptMessage + alphabet;
            } else {
                decryptMessage = decryptMessage + alphabet;
            }
        }
        return decryptMessage;
    }
}
