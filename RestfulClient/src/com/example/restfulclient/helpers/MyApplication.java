package com.example.restfulclient.helpers;

import java.util.ArrayList;
import java.util.List;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class MyApplication extends Application
{
	public List<Category> categories;
	public List<Book> books;

	public Category c;
	public Book b;

	//public String addr = "192.168.1.1"; // telefon
	public String addr = "10.0.2.2"; // emulator

	public boolean offline = false;

	public MyApplication()
	{
		categories = new ArrayList<Category>();
		books = new ArrayList<Book>();
	}

	public int getById(String id)
	{
		for (int i = 0; i < categories.size(); i++)
		{
			if (categories.get(i).getCategoryId().equals(id))
				return i;
		}

		return -1;
	}

	public boolean isOffline()
	{
		ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo netInfo = cm.getActiveNetworkInfo();
		if (netInfo != null && netInfo.isConnectedOrConnecting())
			offline = false;
		else
			offline = true;
		return offline;
	}

	public String genericPhoto = "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";
}
