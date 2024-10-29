package com.apptware.interview.stream;

import java.util.stream.Stream;

public interface DataReader {

  Stream<String> fetchLimitadData(int limit);

  Stream<String> fetchFullData(int limit);
}
