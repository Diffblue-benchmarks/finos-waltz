package org.finos.waltz.data.data_type.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.junit.jupiter.api.Test;

class DataTypeSearchDaoDiffblueTest {
  /**
   * Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.code()).thenReturn("Code");
    when(dataType.description()).thenReturn("The characteristics of someone or something");
    when(dataType.name()).thenReturn("Name");

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(dataType).code();
    verify(dataType).description();
    verify(dataType).name();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch3() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.code()).thenReturn("Code");
    when(dataType.description()).thenReturn("The characteristics of someone or something");
    when(dataType.name()).thenReturn("Name");
    DataType dataType2 = mock(DataType.class);
    when(dataType2.code()).thenReturn("Code");
    when(dataType2.description()).thenReturn("The characteristics of someone or something");
    when(dataType2.name()).thenReturn("Name");

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("Search Query");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(dataType2).code();
    verify(dataType).code();
    verify(dataType2).description();
    verify(dataType).description();
    verify(dataType2).name();
    verify(dataType).name();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch4() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.code()).thenReturn("Code");
    when(dataType.description()).thenReturn("The characteristics of someone or something");
    when(dataType.name()).thenReturn("Name");
    DataType dataType2 = mock(DataType.class);
    when(dataType2.code()).thenReturn("Code");
    when(dataType2.description()).thenReturn("The characteristics of someone or something");
    when(dataType2.name()).thenReturn("Name");

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("[");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(dataType2).code();
    verify(dataType2).description();
    verify(dataType2).name();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(1, actualSearchResult.size());
  }

  /**
   * Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch5() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.code()).thenReturn("Code");
    when(dataType.description()).thenReturn("The characteristics of someone or something");
    when(dataType.name()).thenReturn("Name");
    DataType dataType2 = mock(DataType.class);
    when(dataType2.code()).thenReturn("Code");
    when(dataType2.description()).thenReturn("The characteristics of someone or something");
    when(dataType2.name()).thenReturn("Name");

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("foo");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(dataType2).code();
    verify(dataType).code();
    verify(dataType2).description();
    verify(dataType).description();
    verify(dataType2).name();
    verify(dataType).name();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  void testSearch6() {
    // Arrange
    DataType dataType = mock(DataType.class);
    when(dataType.code()).thenReturn("Code");
    when(dataType.description()).thenReturn("The characteristics of someone or something");
    when(dataType.name()).thenReturn("Name");
    DataType dataType2 = mock(DataType.class);
    when(dataType2.code()).thenReturn("Code");
    when(dataType2.description()).thenReturn("The characteristics of someone or something");
    when(dataType2.name()).thenReturn("Name");

    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(dataType2);
    dataTypeList.add(dataType);
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);
    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("%s %s %s");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(dataType2).code();
    verify(dataType2).description();
    verify(dataType2).name();
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(1, actualSearchResult.size());
  }
}
