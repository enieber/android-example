package com.example.programacaoapp.veicle_revend;

import com.example.programacaoapp.veicle_revend.service.MainService;
import com.example.programacaoapp.veicle_revend.service.MyPrinter;
import com.example.programacaoapp.veicle_revend.service.RestService;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainServiceTest {
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    RestService restService;

    @Mock
    MyPrinter myPrinter;

    @InjectMocks
    MainService mainService;

    @Test
    public void testDoSomething() {
        when(restService.getSomething()).thenReturn("abc");

        mainService.doSomething();

        verify(myPrinter).print("ABC");
    }

}
