package com.file;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOperation {
    private static final int CHUNK_SIZE = 100;
    public void printLastLines(String fileName, int noOfLines) throws IOException {
        int lineCount = 0;
        long readChunkSize = 0;
        byte[] buffer = new byte[CHUNK_SIZE];
        StringBuilder sb = new StringBuilder();
        try(RandomAccessFile file = new RandomAccessFile(fileName, "r")){
            long cursor = file.length();
            while(lineCount<noOfLines && cursor>0){
                readChunkSize = Math.min(CHUNK_SIZE, cursor);
                cursor = Math.max(0, cursor-CHUNK_SIZE);
                file.seek(cursor);
                file.read(buffer,0,(int)readChunkSize);
                for(int i=(int)readChunkSize-1;i>=0;i--) {
                    sb.append((char) buffer[i]);
                    if((char) buffer[i]=='\n'){
                        lineCount++;
                        if(lineCount==noOfLines){
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb.reverse());
    }
}
