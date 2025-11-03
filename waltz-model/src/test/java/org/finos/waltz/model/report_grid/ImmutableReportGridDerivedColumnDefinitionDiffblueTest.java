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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridDerivedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDerivedColumnDefinitionDiffblueTest {
  /**
   * Test {@link ImmutableReportGridDerivedColumnDefinition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#builder()}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#columnDescription(String)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#externalId(String)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#gridColumnId(Long)}
   *   <li>{@link ImmutableReportGridDerivedColumnDefinition#id(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableReportGridDerivedColumnDefinition Builder.build()",
      "Builder Builder.columnDescription(String)", "Builder Builder.externalId(String)",
      "Builder Builder.gridColumnId(Long)", "Builder Builder.id(Long)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableReportGridDerivedColumnDefinition.builder()
        .columnDescription("Column Description")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualGridColumnIdResult = actualExternalIdResult.externalId(externalId).gridColumnId(1L);

    // Assert
    assertSame(actualGridColumnIdResult, actualGridColumnIdResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#derivationScript(String)}.
   * <p>
   * Method under test: {@link Builder#derivationScript(String)}
   */
  @Test
  @DisplayName("Test Builder derivationScript(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.derivationScript(String)"})
  void testBuilderDerivationScript() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.derivationScript("Derivation Script"));
  }

  /**
   * Test Builder {@link Builder#displayName(String)}.
   * <p>
   * Method under test: {@link Builder#displayName(String)}
   */
  @Test
  @DisplayName("Test Builder displayName(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.displayName(String)"})
  void testBuilderDisplayName() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.displayName("Display Name"));
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Given {@link Optional} with {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given Optional with 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOptionalWithFoo() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition2() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
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
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition3() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition4() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#from(ReportGridDerivedColumnDefinition)} with {@code ReportGridDerivedColumnDefinition}.
   * <ul>
   *   <li>Then builder build id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridDerivedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDerivedColumnDefinition) with 'ReportGridDerivedColumnDefinition'; then builder build id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridDerivedColumnDefinition)"})
  void testBuilderFromWithReportGridDerivedColumnDefinition_thenBuilderBuildIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
   * Test Builder {@link Builder#position(int)}.
   * <p>
   * Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableReportGridDerivedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Json {@link Json#columnDescription()}.
   * <p>
   * Method under test: {@link Json#columnDescription()}
   */
  @Test
  @DisplayName("Test Json columnDescription()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.columnDescription()"})
  void testJsonColumnDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnDescription());
  }

  /**
   * Test Json {@link Json#derivationScript()}.
   * <p>
   * Method under test: {@link Json#derivationScript()}
   */
  @Test
  @DisplayName("Test Json derivationScript()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.derivationScript()"})
  void testJsonDerivationScript() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).derivationScript());
  }

  /**
   * Test Json {@link Json#displayName()}.
   * <p>
   * Method under test: {@link Json#displayName()}
   */
  @Test
  @DisplayName("Test Json displayName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.displayName()"})
  void testJsonDisplayName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).displayName());
  }

  /**
   * Test Json {@link Json#externalId()}.
   * <p>
   * Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).externalId());
  }

  /**
   * Test Json {@link Json#gridColumnId()}.
   * <p>
   * Method under test: {@link Json#gridColumnId()}
   */
  @Test
  @DisplayName("Test Json gridColumnId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.gridColumnId()"})
  void testJsonGridColumnId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).gridColumnId());
  }

  /**
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

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
   * Test Json {@link Json#position()}.
   * <p>
   * Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).position());
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   * <p>
   * Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void Json.setPosition(int)"})
  void testJsonSetPosition() {
    // Arrange
    Json json = new Json();

    // Act
    json.setPosition(1);

    // Assert
    assertEquals(1, json.position);
    assertTrue(json.positionIsSet);
  }
}
