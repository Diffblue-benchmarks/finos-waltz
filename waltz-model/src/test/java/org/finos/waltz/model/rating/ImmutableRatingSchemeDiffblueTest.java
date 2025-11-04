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
import ch.qos.logback.core.util.COWArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.finos.waltz.model.DescriptionProvider;
import org.finos.waltz.model.ExternalIdProvider;
import org.finos.waltz.model.IdProvider;
import org.finos.waltz.model.NameProvider;
import org.junit.jupiter.api.Test;

class ImmutableRatingSchemeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ImmutableRatingScheme#builder()}
   *   <li>{@link ImmutableRatingScheme#description(String)}
   *   <li>{@link ImmutableRatingScheme#externalId(String)}
   * </ul>
   */
  @Test
  void testBuilder() {
    // Arrange and Act
    ImmutableRatingScheme.Builder actualExternalIdResult = ImmutableRatingScheme.builder()
        .description("The characteristics of someone or something")
        .externalId("42");
    Optional<String> externalId = Optional.of("foo");
    ImmutableRatingScheme.Builder actualIdResult = actualExternalIdResult.externalId(externalId).id(1L);
    Optional<Long> id = Optional.<Long>of(1L);

    // Assert
    assertSame(actualIdResult, actualIdResult.id(id));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#addAllRatings(Iterable)}
   */
  @Test
  void testBuilderAddAllRatings() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addAllRatings(new ArrayList<>()));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#addRatings(RatingSchemeItem)}
   */
  @Test
  void testBuilderAddRatings() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableRatingSchemeItem.Json()));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#addRatings(RatingSchemeItem[])}
   */
  @Test
  void testBuilderAddRatings2() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.addRatings(new ImmutableRatingSchemeItem.Json()));
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#externalId(Optional)}
   */
  @Test
  void testBuilderExternalId() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    Optional<String> externalId = Optional.of("foo");

    // Act and Assert
    assertSame(builderResult, builderResult.externalId(externalId));
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom2() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenReturn(null);

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#from(DescriptionProvider)}
   */
  @Test
  void testBuilderFrom3() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    DescriptionProvider instance = mock(DescriptionProvider.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom4() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom5() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).externalId();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme.Builder#from(ExternalIdProvider)}
   */
  @Test
  void testBuilderFrom6() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    ExternalIdProvider instance = mock(ExternalIdProvider.class);
    when(instance.externalId()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).externalId();
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom7() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom8() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    IdProvider instance = mock(IdProvider.class);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).id();
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(IdProvider)}
   */
  @Test
  void testBuilderFrom9() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    IdProvider instance = mock(IdProvider.class);
    when(instance.id()).thenThrow(new IllegalStateException("instance"));

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).id();
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(NameProvider)}
   */
  @Test
  void testBuilderFrom10() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    NameProvider instance = mock(NameProvider.class);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).name();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(6, buildResult.ratings().size());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(RatingScheme)}
   */
  @Test
  void testBuilderFrom11() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(RatingScheme)}
   */
  @Test
  void testBuilderFrom12() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenThrow(new IllegalStateException("instance"));
    when(instance.name()).thenReturn("Name");

    // Act and Assert
    assertThrows(IllegalStateException.class, () -> builderResult.from(instance));
    verify(instance).description();
    verify(instance).name();
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(RatingScheme)}
   */
  @Test
  void testBuilderFrom13() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn(null);
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(RatingScheme)}
   */
  @Test
  void testBuilderFrom14() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(RatingScheme)}
   */
  @Test
  void testBuilderFrom15() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#from(RatingScheme)}
   */
  @Test
  void testBuilderFrom16() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ImmutableRatingSchemeItem.Json json = new ImmutableRatingSchemeItem.Json();
    ratingSchemeItemList.add(json);
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(ratingSchemeItemList);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme.Builder actualFromResult = builderResult.from(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertEquals("The characteristics of someone or something", buildResult.description());
    List<RatingSchemeItem> ratingsResult = buildResult.ratings();
    assertEquals(1, ratingsResult.size());
    assertSame(json, ratingsResult.get(0));
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#id(long)}
   */
  @Test
  void testBuilderId() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.id(1L));
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#id(Optional)}
   */
  @Test
  void testBuilderId2() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();
    Optional<Long> id = Optional.<Long>of(1L);

    // Act and Assert
    assertSame(builderResult, builderResult.id(id));
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#name(String)}
   */
  @Test
  void testBuilderName() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    // Act
    ImmutableRatingScheme.Builder actualNameResult = builderResult.name("Name");

    // Assert
    ImmutableRatingScheme buildResult = builderResult.build();
    assertEquals("Name", buildResult.name());
    assertNull(buildResult.description());
    assertEquals(6, buildResult.ratings().size());
    assertSame(builderResult, actualNameResult);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Builder#ratings(Iterable)}
   */
  @Test
  void testBuilderRatings() {
    // Arrange
    ImmutableRatingScheme.Builder builderResult = ImmutableRatingScheme.builder();

    // Act and Assert
    assertSame(builderResult, builderResult.ratings(new ArrayList<>()));
  }

  /**
   * Method under test: {@link ImmutableRatingScheme#copyOf(RatingScheme)}
   */
  @Test
  void testCopyOf() {
    // Arrange
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme actualCopyOfResult = ImmutableRatingScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.ratings().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme#copyOf(RatingScheme)}
   */
  @Test
  void testCopyOf2() {
    // Arrange
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> emptyResult = Optional.empty();
    when(instance.externalId()).thenReturn(emptyResult);
    Optional<Long> ofResult = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme actualCopyOfResult = ImmutableRatingScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.ratings().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme#copyOf(RatingScheme)}
   */
  @Test
  void testCopyOf3() {
    // Arrange
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> emptyResult = Optional.empty();
    when(instance.id()).thenReturn(emptyResult);
    when(instance.ratings()).thenReturn(new ArrayList<>());
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme actualCopyOfResult = ImmutableRatingScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertTrue(actualCopyOfResult.ratings().isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme#copyOf(RatingScheme)}
   */
  @Test
  void testCopyOf4() {
    // Arrange
    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(new ImmutableRatingSchemeItem.Json());
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(ratingSchemeItemList);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme actualCopyOfResult = ImmutableRatingScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(ratingSchemeItemList, actualCopyOfResult.ratings());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme#copyOf(RatingScheme)}
   */
  @Test
  void testCopyOf5() {
    // Arrange
    ArrayList<RatingSchemeItem> ratingSchemeItemList = new ArrayList<>();
    ratingSchemeItemList.add(new ImmutableRatingSchemeItem.Json());
    ratingSchemeItemList.add(new ImmutableRatingSchemeItem.Json());
    RatingScheme instance = mock(RatingScheme.class);
    when(instance.description()).thenReturn("The characteristics of someone or something");
    Optional<String> ofResult = Optional.of("foo");
    when(instance.externalId()).thenReturn(ofResult);
    Optional<Long> ofResult2 = Optional.<Long>of(1L);
    when(instance.id()).thenReturn(ofResult2);
    when(instance.ratings()).thenReturn(ratingSchemeItemList);
    when(instance.name()).thenReturn("Name");

    // Act
    ImmutableRatingScheme actualCopyOfResult = ImmutableRatingScheme.copyOf(instance);

    // Assert
    verify(instance).description();
    verify(instance).externalId();
    verify(instance).id();
    verify(instance).name();
    verify(instance).ratings();
    assertEquals("Name", actualCopyOfResult.name());
    assertEquals("The characteristics of someone or something", actualCopyOfResult.description());
    assertEquals(ratingSchemeItemList, actualCopyOfResult.ratings());
  }

  /**
   * Method under test:
   * {@link ImmutableRatingScheme#fromJson(ImmutableRatingScheme.Json)}
   */
  @Test
  void testFromJson() {
    // Arrange
    ImmutableRatingScheme.Json json = new ImmutableRatingScheme.Json();
    json.setName("name");

    // Act
    ImmutableRatingScheme actualFromJsonResult = ImmutableRatingScheme.fromJson(json);

    // Assert
    List<RatingSchemeItem> ratingsResult = actualFromJsonResult.ratings();
    assertEquals(6, ratingsResult.size());
    RatingSchemeItem getResult = ratingsResult.get(0);
    assertTrue(getResult instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult2 = ratingsResult.get(1);
    assertTrue(getResult2 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult3 = ratingsResult.get(2);
    assertTrue(getResult3 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult4 = ratingsResult.get(3);
    assertTrue(getResult4 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult5 = ratingsResult.get(4);
    assertTrue(getResult5 instanceof ImmutableRatingSchemeItem);
    RatingSchemeItem getResult6 = ratingsResult.get(5);
    assertTrue(getResult6 instanceof ImmutableRatingSchemeItem);
    assertEquals("#28a1b6", getResult6.color());
    assertEquals("#2ca02c", getResult4.color());
    assertEquals("#786aa5", getResult.color());
    assertEquals("#d62728", getResult2.color());
    assertEquals("#eee", getResult5.color());
    assertEquals("#ff7f0e", getResult3.color());
    assertEquals("A", getResult3.rating());
    assertEquals("F", getResult.rating());
    assertEquals("G", getResult4.rating());
    assertEquals("R", getResult2.rating());
    assertEquals("X", getResult5.rating());
    assertEquals("Z", getResult6.rating());
    assertEquals("dflt - Disinvest", getResult2.description());
    assertEquals("dflt - Disinvest", getResult2.name());
    assertEquals("dflt - Future", getResult.description());
    assertEquals("dflt - Future", getResult.name());
    assertEquals("dflt - Invest", getResult4.description());
    assertEquals("dflt - Invest", getResult4.name());
    assertEquals("dflt - Maintain", getResult3.description());
    assertEquals("dflt - Maintain", getResult3.name());
    assertEquals("dflt - Not Applicable", getResult5.description());
    assertEquals("dflt - Not Applicable", getResult5.name());
    assertEquals("dflt - Unknown", getResult6.description());
    assertEquals("dflt - Unknown", getResult6.name());
    assertEquals("name", actualFromJsonResult.name());
    assertNull(actualFromJsonResult.description());
    assertNull(getResult.ratingGroup());
    assertNull(getResult2.ratingGroup());
    assertNull(getResult3.ratingGroup());
    assertNull(getResult4.ratingGroup());
    assertNull(getResult5.ratingGroup());
    assertNull(getResult6.ratingGroup());
    assertEquals(10, getResult2.position());
    assertEquals(1L, getResult.ratingSchemeId());
    assertEquals(1L, getResult2.ratingSchemeId());
    assertEquals(1L, getResult3.ratingSchemeId());
    assertEquals(1L, getResult4.ratingSchemeId());
    assertEquals(1L, getResult5.ratingSchemeId());
    assertEquals(1L, getResult6.ratingSchemeId());
    assertEquals(20, getResult3.position());
    assertEquals(30, getResult4.position());
    assertEquals(35, getResult.position());
    assertEquals(40, getResult6.position());
    assertEquals(50, getResult5.position());
    assertFalse(getResult.isRestricted());
    assertFalse(getResult2.isRestricted());
    assertFalse(getResult3.isRestricted());
    assertFalse(getResult4.isRestricted());
    assertFalse(getResult5.isRestricted());
    assertFalse(getResult6.isRestricted());
    assertFalse(getResult.requiresComment());
    assertFalse(getResult2.requiresComment());
    assertFalse(getResult3.requiresComment());
    assertFalse(getResult4.requiresComment());
    assertFalse(getResult5.requiresComment());
    assertFalse(getResult6.requiresComment());
    assertFalse(getResult6.userSelectable());
    assertTrue(getResult.userSelectable());
    assertTrue(getResult2.userSelectable());
    assertTrue(getResult3.userSelectable());
    assertTrue(getResult4.userSelectable());
    assertTrue(getResult5.userSelectable());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#description()}
   */
  @Test
  void testJsonDescription() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingScheme.Json()).description());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#externalId()}
   */
  @Test
  void testJsonExternalId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingScheme.Json()).externalId());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#id()}
   */
  @Test
  void testJsonId() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingScheme.Json()).id());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#name()}
   */
  @Test
  void testJsonName() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingScheme.Json()).name());
  }

  /**
   * Method under test: default or parameterless constructor of
   * {@link ImmutableRatingScheme.Json}
   */
  @Test
  void testJsonNewJson() {
    // Arrange and Act
    ImmutableRatingScheme.Json actualJson = new ImmutableRatingScheme.Json();

    // Assert
    assertNull(actualJson.description);
    assertNull(actualJson.name);
    assertFalse(actualJson.externalId.isPresent());
    assertFalse(actualJson.id.isPresent());
    assertFalse(actualJson.ratingsIsSet);
    assertTrue(actualJson.ratings.isEmpty());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#ratings()}
   */
  @Test
  void testJsonRatings() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> (new ImmutableRatingScheme.Json()).ratings());
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#setRatings(List)}
   */
  @Test
  void testJsonSetRatings() {
    // Arrange
    ImmutableRatingScheme.Json json = new ImmutableRatingScheme.Json();

    // Act
    json.setRatings(new ArrayList<>());

    // Assert
    assertTrue(json.ratings.isEmpty());
    assertTrue(json.ratingsIsSet);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#setRatings(List)}
   */
  @Test
  void testJsonSetRatings2() {
    // Arrange
    ImmutableRatingScheme.Json json = new ImmutableRatingScheme.Json();

    // Act
    json.setRatings(null);

    // Assert
    assertNull(json.ratings);
    assertFalse(json.ratingsIsSet);
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#setRatings(List)}
   */
  @Test
  void testJsonSetRatings3() {
    // Arrange
    ImmutableRatingScheme.Json json = new ImmutableRatingScheme.Json();

    ArrayList<RatingSchemeItem> ratings = new ArrayList<>();
    ImmutableRatingSchemeItem.Json json2 = new ImmutableRatingSchemeItem.Json();
    ratings.add(json2);

    // Act
    json.setRatings(ratings);

    // Assert
    List<RatingSchemeItem> ratingSchemeItemList = json.ratings;
    assertEquals(1, ratingSchemeItemList.size());
    assertTrue(json.ratingsIsSet);
    assertSame(json2, ratingSchemeItemList.get(0));
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#setRatings(List)}
   */
  @Test
  void testJsonSetRatings4() {
    // Arrange
    ImmutableRatingScheme.Json json = new ImmutableRatingScheme.Json();

    ArrayList<RatingSchemeItem> ratings = new ArrayList<>();
    ImmutableRatingSchemeItem.Json json2 = new ImmutableRatingSchemeItem.Json();
    ratings.add(json2);
    ImmutableRatingSchemeItem.Json json3 = new ImmutableRatingSchemeItem.Json();
    ratings.add(json3);

    // Act
    json.setRatings(ratings);

    // Assert
    List<RatingSchemeItem> ratingSchemeItemList = json.ratings;
    assertEquals(2, ratingSchemeItemList.size());
    assertTrue(json.ratingsIsSet);
    assertSame(json2, ratingSchemeItemList.get(0));
    assertSame(json3, ratingSchemeItemList.get(1));
  }

  /**
   * Method under test: {@link ImmutableRatingScheme.Json#setRatings(List)}
   */
  @Test
  void testJsonSetRatings5() {
    // Arrange
    ImmutableRatingScheme.Json json = new ImmutableRatingScheme.Json();

    // Act
    json.setRatings(mock(COWArrayList.class));

    // Assert
    assertTrue(json.ratingsIsSet);
  }
}
