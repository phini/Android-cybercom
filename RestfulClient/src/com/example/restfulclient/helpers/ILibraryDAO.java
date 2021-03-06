package com.example.restfulclient.helpers;

import java.util.List;

import android.content.Context;

public interface ILibraryDAO
{

	public List<Category> getCategories();

	public List<Book> getBooks(String categoryId);
	
	public void addBook(Book b);
	
	public void deleteBook(Book b);
	
	public void updateBook(Book b);
	
	public void setActivity(Context la);

	public void addCategory(Category category);

	public void deleteCategory(Category category);

	public void updateCategory(Category category);

	public List<Category> getCatsAndBooks();
}
