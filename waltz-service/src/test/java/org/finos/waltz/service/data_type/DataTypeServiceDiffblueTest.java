package org.finos.waltz.service.data_type;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.datatype.DataType;
import org.finos.waltz.model.datatype.DataTypeMigrationResult;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.jooq.Record1;
import org.jooq.Select;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class DataTypeServiceDiffblueTest {
  /**
   * Method under test: {@link DataTypeService#migrate(Long, Long, boolean)}
   */
  @Test
  void testMigrate() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.migrate(Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean()))
        .thenReturn(mock(DataTypeMigrationResult.class));

    // Act
    (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))).migrate(1L, 1L, true);

    // Assert
    verify(dataTypeDao).migrate(eq(1L), eq(1L), eq(true));
  }

  /**
   * Method under test: {@link DataTypeService#migrate(Long, Long, boolean)}
   */
  @Test
  void testMigrate2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.migrate(Mockito.<Long>any(), Mockito.<Long>any(), anyBoolean()))
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))).migrate(1L,
            1L, true));
    verify(dataTypeDao).migrate(eq(1L), eq(1L), eq(true));
  }

  /**
   * Method under test: {@link DataTypeService#findAll()}
   */
  @Test
  void testFindAll() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    when(dataTypeDao.findAll()).thenReturn(dataTypeList);

    // Act
    List<DataType> actualFindAllResult = (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class))).findAll();

    // Assert
    verify(dataTypeDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
    assertSame(dataTypeList, actualFindAllResult);
  }

  /**
   * Method under test: {@link DataTypeService#findAll()}
   */
  @Test
  void testFindAll2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))).findAll());
    verify(dataTypeDao).findAll();
  }

  /**
   * Method under test: {@link DataTypeService#getDataTypeById(long)}
   */
  @Test
  void testGetDataTypeById() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenReturn(null);

    // Act
    DataType actualDataTypeById = (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class))).getDataTypeById(1L);

    // Assert
    verify(dataTypeDao).getById(eq(1L));
    assertNull(actualDataTypeById);
  }

  /**
   * Method under test: {@link DataTypeService#getDataTypeById(long)}
   */
  @Test
  void testGetDataTypeById2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getById(anyLong())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)))
            .getDataTypeById(1L));
    verify(dataTypeDao).getById(eq(1L));
  }

  /**
   * Method under test: {@link DataTypeService#getDataTypeByCode(String)}
   */
  @Test
  void testGetDataTypeByCode() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getByCode(Mockito.<String>any())).thenReturn(null);

    // Act
    DataType actualDataTypeByCode = (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class))).getDataTypeByCode("Code");

    // Assert
    verify(dataTypeDao).getByCode(eq("Code"));
    assertNull(actualDataTypeByCode);
  }

  /**
   * Method under test: {@link DataTypeService#getDataTypeByCode(String)}
   */
  @Test
  void testGetDataTypeByCode2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.getByCode(Mockito.<String>any())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)))
            .getDataTypeByCode("Code"));
    verify(dataTypeDao).getByCode(eq("Code"));
  }

  /**
   * Method under test: {@link DataTypeService#findByIdSelector(Select)}
   */
  @Test
  void testFindByIdSelector() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    ArrayList<EntityReference> entityReferenceList = new ArrayList<>();
    when(dataTypeDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenReturn(entityReferenceList);

    // Act
    List<EntityReference> actualFindByIdSelectorResult = (new DataTypeService(dataTypeDao,
        mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class))).findByIdSelector(mock(Select.class));

    // Assert
    verify(dataTypeDao).findByIdSelectorAsEntityReference(isA(Select.class));
    assertTrue(actualFindByIdSelectorResult.isEmpty());
    assertSame(entityReferenceList, actualFindByIdSelectorResult);
  }

  /**
   * Method under test: {@link DataTypeService#findByIdSelector(Select)}
   */
  @Test
  void testFindByIdSelector2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByIdSelectorAsEntityReference(Mockito.<Select<Record1<Long>>>any()))
        .thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)))
            .findByIdSelector(mock(Select.class)));
    verify(dataTypeDao).findByIdSelectorAsEntityReference(isA(Select.class));
  }

  /**
   * Method under test: {@link DataTypeService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch() {
    // Arrange
    DataTypeSearchDao searchDao = mock(DataTypeSearchDao.class);
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenReturn(dataTypeList);

    // Act
    Collection<DataType> actualSearchResult = (new DataTypeService(mock(DataTypeDao.class), searchDao,
        mock(LogicalFlowDao.class))).search(null);

    // Assert
    verify(searchDao).search(isNull());
    assertTrue(actualSearchResult instanceof List);
    assertTrue(actualSearchResult.isEmpty());
    assertSame(dataTypeList, actualSearchResult);
  }

  /**
   * Method under test: {@link DataTypeService#search(EntitySearchOptions)}
   */
  @Test
  void testSearch2() {
    // Arrange
    DataTypeSearchDao searchDao = mock(DataTypeSearchDao.class);
    when(searchDao.search(Mockito.<EntitySearchOptions>any())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(mock(DataTypeDao.class), searchDao, mock(LogicalFlowDao.class))).search(null));
    verify(searchDao).search(isNull());
  }

  /**
   * Method under test: {@link DataTypeService#getUnknownDataType()}
   */
  @Test
  void testGetUnknownDataType() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenReturn(new ArrayList<>());

    // Act
    Optional<DataType> actualUnknownDataType = (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class))).getUnknownDataType();

    // Assert
    verify(dataTypeDao).findAll();
    assertFalse(actualUnknownDataType.isPresent());
  }

  /**
   * Method under test: {@link DataTypeService#getUnknownDataType()}
   */
  @Test
  void testGetUnknownDataType2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findAll()).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)))
            .getUnknownDataType());
    verify(dataTypeDao).findAll();
  }

  /**
   * Method under test:
   * {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  void testFindSuggestedByEntityRef() {
    // Arrange
    DataTypeService dataTypeService = new DataTypeService(mock(DataTypeDao.class), mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ALL);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.findSuggestedByEntityRef(entityReference));
    verify(entityReference, atLeast(1)).kind();
  }

  /**
   * Method under test:
   * {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  void testFindSuggestedByEntityRef2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    HashSet<DataType> dataTypeSet = new HashSet<>();
    when(dataTypeDao.findSuggestedByEntityRef(Mockito.<EntityReference>any())).thenReturn(dataTypeSet);
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    // Act
    Set<DataType> actualFindSuggestedByEntityRefResult = dataTypeService.findSuggestedByEntityRef(entityReference);

    // Assert
    verify(dataTypeDao).findSuggestedByEntityRef(isA(EntityReference.class));
    verify(entityReference).kind();
    assertTrue(actualFindSuggestedByEntityRefResult.isEmpty());
    assertSame(dataTypeSet, actualFindSuggestedByEntityRefResult);
  }

  /**
   * Method under test:
   * {@link DataTypeService#findSuggestedByEntityRef(EntityReference)}
   */
  @Test
  void testFindSuggestedByEntityRef3() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findSuggestedByEntityRef(Mockito.<EntityReference>any()))
        .thenThrow(new UnsupportedOperationException("foo"));
    DataTypeService dataTypeService = new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class));
    EntityReference entityReference = mock(EntityReference.class);
    when(entityReference.kind()).thenReturn(EntityKind.ACTOR);

    // Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> dataTypeService.findSuggestedByEntityRef(entityReference));
    verify(dataTypeDao).findSuggestedByEntityRef(isA(EntityReference.class));
    verify(entityReference).kind();
  }

  /**
   * Method under test: {@link DataTypeService#findByParentId(long)}
   */
  @Test
  void testFindByParentId() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    ArrayList<DataType> dataTypeList = new ArrayList<>();
    when(dataTypeDao.findByParentId(anyLong())).thenReturn(dataTypeList);

    // Act
    Collection<DataType> actualFindByParentIdResult = (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class),
        mock(LogicalFlowDao.class))).findByParentId(1L);

    // Assert
    verify(dataTypeDao).findByParentId(eq(1L));
    assertTrue(actualFindByParentIdResult instanceof List);
    assertTrue(actualFindByParentIdResult.isEmpty());
    assertSame(dataTypeList, actualFindByParentIdResult);
  }

  /**
   * Method under test: {@link DataTypeService#findByParentId(long)}
   */
  @Test
  void testFindByParentId2() {
    // Arrange
    DataTypeDao dataTypeDao = mock(DataTypeDao.class);
    when(dataTypeDao.findByParentId(anyLong())).thenThrow(new UnsupportedOperationException("foo"));

    // Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new DataTypeService(dataTypeDao, mock(DataTypeSearchDao.class), mock(LogicalFlowDao.class)))
            .findByParentId(1L));
    verify(dataTypeDao).findByParentId(eq(1L));
  }
}
