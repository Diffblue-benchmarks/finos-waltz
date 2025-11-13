package org.finos.waltz.service.logical_data_element;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.data.logical_data_element.LogicalDataElementDao;
import org.finos.waltz.data.logical_data_element.search.LogicalDataElementSearchDao;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.FieldDataType;
import org.finos.waltz.model.entity_search.EntitySearchOptions;
import org.finos.waltz.model.logical_data_element.ImmutableLogicalDataElement;
import org.finos.waltz.model.logical_data_element.LogicalDataElement;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LogicalDataElementServiceDiffblueTest {
  /**
   * Test {@link LogicalDataElementService#getById(long)}.
   *
   * <p>Method under test: {@link LogicalDataElementService#getById(long)}
   */
  @Test
  @DisplayName("Test getById(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalDataElement LogicalDataElementService.getById(long)"})
  void testGetById() {
    // Arrange
    LogicalDataElementDao logicalDataElementDao = mock(LogicalDataElementDao.class);
    when(logicalDataElementDao.getById(anyLong()))
        .thenReturn(
            ImmutableLogicalDataElement.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentDataTypeId(1L)
                .provenance("Provenance")
                .type(FieldDataType.DATE)
                .build());
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            logicalDataElementDao, mock(LogicalDataElementSearchDao.class));

    // Act
    LogicalDataElement actualById = logicalDataElementService.getById(1L);

    // Assert
    verify(logicalDataElementDao).getById(1L);
    assertTrue(actualById instanceof ImmutableLogicalDataElement);
    assertEquals("Name", actualById.name());
    assertEquals("Provenance", actualById.provenance());
    assertEquals("The characteristics of someone or something", actualById.description());
    assertEquals(1L, actualById.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualById.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualById.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualById.type());
  }

  /**
   * Test {@link LogicalDataElementService#getByExternalId(String)}.
   *
   * <p>Method under test: {@link LogicalDataElementService#getByExternalId(String)}
   */
  @Test
  @DisplayName("Test getByExternalId(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"LogicalDataElement LogicalDataElementService.getByExternalId(String)"})
  void testGetByExternalId() {
    // Arrange
    LogicalDataElementDao logicalDataElementDao = mock(LogicalDataElementDao.class);
    when(logicalDataElementDao.getByExternalId(Mockito.<String>any()))
        .thenReturn(
            ImmutableLogicalDataElement.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .parentDataTypeId(1L)
                .provenance("Provenance")
                .type(FieldDataType.DATE)
                .build());
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            logicalDataElementDao, mock(LogicalDataElementSearchDao.class));

    // Act
    LogicalDataElement actualByExternalId = logicalDataElementService.getByExternalId("42");

    // Assert
    verify(logicalDataElementDao).getByExternalId("42");
    assertTrue(actualByExternalId instanceof ImmutableLogicalDataElement);
    assertEquals("Name", actualByExternalId.name());
    assertEquals("Provenance", actualByExternalId.provenance());
    assertEquals("The characteristics of someone or something", actualByExternalId.description());
    assertEquals(1L, actualByExternalId.parentDataTypeId());
    assertEquals(EntityKind.ALL, actualByExternalId.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualByExternalId.entityLifecycleStatus());
    assertEquals(FieldDataType.DATE, actualByExternalId.type());
  }

  /**
   * Test {@link LogicalDataElementService#findAll()}.
   *
   * <p>Method under test: {@link LogicalDataElementService#findAll()}
   */
  @Test
  @DisplayName("Test findAll()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementService.findAll()"})
  void testFindAll() {
    // Arrange
    LogicalDataElementDao logicalDataElementDao = mock(LogicalDataElementDao.class);
    when(logicalDataElementDao.findAll()).thenReturn(new ArrayList<>());
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            logicalDataElementDao, mock(LogicalDataElementSearchDao.class));

    // Act
    List<LogicalDataElement> actualFindAllResult = logicalDataElementService.findAll();

    // Assert
    verify(logicalDataElementDao).findAll();
    assertTrue(actualFindAllResult.isEmpty());
  }

  /**
   * Test {@link LogicalDataElementService#search(EntitySearchOptions)}.
   *
   * <p>Method under test: {@link LogicalDataElementService#search(EntitySearchOptions)}
   */
  @Test
  @DisplayName("Test search(EntitySearchOptions)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List LogicalDataElementService.search(EntitySearchOptions)"})
  void testSearch() {
    // Arrange
    LogicalDataElementSearchDao logicalDataElementSearchDao =
        mock(LogicalDataElementSearchDao.class);
    when(logicalDataElementSearchDao.search(Mockito.<EntitySearchOptions>any()))
        .thenReturn(new ArrayList<>());
    LogicalDataElementService logicalDataElementService =
        new LogicalDataElementService(
            mock(LogicalDataElementDao.class), logicalDataElementSearchDao);

    // Act
    List<LogicalDataElement> actualSearchResult = logicalDataElementService.search(null);

    // Assert
    verify(logicalDataElementSearchDao).search(isNull());
    assertTrue(actualSearchResult.isEmpty());
  }
}
