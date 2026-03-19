package com.file;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FileOperation fo = new FileOperation();
        fo.printLastLines("logfile.txt", 3);
    }
}
