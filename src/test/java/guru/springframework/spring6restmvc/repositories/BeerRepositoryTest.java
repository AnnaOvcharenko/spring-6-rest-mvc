package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Anna Ovcharenko
 */

@DataJpaTest
class BeerRepositoryTest {

    @Autowired
    BeerRepository repository;

    @Test
    void testSaveBeer() {

        Beer beer = repository.save(Beer.builder()
                .beerName("New")
                .build());

        assertThat(beer).isNotNull();
        assertThat(beer.getId()).isNotNull();
    }
}