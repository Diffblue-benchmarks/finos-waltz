package org.finos.waltz.model.rating;

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
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.MandatoryDescriptionProvider;
import org.finos.waltz.model.NameProvider;
import org.finos.waltz.model.PositionProvider;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem.Builder;
import org.finos.waltz.model.rating.ImmutableRatingSchemeItem.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeItemDiffblueTest {
  /**
   * Test {@link ImmutableRatingSchemeItem#builder()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRatingSchemeItem#builder()}
   *   <li>{@link ImmutableRatingSchemeItem#externalId(String)}
   *   <li>{@link ImmutableRatingSchemeItem#ratingGroup(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test builder()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"ImmutableRatingSchemeItem Builder.build()", "Builder Builder.externalId(String)",
      "Builder Builder.ratingGroup(String)"})
  void testBuilder() {
    // Arrange and Act
    Builder actualExternalIdResult = ImmutableRatingSchemeItem.builder().externalId("42");
    Optional<String> externalId = Optional.of("foo");
    Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);
    Builder actualIdResult2 = actualIdResult.id(id);

    // Assert
    assertSame(actualIdResult2, actualIdResult2.ratingGroup("Rating Group"));
  }

  /**
   * Test Builder {@link Builder#color(String)}.
   * <p>
   * Method under test: {@link Builder#color(String)}
   */
  @Test
  @DisplayName("Test Builder color(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.color(String)"})
  void testBuilderColor() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.color("Color"));
  }

  /**
   * Test Builder {@link Builder#description(String)}.
   * <p>
   * Method under test: {@link Builder#description(String)}
   */
  @Test
  @DisplayName("Test Builder description(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.description(String)"})
  void testBuilderDescription() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.description("The characteristics of someone or something"));
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link IdProvider} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given empty; when IdProvider id() return empty")
  @Tag("MaintainedByDiffblue")
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
   * <ul>
   *   <li>Given {@link Optional} with one.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; given Optional with one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_givenOptionalWithOne() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(IdProvider)} with {@code IdProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(IdProvider)}
   */
  @Test
  @DisplayName("Test Builder from(IdProvider) with 'IdProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(IdProvider)"})
  void testBuilderFromWithIdProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Test Builder {@link Builder#from(MandatoryDescriptionProvider)} with {@code MandatoryDescriptionProvider}.
   * <ul>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(MandatoryDescriptionProvider) with 'MandatoryDescriptionProvider'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MandatoryDescriptionProvider)"})
  void testBuilderFromWithMandatoryDescriptionProvider_thenReturnBuilder() {
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
   * Test Builder {@link Builder#from(MandatoryDescriptionProvider)} with {@code MandatoryDescriptionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(MandatoryDescriptionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(MandatoryDescriptionProvider) with 'MandatoryDescriptionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(MandatoryDescriptionProvider)"})
  void testBuilderFromWithMandatoryDescriptionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    MandatoryDescriptionProvider instance = mock(MandatoryDescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Test Builder {@link Builder#from(NameProvider)} with {@code NameProvider}.
   * <ul>
   *   <li>Given {@code Name}.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(NameProvider)}
   */
  @Test
  @DisplayName("Test Builder from(NameProvider) with 'NameProvider'; given 'Name'; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(NameProvider)"})
  void testBuilderFromWithNameProvider_givenName_thenReturnBuilder() {
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
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return builder.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'; given one; then return builder")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider_givenOne_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenReturn(1);

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).position();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(PositionProvider)} with {@code PositionProvider}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(PositionProvider)}
   */
  @Test
  @DisplayName("Test Builder from(PositionProvider) with 'PositionProvider'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(PositionProvider)"})
  void testBuilderFromWithPositionProvider_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    PositionProvider instance = mock(PositionProvider.class);
    when(instance.position()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).position();
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   * <ul>
   *   <li>Given empty.</li>
   *   <li>When {@link RatingSchemeItem} {@link IdProvider#id()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'; given empty; when RatingSchemeItem id() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem_givenEmpty_whenRatingSchemeItemIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Group", buildResult.ratingGroup());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   * <ul>
   *   <li>Then builder build ratingGroup is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'; then builder build ratingGroup is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem_thenBuilderBuildRatingGroupIsNull() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn(null);
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertNull(buildResult.ratingGroup());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   * <ul>
   *   <li>Then builder build ratingGroup is {@code Rating Group}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'; then builder build ratingGroup is 'Rating Group'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem_thenBuilderBuildRatingGroupIsRatingGroup() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Group", buildResult.ratingGroup());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   * <ul>
   *   <li>Then throw {@link IllegalStateException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'; then throw IllegalStateException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem_thenThrowIllegalStateException() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).requiresComment();
  }

  /**
   * Test Builder {@link Builder#from(RatingSchemeItem)} with {@code RatingSchemeItem}.
   * <ul>
   *   <li>When {@link RatingSchemeItem} {@link ExternalIdProvider#externalId()} return empty.</li>
   * </ul>
   * <p>
   * Method under test: {@link Builder#from(RatingSchemeItem)}
   */
  @Test
  @DisplayName("Test Builder from(RatingSchemeItem) with 'RatingSchemeItem'; when RatingSchemeItem externalId() return empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.from(RatingSchemeItem)"})
  void testBuilderFromWithRatingSchemeItem_whenRatingSchemeItemExternalIdReturnEmpty() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    RatingSchemeItem instance = mock(RatingSchemeItem.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratingSchemeId()).thenReturn(1L);
    when(instance.isRestricted()).thenReturn(true);
    when(instance.userSelectable()).thenReturn(true);
    when(instance.rating()).thenReturn("Rating");
    when(instance.ratingGroup()).thenReturn("Rating Group");
    when(instance.color()).thenReturn("Color");
    when(instance.requiresComment()).thenReturn(true);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    when(instance.position()).thenReturn(1);
    when(instance.name()).thenReturn("Name");

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).description();
    verify(instance).name();
    verify(instance).position();
    verify(instance).color();
    verify(instance).isRestricted();
    verify(instance).rating();
    verify(instance).ratingGroup();
    verify(instance).ratingSchemeId();
    verify(instance).requiresComment();
    verify(instance).userSelectable();
    ImmutableRatingSchemeItem buildResult = builderResult.build();
    assertEquals("Color", buildResult.color());
    assertEquals("Name", buildResult.name());
    assertEquals("Rating Group", buildResult.ratingGroup());
    assertEquals("Rating", buildResult.rating());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertEquals(1, buildResult.position());
    assertEquals(1L, buildResult.ratingSchemeId());
    assertTrue(buildResult.isRestricted());
    assertTrue(buildResult.requiresComment());
    assertTrue(buildResult.userSelectable());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#id(long)} with {@code long}.
   * <p>
   * Method under test: {@link Builder#id(long)}
   */
  @Test
  @DisplayName("Test Builder id(long) with 'long'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(long)"})
  void testBuilderIdWithLong() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Test Builder {@link Builder#id(Optional)} with {@code Optional}.
   * <p>
   * Method under test: {@link Builder#id(Optional)}
   */
  @Test
  @DisplayName("Test Builder id(Optional) with 'Optional'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.id(Optional)"})
  void testBuilderIdWithOptional() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Test Builder {@link Builder#isRestricted(boolean)}.
   * <p>
   * Method under test: {@link Builder#isRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Builder isRestricted(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.isRestricted(boolean)"})
  void testBuilderIsRestricted() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.isRestricted(true));
  }

  /**
   * Test Builder {@link Builder#name(String)}.
   * <p>
   * Method under test: {@link Builder#name(String)}
   */
  @Test
  @DisplayName("Test Builder name(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.name(String)"})
  void testBuilderName() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.name("Name"));
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
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.position(1));
  }

  /**
   * Test Builder {@link Builder#rating(String)}.
   * <p>
   * Method under test: {@link Builder#rating(String)}
   */
  @Test
  @DisplayName("Test Builder rating(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.rating(String)"})
  void testBuilderRating() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.rating("Rating"));
  }

  /**
   * Test Builder {@link Builder#ratingSchemeId(long)}.
   * <p>
   * Method under test: {@link Builder#ratingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Builder ratingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.ratingSchemeId(long)"})
  void testBuilderRatingSchemeId() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratingSchemeId(1L));
  }

  /**
   * Test Builder {@link Builder#requiresComment(boolean)}.
   * <p>
   * Method under test: {@link Builder#requiresComment(boolean)}
   */
  @Test
  @DisplayName("Test Builder requiresComment(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.requiresComment(boolean)"})
  void testBuilderRequiresComment() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.requiresComment(true));
  }

  /**
   * Test Builder {@link Builder#userSelectable(boolean)}.
   * <p>
   * Method under test: {@link Builder#userSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Builder userSelectable(boolean)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Builder Builder.userSelectable(boolean)"})
  void testBuilderUserSelectable() {
    // Arrange
    Builder builderResult = ImmutableRatingSchemeItem.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.userSelectable(true));
  }

  /**
   * Test Json {@link Json#color()}.
   * <p>
   * Method under test: {@link Json#color()}
   */
  @Test
  @DisplayName("Test Json color()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.color()"})
  void testJsonColor() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).color());
  }

  /**
   * Test Json {@link Json#description()}.
   * <p>
   * Method under test: {@link Json#description()}
   */
  @Test
  @DisplayName("Test Json description()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.description()"})
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).description());
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
   * Test Json {@link Json#id()}.
   * <p>
   * Method under test: {@link Json#id()}
   */
  @Test
  @DisplayName("Test Json id()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Optional Json.id()"})
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).id());
  }

  /**
   * Test Json {@link Json#isRestricted()}.
   * <p>
   * Method under test: {@link Json#isRestricted()}
   */
  @Test
  @DisplayName("Test Json isRestricted()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.isRestricted()"})
  void testJsonIsRestricted() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).isRestricted());
  }

  /**
   * Test Json {@link Json#name()}.
   * <p>
   * Method under test: {@link Json#name()}
   */
  @Test
  @DisplayName("Test Json name()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.name()"})
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).name());
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
   * Test Json {@link Json#rating()}.
   * <p>
   * Method under test: {@link Json#rating()}
   */
  @Test
  @DisplayName("Test Json rating()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.rating()"})
  void testJsonRating() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).rating());
  }

  /**
   * Test Json {@link Json#ratingGroup()}.
   * <p>
   * Method under test: {@link Json#ratingGroup()}
   */
  @Test
  @DisplayName("Test Json ratingGroup()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String Json.ratingGroup()"})
  void testJsonRatingGroup() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingGroup());
  }

  /**
   * Test Json {@link Json#ratingSchemeId()}.
   * <p>
   * Method under test: {@link Json#ratingSchemeId()}
   */
  @Test
  @DisplayName("Test Json ratingSchemeId()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long Json.ratingSchemeId()"})
  void testJsonRatingSchemeId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).ratingSchemeId());
  }

  /**
   * Test Json {@link Json#requiresComment()}.
   * <p>
   * Method under test: {@link Json#requiresComment()}
   */
  @Test
  @DisplayName("Test Json requiresComment()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.requiresComment()"})
  void testJsonRequiresComment() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).requiresComment());
  }

  /**
   * Test Json {@link Json#setIsRestricted(boolean)}.
   * <p>
   * Method under test: {@link Json#setIsRestricted(boolean)}
   */
  @Test
  @DisplayName("Test Json setIsRestricted(boolean)")
  @Tag("MaintainedByDiffblue")
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

  /**
   * Test Json {@link Json#setRatingSchemeId(long)}.
   * <p>
   * Method under test: {@link Json#setRatingSchemeId(long)}
   */
  @Test
  @DisplayName("Test Json setRatingSchemeId(long)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setRequiresComment(boolean)}
   */
  @Test
  @DisplayName("Test Json setRequiresComment(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#setUserSelectable(boolean)}
   */
  @Test
  @DisplayName("Test Json setUserSelectable(boolean)")
  @Tag("MaintainedByDiffblue")
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
   * <p>
   * Method under test: {@link Json#userSelectable()}
   */
  @Test
  @DisplayName("Test Json userSelectable()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean Json.userSelectable()"})
  void testJsonUserSelectable() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new Json()).userSelectable());
  }
}
