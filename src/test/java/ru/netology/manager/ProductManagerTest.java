package ru.netology.productManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductsRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    private ProductsRepository repository = new ProductsRepository();
    private ProductManager productManager = new ProductManager(repository);

    Product first = new Book(1, "Crime And Punishment", 1000, "Dostoevsky");
    Product second = new Book(2, "Dead Souls", 1000, "Gogol");
    Product third = new Smartphone(3, "IPhone", 100000, "Apple");
    Product fourth = new Smartphone(4, "Pixel", 75000, "Google");

    @BeforeEach
    void setUp() {
        productManager.add(first);
        productManager.add(second);
        productManager.add(third);
        productManager.add(fourth);

    }

    @Test
    void searchByBookAuthor() {
        Product[] actual = productManager.searchBy("Dostoevsky");
        Product[] expected = new Product[]{first};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByBookName() {
        Product[] actual = productManager.searchBy("Dead Souls");
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneName() {
        Product[] actual = productManager.searchBy("Apple");
        Product[] expected = new Product[]{third};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchBySmartphoneManufacturer() {
        Product[] actual = productManager.searchBy("Google");
        Product[] expected = new Product[]{fourth};
        assertArrayEquals(expected, actual);
    }


    @Test
    void searchByBookAuthorEmpty() {
        Product[] actual = productManager.searchBy("Pushkin");
        Product[] expected = new Product[]{};
        assertArrayEquals(expected, actual);
    }
}
