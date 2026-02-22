package com.composite;

import org.junit.Test;
import static org.junit.Assert.*;

public class CompositeTest {
    
    @Test
    public void testFileSize() {
        var file = new File("document.txt", 1024);
        assertEquals(1024, file.getSize());
    }
    
    @Test
    public void testFileName() {
        var file = new File("image.jpg", 2048);
        assertEquals("image.jpg", file.getName());
    }
    
    @Test
    public void testDirectoryWithFiles() {
        var directory = new Directory("Documents");
        directory.add(new File("file1.txt", 100));
        directory.add(new File("file2.txt", 200));
        
        assertEquals(300, directory.getSize());
    }
    
    @Test
    public void testNestedDirectories() {
        var root = new Directory("root");
        var subdir = new Directory("subdir");
        
        subdir.add(new File("file.txt", 500));
        root.add(subdir);
        
        assertEquals(500, root.getSize());
    }
    
    @Test
    public void testComplexStructure() {
        var root = new Directory("root");
        var docs = new Directory("Documents");
        var work = new Directory("Work");
        
        docs.add(new File("report.pdf", 2000));
        work.add(new File("project.txt", 1000));
        docs.add(work);
        root.add(docs);
        root.add(new File("readme.txt", 500));
        
        assertEquals(3500, root.getSize());
    }
    
    @Test
    public void testRemoveComponent() {
        var directory = new Directory("temp");
        var file = new File("file.txt", 100);
        
        directory.add(file);
        assertEquals(100, directory.getSize());
        
        directory.remove(file);
        assertEquals(0, directory.getSize());
    }
}
