package org.finos.waltz.service.data_type;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.data.data_type.DataTypeDao;
import org.finos.waltz.data.data_type.search.DataTypeSearchDao;
import org.finos.waltz.data.logical_flow.LogicalFlowDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.app_group.ImmutableAppGroupEntry;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeMigrationResult;
import org.finos.waltz.model.datatype.ImmutableDataType;
import org.finos.waltz.model.datatype.ImmutableDataTypeMigrationResult;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeServiceDiffblueTest {
  /**
   * Test {@link DataTypeService#migrate(Long, Long, boolean)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableDataTypeMigrationResult}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#migrate(Long, Long, boolean)}
   */
  @Test
  @DisplayName("Test migrate(Long, Long, boolean); then return ImmutableDataTypeMigrationResult")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataTypeMigrationResult DataTypeService.migrate(Long, Long, boolean)"})
  void testMigrate_thenReturnImmutableDataTypeMigrationResult() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.migrate(Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean()))
        .thenReturn(
            ImmutableDataTypeMigrationResult.builder()
                .classificationRuleCount(3L)
                .dataTypeRemoved(true)
                .logicalFlowDataTypeCount(3L)
                .physicalSpecDataTypeCount(3L)
                .usageCount(3L)
                .build());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    DataTypeMigrationResult actualMigrateResult = dataTypeService.migrate(1L, 1L, true);

    // Assert
    verify(dataTypeDao).migrate(1L, 1L, true);
    assertTrue(actualMigrateResult instanceof ImmutableDataTypeMigrationResult);
    assertEquals(3L, actualMigrateResult.classificationRuleCount());
    assertEquals(3L, actualMigrateResult.logicalFlowDataTypeCount());
    assertEquals(3L, actualMigrateResult.physicalSpecDataTypeCount());
    assertEquals(3L, actualMigrateResult.usageCount());
    assertTrue(actualMigrateResult.dataTypeRemoved());
  }

  /**
   * Test {@link DataTypeService#migrate(Long, Long, boolean)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#migrate(Long, Long, boolean)}
   */
  @Test
  @DisplayName("Test migrate(Long, Long, boolean); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataTypeMigrationResult DataTypeService.migrate(Long, Long, boolean)"})
  void testMigrate_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.migrate(Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.migrate(1L, 1L, true));
    verify(dataTypeDao).migrate(1L, 1L, true);
  }

  /**
   * Test {@link DataTypeService#findAll()}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao} {@link DataTypeDao#findAll()} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); given DataTypeDao findAll() return ArrayList(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeService.findAll()"})
  void testFindAll_givenDataTypeDaoFindAllReturnArrayList_thenReturnEmpty() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    List<DataType> actualFindAllResult = dataTypeService.findAll();

    // Assert
    verify(dataTypeDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link DataTypeService#findAll()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findAll()}
   */
  @Test
  @DisplayName("Test findAll(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeService.findAll()"})
  void testFindAll_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.findAll());
    verify(dataTypeDao).findAll();
  }

  /**
   * Test {@link DataTypeService#getDataTypeById(long)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableDataType}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#getDataTypeById(long)}
   */
  @Test
  @DisplayName("Test getDataTypeById(long); then return ImmutableDataType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType DataTypeService.getDataTypeById(long)"})
  void testGetDataTypeById_thenReturnImmutableDataType() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    DataType actualDataTypeById = dataTypeService.getDataTypeById(1L);

    // Assert
    verify(dataTypeDao).getById(1L);
    assertTrue(actualDataTypeById instanceof ImmutableDataType);
    assertEquals("Code", actualDataTypeById.code());
    assertEquals("Name", actualDataTypeById.name());
    assertEquals("The characteristics of someone or something", actualDataTypeById.description());
    assertEquals(EntityKind.ALL, actualDataTypeById.kind());
    assertFalse(actualDataTypeById.deprecated());
    assertFalse(actualDataTypeById.unknown());
    assertTrue(actualDataTypeById.concrete());
  }

  /**
   * Test {@link DataTypeService#getDataTypeById(long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#getDataTypeById(long)}
   */
  @Test
  @DisplayName("Test getDataTypeById(long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType DataTypeService.getDataTypeById(long)"})
  void testGetDataTypeById_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.getDataTypeById(1L));
    verify(dataTypeDao).getById(1L);
  }

  /**
   * Test {@link DataTypeService#getDataTypeByCode(String)}.
   *
   * <ul>
   *   <li>Then return {@link ImmutableDataType}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#getDataTypeByCode(String)}
   */
  @Test
  @DisplayName("Test getDataTypeByCode(String); then return ImmutableDataType")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType DataTypeService.getDataTypeByCode(String)"})
  void testGetDataTypeByCode_thenReturnImmutableDataType() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getByCode(Mockito.<String>any()))
        .thenReturn(
            ImmutableDataType.builder()
                .code("Code")
                .description("The characteristics of someone or something")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentId(1L)
                .build());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    DataType actualDataTypeByCode = dataTypeService.getDataTypeByCode("Code");

    // Assert
    verify(dataTypeDao).getByCode("Code");
    assertTrue(actualDataTypeByCode instanceof ImmutableDataType);
    assertEquals("Code", actualDataTypeByCode.code());
    assertEquals("Name", actualDataTypeByCode.name());
    assertEquals("The characteristics of someone or something", actualDataTypeByCode.description());
    assertEquals(EntityKind.ALL, actualDataTypeByCode.kind());
    assertFalse(actualDataTypeByCode.deprecated());
    assertFalse(actualDataTypeByCode.unknown());
    assertTrue(actualDataTypeByCode.concrete());
  }

  /**
   * Test {@link DataTypeService#getDataTypeByCode(String)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#getDataTypeByCode(String)}
   */
  @Test
  @DisplayName("Test getDataTypeByCode(String); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"DataType DataTypeService.getDataTypeByCode(String)"})
  void testGetDataTypeByCode_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getByCode(Mockito.<String>any()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class, () -> dataTypeService.getDataTypeByCode("Code"));
    verify(dataTypeDao).getByCode("Code");
  }

  /**
   * Test {@link DataTypeService#findByIdSelector(Select)} with {@code selector}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findByIdSelector(Select)}
   */
  @Test
  @DisplayName("Test findByIdSelector(Select) with 'selector'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeService.findByIdSelector(Select)"})
  void testFindByIdSelectorWithSelector_thenReturnEmpty() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    List<EntityReference> actualFindByIdSelectorResult =
        dataTypeService.findByIdSelector(mock(Select.class));

    // Assert
    verify(dataTypeDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualFindByIdSelectorResult.isEmpty());
  }

  /**
   * Test {@link DataTypeService#findByIdSelector(Select)} with {@code selector}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findByIdSelector(Select)}
   */
  @Test
  @DisplayName(
      "Test findByIdSelector(Select) with 'selector'; then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List DataTypeService.findByIdSelector(Select)"})
  void testFindByIdSelectorWithSelector_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () -> dataTypeService.findByIdSelector(mock(Select.class)));
    verify(dataTypeDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Test {@link DataTypeService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeSearchDao} {@link DataTypeSearchDao#search(EntitySearchOptions)}
   *       return {@link ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName(
      "Test search(EntitySearchOptions); given DataTypeSearchDao search(EntitySearchOptions) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DataTypeService.search(EntitySearchOptions)"})
  void testSearch_givenDataTypeSearchDaoSearchReturnArrayList_thenReturnList() {
    // Arrange
    DataTypeSearchDao searchDao = mock(DataTypeSearchDao.class);
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(dataTypeList);
    DataTypeService dataTypeService =
        new DataTypeService(mock(DataTypeDao.class), searchDao, mock(LogicalFlowDao.class));

    // Act
    Collection<DataType> actualSearchResult = dataTypeService.search(null);

    // Assert
    verify(searchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(dataTypeList, actualSearchResult);
  }

  /**
   * Test {@link DataTypeService#search(EntitySearchOptions)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DataTypeService.search(EntitySearchOptions)"})
  void testSearch_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeSearchDao searchDao = mock(DataTypeSearchDao.class);
    when(searchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(mock(DataTypeDao.class), searchDao, mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.search(null));
    verify(searchDao).search(isNull());
  }

  /**
   * Test {@link DataTypeService#getUnknownDataType()}.
   *
   * <p>Method under test: {@link DataTypeService#getUnknownDataType()}
   */
  @Test
  @DisplayName("Test getUnknownDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DataTypeService.getUnknownDataType()"})
  void testGetUnknownDataType() {
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
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    Optional<DataType> actualUnknownDataType = dataTypeService.getUnknownDataType();

    // Assert
    verify(dataTypeDao).findAll();
    assertFalse(actualUnknownDataType.isPresent());
  }

  /**
   * Test {@link DataTypeService#getUnknownDataType()}.
   *
   * <p>Method under test: {@link DataTypeService#getUnknownDataType()}
   */
  @Test
  @DisplayName("Test getUnknownDataType()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DataTypeService.getUnknownDataType()"})
  void testGetUnknownDataType2() {
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
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    Optional<DataType> actualUnknownDataType = dataTypeService.getUnknownDataType();

    // Assert
    verify(dataTypeDao).findAll();
    assertFalse(actualUnknownDataType.isPresent());
  }

  /**
   * Test {@link DataTypeService#getUnknownDataType()}.
   *
   * <ul>
   *   <li>Then return not Present.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#getUnknownDataType()}
   */
  @Test
  @DisplayName("Test getUnknownDataType(); then return not Present")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DataTypeService.getUnknownDataType()"})
  void testGetUnknownDataType_thenReturnNotPresent() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    Optional<DataType> actualUnknownDataType = dataTypeService.getUnknownDataType();

    // Assert
    verify(dataTypeDao).findAll();
    assertFalse(actualUnknownDataType.isPresent());
  }

  /**
   * Test {@link DataTypeService#getUnknownDataType()}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#getUnknownDataType()}
   */
  @Test
  @DisplayName("Test getUnknownDataType(); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional DataTypeService.getUnknownDataType()"})
  void testGetUnknownDataType_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.getUnknownDataType());
    verify(dataTypeDao).findAll();
  }

  /**
   * Test {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findSuggestedByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeService.findSuggestedByEntityRef(EntityReference)"})
  void testFindSuggestedByEntityRef() {
    // Arrange
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeService.findSuggestedByEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build()));
  }

  /**
   * Test {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findSuggestedByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeService.findSuggestedByEntityRef(EntityReference)"})
  void testFindSuggestedByEntityRef2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findSuggestedByEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeService.findSuggestedByEntityRef(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ACTOR)
                    .name("Name")
                    .build()));
    verify(dataTypeDao).findSuggestedByEntityRef(isA(EntityReference.class));
  }

  /**
   * Test {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}.
   *
   * <p>Method under test: {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findSuggestedByEntityRef(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeService.findSuggestedByEntityRef(EntityReference)"})
  void testFindSuggestedByEntityRef3() {
    // Arrange
    DataTypeService dataTypeService =
        new DataTypeService(
            mock(DataTypeDao.class), mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(
        UnsupportedOperationException.class,
        () ->
            dataTypeService.findSuggestedByEntityRef(
                ImmutableAppGroupEntry.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .provenance("Provenance")
                    .build()));
  }

  /**
   * Test {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  @DisplayName("Test findSuggestedByEntityRef(EntityReference); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set DataTypeService.findSuggestedByEntityRef(EntityReference)"})
  void testFindSuggestedByEntityRef_thenReturnEmpty() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findSuggestedByEntityRef(Mockito.<EntityReference>any()))
        .thenReturn(new HashSet<>());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    Set<DataType> actualFindSuggestedByEntityRefResult =
        dataTypeService.findSuggestedByEntityRef(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ACTOR)
                .name("Name")
                .build());

    // Assert
    verify(dataTypeDao).findSuggestedByEntityRef(isA(EntityReference.class));
    assertTrue(actualFindSuggestedByEntityRefResult.isEmpty());
  }

  /**
   * Test {@link DataTypeService#findByParentId(long)}.
   *
   * <ul>
   *   <li>Given {@link DataTypeDao} {@link DataTypeDao#findByParentId(long)} return {@link
   *       ArrayList#ArrayList()}.
   *   <li>Then return {@link List}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findByParentId(long)}
   */
  @Test
  @DisplayName(
      "Test findByParentId(long); given DataTypeDao findByParentId(long) return ArrayList(); then return List")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DataTypeService.findByParentId(long)"})
  void testFindByParentId_givenDataTypeDaoFindByParentIdReturnArrayList_thenReturnList() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    when(dataTypeDao.findByParentId(anyLong())).thenReturn(dataTypeList);
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act
    Collection<DataType> actualFindByParentIdResult = dataTypeService.findByParentId(1L);

    // Assert
    verify(dataTypeDao).findByParentId(1L);
    assertTrue(actualFindByParentIdResult instanceof List);
    assertTrue(actualFindByParentIdResult.isEmpty());
    assertSame(dataTypeList, actualFindByParentIdResult);
  }

  /**
   * Test {@link DataTypeService#findByParentId(long)}.
   *
   * <ul>
   *   <li>Then throw {@link UnsupportedOperationException}.
   * </ul>
   *
   * <p>Method under test: {@link DataTypeService#findByParentId(long)}
   */
  @Test
  @DisplayName("Test findByParentId(long); then throw UnsupportedOperationException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Collection DataTypeService.findByParentId(long)"})
  void testFindByParentId_thenThrowUnsupportedOperationException() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByParentId(anyLong())).thenThrow(new UnsupportedOperationException());
    DataTypeService dataTypeService =
        new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.findByParentId(1L));
    verify(dataTypeDao).findByParentId(1L);
  }
}
