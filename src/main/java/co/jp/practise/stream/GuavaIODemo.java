package co.jp.practise.stream;

import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

public class GuavaIODemo {
    public static void main(String[] args) throws IOException {
        CharSource charSource = Files.asCharSource(new File("/Users/wen/Downloads/Source.json"), Charsets.UTF_8);
        CharSink charSink = Files.asCharSink(new File("/Users/wen/Downloads/Sink.json"), Charsets.UTF_8);
        charSource.copyTo(charSink);
    }
}
