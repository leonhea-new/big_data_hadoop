package tryself.ha.fs;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;


public class URLCat {
    static {
        URL.setURLStreamHandlerFactory( new FsUrlStreamHandlerFactory());
    }

    public static void main(String[] args) throws Exception {
        args = new String[]{"hdfs://localhost:9000/tmp/README.txt"};

        InputStream in = null;
        try {
            in= new URL(args[0]).openStream();
            IOUtils.copyBytes(in, System.out, 4096, false);
        } finally {
            IOUtils.closeStream(in);
        }
    }
}
