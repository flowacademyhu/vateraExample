package hu.flowacademy.vatera.service;

import hu.flowacademy.vatera.model.Bid;
import hu.flowacademy.vatera.repository.BidRepository;
import hu.flowacademy.vatera.repository.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.time.LocalDate;
import java.util.Optional;

@RunWith(SpringRunner.class)
public class BidServiceTest {
    @TestConfiguration
    static class BidServiceConfiguration {

        @Bean
        public BidService bidService() {
            return new BidService();
        }
    }

        @MockBean
        private BidRepository bidRepository;

        @MockBean
        private ProductRepository productRepository;

        @Autowired
        private BidService bidService;

        @Before
        public void setup() {

        }

        @Test
        public void findById() {
            Bid bidShouldBeFound = new Bid(1, 122, "Joska", LocalDate.now(),null);

            Mockito.when(bidRepository.findById(bidShouldBeFound.getId())).thenReturn(Optional.of(bidShouldBeFound));
            Bid found = bidService.getById(1);
            assertThat(found).isEqualTo(bidShouldBeFound);
        }
   }

