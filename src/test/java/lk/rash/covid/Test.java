package lk.rash.covid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Test {
    public static void main(String[] args) {
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        String paswrd="nayomirashmikaaa123";
//        String encodedpaswrd=encoder.encode(paswrd);
//        System.out.println(encodedpaswrd);
         PasswordEncoder delegateEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        System.out.println(delegateEncoder.encode("lochana123"));



    }
}
