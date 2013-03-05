import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
public class JustifyText {
    public String[] format(String[] text) {
        int len = 0;
        for(String w : text) {
            if (w.length() > len)
                len = w.length();
        }
        for (int i=0; i < text.length; i++) {
            //text[i] = space*(int)(len - text[i].length) + text[i];
            while(text[i].length() <= len)
                text[i] = " " + text[i];
        }
        return text;
    }
}
