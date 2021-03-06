package com.example.restfulclient.helpers;

import java.util.List;

import android.content.Context;

public class SQLiteLibrary implements ILibraryDAO
{
    
    List<Category> cats = null;
    List<Book> books = null;
    
    Context actv = null;
    
    public SQLiteLibrary(Context mainActivity)
    {
	actv = mainActivity;
    }
    
    @Override
    public List<Category> getCategories()
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	
	List<Category> tmp = dh.getAllCats();
	dh.close();
	
	return tmp;
    }
    
    @Override
    public List<Book> getBooks(String catID)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	List<Book> tmp = dh.getBooksByCid(catID);
	dh.close();
	return tmp;
    }
    
    @Override
    public void setActivity(Context la)
    {
	actv = la;
    }
    
    @Override
    public void addCategory(Category category)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	dh.addCategory(category);
	dh.close();
    }
    
    @Override
    public void deleteCategory(Category category)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	dh.delete(category);
	dh.close();
    }
    
    @Override
    public void updateCategory(Category category)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	dh.update(category);
	dh.close();
    }
    
    @Override
    public List<Category> getCatsAndBooks()
    {
	List<Category> cats = getCategories();
	
	for (Category c : cats)
	{
	    c.setBooks(getBooks(c.getCategoryId()));
	}
	
	return cats;
    }
    
    @Override
    public void addBook(Book book)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	dh.addBook(book);
	dh.close();
    }
    
    @Override
    public void updateBook(Book book)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	dh.update(book);
	dh.close();
    }
    
    @Override
    public void deleteBook(Book book)
    {
	DatabaseHelper dh = new DatabaseHelper(actv);
	dh.delete(book);
	dh.close();
    }
}
