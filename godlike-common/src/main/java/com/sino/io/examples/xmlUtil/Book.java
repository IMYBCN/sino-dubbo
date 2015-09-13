package com.sino.io.examples.xmlUtil;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 * Created by admin on 2015/5/21.
 */
@XStreamAlias("book")
public class Book {
    @XStreamAsAttribute
    @XStreamAlias("price")
    private String price;
    @XStreamAlias("name")
    private String name;
    @XStreamOmitField
    @XStreamAlias("author")
    private String author;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "price='" + price + '\'' +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
