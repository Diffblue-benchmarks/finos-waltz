package org.finos.waltz.model.report_grid;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.junit.jupiter.api.Test;

class ImmutableReportGridFixedColumnDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#builder()}
   *   <li>
   * {@link ImmutableReportGridFixedColumnDefinition#columnDescription(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnEntityId(Long)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnName(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnQualifierId(Long)}
   *   <li>
   * {@link ImmutableReportGridFixedColumnDefinition#columnQualifierKind(EntityKind)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#displayName(String)}
   *   <li>
   * {@link ImmutableReportGridFixedColumnDefinition#entityFieldReference(EntityFieldReference)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#externalId(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#gridColumnId(Long)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#id(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridFixedColumnDefinition.Builder actualExternalIdResult = ImmutableReportGridFixedColumnDefinition
        .builder()
        .columnDescription("Column Description")
        .columnEntityId(1L)
        .columnName("Column Name")
        .columnQualifierId(1L)
        .columnQualifierKind(EntityKind.ALL)
        .displayName("Display Name")
        .entityFieldReference(null)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableReportGridFixedColumnDefinition.Builder actualGridColumnIdResult = actualExternalIdResult
        .externalId(externalId)
        .gridColumnId(1L);

    // Assert
    assertSame(actualGridColumnIdResult, actualGridColumnIdResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#columnEntityKind(EntityKind)}
   */
  @Test
  void testBuilderColumnEntityKind() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#columnEntityKind(EntityKind)}
   */
  @Test
  void testBuilderColumnEntityKind2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    builderResult.entityFieldReference(mock(EntityFieldReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.columnEntityKind(EntityKind.ALL));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    builderResult.entityFieldReference(mock(EntityFieldReference.class));
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnQualifierKind()).thenThrow(new IllegalStateException("instance"));
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn(null);
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.columnName());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.columnQualifierKind());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(null);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.columnEntityId());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(null);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.columnQualifierId());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(null);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.gridColumnId());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(null);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.id());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn(null);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.columnDescription());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertNull(buildResult.displayName());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.entityFieldReference());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(mock(EntityFieldReference.class));

    // Act
    ImmutableReportGridFixedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridFixedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Column Name", buildResult.columnName());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnEntityKind());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, buildResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, buildResult.additionalColumnOptions());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Builder#position(int)}
   */
  @Test
  void testBuilderPosition2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    builderResult.entityFieldReference(mock(EntityFieldReference.class));

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn(null);
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.columnName());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(null);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.columnQualifierKind());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(null);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.columnEntityId());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(null);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.columnQualifierId());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf6() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(null);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.gridColumnId());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf7() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(null);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.id());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf8() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn(null);
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.columnDescription());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf9() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertNull(actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf10() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(null);

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertNull(actualCopyOfResult.entityFieldReference());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition#copyOf(ReportGridFixedColumnDefinition)}
   */
  @Test
  void testCopyOf11() {
    // Arrange
    ReportGridFixedColumnDefinition instance = mock(ReportGridFixedColumnDefinition.class);
    when(instance.columnName()).thenReturn("Column Name");
    when(instance.columnQualifierKind()).thenReturn(EntityKind.ALL);
    when(instance.position()).thenReturn(1);
    when(instance.columnEntityId()).thenReturn(1L);
    when(instance.columnQualifierId()).thenReturn(1L);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    when(instance.displayName()).thenReturn("Display Name");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.additionalColumnOptions()).thenReturn(AdditionalColumnOptions.NONE);
    when(instance.columnEntityKind()).thenReturn(EntityKind.ALL);
    when(instance.entityFieldReference()).thenReturn(mock(EntityFieldReference.class));

    // Act
    ImmutableReportGridFixedColumnDefinition actualCopyOfResult = ImmutableReportGridFixedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).additionalColumnOptions();
    verify(instance).columnDescription();
    verify(instance).columnEntityId();
    verify(instance).columnEntityKind();
    verify(instance).columnName();
    verify(instance).columnQualifierId();
    verify(instance).columnQualifierKind();
    verify(instance).displayName();
    verify(instance).entityFieldReference();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Column Name", actualCopyOfResult.columnName());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.columnEntityId().longValue());
    assertEquals(1L, actualCopyOfResult.columnQualifierId().longValue());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnEntityKind());
    assertEquals(EntityKind.ALL, actualCopyOfResult.columnQualifierKind());
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualCopyOfResult.kind());
    assertEquals(AdditionalColumnOptions.NONE, actualCopyOfResult.additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#additionalColumnOptions()}
   */
  @Test
  void testJsonAdditionalColumnOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).additionalColumnOptions());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#columnDescription()}
   */
  @Test
  void testJsonColumnDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).columnDescription());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#columnEntityId()}
   */
  @Test
  void testJsonColumnEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).columnEntityId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#columnEntityKind()}
   */
  @Test
  void testJsonColumnEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).columnEntityKind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#columnName()}
   */
  @Test
  void testJsonColumnName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).columnName());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#columnQualifierId()}
   */
  @Test
  void testJsonColumnQualifierId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).columnQualifierId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#columnQualifierKind()}
   */
  @Test
  void testJsonColumnQualifierKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).columnQualifierKind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#displayName()}
   */
  @Test
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).displayName());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#entityFieldReference()}
   */
  @Test
  void testJsonEntityFieldReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).entityFieldReference());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#gridColumnId()}
   */
  @Test
  void testJsonGridColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).gridColumnId());
  }

  /**
   * Method under test: {@link ImmutableReportGridFixedColumnDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableReportGridFixedColumnDefinition.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridFixedColumnDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridFixedColumnDefinition.Json actualJson = new ImmutableReportGridFixedColumnDefinition.Json();

    // Assert
    assertNull(actualJson.columnEntityId);
    assertNull(actualJson.columnQualifierId);
    assertNull(actualJson.gridColumnId);
    assertNull(actualJson.id);
    assertNull(actualJson.columnDescription);
    assertNull(actualJson.columnName);
    assertNull(actualJson.displayName);
    assertNull(actualJson.columnEntityKind);
    assertNull(actualJson.columnQualifierKind);
    assertNull(actualJson.entityFieldReference);
    assertNull(actualJson.additionalColumnOptions);
    assertEquals(0, actualJson.position);
    assertEquals(EntityKind.REPORT_GRID_FIXED_COLUMN_DEFINITION, actualJson.kind());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridFixedColumnDefinition.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridFixedColumnDefinition.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition2() {
    // Arrange
    ImmutableReportGridFixedColumnDefinition.Json json = new ImmutableReportGridFixedColumnDefinition.Json();
    json.setEntityFieldReference(mock(EntityFieldReference.class));

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
