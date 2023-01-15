/*
 * Decompiled with CFR 0.150.
 */
package net.sf.image4j.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CountingInputStream
extends FilterInputStream {
    private int count;

    public CountingInputStream(InputStream src) {
        super(src);
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public int read() throws IOException {
        int b = super.read();
        if (b != -1) {
            ++this.count;
        }
        return b;
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int r = super.read(b, off, len);
        if (r > 0) {
            this.count += r;
        }
        return r;
    }
}
