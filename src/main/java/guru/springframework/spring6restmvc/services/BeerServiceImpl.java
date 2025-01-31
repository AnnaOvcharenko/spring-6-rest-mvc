package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.BeerDTO;
import guru.springframework.spring6restmvc.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author Anna Ovcharenko
 */
@Slf4j
@Service
public class BeerServiceImpl implements BeerService {

    private Map<UUID, BeerDTO> beerMap;

    public BeerServiceImpl() {
        this.beerMap = new HashMap<>();

        BeerDTO beer1 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityOnHand(122)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beer2 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityOnHand(392)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        BeerDTO beer3 = BeerDTO.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityOnHand(144)
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();

        beerMap.put(beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }

    @Override
    public List<BeerDTO> listBeers() {
        log.debug("List Beers - in service.");
        return new ArrayList<>(beerMap.values());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        log.debug("Get Beer by ID - in service. ID: " + id);
        return Optional.of(beerMap.get(id));
    }

    @Override
    public BeerDTO addBeer(BeerDTO beer) {
        BeerDTO savedBeer = BeerDTO.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .beerName(beer.getBeerName())
                .quantityOnHand(beer.getQuantityOnHand())
                .beerStyle(beer.getBeerStyle())
                .price(beer.getPrice())
                .upc(beer.getUpc())
                //.version(beer.getVersion())
                .build();
        beerMap.put(savedBeer.getId(), savedBeer);

        log.debug("Add beer - in service");
        return savedBeer;
    }

    @Override
    public BeerDTO updateBeer(UUID id, BeerDTO beer) {
        BeerDTO updated = beerMap.get(id);
        updated.setBeerName(beer.getBeerName());
        updated.setUpdateDate(LocalDateTime.now());
        updated.setBeerStyle(beer.getBeerStyle());
        updated.setUpc(beer.getUpc());
        updated.setPrice(beer.getPrice());
        updated.setQuantityOnHand(beer.getQuantityOnHand());
       // updated.setVersion(beer.getVersion());
        log.debug("Update beer - in service");
        return updated;
    }

    @Override
    public void deleteBeer(UUID id) {
        log.debug("Delete beer - in service");
        beerMap.remove(id);
    }

    @Override
    public void patchBeer(UUID id, BeerDTO beer) {
        BeerDTO patchedBeer = beerMap.get(id);

        if (StringUtils.hasText(beer.getBeerName())) {
            patchedBeer.setBeerName(beer.getBeerName());
        }

//        if (beer.getVersion() != null) {
//            patchedBeer.setVersion(beer.getVersion());
//        }

        if (beer.getBeerStyle() != null) {
            patchedBeer.setBeerStyle(beer.getBeerStyle());
        }

        if (StringUtils.hasText(beer.getUpc())) {
            patchedBeer.setUpc(beer.getUpc());
        }

        if (beer.getQuantityOnHand() != null) {
            patchedBeer.setQuantityOnHand(beer.getQuantityOnHand());
        }

        if (beer.getPrice() != null) {
            patchedBeer.setPrice(beer.getPrice());
        }

        patchedBeer.setUpdateDate(LocalDateTime.now());
        log.debug("Patch beer - in service");
    }
}
