package org.finos.waltz.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.finos.waltz.model.ImmutableEntityReferenceKeyedGroup.Builder;
import org.finos.waltz.model.ImmutableEntityReferenceKeyedGroup.Json;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ImmutableEntityReferenceKeyedGroupDiffblueTest {
  /**
   * Test Builder {@link Builder#addAllValues(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addAllValues(Iterable)}
   */
  @Test
  @DisplayName("Test Builder addAllValues(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addAllValues(Iterable)"})
  void testBuilderAddAllValues_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act
    Builder actualAddAllValuesResult = builderResult.addAllValues(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualAddAllValuesResult);
  }

  /**
   * Test Builder {@link Builder#addValues(EntityReference)} with {@code element}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValues(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder addValues(EntityReference) with 'element'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValues(EntityReference)"})
  void testBuilderAddValuesWithElement_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act
    Builder actualAddValuesResult = builderResult.addValues(new ImmutableEntityReference.Json());

    // Assert
    assertSame(builderResult, actualAddValuesResult);
  }

  /**
   * Test Builder {@link Builder#addValues(EntityReference[])} with {@code elements}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#addValues(EntityReference[])}
   */
  @Test
  @DisplayName(
      "Test Builder addValues(EntityReference[]) with 'elements'; when Json (default constructor); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.addValues(EntityReference[])"})
  void testBuilderAddValuesWithElements_whenJson_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act
    Builder actualAddValuesResult = builderResult.addValues(new ImmutableEntityReference.Json());

    // Assert
    assertSame(builderResult, actualAddValuesResult);
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
  @MethodsUnderTest({"ImmutableEntityReferenceKeyedGroup Builder.build()"})
  void testBuilderBuild() {
    // Arrange and Act
    Builder actualBuilderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReference key =
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build();
    ImmutableEntityReferenceKeyedGroup actualImmutableEntityReferenceKeyedGroup =
        actualBuilderResult.key(key).build();

    // Assert
    assertTrue(actualImmutableEntityReferenceKeyedGroup.values().isEmpty());
    assertSame(key, actualImmutableEntityReferenceKeyedGroup.key());
  }

  /**
   * Test Builder {@link Builder#from(EntityReferenceKeyedGroup)}.
   *
   * <p>Method under test: {@link Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReferenceKeyedGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReferenceKeyedGroup)"})
  void testBuilderFrom() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    Builder builderResult2 = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup instance =
        builderResult2
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityReferenceKeyedGroup actualImmutableEntityReferenceKeyedGroup =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityReferenceKeyedGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#from(EntityReferenceKeyedGroup)}.
   *
   * <p>Method under test: {@link Builder#from(EntityReferenceKeyedGroup)}
   */
  @Test
  @DisplayName("Test Builder from(EntityReferenceKeyedGroup)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.from(EntityReferenceKeyedGroup)"})
  void testBuilderFrom2() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    Builder builderResult2 = ImmutableEntityReferenceKeyedGroup.builder();
    builderResult2.addValues(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableEntityReferenceKeyedGroup instance =
        builderResult2
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    Builder actualFromResult = builderResult.from(instance);

    // Assert
    ImmutableEntityReferenceKeyedGroup actualImmutableEntityReferenceKeyedGroup =
        builderResult.build();
    assertEquals(instance, actualImmutableEntityReferenceKeyedGroup);
    assertSame(builderResult, actualFromResult);
  }

  /**
   * Test Builder {@link Builder#key(EntityReference)}.
   *
   * <ul>
   *   <li>When {@link ImmutableEntityReference.Json} (default constructor).
   *   <li>Then builder build key is {@link ImmutableEntityReference.Json} (default constructor).
   * </ul>
   *
   * <p>Method under test: {@link Builder#key(EntityReference)}
   */
  @Test
  @DisplayName(
      "Test Builder key(EntityReference); when Json (default constructor); then builder build key is Json (default constructor)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.key(EntityReference)"})
  void testBuilderKey_whenJson_thenBuilderBuildKeyIsJson() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();

    // Act
    Builder actualKeyResult = builderResult.key(key);

    // Assert
    assertSame(key, builderResult.build().key());
    assertSame(builderResult, actualKeyResult);
  }

  /**
   * Test Builder {@link Builder#values(Iterable)}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return builder.
   * </ul>
   *
   * <p>Method under test: {@link Builder#values(Iterable)}
   */
  @Test
  @DisplayName("Test Builder values(Iterable); when ArrayList(); then return builder")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Builder Builder.values(Iterable)"})
  void testBuilderValues_whenArrayList_thenReturnBuilder() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act
    Builder actualValuesResult = builderResult.values(new ArrayList<>());

    // Assert
    assertSame(builderResult, actualValuesResult);
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#copyOf(EntityReferenceKeyedGroup)}.
   *
   * <ul>
   *   <li>Then key return {@link ImmutableEntityReference}.
   * </ul>
   *
   * <p>Method under test: {@link
   * ImmutableEntityReferenceKeyedGroup#copyOf(EntityReferenceKeyedGroup)}
   */
  @Test
  @DisplayName("Test copyOf(EntityReferenceKeyedGroup); then key return ImmutableEntityReference")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.copyOf(EntityReferenceKeyedGroup)"
  })
  void testCopyOf_thenKeyReturnImmutableEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup instance =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityReferenceKeyedGroup actualCopyOfResult =
        ImmutableEntityReferenceKeyedGroup.copyOf(instance);

    // Assert
    EntityReference keyResult = actualCopyOfResult.key();
    assertTrue(keyResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", keyResult.description());
    assertEquals(1L, keyResult.id());
    assertEquals(EntityKind.ALL, keyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, keyResult.entityLifecycleStatus());
    assertTrue(actualCopyOfResult.values().isEmpty());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}, and {@link
   * ImmutableEntityReferenceKeyedGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityReferenceKeyedGroup#equals(Object)}
   *   <li>{@link ImmutableEntityReferenceKeyedGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReferenceKeyedGroup.equals(Object)",
    "int ImmutableEntityReferenceKeyedGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup2 =
        builderResult2
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityReferenceKeyedGroup, immutableEntityReferenceKeyedGroup2);
    assertEquals(
        immutableEntityReferenceKeyedGroup.hashCode(),
        immutableEntityReferenceKeyedGroup2.hashCode());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}, and {@link
   * ImmutableEntityReferenceKeyedGroup#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityReferenceKeyedGroup#equals(Object)}
   *   <li>{@link ImmutableEntityReferenceKeyedGroup#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReferenceKeyedGroup.equals(Object)",
    "int ImmutableEntityReferenceKeyedGroup.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act and Assert
    assertEquals(immutableEntityReferenceKeyedGroup, immutableEntityReferenceKeyedGroup);
    int expectedHashCodeResult = immutableEntityReferenceKeyedGroup.hashCode();
    assertEquals(expectedHashCodeResult, immutableEntityReferenceKeyedGroup.hashCode());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReferenceKeyedGroup.equals(Object)",
    "int ImmutableEntityReferenceKeyedGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    builderResult.addValues(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityReferenceKeyedGroup,
        builderResult2
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReferenceKeyedGroup.equals(Object)",
    "int ImmutableEntityReferenceKeyedGroup.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.PENDING)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    Builder builderResult2 = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertNotEquals(
        immutableEntityReferenceKeyedGroup,
        builderResult2
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReferenceKeyedGroup.equals(Object)",
    "int ImmutableEntityReferenceKeyedGroup.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        null);
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ImmutableEntityReferenceKeyedGroup.equals(Object)",
    "int ImmutableEntityReferenceKeyedGroup.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act and Assert
    assertNotEquals(
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build(),
        "Different type to ImmutableEntityReferenceKeyedGroup");
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()} add {@link ImmutableEntityReference.Json} (default
   *       constructor).
   *   <li>When {@link Json} (default constructor) Key is {@link ImmutableEntityReference.Json}
   *       (default constructor).
   *   <li>Then return values size is one.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList() add Json (default constructor); when Json (default constructor) Key is Json (default constructor); then return values size is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.fromJson(Json)"
  })
  void testFromJson_givenArrayListAddJson_whenJsonKeyIsJson_thenReturnValuesSizeIsOne() {
    // Arrange
    ArrayList<EntityReference> values = new ArrayList<>();
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    values.add(json);

    Json json2 = new Json();
    json2.setKey(new ImmutableEntityReference.Json());
    json2.setValues(values);

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult =
        ImmutableEntityReferenceKeyedGroup.fromJson(json2);

    // Assert
    List<EntityReference> valuesResult = actualFromJsonResult.values();
    assertEquals(1, valuesResult.size());
    assertSame(json, valuesResult.get(0));
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link Json} (default constructor) Key is {@link ImmutableEntityReference.Json}
   *       (default constructor).
   *   <li>Then return values Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given ArrayList(); when Json (default constructor) Key is Json (default constructor); then return values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.fromJson(Json)"
  })
  void testFromJson_givenArrayList_whenJsonKeyIsJson_thenReturnValuesEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();
    json.setKey(key);
    json.setValues(new ArrayList<>());

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult =
        ImmutableEntityReferenceKeyedGroup.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.values().isEmpty());
    assertSame(key, actualFromJsonResult.key());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link Json} (default constructor) Values is {@code null}.
   *   <li>Then return values Empty.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}
   */
  @Test
  @DisplayName(
      "Test fromJson(Json); given 'null'; when Json (default constructor) Values is 'null'; then return values Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.fromJson(Json)"
  })
  void testFromJson_givenNull_whenJsonValuesIsNull_thenReturnValuesEmpty() {
    // Arrange
    Json json = new Json();
    ImmutableEntityReference.Json key = new ImmutableEntityReference.Json();
    json.setKey(key);
    json.setValues(null);

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult =
        ImmutableEntityReferenceKeyedGroup.fromJson(json);

    // Assert
    assertTrue(actualFromJsonResult.values().isEmpty());
    assertSame(key, actualFromJsonResult.key());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}.
   *
   * <ul>
   *   <li>Then return values size is two.
   * </ul>
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#fromJson(Json)}
   */
  @Test
  @DisplayName("Test fromJson(Json); then return values size is two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.fromJson(Json)"
  })
  void testFromJson_thenReturnValuesSizeIsTwo() {
    // Arrange
    ArrayList<EntityReference> values = new ArrayList<>();
    values.add(
        ImmutableEntityReference.builder()
            .description("The characteristics of someone or something")
            .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
            .externalId("42")
            .id(1L)
            .kind(EntityKind.ALL)
            .name("Name")
            .build());
    ImmutableEntityReference.Json json = new ImmutableEntityReference.Json();
    values.add(json);

    Json json2 = new Json();
    json2.setKey(new ImmutableEntityReference.Json());
    json2.setValues(values);

    // Act
    ImmutableEntityReferenceKeyedGroup actualFromJsonResult =
        ImmutableEntityReferenceKeyedGroup.fromJson(json2);

    // Assert
    List<EntityReference> valuesResult = actualFromJsonResult.values();
    assertEquals(2, valuesResult.size());
    EntityReference getResult = valuesResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", getResult.description());
    assertEquals(1L, getResult.id());
    assertEquals(EntityKind.ALL, getResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, getResult.entityLifecycleStatus());
    assertSame(json, valuesResult.get(1));
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImmutableEntityReferenceKeyedGroup#toString()}
   *   <li>{@link ImmutableEntityReferenceKeyedGroup#values()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "String ImmutableEntityReferenceKeyedGroup.toString()",
    "List ImmutableEntityReferenceKeyedGroup.values()"
  })
  void testGettersAndSetters() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    String actualToStringResult = immutableEntityReferenceKeyedGroup.toString();

    // Assert
    assertEquals(
        "EntityReferenceKeyedGroup{key=EntityReference{kind=ALL, id=1, entityLifecycleStatus=ACTIVE},"
            + " values=[]}",
        actualToStringResult);
    assertTrue(immutableEntityReferenceKeyedGroup.values().isEmpty());
  }

  /**
   * Test Json {@link Json#key()}.
   *
   * <p>Method under test: {@link Json#key()}
   */
  @Test
  @DisplayName("Test Json key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference Json.key()"})
  void testJsonKey() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().key());
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
    assertNull(actualJson.key);
    assertTrue(actualJson.values.isEmpty());
  }

  /**
   * Test Json {@link Json#values()}.
   *
   * <p>Method under test: {@link Json#values()}
   */
  @Test
  @DisplayName("Test Json values()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List Json.values()"})
  void testJsonValues() {
    // Arrange, Act and Assert
    assertThrows(UnsupportedOperationException.class, () -> new Json().values());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#key()}.
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#key()}
   */
  @Test
  @DisplayName("Test key()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityReference ImmutableEntityReferenceKeyedGroup.key()"})
  void testKey() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();

    // Act
    EntityReference actualKeyResult =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build()
            .key();

    // Assert
    assertTrue(actualKeyResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", actualKeyResult.description());
    assertEquals(1L, actualKeyResult.id());
    assertEquals(EntityKind.ALL, actualKeyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, actualKeyResult.entityLifecycleStatus());
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#withKey(EntityReference)}.
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#withKey(EntityReference)}
   */
  @Test
  @DisplayName("Test withKey(EntityReference)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.withKey(EntityReference)"
  })
  void testWithKey() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityReferenceKeyedGroup actualWithKeyResult =
        immutableEntityReferenceKeyedGroup.withKey(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    assertEquals(immutableEntityReferenceKeyedGroup, actualWithKeyResult);
  }

  /**
   * Test {@link ImmutableEntityReferenceKeyedGroup#withValues(EntityReference[])} with {@code
   * EntityReference[]}.
   *
   * <p>Method under test: {@link ImmutableEntityReferenceKeyedGroup#withValues(EntityReference[])}
   */
  @Test
  @DisplayName("Test withValues(EntityReference[]) with 'EntityReference[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ImmutableEntityReferenceKeyedGroup ImmutableEntityReferenceKeyedGroup.withValues(EntityReference[])"
  })
  void testWithValuesWithEntityReference() {
    // Arrange
    Builder builderResult = ImmutableEntityReferenceKeyedGroup.builder();
    ImmutableEntityReferenceKeyedGroup immutableEntityReferenceKeyedGroup =
        builderResult
            .key(
                ImmutableEntityReference.builder()
                    .description("The characteristics of someone or something")
                    .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                    .externalId("42")
                    .id(1L)
                    .kind(EntityKind.ALL)
                    .name("Name")
                    .build())
            .build();

    // Act
    ImmutableEntityReferenceKeyedGroup actualWithValuesResult =
        immutableEntityReferenceKeyedGroup.withValues(
            ImmutableEntityReference.builder()
                .description("The characteristics of someone or something")
                .entityLifecycleStatus(EntityLifecycleStatus.ACTIVE)
                .externalId("42")
                .id(1L)
                .kind(EntityKind.ALL)
                .name("Name")
                .build());

    // Assert
    List<EntityReference> valuesResult = actualWithValuesResult.values();
    assertEquals(1, valuesResult.size());
    EntityReference getResult = valuesResult.get(0);
    assertTrue(getResult instanceof ImmutableEntityReference);
    EntityReference keyResult = actualWithValuesResult.key();
    assertTrue(keyResult instanceof ImmutableEntityReference);
    assertEquals("The characteristics of someone or something", keyResult.description());
    assertEquals(1L, keyResult.id());
    assertEquals(EntityKind.ALL, keyResult.kind());
    assertEquals(EntityLifecycleStatus.ACTIVE, keyResult.entityLifecycleStatus());
    assertEquals(keyResult, getResult);
  }
}
