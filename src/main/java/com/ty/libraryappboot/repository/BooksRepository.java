package com.ty.libraryappboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.libraryappboot.dto.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{

}
