package com.sino.lucene;

import com.sino.constans.LuceneConstans;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.Paths;


/**
 * Created by pierce-deng on 2015/8/17.
 */
public class LuceneUtil {
    private static Directory directory = null;
    private static IndexWriterConfig indexWriterConfig = null;
    private static Analyzer analyzer = null;

    static {
        try {
            directory = FSDirectory.open(Paths.get(LuceneConstans.INDEXURL));
            analyzer = LuceneConstans.ANALYZER;
            indexWriterConfig = new IndexWriterConfig(analyzer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static IndexWriter getIndexWriter() throws IOException {
        IndexWriter indexWriter = new IndexWriter(directory, indexWriterConfig);
        return indexWriter;
    }

    public static IndexSearcher getIndexSearcher() throws IOException {
        IndexReader indexReader = DirectoryReader.open(directory);
        IndexSearcher indexSearcher = new IndexSearcher(indexReader);
        return indexSearcher;

    }

    public static Directory getDirectory() {
        return directory;
    }

    public static void setDirectory(Directory directory) {
        LuceneUtil.directory = directory;
    }

    public static IndexWriterConfig getIndexWriterConfig() {
        return indexWriterConfig;
    }

    public static void setIndexWriterConfig(IndexWriterConfig indexWriterConfig) {
        LuceneUtil.indexWriterConfig = indexWriterConfig;
    }

    public static Analyzer getAnalyzer() {
        return analyzer;
    }

    public static void setAnalyzer(Analyzer analyzer) {
        LuceneUtil.analyzer = analyzer;
    }


}
