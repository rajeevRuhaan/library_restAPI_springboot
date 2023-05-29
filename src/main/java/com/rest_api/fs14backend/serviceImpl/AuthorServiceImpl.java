package com.rest_api.fs14backend.serviceImpl;

import com.rest_api.fs14backend.entity.Author;
import com.rest_api.fs14backend.repository.AuthorRepository;
import com.rest_api.fs14backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void createAuthor(Author author) {
        System.out.println(author);
        String email = author.getEmail();
        String name = author.getName();
        if (authorRepository.existsByEmail(email)) {
            throw new IllegalArgumentException("Email already exists");
        }
        if (authorRepository.existsByName(name)) {
            throw new IllegalArgumentException("Name already exists");
        }
        authorRepository.save(author);

    }

    @Override
    public Author getAuthorById(UUID authorId) {
        Optional<Author> optionalAuthor = authorRepository.findById(authorId);
        return optionalAuthor.get();
    }

    @Override
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Override
    public Author updateAuthor(Author author, UUID authorId) {
        Author existingAuthor = authorRepository.findById(authorId).orElse(null);

        if (existingAuthor != null) {
            existingAuthor.setEmail(author.getEmail());
            existingAuthor.setName(author.getName());
            existingAuthor.setPhone(author.getPhone());
            authorRepository.save(existingAuthor);
            return existingAuthor;
        }
        return null;
    }

    @Override
    public void deleteAuthor(UUID authorId) {
        authorRepository.deleteById(authorId);

    }
}
