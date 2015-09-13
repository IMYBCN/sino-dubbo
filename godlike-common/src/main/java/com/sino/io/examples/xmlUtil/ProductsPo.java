package com.sino.io.examples.xmlUtil;

import com.sino.io.XmlUtil;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import java.util.List;

/**
 *
 */
@XStreamAlias("products")
public class ProductsPo {
    /*
    @XStreamAlias("message") 元素名注解
    作用目标: 类,字段
    @XStreamImplicit(itemFieldName="part")集合注解
    作用目标: 集合字段
    @XStreamAsAttribute 属性注解
    作用目标: 字段
    @XStreamOmitField 忽略元素
    作用目标: 字段
    */
    @XStreamAlias("salesman")
    private String salesman;
    @XStreamImplicit(itemFieldName = "book")
    private List<Book> books;

    public String getSalesman() {
        return salesman;
    }

    public void setSalesman(String salesman) {
        this.salesman = salesman;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "ProductsPo{" +
                "salesman='" + salesman + '\'' +
                ", books=" + books +
                '}';
    }

    public static void main(String[] args) {
        ProductsPo productsPo = (ProductsPo) XmlUtil.getObject("./products.xml", new ProductsPo());
        System.out.println(productsPo);
    }
}
