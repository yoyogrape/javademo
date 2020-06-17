package com.songjn.designmode.工厂模式;

public class 工厂方法模式 {
    public void test() {
        ReaderFactory factory = new JpgReaderFactory();
        Reader reader = factory.getReader();
        reader.read();
    }
}

interface ReaderFactory {
    Reader getReader();
}

class JpgReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new JpgReader();
    }
}

class PngReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new PngReader();
    }
}

class GifReaderFactory implements ReaderFactory {
    @Override
    public Reader getReader() {
        return new GifReader();
    }
}

interface Reader {
    void read();
}

class JpgReader implements Reader {
    @Override
    public void read() {
        System.out.print("read jpg");
    }
}

class PngReader implements Reader {
    @Override
    public void read() {
        System.out.print("read png");
    }
}

class GifReader implements Reader {
    @Override
    public void read() {
        System.out.print("read gif");
    }
}

