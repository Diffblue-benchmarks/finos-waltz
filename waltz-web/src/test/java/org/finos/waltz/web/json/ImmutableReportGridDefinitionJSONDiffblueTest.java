package org.finos.waltz.web.json;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.web.json.ImmutableReportGridDefinitionJSON.Builder;
import org.finos.waltz.web.json.ImmutableReportGridDefinitionJSON.Json;
import org.finos.waltz.web.json.ReportGridDefinitionJSON.ReportGridColumnJSON;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableReportGridDefinitionJSONDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllColumns(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllColumns(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllColumns(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllColumns(Iterable)"})
  void testBuilderAddAllColumns_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualAddAllColumnsResult = builderResult.addAllColumns(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllColumnsResult);
  }

  /**
   * Test Builder {@link Builder#addColumns(ReportGridColumnJSON)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridColumnJSON.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addColumns(ReportGridColumnJSON)}
   */
  @Test
  @DisplayName(
      "Test Builder addColumns(ReportGridColumnJSON) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addColumns(ReportGridColumnJSON)"})
  void testBuilderAddColumnsWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualAddColumnsResult =
        builderResult.addColumns(new ImmutableReportGridColumnJSON.Json());

    // Assert
    assertSame(builderResult, actualAddColumnsResult);
  }

  /**
   * Test Builder {@link Builder#addColumns(ReportGridColumnJSON[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableReportGridColumnJSON.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addColumns(ReportGridColumnJSON[])}
   */
  @Test
  @DisplayName(
      "Test Builder addColumns(ReportGridColumnJSON[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addColumns(ReportGridColumnJSON[])"})
  void testBuilderAddColumnsWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualAddColumnsResult =
        builderResult.addColumns(new ImmutableReportGridColumnJSON.Json());

    // Assert
    assertSame(builderResult, actualAddColumnsResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        actualIdResult.id(id).name("Name").subjectKind(EntityKind.ALL).build();

    // Assert
    assertEquals("Name", actualImmutableReportGridDefinitionJSON.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableReportGridDefinitionJSON.description());
    assertEquals(EntityKind.ALL, actualImmutableReportGridDefinitionJSON.subjectKind());
    assertTrue(actualImmutableReportGridDefinitionJSON.columns().isEmpty());
  }

  /**
   * Test Builder {@link Builder#columns(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#columns(Iterable)}
   */
  @Test
  @DisplayName("Test Builder columns(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.columns(Iterable)"})
  void testBuilderColumns_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualColumnsResult = builderResult.columns(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualColumnsResult);
  }

  /**
   * Test Builder {@link Builder#externalId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#externalId(Optional)}
   */
  @Test
  @DisplayName("Test Builder externalId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.externalId(Optional)"})
  void testBuilderExternalIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        builderResult.from((DescriptionProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON2);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(DescriptionProvider)} with {@code DescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(DescriptionProvider) with 'DescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        builderResult.from((ExternalIdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON2);
  }

  /**
   * Test Builder {@link Builder#from(ExternalIdProvider)} with {@code ExternalIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

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
   *
   * <ul>
   *   <li>Given of {@code foo}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of 'foo'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOfFoo() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

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
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        builderResult.from((IdProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON2);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenEmpty_whenIdProviderIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of one; when IdProvider id() return of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfOne_whenIdProviderIdReturnOfOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        builderResult.from((NameProvider) instance).build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON2);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinitionJSON)} with {@code
   * ReportGridDefinitionJSON}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinitionJSON) with 'ReportGridDefinitionJSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinitionJSON)"})
  void testBuilderFromWithReportGridDefinitionJSON() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinitionJSON)} with {@code
   * ReportGridDefinitionJSON}.
   *
   * <p>Method under test: {@link Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  @DisplayName("Test Builder from(ReportGridDefinitionJSON) with 'ReportGridDefinitionJSON'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinitionJSON)"})
  void testBuilderFromWithReportGridDefinitionJSON2() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON =
        builderResult.from(instance).build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON);
    ImmutableReportGridDefinitionJSON actualImmutableReportGridDefinitionJSON2 =
        builderResult.build();
    assertEquals(instance, actualImmutableReportGridDefinitionJSON2);
  }

  /**
   * Test Builder {@link Builder#from(ReportGridDefinitionJSON)} with {@code
   * ReportGridDefinitionJSON}.
   *
   * <ul>
   *   <li>Then return build columns size is one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ReportGridDefinitionJSON)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ReportGridDefinitionJSON) with 'ReportGridDefinitionJSON'; then return build columns size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ReportGridDefinitionJSON)"})
  void testBuilderFromWithReportGridDefinitionJSON_thenReturnBuildColumnsSizeIsOne() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    Builder builderResult2 = ImmutableReportGridDefinitionJSON.builder();
    builderResult2.addColumns(
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build());

    // Act and Assert
    List<ReportGridColumnJSON> columnsResult =
        builderResult
            .from(
                builderResult2
                    .description("The characteristics of someone or something")
                    .externalId("42")
                    .id(1L)
                    .name("Name")
                    .subjectKind(EntityKind.ALL)
                    .build())
            .build()
            .columns();
    assertEquals(1, columnsResult.size());
    ReportGridColumnJSON getResult = columnsResult.get(0);
    assertTrue(getResult instanceof ImmutableReportGridColumnJSON);
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, getResult.position());
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualIdResult = builderResult.id(1L);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#subjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link Builder#subjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder subjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.subjectKind(EntityKind)"})
  void testBuilderSubjectKind() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();

    // Act
    Builder actualSubjectKindResult = builderResult.subjectKind(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDefinitionJSON#copyOf(ReportGridDefinitionJSON)}
   */
  @Test
  @DisplayName("Test copyOf(ReportGridDefinitionJSON); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.copyOf(ReportGridDefinitionJSON)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableReportGridDefinitionJSON instance =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualCopyOfResult =
        ImmutableReportGridDefinitionJSON.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.subjectKind());
    assertTrue(actualCopyOfResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}, and {@link
   * ImmutableReportGridDefinitionJSON#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDefinitionJSON#equals(Object)}
   *   <li>{@link ImmutableReportGridDefinitionJSON#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON2 =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridDefinitionJSON, immutableReportGridDefinitionJSON2);
    assertEquals(
        immutableReportGridDefinitionJSON.hashCode(),
        immutableReportGridDefinitionJSON2.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}, and {@link
   * ImmutableReportGridDefinitionJSON#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDefinitionJSON#equals(Object)}
   *   <li>{@link ImmutableReportGridDefinitionJSON#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertEquals(immutableReportGridDefinitionJSON, immutableReportGridDefinitionJSON);
    int expectedHashCodeResult = immutableReportGridDefinitionJSON.hashCode();
    assertEquals(expectedHashCodeResult, immutableReportGridDefinitionJSON.hashCode());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableReportGridDefinitionJSON.builder();
    builderResult.addColumns(
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build());
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinitionJSON,
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinitionJSON,
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinitionJSON,
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("externalId")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinitionJSON,
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ACTOR)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableReportGridDefinitionJSON,
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableReportGridDefinitionJSON.equals(Object)",
    "int ImmutableReportGridDefinitionJSON.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build(),
        "Different type to ImmutableReportGridDefinitionJSON");
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#externalId()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridDefinitionJSON.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Columns is {@code null}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Columns is 'null'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonColumnsIsNull_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(null);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertTrue(actualFromJsonResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_givenAll_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription("Json");
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(null);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertTrue(actualFromJsonResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableReportGridColumnJSON.Json}
   *       (default constructor).
   *   <li>Then return columns size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); then return columns size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_thenReturnColumnsSizeIsOne() {
    // Arrange
    ArrayList<ReportGridColumnJSON> columns = new ArrayList<>();
    ImmutableReportGridColumnJSON.Json json = new ImmutableReportGridColumnJSON.Json();
    columns.add(json);

    Json json2 = new Json();
    json2.setId(null);
    json2.setName("Json");
    json2.setExternalId(null);
    json2.setDescription(null);
    json2.setSubjectKind(EntityKind.ALL);
    json2.setColumns(columns);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json2);

    // Assert
    List<ReportGridColumnJSON> columnsResult = actualFromJsonResult.columns();
    assertEquals(1, columnsResult.size());
    assertSame(json, columnsResult.get(0));
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); given ArrayList(); then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_givenArrayList_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(new ArrayList<>());

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertTrue(actualFromJsonResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setName("Json");
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(null);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertTrue(actualFromJsonResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of three.
   *   <li>When {@link Json} (default constructor) Id is of three.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of three; when Json (default constructor) Id is of three; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_givenOfThree_whenJsonIdIsOfThree_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(3L);
    json.setId(id);
    json.setName("Json");
    json.setExternalId(null);
    json.setDescription(null);
    json.setSubjectKind(EntityKind.ALL);
    json.setColumns(null);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.subjectKind());
    assertTrue(actualFromJsonResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return columns size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return columns size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.fromJson(Json)"
  })
  void testFromJson_thenReturnColumnsSizeIsTwo() {
    // Arrange
    ArrayList<ReportGridColumnJSON> columns = new ArrayList<>();
    columns.add(
        ImmutableReportGridColumnJSON.builder()
            .description("The characteristics of someone or something")
            .id(1L)
            .name("Name")
            .position(1)
            .build());
    ImmutableReportGridColumnJSON.Json json = new ImmutableReportGridColumnJSON.Json();
    columns.add(json);

    Json json2 = new Json();
    json2.setId(null);
    json2.setName("Json");
    json2.setExternalId(null);
    json2.setDescription(null);
    json2.setSubjectKind(EntityKind.ALL);
    json2.setColumns(columns);

    // Act
    ImmutableReportGridDefinitionJSON actualFromJsonResult =
        ImmutableReportGridDefinitionJSON.fromJson(json2);

    // Assert
    List<ReportGridColumnJSON> columnsResult = actualFromJsonResult.columns();
    assertEquals(2, columnsResult.size());
    ReportGridColumnJSON getResult = columnsResult.get(0);
    assertTrue(getResult instanceof ImmutableReportGridColumnJSON);
    assertEquals("Name", getResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1, getResult.position());
    assertSame(json, columnsResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableReportGridDefinitionJSON#columns()}
   *   <li>{@link ImmutableReportGridDefinitionJSON#description()}
   *   <li>{@link ImmutableReportGridDefinitionJSON#name()}
   *   <li>{@link ImmutableReportGridDefinitionJSON#subjectKind()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "List ImmutableReportGridDefinitionJSON.columns()",
    "String ImmutableReportGridDefinitionJSON.description()",
    "String ImmutableReportGridDefinitionJSON.name()",
    "EntityKind ImmutableReportGridDefinitionJSON.subjectKind()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    List<ReportGridColumnJSON> actualColumnsResult = immutableReportGridDefinitionJSON.columns();
    String actualDescriptionResult = immutableReportGridDefinitionJSON.description();
    String actualNameResult = immutableReportGridDefinitionJSON.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, immutableReportGridDefinitionJSON.subjectKind());
    assertTrue(actualColumnsResult.isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#id()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableReportGridDefinitionJSON.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#columns()}.
   *
   * <p>Method under test: {@link Json#columns()}
   */
  @Test
  @DisplayName("Test Json columns()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.columns()"})
  void testJsonColumns() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().columns());
  }

  /**
   * Test Json {@link Json#description()}.
   *
   * <p>Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().description());
  }

  /**
   * Test Json {@link Json#externalId()}.
   *
   * <p>Method under test: {@link Json#externalId()}
   */
  @Test
  @DisplayName("Test Json externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.externalId()"})
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().externalId());
  }

  /**
   * Test Json {@link Json#id()}.
   *
   * <p>Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().id());
  }

  /**
   * Test Json {@link Json#name()}.
   *
   * <p>Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().name());
  }

  /**
   * Test Json new {@link Json} (default constructor).
   *
   * <p>Method under test: default or parameterless constructor of {@link Json}
   */
  @Test
  @DisplayName("Test Json new Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.<init>()"})
  void testJsonNewJson() {
    // Arrange and Act
    Json actualJson = new Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.subjectKind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertTrue(actualJson.columns.isEmpty());
  }

  /**
   * Test Json {@link Json#subjectKind()}.
   *
   * <p>Method under test: {@link Json#subjectKind()}
   */
  @Test
  @DisplayName("Test Json subjectKind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.subjectKind()"})
  void testJsonSubjectKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().subjectKind());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#toString()}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableReportGridDefinitionJSON.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "ReportGridDefinitionJSON{id=1, name=Name, externalId=42, subjectKind=ALL, columns=[]}",
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withColumns(ReportGridColumnJSON[])} with {@code
   * ReportGridColumnJSON[]}.
   *
   * <p>Method under test: {@link
   * ImmutableReportGridDefinitionJSON#withColumns(ReportGridColumnJSON[])}
   */
  @Test
  @DisplayName("Test withColumns(ReportGridColumnJSON[]) with 'ReportGridColumnJSON[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withColumns(ReportGridColumnJSON[])"
  })
  void testWithColumnsWithReportGridColumnJSON() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithColumnsResult =
        immutableReportGridDefinitionJSON.withColumns(
            ImmutableReportGridColumnJSON.builder()
                .description("The characteristics of someone or something")
                .id(1L)
                .name("Name")
                .position(1)
                .build());

    // Assert
    List<ReportGridColumnJSON> columnsResult = actualWithColumnsResult.columns();
    assertEquals(1, columnsResult.size());
    ReportGridColumnJSON getResult = columnsResult.get(0);
    assertTrue(getResult instanceof ImmutableReportGridColumnJSON);
    assertEquals("Name", getResult.name());
    assertEquals("Name", actualWithColumnsResult.name());
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(
        "The characteristics of someone or something", actualWithColumnsResult.description());
    assertEquals(1, getResult.position());
    assertEquals(EntityKind.ALL, actualWithColumnsResult.subjectKind());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithDescriptionResult =
        immutableReportGridDefinitionJSON.withDescription("42");

    // Assert
    assertEquals(immutableReportGridDefinitionJSON, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithDescriptionResult =
        immutableReportGridDefinitionJSON.withDescription("42");

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableReportGridDefinitionJSON actualWithExternalIdResult =
        immutableReportGridDefinitionJSON.withExternalId(optional);

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableReportGridDefinitionJSON actualWithExternalIdResult =
        immutableReportGridDefinitionJSON.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertTrue(actualWithExternalIdResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithExternalIdResult =
        immutableReportGridDefinitionJSON.withExternalId("42");

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridDefinitionJSON actualWithExternalIdResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.subjectKind());
    assertTrue(actualWithExternalIdResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withId(Optional)"
  })
  void testWithIdWithOptional() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableReportGridDefinitionJSON actualWithIdResult =
        immutableReportGridDefinitionJSON.withId(optional);

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withId(Optional)"
  })
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableReportGridDefinitionJSON actualWithIdResult =
        immutableReportGridDefinitionJSON.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.subjectKind());
    assertTrue(actualWithIdResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withId(long)"
  })
  void testWithIdWithValue() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithIdResult =
        immutableReportGridDefinitionJSON.withId(1L);

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withId(long)"
  })
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridDefinitionJSON actualWithIdResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.subjectKind());
    assertTrue(actualWithIdResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withName(String)"
  })
  void testWithName() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("42")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithNameResult =
        immutableReportGridDefinitionJSON.withName("42");

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withName(String)"
  })
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableReportGridDefinitionJSON actualWithNameResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.subjectKind());
    assertTrue(actualWithNameResult.columns().isEmpty());
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withSubjectKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind() {
    // Arrange
    ImmutableReportGridDefinitionJSON immutableReportGridDefinitionJSON =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ALL)
            .build();

    // Act
    ImmutableReportGridDefinitionJSON actualWithSubjectKindResult =
        immutableReportGridDefinitionJSON.withSubjectKind(EntityKind.ALL);

    // Assert
    assertSame(immutableReportGridDefinitionJSON, actualWithSubjectKindResult);
  }

  /**
   * Test {@link ImmutableReportGridDefinitionJSON#withSubjectKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableReportGridDefinitionJSON#withSubjectKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withSubjectKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableReportGridDefinitionJSON ImmutableReportGridDefinitionJSON.withSubjectKind(EntityKind)"
  })
  void testWithSubjectKind_thenReturnName() {
    // Arrange and Act
    ImmutableReportGridDefinitionJSON actualWithSubjectKindResult =
        ImmutableReportGridDefinitionJSON.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .subjectKind(EntityKind.ACTOR)
            .build()
            .withSubjectKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithSubjectKindResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithSubjectKindResult.description());
    assertEquals(EntityKind.ALL, actualWithSubjectKindResult.subjectKind());
    assertTrue(actualWithSubjectKindResult.columns().isEmpty());
  }
}
