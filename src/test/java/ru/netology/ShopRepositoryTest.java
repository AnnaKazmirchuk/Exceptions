package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository();

    Product product1 = new Product(5, "Bread", 80);
    Product product2 = new Product(7, "Butter", 200);
    Product product3 = new Product(98, "Caviar", 1000);

    @Test
    public void shouldDeleteProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);
        repo.removeById(7);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTrowException() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();

        Assertions.assertThrows(NotFoundException.class, () -> {
            repo.removeById(9);
        });
    }



}