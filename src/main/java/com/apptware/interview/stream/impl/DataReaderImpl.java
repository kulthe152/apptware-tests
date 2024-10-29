package com.apptware.interview.stream.impl;

import com.apptware.interview.stream.DataReader;
import com.apptware.interview.stream.PaginationService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.apptware.interview.stream.PaginationService.FULL_DATA_SIZE;


@Slf4j
@Service
class DataReaderImpl implements DataReader {

  @Autowired private PaginationService paginationService;

  @Override
  public Stream<String> fetchLimitadData(int limit) {
    return fetchPaginatedDataAsStream(limit);
  }

  @Override
  public Stream<String> fetchFullData(int limit) {
    return fetchPaginatedDataAsStream(limit);
  }

  /**
   * This method is where the candidate should add the implementation. Logs have been added to track
   * the data fetching behavior. Do not modify any other areas of the code.
   */


  private @NonNull Stream<String> fetchPaginatedDataAsStream(int size) {
    log.info("Fetching paginated data as stream.");
    // Placeholder for paginated data fetching logic
    // The candidate will add the actual implementation here
    List<String> stringList = IntStream.range(0, size)
            .mapToObj(i -> "Demo_String_" + i)
            .collect(Collectors.toList());

    Stream<String> dataStream = stringList.stream();
    return dataStream.peek(item -> log.info("Fetched Item: {}", item));
  }
}
