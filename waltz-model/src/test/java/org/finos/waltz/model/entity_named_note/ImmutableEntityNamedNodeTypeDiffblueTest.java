package org.finos.waltz.model.entity_named_note;

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
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNodeType.Builder;
import org.finos.waltz.model.entity_named_note.ImmutableEntityNamedNodeType.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityNamedNodeTypeDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllApplicableEntityKinds(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicableEntityKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllApplicableEntityKinds(Iterable); given 'ALL'; when LinkedHashSet() add 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicableEntityKinds(Iterable)"})
  void testBuilderAddAllApplicableEntityKinds_givenAll_whenLinkedHashSetAddAll() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    LinkedHashSet<EntityKind> elements = new LinkedHashSet<>();
    elements.add(EntityKind.ALL);

    // Act
    Builder actualAddAllApplicableEntityKindsResult =
        builderResult.addAllApplicableEntityKinds(elements);

    // Assert
    assertSame(builderResult, actualAddAllApplicableEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addAllApplicableEntityKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllApplicableEntityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllApplicableEntityKinds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllApplicableEntityKinds(Iterable)"})
  void testBuilderAddAllApplicableEntityKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualAddAllApplicableEntityKindsResult =
        builderResult.addAllApplicableEntityKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllApplicableEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addApplicableEntityKinds(EntityKind)} with {@code element}.
   *
   * <p>Method under test: {@link Builder#addApplicableEntityKinds(EntityKind)}
   */
  @Test
  @DisplayName("Test Builder addApplicableEntityKinds(EntityKind) with 'element'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicableEntityKinds(EntityKind)"})
  void testBuilderAddApplicableEntityKindsWithElement() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualAddApplicableEntityKindsResult =
        builderResult.addApplicableEntityKinds(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAddApplicableEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#addApplicableEntityKinds(EntityKind[])} with {@code elements}.
   *
   * <p>Method under test: {@link Builder#addApplicableEntityKinds(EntityKind[])}
   */
  @Test
  @DisplayName("Test Builder addApplicableEntityKinds(EntityKind[]) with 'elements'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addApplicableEntityKinds(EntityKind[])"})
  void testBuilderAddApplicableEntityKindsWithElements() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualAddApplicableEntityKindsResult =
        builderResult.addApplicableEntityKinds(EntityKind.ALL);

    // Assert
    assertSame(builderResult, actualAddApplicableEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#applicableEntityKinds(Iterable)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link LinkedHashSet#LinkedHashSet()} add {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicableEntityKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder applicableEntityKinds(Iterable); given 'ALL'; when LinkedHashSet() add 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicableEntityKinds(Iterable)"})
  void testBuilderApplicableEntityKinds_givenAll_whenLinkedHashSetAddAll() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    LinkedHashSet<EntityKind> elements = new LinkedHashSet<>();
    elements.add(EntityKind.ALL);

    // Act
    Builder actualApplicableEntityKindsResult = builderResult.applicableEntityKinds(elements);

    // Assert
    assertSame(builderResult, actualApplicableEntityKindsResult);
  }

  /**
   * Test Builder {@link Builder#applicableEntityKinds(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#applicableEntityKinds(Iterable)}
   */
  @Test
  @DisplayName("Test Builder applicableEntityKinds(Iterable); when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.applicableEntityKinds(Iterable)"})
  void testBuilderApplicableEntityKinds_whenArrayList() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualApplicableEntityKindsResult =
        builderResult.applicableEntityKinds(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualApplicableEntityKindsResult);
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
    "ImmutableEntityNamedNodeType Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("42");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(42L);
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType =
        actualIdResult.id(id).isReadOnly(true).name("Name").position(1).build();

    // Assert
    assertEquals("Name", actualImmutableEntityNamedNodeType.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableEntityNamedNodeType.description());
    assertEquals(1, actualImmutableEntityNamedNodeType.position());
    assertTrue(actualImmutableEntityNamedNodeType.applicableEntityKinds().isEmpty());
    assertTrue(actualImmutableEntityNamedNodeType.isReadOnly());
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    Optional<String> externalId = Optional.of("42");

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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

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
   *   <li>Given {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(DescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(DescriptionProvider) with 'DescriptionProvider'; given 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(DescriptionProvider)"})
  void testBuilderFromWithDescriptionProvider_givenNull() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNodeType)} with {@code EntityNamedNodeType}.
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNodeType)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNodeType) with 'EntityNamedNodeType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNodeType)"})
  void testBuilderFromWithEntityNamedNodeType() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNodeType)} with {@code EntityNamedNodeType}.
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNodeType)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNodeType) with 'EntityNamedNodeType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNodeType)"})
  void testBuilderFromWithEntityNamedNodeType2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNodeType)} with {@code EntityNamedNodeType}.
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNodeType)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNodeType) with 'EntityNamedNodeType'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNodeType)"})
  void testBuilderFromWithEntityNamedNodeType3() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(false)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityNamedNodeType)} with {@code EntityNamedNodeType}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityNamedNodeType)}
   */
  @Test
  @DisplayName("Test Builder from(EntityNamedNodeType) with 'EntityNamedNodeType'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityNamedNodeType)"})
  void testBuilderFromWithEntityNamedNodeType_givenAll() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    Builder builderResult2 = ImmutableEntityNamedNodeType.builder();
    builderResult2.addApplicableEntityKinds(EntityKind.ALL);
    ImmutableEntityNamedNodeType instance =
        builderResult2
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

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
   *   <li>Given of {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ExternalIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ExternalIdProvider) with 'ExternalIdProvider'; given of '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ExternalIdProvider)"})
  void testBuilderFromWithExternalIdProvider_givenOf42() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("42");
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

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
   *   <li>Given of forty-two.
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return of forty-two.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(IdProvider) with 'IdProvider'; given of forty-two; when IdProvider id() return of forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOfFortyTwo_whenIdProviderIdReturnOfFortyTwo() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.of(42L);
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithNameProvider2() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
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
  void testBuilderFromWithNameProvider3() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(false)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When builder addApplicableEntityKinds {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'ALL'; when builder addApplicableEntityKinds 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenAll_whenBuilderAddApplicableEntityKindsAll() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    Builder builderResult2 = ImmutableEntityNamedNodeType.builder();
    builderResult2.addApplicableEntityKinds(EntityKind.ALL);
    ImmutableEntityNamedNodeType instance =
        builderResult2
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableEntityNamedNodeType actualImmutableEntityNamedNodeType = builderResult.build();
    assertEquals(instance, actualImmutableEntityNamedNodeType);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then calls {@link NameProvider#name()}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then calls name()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenCallsName() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    Optional<Long> id = Optional.of(42L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Builder#isReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Builder isReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isReadOnly(boolean)"})
  void testBuilderIsReadOnly() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualIsReadOnlyResult = builderResult.isReadOnly(true);

    // Assert
    assertSame(builderResult, actualIsReadOnlyResult);
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
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#position(int)}.
   *
   * <p>Method under test: {@link Builder#position(int)}
   */
  @Test
  @DisplayName("Test Builder position(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.position(int)"})
  void testBuilderPosition() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#copyOf(EntityNamedNodeType)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#copyOf(EntityNamedNodeType)}
   */
  @Test
  @DisplayName("Test copyOf(EntityNamedNodeType); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.copyOf(EntityNamedNodeType)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableEntityNamedNodeType instance =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualCopyOfResult = ImmutableEntityNamedNodeType.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(1, actualCopyOfResult.position());
    assertTrue(actualCopyOfResult.applicableEntityKinds().isEmpty());
    assertTrue(actualCopyOfResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}, and {@link
   * ImmutableEntityNamedNodeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityNamedNodeType#equals(Object)}
   *   <li>{@link ImmutableEntityNamedNodeType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType2 =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertEquals(immutableEntityNamedNodeType, immutableEntityNamedNodeType2);
    assertEquals(immutableEntityNamedNodeType.hashCode(), immutableEntityNamedNodeType2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}, and {@link
   * ImmutableEntityNamedNodeType#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityNamedNodeType#equals(Object)}
   *   <li>{@link ImmutableEntityNamedNodeType#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertEquals(immutableEntityNamedNodeType, immutableEntityNamedNodeType);
    int expectedHashCodeResult = immutableEntityNamedNodeType.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityNamedNodeType.hashCode());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityNamedNodeType.builder();
    builderResult.addApplicableEntityKinds(EntityKind.ALL);
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        builderResult
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNodeType,
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNodeType,
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNodeType,
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(false)
            .name("Name")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNodeType,
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("externalId")
            .position(1)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNodeType,
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(0)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableEntityNamedNodeType,
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityNamedNodeType.equals(Object)",
    "int ImmutableEntityNamedNodeType.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build(),
        "Different type to ImmutableEntityNamedNodeType");
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#externalId()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNodeType.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityNamedNodeType#applicableEntityKinds()}
   *   <li>{@link ImmutableEntityNamedNodeType#description()}
   *   <li>{@link ImmutableEntityNamedNodeType#isReadOnly()}
   *   <li>{@link ImmutableEntityNamedNodeType#name()}
   *   <li>{@link ImmutableEntityNamedNodeType#position()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableEntityNamedNodeType.applicableEntityKinds()",
    "String ImmutableEntityNamedNodeType.description()",
    "boolean ImmutableEntityNamedNodeType.isReadOnly()",
    "String ImmutableEntityNamedNodeType.name()",
    "int ImmutableEntityNamedNodeType.position()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    Set<EntityKind> actualApplicableEntityKindsResult =
        immutableEntityNamedNodeType.applicableEntityKinds();
    String actualDescriptionResult = immutableEntityNamedNodeType.description();
    boolean actualIsReadOnlyResult = immutableEntityNamedNodeType.isReadOnly();
    String actualNameResult = immutableEntityNamedNodeType.name();

    // Assert
    assertEquals("Name", actualNameResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1, immutableEntityNamedNodeType.position());
    assertTrue(actualApplicableEntityKindsResult.isEmpty());
    assertTrue(actualIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#id()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableEntityNamedNodeType.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test Json {@link Json#applicableEntityKinds()}.
   *
   * <p>Method under test: {@link Json#applicableEntityKinds()}
   */
  @Test
  @DisplayName("Test Json applicableEntityKinds()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.applicableEntityKinds()"})
  void testJsonApplicableEntityKinds() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().applicableEntityKinds());
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
   * Test Json {@link Json#isReadOnly()}.
   *
   * <p>Method under test: {@link Json#isReadOnly()}
   */
  @Test
  @DisplayName("Test Json isReadOnly()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isReadOnly()"})
  void testJsonIsReadOnly() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isReadOnly());
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
    assertEquals(0, actualJson.position);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isReadOnly);
    assertFalse(actualJson.isReadOnlyIsSet);
    assertFalse(actualJson.positionIsSet);
    assertTrue(actualJson.applicableEntityKinds.isEmpty());
  }

  /**
   * Test Json {@link Json#position()}.
   *
   * <p>Method under test: {@link Json#position()}
   */
  @Test
  @DisplayName("Test Json position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Json.position()"})
  void testJsonPosition() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().position());
  }

  /**
   * Test Json {@link Json#setIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsReadOnly(boolean)"})
  void testJsonSetIsReadOnly() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsReadOnly(true);

    // Assert
    assertTrue(json.isReadOnly);
    assertTrue(json.isReadOnlyIsSet);
  }

  /**
   * Test Json {@link Json#setPosition(int)}.
   *
   * <p>Method under test: {@link Json#setPosition(int)}
   */
  @Test
  @DisplayName("Test Json setPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
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

  /**
   * Test {@link ImmutableEntityNamedNodeType#toString()}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableEntityNamedNodeType.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "EntityNamedNodeType{id=1, name=Name, externalId=42, applicableEntityKinds=[], isReadOnly=true,"
            + " position=1}",
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withApplicableEntityKinds(EntityKind[])} with {@code
   * EntityKind[]}.
   *
   * <p>Method under test: {@link
   * ImmutableEntityNamedNodeType#withApplicableEntityKinds(EntityKind[])}
   */
  @Test
  @DisplayName("Test withApplicableEntityKinds(EntityKind[]) with 'EntityKind[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withApplicableEntityKinds(EntityKind[])"
  })
  void testWithApplicableEntityKindsWithEntityKind() {
    // Arrange and Act
    ImmutableEntityNamedNodeType actualWithApplicableEntityKindsResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .withApplicableEntityKinds(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithApplicableEntityKindsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithApplicableEntityKindsResult.description());
    Set<EntityKind> applicableEntityKindsResult =
        actualWithApplicableEntityKindsResult.applicableEntityKinds();
    assertEquals(1, applicableEntityKindsResult.size());
    assertEquals(1, actualWithApplicableEntityKindsResult.position());
    assertTrue(applicableEntityKindsResult.contains(EntityKind.ALL));
    assertTrue(actualWithApplicableEntityKindsResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withApplicableEntityKinds(Iterable)} with {@code
   * Iterable}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withApplicableEntityKinds(Iterable)}
   */
  @Test
  @DisplayName(
      "Test withApplicableEntityKinds(Iterable) with 'Iterable'; given 'ALL'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withApplicableEntityKinds(Iterable)"
  })
  void testWithApplicableEntityKindsWithIterable_givenAll_thenReturnName() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    LinkedHashSet<EntityKind> elements = new LinkedHashSet<>();
    elements.add(EntityKind.ALL);

    // Act
    ImmutableEntityNamedNodeType actualWithApplicableEntityKindsResult =
        immutableEntityNamedNodeType.withApplicableEntityKinds(elements);

    // Assert
    assertEquals("Name", actualWithApplicableEntityKindsResult.name());
    assertEquals(
        "The characteristics of someone or something",
        actualWithApplicableEntityKindsResult.description());
    assertEquals(1, actualWithApplicableEntityKindsResult.position());
    assertTrue(actualWithApplicableEntityKindsResult.isReadOnly());
    assertEquals(elements, actualWithApplicableEntityKindsResult.applicableEntityKinds());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithDescriptionResult =
        immutableEntityNamedNodeType.withDescription("42");

    // Assert
    assertEquals(immutableEntityNamedNodeType, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithDescriptionResult =
        immutableEntityNamedNodeType.withDescription("42");

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNodeType actualWithExternalIdResult =
        immutableEntityNamedNodeType.withExternalId(optional);

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("External Id")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableEntityNamedNodeType actualWithExternalIdResult =
        immutableEntityNamedNodeType.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1, actualWithExternalIdResult.position());
    assertTrue(actualWithExternalIdResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithExternalIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithExternalIdResult =
        immutableEntityNamedNodeType.withExternalId("42");

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableEntityNamedNodeType actualWithExternalIdResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(1, actualWithExternalIdResult.position());
    assertTrue(actualWithExternalIdResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithExternalIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableEntityNamedNodeType actualWithIdResult = immutableEntityNamedNodeType.withId(optional);

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; when of forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withId(Optional)"})
  void testWithIdWithOptional_whenOfFortyTwo_thenReturnName() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();
    Optional<Long> optional = Optional.of(42L);

    // Act
    ImmutableEntityNamedNodeType actualWithIdResult = immutableEntityNamedNodeType.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertTrue(actualWithIdResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithIdResult = immutableEntityNamedNodeType.withId(1L);

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableEntityNamedNodeType actualWithIdResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(1, actualWithIdResult.position());
    assertTrue(actualWithIdResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithIdResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withIsReadOnly(boolean)}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithIsReadOnlyResult =
        immutableEntityNamedNodeType.withIsReadOnly(true);

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithIsReadOnlyResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withIsReadOnly(boolean)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withIsReadOnly(boolean)}
   */
  @Test
  @DisplayName("Test withIsReadOnly(boolean); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withIsReadOnly(boolean)"
  })
  void testWithIsReadOnly_thenReturnName() {
    // Arrange and Act
    ImmutableEntityNamedNodeType actualWithIsReadOnlyResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(false)
            .name("Name")
            .position(1)
            .build()
            .withIsReadOnly(true);

    // Assert
    assertEquals("Name", actualWithIsReadOnlyResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithIsReadOnlyResult.description());
    assertEquals(1, actualWithIsReadOnlyResult.position());
    assertTrue(actualWithIsReadOnlyResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithIsReadOnlyResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("42")
            .position(1)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithNameResult = immutableEntityNamedNodeType.withName("42");

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableEntityNamedNodeType actualWithNameResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(1, actualWithNameResult.position());
    assertTrue(actualWithNameResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithNameResult.isReadOnly());
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableEntityNamedNodeType immutableEntityNamedNodeType =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(42)
            .build();

    // Act
    ImmutableEntityNamedNodeType actualWithPositionResult =
        immutableEntityNamedNodeType.withPosition(42);

    // Assert
    assertSame(immutableEntityNamedNodeType, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableEntityNamedNodeType#withPosition(int)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityNamedNodeType#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableEntityNamedNodeType ImmutableEntityNamedNodeType.withPosition(int)"})
  void testWithPosition_thenReturnName() {
    // Arrange and Act
    ImmutableEntityNamedNodeType actualWithPositionResult =
        ImmutableEntityNamedNodeType.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .isReadOnly(true)
            .name("Name")
            .position(1)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(42, actualWithPositionResult.position());
    assertTrue(actualWithPositionResult.applicableEntityKinds().isEmpty());
    assertTrue(actualWithPositionResult.isReadOnly());
  }
}
