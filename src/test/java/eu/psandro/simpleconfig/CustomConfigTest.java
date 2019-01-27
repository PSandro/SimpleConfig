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
public class CustomConfigTest {

    private CustomConfig customConfig;

    @Before
    public void setUp() throws Exception {
        customConfig = new CustomConfig(new File("src/test/resources/customConfigTest.yml"));
        final Entry<Boolean> entry = new Entry(true, "i-am-hot");
        entry.setComment("What is the sense of life?");
        customConfig.set(entry);
        customConfig.saveConfig();
    }

    @Test
    public void testWriteLoadString() throws IOException {
        final Entry test = new Entry("test", "this-is-a-test");
        this.customConfig.set(test);
        this.customConfig.saveConfig();
        this.customConfig.loadConfig();
        final String savedTest = this.customConfig.get(test.getKey(), String.class);
        assertEquals(savedTest, test.getValue());
    }

    @Test
    public void testCompareSize() throws IOException {
        int actualSize = this.customConfig.getEntries().size();
        this.customConfig.saveConfig();
        this.customConfig.clear();
        this.customConfig.loadConfig();
        int size = this.customConfig.getEntries().size();
        assertEquals(actualSize, size);
        System.out.println(size);
    }

    @Test
    public void testMultipleEntries() throws IOException {
        this.customConfig.clear();
        for (int i = 0; i < 5; i++) {
            Entry entry = new Entry("hi" + i, "test-" + i);
            entry.setComment("THIS IS " + i);
            this.customConfig.set(entry);
        }

        int actualSize = this.customConfig.getEntries().size();
        this.customConfig.saveConfig();
        this.customConfig.clear();
        this.customConfig.loadConfig();
        int size = this.customConfig.getEntries().size();
        assertEquals(actualSize, size);
    }

    @Test
    public void testList() throws IOException {
        this.customConfig.clear();
        List<String> strings = Arrays.asList("This", "is", "just", "a", "test");

        final Entry entry = new Entry(strings, "strings");
        entry.setComment("A few Strings");
        this.customConfig.set(entry);
        this.customConfig.saveConfig();
        this.customConfig.clear();
        this.customConfig.loadConfig();
        final List<String> savedStrings = this.customConfig.get("strings", List.class);
        assertEquals(savedStrings, strings);
    }

    @Test
    public void testEntryExists() throws IOException {
        final boolean iAmHot = this.customConfig.get("i-am-hot", Boolean.class);
        assertTrue(iAmHot);
    }

}