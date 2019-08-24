package com.vinit.Foodplazabootweb.service;

import java.util.List;

public interface SearchService<T> {

	List<T> searchBy(Class<T> t, String searchStr, String[] fields);

}
