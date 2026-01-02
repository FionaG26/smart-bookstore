package com.admin;

import com.bookstore.model.Book;
import com.bookstore.repository.BookRepository;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("admin")
public class BookAdminView extends VerticalLayout {

    private final Grid<Book> grid = new Grid<>(Book.class);

    @Autowired
    public BookAdminView(BookRepository repository){
        grid.setItems(repository.findAll());
        add(grid);

        Button addBtn = new Button("Add Sample Book", e -> {
            repository.save(new Book("Sample Book", "Author", 29.99));
            grid.setItems(repository.findAll());
        });
        add(addBtn);
    }
}

