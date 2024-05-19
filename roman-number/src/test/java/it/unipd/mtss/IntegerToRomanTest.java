package it.unipd.mtss;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
//
public class IntegerToRomanTest
{
    static IntegerToRoman converter;

    @BeforeClass
    public static void startConverter() {
        converter = new IntegerToRoman();
    }

    // test sulle lettere

    @Test
    public void NumberToLetter3() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String[] romans= {"I", "II", "III"};
        for(int i=1;i<=3;i++){
            assertEquals(converter.convert(i), romans[i-1]);
        }
    }

    @Test
    public void NumberToLetter6() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="VI";
        assertEquals(converter.convert(6),roman);
    }

    @Test
    public void NumberToLetter10() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        assertEquals("X",converter.convert(10));
    }

    @Test
    public void NumberToLetter20() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="XX";
        assertEquals(converter.convert(20),roman);
    }

    @Test
    public void NumberToLetter50() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="L";
        assertEquals(converter.convert(50),roman);
    }

    @Test
    public void NumberToLetter100() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="C";
        assertEquals(converter.convert(100),roman);
    }

    @Test
    public void NumberToLetter500() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="D";
        assertEquals(converter.convert(500),roman);
    }

    @Test
    public void NumberToLetter1000() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="M";
        assertEquals(converter.convert(1000),roman);
    }

    //test casi particolari

    @Test
    public void CasoParticolare4() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="IV";
        assertEquals(converter.convert(4),roman);
    }
    @Test
    public void CasoParticolare9() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        String roman="IX";
        assertEquals(converter.convert(9),roman);
    }
    @Test
    public void CasoParticolare40() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        assertEquals(converter.convert(40),"XL");
    }
    @Test
    public void CasoParticolare900() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        assertEquals(converter.convert(900),"CM");
    }

    //Caso_Max

    @Test
    public void CasoMax3999() throws ZeroException,NegativeNumberException,BiggerThan4000Exception{
        assertEquals(converter.convert(3999),"MMMCMXCIX");
    }
    //Testing exception
    @Test(expected = ZeroException.class)
    public void convertZero() throws ZeroException, BiggerThan4000Exception, NegativeNumberException{
        int zero=0;

        converter.convert(zero);
    }

    @Test(expected = NegativeNumberException.class)
    public void convertNegative() throws ZeroException, BiggerThan4000Exception, NegativeNumberException{
        int negative=-1;

        converter.convert(negative);
    }

    @Test(expected = BiggerThan4000Exception.class)
    public void convertGreaterThan3999() throws ZeroException, BiggerThan4000Exception, NegativeNumberException{

        converter.convert(4000);
    }

}