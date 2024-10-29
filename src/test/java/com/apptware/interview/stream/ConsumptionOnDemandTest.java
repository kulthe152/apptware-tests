package com.apptware.interview.stream;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static com.apptware.interview.stream.PaginationService.FULL_DATA_SIZE;

@Slf4j
@SpringBootTest
class ConsumptionOnDemandTest {

  @Autowired private DataReader dataReader;

  @Test
  void testConsumptionOnDemand() {
    int limit = 1000;
    int limit2 = FULL_DATA_SIZE;
    List<String> limitedData = dataReader.fetchLimitadData(limit).toList();
    Assertions.assertThat(limitedData).hasSize(limit);

    List<String> fullData = dataReader.fetchFullData(limit2).toList();
    Assertions.assertThat(fullData).hasSize(FULL_DATA_SIZE);

  }
}
