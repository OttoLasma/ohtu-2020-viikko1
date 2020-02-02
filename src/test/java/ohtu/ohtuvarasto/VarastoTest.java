package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    Varasto varasto3;
    Varasto varasto4;
    Varasto varasto5;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        varasto2 = new Varasto(10,5);
        varasto3 = new Varasto(-2,3);
        varasto4 = new Varasto(-2);
        varasto5 = new Varasto(10,-4);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }

    @Test
    public void ottaminenPalauttaaOikeanMaaran() {
        varasto.lisaaVarastoon(8);

        double saatuMaara = varasto.otaVarastosta(2);

        assertEquals(2, saatuMaara, vertailuTarkkuus);
    }

    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void liikaaTavaraa() {
    	varasto.lisaaVarastoon(12);
    	assertEquals(0, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    	
    }
    @Test
    public void liianVahanTavaraa() {
    	varasto.lisaaVarastoon(5);
    	varasto.otaVarastosta(6);
    	assertEquals(10, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    @Test
    public void toinenKonstruktori() {
    	varasto2.lisaaVarastoon(1);
    	assertEquals(6, varasto2.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void toinenKonstruktoriToinenTesti() {
    	varasto3.lisaaVarastoon(1);
    	
    	assertEquals(0, varasto3.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void KonstruktoriToinenTesti() {
    	varasto4.lisaaVarastoon(1);
    	
    	assertEquals(0, varasto4.getTilavuus(), vertailuTarkkuus);
    }
    @Test
    public void toinenKonstruktoriNegatiivinenAlkusaldo() {
    	varasto5.lisaaVarastoon(5);
    	varasto5.lisaaVarastoon(-2);
    	varasto5.otaVarastosta(-2);
    	String vittuEiSitten = varasto5.toString();
    	assertEquals(5,varasto5.getSaldo(), vertailuTarkkuus);
    }
    
}