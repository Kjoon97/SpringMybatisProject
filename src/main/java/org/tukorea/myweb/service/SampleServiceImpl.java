package org.tukorea.myweb.service;

import org.springframework.stereotype.Service;

//@Service
public class SampleServiceImpl implements SampleService{

    public Integer doAdd(String s1, String s2) throws Exception {
        return Integer.parseInt(s1)+Integer.parseInt(s2);
    }
}
