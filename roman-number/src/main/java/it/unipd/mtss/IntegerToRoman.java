////////////////////////////////////////////////////////////////////
//  Gabriele Isacco Magnelli 2075542
//  Teodora Mihajlovic 2068221
////////////////////////////////////////////////////////////////////
package it.unipd.mtss;

/**
 * Hello world!
 *
 */
public class IntegerToRoman
{
    public static String convert(int number) throws ZeroException,NegativeNumberException,BiggerThan4000Exception
    {
        if(number==0) {throw new ZeroException(); }
        if(number<0) {throw new NegativeNumberException();}
        if(number>3999) {throw new BiggerThan4000Exception();}

        String[] thousands = {"", "M","MM","MMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] units = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return (thousands[number / 1000] + hundreds[(number % 1000) / 100] + tens[(number % 100) / 10] + units[number % 10]);
    }
}
