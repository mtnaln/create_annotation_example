package com.metin.example;

import com.metin.annotations.CustomAuthority;
import org.springframework.stereotype.Service;

@Service
public class PersonelService extends BaseService {

    @CustomAuthority(authorities = {"ADD_PERSONEL"})
    public void addPersonel() {

        if (authorityUtil.isAuth(this, Thread.currentThread().getStackTrace()[1].getMethodName())) {
            System.out.println("Personel added successfully...");
        } else {
            System.out.println("You have NOT authoritiy for adding personel...");
        }
    }

    @CustomAuthority(authorities = {"DELETE_PERSONEL"})
    public void deletePersonel() {

        if (authorityUtil.isAuth(this, Thread.currentThread().getStackTrace()[1].getMethodName())) {
            System.out.println("Personel deleted successfully...");
        } else {
            System.out.println("You have NOT authoritiy for deleting personel...");
        }
    }

}
