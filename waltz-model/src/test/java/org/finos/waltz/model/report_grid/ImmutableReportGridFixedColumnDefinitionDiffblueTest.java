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
import org.finos.waltz.model.entity_field_reference.EntityFieldReference;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Builder;
import org.finos.waltz.model.report_grid.ImmutableReportGridFixedColumnDefinition.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridFixedColumnDefinitionDiffblueTest {
  /**
   * Test {@link ImmutableReportGridFixedColumnDefinition#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#builder()}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnDescription(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnEntityId(Long)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnName(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnQualifierId(Long)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#columnQualifierKind(EntityKind)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#displayName(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#entityFieldReference(EntityFieldReference)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#externalId(String)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#gridColumnId(Long)}
   *   <li>{@link ImmutableReportGridFixedColumnDefinition#id(Long)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.additionalColumnOptions(AdditionalColumnOptions)",
      "ImmutableReportGridFixedColumnDefinition Builder.build()", "Builder Builder.columnDescription(String)",
      "Builder Builder.columnEntityId(Long)", "Builder Builder.columnName(String)",
      "Builder Builder.columnQualifierId(Long)", "Builder Builder.columnQualifierKind(EntityKind)",
      "Builder Builder.displayName(String)", "Builder Builder.entityFieldReference(EntityFieldReference)",
      "Builder Builder.externalId(String)", "Builder Builder.gridColumnId(Long)", "Builder Builder.id(Long)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableReportGridFixedColumnDefinition.builder()
        .columnDescription("Column Description")
        .columnEntityId(1L)
        .columnName("Column Name")
        .columnQualifierId(1L)
        .columnQualifierKind(EntityKind.ALL)
        .displayName("Display Name")
        .entityFieldReference(null)
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualGridColumnIdResult = actualExternalIdResult.externalId(externalId).gridColumnId(1L);

    // Assert
    assertSame(actualGridColumnIdResult, actualGridColumnIdResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#columnEntityKind(EntityKind)}.
   * <p>
   * Method under test: {@link Builder#columnEntityKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder columnEntityKind(EntityKind)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.columnEntityKind(EntityKind)"})
  void testBuilderColumnEntityKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.columnEntityKind(EntityKind.ALL));
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
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition2() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition3() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition4() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition5() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition6() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition7() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition8() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition9() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition10() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    Builder actualFromResult = builderResult.from(instance);

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
    ImmutableReportGridFixedColumnDefinition buildResult = actualFromResult.build();
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
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Given empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; given empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(1L, buildResult.id().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
  }

  /**
   * Test Builder {@link Builder#from(ReportGridFixedColumnDefinition)} with {@code ReportGridFixedColumnDefinition}.
   * <ul>
   *   <li>Then builder build id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(ReportGridFixedColumnDefinition)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridFixedColumnDefinition) with 'ReportGridFixedColumnDefinition'; then builder build id is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(ReportGridFixedColumnDefinition)"})
  void testBuilderFromWithReportGridFixedColumnDefinition_thenBuilderBuildIdIsNull() {
    // Arrange
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();
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
    builderResult.from(instance);

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
    assertEquals(1L, buildResult.columnEntityId().longValue());
    assertEquals(1L, buildResult.columnQualifierId().longValue());
    assertEquals(1L, buildResult.gridColumnId().longValue());
    assertEquals(EntityKind.ALL, buildResult.columnQualifierKind());
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
    Builder builderResult = ImmutableReportGridFixedColumnDefinition.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Json {@link Json#additionalColumnOptions()}.
   * <p>
   * Method under test: {@link Json#additionalColumnOptions()}
   */
  @Test
  @DisplayName("Test Json additionalColumnOptions()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"AdditionalColumnOptions Json.additionalColumnOptions()"})
  void testJsonAdditionalColumnOptions() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).additionalColumnOptions());
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
   * Test Json {@link Json#columnEntityId()}.
   * <p>
   * Method under test: {@link Json#columnEntityId()}
   */
  @Test
  @DisplayName("Test Json columnEntityId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.columnEntityId()"})
  void testJsonColumnEntityId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnEntityId());
  }

  /**
   * Test Json {@link Json#columnEntityKind()}.
   * <p>
   * Method under test: {@link Json#columnEntityKind()}
   */
  @Test
  @DisplayName("Test Json columnEntityKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.columnEntityKind()"})
  void testJsonColumnEntityKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnEntityKind());
  }

  /**
   * Test Json {@link Json#columnName()}.
   * <p>
   * Method under test: {@link Json#columnName()}
   */
  @Test
  @DisplayName("Test Json columnName()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.columnName()"})
  void testJsonColumnName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnName());
  }

  /**
   * Test Json {@link Json#columnQualifierId()}.
   * <p>
   * Method under test: {@link Json#columnQualifierId()}
   */
  @Test
  @DisplayName("Test Json columnQualifierId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Long Json.columnQualifierId()"})
  void testJsonColumnQualifierId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnQualifierId());
  }

  /**
   * Test Json {@link Json#columnQualifierKind()}.
   * <p>
   * Method under test: {@link Json#columnQualifierKind()}
   */
  @Test
  @DisplayName("Test Json columnQualifierKind()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityKind Json.columnQualifierKind()"})
  void testJsonColumnQualifierKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).columnQualifierKind());
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
   * Test Json {@link Json#entityFieldReference()}.
   * <p>
   * Method under test: {@link Json#entityFieldReference()}
   */
  @Test
  @DisplayName("Test Json entityFieldReference()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityFieldReference Json.entityFieldReference()"})
  void testJsonEntityFieldReference() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).entityFieldReference());
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
