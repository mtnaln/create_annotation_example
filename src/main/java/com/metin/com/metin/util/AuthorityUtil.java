package com.metin.com.metin.util;

import com.metin.annotations.CustomAuthority;
import com.metin.example.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.List;

@Component
public class AuthorityUtil {

    @Autowired
    private User user;

    public boolean isAuth(Object obj, String methodName) {

        List<String> authorities = user.getAuthorities();

        boolean isAuthForClass = false;
        boolean isAuthForMethods = false;

        // for class
        Annotation annotationForClass = obj.getClass().getAnnotation(CustomAuthority.class);

        if (annotationForClass != null){

            CustomAuthority customAuthorityForClass = (CustomAuthority) annotationForClass;

            for (String role : customAuthorityForClass.authorities()) {

                for (String userRole : authorities) {

                    if (role.equalsIgnoreCase(userRole)) {
                        isAuthForClass = true;
                    }
                }
            }
        } else {
            isAuthForClass = true;
        }

        // for methods
        for (Method method : obj.getClass().getDeclaredMethods()) {

            if (method.getName().equalsIgnoreCase(methodName)) {

                Annotation annotationForMethod = method.getAnnotation(CustomAuthority.class);

                if (annotationForMethod != null){

                    CustomAuthority customAuthorityForMethods = (CustomAuthority) annotationForMethod;

                    for (String role : customAuthorityForMethods.authorities()) {

                        for (String userRole : authorities) {

                            if (role.equalsIgnoreCase(userRole)) {
                                isAuthForMethods = true;
                            }
                        }
                    }
                } else {
                    isAuthForMethods = true;
                }
            }
        }

        return isAuthForClass && isAuthForMethods;
    }
}
