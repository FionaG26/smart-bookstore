package com.ms;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Path("/ms/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {

    private static final List<Book> books = new ArrayList<>();
    private static final AtomicLong counter = new AtomicLong();

    @GET
    public List<Book> getAll() {
        return books;
    }

    @POST
    public Book addBook(Book book){
        book.setId(counter.incrementAndGet());
        books.add(book);
        return book;
    }

    @DELETE
    @Path("/{id}")
    public void deleteBook(@PathParam("id") Long id){
        books.removeIf(book -> book.getId().equals(id));
    }
}

