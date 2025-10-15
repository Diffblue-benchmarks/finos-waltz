package org.finos.waltz.model.orgunit;

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
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityKindProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.ParentIdProvider;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit.Builder;
import org.finos.waltz.model.orgunit.ImmutableOrganisationalUnit.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableOrganisationalUnitDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#description(String)}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#kind(EntityKind)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit Builder.build()",
    "Builder Builder.description(String)",
    "Builder Builder.externalId(String)",
    "Builder Builder.kind(EntityKind)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    Builder actualParentIdResult =
        actualIdResult.id(id).kind(EntityKind.ALL).name("Name").parentId(1L);
    Optional<Long> parentId = Optional.of(1L);
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit =
        actualParentIdResult.parentId(parentId).build();

    // Assert
    assertEquals("Name", actualImmutableOrganisationalUnit.name());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableOrganisationalUnit.description());
    assertEquals(EntityKind.ALL, actualImmutableOrganisationalUnit.kind());
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((DescriptionProvider) instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((EntityKindProvider) instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName("Test Builder from(EntityKindProvider) with 'EntityKindProvider'; given 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_givenAll() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenReturn(EntityKind.ALL);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).kind();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityKindProvider)} with {@code EntityKindProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(EntityKindProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(EntityKindProvider) with 'EntityKindProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityKindProvider)"})
  void testBuilderFromWithEntityKindProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    EntityKindProvider instance = mock(EntityKindProvider.class);
    when(instance.kind()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).kind();
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Given {@code Name}.
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableOrganisationalUnit immutableOrganisationalUnit = builderResult.build();
    assertEquals("Name", immutableOrganisationalUnit.name());
    assertNull(immutableOrganisationalUnit.description());
    assertEquals(EntityKind.ORG_UNIT, immutableOrganisationalUnit.kind());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(NameProvider) with 'NameProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).name();
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnit)} with {@code OrganisationalUnit}.
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnit) with 'OrganisationalUnit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnit)"})
  void testBuilderFromWithOrganisationalUnit() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(OrganisationalUnit)} with {@code OrganisationalUnit}.
   *
   * <p>Method under test: {@link Builder#from(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test Builder from(OrganisationalUnit) with 'OrganisationalUnit'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(OrganisationalUnit)"})
  void testBuilderFromWithOrganisationalUnit2() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description(null)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ParentIdProvider) instance);

    // Assert
    ImmutableOrganisationalUnit actualImmutableOrganisationalUnit = builderResult.build();
    assertEquals(instance, actualImmutableOrganisationalUnit);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given empty.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenEmpty() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.parentId()).thenReturn(emptyResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Given of one.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(ParentIdProvider) with 'ParentIdProvider'; given of one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_givenOfOne() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    Optional<Long> ofResult = Optional.of(1L);
    when(instance.parentId()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).parentId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(ParentIdProvider)} with {@code ParentIdProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(ParentIdProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(ParentIdProvider) with 'ParentIdProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(ParentIdProvider)"})
  void testBuilderFromWithParentIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    ParentIdProvider instance = mock(ParentIdProvider.class);
    when(instance.parentId()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).parentId();
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
    Builder builderResult = ImmutableOrganisationalUnit.builder();

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
    Builder builderResult = ImmutableOrganisationalUnit.builder();
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
   *   <li>Then builder build name is {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String); when 'Name'; then builder build name is 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName_whenName_thenBuilderBuildNameIsName() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    // Act
    Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableOrganisationalUnit immutableOrganisationalUnit = builderResult.build();
    assertEquals("Name", immutableOrganisationalUnit.name());
    assertNull(immutableOrganisationalUnit.description());
    assertEquals(EntityKind.ORG_UNIT, immutableOrganisationalUnit.kind());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Test Builder {@link Builder#parentId(long)} with {@code long}.
   *
   * <p>Method under test: {@link Builder#parentId(long)}
   */
  @Test
  @DisplayName("Test Builder parentId(long) with 'long'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(long)"})
  void testBuilderParentIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();

    // Act
    Builder actualParentIdResult = builderResult.parentId(1L);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test Builder {@link Builder#parentId(Optional)} with {@code Optional}.
   *
   * <p>Method under test: {@link Builder#parentId(Optional)}
   */
  @Test
  @DisplayName("Test Builder parentId(Optional) with 'Optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.parentId(Optional)"})
  void testBuilderParentIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableOrganisationalUnit.builder();
    Optional<Long> parentId = Optional.of(1L);

    // Act
    Builder actualParentIdResult = builderResult.parentId(parentId);

    // Assert
    assertSame(builderResult, actualParentIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#copyOf(OrganisationalUnit)}
   */
  @Test
  @DisplayName("Test copyOf(OrganisationalUnit); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.copyOf(OrganisationalUnit)"
  })
  void testCopyOf_thenReturnName() {
    // Arrange
    ImmutableOrganisationalUnit instance =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualCopyOfResult = ImmutableOrganisationalUnit.copyOf(instance);

    // Assert
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(EntityKind.ALL, actualCopyOfResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}, and {@link
   * ImmutableOrganisationalUnit#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnit#equals(Object)}
   *   <li>{@link ImmutableOrganisationalUnit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    ImmutableOrganisationalUnit immutableOrganisationalUnit2 =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableOrganisationalUnit, immutableOrganisationalUnit2);
    assertEquals(immutableOrganisationalUnit.hashCode(), immutableOrganisationalUnit2.hashCode());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}, and {@link
   * ImmutableOrganisationalUnit#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnit#equals(Object)}
   *   <li>{@link ImmutableOrganisationalUnit#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableOrganisationalUnit, immutableOrganisationalUnit);
    int expectedHashCodeResult = immutableOrganisationalUnit.hashCode();
    assertEquals(expectedHashCodeResult, immutableOrganisationalUnit.hashCode());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnit,
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnit,
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnit,
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("externalId")
            .parentId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnit,
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableOrganisationalUnit,
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableOrganisationalUnit.equals(Object)",
    "int ImmutableOrganisationalUnit.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build(),
        "Different type to ImmutableOrganisationalUnit");
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#externalId()}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableOrganisationalUnit.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .externalId();

    // Assert
    assertEquals("42", actualExternalIdResult.get());
    assertTrue(actualExternalIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code ALL}.
   *   <li>When {@link Json} (default constructor) Kind is {@code ALL}.
   *   <li>Then return kind is {@code ALL}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'ALL'; when Json (default constructor) Kind is 'ALL'; then return kind is 'ALL'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.fromJson(Json)"})
  void testFromJson_givenAll_whenJsonKindIsAll_thenReturnKindIsAll() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setKind(EntityKind.ALL);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ALL, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Description is {@code Json}.
   *   <li>Then return description is {@code Json}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Description is 'Json'; then return description is 'Json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonDescriptionIsJson_thenReturnDescriptionIsJson() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription("Json");
    json.setExternalId(null);
    json.setKind(null);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.description());
    assertEquals("Json", actualFromJsonResult.name());
    assertEquals(EntityKind.ORG_UNIT, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code Json}.
   *   <li>When {@link Json} (default constructor) Name is {@code Json}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'Json'; when Json (default constructor) Name is 'Json'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.fromJson(Json)"})
  void testFromJson_givenJson_whenJsonNameIsJson_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setKind(null);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ORG_UNIT, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of {@code foo}.
   *   <li>When {@link Json} (default constructor) ExternalId is of {@code foo}.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of 'foo'; when Json (default constructor) ExternalId is of 'foo'; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.fromJson(Json)"})
  void testFromJson_givenOfFoo_whenJsonExternalIdIsOfFoo_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription(null);
    Optional<String> externalId = Optional.of("foo");
    json.setExternalId(externalId);
    json.setKind(null);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ORG_UNIT, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) Id is of one.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) Id is of one; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.fromJson(Json)"})
  void testFromJson_givenOfOne_whenJsonIdIsOfOne_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    Optional<Long> id = Optional.of(1L);
    json.setId(id);
    json.setParentId(null);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setKind(null);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ORG_UNIT, actualFromJsonResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given of one.
   *   <li>When {@link Json} (default constructor) ParentId is of one.
   *   <li>Then return description is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given of one; when Json (default constructor) ParentId is of one; then return description is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.fromJson(Json)"})
  void testFromJson_givenOfOne_whenJsonParentIdIsOfOne_thenReturnDescriptionIsNull() {
    // Arrange
    Json json = new Json();
    json.setId(null);
    Optional<Long> parentId = Optional.of(1L);
    json.setParentId(parentId);
    json.setName("Json");
    json.setDescription(null);
    json.setExternalId(null);
    json.setKind(null);

    // Act
    ImmutableOrganisationalUnit actualFromJsonResult = ImmutableOrganisationalUnit.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertEquals(EntityKind.ORG_UNIT, actualFromJsonResult.kind());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableOrganisationalUnit#description()}
   *   <li>{@link ImmutableOrganisationalUnit#kind()}
   *   <li>{@link ImmutableOrganisationalUnit#name()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableOrganisationalUnit.description()",
    "EntityKind ImmutableOrganisationalUnit.kind()",
    "String ImmutableOrganisationalUnit.name()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    String actualDescriptionResult = immutableOrganisationalUnit.description();
    EntityKind actualKindResult = immutableOrganisationalUnit.kind();

    // Assert
    assertEquals("Name", immutableOrganisationalUnit.name());
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(EntityKind.ALL, actualKindResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#id()}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableOrganisationalUnit.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
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
   * Test Json {@link Json#kind()}.
   *
   * <p>Method under test: {@link Json#kind()}
   */
  @Test
  @DisplayName("Test Json kind()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityKind Json.kind()"})
  void testJsonKind() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().kind());
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
    assertNull(actualJson.kind);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.parentId.isPresent());
  }

  /**
   * Test Json {@link Json#parentId()}.
   *
   * <p>Method under test: {@link Json#parentId()}
   */
  @Test
  @DisplayName("Test Json parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional Json.parentId()"})
  void testJsonParentId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().parentId());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#parentId()}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#parentId()}
   */
  @Test
  @DisplayName("Test parentId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableOrganisationalUnit.parentId()"})
  void testParentId() {
    // Arrange and Act
    Optional<Long> actualParentIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .parentId();

    // Assert
    assertEquals(1L, actualParentIdResult.get().longValue());
    assertTrue(actualParentIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#toString()}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableOrganisationalUnit.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "OrganisationalUnit{id=1, parentId=1, name=Name, externalId=42, kind=ALL}",
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withDescription(String)"
  })
  void testWithDescription() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithDescriptionResult =
        immutableOrganisationalUnit.withDescription("42");

    // Assert
    assertEquals(immutableOrganisationalUnit, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withDescription(String)"
  })
  void testWithDescription2() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("42")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithDescriptionResult =
        immutableOrganisationalUnit.withDescription("42");

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableOrganisationalUnit actualWithExternalIdResult =
        immutableOrganisationalUnit.withExternalId(optional);

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnName() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableOrganisationalUnit actualWithExternalIdResult =
        immutableOrganisationalUnit.withExternalId(optional);

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withExternalId(String)"
  })
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithExternalIdResult =
        immutableOrganisationalUnit.withExternalId("42");

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withExternalId(String)"
  })
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnName() {
    // Arrange and Act
    ImmutableOrganisationalUnit actualWithExternalIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(EntityKind.ALL, actualWithExternalIdResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableOrganisationalUnit actualWithIdResult = immutableOrganisationalUnit.withId(optional);

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withId(Optional)"})
  void testWithIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableOrganisationalUnit actualWithIdResult = immutableOrganisationalUnit.withId(optional);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithIdResult = immutableOrganisationalUnit.withId(1L);

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableOrganisationalUnit actualWithIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(EntityKind.ALL, actualWithIdResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withKind(EntityKind)}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withKind(EntityKind)"
  })
  void testWithKind() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithKindResult =
        immutableOrganisationalUnit.withKind(EntityKind.ALL);

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithKindResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withKind(EntityKind)}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withKind(EntityKind)}
   */
  @Test
  @DisplayName("Test withKind(EntityKind); then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withKind(EntityKind)"
  })
  void testWithKind_thenReturnName() {
    // Arrange and Act
    ImmutableOrganisationalUnit actualWithKindResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ACTOR)
            .name("Name")
            .parentId(1L)
            .build()
            .withKind(EntityKind.ALL);

    // Assert
    assertEquals("Name", actualWithKindResult.name());
    assertEquals("The characteristics of someone or something", actualWithKindResult.description());
    assertEquals(EntityKind.ALL, actualWithKindResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("42")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithNameResult = immutableOrganisationalUnit.withName("42");

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableOrganisationalUnit actualWithNameResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(EntityKind.ALL, actualWithNameResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withParentId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withParentId(Optional)"
  })
  void testWithParentIdWithOptional() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableOrganisationalUnit actualWithParentIdResult =
        immutableOrganisationalUnit.withParentId(optional);

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withParentId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withParentId(Optional)}
   */
  @Test
  @DisplayName("Test withParentId(Optional) with 'optional'; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withParentId(Optional)"
  })
  void testWithParentIdWithOptional_thenReturnName() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(2L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableOrganisationalUnit actualWithParentIdResult =
        immutableOrganisationalUnit.withParentId(optional);

    // Assert
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withParentId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withParentId(long)"})
  void testWithParentIdWithValue() {
    // Arrange
    ImmutableOrganisationalUnit immutableOrganisationalUnit =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build();

    // Act
    ImmutableOrganisationalUnit actualWithParentIdResult =
        immutableOrganisationalUnit.withParentId(1L);

    // Assert
    assertSame(immutableOrganisationalUnit, actualWithParentIdResult);
  }

  /**
   * Test {@link ImmutableOrganisationalUnit#withParentId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Name}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableOrganisationalUnit#withParentId(long)}
   */
  @Test
  @DisplayName("Test withParentId(long) with 'value'; when forty-two; then return 'Name'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableOrganisationalUnit ImmutableOrganisationalUnit.withParentId(long)"})
  void testWithParentIdWithValue_whenFortyTwo_thenReturnName() {
    // Arrange and Act
    ImmutableOrganisationalUnit actualWithParentIdResult =
        ImmutableOrganisationalUnit.builder()
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .parentId(1L)
            .build()
            .withParentId(42L);

    // Assert
    assertEquals("Name", actualWithParentIdResult.name());
    assertEquals(
        "The characteristics of someone or something", actualWithParentIdResult.description());
    assertEquals(EntityKind.ALL, actualWithParentIdResult.kind());
  }
}
