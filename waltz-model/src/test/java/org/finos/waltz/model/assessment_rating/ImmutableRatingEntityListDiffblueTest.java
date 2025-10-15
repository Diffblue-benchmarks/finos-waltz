package org.finos.waltz.model.assessment_rating;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import org.finos.waltz.model.EntityKind;
import org.finos.waltz.model.EntityLifecycleStatus;
import org.finos.waltz.model.EntityReference;
import org.finos.waltz.model.ImmutableEntityReference;
import org.finos.waltz.model.assessment_rating.ImmutableRatingEntityList.Builder;
import org.finos.waltz.model.assessment_rating.ImmutableRatingEntityList.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableRatingEntityListDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllEntityReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllEntityReferences(Iterable)}
   */
  @Test
  @DisplayName(
      "Test Builder addAllEntityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllEntityReferences(Iterable)"})
  void testBuilderAddAllEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    Builder actualAddAllEntityReferencesResult =
        builderResult.addAllEntityReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addEntityReferences(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEntityReferences(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addEntityReferences(EntityReference) with 'element'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityReferences(EntityReference)"})
  void testBuilderAddEntityReferencesWithElement_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    Builder actualAddEntityReferencesResult =
        builderResult.addEntityReferences(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#addEntityReferences(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link EntityReference}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addEntityReferences(EntityReference[]) with 'elements'; when EntityReference; then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addEntityReferences(EntityReference[])"})
  void testBuilderAddEntityReferencesWithElements_whenEntityReference_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    Builder actualAddEntityReferencesResult =
        builderResult.addEntityReferences(mock(EntityReference.class));

    // Assert
    assertSame(builderResult, actualAddEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#build()}.
   *
   * <p>Method under test: {@link Builder#build()}
   */
  @Test
  @DisplayName("Test Builder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    ImmutableRatingEntityList actualImmutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Assert
    assertEquals("Rating", actualImmutableRatingEntityList.rating());
    assertTrue(actualImmutableRatingEntityList.entityReferences().isEmpty());
  }

  /**
   * Test Builder {@link Builder#entityReferences(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#entityReferences(Iterable)}
   */
  @Test
  @DisplayName("Test Builder entityReferences(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.entityReferences(Iterable)"})
  void testBuilderEntityReferences_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    Builder actualEntityReferencesResult = builderResult.entityReferences(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualEntityReferencesResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingEntityList)}.
   *
   * <p>Method under test: {@link Builder#from(RatingEntityList)}
   */
  @Test
  @DisplayName("Test Builder from(RatingEntityList)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingEntityList)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    Builder builderResult2 = ImmutableRatingEntityList.builder();
    builderResult2.addEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableRatingEntityList instance = builderResult2.rating("Rating").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingEntityList actualImmutableRatingEntityList = builderResult.build();
    assertEquals(instance, actualImmutableRatingEntityList);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(RatingEntityList)}.
   *
   * <ul>
   *   <li>Then builder build is builder rating {@code Rating} build.
   * </ul>
   *
   * <p>Method under test: {@link Builder#from(RatingEntityList)}
   */
  @Test
  @DisplayName(
      "Test Builder from(RatingEntityList); then builder build is builder rating 'Rating' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(RatingEntityList)"})
  void testBuilderFrom_thenBuilderBuildIsBuilderRatingRatingBuild() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();
    ImmutableRatingEntityList instance =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableRatingEntityList actualImmutableRatingEntityList = builderResult.build();
    assertEquals(instance, actualImmutableRatingEntityList);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#rating(String)}.
   *
   * <ul>
   *   <li>When {@code Rating}.
   *   <li>Then builder build rating is {@code Rating}.
   * </ul>
   *
   * <p>Method under test: {@link Builder#rating(String)}
   */
  @Test
  @DisplayName("Test Builder rating(String); when 'Rating'; then builder build rating is 'Rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.rating(String)"})
  void testBuilderRating_whenRating_thenBuilderBuildRatingIsRating() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();

    // Act
    Builder actualRatingResult = builderResult.rating("Rating");

    // Assert
    assertEquals("Rating", builderResult.build().rating());
    assertSame(builderResult, actualRatingResult);
  }

  /**
   * Test {@link ImmutableRatingEntityList#copyOf(RatingEntityList)}.
   *
   * <ul>
   *   <li>When builder rating {@code Rating} build.
   *   <li>Then return {@code Rating}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#copyOf(RatingEntityList)}
   */
  @Test
  @DisplayName(
      "Test copyOf(RatingEntityList); when builder rating 'Rating' build; then return 'Rating'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingEntityList ImmutableRatingEntityList.copyOf(RatingEntityList)"
  })
  void testCopyOf_whenBuilderRatingRatingBuild_thenReturnRating() {
    // Arrange
    ImmutableRatingEntityList instance =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Act
    ImmutableRatingEntityList actualCopyOfResult = ImmutableRatingEntityList.copyOf(instance);

    // Assert
    assertEquals("Rating", actualCopyOfResult.rating());
    assertTrue(actualCopyOfResult.entityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingEntityList#equals(Object)}, and {@link
   * ImmutableRatingEntityList#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingEntityList#equals(Object)}
   *   <li>{@link ImmutableRatingEntityList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingEntityList.equals(Object)",
    "int ImmutableRatingEntityList.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImmutableRatingEntityList immutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("Rating").build();
    ImmutableRatingEntityList immutableRatingEntityList2 =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Act and Assert
    assertEquals(immutableRatingEntityList, immutableRatingEntityList2);
    assertEquals(immutableRatingEntityList.hashCode(), immutableRatingEntityList2.hashCode());
  }

  /**
   * Test {@link ImmutableRatingEntityList#equals(Object)}, and {@link
   * ImmutableRatingEntityList#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingEntityList#equals(Object)}
   *   <li>{@link ImmutableRatingEntityList#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingEntityList.equals(Object)",
    "int ImmutableRatingEntityList.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImmutableRatingEntityList immutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Act and Assert
    assertEquals(immutableRatingEntityList, immutableRatingEntityList);
    int expectedHashCodeResult = immutableRatingEntityList.hashCode();
    assertEquals(expectedHashCodeResult, immutableRatingEntityList.hashCode());
  }

  /**
   * Test {@link ImmutableRatingEntityList#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingEntityList.equals(Object)",
    "int ImmutableRatingEntityList.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableRatingEntityList.builder();
    builderResult.addEntityReferences(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableRatingEntityList immutableRatingEntityList = builderResult.rating("Rating").build();

    // Act and Assert
    assertNotEquals(
        immutableRatingEntityList, ImmutableRatingEntityList.builder().rating("Rating").build());
  }

  /**
   * Test {@link ImmutableRatingEntityList#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingEntityList.equals(Object)",
    "int ImmutableRatingEntityList.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImmutableRatingEntityList immutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("java.lang.String").build();

    // Act and Assert
    assertNotEquals(
        immutableRatingEntityList, ImmutableRatingEntityList.builder().rating("Rating").build());
  }

  /**
   * Test {@link ImmutableRatingEntityList#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingEntityList.equals(Object)",
    "int ImmutableRatingEntityList.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImmutableRatingEntityList.builder().rating("Rating").build(), null);
  }

  /**
   * Test {@link ImmutableRatingEntityList#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableRatingEntityList.equals(Object)",
    "int ImmutableRatingEntityList.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ImmutableRatingEntityList.builder().rating("Rating").build(),
        "Different type to ImmutableRatingEntityList");
  }

  /**
   * Test {@link ImmutableRatingEntityList#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link Json} (default constructor) EntityReferences is {@link HashSet#HashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given HashSet(); when Json (default constructor) EntityReferences is HashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList ImmutableRatingEntityList.fromJson(Json)"})
  void testFromJson_givenHashSet_whenJsonEntityReferencesIsHashSet() {
    // Arrange
    Json json = new Json();
    json.setRating("Json");
    json.setEntityReferences(new HashSet<>());

    // Act
    ImmutableRatingEntityList actualFromJsonResult = ImmutableRatingEntityList.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.rating());
    assertTrue(actualFromJsonResult.entityReferences().isEmpty());
  }

  /**
   * Test {@link ImmutableRatingEntityList#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return entityReferences is {@link LinkedHashSet#LinkedHashSet()}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return entityReferences is LinkedHashSet()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList ImmutableRatingEntityList.fromJson(Json)"})
  void testFromJson_thenReturnEntityReferencesIsLinkedHashSet() {
    // Arrange
    LinkedHashSet<EntityReference> entityReferences = new LinkedHashSet<>();
    entityReferences.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    entityReferences.add(mock(EntityReference.class));

    Json json = new Json();
    json.setRating("Json");
    json.setEntityReferences(entityReferences);

    // Act
    ImmutableRatingEntityList actualFromJsonResult = ImmutableRatingEntityList.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.rating());
    assertEquals(entityReferences, actualFromJsonResult.entityReferences());
  }

  /**
   * Test {@link ImmutableRatingEntityList#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return entityReferences size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return entityReferences size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList ImmutableRatingEntityList.fromJson(Json)"})
  void testFromJson_thenReturnEntityReferencesSizeIsOne() {
    // Arrange
    LinkedHashSet<EntityReference> entityReferences = new LinkedHashSet<>();
    entityReferences.add(mock(EntityReference.class));

    Json json = new Json();
    json.setRating("Json");
    json.setEntityReferences(entityReferences);

    // Act
    ImmutableRatingEntityList actualFromJsonResult = ImmutableRatingEntityList.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.rating());
    assertEquals(1, actualFromJsonResult.entityReferences().size());
  }

  /**
   * Test {@link ImmutableRatingEntityList#fromJson(Json)}.
   *
   * <ul>
   *   <li>When {@link Json} (default constructor) EntityReferences is {@code null}.
   *   <li>Then return entityReferences Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); when Json (default constructor) EntityReferences is 'null'; then return entityReferences Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList ImmutableRatingEntityList.fromJson(Json)"})
  void testFromJson_whenJsonEntityReferencesIsNull_thenReturnEntityReferencesEmpty() {
    // Arrange
    Json json = new Json();
    json.setRating("Json");
    json.setEntityReferences(null);

    // Act
    ImmutableRatingEntityList actualFromJsonResult = ImmutableRatingEntityList.fromJson(json);

    // Assert
    assertEquals("Json", actualFromJsonResult.rating());
    assertTrue(actualFromJsonResult.entityReferences().isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableRatingEntityList#toString()}
   *   <li>{@link ImmutableRatingEntityList#entityReferences()}
   *   <li>{@link ImmutableRatingEntityList#rating()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "Set ImmutableRatingEntityList.entityReferences()",
    "String ImmutableRatingEntityList.rating()",
    "String ImmutableRatingEntityList.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ImmutableRatingEntityList immutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Act
    String actualToStringResult = immutableRatingEntityList.toString();
    Set<EntityReference> actualEntityReferencesResult =
        immutableRatingEntityList.entityReferences();

    // Assert
    assertEquals("Rating", immutableRatingEntityList.rating());
    assertEquals("RatingEntityList{rating=Rating, entityReferences=[]}", actualToStringResult);
    assertTrue(actualEntityReferencesResult.isEmpty());
  }

  /**
   * Test Json {@link Json#entityReferences()}.
   *
   * <p>Method under test: {@link Json#entityReferences()}
   */
  @Test
  @DisplayName("Test Json entityReferences()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Set Json.entityReferences()"})
  void testJsonEntityReferences() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().entityReferences());
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
    assertNull(actualJson.rating);
    assertTrue(actualJson.entityReferences.isEmpty());
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
   * Test {@link ImmutableRatingEntityList#withEntityReferences(EntityReference[])} with {@code
   * EntityReference[]}.
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#withEntityReferences(EntityReference[])}
   */
  @Test
  @DisplayName("Test withEntityReferences(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableRatingEntityList ImmutableRatingEntityList.withEntityReferences(EntityReference[])"
  })
  void testWithEntityReferencesWithEntityReference() {
    // Arrange
    ImmutableRatingEntityList immutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("Rating").build();

    // Act
    ImmutableRatingEntityList actualWithEntityReferencesResult =
        immutableRatingEntityList.withEntityReferences(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals("Rating", actualWithEntityReferencesResult.rating());
    assertEquals(1, actualWithEntityReferencesResult.entityReferences().size());
  }

  /**
   * Test {@link ImmutableRatingEntityList#withRating(String)}.
   *
   * <ul>
   *   <li>Given builder rating {@code 42} build.
   *   <li>Then return builder rating {@code 42} build.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#withRating(String)}
   */
  @Test
  @DisplayName(
      "Test withRating(String); given builder rating '42' build; then return builder rating '42' build")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList ImmutableRatingEntityList.withRating(String)"})
  void testWithRating_givenBuilderRating42Build_thenReturnBuilderRating42Build() {
    // Arrange
    ImmutableRatingEntityList immutableRatingEntityList =
        ImmutableRatingEntityList.builder().rating("42").build();

    // Act
    ImmutableRatingEntityList actualWithRatingResult = immutableRatingEntityList.withRating("42");

    // Assert
    assertSame(immutableRatingEntityList, actualWithRatingResult);
  }

  /**
   * Test {@link ImmutableRatingEntityList#withRating(String)}.
   *
   * <ul>
   *   <li>Given builder rating {@code Rating} build.
   *   <li>Then return rating is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableRatingEntityList#withRating(String)}
   */
  @Test
  @DisplayName(
      "Test withRating(String); given builder rating 'Rating' build; then return rating is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ImmutableRatingEntityList ImmutableRatingEntityList.withRating(String)"})
  void testWithRating_givenBuilderRatingRatingBuild_thenReturnRatingIs42() {
    // Arrange and Act
    ImmutableRatingEntityList actualWithRatingResult =
        ImmutableRatingEntityList.builder().rating("Rating").build().withRating("42");

    // Assert
    assertEquals("42", actualWithRatingResult.rating());
    assertTrue(actualWithRatingResult.entityReferences().isEmpty());
  }
}
