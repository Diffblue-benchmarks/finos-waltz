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
import org.junit.jupiter.api.Test;

class ImmutableReportGridDerivedColumnDefinitionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#builder()}
   *   <li>
   * {@link ImmutableReportGridDerivedColumnDefinition#columnDescription(String)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#externalId(String)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#gridColumnId(Long)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#id(Long)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualExternalIdResult = ImmutableReportGridDerivedColumnDefinition
        .builder()
        .columnDescription("Column Description")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableReportGridDerivedColumnDefinition.Builder actualGridColumnIdResult = actualExternalIdResult
        .externalId(externalId)
        .gridColumnId(1L);

    // Assert
    assertSame(actualGridColumnIdResult, actualGridColumnIdResult.id(1L));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#derivationScript(String)}
   */
  @Test
  void testBuilderDerivationScript() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.derivationScript("Derivation Script"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#displayName(String)}
   */
  @Test
  void testBuilderDisplayName() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.displayName("Display Name"));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridDerivedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Derivation Script", buildResult.derivationScript());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).derivationScript();
    verify(instance).displayName();
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(null);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridDerivedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Derivation Script", buildResult.derivationScript());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.gridColumnId());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(null);
    when(instance.columnDescription()).thenReturn("Column Description");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridDerivedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Derivation Script", buildResult.derivationScript());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.id());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridDerivedColumnDefinition buildResult = builderResult.build();
    assertEquals("Derivation Script", buildResult.derivationScript());
    assertEquals("Display Name", buildResult.displayName());
    assertNull(buildResult.columnDescription());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    ImmutableReportGridDerivedColumnDefinition buildResult = builderResult.build();
    assertEquals("Column Description", buildResult.columnDescription());
    assertEquals("Derivation Script", buildResult.derivationScript());
    assertEquals("Display Name", buildResult.displayName());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, buildResult.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Builder#position(int)}
   */
  @Test
  void testBuilderPosition() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Builder builderResult = ImmutableReportGridDerivedColumnDefinition
        .builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition#copyOf(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition actualCopyOfResult = ImmutableReportGridDerivedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Derivation Script", actualCopyOfResult.derivationScript());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition#copyOf(ReportGridDerivedColumnDefinition)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    ReportGridDerivedColumnDefinition instance = mock(ReportGridDerivedColumnDefinition.class);
    when(instance.position()).thenReturn(1);
    when(instance.gridColumnId()).thenReturn(1L);
    when(instance.id()).thenReturn(1L);
    when(instance.columnDescription()).thenReturn("Column Description");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    when(instance.derivationScript()).thenReturn("Derivation Script");
    when(instance.displayName()).thenReturn("Display Name");

    // Act
    ImmutableReportGridDerivedColumnDefinition actualCopyOfResult = ImmutableReportGridDerivedColumnDefinition
        .copyOf(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).columnDescription();
    verify(instance).derivationScript();
    verify(instance).displayName();
    verify(instance).gridColumnId();
    verify(instance).id();
    verify(instance).position();
    assertEquals("Column Description", actualCopyOfResult.columnDescription());
    assertEquals("Derivation Script", actualCopyOfResult.derivationScript());
    assertEquals("Display Name", actualCopyOfResult.displayName());
    assertEquals(1, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.gridColumnId().longValue());
    assertEquals(1L, actualCopyOfResult.id().longValue());
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualCopyOfResult.kind());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#columnDescription()}
   */
  @Test
  void testJsonColumnDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).columnDescription());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#derivationScript()}
   */
  @Test
  void testJsonDerivationScript() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).derivationScript());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#displayName()}
   */
  @Test
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).displayName());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).externalId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#gridColumnId()}
   */
  @Test
  void testJsonGridColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).gridColumnId());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).id());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableReportGridDerivedColumnDefinition.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableReportGridDerivedColumnDefinition.Json actualJson = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Assert
    assertNull(actualJson.gridColumnId);
    assertNull(actualJson.id);
    assertNull(actualJson.columnDescription);
    assertNull(actualJson.derivationScript);
    assertNull(actualJson.displayName);
    assertEquals(0, actualJson.position);
    assertEquals(EntityKind.REPORT_GRID_DERIVED_COLUMN_DEFINITION, actualJson.kind());
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.positionIsSet);
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#position()}
   */
  @Test
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class,
        () -> (new ImmutableReportGridDerivedColumnDefinition.Json()).position());
  }

  /**
   * Method under test:
   * {@link ImmutableReportGridDerivedColumnDefinition.Json#setPosition(int)}
   */
  @Test
  void testJsonSetPosition() {
    // Arrange
    ImmutableReportGridDerivedColumnDefinition.Json json = new ImmutableReportGridDerivedColumnDefinition.Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
