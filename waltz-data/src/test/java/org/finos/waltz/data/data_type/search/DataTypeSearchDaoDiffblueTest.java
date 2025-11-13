package org.finos.waltz.data.data_type.search;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions;
import org.finos.waltz.model.entity_search.ImmutableEntitySearchOptions.Builder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class DataTypeSearchDaoDiffblueTest {
  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<DataType> actualSearchResult =
        dataTypeSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dataTypeDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch2() {
    // Arrange
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<DataType> actualSearchResult =
        dataTypeSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dataTypeDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch3() {
    // Arrange
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<DataType> actualSearchResult =
        dataTypeSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("Search Query")
                .userId("42")
                .build());

    // Assert
    verify(dataTypeDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch4() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);

    Builder builderResult = ImmutableEntitySearchOptions.builder();

    // Act
    List<DataType> actualSearchResult =
        dataTypeSearchDao.search(
            builderResult
                .addAllEntityLifecycleStatuses(new ArrayList<>())
                .searchQuery("[")
                .userId("42")
                .build());

    // Assert
    verify(dataTypeDao).findAll();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code foo}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       foo}.
   *   <li>Then calls {@link EntitySearchOptions#limit()}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'foo'; when EntitySearchOptions searchQuery() return 'foo'; then calls limit()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenFoo_whenEntitySearchOptionsSearchQueryReturnFoo_thenCallsLimit() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeSearchDao dataTypeSearchDao = new DataTypeSearchDao(dataTypeDao);

    EntitySearchOptions options = mock(EntitySearchOptions.class);
    when(options.limit()).thenReturn(1);
    when(options.searchQuery()).thenReturn("foo");

    // Act
    List<DataType> actualSearchResult = dataTypeSearchDao.search(options);

    // Assert
    verify(dataTypeDao).findAll();
    verify(options).limit();
    verify(options).searchQuery();
    assertTrue(actualSearchResult.isEmpty());
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code [}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); given '['")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenLeftSquareBracket() {
    // Arrange
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

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
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(dataTypeList, actualSearchResult);
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code %s %s %s}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       %s %s %s}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given '%s %s %s'; when EntitySearchOptions searchQuery() return '%s %s %s'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenSSS_whenEntitySearchOptionsSearchQueryReturnSSS() {
    // Arrange
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    dataTypeList.add(
        ImmutableDataType.builder()
            .code("Code")
            .description("The characteristics of someone or something")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());

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
    verify(options).limit();
    verify(options).searchQuery();
    assertEquals(dataTypeList, actualSearchResult);
  }

  /**
   * Test {@link DataTypeSearchDao#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@code Search Query}.
   *   <li>When {@link EntitySearchOptions} {@link EntitySearchOptions#searchQuery()} return {@code
   *       Search Query}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeSearchDao#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given 'Search Query'; when EntitySearchOptions searchQuery() return 'Search Query'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeSearchDao.search(EntitySearchOptions)"})
  void testSearch_givenSearchQuery_whenEntitySearchOptionsSearchQueryReturnSearchQuery() {
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
}
