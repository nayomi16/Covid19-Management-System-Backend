package lk.rash.covid;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String paswrd="lochana123";
        String encodedpaswrd=encoder.encode(paswrd);
        System.out.println(encodedpaswrd);


    }
}
