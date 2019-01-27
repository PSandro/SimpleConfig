package eu.psandro.simpleconfig;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author PSandro on 26.01.19
 * @project yamlcomment
 */
public class StandardTypeConfigTest {

    private StandardTypeConfig standardTypeConfig;

    @Before
    public void setUp() throws Exception {
        standardTypeConfig = new StandardTypeConfig(new File("src/test/resources/standardTypeConfigTest.yml"));
    }

    @Test
    public void testWriteReadBoolean() throws IOException {
        final Class type = Boolean.TYPE;
        final Entry test = new Entry(true, "this-is-a-" + type.getSimpleName());
        test.setComment("This is just a simple " + type.getSimpleName());
        this.standardTypeConfig.set(test);
        this.standardTypeConfig.saveConfig();
        this.standardTypeConfig.loadConfig();
        final Object savedTest = this.standardTypeConfig.getBoolean(test.getKey());
        assertEquals(savedTest, test.getValue());
    }

    @Test
    public void testWriteReadString() throws IOException {
        final Class type = String.class;
        final Entry test = new Entry("Hoghohohoho", "this-is-a-" + type.getSimpleName());
        test.setComment("This is just a simple " + type.getSimpleName());
        this.standardTypeConfig.set(test);
        this.standardTypeConfig.saveConfig();
        this.standardTypeConfig.loadConfig();
        final Object savedTest = this.standardTypeConfig.getString(test.getKey());
        assertEquals(savedTest, test.getValue());
    }

    @Test
    public void testWriteReadInteger() throws IOException {
        final Class type = Integer.class;
        final Entry test = new Entry(1268462165, "this-is-a-" + type.getSimpleName());
        test.setComment("This is just a simple " + type.getSimpleName());
        this.standardTypeConfig.set(test);
        this.standardTypeConfig.saveConfig();
        this.standardTypeConfig.loadConfig();
        final Object savedTest = this.standardTypeConfig.getInteger(test.getKey());
        assertEquals(savedTest, test.getValue());
    }

    @Test
    public void testWriteReadDouble() throws IOException {
        final Class type = Double.class;
        final Entry test = new Entry(12.2, "this-is-a-" + type.getSimpleName());
        test.setComment("This is just a simple " + type.getSimpleName());
        this.standardTypeConfig.set(test);
        this.standardTypeConfig.saveConfig();
        this.standardTypeConfig.loadConfig();
        final Object savedTest = this.standardTypeConfig.getDouble(test.getKey());
        assertEquals(savedTest, test.getValue());
    }

    @Test
    public void testWriteReadIntegerList() throws IOException {
        final Class type = List.class;
        final Entry test = new Entry(Arrays.asList(2, 3, 4, 5, 6), "this-is-a-" + type.getSimpleName());
        test.setComment("This is just a simple " + type.getSimpleName());
        this.standardTypeConfig.set(test);
        this.standardTypeConfig.saveConfig();
        this.standardTypeConfig.loadConfig();
        final Object savedTest = this.standardTypeConfig.getIntegerList(test.getKey());
        assertEquals(savedTest, test.getValue());
    }


}