import java.util.*;
import java.util.regex.*;
import java.math.*;
import java.text.*;
import java.io.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.JUnitCore;

public class ChatTranscript {
    public static void main (String[] args) {
        JUnitCore.main(ChatTranscript.class.)
    }
    public int howMany(String[] transcript,  String name) {
        name += ":";

        int count = 0;
        for (int i=0;i<transcript.length;i++)
            if(transcript[i].startsWith(name)) count++;

        return count;
    }
}
