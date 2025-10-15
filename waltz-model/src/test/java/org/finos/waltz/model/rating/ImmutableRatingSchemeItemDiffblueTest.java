package org.finos.waltz.model.rating;

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
import java.time.LocalDate;
import java.util.Optional;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.ImmutableEnumValue;
import org.finos.waltz.model.MandatoryDescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.measurable.ImmutableMeasurable;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem.Builder;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeItemDiffblueTest {
  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link Builder#build()}
   *   <li>{@link Builder#externalId(String)}
   *   <li>{@link Builder#ratingGroup(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem Builder.build()",
    "Builder Builder.externalId(String)",
    "Builder Builder.ratingGroup(String)"
  })
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualExternalIdResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.of(1L);
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem =
        actualIdResult
            .id(id)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Assert
    assertEquals("Color", actualImmutableRatingSchemeItem.color());
    assertEquals("Name", actualImmutableRatingSchemeItem.name());
    assertEquals("Rating Group", actualImmutableRatingSchemeItem.ratingGroup());
    assertEquals("Rating", actualImmutableRatingSchemeItem.rating());
    assertEquals(
        "The characteristics of someone or something",
        actualImmutableRatingSchemeItem.description());
    assertEquals(0, actualImmutableRatingSchemeItem.position());
    assertEquals(1L, actualImmutableRatingSchemeItem.ratingSchemeId());
    assertFalse(actualImmutableRatingSchemeItem.isRestricted());
    assertFalse(actualImmutableRatingSchemeItem.requiresComment());
    assertTrue(actualImmutableRatingSchemeItem.userSelectable());
  }

  /**
   * Test Builder {@link Builder#color(String)}.
   *
   * <ul>
   *   <li>When {@code Color}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#color(String)}
   */
  @Test
  @DisplayName("Test Builder color(String); when 'Color'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.color(String)"})
  void testBuilderColor_whenColor_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualColorResult = builderResult.color("Color");

    // Assert
    assertSame(builderResult, actualColorResult);
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   *
   * <ul>
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualDescriptionResult =
        builderResult.description("The characteristics of someone or something");

    // Assert
    assertSame(builderResult, actualDescriptionResult);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act
    Builder actualExternalIdResult = builderResult.externalId(externalId);

    // Assert
    assertSame(builderResult, actualExternalIdResult);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((ExternalIdProvider) instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((IdProvider) instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(MandatoryDescriptionProvider)} with {@code
   * MandatoryDescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MandatoryDescriptionProvider) with 'MandatoryDescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MandatoryDescriptionProvider)"})
  void testBuilderFromWithMandatoryDescriptionProvider() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((MandatoryDescriptionProvider) instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MandatoryDescriptionProvider)} with {@code
   * MandatoryDescriptionProvider}.
   *
   * <p>Method under test: {@link Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MandatoryDescriptionProvider) with 'MandatoryDescriptionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MandatoryDescriptionProvider)"})
  void testBuilderFromWithMandatoryDescriptionProvider2() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    MandatoryDescriptionProvider instance = mock(MandatoryDescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(MandatoryDescriptionProvider)} with {@code
   * MandatoryDescriptionProvider}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  @DisplayName(
      "Test Builder from(MandatoryDescriptionProvider) with 'MandatoryDescriptionProvider'; then throw IllegalStateException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(MandatoryDescriptionProvider)"})
  void testBuilderFromWithMandatoryDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    MandatoryDescriptionProvider instance = mock(MandatoryDescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException());

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((NameProvider) instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableEnumValue.builder()
                    .description("The characteristics of someone or something")
                    .icon("Icon")
                    .iconColor("Icon Color")
                    .key("Key")
                    .name("Name")
                    .type("Type")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider2() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((PositionProvider) instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider3() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualFromResult =
        builderResult.from(
            (PositionProvider)
                ImmutableMeasurable.builder()
                    .categoryId(1L)
                    .concrete(true)
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .externalParentId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .lastUpdatedAt(LocalDate.of(1970, 1, 1).atStartOfDay())
                    .lastUpdatedBy("2020-03-01")
                    .name("Name")
                    .organisationalUnitId(1L)
                    .parentId(1L)
                    .provenance("Provenance")
                    .build());

    // Assert
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   *
   * <p>Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider4() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup(null)
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from((PositionProvider) instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   *
   * <p>Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   *
   * <p>Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem2() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup(null)
            .ratingSchemeId(1L)
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingSchemeItem actualImmutableRatingSchemeItem = builderResult.build();
    assertEquals(instance, actualImmutableRatingSchemeItem);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    Optional<Long> id = Optional.of(1L);

    // Act
    Builder actualIdResult = builderResult.id(id);

    // Assert
    assertSame(builderResult, actualIdResult);
  }

  /**
   * Test Builder {@link Builder#isRestricted(boolean)}.
   *
   * <p>Method under test: {@link Builder#isRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.isRestricted(boolean)"})
  void testBuilderIsRestricted() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualIsRestrictedResult = builderResult.isRestricted(true);

    // Assert
    assertSame(builderResult, actualIsRestrictedResult);
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualPositionResult = builderResult.position(1);

    // Assert
    assertSame(builderResult, actualPositionResult);
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   *
   * <p>Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualRatingSchemeIdResult = builderResult.ratingSchemeId(1L);

    // Assert
    assertSame(builderResult, actualRatingSchemeIdResult);
  }

  /**
   * Test Builder {@link Builder#rating(String)}.
   *
   * <ul>
   *   <li>When {@code Rating}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rating(String)}
   */
  @Test
  @DisplayName("Test Builder rating(String); when 'Rating'; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(String)"})
  void testBuilderRating_whenRating_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualRatingResult = builderResult.rating("Rating");

    // Assert
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test Builder {@link Builder#requiresComment(boolean)}.
   *
   * <p>Method under test: {@link Builder#requiresComment(boolean)}
   */
  @Test
  @DisplayName("Test Builder requiresComment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.requiresComment(boolean)"})
  void testBuilderRequiresComment() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualRequiresCommentResult = builderResult.requiresComment(true);

    // Assert
    assertSame(builderResult, actualRequiresCommentResult);
  }

  /**
   * Test Builder {@link Builder#userSelectable(boolean)}.
   *
   * <p>Method under test: {@link Builder#userSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.userSelectable(boolean)"})
  void testBuilderUserSelectable() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act
    Builder actualUserSelectableResult = builderResult.userSelectable(true);

    // Assert
    assertSame(builderResult, actualUserSelectableResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#copyOf(RatingSchemeItem)}.
   *
   * <ul>
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#copyOf(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test copyOf(RatingSchemeItem); then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.copyOf(RatingSchemeItem)"
  })
  void testCopyOf_thenReturnColor() {
    // Arrange
    ImmutableRatingSchemeItem instance =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualCopyOfResult = ImmutableRatingSchemeItem.copyOf(instance);

    // Assert
    assertEquals("Color", actualCopyOfResult.color());
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("Rating Group", actualCopyOfResult.ratingGroup());
    assertEquals("Rating", actualCopyOfResult.rating());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(0, actualCopyOfResult.position());
    assertEquals(1L, actualCopyOfResult.ratingSchemeId());
    assertFalse(actualCopyOfResult.isRestricted());
    assertFalse(actualCopyOfResult.requiresComment());
    assertTrue(actualCopyOfResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}, and {@link
   * ImmutableRatingSchemeItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItem#equals(Object)}
   *   <li>{@link ImmutableRatingSchemeItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    ImmutableRatingSchemeItem immutableRatingSchemeItem2 =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableRatingSchemeItem, immutableRatingSchemeItem2);
    assertEquals(immutableRatingSchemeItem.hashCode(), immutableRatingSchemeItem2.hashCode());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}, and {@link
   * ImmutableRatingSchemeItem#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItem#equals(Object)}
   *   <li>{@link ImmutableRatingSchemeItem#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertEquals(immutableRatingSchemeItem, immutableRatingSchemeItem);
    int expectedHashCodeResult = immutableRatingSchemeItem.hashCode();
    assertEquals(expectedHashCodeResult, immutableRatingSchemeItem.hashCode());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Name")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("Name")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Rating")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Name")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Name")
            .ratingSchemeId(1L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(2L)
            .build();

    // Act and Assert
    assertNotEquals(
        immutableRatingSchemeItem,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingSchemeItem.equals(Object)",
    "int ImmutableRatingSchemeItem.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build(),
        "Different type to ImmutableRatingSchemeItem");
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#externalId()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#externalId()}
   */
  @Test
  @DisplayName("Test externalId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableRatingSchemeItem.externalId()"})
  void testExternalId() {
    // Arrange and Act
    Optional<String> actualExternalIdResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
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
   *   <li>{@link ImmutableRatingSchemeItem#color()}
   *   <li>{@link ImmutableRatingSchemeItem#description()}
   *   <li>{@link ImmutableRatingSchemeItem#name()}
   *   <li>{@link ImmutableRatingSchemeItem#rating()}
   *   <li>{@link ImmutableRatingSchemeItem#ratingGroup()}
   *   <li>{@link ImmutableRatingSchemeItem#ratingSchemeId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableRatingSchemeItem.color()",
    "String ImmutableRatingSchemeItem.description()",
    "String ImmutableRatingSchemeItem.name()",
    "String ImmutableRatingSchemeItem.rating()",
    "String ImmutableRatingSchemeItem.ratingGroup()",
    "long ImmutableRatingSchemeItem.ratingSchemeId()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    String actualColorResult = immutableRatingSchemeItem.color();
    String actualDescriptionResult = immutableRatingSchemeItem.description();
    String actualNameResult = immutableRatingSchemeItem.name();
    String actualRatingResult = immutableRatingSchemeItem.rating();
    String actualRatingGroupResult = immutableRatingSchemeItem.ratingGroup();

    // Assert
    assertEquals("Color", actualColorResult);
    assertEquals("Name", actualNameResult);
    assertEquals("Rating Group", actualRatingGroupResult);
    assertEquals("Rating", actualRatingResult);
    assertEquals("The characteristics of someone or something", actualDescriptionResult);
    assertEquals(1L, immutableRatingSchemeItem.ratingSchemeId());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#id()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#id()}
   */
  @Test
  @DisplayName("Test id()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Optional ImmutableRatingSchemeItem.id()"})
  void testId() {
    // Arrange and Act
    Optional<Long> actualIdResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .id();

    // Assert
    assertEquals(1L, actualIdResult.get().longValue());
    assertTrue(actualIdResult.isPresent());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#isRestricted()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#isRestricted()}
   */
  @Test
  @DisplayName("Test isRestricted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRatingSchemeItem.isRestricted()"})
  void testIsRestricted() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .isRestricted());
  }

  /**
   * Test Json {@link Json#color()}.
   *
   * <p>Method under test: {@link Json#color()}
   */
  @Test
  @DisplayName("Test Json color()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.color()"})
  void testJsonColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().color());
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
   * Test Json {@link Json#isRestricted()}.
   *
   * <p>Method under test: {@link Json#isRestricted()}
   */
  @Test
  @DisplayName("Test Json isRestricted()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.isRestricted()"})
  void testJsonIsRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().isRestricted());
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
    assertNull(actualJson.color);
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertNull(actualJson.rating);
    assertNull(actualJson.ratingGroup);
    assertEquals(0, actualJson.position);
    assertEquals(0L, actualJson.ratingSchemeId);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.isRestricted);
    assertFalse(actualJson.isRestrictedIsSet);
    assertFalse(actualJson.positionIsSet);
    assertFalse(actualJson.ratingSchemeIdIsSet);
    assertFalse(actualJson.requiresComment);
    assertFalse(actualJson.requiresCommentIsSet);
    assertFalse(actualJson.userSelectable);
    assertFalse(actualJson.userSelectableIsSet);
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
   * Test Json {@link Json#rating()}.
   *
   * <p>Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().rating());
  }

  /**
   * Test Json {@link Json#ratingGroup()}.
   *
   * <p>Method under test: {@link Json#ratingGroup()}
   */
  @Test
  @DisplayName("Test Json ratingGroup()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String Json.ratingGroup()"})
  void testJsonRatingGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingGroup());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   *
   * <p>Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().ratingSchemeId());
  }

  /**
   * Test Json {@link Json#requiresComment()}.
   *
   * <p>Method under test: {@link Json#requiresComment()}
   */
  @Test
  @DisplayName("Test Json requiresComment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.requiresComment()"})
  void testJsonRequiresComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().requiresComment());
  }

  /**
   * Test Json {@link Json#setIsRestricted(boolean)}.
   *
   * <p>Method under test: {@link Json#setIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setIsRestricted(boolean)"})
  void testJsonSetIsRestricted() {
    // Arrange
    Json json = new Json();

    // Act
    json.setIsRestricted(true);

    // Assert
    assertTrue(json.isRestricted);
    assertTrue(json.isRestrictedIsSet);
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
   * Test Json {@link Json#setRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRatingSchemeId(long)"})
  void testJsonSetRatingSchemeId() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRatingSchemeId(1L);

    // Assert
    assertEquals(1L, json.ratingSchemeId);
    assertTrue(json.ratingSchemeIdIsSet);
  }

  /**
   * Test Json {@link Json#setRequiresComment(boolean)}.
   *
   * <p>Method under test: {@link Json#setRequiresComment(boolean)}
   */
  @Test
  @DisplayName("Test Json setRequiresComment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setRequiresComment(boolean)"})
  void testJsonSetRequiresComment() {
    // Arrange
    Json json = new Json();

    // Act
    json.setRequiresComment(true);

    // Assert
    assertTrue(json.requiresComment);
    assertTrue(json.requiresCommentIsSet);
  }

  /**
   * Test Json {@link Json#setUserSelectable(boolean)}.
   *
   * <p>Method under test: {@link Json#setUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Json setUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void Json.setUserSelectable(boolean)"})
  void testJsonSetUserSelectable() {
    // Arrange
    Json json = new Json();

    // Act
    json.setUserSelectable(true);

    // Assert
    assertTrue(json.userSelectable);
    assertTrue(json.userSelectableIsSet);
  }

  /**
   * Test Json {@link Json#userSelectable()}.
   *
   * <p>Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#position()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#position()}
   */
  @Test
  @DisplayName("Test position()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int ImmutableRatingSchemeItem.position()"})
  void testPosition() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .position());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#requiresComment()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#requiresComment()}
   */
  @Test
  @DisplayName("Test requiresComment()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRatingSchemeItem.requiresComment()"})
  void testRequiresComment() {
    // Arrange, Act and Assert
    assertFalse(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .requiresComment());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRatingSchemeItem.toString()"})
  void testToString() {
    // Arrange, Act and Assert
    assertEquals(
        "RatingSchemeItem{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1,"
            + " userSelectable=true, isRestricted=false, ratingGroup=Rating Group, requiresComment=false}",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#toString()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#toString()}
   */
  @Test
  @DisplayName("Test toString()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String ImmutableRatingSchemeItem.toString()"})
  void testToString2() {
    // Arrange, Act and Assert
    assertEquals(
        "RatingSchemeItem{id=1, name=Name, position=0, externalId=42, rating=Rating, color=Color, ratingSchemeId=1,"
            + " userSelectable=true, isRestricted=false, requiresComment=false}",
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup(null)
            .ratingSchemeId(1L)
            .build()
            .toString());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#userSelectable()}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#userSelectable()}
   */
  @Test
  @DisplayName("Test userSelectable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ImmutableRatingSchemeItem.userSelectable()"})
  void testUserSelectable() {
    // Arrange, Act and Assert
    assertTrue(
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withColor(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withColor(String)}
   */
  @Test
  @DisplayName("Test withColor(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withColor(String)"})
  void testWithColor() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("42")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithColorResult = immutableRatingSchemeItem.withColor("42");

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithColorResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withColor(String)}.
   *
   * <ul>
   *   <li>Then return color is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withColor(String)}
   */
  @Test
  @DisplayName("Test withColor(String); then return color is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withColor(String)"})
  void testWithColor_thenReturnColorIs42() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithColorResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withColor("42");

    // Assert
    assertEquals("42", actualWithColorResult.color());
    assertEquals("Name", actualWithColorResult.name());
    assertEquals("Rating Group", actualWithColorResult.ratingGroup());
    assertEquals("Rating", actualWithColorResult.rating());
    assertEquals(
        "The characteristics of someone or something", actualWithColorResult.description());
    assertEquals(0, actualWithColorResult.position());
    assertEquals(1L, actualWithColorResult.ratingSchemeId());
    assertFalse(actualWithColorResult.isRestricted());
    assertFalse(actualWithColorResult.requiresComment());
    assertTrue(actualWithColorResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withDescription(String)"})
  void testWithDescription() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithDescriptionResult =
        immutableRatingSchemeItem.withDescription("42");

    // Assert
    assertEquals(immutableRatingSchemeItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withDescription(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withDescription(String)}
   */
  @Test
  @DisplayName("Test withDescription(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withDescription(String)"})
  void testWithDescription2() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("42")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithDescriptionResult =
        immutableRatingSchemeItem.withDescription("42");

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithDescriptionResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withExternalId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<String> optional = Optional.of("42");

    // Act
    ImmutableRatingSchemeItem actualWithExternalIdResult =
        immutableRatingSchemeItem.withExternalId(optional);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withExternalId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>When of {@code foo}.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withExternalId(Optional)}
   */
  @Test
  @DisplayName("Test withExternalId(Optional) with 'optional'; when of 'foo'; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withExternalId(Optional)"
  })
  void testWithExternalIdWithOptional_whenOfFoo_thenReturnColor() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<String> optional = Optional.of("foo");

    // Act
    ImmutableRatingSchemeItem actualWithExternalIdResult =
        immutableRatingSchemeItem.withExternalId(optional);

    // Assert
    assertEquals("Color", actualWithExternalIdResult.color());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Rating Group", actualWithExternalIdResult.ratingGroup());
    assertEquals("Rating", actualWithExternalIdResult.rating());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(0, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.ratingSchemeId());
    assertFalse(actualWithExternalIdResult.isRestricted());
    assertFalse(actualWithExternalIdResult.requiresComment());
    assertTrue(actualWithExternalIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withExternalId(String)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withExternalId(String)}
   */
  @Test
  @DisplayName("Test withExternalId(String) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withExternalId(String)"})
  void testWithExternalIdWithValue() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithExternalIdResult =
        immutableRatingSchemeItem.withExternalId("42");

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithExternalIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withExternalId(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withExternalId(String)}
   */
  @Test
  @DisplayName(
      "Test withExternalId(String) with 'value'; when '0123456789ABCDEF'; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withExternalId(String)"})
  void testWithExternalIdWithValue_when0123456789abcdef_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithExternalIdResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withExternalId("0123456789ABCDEF");

    // Assert
    assertEquals("Color", actualWithExternalIdResult.color());
    assertEquals("Name", actualWithExternalIdResult.name());
    assertEquals("Rating Group", actualWithExternalIdResult.ratingGroup());
    assertEquals("Rating", actualWithExternalIdResult.rating());
    assertEquals(
        "The characteristics of someone or something", actualWithExternalIdResult.description());
    assertEquals(0, actualWithExternalIdResult.position());
    assertEquals(1L, actualWithExternalIdResult.ratingSchemeId());
    assertFalse(actualWithExternalIdResult.isRestricted());
    assertFalse(actualWithExternalIdResult.requiresComment());
    assertTrue(actualWithExternalIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withId(Optional)} with {@code optional}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withId(Optional)"})
  void testWithIdWithOptional() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableRatingSchemeItem actualWithIdResult = immutableRatingSchemeItem.withId(optional);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withId(Optional)} with {@code optional}.
   *
   * <ul>
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withId(Optional)}
   */
  @Test
  @DisplayName("Test withId(Optional) with 'optional'; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withId(Optional)"})
  void testWithIdWithOptional_thenReturnColor() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(2L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();
    Optional<Long> optional = Optional.of(1L);

    // Act
    ImmutableRatingSchemeItem actualWithIdResult = immutableRatingSchemeItem.withId(optional);

    // Assert
    assertEquals("Color", actualWithIdResult.color());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Rating Group", actualWithIdResult.ratingGroup());
    assertEquals("Rating", actualWithIdResult.rating());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.ratingSchemeId());
    assertFalse(actualWithIdResult.isRestricted());
    assertFalse(actualWithIdResult.requiresComment());
    assertTrue(actualWithIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withId(long)} with {@code value}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withId(long)"})
  void testWithIdWithValue() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithIdResult = immutableRatingSchemeItem.withId(1L);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withId(long)} with {@code value}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withId(long)}
   */
  @Test
  @DisplayName("Test withId(long) with 'value'; when forty-two; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withId(long)"})
  void testWithIdWithValue_whenFortyTwo_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithIdResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withId(42L);

    // Assert
    assertEquals("Color", actualWithIdResult.color());
    assertEquals("Name", actualWithIdResult.name());
    assertEquals("Rating Group", actualWithIdResult.ratingGroup());
    assertEquals("Rating", actualWithIdResult.rating());
    assertEquals("The characteristics of someone or something", actualWithIdResult.description());
    assertEquals(0, actualWithIdResult.position());
    assertEquals(1L, actualWithIdResult.ratingSchemeId());
    assertFalse(actualWithIdResult.isRestricted());
    assertFalse(actualWithIdResult.requiresComment());
    assertTrue(actualWithIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withIsRestricted(boolean)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test withIsRestricted(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withIsRestricted(boolean)"
  })
  void testWithIsRestricted() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithIsRestrictedResult =
        immutableRatingSchemeItem.withIsRestricted(false);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithIsRestrictedResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withIsRestricted(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test withIsRestricted(boolean); when 'true'; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withIsRestricted(boolean)"
  })
  void testWithIsRestricted_whenTrue_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithIsRestrictedResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withIsRestricted(true);

    // Assert
    assertEquals("Color", actualWithIsRestrictedResult.color());
    assertEquals("Name", actualWithIsRestrictedResult.name());
    assertEquals("Rating Group", actualWithIsRestrictedResult.ratingGroup());
    assertEquals("Rating", actualWithIsRestrictedResult.rating());
    assertEquals(
        "The characteristics of someone or something", actualWithIsRestrictedResult.description());
    assertEquals(0, actualWithIsRestrictedResult.position());
    assertEquals(1L, actualWithIsRestrictedResult.ratingSchemeId());
    assertFalse(actualWithIsRestrictedResult.requiresComment());
    assertTrue(actualWithIsRestrictedResult.isRestricted());
    assertTrue(actualWithIsRestrictedResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withName(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withName(String)"})
  void testWithName() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("42")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithNameResult = immutableRatingSchemeItem.withName("42");

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithNameResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withName(String)}.
   *
   * <ul>
   *   <li>Then return name is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withName(String)}
   */
  @Test
  @DisplayName("Test withName(String); then return name is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withName(String)"})
  void testWithName_thenReturnNameIs42() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithNameResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withName("42");

    // Assert
    assertEquals("42", actualWithNameResult.name());
    assertEquals("Color", actualWithNameResult.color());
    assertEquals("Rating Group", actualWithNameResult.ratingGroup());
    assertEquals("Rating", actualWithNameResult.rating());
    assertEquals("The characteristics of someone or something", actualWithNameResult.description());
    assertEquals(0, actualWithNameResult.position());
    assertEquals(1L, actualWithNameResult.ratingSchemeId());
    assertFalse(actualWithNameResult.isRestricted());
    assertFalse(actualWithNameResult.requiresComment());
    assertTrue(actualWithNameResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withPosition(int)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withPosition(int)"})
  void testWithPosition() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithPositionResult = immutableRatingSchemeItem.withPosition(0);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithPositionResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withPosition(int)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withPosition(int)}
   */
  @Test
  @DisplayName("Test withPosition(int); when forty-two; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withPosition(int)"})
  void testWithPosition_whenFortyTwo_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithPositionResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withPosition(42);

    // Assert
    assertEquals("Color", actualWithPositionResult.color());
    assertEquals("Name", actualWithPositionResult.name());
    assertEquals("Rating Group", actualWithPositionResult.ratingGroup());
    assertEquals("Rating", actualWithPositionResult.rating());
    assertEquals(
        "The characteristics of someone or something", actualWithPositionResult.description());
    assertEquals(1L, actualWithPositionResult.ratingSchemeId());
    assertEquals(42, actualWithPositionResult.position());
    assertFalse(actualWithPositionResult.isRestricted());
    assertFalse(actualWithPositionResult.requiresComment());
    assertTrue(actualWithPositionResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRating(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRating(String)"})
  void testWithRating() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("42")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithRatingResult = immutableRatingSchemeItem.withRating("42");

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRatingGroup(String)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRatingGroup(String)}
   */
  @Test
  @DisplayName("Test withRatingGroup(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRatingGroup(String)"})
  void testWithRatingGroup() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("42")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithRatingGroupResult =
        immutableRatingSchemeItem.withRatingGroup("42");

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithRatingGroupResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRatingGroup(String)}.
   *
   * <ul>
   *   <li>Then return ratingGroup is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRatingGroup(String)}
   */
  @Test
  @DisplayName("Test withRatingGroup(String); then return ratingGroup is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRatingGroup(String)"})
  void testWithRatingGroup_thenReturnRatingGroupIs42() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithRatingGroupResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withRatingGroup("42");

    // Assert
    assertEquals("42", actualWithRatingGroupResult.ratingGroup());
    assertEquals("Color", actualWithRatingGroupResult.color());
    assertEquals("Name", actualWithRatingGroupResult.name());
    assertEquals("Rating", actualWithRatingGroupResult.rating());
    assertEquals(
        "The characteristics of someone or something", actualWithRatingGroupResult.description());
    assertEquals(0, actualWithRatingGroupResult.position());
    assertEquals(1L, actualWithRatingGroupResult.ratingSchemeId());
    assertFalse(actualWithRatingGroupResult.isRestricted());
    assertFalse(actualWithRatingGroupResult.requiresComment());
    assertTrue(actualWithRatingGroupResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRatingSchemeId(long)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(42L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithRatingSchemeIdResult =
        immutableRatingSchemeItem.withRatingSchemeId(42L);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithRatingSchemeIdResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRatingSchemeId(long)}.
   *
   * <ul>
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test withRatingSchemeId(long); then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRatingSchemeId(long)"
  })
  void testWithRatingSchemeId_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithRatingSchemeIdResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withRatingSchemeId(42L);

    // Assert
    assertEquals("Color", actualWithRatingSchemeIdResult.color());
    assertEquals("Name", actualWithRatingSchemeIdResult.name());
    assertEquals("Rating Group", actualWithRatingSchemeIdResult.ratingGroup());
    assertEquals("Rating", actualWithRatingSchemeIdResult.rating());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRatingSchemeIdResult.description());
    assertEquals(0, actualWithRatingSchemeIdResult.position());
    assertEquals(42L, actualWithRatingSchemeIdResult.ratingSchemeId());
    assertFalse(actualWithRatingSchemeIdResult.isRestricted());
    assertFalse(actualWithRatingSchemeIdResult.requiresComment());
    assertTrue(actualWithRatingSchemeIdResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRating(String)}.
   *
   * <ul>
   *   <li>Then return rating is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRating(String)}
   */
  @Test
  @DisplayName("Test withRating(String); then return rating is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRating(String)"})
  void testWithRating_thenReturnRatingIs42() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithRatingResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withRating("42");

    // Assert
    assertEquals("42", actualWithRatingResult.rating());
    assertEquals("Color", actualWithRatingResult.color());
    assertEquals("Name", actualWithRatingResult.name());
    assertEquals("Rating Group", actualWithRatingResult.ratingGroup());
    assertEquals(
        "The characteristics of someone or something", actualWithRatingResult.description());
    assertEquals(0, actualWithRatingResult.position());
    assertEquals(1L, actualWithRatingResult.ratingSchemeId());
    assertFalse(actualWithRatingResult.isRestricted());
    assertFalse(actualWithRatingResult.requiresComment());
    assertTrue(actualWithRatingResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRequiresComment(boolean)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRequiresComment(boolean)}
   */
  @Test
  @DisplayName("Test withRequiresComment(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRequiresComment(boolean)"
  })
  void testWithRequiresComment() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithRequiresCommentResult =
        immutableRatingSchemeItem.withRequiresComment(false);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithRequiresCommentResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withRequiresComment(boolean)}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withRequiresComment(boolean)}
   */
  @Test
  @DisplayName("Test withRequiresComment(boolean); when 'true'; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withRequiresComment(boolean)"
  })
  void testWithRequiresComment_whenTrue_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithRequiresCommentResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withRequiresComment(true);

    // Assert
    assertEquals("Color", actualWithRequiresCommentResult.color());
    assertEquals("Name", actualWithRequiresCommentResult.name());
    assertEquals("Rating Group", actualWithRequiresCommentResult.ratingGroup());
    assertEquals("Rating", actualWithRequiresCommentResult.rating());
    assertEquals(
        "The characteristics of someone or something",
        actualWithRequiresCommentResult.description());
    assertEquals(0, actualWithRequiresCommentResult.position());
    assertEquals(1L, actualWithRequiresCommentResult.ratingSchemeId());
    assertFalse(actualWithRequiresCommentResult.isRestricted());
    assertTrue(actualWithRequiresCommentResult.requiresComment());
    assertTrue(actualWithRequiresCommentResult.userSelectable());
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withUserSelectable(boolean)}.
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withUserSelectable(boolean)"
  })
  void testWithUserSelectable() {
    // Arrange
    ImmutableRatingSchemeItem immutableRatingSchemeItem =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build();

    // Act
    ImmutableRatingSchemeItem actualWithUserSelectableResult =
        immutableRatingSchemeItem.withUserSelectable(true);

    // Assert
    assertSame(immutableRatingSchemeItem, actualWithUserSelectableResult);
  }

  /**
   * Test {@link ImmutableRatingSchemeItem#withUserSelectable(boolean)}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code Color}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingSchemeItem#withUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test withUserSelectable(boolean); when 'false'; then return 'Color'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingSchemeItem ImmutableRatingSchemeItem.withUserSelectable(boolean)"
  })
  void testWithUserSelectable_whenFalse_thenReturnColor() {
    // Arrange and Act
    ImmutableRatingSchemeItem actualWithUserSelectableResult =
        ImmutableRatingSchemeItem.builder()
            .color("Color")
            .description("The characteristics of someone or something")
            .externalId("42")
            .id(1L)
            .name("Name")
            .rating("Rating")
            .ratingGroup("Rating Group")
            .ratingSchemeId(1L)
            .build()
            .withUserSelectable(false);

    // Assert
    assertEquals("Color", actualWithUserSelectableResult.color());
    assertEquals("Name", actualWithUserSelectableResult.name());
    assertEquals("Rating Group", actualWithUserSelectableResult.ratingGroup());
    assertEquals("Rating", actualWithUserSelectableResult.rating());
    assertEquals(
        "The characteristics of someone or something",
        actualWithUserSelectableResult.description());
    assertEquals(0, actualWithUserSelectableResult.position());
    assertEquals(1L, actualWithUserSelectableResult.ratingSchemeId());
    assertFalse(actualWithUserSelectableResult.isRestricted());
    assertFalse(actualWithUserSelectableResult.requiresComment());
    assertFalse(actualWithUserSelectableResult.userSelectable());
  }
}
