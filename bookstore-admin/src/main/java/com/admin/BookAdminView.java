package com.admin;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Route("admin")
public class BookAdminView extends VerticalLayout {

    private final Grid<BookDto> grid = new Grid<>(BookDto.class);
    private final RestTemplate restTemplate = new RestTemplate();
    private final String backendUrl = "http://localhost:8080/api/books";

    public BookAdminView() {
        setSizeFull();
        fetchBooks();

        Button refreshBtn = new Button("Refresh", e -> fetchBooks());
        add(grid, refreshBtn);
    }

    private void fetchBooks() {
        BookDto[] books = restTemplate.getForObject(backendUrl, BookDto[].class);
        if (books != null) {
            List<BookDto> bookList = Arrays.asList(books);
            grid.setItems(bookList);
        }
    }
}

