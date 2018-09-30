package com.metin.example;

import com.metin.com.metin.util.AuthorityUtil;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseService {

    @Autowired
    protected AuthorityUtil authorityUtil;
}
